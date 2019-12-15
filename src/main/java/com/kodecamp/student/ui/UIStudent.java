/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kodecamp.student.ui;

import java.io.Serializable;

import com.kodecamp.student.db.Student;

/**
 *
 * @author kcamp
 */
public class UIStudent implements Serializable {
	private static final long serialVersionUID = 1L;

	private final Student student;
	private String deleteUrl;
	private String updateUrl;
	private static String DELETE_URL = "/student/delete.xhtml?rollNo=%s";
	private static String UPDATE_URL = "/student/updateform.xhtml?rollNo=%s";

//	public UIStudent() {
//		this.student=null;
//	
//				
//	}
	public UIStudent(final Student student, final String contextPath) {
		this.student = student;
		this.deleteUrl = String.format(contextPath + DELETE_URL, student.getRollNo());
		this.updateUrl = String.format(contextPath + UPDATE_URL, this.student.getRollNo());
	}
	
	public Student getStudent() {
		return student;
	}

	public String getUpdateUrl() {
		return updateUrl;
	}

	public String getDeleteUrl() {
		return deleteUrl;
	}

	public void setDeleteUrl(String deleteUrl) {
		this.deleteUrl = deleteUrl;
	}

	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((student == null) ? 0 : student.hashCode());
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
		UIStudent other = (UIStudent) obj;
		if (student == null) {
			if (other.student != null)
				return false;
		} else if (!student.equals(other.student))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UIStudent [student=" + student + "]";
	}

}
