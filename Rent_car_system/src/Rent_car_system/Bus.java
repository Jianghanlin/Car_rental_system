/*
 * Author：Jarvis
 * Date：2020.10.21
 * Class：17电子信息工程1 
 * Num：Xb17610107
*/

/*
 * Description：子类Bus,继承父类Vehicle
 * 
*/

package Rent_car_system;

import java.util.List;
import java.util.Scanner;

public final class Bus extends Vehicle {// 子类Bus继承继承父类Vehicle，final限制Bus不能有子类
	static final int start = 8;
	static final int end = 11;
	private int seatcount;// Bus独有的seatcount类

	public Bus() {// Bus的无参构造函数

	}

	public Bus(String no, String brand, String mtype, int seatcount, int state) {// Bus的有参构造函数，转入参数为车牌、品牌、类型、座位号、租赁状态
		super(no, brand, mtype, state);// 调用父类Vehicle的构造函数，必须要写
		this.seatcount = seatcount;
	}

	@Override
	public void input(String brand, String mtype, int money, int days, List<Vehicle> vehicles, List<Customer> orders,
			Customer p1) {// 针对Bus类重写父类的input函数
		super.input(brand, mtype, money, days, vehicles, orders, p1);// 父类的input函数
		mtype = "客车";
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("请输入要租赁的客车品牌(1.金杯		2.金龙):");
		brand = input.next();
		// 统一标号与品牌，将原来输入为12的brand值覆盖成12对应的具体客车品牌，方便后期打印
		if ("1".equals(brand)) {
			brand = "金杯";// 原来"1"覆盖成"金杯"
		} else {
			brand = "金龙";// 原来"2"覆盖成"金龙"
		}
		System.out.print("请输入座位数(15、40、50、60):");
		seatcount = input.nextInt();
		for (int i = start; i <= end; i++) {// 开始遍历vehicles，找到符合条件的客车并打印
			Bus temp = (Bus) vehicles.get(i);
			if ((temp.getBrand().equals(brand)) && (temp.getState() == 0) && (temp.getSeatcount() == seatcount)) {
				vehicles.get(i).setState(1);
				p1.setNo(temp.getNo());// 将获得的牌号保存进购物车变量p1里
				break;
			} else
				;
		}
		money = calrent(days);
		p1.setBrand(brand);
		p1.setDays(days);
		p1.setMtype(mtype);
		p1.setMoney(money);
		p1.setType("空");// 因为客车没有型号，但是最后打印有型号一列，所以赋值为空
		p1.setSeatcount(seatcount);
		orders.add(p1);// 将找到的汽车添加进购物车中
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

	public int calrent(int days) {// 针对Bus类重写父类的calrent函数
		if (seatcount <= 16) {
			return days * 800;// 小于等于16座的租金
		} else {
			return days * 1500;// 大于16座的租金
		}
	}

}
