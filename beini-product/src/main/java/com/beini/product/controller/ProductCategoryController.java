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
import com.beini.product.entity.ProductCategory;
import com.beini.product.service.ProductCategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 商品类别信息控制器
 * @author lb_chen
 */
@Api(value="商品类别信息")
@RestController
@RequestMapping("/product/category/")
@SuppressWarnings("rawtypes")
public class ProductCategoryController {
	@Autowired
	private ProductCategoryService productCategoryService;
	@ApiOperation(value="根据ID获取商品类别信息")
	@GetMapping("{id}")
	public ResultVO findById(@PathVariable(value = "id") String id) {
		ProductCategory productAttribute = productCategoryService.findById(id);
		return ResultVOUtil.success(productAttribute);
	}
	@ApiOperation(value="根据分页信息获取商品类别分页信息")
	@GetMapping("")
	public ResultVO findByPage(@RequestParam(name = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
		PageRequest request = new PageRequest(pageNo - 1, pageSize);
		Page<ProductCategory> page = productCategoryService.findAll(request);
		return ResultVOUtil.success(page);
	}
	@ApiOperation(value="根据商品类别信息进行数据更新(以主键为依据)")
	@PutMapping
	public ResultVO update(ProductCategory productCategory) {
		if (productCategory == null || productCategory.getPcUuid() == null || "".equals(productCategory.getPcUuid())) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_CATEGORY_NOT_EXIST);
		}
		if (productCategoryService.update(productCategory) == null) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_CATEGORY_UPDATE_FAIL);
		} else {
			return ResultVOUtil.success();
		}
	}
	@ApiOperation(value="增加商品类别信息")
	@PostMapping
	public ResultVO save(ProductCategory productCategory) {
		if (productCategoryService.save(productCategory) == null) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_CATEGORY_INSERT_FAIL);
		} else {
			return ResultVOUtil.success();
		}
	}
	@ApiOperation(value="根据商品类别ID删除")
	@DeleteMapping("{id}")
	public ResultVO deleteById(@PathVariable(value="id") String id) {
		try {
			productCategoryService.delete(id);
			return ResultVOUtil.success();
		} catch (Exception e) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_CATEGORY_DELETE_FAIL);
		}
	}
}
