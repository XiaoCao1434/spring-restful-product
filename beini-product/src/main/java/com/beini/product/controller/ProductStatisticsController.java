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
import com.beini.product.entity.ProductStatistics;
import com.beini.product.service.ProductStatisticsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 商品统计信息控制器
 * 
 * @author lb_chen
 *
 */
@Api(value = "商品统计信息")
@RestController
@SuppressWarnings("rawtypes")
@RequestMapping("/product/statistics/")
public class ProductStatisticsController {
	@Autowired
	private ProductStatisticsService productStatisticsService;

	@ApiOperation(value = "根据ID获取单个商品统计对象信息")
	@GetMapping("{id}")
	public ResultVO findById(@PathVariable("id") Integer id) {
		ProductStatistics productStatistics = productStatisticsService.findById(id);
		return ResultVOUtil.success(productStatistics);
	}

	@ApiOperation(value = "根据分页信息获取商品统计信息的分页")
	@GetMapping("")
	public ResultVO findByPage(@RequestParam(name = "pageNo", required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
		PageRequest request = new PageRequest(pageNo - 1, pageSize);
		Page<ProductStatistics> page = productStatisticsService.findAll(request);
		return ResultVOUtil.success(page);
	}

	@ApiOperation(value = "根据商品统计信息进行更新")
	@PutMapping
	public ResultVO update(ProductStatistics productStatistics) {
		if (productStatistics == null) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_STATISTICS_NOT_EXIST);
		}
		if (productStatisticsService.update(productStatistics) == null) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_STATISTICS_UPDATE_FAIL);
		} else {
			return ResultVOUtil.success();
		}
	}

	@ApiOperation(value = "新增商品统计信息")
	@PostMapping
	public ResultVO save(ProductStatistics productStatistics) {
		if (productStatisticsService.save(productStatistics) == null) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_STATISTICS_INSERT_FAIL);
		} else {
			return ResultVOUtil.success();
		}
	}

	@ApiOperation(value = "根据商品统计ID进行删除")
	@DeleteMapping("{id}")
	public ResultVO deleteById(@PathVariable("id") Integer id) {
		try {
			productStatisticsService.delete(id);
			return ResultVOUtil.success();
		} catch (Exception e) {
			return ResultVOUtil.error(ResultEnum.PRODUCT_STATISTICS_DELETE_FAIL);
		}
	}
}
