
public class Manager extends Employee {
	private String department;
	
	public Manager(int id, String fname, String lname, String department) {
		super(id, fname, lname);
		this.department = department;
	}
	
	public void setDepartment(String dept) {
		this.department = dept;
	}
	public String getDepartmnet() {
		return this.department;
	}
	
	@Override
	public void employeeSummary() {
//		super.employeeSummary();
		System.out.printf("ID: %s | %s %s | Salary: %s", 
				this.employeeId, this.firstName, this.lastName, this.salary);
		System.out.printf(" | Department: %s\n", this.department);
	}
}
