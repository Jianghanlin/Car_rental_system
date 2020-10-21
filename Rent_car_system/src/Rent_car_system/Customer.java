/*
 * Author：Jarvis
 * Date：2020.10.21
 * Class：17电子信息工程1 
 * Num：Xb17610107
*/

/*
 * Description：购物车类
 * 
*/

package Rent_car_system;

public class Customer {
	String name;
	String no;
	String brand;
	String mtype;
	String type;
	int seatcount;
	int tone;
	int days;
	int money;

	public Customer(String name, String no, String brand, String mtype, String type, int seatcount, int tone, int days,
			int money) {
		super();
		this.name = name;
		this.no = no;
		this.brand = brand;
		this.mtype = mtype;
		this.type = type;
		this.seatcount = seatcount;
		this.tone = tone;
		this.days = days;
		this.money = money;
	}

	public int getTone() {
		return tone;
	}

	public void setTone(int tone) {
		this.tone = tone;
	}

	public Customer() {
	}

	public int getSeatcount() {
		return seatcount;
	}

	public void setSeatcount(int seatcount) {
		this.seatcount = seatcount;
	}

	public String getMtype() {
		return mtype;
	}

	public void setMtype(String mtype) {
		this.mtype = mtype;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
