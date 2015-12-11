package cn.com.study.jdk.annotation;


public class User {
	@RequestMapping(required=true, regex="^[a-zA-Z]+$")
	private String name;
	@RequestMapping(required=true)
	private int age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}