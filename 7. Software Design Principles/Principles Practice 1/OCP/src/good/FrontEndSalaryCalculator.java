package good;

public class FrontEndSalaryCalculator extends SalaryCalculator{

	private double salary;

	@Override
	public void calculator() {
		
		this.salary = 1000;
	}

	@Override
	public double getSalary() {
		return this.salary;
	}
}
