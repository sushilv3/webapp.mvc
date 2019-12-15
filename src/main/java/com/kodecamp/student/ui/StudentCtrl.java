/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kodecamp.student.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kodecamp.commons.ui.Message;
import com.kodecamp.commons.ui.MessageUtil;
import com.kodecamp.student.db.Student;

/**
 *
 * @author kcamp
 */
public class StudentCtrl {

	public StudentCtrl() {
		System.out.println("Constructor : StudentCtrl");

	}

	private static final String viewPathPrefix = "/views/student";
	// session scope
	private final List<UIStudent> studentList = new ArrayList<>();

	public String list(final HttpServletRequest request, final HttpServletResponse response) {
		System.out.println("Student list metho called:::::::::::::::::");
		final String contextPath = request.getContextPath();
		if (this.studentList.isEmpty()) {
			this.studentList.addAll(createDummyList(request, response));
		}
		
		this.studentList.addAll(fatchStudents(request, response));
		return StudentCtrl.viewPathPrefix + "/student_list.jsp";
	}

	private List<UIStudent> fatchStudents(final HttpServletRequest request, final HttpServletResponse response) {
		System.out.println("fatchStudents called------------------------");
		this.studentList.removeAll(studentList);
		List<UIStudent> students = createDummyList(request, response);
		final String regNo = request.getParameter("regNo");
		List<UIStudent> filteredStudennts = students.stream()
				.filter(uiStudent -> uiStudent.getStudent().getCollRegNo().equals(regNo)).collect(Collectors.toList());
		return filteredStudennts;
	}
	public String allstudent(final HttpServletRequest request, final HttpServletResponse response) {
		System.out.println("Show all student method called : ");
		if (this.studentList.isEmpty()) {
			this.studentList.addAll(createDummyList(request, response));
		}
		return StudentCtrl.viewPathPrefix + "/student_list.jsp";
	}
	private List<UIStudent> createDummyList(final HttpServletRequest request, final HttpServletResponse resp) {
		
		final String contextPath = request.getContextPa)th();
		final List<UIStudent> dummyStudents = new ArrayList<>();
		final UIStudent student1 = new UIStudent(new Student("Su123", "Sushil Kumar Verma", "Lucknow", "sar001"),
				contextPath);
		student1.setDeleteUrl(resp.encodeURL(student1.getDeleteUrl()));
		student1.setUpdateUrl(resp.encodeURL(student1.getUpdateUrl()));

		final UIStudent student2 = new UIStudent(new Student("Anu456", "Anurag Gupta", "Kanpur", "bbd001"),
				contextPath);
		student2.setDeleteUrl(resp.encodeURL(student1.getDeleteUrl()));
		student2.setUpdateUrl(resp.encodeURL(student1.getUpdateUrl()));

		final UIStudent student3 = new UIStudent(new Student("Man789", "Manish Rajbhar", "Bihar", "azd001"),
				contextPath);
		student3.setDeleteUrl(resp.encodeURL(student3.getDeleteUrl()));
		student3.setUpdateUrl(resp.encodeURL(student3.getUpdateUrl()));

		dummyStudents.add(student1);
		dummyStudents.add(student2);
		dummyStudents.add(student3);
		return dummyStudents;
	}

//	public static List<Student> students() {
//		final List<Student> students = new ArrayList<>();
//		Student student = new Student("abc001", "ABC", "XYZ", "NJI Inst.","CVB001");
//		Student student1 = new Student("Su123", "Sushil Kumar Verma", "Lucknow", "sar001");
//		Student student2 = new Student("Anu456", "Anurag Gupta", "Kanpur", "bbd001");
//		Student student3 = new Student("Man789", "Manish Rajbhar", "Bihar", "azd001");
//		students.add(student);
//		students.add(student1);
//		students.add(student2);
//		students.add(student3);
//		return students;
//	}

	public String addform(final HttpServletRequest request, final HttpServletResponse response) {
//    this.rollNo = "20";
		return "/views/student/add_form.jsp";
	}

	public String addnew(final HttpServletRequest request, final HttpServletResponse response) {
		MessageUtil.setMessages(request, new Message(Message.MSG_TYPE_ERROR, "Sample Message"),
				new Message(Message.MSG_TYPE_INFO, "Sample Message"));
		return "/student/addform";
	}

	public List<UIStudent> getStudentList() {
		return studentList;
	}

	@Override
	public String toString() {
		return "StudentCtrl [studentList=" + studentList + "]";
	}

}
