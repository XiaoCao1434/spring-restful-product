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
import com.beini.product.entity.ProductDescription;
import com.beini.product.service.ProductDescriptionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 商品描述信息控制器
 * 
 * @author lb_chen
 */
@Api(value = "商品描述信息")
@RestController
@SuppressWarnings("rawtypes")
@RequestMapping("/product/description/")
public class ProductDescriptionController {
	@Autowired
	private ProductDescriptionService productDescriptionService;

	@ApiOperation(value = "根据ID获取单个商品描述对象信息")
	@GetMapping("{id}")
	public ResultVO findById(@PathVariable("id") Integer id) {
		ProductDescription productDescription = productDescriptionService.findById(id);
		return ResultVOUtil.success(productDescription);
	}

	@ApiOperation(value = "根据分页信息获取商品描述信息的分页")
	@GetMapping("")
	public ResultVO findByPage(@RequestParam(name = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
		PageRequest request = new PageRequest(pageNo - 1, pageSize);
		Page<ProductDescription> page = productDescriptionService.findAll(request);
		return ResultVOUtil.success(page);
	}

	@ApiOperation(value = "根据商品描述信息进行更新")
	@PutMapping
	public ResultVO update(ProductDescription productDescription) {
		if (productDescription == null) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_DESCRIPPTION_NOT_EXIST);
		}
		if (productDescriptionService.update(productDescription) == null) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_DESCRIPPTION_UPDATE_FAIL);
		} else {
			return ResultVOUtil.success();
		}
	}

	@ApiOperation(value = "新增商品描述信息")
	@PostMapping
	public ResultVO save(ProductDescription productDescription) {
		if (productDescriptionService.save(productDescription) == null) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_DESCRIPPTION_INSERT_FAIL);
		} else {
			return ResultVOUtil.success();
		}
	}

	@ApiOperation(value = "根据商品描述ID进行删除")
	@DeleteMapping("{id}")
	public ResultVO deleteById(@PathVariable("id") Integer id) {
		try {
			productDescriptionService.delete(id);
			return ResultVOUtil.success();
		} catch (Exception e) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_DESCRIPPTION_DELETE_FAIL);
		}
	}
}
