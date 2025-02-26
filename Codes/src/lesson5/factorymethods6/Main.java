package lesson5.factorymethods6;
import java.util.*;

import lesson5.factorymethods6.otherpackage.DataRecord;
import lesson5.factorymethods6.otherpackage.Database;
import lesson5.factorymethods6.studreport.GradeReport;
import lesson5.factorymethods6.studreport.StudentAndReport;
import lesson5.factorymethods6.studreport.StudentGradeReportFactory;


public class Main {

	public static void main(String[] args) {
		//two setters
		printTopStudents();
		
			
		
	}
	public static void printTopStudents() {
		Collection<DataRecord> data = Database.h.values();
		List<GradeReport> reports = new ArrayList<>();
		for(DataRecord d : data) {
			StudentAndReport sr 
			  = StudentGradeReportFactory
			      .createStudentAndReport(d.getName(), d.getGrade());
			reports.add(sr.getReport());	
		}
		
		Collections.sort(reports);
		Iterator<GradeReport> it = reports.iterator();
		System.out.println("A Students:");
		GradeReport next = null;
		while((next =it.next()) != null && next.getGrade().equals("A")) {
			System.out.print(next.getStudent().getName() + " ");
		}
	}
	

}
