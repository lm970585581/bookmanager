package smn.vo;

import java.util.Date;

public class Student {
	private String readerId;
	private String name;
	private String spec;
	private boolean sex;
	private Date born;
	private int num;// ΩË È¡ø
	private int snum;// ø‚¥Ê¡ø
	private byte[] photo;

	public Student(String readerId, String name, boolean sex,
			java.sql.Date born, String spec, int num, byte[] photo) {
		super();
		this.readerId = readerId;
		this.name = name;
		this.spec = spec;
		this.sex = sex;
		this.born = born;
		this.num = num;
		this.photo = photo;
	}

	public String getReaderId() {
		return readerId;
	}

	public void setReaderId(String readerId) {
		this.readerId = readerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public Date getBorn() {
		return born;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getSnum() {
		return snum;
	}

	public void setSnum(int snum) {
		this.snum = snum;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}
