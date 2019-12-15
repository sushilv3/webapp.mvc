package com.kodecamp.student.db;

import java.io.Serializable;

/**
 *
 * @author kcamp
 */
public class Student implements Serializable {
	private String rollNo;
	private String name;
	private String address;
	private String collRegNo;

	public Student(String rollNo) {
		this.rollNo = rollNo;
		
	}

	public Student(final String rollNo,  final String name, final String address,final String collRegNo) {
		this.rollNo = rollNo;
		this.name = name;
		this.address = address;
		this.collRegNo = collRegNo;
	}

	public String getRollNo() {
		return rollNo;
	}

	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}

	
	public String getCollRegNo() {
		return collRegNo;
	}

	
	public void setCollRegNo(String collRegNo) {
		 
		 System.out.println("%%%%%Student setCollRegNo : " + this.collRegNo);
		this.collRegNo = collRegNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rollNo == null) ? 0 : rollNo.hashCode());
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
		Student other = (Student) obj;
		if (rollNo == null) {
			if (other.rollNo != null)
				return false;
		} else if (!rollNo.equals(other.rollNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", address=" + address + ", collRegNo=" + collRegNo
				+ "]";
	}

	



}
