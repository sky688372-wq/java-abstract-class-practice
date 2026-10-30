package 예제1_7;

public abstract class Empolyee {
	String name;
	 int id;
	
	public Empolyee(String name, int id) {
		this.name = name;
		this.id= id;
	}
	
	// 추상 매서드
	abstract int calculateSalry();
	
	void work() {
		System.out.println("사원본호:" + id + ", 사원명: " + name + " 사원이 업무를 시작합니다.");
	}
	
}
