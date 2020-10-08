package Rent_car_system;

public abstract class Vehicle {//类的优化设计，将汽车设计为抽象类，不允许实例化
	private String no;
	private String brand;

	public Vehicle() {// 父类汽车的无参构造函数

	}

	public Vehicle(String no, String brand) {
		this.no = no;
		this.brand = brand;
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

	public abstract int calrent(int days);

}
