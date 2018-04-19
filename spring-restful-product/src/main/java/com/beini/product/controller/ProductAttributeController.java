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
import com.beini.product.entity.ProductAttribute;
import com.beini.product.service.ProductAttributeService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/productAttribute/attribute/")
@SuppressWarnings("rawtypes")
public class ProductAttributeController {
	@Autowired
	private ProductAttributeService productAttributeService;
	@ApiOperation(value="根据ID获取商品属性信息")
	@GetMapping("{id}")
	public ResultVO findById(@PathVariable(value = "id") String id) {
		ProductAttribute productAttribute = productAttributeService.findById(id);
		return ResultVOUtil.success(productAttribute);
	}
	@ApiOperation(value="根据分页信息获取商品属性分页信息")
	@GetMapping("")
	public ResultVO findByPage(@RequestParam(name = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
		PageRequest request = new PageRequest(pageNo - 1, pageSize);
		Page<ProductAttribute> page = productAttributeService.findAll(request);
		return ResultVOUtil.success(page);
	}
	@ApiOperation(value="根据商品属性信息进行数据更新(以主键为依据)")
	@PutMapping
	public ResultVO update(ProductAttribute productAttribute) {
		if (productAttribute == null || productAttribute.getPaUuid() == null || "".equals(productAttribute.getPaUuid())) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_ATTRIBUTE_NOT_EXIST);
		}
		if (productAttributeService.update(productAttribute) == null) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_ATTRIBUTE_UPDATE_FAIL);
		} else {
			return ResultVOUtil.success();
		}
	}
	@ApiOperation(value="增加商品属性信息")
	@PostMapping
	public ResultVO save(ProductAttribute productAttribute) {
		if (productAttributeService.save(productAttribute) == null) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_ATTRIBUTE_INSERT_FAIL);
		} else {
			return ResultVOUtil.success();
		}
	}
	@ApiOperation(value="根据商品属性ID删除")
	@DeleteMapping("{id}")
	public ResultVO deleteById(@PathVariable(value="id") String id) {
		try {
			productAttributeService.delete(id);
			return ResultVOUtil.success();
		} catch (Exception e) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_ATTRIBUTE_DELETE_FAIL);
		}
	}
}
