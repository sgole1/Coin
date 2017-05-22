package com.walkerdigital.toolkit.money.component;


import com.walkerdigital.toolkit.money.constant.CurrencyCode;
import com.walkerdigital.toolkit.money.constant.CurrencySymbol;

/**
 * Factory class responsible to create and provide different instances of Coin on the basis of CurrencyCode 
 * & CurrencySymbol. Create Coin instance at run time.
 */
public class CoinFactory {
	
	private final static Coin US_DOLLAR = createInstance(
			java.util.Currency.getInstance(CurrencyCode.CURRENCY_CODE_USD
					.getCurrency()), "840", 100, "US dollar", null);
	private final static Coin HK_DOLLAR = createInstance(
			java.util.Currency.getInstance(CurrencyCode.CURRENCY_CODE_HKD
					.getCurrency()), "344", 100, "Hong Kong dollar", null);
	private final static Coin MALAYSIAN_RINGGIT = createInstance(
			java.util.Currency.getInstance(CurrencyCode.CURRENCY_CODE_MYR
					.getCurrency()), "458", 100, "Malaysian ringgit",
			CurrencySymbol.CURRENCY_SYMBOL_RM.getCurrencySymbol());


	/**
	 * @param cc : The CurrencyCode for which Coin instance needs tobe created
	 * @return returns the Coin instance
	 */
	public static Coin getCoinByCurrencyCode(CurrencyCode cc) {
		Coin coinInstance = null;
		switch (cc) {
		case CURRENCY_CODE_USD:
			coinInstance = US_DOLLAR;
			break;
		case CURRENCY_CODE_HKD:
			coinInstance = HK_DOLLAR;
			break;
		case CURRENCY_CODE_MYR:
			coinInstance = MALAYSIAN_RINGGIT;
			break;
		default:
			System.out.println("CurrencyCode not supported");
			
		}
		return coinInstance;

	}
	/**
	 * @param cs : The CurrencySymbol for which Coin instance needs to be created
	 * @return returns the Coin instance
	 */
	public static Coin getCoinByCurrencySymbol(CurrencySymbol cs) {
		Coin coinInstance = null;
		switch (cs) {
		case CURRENCY_SYMBOL_USD:
			coinInstance = US_DOLLAR;
			break;
		case CURRENCY_SYMBOL_HKD:
			coinInstance = HK_DOLLAR;
			break;
		case CURRENCY_SYMBOL_RM:
			coinInstance = MALAYSIAN_RINGGIT;
			break;
		default:
			System.out.println("CurrencySymbol not supported");
			
		}
		return coinInstance;

	}
	
	/**
	 * @param pCurrency : The coin attribute
	 * @param pNumericCode : The coin attribute
	 * @param pScale : The coin attribute
	 * @param pDescription : The coin attribute
	 * @param pCurrencySymbolOverride : The coin attribute
	 * @return returns the Coin instance
	 */
	public static Coin createInstance(java.util.Currency pCurrency, String pNumericCode, int pScale,
			String pDescription, String pCurrencySymbolOverride){
		
		return new Coin(pCurrency, pNumericCode, pScale, pDescription, pCurrencySymbolOverride);
		
	}

}
