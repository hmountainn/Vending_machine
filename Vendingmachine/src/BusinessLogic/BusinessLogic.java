package BusinessLogic;

import java.util.Scanner;

import Customer.User;
import Machine.DrinkMachine;

public class BusinessLogic {
	
	public void run() {
		//스캐너
		Scanner scan = new Scanner(System.in);
		
		//자판기 실행
		DrinkMachine machine = new DrinkMachine();
		
		//기능 선택하기
		int choice = machine.choiceFunction(scan);
		
		//음료구매기능
		if(choice == 1) {
			//구매자 설정
			machine.printLine("구매자 설정");
			User user = machine.setUser(scan);
			
			while(true) {				
				//구매자 현재 상태
				machine.printLine("구매자 정보");
				machine.printUserInfo(user);
				
				//코인 넣기
				machine.printLine("코인 투입");
				machine.insertCoin(user, scan);

				//구매자 현재 상태
				machine.printLine("구매자 정보");
				machine.printUserInfo(user);
				
				//음료 구입하기
				machine.printLine("음료 구입");
				machine.purchase(user, scan);
			}
			
		//자판기 관리
		}else if(choice == 2) {
			
		}
	}
}
