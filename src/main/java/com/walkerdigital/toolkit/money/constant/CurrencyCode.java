package com.walkerdigital.toolkit.money.constant;

public enum CurrencyCode {
		// supported currency codes
		CURRENCY_CODE_USD("USD"),
		CURRENCY_CODE_HKD("HKD"),
		CURRENCY_CODE_MYR("MYR"),
		UNKNOWN("");
		private String currency;
		
		public String getCurrency() {
			return currency;
		}

		private CurrencyCode(String currency) {
			this.currency = currency;	
		}
}
