package Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import Customer.User1;
import Machine.DrinkMachine;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("안녕하세요 음료자판기 관리시스템입니다. 사용하실 메뉴를 선택해주세요");
		System.out.println("1.음료 구매하기 2.자판기 관리하기");
		System.out.print("입력: ");
		int choice = scan.nextInt();
		
		if(choice == 1) 
		{
			System.out.println("---------------구매모드---------------");
			
			//구매자 설정
			System.out.print("구매자의 이름을 입력해주세요: ");
			String userName = scan.next();
			System.out.print("소지하고 계신 돈을 입력해주세요: ");
			int money = scan.nextInt();
			ArrayList<String> purchase = new ArrayList<String>();
			
			
			//구매자 설정 완료
			User1 user1 = new User1(userName, money, purchase);
			purchase = user1.getPurchase();
			
			
			//자판기 기본설정
			DrinkMachine machine = new DrinkMachine();
			
			
			while(true) {
				System.out.println("---------------구매모드---------------");
				System.out.printf("구매자:%s  현재 돈:%d  투입된 돈:%d\n", user1.getName(), user1.getMoney(), machine.getInputCoin());
				
				
				//구입음료 목록
				String[] drinks = machine.getDrinks();
				int[] countPurchase = new int[drinks.length];
				purchase = user1.getPurchase();
				for(int i=0; i<drinks.length; i++) {countPurchase[i] = Collections.frequency(purchase, drinks[i]);}
				String PurchaseList = "";
				for(int i=0; i<drinks.length; i++) {if(countPurchase[i] != 0) {PurchaseList += drinks[i] + "(" +countPurchase[i] +") ";}}
				if(user1.getPurchase().size() != 0) {System.out.printf("구매한 음로:%s\n", PurchaseList);}
				
				
				//코인투입
				System.out.println("------------------------------------");
				System.out.printf("코인을 투입하시겠습니까? (y/n): ");
				String answer = scan.next();
				int inputCoin = 0;
				if(answer.equals("y") || answer.equals("Y")) {
					System.out.print("투입하실 돈을 입력해주세요: ");
					inputCoin = scan.nextInt();
					machine.insertCoin(inputCoin);
					user1.UseCoin(inputCoin);
				}
				
				
				//현재 구매자 상태
				System.out.println("-----------------------------------");
				System.out.printf("구매자:%s  현재 돈:%d  투입된 돈:%d\n", user1.getName(), user1.getMoney(), machine.getInputCoin());
				System.out.println();
				drinks = machine.getDrinks();
				int[] prices = machine.getPrices();
				
				
				//구매하기
				String[] menu = new String[drinks.length];
				for(int i=0; i<drinks.length; i++) { menu[i] = drinks[i] + "(" +prices[i] + "원)";
				System.out.printf("%d.%s ",i+1,menu[i]);}
				System.out.println();
				System.out.print("구매하실 음료번호를 입력해주세요: ");
				int purchaseNum = scan.nextInt()-1;
				inputCoin = machine.purchase(purchaseNum);
				String drink = machine.getDrinks()[purchaseNum];
				user1.purchaseDrink(drink);
			}
			
		
		}else if(choice == 2) {
			
		}
	}

}
