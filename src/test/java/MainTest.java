import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.walkerdigital.toolkit.money.component.Coin;
import com.walkerdigital.toolkit.money.component.CoinFactory;
import com.walkerdigital.toolkit.money.constant.CurrencyCode;

public class MainTest {

	@Test
	public void testCoinsSortingByNumericCode() {
		Coin currencyUSD = CoinFactory
				.getCoinByCurrencyCode(CurrencyCode.CURRENCY_CODE_USD);
		Coin currencyHKD = CoinFactory
				.getCoinByCurrencyCode(CurrencyCode.CURRENCY_CODE_HKD);
		Coin currencyMYR = CoinFactory
				.getCoinByCurrencyCode(CurrencyCode.CURRENCY_CODE_MYR);

		List<Coin> sortedCoins = Main.coinsSortingByNumericCode(currencyUSD, currencyHKD, currencyMYR);
		assertEquals("344", sortedCoins.get(0).getNumericCode());
	}
	
	@Test
	public void testCoinsSortingByCoinDescription() {
		Coin currencyUSD = CoinFactory
				.getCoinByCurrencyCode(CurrencyCode.CURRENCY_CODE_USD);
		Coin currencyHKD = CoinFactory
				.getCoinByCurrencyCode(CurrencyCode.CURRENCY_CODE_HKD);
		Coin currencyMYR = CoinFactory
				.getCoinByCurrencyCode(CurrencyCode.CURRENCY_CODE_MYR);

		List<Coin> sortedCoins = Main.coinsSortingByDescription(currencyUSD, currencyHKD, currencyMYR);
		assertEquals("Hong Kong dollar", sortedCoins.get(0).getDescription());
	}

}
