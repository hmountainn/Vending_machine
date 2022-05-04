package Machine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import Customer.User;

public class DrinkMachine {
	String[] drinks = {"�ݶ�","���̴�","��"};
	int[] prices = {300,200,100};
	int inputCoin = 0;
	
	
	public DrinkMachine() {
		
	}
	
	//��� ����
	public int choiceFunction(Scanner scan) throws InputMismatchException {
		int choice;
		
		System.out.println("�ȳ��ϼ��� �������Ǳ� �����ý����Դϴ�. ����Ͻ� �޴��� �������ּ���");
		
		while(true) {
			try 
			{
				System.out.println("1.���� �����ϱ� 2.���Ǳ� �����ϱ�");
				System.out.print("�Է�: ");
				scan = new Scanner(System.in);
				choice = scan.nextInt();
			} 
			catch (InputMismatchException e) 
			{	
				System.out.println("------------------------------------");
				System.out.println("[�߸��� �Է��Դϴ�. �ٽ� �Է����ּ���]");
				continue;
			}
			return choice;
		}
	}
	
	//������ ����
	public User setUser(Scanner scan) {
		User user = new User();
		
		//�̸�����
		System.out.print("�������� �̸��� �Է����ּ���: ");
		String userName = scan.next();
		user.setName(userName);
		
		//�����ݾ� ����
		System.out.print("�����ϰ� ��� ���� �Է����ּ���: ");
		int money = scan.nextInt();
		user.setMoney(money);
		
		//���Ÿ�� �ʱ�ȭ
		ArrayList<String> purchase = new ArrayList<String>();
		user.setPurchase(purchase);
		
		return user;
	}
	
	//���γֱ�
	public void insertCoin(User user, Scanner scan) {
		//��������
		System.out.printf("������ �����Ͻðڽ��ϱ�? (y/n): ");
		String answer = scan.next();
		
		int coin = 0;
		if(answer.equals("y") || answer.equals("Y")) {
			System.out.print("�����Ͻ� ���� �Է����ּ���: ");
			coin = scan.nextInt();
			inputCoin = inputCoin + coin;
			user.UseCoin(inputCoin); 
		}
	}
	
	//����
	public void purchase(User user, Scanner scan) {
		//�����ϱ�
		String[] menu = new String[drinks.length];
		for(int i=0; i<drinks.length; i++) { menu[i] = drinks[i] + "(" +prices[i] + "��)";
		System.out.printf("%d.%s ",i+1,menu[i]);}
		System.out.println();
		System.out.print("�����Ͻ� �����ȣ�� �Է����ּ���: ");
		int purchaseNum = scan.nextInt()-1;
		user.purchaseDrink(drinks[purchaseNum]);		
		
		inputCoin = inputCoin - prices[purchaseNum];
	}
	
	//���м� ���
	public void printLine(String msg) {
		System.out.printf("---------------%s---------------\n",msg);
	}
	
	//���������� ���
	public void printUserInfo(User user) {
		
		//������ ����
		System.out.printf("������:%s  ���� ��:%d  ���Ե� ��:%d\n", user.getName(), user.getMoney(), inputCoin);
		
		//�������� ���
		int[] countPurchase = new int[drinks.length];
		ArrayList<String> purchase = user.getPurchase();
		for(int i=0; i<drinks.length; i++) {countPurchase[i] = Collections.frequency(purchase, drinks[i]);}
		String PurchaseList = "";
		for(int i=0; i<drinks.length; i++) {if(countPurchase[i] != 0) {PurchaseList += drinks[i] + "(" +countPurchase[i] +") ";}}
		if(user.getPurchase().size() != 0) {System.out.printf("������ ����:%s\n", PurchaseList);}
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
