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
import com.beini.product.entity.ProductImage;
import com.beini.product.service.ProductImageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 商品图片信息控制器
 * 
 * @author lb_chen
 */
@Api(value = "商品图片信息")
@RestController
@SuppressWarnings("rawtypes")
@RequestMapping("/product/image/")
public class ProductImageController {
	@Autowired
	private ProductImageService productImageService;

	@ApiOperation(value = "根据ID获取单个商品图片对象信息")
	@GetMapping("{id}")
	public ResultVO findById(@PathVariable("id") Integer id) {
		ProductImage productImage = productImageService.findById(id);
		return ResultVOUtil.success(productImage);
	}

	@ApiOperation(value = "根据分页信息获取商品图片信息的分页")
	@GetMapping("")
	public ResultVO findByPage(@RequestParam(name = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
		PageRequest request = new PageRequest(pageNo - 1, pageSize);
		Page<ProductImage> page = productImageService.findAll(request);
		return ResultVOUtil.success(page);
	}

	@ApiOperation(value = "根据商品图片信息进行更新")
	@PutMapping
	public ResultVO update(ProductImage productImage) {
		if (productImage == null) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_IMAGE_NOT_EXIST);
		}
		if (productImageService.update(productImage) == null) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_IMAGE_UPDATE_FAIL);
		} else {
			return ResultVOUtil.success();
		}
	}

	@ApiOperation(value = "新增商品图片信息")
	@PostMapping
	public ResultVO save(ProductImage productImage) {
		if (productImageService.save(productImage) == null) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_IMAGE_INSERT_FAIL);
		} else {
			return ResultVOUtil.success();
		}
	}

	@ApiOperation(value = "根据商品图片ID进行删除")
	@DeleteMapping("{id}")
	public ResultVO deleteById(@PathVariable("id") Integer id) {
		try {
			productImageService.delete(id);
			return ResultVOUtil.success();
		} catch (Exception e) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_IMAGE_DELETE_FAIL);
		}
	}
}
