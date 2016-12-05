package bean;

import java.util.List;

public class User {
	private int ID;					//用户唯一标识id
	
	private String Username;		//用户名-登录名
	private String Password;		//密码
	
	private int Money;				//余额
	
	private String Sex;				//性别
	
	private int age;				//年龄
	
	private String userimaurl;		//头像url
	
	private List<Oder> Oderlist;	//用户的所有订单信息

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getMoney() {
		return Money;
	}

	public void setMoney(int money) {
		Money = money;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUserimaurl() {
		return userimaurl;
	}

	public void setUserimaurl(String userimaurl) {
		this.userimaurl = userimaurl;
	}

	public List<Oder> getOderlist() {
		return Oderlist;
	}

	public void setOderlist(List<Oder> oderlist) {
		Oderlist = oderlist;
	}
	
	
	
	
	
	
}
