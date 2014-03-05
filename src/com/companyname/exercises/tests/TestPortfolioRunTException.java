package com.companyname.exercises.tests;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.companyname.exercises.IStockMarket;
import com.companyname.exercises.Portfolio;
import com.companyname.exercises.Stock;

public class TestPortfolioRunTException {

	private Portfolio portfolio;
	private IStockMarket marketMock;
	
	@Before
	public void setUp() throws Exception {
		portfolio = new Portfolio();
		marketMock = EasyMock.createMock(IStockMarket.class);
	}


	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void test() throws NullPointerException {
		  thrown.expect(NullPointerException.class);
		Stock stock = new Stock();
		stock.setName("carso");
		stock.setQuantity(5);
		
		portfolio.addStock(stock);
				
		marketMock.price("carso");
		EasyMock.expectLastCall().andReturn(10.0);
		EasyMock.replay(marketMock);
		// intentionally I do not set the marketMock to portfolio, so a NullPointerException is expected
		// portfolio.setStockMarket(marketMock);
		portfolio.value();
	}
}
