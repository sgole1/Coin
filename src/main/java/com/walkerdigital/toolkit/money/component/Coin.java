package com.walkerdigital.toolkit.money.component;

import java.util.Comparator;


/**
 * The Entity class defining the Coin attributes like currencyCOde, nummericCode, description etc.
 *
 */
/**
 * @author Niren
 *
 */
public class Coin {

	@Override
	public String toString() {
		return "Coin [javaCurrency=" + javaCurrency + ", numericCode="
				+ numericCode + ", currencySymbolOverride="
				+ currencySymbolOverride + ", description=" + description
				+ ", hashCode=" + hashCode + ", scale=" + scale + "]";
	}

	private static final long serialVersionUID = 8228779577409316939L;

	private final java.util.Currency javaCurrency;

	private final String numericCode;
	private final String currencySymbolOverride; // use to override the currency
													// code in java.util.Coin
	private final String description;
	private final int hashCode;

	private final int scale; // the number of sub-units of the currency (e.g. US
								// dollars have 100 sub-units, or pennies)

	/** default constructor was added to work with jaxb generation / conversion */
	private Coin() {
		javaCurrency = null;
		numericCode = null;
		currencySymbolOverride = null;
		description = null;
		hashCode = 0;
		scale = 0;
	}

	public static Comparator<Coin> getNumericCodeComparator() {
		return NumericCodeComparator;
	}

	public static void setNumericCodeComparator(
			Comparator<Coin> numericCodeComparator) {
		NumericCodeComparator = numericCodeComparator;
	}

	public java.util.Currency getJavaCurrency() {
		return javaCurrency;
	}

	public String getNumericCode() {
		return numericCode;
	}

	public String getCurrencySymbolOverride() {
		return currencySymbolOverride;
	}

	public String getDescription() {
		return description;
	}

	public int getScale() {
		return scale;
	}

	/**
	 * Constructor to use the currency code from java.util.Coin
	 * 
	 * @param pCurrency
	 * @param pNumericCode
	 * @param pScale
	 * @param pDescription
	 */
	private Coin(java.util.Currency pCurrency, String pNumericCode, int pScale,
			String pDescription) {
		this(pCurrency, pNumericCode, pScale, pDescription, null);
	}

	/**
	 * Constructor to override the currency code in java.util.Coin
	 * 
	 * @param pCurrency
	 * @param pNumericCode
	 * @param pScale
	 * @param pDescription
	 * @param pCurrencySymbolOverride
	 */
	protected Coin(java.util.Currency pCurrency, String pNumericCode,
			int pScale, String pDescription, String pCurrencySymbolOverride) {
		javaCurrency = pCurrency;
		numericCode = pNumericCode;
		description = pDescription;
		hashCode = Integer.parseInt(numericCode);
		scale = pScale;
		currencySymbolOverride = pCurrencySymbolOverride;
	}

	 /* The Comparator class instance to sort the coins collection on the basis of Numeric code  
	 */
	
	public static Comparator<Coin> NumericCodeComparator = new Comparator<Coin>() {

		public int compare(Coin c1, Coin c2) {
			String c1NumericCode = c1.getNumericCode();
			String c2NumericCode = c2.getNumericCode();

			// ascending order
			return c1NumericCode.compareTo(c2NumericCode);

			// descending order
			// return c2NumericCode.compareTo(c1NumericCode);
		}
	};

	/* The Comparator class instance to sort the coins collection on the basis of coin description  
	 */
	public static Comparator<Coin> coinDescriptionComparator = new Comparator<Coin>() {

		public int compare(Coin c1, Coin c2) {
			String c1Description = c1.getDescription();
			String c2Description = c2.getDescription();

			// ascending order
			return c1Description.compareTo(c2Description);

			// descending order
			// return c2Description.compareTo(c1Description);
		}
	};
	
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}

		final Coin currency = (Coin) o;
		return numericCode.equals(currency.numericCode);
	}

	public int hashCode()
	{
		return (int)System.currentTimeMillis();

	}

}
