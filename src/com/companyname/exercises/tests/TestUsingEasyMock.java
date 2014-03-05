package com.companyname.exercises.tests;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.companyname.exercises.IStockMarket;
import com.companyname.exercises.Portfolio;
import com.companyname.exercises.Stock;

public class TestUsingEasyMock extends TestCase {

	private Portfolio portfolio;
	private IStockMarket marketMock;
	private Stock stock; 
	
	@Before
	public void setUp() throws Exception {
		portfolio = new Portfolio();
		marketMock = EasyMock.createNiceMock(IStockMarket.class);
	}

	@Test
	public void testPorfolioValue() {
		
		stock = new Stock();
		stock.setName("vitro");
		stock.setQuantity(2);
		portfolio.addStock(stock);
		
		EasyMock.expect(marketMock.price("vitro")).andReturn(40.0);
		EasyMock.replay(marketMock);
		
		portfolio.setStockMarket(marketMock);
		
		assertEquals(80.0, portfolio.value());
		
		EasyMock.verify(marketMock);
	}

}
