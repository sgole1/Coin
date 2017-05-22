package com.walkerdigital.toolkit.money.component;

import static org.junit.Assert.*;

import org.junit.Test;

import com.walkerdigital.toolkit.money.constant.CurrencyCode;
import com.walkerdigital.toolkit.money.constant.CurrencySymbol;

public class CoinFactoryTest {
	


	@Test
	public void testGetCoinByCurrencyCode() {
		Coin currencyMYR = CoinFactory.getCoinByCurrencyCode(CurrencyCode.CURRENCY_CODE_USD);
		assertEquals(currencyMYR.getNumericCode(), "840");
	}

	@Test
	public void testGetCoinByCurrencySymbol() {
		Coin currencyMYR = CoinFactory.getCoinByCurrencySymbol(CurrencySymbol.CURRENCY_SYMBOL_USD);
		assertEquals(currencyMYR.getNumericCode(), "840");
	
	}

	@Test
	public void testCreateInstance() {
		Coin currencyMYR = CoinFactory.createInstance(
				java.util.Currency.getInstance(CurrencyCode.CURRENCY_CODE_MYR
						.getCurrency()), "458", 100, "Malaysian ringgit",
				CurrencySymbol.CURRENCY_SYMBOL_RM.getCurrencySymbol());
		assertEquals(currencyMYR.getNumericCode(), "458");
	}

}
