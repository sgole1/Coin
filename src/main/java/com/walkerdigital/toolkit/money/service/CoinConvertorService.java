package com.walkerdigital.toolkit.money.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.walkerdigital.toolkit.money.util.PropertyUtil;
/*
*The class is used for currency conversion.
 */
public class CoinConvertorService implements CoinConvertor {
	//A map defines mapping between the CurrencyCode and corresponding mapping in the property file
	private static Map<String, String> currencyCodeAndConvertorMap;
	static {
		currencyCodeAndConvertorMap = new HashMap<String, String>();
		currencyCodeAndConvertorMap.put("USD_TO_HKD",
				"conversionRate.USD_TO_MYR");
		currencyCodeAndConvertorMap.put("USD_TO_MYR",
				"conversionRate.USD_TO_MYR");
		currencyCodeAndConvertorMap.put("HKD_TO_USD",
				"conversionRate.HKD_TO_USD");
		currencyCodeAndConvertorMap.put("HKD_TO_MYR",
				"conversionRate.HKD_TO_MYR");
		currencyCodeAndConvertorMap.put("MYR_TO_USD",
				"conversionRate.MYR_TO_USD");
		currencyCodeAndConvertorMap.put("MYR_TO_HKD",
				"conversionRate.MYR_TO_HKD");
	}
    //instance creation and initialization of property file
	public CoinConvertorService(String propertyFile) {
		super();
		PropertyUtil propertyUtil = new PropertyUtil();
		propertyFileReference = propertyUtil.getProperties(propertyFile);
	}

	Properties propertyFileReference = null;
	
	@Override
	public Long convertTo(int currencyQuantity, String conversion) {
		Long conversionRate = 0L;
		if (propertyFileReference != null) {
			conversionRate = Long.valueOf(propertyFileReference
					.getProperty(currencyCodeAndConvertorMap.get(conversion)));
		}
		return currencyQuantity * conversionRate;
	}

}
