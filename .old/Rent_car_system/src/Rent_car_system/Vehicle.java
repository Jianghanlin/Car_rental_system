/*
 * Author：Jarvis
 * Date：2020.10.21
 * Class：17电子信息工程1 
 * Num：Xb17610107
*/

/*
 * Description：父类汽车类
 * 
*/
package Rent_car_system;

import java.util.List;

public abstract class Vehicle {// 父类Vehicle
	private String no;// 汽车牌号
	private String brand;// 汽车品牌
	private String mtype;// 汽车类型
	private int state;// 租赁状态

	public Vehicle() {// 父类的无参构造函数

	}

	public Vehicle(String no, String brand, String mtype, int state) {// 父类的有参构造函数
		this.no = no;
		this.brand = brand;
		this.mtype = mtype;
		this.state = state;
	}

	public String getMtype() {
		return mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void input(String brand, String mtype, int money, int days, List<Vehicle> vehicles, List<Customer> orders,
			Customer obj1) {// 父类的input函数，没有函数体，被继承的子类重写
	}

	public void print() {

	}

	public abstract int calrent(int days);

}
