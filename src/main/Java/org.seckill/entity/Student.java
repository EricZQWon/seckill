package org.seckill.entity;

/**
 * Created by dell on 2018/5/18.
 */
public class Student {
	private long id;
	private String name;
	private String pwd;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Student{");
		sb.append("id=").append(id);
		sb.append(", name='").append(name).append('\'');
		sb.append(", pwd='").append(pwd).append('\'');
		sb.append('}');
		return sb.toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
