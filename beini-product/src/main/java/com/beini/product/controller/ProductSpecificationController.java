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
import com.beini.product.entity.ProductSpecification;
import com.beini.product.service.ProductSpecificationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 商品规格信息控制器
 * @author lb_chen
 */
@Api(value = "商品规格信息")
@RestController
@RequestMapping("/product/specification/")
@SuppressWarnings("rawtypes")
public class ProductSpecificationController {
	@Autowired
	private ProductSpecificationService productSpecificationService;
	/**
	 * 根据商品ID获取商品规格信息
	 * @param id 商品ID
	 * @return 商品规格信息
	 */
	@ApiOperation(value="根据商品ID获取商品规格信息")
	@GetMapping("{id}")
	public ResultVO findById(@PathVariable(value = "id") String id) {
		ProductSpecification productSpecification = productSpecificationService.findById(id);
		return ResultVOUtil.success(productSpecification);
	}
	/**
	 * 根据分页信息获取商品分页信息
	 * @param pageNo 第几页
	 * @param pageSize 每页条数
	 * @return 商品规格分页信息
	 */
	@ApiOperation(value="根据分页信息获取商品规格分页信息")
	@GetMapping("")
	public ResultVO findByPage(@RequestParam(name = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
		PageRequest request = new PageRequest(pageNo - 1, pageSize);
		Page<ProductSpecification> page = productSpecificationService.findAll(request);
		return ResultVOUtil.success(page);
	}
	@ApiOperation(value="根据商品规格信息进行数据更新(以主键为依据)")
	@PutMapping
	public ResultVO update(ProductSpecification productSpecification) {
		if (productSpecification == null || productSpecification.getProSpeUuid() == null || "".equals(productSpecification.getProSpeUuid())) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_SPECIFICATION_NOT_EXIST);
		}
		if (productSpecificationService.update(productSpecification) == null) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_SPECIFICATION_UPDATE_FAIL);
		} else {
			return ResultVOUtil.success();
		}
	}
	@ApiOperation(value="增加商品规格信息")
	@PostMapping
	public ResultVO save(ProductSpecification productSpecification) {
		if (productSpecificationService.save(productSpecification) == null) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_SPECIFICATION_INSERT_FAIL);
		} else {
			return ResultVOUtil.success();
		}
	}
	@ApiOperation(value="根据商品ID删除商品规格信息")
	@DeleteMapping("{id}")
	public ResultVO deleteById(@PathVariable(value="id") String id) {
		try {
			productSpecificationService.delete(id);
			return ResultVOUtil.success();
		} catch (Exception e) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_SPECIFICATION_DELETE_FAIL);
		}
	}
}