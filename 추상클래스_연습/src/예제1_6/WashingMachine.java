package 예제1_6;

public class WashingMachine extends Apliance {

	// 생성자
	public WashingMachine(String brand) {
		super(brand);
	}

	@Override
	public void operate() {
		if (isPowerOn) {
			System.out.println(brand + " 세탁기가 빨래를 시작합니다.");
			System.out.println("빨래가 완료되었습니다.");
		} else {
			System.out.println("전원을 켜주세요.");
		}
	}
}
