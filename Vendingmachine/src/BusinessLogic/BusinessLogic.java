package BusinessLogic;

import java.util.Scanner;

import Customer.User;
import Machine.DrinkMachine;

public class BusinessLogic {
	
	public void run() {
		//��ĳ��
		Scanner scan = new Scanner(System.in);
		
		//���Ǳ� ����
		DrinkMachine machine = new DrinkMachine();
		
		//��� �����ϱ�
		int choice = machine.choiceFunction(scan);
		
		//���ᱸ�ű��
		if(choice == 1) {
			//������ ����
			machine.printLine("������ ����");
			User user = machine.setUser(scan);
			
			while(true) {				
				//������ ���� ����
				machine.printLine("������ ����");
				machine.printUserInfo(user);
				
				//���� �ֱ�
				machine.printLine("���� ����");
				machine.insertCoin(user, scan);

				//������ ���� ����
				machine.printLine("������ ����");
				machine.printUserInfo(user);
				
				//���� �����ϱ�
				machine.printLine("���� ����");
				machine.purchase(user, scan);
			}
			
		//���Ǳ� ����
		}else if(choice == 2) {
			
		}
	}
}
