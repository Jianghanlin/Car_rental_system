/*
 * Author��Jarvis
 * Date��2020.10.21
 * Class��17������Ϣ����1 
 * Num��Xb17610107
*/

/*
 * Description������Car,�̳и���Vehicle
 * 
*/

package Rent_car_system;

import java.util.List;
import java.util.Scanner;

public final class Car extends Vehicle {// ����Car�̳м̳и���Vehicle��final����Car����������
	static final int start = 0;
	static final int end = 7;
	private String type;// Car���е�type��

	public Car(String no, String brand, String mtype, String type, int state) {// Car���вι��캯����ת�����Ϊ���ơ�Ʒ�ơ����͡��ͺš�����״̬
		super(no, brand, mtype, state);// ���ø���Vehicle�Ĺ��캯��������Ҫд
		this.type = type;
	}

	public Car() {// Car���޲ι��캯��
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int calrent(int days) {// ���Car����д�����calrent����
		if ("550i".equals(type)) {
			return days * 500;// ����550i�����
		} else if ("�����GL8".equals(type)) {
			return days * 600;// ��������GL8�����
		} else if ("������".equals(type)) {
			return days * 300;// ��������������
		} else
			return 0;
	}

	@Override
	public void print() {
		super.print();
	}

	@Override
	public int input(String brand, String mtype, int money, int days, List<Vehicle> vehicles, List<Customer> orders,
			Customer p1) {// ���Car����д�����input����
		int scan = 1;
		int num = 1;
		// ��ű���
		/*
		 * super.input(brand, mtype, money, days, vehicles, orders, p1);// �����input����
		 */ mtype = "�γ�";
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("������Ҫ���޵Ľγ�Ʒ��(1.����		2.���):");
		brand = input.next();
		while (("1".equals(brand) == false) && ("2".equals(brand) == false)) {
			System.out.print("����û������Ʒ�Ƶĳ�������,���������룺");
			brand = input.next();
		}

		// ͳһ�����Ʒ�ƣ���ԭ������Ϊ12��brandֵ���ǳ�12��Ӧ�ľ���γ�Ʒ�ƣ�������ڴ�ӡ
		if ("1".equals(brand)) {// ѡ����Ǳ���
			brand = "����";// ԭ��"1"���ǳ�"����"
			System.out.print("�����Ǹ�Ʒ���������е���");
			System.out.print("\n");
			for (int i = 0; i < 20; i++)
				System.out.print("-");
			System.out.print("\n");
			System.out.println("[���]\t[�����ƺ�]\t[��������]\t[����Ʒ��]\t[�����ͺ�]\t[����״̬]");
			for (int i = 0; i <= 3; i++) {// ��ʼ����vehicles���ҵ����������Ľγ�����ӡ
				Car temp = (Car) vehicles.get(i);
				System.out.printf("  %-8d%-15s%-15s%-12s%-18s%-15d\n", num, temp.getNo(), temp.getMtype(),
						temp.getBrand(), temp.getType(), temp.getState());
				num++;
			}

			System.out.print("������γ����ͺ�(1.550i):");
			type = input.next();

			while ("1".equals(type) == false) {
				System.out.print("����û�������ͺŵĳ�������,���������룺");
				type = input.next();
			}

			// ͳһ������ͺţ���ԭ������Ϊ123��typeֵ���ǳ�123��Ӧ�ľ���γ��ͺţ�������ڴ�ӡ
			type = "550i";// ԭ��"1"���ǳ�"550i"

		} else {// ѡ����Ǳ��
			brand = "���";// ԭ��"2"���ǳ�"���"
			System.out.print("�����Ǹ�Ʒ���������е���");
			System.out.print("\n");
			for (int i = 0; i < 20; i++)
				System.out.print("-");
			System.out.print("\n");
			System.out.println("[���]\t[�����ƺ�]\t[��������]\t[����Ʒ��]\t[�����ͺ�]\t[����״̬]");
			for (int i = 4; i <= 7; i++) {// ��ʼ����vehicles���ҵ����������Ľγ�����ӡ
				Car temp = (Car) vehicles.get(i);
				System.out.printf("  %-8d%-15s%-15s%-12s%-18s%-15d\n", num, temp.getNo(), temp.getMtype(),
						temp.getBrand(), temp.getType(), temp.getState());
				num++;
			}

			System.out.print("������γ����ͺ�(2.�����GL8		3.������):");
			type = input.next();

			while (("2".equals(type) == false) && ("3".equals(type) == false)) {
				System.out.print("����û�������ͺŵĳ�������,���������룺");
				type = input.next();
			}

			switch (type) {// ͳһ������ͺţ���ԭ������Ϊ123��typeֵ���ǳ�123��Ӧ�ľ���γ��ͺţ�������ڴ�ӡ
			case "2":
				type = "�����GL8";// ԭ��"2"���ǳ�"�����GL8"
				break;
			case "3":
				type = "������";// ԭ��"3"���ǳ�"������"
				break;
			default:
				break;
			}
		}

		for (int i = start; i <= end; i++) {// ��ʼ����vehicles���ҵ����������Ľγ�����ӡ
			Car temp = (Car) vehicles.get(i);
			if ((temp.getType().equals(type)) && (temp.getState() == 0)) {
				vehicles.get(i).setState(1);
				p1.setNo(temp.getNo());// ����õ��ƺű�������ﳵ����p1��
				scan = 0;
				break;
			} else
				;
		}
		if (scan == 0) {
			money = calrent(days);// �������
			p1.setBrand(brand);
			p1.setDays(days);
			p1.setMtype(mtype);
			p1.setMoney(money);
			p1.setType(type);
			orders.add(p1);// ���ҵ��Ľγ���ӽ����ﳵ��
			return 0;// ����û�д��󣬷���0
		} else {
			System.out.print("�ó����ѱ��������û�иó�������");
			return 1;// �����д��󣬷���1
		}

	}
}
