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
	public int input(String brand, String mtype, int money, int days, List<Vehicle> vehicles, List<Customer> orders,
			Customer p1) {
		int scan = 1;
		int num = 1;
		// ���Bus����д�����input����
		/*
		 * super.input(brand, mtype, money, days, vehicles, orders, p1);// �����input����
		 */
		mtype = "�ͳ�";
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("������Ҫ���޵Ŀͳ�Ʒ��(1.��		2.����):");
		brand = input.next();

		while (("1".equals(brand) == false) && ("2".equals(brand) == false)) {
			System.out.print("����û������Ʒ�Ƶĳ�������,���������룺");
			brand = input.next();
		}

		// ͳһ�����Ʒ�ƣ���ԭ������Ϊ12��brandֵ���ǳ�12��Ӧ�ľ���ͳ�Ʒ�ƣ�������ڴ�ӡ
		if ("1".equals(brand)) {
			brand = "��";// ԭ��"1"���ǳ�"��"
			System.out.print("�����Ǹ�Ʒ���������е���");
			System.out.print("\n");
			for (int i = 0; i < 20; i++)
				System.out.print("-");
			System.out.print("\n");
			System.out.println("[���]\t[�����ƺ�]\t[��������]\t[����Ʒ��]\t[��λ��]\t[����״̬]");
			for (int i = 8; i <= 9; i++) {// ��ʼ����vehicles���ҵ����������Ľγ�����ӡ
				Bus temp = (Bus) vehicles.get(i);
				System.out.printf("  %-8d%-15s%-15s%-12s%-15d%-15d\n", num, temp.getNo(), temp.getMtype(),
						temp.getBrand(), temp.getSeatcount(), temp.getState());
				num++;
			}

		} else {
			brand = "����";// ԭ��"2"���ǳ�"����"
			System.out.print("�����Ǹ�Ʒ���������е���");
			System.out.print("\n");
			for (int i = 0; i < 20; i++)
				System.out.print("-");
			System.out.print("\n");
			System.out.println("[���]\t[�����ƺ�]\t[��������]\t[����Ʒ��]\t[��λ��]\t[����״̬]");
			for (int i = 10; i <= 11; i++) {// ��ʼ����vehicles���ҵ����������Ľγ�����ӡ
				Bus temp = (Bus) vehicles.get(i);
				System.out.printf("  %-8d%-15s%-15s%-12s%-15d%-15d\n", num, temp.getNo(), temp.getMtype(),
						temp.getBrand(), temp.getSeatcount(), temp.getState());
				num++;
			}

		}

		System.out.print("��������λ��(15��40��50��60):");
		seatcount = input.nextInt();

		while ((seatcount != 15) && (seatcount != 40) && (seatcount != 50) && (seatcount != 60)) {
			System.out.print("����û��������λ���ĳ�������,���������룺");
			seatcount = input.nextInt();
		}

		for (int i = start; i <= end; i++) {// ��ʼ����vehicles���ҵ����������Ŀͳ�����ӡ
			Bus temp = (Bus) vehicles.get(i);
			if ((temp.getBrand().equals(brand)) && (temp.getState() == 0) && (temp.getSeatcount() == seatcount)) {
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
			p1.setType("��");// ��Ϊ�ͳ�û���ͺţ���������ӡ���ͺ�һ�У����Ը�ֵΪ��
			p1.setSeatcount(seatcount);
			orders.add(p1);// ���ҵ��Ŀͳ���ӽ����ﳵ��
			return 0;// ����û�д��󣬷���0
		} else {
			System.out.print("�ó����ѱ��������û�иó�������");
			return 1;// �����д��󣬷���1
		}
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
