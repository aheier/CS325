
public class Employee {
	protected int employeeId;
	protected String firstName;
	protected String lastName;
	protected double salary;
	
	public Employee(int id, String fname, String lname) {
		this.employeeId = id;
		this.firstName = fname;
		this.lastName = lname;
		this.salary = 0d;		
	}
	
	public void employeeSummary() {
		System.out.printf("ID: %s | %s %s | Salary: %s\n", 
				this.employeeId, this.firstName, this.lastName, this.salary);
	}
	
	public void setId(int id) {
		this.employeeId = id;
	}
	public int getId() {
		return this.employeeId;
	}
	public void setFirstName(String fname) {
		this.firstName = fname;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setLastName(String lname) {
		this.lastName = lname;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getSalary() {
		return this.salary;
	}
	
}
