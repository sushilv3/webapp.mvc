package com.kodecamp.student;

import java.util.ArrayList;
import java.util.List;

import com.kodecamp.student.db.Student;

public class StudentBussinessObject {
	public StudentBussinessObject() {
		
	}
	  public List<Student> fetchAll() {
		    List<Student> students = new ArrayList<>();
		    students.add(new Student("abc001", "ABC", "XYZ", "CVB001"));
		    students.add(new Student("Su123", "Sushil Kumar Verma", "Lucknow", "sar001"));
		    students.add(new Student("Anu456", "Anurag Gupta", "Kanpur", "bbd001"));
		    students.add(new Student("Man789", "Manish Rajbhar", "Bihar", "azd001"));
		    return students;
		  }
}
