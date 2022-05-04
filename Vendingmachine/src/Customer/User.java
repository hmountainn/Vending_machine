package Customer;

import java.util.ArrayList;

public class User {
	String name;
	int money;
	ArrayList<String> purchase;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	//»ý¼ºÀÚ
	public User(String name, int money, ArrayList<String> purchase) {
		super();
		this.name = name;
		this.money = money;
		this.purchase = purchase;
	}
	
	public int UseCoin(int coin) {
		money = money - coin;
		return money;
	}
	
	public void purchaseDrink(String drink) {
		purchase.add(drink);
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getMoney() {
		return money;
	}

	
	public void setMoney(int money) {
		this.money = money;
	}

	public ArrayList<String> getPurchase() {
		return purchase;
	}

	public void setPurchase(ArrayList<String> purchase) {
		this.purchase = purchase;
	}
	
	
	
}
