package 예제1_6;

public class Test {
	public static void main(String[] args) {
		//업 캐스팅
		Apliance washer = new WashingMachine("LG 트롬");
		Apliance cleaner = new RobotCleaner("로보락");
		
		washer.operate();
		washer.turnOn();
		washer.operate();
		
		System.out.println(); // 줄바꿈용
		
		cleaner.turnOn();
		cleaner.operate();
	}
}
