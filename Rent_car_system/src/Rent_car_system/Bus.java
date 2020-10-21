/*
 * Author��Jarvis
 * Date��2020.10.21
 * Class��17������Ϣ����1 
 * Num��Xb17610107
*/

/*
 * Description������Bus,�̳и���Vehicle
 * 
*/

package Rent_car_system;

import java.util.List;
import java.util.Scanner;

public final class Bus extends Vehicle {// ����Bus�̳м̳и���Vehicle��final����Bus����������
	static final int start = 8;
	static final int end = 11;
	private int seatcount;// Bus���е�seatcount��

	public Bus() {// Bus���޲ι��캯��

	}

	public Bus(String no, String brand, String mtype, int seatcount, int state) {// Bus���вι��캯����ת�����Ϊ���ơ�Ʒ�ơ����͡���λ�š�����״̬
		super(no, brand, mtype, state);// ���ø���Vehicle�Ĺ��캯��������Ҫд
		this.seatcount = seatcount;
	}

	@Override
	public void input(String brand, String mtype, int money, int days, List<Vehicle> vehicles, List<Customer> orders,
			Customer p1) {// ���Bus����д�����input����
		super.input(brand, mtype, money, days, vehicles, orders, p1);// �����input����
		mtype = "�ͳ�";
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("������Ҫ���޵Ŀͳ�Ʒ��(1.��		2.����):");
		brand = input.next();
		// ͳһ�����Ʒ�ƣ���ԭ������Ϊ12��brandֵ���ǳ�12��Ӧ�ľ���ͳ�Ʒ�ƣ�������ڴ�ӡ
		if ("1".equals(brand)) {
			brand = "��";// ԭ��"1"���ǳ�"��"
		} else {
			brand = "����";// ԭ��"2"���ǳ�"����"
		}
		System.out.print("��������λ��(15��40��50��60):");
		seatcount = input.nextInt();
		for (int i = start; i <= end; i++) {// ��ʼ����vehicles���ҵ����������Ŀͳ�����ӡ
			Bus temp = (Bus) vehicles.get(i);
			if ((temp.getBrand().equals(brand)) && (temp.getState() == 0) && (temp.getSeatcount() == seatcount)) {
				vehicles.get(i).setState(1);
				p1.setNo(temp.getNo());// ����õ��ƺű�������ﳵ����p1��
				break;
			} else
				;
		}
		money = calrent(days);
		p1.setBrand(brand);
		p1.setDays(days);
		p1.setMtype(mtype);
		p1.setMoney(money);
		p1.setType("��");// ��Ϊ�ͳ�û���ͺţ���������ӡ���ͺ�һ�У����Ը�ֵΪ��
		p1.setSeatcount(seatcount);
		orders.add(p1);// ���ҵ���������ӽ����ﳵ��
	}

	public int getSeatcount() {
		return seatcount;
	}

	public void setSeatcount(int seatcount) {
		this.seatcount = seatcount;
	}

	@Override
	public void print() {
		super.print();
	}

	public int calrent(int days) {// ���Bus����д�����calrent����
		if (seatcount <= 16) {
			return days * 800;// С�ڵ���16�������
		} else {
			return days * 1500;// ����16�������
		}
	}

}
