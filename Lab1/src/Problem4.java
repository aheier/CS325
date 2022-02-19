
public class Problem4 {
	public static void main(String[] args) {
	
	Manager m1 = new Manager(1, "Anthony", "Heier", "CS");
	Manager m2 = new Manager(2, "Caleb", "Gundberg", "CS");
	Manager m3 = new Manager(2, "Susan", "Peterson", "CS");
	m3.setSalary(234234.32);
	m3.setDepartment("Math");
	m3.setId(3);
	
	m1.employeeSummary();
	m2.employeeSummary();
	m3.employeeSummary();
	
	}
}
