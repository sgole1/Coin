package com.walkerdigital.toolkit.money.constant;
/*
 * Enum class to define currency symbols supported by the application
 */
public enum CurrencySymbol {
	
			// supported currency symbols
		CURRENCY_SYMBOL_USD("$"),
		CURRENCY_SYMBOL_HKD("HK$"),
		CURRENCY_SYMBOL_RM("RM"),
		UNKNOWN("");
		private String currencySymbol;
		
		public String getCurrencySymbol() {
			return currencySymbol;
		}

		private CurrencySymbol(String currencySymbol) {
			this.currencySymbol = currencySymbol;	
		}
}
