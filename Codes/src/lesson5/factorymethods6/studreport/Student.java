package lesson5.factorymethods6.studreport;


//Outsisde of studreport package, Student is immutable
//Immutability in this case depends on the fact that GradeReport is immutable
final public class Student {
	private GradeReport report;
	private String name;
	
	//package level access
	Student(String nm) {
		name = nm;
	}
	public String getName() {
		return name;
	}
	//package level access
	void setReport(GradeReport report) {
		this.report = report;
	}
	public GradeReport getReport() {
		return report;
	}
}
