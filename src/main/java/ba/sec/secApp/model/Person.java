package ba.sec.secApp.model;

import java.io.Serializable;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class Person implements Serializable{

	private static final long serialVersionUID = 1305729481143211000L;
	
	@NotEmpty(message="name is reqired")
	private String name;
	
	@NotEmpty(message="Email is reqired")
	@Email(message="Email is reqired")
	private String email;
	
	//@NotEmpty(message="Age is reqired")
	//@Max(value=99L,message="maximun value is 99")
	//@Min(value = 1L, message = "The value must be positive")
	private int age ;
	
	public Person(){}
	
	public Person(String name, String email, int age) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

	
	
}
