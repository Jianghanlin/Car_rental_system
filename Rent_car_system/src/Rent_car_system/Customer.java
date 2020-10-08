package Rent_car_system;

public class Customer {
	String id;
	String name;

	public Customer(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int cal_total_rent(Vehicle motos[], int days) {
		int sum = 0;
		for (int i = 0; i < motos.length; i++) {
			if (motos[i] == null)
				break;
			else {
				sum += motos[i].calrent(days);
			}
		}
		return sum;
	}
}
