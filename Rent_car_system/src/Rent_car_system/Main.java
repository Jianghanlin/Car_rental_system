package Rent_car_system;

public class Main {

	public static void main(String[] args) {
		int days=0;// 租赁天数
		int totalrent=0;// 总租金费用
		// 1、客户租赁的多辆汽车信息和租赁天数
		Vehicle motos[] = new Vehicle[4];
		motos[0] = new Car("浙0000", "宝马", "550i");
		motos[1] = new Car("浙0001", "宝马", "550i");
		motos[2] = new Car("浙0002", "别克", "林荫大道");
		motos[3] = new Bus("浙0003", "金龙", 34);
		days = 5;
		// 2、计算总租赁费用
		Customer customer = new Customer("Xb17610107", "江瀚林");
		totalrent = customer.cal_total_rent(motos, days);
		// 输出客户姓名和总租赁费用
		System.out.println("汽车牌号\t\t汽车品牌");

		for (int i = 0; i < motos.length; i++) {
			if (motos[i] == null)
				break;
			else {
				System.out.println(motos[i].getNo() + "\t\t" + motos[i].getBrand());
			}
		}
		System.out.println("\n客户名:" + customer.getName() + ",租赁天数" + days + ",租赁费用" + totalrent + ".");
		/*
		 * // TODO Auto-generated method stub Vehicle_Manager s1 = new
		 * Vehicle_Manager(); s1.menu();
		 */
	}

}
