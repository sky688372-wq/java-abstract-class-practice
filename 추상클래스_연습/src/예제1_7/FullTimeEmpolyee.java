package 예제1_7;

public class FullTimeEmpolyee extends Empolyee {
	// 필드
	int baseSalary;
	int bouns;

	public FullTimeEmpolyee(String name, int id, int baseSalary, int bouns) {
		super(name, id);
		this.baseSalary = baseSalary;
		this.bouns = bouns;
	}

	@Override
	int calculateSalry() {
		return baseSalary + bouns;
	}

}
