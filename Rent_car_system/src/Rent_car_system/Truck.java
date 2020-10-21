/*
 * Author��Jarvis
 * Date��2020.10.21
 * Class��17������Ϣ����1 
 * Num��Xb17610107
*/

/*
 * Description������Truck,�̳и���Vehicle
 * 
*/

package Rent_car_system;

import java.util.List;
import java.util.Scanner;

public final class Truck extends Vehicle {// ����Truck�̳м̳и���Vehicle��final����Truck����������
	static final int start = 12;
	private int tone;

	public Truck() {// Truck���޲ι��캯��

	}

	public Truck(String no, String brand, String mtype, int tone, int state) {// Truck���вι��캯����ת�����Ϊ���ơ�Ʒ�ơ����͡�����������״̬
		super(no, brand, mtype, state);// ���ø���Vehicle�Ĺ��캯��������Ҫд
		this.tone = tone;
	}

	public int getTone() {
		return tone;
	}

	public void setTone(int tone) {
		this.tone = tone;
	}

	public int gettone() {
		return tone;
	}

	public void settone(int tone) {
		this.tone = tone;
	}

	public int calrent(int days) {// ���Truck����д�����calrent����
		return tone * days * 50;// ���=����*����*50
	}

	@Override
	public void input(String brand, String mtype, int money, int days, List<Vehicle> vehicles, List<Customer> orders,
			Customer p1) {// ���Truck����д�����input����
		super.input(brand, mtype, money, days, vehicles, orders, p1);// �����input����
		mtype = "����";
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("����Ҫ���޵Ŀ���Ʒ��(1.����		2.���):");
		brand = input.next();
		System.out.print("���������(10��20��40��50):");
		tone = input.nextInt();
		// ͳһ�����Ʒ�ƣ���ԭ������Ϊ12��brandֵ���ǳ�12��Ӧ�ľ��忨��Ʒ�ƣ�������ڴ�ӡ
		if ("1".equals(brand)) {
			brand = "����";// ԭ��"1"���ǳ�"����"
		} else if ("2".equals(brand)) {
			brand = "���";// ԭ��"2"���ǳ�"���"
		} else {
			System.out.print("���޴˳�������");
		}
		for (int i = start; i < vehicles.size(); i++) {// ��ʼ����vehicles���ҵ����������Ŀ�������ӡ
			Truck temp = (Truck) vehicles.get(i);
			if ((temp.getState() == 0) && (temp.gettone() == tone)) {
				vehicles.get(i).setState(1);
				p1.setNo(temp.getNo());// ����õ��ƺű�������ﳵ����p1��
				break;
			}
		}
		money = calrent(days);// �������
		p1.setBrand(brand);
		p1.setDays(days);
		p1.setMtype(mtype);
		p1.setMoney(money);
		p1.setType("��");// ��Ϊ����û���ͺţ���������ӡ���ͺ�һ�У����Ը�ֵΪ��
		p1.setSeatcount(tone);
		orders.add(p1);// ���ҵ���������ӽ����ﳵ��
	}
}
