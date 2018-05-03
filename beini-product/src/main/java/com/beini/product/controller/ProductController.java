package com.beini.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beini.core.enums.ResultEnum;
import com.beini.core.utils.ResultVOUtil;
import com.beini.core.vo.ResultVO;
import com.beini.product.entity.Product;
import com.beini.product.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 商品信息控制器
 * 
 * @author lb_chen
 * @data 2018-04-18 16:15
 */
@Api(value = "商品信息")
@RestController
@RequestMapping("/product/product/")
@SuppressWarnings("rawtypes")
public class ProductController {
	@Autowired
	private ProductService productService;

	/**
	 * 根据商品ID获取商品信息
	 * 
	 * @param id
	 *            商品ID
	 * @return 商品信息
	 */
	@ApiOperation(value = "根据商品ID获取商品信息")
	@GetMapping("{id}")
	public ResultVO findById(@PathVariable(value = "id") String id) {
		Product product = productService.findById(id);
		return ResultVOUtil.success(product);
	}

	/**
	 * 根据分页信息获取商品分页信息
	 * 
	 * @param pageNo
	 *            第几页
	 * @param pageSize
	 *            每页条数
	 * @return 商品分页信息
	 */
	@ApiOperation(value = "根据分页信息获取商品分页信息")
	@GetMapping("")
	public ResultVO findByPage(@RequestParam(name = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
		PageRequest request = new PageRequest(pageNo - 1, pageSize);
		Page<Product> page = productService.findAll(request);
		return ResultVOUtil.success(page);
	}

	@ApiOperation(value = "根据商品信息进行数据更新(以主键为依据)")
	@PutMapping
	public ResultVO update(Product product) {
		if (product == null || product.getProUuid() == null || "".equals(product.getProUuid())) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_NOT_EXIST);
		}
		if (productService.update(product) == null) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_UPDATE_FAIL);
		} else {
			return ResultVOUtil.success();
		}
	}
	
	@ApiOperation(value = "根据商品信息进行更新库存")
	@PutMapping("updateStock")
	public ResultVO updateStock(@RequestParam("proUuid")String proUuid, @RequestParam("number")double number) {
		if (proUuid == null || "".equals(proUuid)) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_NOT_EXIST);
		}
		Product product = new Product();
		product.setProUuid(proUuid);
		product.setStock(number);
		if (productService.updateStock(product) <1) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_STOCK_ERROR);
		} else {
			return ResultVOUtil.success();
		}
	}

	@ApiOperation(value = "增加商品信息")
	@PostMapping
	public ResultVO save(Product product) {
		if (productService.save(product) == null) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_INSERT_FAIL);
		} else {
			return ResultVOUtil.success();
		}
	}

	@ApiOperation(value = "根据商品ID删除商品信息")
	@DeleteMapping("{id}")
	public ResultVO deleteById(@PathVariable(value = "id") String id) {
		try {
			productService.delete(id);
			return ResultVOUtil.success();
		} catch (Exception e) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_DELETE_FAIL);
		}
	}
}
