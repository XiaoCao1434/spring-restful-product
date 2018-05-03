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
import com.beini.product.entity.ProductBrand;
import com.beini.product.service.ProductBrandService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 商品品牌信息控制器
 * 
 * @author lb_chen
 */
@Api(value = "商品品牌信息")
@RestController
@SuppressWarnings("rawtypes")
@RequestMapping("/product/brand/")
public class ProductBrandController {
	@Autowired
	private ProductBrandService productBrandService;

	@ApiOperation(value = "根据品牌ID获取品牌信息")
	@GetMapping("{id}")
	public ResultVO findById(@PathVariable("id") String id) {
		ProductBrand productBrand = productBrandService.findById(id);
		return ResultVOUtil.success(productBrand);
	}

	@ApiOperation(value = "根据品牌分页信息获取品牌分页")
	@GetMapping("")
	public ResultVO findByPage(@RequestParam(name = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
		PageRequest request = new PageRequest(pageNo - 1, pageSize);
		Page<ProductBrand> page = productBrandService.findAll(request);
		return ResultVOUtil.success(page);
	}

	@ApiOperation(value = "根据商品类别ID和分页信息获取商品类别下的品牌分页")
	@GetMapping("category/{pcUuid}")
	public ResultVO findAllByPcUuid(@PathVariable("pcUuid") String pcUuid,
			@RequestParam(name = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
		PageRequest request = new PageRequest(pageNo - 1, pageSize);
		Page<ProductBrand> page = productBrandService.findAllByPcUuid(pcUuid, request);
		return ResultVOUtil.success(page);
	}

	@ApiOperation(value = "根据品牌信息更新")
	@PutMapping
	public ResultVO update(ProductBrand productBrand) {
		if (productBrand == null || productBrand.getPbUuid() == null || "".equals(productBrand.getPbUuid())) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_BRAND_NOT_EXIST);
		}
		if (productBrandService.update(productBrand) == null) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_BRAND_UPDATE_FAIL);
		} else {
			return ResultVOUtil.success();
		}
	}

	@ApiOperation(value = "新增品牌信息")
	@PostMapping
	public ResultVO save(ProductBrand productBrand) {
		if (productBrandService.save(productBrand) == null) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_BRAND_INSERT_FAIL);
		} else {
			return ResultVOUtil.success();
		}
	}

	@ApiOperation(value = "根据品牌ID删除品牌信息")
	@DeleteMapping("{id}")
	public ResultVO deleteById(@PathVariable("id") String id) {
		try {
			productBrandService.delete(id);
			return ResultVOUtil.success();
		} catch (Exception e) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_BRAND_DELETE_FAIL);
		}
	}
}
