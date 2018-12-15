package com.yjw.supermarket.app.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yjw.supermarket.app.stock.dao.StockMapper;
import com.yjw.supermarket.app.stock.po.Stock;

@Service
@Transactional
public class StockService {
	
	
	@Autowired
	private StockMapper stockMapper;
	
	/**
	 * 查找库存通过库存ID
	 * @param stockId
	 * @return
	 */
	public Stock findById(Integer stockId) {
		return stockMapper.selectByPrimaryKey(stockId);
	}

}
