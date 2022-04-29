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
		
		System.out.println("�ȳ��ϼ��� �������Ǳ� �����ý����Դϴ�. ����Ͻ� �޴��� �������ּ���");
		System.out.println("1.���� �����ϱ� 2.���Ǳ� �����ϱ�");
		System.out.print("�Է�: ");
		int choice = scan.nextInt();
		
		if(choice == 1) 
		{
			System.out.println("---------------���Ÿ��---------------");
			
			//������ ����
			System.out.print("�������� �̸��� �Է����ּ���: ");
			String userName = scan.next();
			System.out.print("�����ϰ� ��� ���� �Է����ּ���: ");
			int money = scan.nextInt();
			ArrayList<String> purchase = new ArrayList<String>();
			
			
			//������ ���� �Ϸ�
			User1 user1 = new User1(userName, money, purchase);
			purchase = user1.getPurchase();
			
			
			//���Ǳ� �⺻����
			DrinkMachine machine = new DrinkMachine();
			
			
			while(true) {
				System.out.println("---------------���Ÿ��---------------");
				System.out.printf("������:%s  ���� ��:%d  ���Ե� ��:%d\n", user1.getName(), user1.getMoney(), machine.getInputCoin());
				
				
				//�������� ���
				String[] drinks = machine.getDrinks();
				int[] countPurchase = new int[drinks.length];
				purchase = user1.getPurchase();
				for(int i=0; i<drinks.length; i++) {countPurchase[i] = Collections.frequency(purchase, drinks[i]);}
				String PurchaseList = "";
				for(int i=0; i<drinks.length; i++) {if(countPurchase[i] != 0) {PurchaseList += drinks[i] + "(" +countPurchase[i] +") ";}}
				if(user1.getPurchase().size() != 0) {System.out.printf("������ ����:%s\n", PurchaseList);}
				
				
				//��������
				System.out.println("------------------------------------");
				System.out.printf("������ �����Ͻðڽ��ϱ�? (y/n): ");
				String answer = scan.next();
				int inputCoin = 0;
				if(answer.equals("y") || answer.equals("Y")) {
					System.out.print("�����Ͻ� ���� �Է����ּ���: ");
					inputCoin = scan.nextInt();
					machine.insertCoin(inputCoin);
					user1.UseCoin(inputCoin);
				}
				
				
				//���� ������ ����
				System.out.println("-----------------------------------");
				System.out.printf("������:%s  ���� ��:%d  ���Ե� ��:%d\n", user1.getName(), user1.getMoney(), machine.getInputCoin());
				System.out.println();
				drinks = machine.getDrinks();
				int[] prices = machine.getPrices();
				
				
				//�����ϱ�
				String[] menu = new String[drinks.length];
				for(int i=0; i<drinks.length; i++) { menu[i] = drinks[i] + "(" +prices[i] + "��)";
				System.out.printf("%d.%s ",i+1,menu[i]);}
				System.out.println();
				System.out.print("�����Ͻ� �����ȣ�� �Է����ּ���: ");
				int purchaseNum = scan.nextInt()-1;
				inputCoin = machine.purchase(purchaseNum);
				String drink = machine.getDrinks()[purchaseNum];
				user1.purchaseDrink(drink);
			}
			
		
		}else if(choice == 2) {
			
		}
	}

}
