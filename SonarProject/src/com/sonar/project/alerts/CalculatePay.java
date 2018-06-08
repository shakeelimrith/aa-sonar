package com.sonar.project.alerts;

public class CalculatePay {

	public int calculatePay(Employees emp, int pay, int raise, double percentage) {
		if (emp == null) {
			return 0;
		}

		if (emp != null) {
			if (emp.getId() == 0)
				return 0;
		}
		if (emp.getId() == 1) {
			if (emp.getName() == "shakeel") {
				pay = pay + raise;
			}
		}

		return pay;
	}

	public boolean isEmpGettingPay(Employees emp) {
		if (emp.getId() == 1) {
			return true;
		} else {
			return false;
		}
	}

	public int calculatePayDouble(Employees emp, int pay, int raise, double percentage) {

		if (emp != null) {
			if (emp.getId() == 0)
				return 0;
		}
		if (emp.getId() == 1) {
			if (emp.getName() == "shakeel") {
				pay = pay + raise;
			}
		}

		return pay;
	}

	public String empDeRef() {
		Employees emp = new Employees();

		if (emp != null) {
			return "";
		}
		return "test";
	}

}
