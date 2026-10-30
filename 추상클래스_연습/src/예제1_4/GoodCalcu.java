package 예제1_4;

public class GoodCalcu extends Calculator{
	
	// 더하기 매서드
	@Override
	public void add(int n1, int n2) {
		System.out.println(n1 + "와 " + n2 + "의 덧셈 결과 = " + n1 + n2);
	}
	
	// 빼기 매서드
	@Override
	public void subtrack(int n1, int n2) {
		System.out.println(n1 + "와 " + n2 + "의 뺄셈 결과 = " + (n1 - n2));		
	}
	
	// 평균 매서드 : 가변인자로 어떤 인자들이 들어올지 모르니 가변 변수 선언
	@Override
	public void average(int... nums) {
		int sum = 0;
		// 각 수를 덧셈하는 로직
		for (int i : nums) {
			sum += i;
		}
		
		//출력 문에서 소수점이 정해져 있었으므로 포매팅을 하여 출력한다.
		System.out.printf("평균 = %.2f\n", (double)sum / nums.length);
		//계산 과정에서 정수가 되지 않도록 한 쪽을 강제 형변환하기
		// - 포매팅 형식은 꼭 기억하기
	}
	
	//시작점
	public static void main(String[] args) {
		GoodCalcu c = new GoodCalcu();
		//여기서 업 캐스팅을 해도 매서드들을 전부 재정의를 해놨기에 자식의 오버라이딩된 매서드가 실행된다.
		
		c.add(2, 3);	
		c.subtrack(2, 3);
		c.average(1,2,3,4,5,6);
		
	}
}
