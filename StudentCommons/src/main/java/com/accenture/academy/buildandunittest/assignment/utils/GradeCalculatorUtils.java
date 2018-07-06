package com.accenture.academy.buildandunittest.assignment.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.commons.math.util.FastMath;

import com.accenture.academy.buildandunittest.assignment.enumerations.GradeEnum;

public final class GradeCalculatorUtils {

	/**
	 * Computes the marks (40% of assignment and 60% of exams).
	 * 
	 * @param assignmentMarks
	 *            Assignment marks.
	 * @param examsMarks
	 *            Exams marks
	 * @return The total marks
	 */
	
	 private GradeCalculatorUtils() {
	throw new IllegalStateException("Utility class");
	}
	
	public static Double calculateTotalGrade(Double assignmentMarks, Double examsMarks) {
		if (assignmentMarks == null || examsMarks == null) {
			return Double.valueOf(0.0);
		}

		return computeMark(assignmentMarks, 0.4, false) + computeMark(examsMarks, 0.6, false);

	}

	/**
	 * Computes the marks.
	 * 
	 * @param mark
	 *            The mark
	 * @param percentage
	 *            The percentage
	 * @param giveAdditionalMarks
	 *            True if we do a ceil to give more marks. False if not
	 * @return The total marks
	 */
	public static Double computeMark(Double mark, Double percentage, boolean giveAdditionalMarks) {
		giveAdditionalMarks = false;
		if (mark == null || percentage == null) {
			return Double.valueOf(0.0);
		}

		if (giveAdditionalMarks) {
			return FastMath.ceil(mark * percentage);
		}
		final BigDecimal total = new BigDecimal(mark * percentage);
		
		return total.setScale(1, RoundingMode.CEILING).doubleValue();
	}

	public static Character computeGrade(Double totalMarks) {
		Character grade = 'F';
		if (isValueBetween(totalMarks, GradeEnum.A.getMinMarks(), GradeEnum.A.getMaxMarks())) {
			grade = 'A';
		} else if (isValueBetween(totalMarks, GradeEnum.B.getMinMarks(), GradeEnum.B.getMaxMarks())) {
			grade = 'B';
		} else if (isValueBetween(totalMarks, GradeEnum.C.getMinMarks(), GradeEnum.C.getMaxMarks())) {
			grade = 'C';
		} else if (isValueBetween(totalMarks, GradeEnum.F.getMinMarks(), GradeEnum.F.getMaxMarks())) {
			grade = 'F';
		}
		return grade;

	}

	/**
	 * Checks if value is between 2 values.
	 * 
	 * @param valueToCheck
	 *            The value to check
	 * @param minBoundary
	 *            The min value
	 * @param maxBoundary
	 *            The max value
	 * @return True if between
	 */
	public static boolean isValueBetween(Double valueToCheck, int minBoundary, int maxBoundary) {
		final Double minBoundaryDouble = Double.valueOf((double) minBoundary);
		final Double maxBoundaryDouble = Double.valueOf((double) maxBoundary);
		if (maxBoundary == 100) {
			return valueToCheck >= minBoundaryDouble && valueToCheck <= maxBoundaryDouble;
		}

		return valueToCheck >= minBoundaryDouble && valueToCheck < maxBoundaryDouble;
	}

}
