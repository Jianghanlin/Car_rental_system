package Rent_car_system;

public final class Truck extends Vehicle {
	private int tone;

	public Truck() {// 子类卡车类的无参构造函数

	}

	public Truck(String no, String brand, int tone) {
		super(no, brand);
		this.tone = tone;
	}

	public int gettone() {
		return tone;
	}

	public void settone(int tone) {
		this.tone = tone;
	}

	public int calrent(int days) {// 对父类的方法重写
		return tone * days * 50;
	}
}
