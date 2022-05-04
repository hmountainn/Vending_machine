package Machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import Customer.User;

public class DrinkMachine {
	String[] drinks = {"콜라","사이다","물"};
	int[] prices = {300,200,100};
	int inputCoin = 0;
	
	
	public DrinkMachine() {
		
	}
	
	//기능 선택
	public int choiceFunction(Scanner scan) throws InputMismatchException {
		int choice;
		
		System.out.println("안녕하세요 음료자판기 관리시스템입니다. 사용하실 메뉴를 선택해주세요");
		
		while(true) {
			try 
			{
				System.out.println("1.음료 구매하기 2.자판기 관리하기");
				System.out.print("입력: ");
				scan = new Scanner(System.in);
				choice = scan.nextInt();
			} 
			catch (InputMismatchException e) 
			{	
				System.out.println("------------------------------------");
				System.out.println("[잘못된 입력입니다. 다시 입력해주세요]");
				continue;
			}
			return choice;
		}
	}
	
	//구매자 설정
	public User setUser(Scanner scan) {
		User user = new User();
		
		//이름설정
		System.out.print("구매자의 이름을 입력해주세요: ");
		String userName = scan.next();
		user.setName(userName);
		
		//소유금액 설정
		System.out.print("소지하고 계신 돈을 입력해주세요: ");
		int money = scan.nextInt();
		user.setMoney(money);
		
		//구매목록 초기화
		ArrayList<String> purchase = new ArrayList<String>();
		user.setPurchase(purchase);
		
		return user;
	}
	
	//코인넣기
	public void insertCoin(User user, Scanner scan) {
		//코인투입
		System.out.printf("코인을 투입하시겠습니까? (y/n): ");
		String answer = scan.next();
		
		int coin = 0;
		if(answer.equals("y") || answer.equals("Y")) {
			System.out.print("투입하실 돈을 입력해주세요: ");
			coin = scan.nextInt();
			inputCoin = inputCoin + coin;
			user.UseCoin(inputCoin); 
		}
	}
	
	//구매
	public void purchase(User user, Scanner scan) {
		//구매하기
		String[] menu = new String[drinks.length];
		for(int i=0; i<drinks.length; i++) { menu[i] = drinks[i] + "(" +prices[i] + "원)";
		System.out.printf("%d.%s ",i+1,menu[i]);}
		System.out.println();
		System.out.print("구매하실 음료번호를 입력해주세요: ");
		int purchaseNum = scan.nextInt()-1;
		user.purchaseDrink(drinks[purchaseNum]);		
		
		inputCoin = inputCoin - prices[purchaseNum];
	}
	
	//구분선 출력
	public void printLine(String msg) {
		System.out.printf("---------------%s---------------\n",msg);
	}
	
	//구매자정보 출력
	public void printUserInfo(User user) {
		
		//구매자 정보
		System.out.printf("구매자:%s  현재 돈:%d  투입된 돈:%d\n", user.getName(), user.getMoney(), inputCoin);
		
		//구입음료 목록
		int[] countPurchase = new int[drinks.length];
		ArrayList<String> purchase = user.getPurchase();
		for(int i=0; i<drinks.length; i++) {countPurchase[i] = Collections.frequency(purchase, drinks[i]);}
		String PurchaseList = "";
		for(int i=0; i<drinks.length; i++) {if(countPurchase[i] != 0) {PurchaseList += drinks[i] + "(" +countPurchase[i] +") ";}}
		if(user.getPurchase().size() != 0) {System.out.printf("구매한 음로:%s\n", PurchaseList);}
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
