package Machine;

public class DrinkMachine {
	String[] drinks = {"콜라","사이다","물"};
	int[] prices = {300,200,100};
	int inputCoin = 0;
	
	
	public DrinkMachine() {
		
	}
	
	public int insertCoin(int coin) {
		inputCoin = inputCoin + coin;
		return inputCoin;
	}
	
	public int purchase(int drinkNum) {
		inputCoin = inputCoin - prices[drinkNum];
		return inputCoin;
	}

	public String[] getDrinks() {
		return drinks;
	}

	public void setDrinks(String[] drinks) {
		this.drinks = drinks;
	}

	public int[] getPrices() {
		return prices;
	}

	public void setPrices(int[] prices) {
		this.prices = prices;
	}

	public int getInputCoin() {
		return inputCoin;
	}

	public void setInputCoin(int inputCoin) {
		this.inputCoin = inputCoin;
	}
}
