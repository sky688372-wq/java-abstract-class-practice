package 예제1_7;

public class Test {
	public static void main(String[] args) {
		Empolyee[] e = new Empolyee[2];
		e[0] = new FullTimeEmpolyee("강하늘", 123, 150, 300);
		e[1] = new PartTimeEmpolyee("진국화", 234, 100, 2); 
		
		for (Empolyee empolyee : e) {
			//공통 매서드 실행
			empolyee.work();
			System.out.println("급여: " + empolyee.calculateSalry() + "만원");
			
			if (empolyee instanceof FullTimeEmpolyee) {
				// 다운 캐스팅해서 자식의 필드에 접근
				FullTimeEmpolyee f = (FullTimeEmpolyee)empolyee;
				System.out.println("보너스: " + f.bouns + "만원");
				System.out.println();
			}
		}
	}
}
