package com.walkerdigital.toolkit.money;

import static org.junit.Assert.*;

import org.junit.Test;

import com.walkerdigital.toolkit.money.service.CoinConvertor;
import com.walkerdigital.toolkit.money.service.CoinConvertorService;

public class CoinConvertorServiceTest {

	private CoinConvertor coinConvertor = new CoinConvertorService(
			"test.properties");

	@Test
	public void testCurrencyConversionFromUSD_TO_HKD() {
		Long convertedValue = coinConvertor.convertTo(30, "USD_TO_HKD");
		System.out.println("convertedValue :" + convertedValue);
		Long expectedValue = new Long(60L);
		assertEquals(expectedValue, convertedValue);

	}

}
