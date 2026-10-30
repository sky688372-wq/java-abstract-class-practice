package 예제1_7;

public class PartTimeEmpolyee extends Empolyee{
	// 필드
	int hourRate;
	int workingHours;
	
	// 생성자
	public PartTimeEmpolyee(String name, int id, int hourRate, int workingHours) {
		super(name, id);
		this.hourRate = hourRate;
		this.workingHours = workingHours;
	}
	
	@Override
	int calculateSalry() {
		return hourRate * workingHours;
	}
}
