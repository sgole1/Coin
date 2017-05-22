import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.List;

import com.walkerdigital.toolkit.money.component.Coin;
import com.walkerdigital.toolkit.money.component.CoinFactory;
import com.walkerdigital.toolkit.money.constant.CurrencyCode;


/******************************
 * INSTRUCTIONS
 *
 * Steps:
 * 1. Add Unit tests for 	all public methods.
 * 2. All methods must have Javadoc comments.
 * 3. Fix all the bugs. Run the main method and you will see HKD and MYR are the same. This is not correct.
 * 4. New functionality: create and implement a public interface for adding new coins at runtime using some design pattern.
 * 5. New functionality: Implement a method to Sort coins first by Numeric Code and then coin Name.
 * 6. New functionality: Use a property file to mention conversion rate and expose an Interface to convert one coin value to another.
 * 7. Refactor the Coin class and explain why your refractors are improvements.
 * 8. Use Maven.
 * 
 * When the updates have been completed, zip up the project and email it back.
 * Use of 3rd-party software (e.g. frameworks like Maven) is encouraged where applicable, however please point out all instances where the code you used was not your own.
 * Provide information on how long you worked on it and explain your changes.
 ******************************/
public class Main {

    public static void main(String[] args) {
        Coin currencyUSD = CoinFactory.getCoinByCurrencyCode(CurrencyCode.CURRENCY_CODE_USD);
        Coin currencyHKD = CoinFactory.getCoinByCurrencyCode(CurrencyCode.CURRENCY_CODE_HKD);
        Coin currencyMYR = CoinFactory.getCoinByCurrencyCode(CurrencyCode.CURRENCY_CODE_MYR);
        
          
        boolean currenciesAreSame = currencyUSD.equals(currencyHKD);
        if (currenciesAreSame) {
            System.out.println("USD and HKD currencies are the same.");
        }
        else {
            System.out.println("USD and HKD currencies are different.");
        }

        currenciesAreSame = currencyUSD.equals(currencyMYR);
        if (currenciesAreSame) {
            System.out.println("USD and MYR currencies are the same.");
        }
        else {
            System.out.println("USD and MYR currencies are different.");
        }

        currenciesAreSame = currencyHKD.equals(currencyMYR);
        if (currenciesAreSame) {
            System.out.println("HKD and MYR currencies are the same.");
        }
        else {
            System.out.println("HKD and MYR currencies are different.");
        }
        
        //verification for sorting feature
        coinsSortingByDescription(currencyUSD, currencyHKD, currencyMYR);
        coinsSortingByNumericCode(currencyUSD, currencyHKD, currencyMYR);
    }
    
    

	/**
	 * @param currencyUSD : USD coin instance
	 * @param currencyHKD : HKD coin instance
	 * @param currencyMYR : MYR coin instance
	 * This method verify comparisons on the basis of Numeric code 
	 */
	public static List<Coin> coinsSortingByNumericCode(Coin currencyUSD, Coin currencyHKD,
			Coin currencyMYR) {
		List<Coin> coins = new ArrayList<Coin>();
        coins.add(currencyUSD); coins.add(currencyHKD);coins.add(currencyMYR);
        //Sorting by Numeric code
        Collections.sort(coins, Coin.NumericCodeComparator);
        System.out.println("Sorting by Numeric code");
        coins.forEach(coin -> {System.out.println(coin.toString());});
        return coins;
       
	}
	
	
	/**
	 * @param currencyUSD : USD coin instance
	 * @param currencyHKD : HKD coin instance
	 * @param currencyMYR : MYR coin instance
	 * This method verify comparisons on the basis of  Coin description
	 */
	public static List<Coin>  coinsSortingByDescription(Coin currencyUSD, Coin currencyHKD,
			Coin currencyMYR) {
		List<Coin> coins = new ArrayList<Coin>();
        coins.add(currencyUSD); coins.add(currencyHKD);coins.add(currencyMYR);
        //sorting by description
        System.out.println("Sorting by coin description");
        Collections.sort(coins, Coin.coinDescriptionComparator);
        coins.forEach(coin -> {System.out.println(coin.toString());});
        return coins;
	}
}
