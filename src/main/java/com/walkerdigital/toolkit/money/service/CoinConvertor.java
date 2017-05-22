package com.walkerdigital.toolkit.money.service;
/*
*The interface used for currency conversion.
 */

public interface CoinConvertor {
	/**
	 * @param currencyQuantity : The dollar unit needs to be converted into another Currency 
	 * @param conversion : string indication the conversion (eg : Currency rate conversion from MYR to USD is MYR_TO_USD )
	 * @return returns the converted value
	 * The method read the desired property from the config file and perform the calculations.
	 */
	Long convertTo(int currencyQuantity, String conversion);

}
