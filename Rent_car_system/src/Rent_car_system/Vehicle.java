/*
 * Author��Jarvis
 * Date��2020.10.21
 * Class��17������Ϣ����1 
 * Num��Xb17610107
*/

/*
 * Description������������
 * 
*/
package Rent_car_system;

import java.util.List;

public abstract class Vehicle {// ����Vehicle
	private String no;// �����ƺ�
	private String brand;// ����Ʒ��
	private String mtype;// ��������
	private int state;// ����״̬

	public Vehicle() {// ������޲ι��캯��

	}

	public Vehicle(String no, String brand, String mtype, int state) {// ������вι��캯��
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
			Customer obj1) {// �����input������û�к����壬���̳е�������д
	}

	public void print() {

	}

	public abstract int calrent(int days);

}
