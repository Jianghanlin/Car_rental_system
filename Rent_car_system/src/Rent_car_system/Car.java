package Rent_car_system;

public final class Car extends Vehicle {// 类的优化设计，将轿车设计为final类，不允许有子类
	private String type;

	public Car() {// 子类轿车类的无参构造函数

	}

	public Car(String no, String brand, String type) {
		super(no, brand);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int calrent(int days) {// 对父类的方法重写
		if ("1".equals(type)) {
			return days * 500;
		} else if ("2".equals(type)) {
			return days * 600;
		} else {
			return days * 300;
		}
	}
}
