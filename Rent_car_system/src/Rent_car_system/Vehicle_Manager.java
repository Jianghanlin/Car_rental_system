package Rent_car_system;

import java.util.Scanner;

public class Vehicle_Manager {
	String no, brand, mtype, type;
	int seatcount, days, rent;
	Car car = new Car();
	Bus bus = new Bus();

	public void menu() {
		System.out.println("欢迎汽车租赁系统 Rev1.0");
		System.out.println("Powered by Jarvis,2020.10.14");
		for (int i = 0; i < 20; i++)
			System.out.print("-");
		System.out.print("\n");

		System.out.print("请输入要租赁的天数:");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		days = input.nextInt();
		System.out.print("请输入要租赁的汽车类型(1.轿车 2.客车):");
		mtype = input.next();

		if ("1".equals(mtype)) {
			System.out.print("请输入要租赁的汽车品牌(1.宝马 2.别克):");
			brand = input.next();
			if ("1".equals(brand)) {
				System.out.print("请输入轿车的型号(1.550i):");
			} else {
				System.out.print("请输入轿车的型号(2.商务舱GL7 3.林英达到):");
			}
			type = input.next();
			no = "浙12323";// 分配汽车牌号
			car = new Car(no, brand, mtype);
			rent = car.calrent(days);

			for (int i = 0; i < 20; i++)
				System.out.print("-");
			System.out.print("\n");

			System.out.println("您的订单如下:");
			System.out.print("租赁天数:\t" + days + "\n" + "轿车类型:\t" + mtype + "\n" + "轿车品牌:\t" + brand + "\n" + "轿车型号:\t"
					+ type + "\n" + "轿车牌号:\t" + no + "\n" + "租赁总费用:\t" + rent + "元\n");
		} else {
			System.out.print("请输入要租赁的客车品牌(1.金杯 2.金龙):");
			brand = input.next();
			System.out.print("请输入客车座位数:");
			seatcount = input.nextInt();
			no = "京AU8769";// 简单指定汽车牌号
			bus = new Bus(no, brand, seatcount);
			rent = car.calrent(days);

			for (int i = 0; i < 20; i++)
				System.out.print("-");
			System.out.print("\n");

			System.out.println("您的订单如下:");
			System.out.print("租赁的天数:" + days + "\n" + "租赁的汽车类型:" + mtype + "\n" + "租赁的汽车品牌" + brand + "\n" + "客车的座位数:"
					+ seatcount + "\n" + "汽车牌号" + no + "\n" + "租赁总费用" + rent + "\n");
		}
	}

}
