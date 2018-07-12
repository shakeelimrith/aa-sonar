package com.accenture.academy.buildandunittest.assignment.studentview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.accenture.academy.buildandunittest.assignment.student.StudentBean;
import com.accenture.academy.buildandunittest.assignment.util.WebUtils;
import com.accenture.academy.buildandunittest.assignment.utils.FileUtils;
import com.accenture.academy.buildandunittest.assignment.utils.GradeCalculatorUtils;

@ManagedBean(name = "studentViewManagedBean")
@SessionScoped
public class StudentViewManagedBean {

	/** List of students. */
	private List<StudentBean> list;

	@ManagedProperty(value = "#{commonUtils}")
	private WebUtils util;

	public void setUtil(WebUtils util) {
		this.util = util;
	}

	@PostConstruct
	public void init() {
		list = new ArrayList<StudentBean>();
	}

	public void refreshStudentLists() {
		init();
		String realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/students/students.csv");

		File studentFile = new File(realPath);
		String line = null;

		if (studentFile.exists() && FileUtils.isCsvFile(realPath)) {
			boolean isFirstLine = true;
			try(BufferedReader br = new BufferedReader(new FileReader(studentFile))) {
				
				while ((line = br.readLine()) != null) {
					// We skip the 1st line.
					if (isFirstLine) {
						isFirstLine = false;
						continue;
					}
					final String[] oneLine = FileUtils.splitFile(line, ";");

					list.add(computeStudentGrade(oneLine));
				}
			} catch (IOException e) {
				// Do nothing
			} 
		}

		util.redirectWithGet();
	}

	private StudentBean computeStudentGrade(String[] oneLine) {
		final StudentBean studentBean = new StudentBean();
		if (oneLine.length == 5) {
			final Integer studentId = Integer.valueOf(oneLine[0]);
			String fName = oneLine[1];
			if (fName.isEmpty()) 
				fName = "No Name";
			
			final String lName = oneLine[2];

			final Double assignmentMarks = new BigDecimal(oneLine[3]).doubleValue();
			final Double examsMarks = new BigDecimal(oneLine[4]).doubleValue();

			final Double totalMarks = GradeCalculatorUtils.calculateTotalGrade(assignmentMarks, examsMarks);

			final Character grade = GradeCalculatorUtils.computeGrade(totalMarks);

			studentBean.setStudentId(studentId);
			studentBean.setStudentFirstName(fName);
			studentBean.setStudentLastName(lName);
			studentBean.setAssignmentMarks(assignmentMarks);
			studentBean.setExamsMarks(examsMarks);
			studentBean.setTotalMarks(totalMarks);
			studentBean.setGrade(grade);

		}
		return studentBean;
	}

	/**
	 * Getter for list.
	 * 
	 * @return the list
	 */
	public final List<StudentBean> getList() {
		return list;
	}

}
