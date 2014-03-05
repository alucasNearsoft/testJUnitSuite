package com.companyname.exercises;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {

	private IStockMarket stockMarket;
	private List<Stock> stocks = new ArrayList<>();
	
	public IStockMarket getStockMarket() {
		return stockMarket;
	}
	public void setStockMarket(IStockMarket stockMarket) {
		this.stockMarket = stockMarket;
	}
	
	public void addStock(Stock stock) {
		stocks.add(stock);
	}
	
	public Double value() {
		Double value = 0.0;
		for (Stock stock : stocks) {
			value += stockMarket.price(stock.getName()) * stock.getQuantity();
		}
		return value;
	}
}
