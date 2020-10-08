package Rent_car_system;

public final class Bus extends Vehicle {// 类的优化设计，将客车设计为final类，不允许有子类
	private int seatcount;

	public Bus(String no, String brand,int seatcount) {
		super(no,brand);
		this.seatcount = seatcount;
	}

	public int getSeatcount() {
		return seatcount;
	}

	public void setSeatcount(int seatcount) {
		this.seatcount = seatcount;
	}

	public Bus() {// 子类轿车类的无参构造函数

	}

	public int calrent(int days) {// 对父类的方法重写
		if (seatcount <= 16) {
			return days * 800;
		} else {
			return days * 1500;
		}
	}
}
