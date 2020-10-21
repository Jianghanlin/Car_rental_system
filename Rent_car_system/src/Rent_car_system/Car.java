/*
 * Author：Jarvis
 * Date：2020.10.21
 * Class：17电子信息工程1 
 * Num：Xb17610107
*/

/*
 * Description：子类Car,继承父类Vehicle
 * 
*/

package Rent_car_system;

import java.util.List;
import java.util.Scanner;

public final class Car extends Vehicle {// 子类Car继承继承父类Vehicle，final限制Car不能有子类
	static final int start = 0;
	static final int end = 7;
	private String type;// Car独有的type类

	public Car(String no, String brand, String mtype, String type, int state) {// Car的有参构造函数，转入参数为车牌、品牌、类型、型号、租赁状态
		super(no, brand, mtype, state);// 调用父类Vehicle的构造函数，必须要写
		this.type = type;
	}

	public Car() {// Car的无参构造函数
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int calrent(int days) {// 针对Car类重写父类的calrent函数
		if ("1".equals(type)) {
			return days * 500;// 宝马550i的租金
		} else if ("2".equals(type)) {
			return days * 600;// 别克商务舱GL8的租金
		} else if ("3".equals(type)) {
			return days * 300;// 别克林荫大道的租金
		} else
			return 0;
	}

	@Override
	public void print() {
		super.print();
	}

	@Override
	public void input(String brand, String mtype, int money, int days, List<Vehicle> vehicles, List<Customer> orders,
			Customer p1) {// 针对Car类重写父类的input函数
		super.input(brand, mtype, money, days, vehicles, orders, p1);// 父类的input函数
		mtype = "轿车";
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("请输入要租赁的轿车品牌(1.宝马		2.别克):");
		brand = input.next();
		// 统一标号与品牌，将原来输入为12的brand值覆盖成12对应的具体轿车品牌，方便后期打印
		if ("1".equals(brand)) {// 选择的是宝马
			brand = "宝马";// 原来"1"覆盖成"宝马"
			System.out.print("请输入轿车的型号(1.550i):");
		} else {// 选择的是别克
			brand = "别克";// 原来"2"覆盖成"别克"
			System.out.print("请输入轿车的型号(2.商务舱GL8		3.林荫大道):");
		}
		type = input.next();
		money = calrent(days);// 计算租金
		// 统一标号与型号，将原来输入为123的type值覆盖成123对应的具体轿车型号，方便后期打印
		switch (type) {
		case "1":
			type = "550i";// 原来"1"覆盖成"550i"
			break;
		case "2":
			type = "商务舱GL8";// 原来"2"覆盖成"商务舱GL8"
			break;
		case "3":
			type = "林荫大道";// 原来"3"覆盖成"林荫大道"
			break;
		default:
			System.out.print("查无此车！！！");
			break;
		}
		for (int i = start; i < end; i++) {// 开始遍历vehicles，找到符合条件的轿车并打印
			Car temp = (Car) vehicles.get(i);
			if ((temp.getType().equals(type)) && (temp.getState() == 0)) {
				vehicles.get(i).setState(1);
				p1.setNo(temp.getNo());// 将获得的牌号保存进购物车变量p1里
				break;
			} else
				;
		}

		p1.setBrand(brand);
		p1.setDays(days);
		p1.setMtype(mtype);
		p1.setMoney(money);
		p1.setType(type);
		orders.add(p1);// 将找到的轿车添加进购物车中
	}

}
