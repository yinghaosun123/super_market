package com.yjw.supermarket.app.stock.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yjw.supermarket.app.stock.bo.StockCondition;
import com.yjw.supermarket.app.stock.po.Stock;
import com.yjw.supermarket.app.stock.service.StockService;
import com.yjw.supermarket.app.stock.vo.StockVo;
import com.yjw.supermarket.framework.utils.ResultJson;

@RestController
@RequestMapping("/stock")
public class StockController {
	
	
	@Autowired
	private StockService stockService;
	
	
	/**
	 * 条件查询库存列表
	 * @param stockCondition
	 * @return
	 */
	@RequestMapping(value = "/list" , method = {RequestMethod.GET})
	public ResultJson findAllByCondition(@RequestBody StockCondition stockCondition) {
		ResultJson result = new ResultJson();
		result.setRet("200");
		result.setMsg("SUCCESS");
		return result;
	}
	
	/**
	 * 通过库存ID查看库存详情
	 * @param stockId
	 * @return
	 */
	@RequestMapping(value = "/detail/{id}" , method = {RequestMethod.GET})
	public ResultJson findById(@PathVariable("id") Integer stockId) {
		ResultJson result = new ResultJson();
		try {
			Stock stock = stockService.findById(stockId);
			StockVo vo = new StockVo();
			BeanUtils.copyProperties(stock, vo);
			result.setRet("200");
			result.setMsg("SUCCESS");
			result.setData(vo);
			return result;
		}catch (Exception e) {
			e.printStackTrace();
			result.setRet("201");
			result.setMsg("通过库存ID查看详情失败");
			return result;
		}
		
	}
	
	
}
