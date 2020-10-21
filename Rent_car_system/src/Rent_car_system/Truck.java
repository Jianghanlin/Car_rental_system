/*
 * Author：Jarvis
 * Date：2020.10.21
 * Class：17电子信息工程1 
 * Num：Xb17610107
*/

/*
 * Description：子类Truck,继承父类Vehicle
 * 
*/

package Rent_car_system;

import java.util.List;
import java.util.Scanner;

public final class Truck extends Vehicle {// 子类Truck继承继承父类Vehicle，final限制Truck不能有子类
	static final int start = 12;
	private int tone;

	public Truck() {// Truck的无参构造函数

	}

	public Truck(String no, String brand, String mtype, int tone, int state) {// Truck的有参构造函数，转入参数为车牌、品牌、类型、吨数、租赁状态
		super(no, brand, mtype, state);// 调用父类Vehicle的构造函数，必须要写
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

	public int calrent(int days) {// 针对Truck类重写父类的calrent函数
		return tone * days * 50;// 租金=吨数*天数*50
	}

	@Override
	public void input(String brand, String mtype, int money, int days, List<Vehicle> vehicles, List<Customer> orders,
			Customer p1) {// 针对Truck类重写父类的input函数
		super.input(brand, mtype, money, days, vehicles, orders, p1);// 父类的input函数
		mtype = "卡车";
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("输入要租赁的卡车品牌(1.重汽		2.解放):");
		brand = input.next();
		System.out.print("请输入吨数(10、20、40、50):");
		tone = input.nextInt();
		// 统一标号与品牌，将原来输入为12的brand值覆盖成12对应的具体卡车品牌，方便后期打印
		if ("1".equals(brand)) {
			brand = "重汽";// 原来"1"覆盖成"重汽"
		} else if ("2".equals(brand)) {
			brand = "解放";// 原来"2"覆盖成"解放"
		} else {
			System.out.print("查无此车！！！");
		}
		for (int i = start; i < vehicles.size(); i++) {// 开始遍历vehicles，找到符合条件的卡车并打印
			Truck temp = (Truck) vehicles.get(i);
			if ((temp.getState() == 0) && (temp.gettone() == tone)) {
				vehicles.get(i).setState(1);
				p1.setNo(temp.getNo());// 将获得的牌号保存进购物车变量p1里
				break;
			}
		}
		money = calrent(days);// 计算租金
		p1.setBrand(brand);
		p1.setDays(days);
		p1.setMtype(mtype);
		p1.setMoney(money);
		p1.setType("空");// 因为卡车没有型号，但是最后打印有型号一列，所以赋值为空
		p1.setSeatcount(tone);
		orders.add(p1);// 将找到的汽车添加进购物车中
	}
}
