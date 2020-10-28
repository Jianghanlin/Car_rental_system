/*
 * Author：Jarvis
 * Date：2020.10.21
 * Class：17电子信息工程1 
 * Num：Xb17610107
*/

/*
 * Description：汽车管理类
 * 
*/

package Rent_car_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vehicle_Manager {
	String no;// 汽车牌号
	String brand;// 汽车品牌
	String mtype;// 汽车类型
	String type;// 汽车型号
	String name;// 用户姓名
	int seatcount = 0;// 座位数
	int totalrent = 0;// 总租金
	int money = 0;// 分租金
	int days = 0;// 租赁天数
	int i = 0;// 循环变量
	static int j = 0;// 初始化界面执行次数控制函数

	Car car = new Car();// 新建对象car，为后期调用重写input做准备
	Bus bus = new Bus();// 新建对象bus，为后期调用重写input做准备
	Truck truck = new Truck();// 新建truck类，为后期调用重写input做准备
	List<Vehicle> vehicles = new ArrayList<Vehicle>();// 新建Arraylist类,对象名为vehicles，用来保存轿车、卡车和客车
	List<Customer> orders = new ArrayList<Customer>();// 新建Customer类，对象名为orders，用来保存用户租赁清单
	Customer p1 = new Customer();// 新建Customer对象p1，用来保存用户的租赁信息

	public void vehicle_init() {// 汽车初始化函数
		Vehicle car1 = new Car("浙0001", "宝马", "轿车", "550i", 0);// 新建父类Vehicle对象car1，调用子类有参构造函数，传入参数为车牌、品牌、汽车类型、具体型号、租赁状态
		Vehicle car2 = new Car("浙0002", "宝马", "轿车", "550i", 0);
		Vehicle car3 = new Car("浙0003", "宝马", "轿车", "550i", 0);
		Vehicle car4 = new Car("浙0004", "宝马", "轿车", "550i", 0);
		Vehicle car5 = new Car("浙0005", "别克", "轿车", "商务舱GL8", 0);
		Vehicle car6 = new Car("浙0006", "别克", "轿车", "商务舱GL8", 0);
		Vehicle car7 = new Car("浙0007", "别克", "轿车", "林荫大道", 0);
		Vehicle car8 = new Car("浙0008", "别克", "轿车", "林荫大道", 0);
		Vehicle truck1 = new Truck("浙0009", "重汽", "卡车", 10, 0);// 新建父类Vehicle对象truck1，调用子类有参构造函数，传入参数为车牌、品牌、汽车类型、吨数、租赁状态
		Vehicle truck2 = new Truck("浙0010", "重汽", "卡车", 20, 0);
		Vehicle truck3 = new Truck("浙0011", "解放", "卡车", 40, 0);
		Vehicle truck4 = new Truck("浙0012", "解放", "卡车", 50, 0);
		Vehicle bus1 = new Bus("浙0013", "金杯", "客车", 15, 0);// 新建父类Vehicle对象bus1，调用子类有参构造函数，传入参数为车牌、品牌、汽车类型、座位号、租赁状态
		Vehicle bus2 = new Bus("浙0014", "金杯", "客车", 40, 0);
		Vehicle bus3 = new Bus("浙0015", "金龙", "客车", 50, 0);
		Vehicle bus4 = new Bus("浙0016", "金龙", "客车", 60, 0);
		vehicles.add(car1);// 将初始化的对象添加到Arraylist对象vehicles中
		vehicles.add(car2);
		vehicles.add(car3);
		vehicles.add(car4);
		vehicles.add(car5);
		vehicles.add(car6);
		vehicles.add(car7);
		vehicles.add(car8);
		vehicles.add(bus1);
		vehicles.add(bus2);
		vehicles.add(bus3);
		vehicles.add(bus4);
		vehicles.add(truck1);
		vehicles.add(truck2);
		vehicles.add(truck3);
		vehicles.add(truck4);
	}

	public void system_start() {// 系统启动函数
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		if (j == 0) {// if里的字段只执行一次
			System.out.println("欢迎使用汽车租赁系统 Rev1.0");
			System.out.println("Powered by Jarvis,2020.10.21");
			for (i = 0; i < 20; i++)
				System.out.print("-");
			System.out.print("\n");
			System.out.print("请输入您的姓名:");
			name = input.next();// 姓名
			j = 1;
		}
		System.out.print("请输入租赁天数：");
		days = input.nextInt();// 租赁天数
		System.out.print("请输入要租赁的汽车类型(1.轿车 2.客车 3.卡车):");
		mtype = input.next();// 汽车类型
	}

	public void trolly() {// 打印购物清单
		for (i = 0; i < 20; i++)
			System.out.print("-");
		System.out.print("\n");
		System.out.println("您的订单如下:");
		System.out.println("[序号]\t[汽车牌号]\t[汽车类型]\t[汽车品牌]\t[汽车型号]\t[租赁天数]\t[租金]");
		for (i = 0; i < orders.size(); i++) {// 遍历Arraylist的对象orders，orders里存储用户的所有订购信息
			Customer person = (Customer) orders.get(i);
			totalrent = totalrent + person.getMoney();// 计算总租金
			System.out.printf("  %-8d%-15s%-15s%-12s%-18s%-15d%-8d\n", i + 1, person.getNo(), person.getMtype(),
					person.getBrand(), person.getType(), person.getDays(), person.getMoney());
		}
		System.out.println("\n" + "客户名：" + name + ",租赁总租金" + totalrent);// 打印客户名和总租金
	}

	public void menu() {// 系统菜单函数
		char cycle = 1, confirm = 0;// cycle、confirm共同控制同一客户租赁多个汽车的循环
		vehicle_init();// 汽车库初始化
		while (cycle == 1) {
			system_start();
			if ("1".equals(mtype)) {// 选择的是轿车,执行轿车输入函数
				car.input(brand, mtype, money, days, vehicles, orders, p1);
			} else if ("2".equals(mtype)) {// 选择的是客车,执行客车输入函数
				bus.input(brand, mtype, money, days, vehicles, orders, p1);
			} else {// 选择的是卡车,执行卡车输入函数
				truck.input(brand, mtype, money, days, vehicles, orders, p1);
			}
			System.out.println("请问还要继续租赁汽车么?(y OR press any key to exit)");// 输入y继续，输入其他循环
			@SuppressWarnings("resource")
			Scanner input1 = new Scanner(System.in);
			confirm = input1.next().charAt(0);
			if (confirm != 'y') {
				cycle = 0;
			} else {
				p1 = new Customer();// 选择继续租赁后,重新开辟空间,新建Customer类的对象p1,为接下来的信息录入做准备
			}
		}
		trolly();// 打印购物车
	}
}
