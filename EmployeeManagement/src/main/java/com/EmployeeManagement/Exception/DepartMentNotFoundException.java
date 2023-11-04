package com.EmployeeManagement.Exception;

public class DepartMentNotFoundException extends RuntimeException {
  public DepartMentNotFoundException(String msg) {
	  super(msg);
  }
}
