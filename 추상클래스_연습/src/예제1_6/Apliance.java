package 예제1_6;

public abstract class Apliance {
	// 필드
	protected String brand;
	protected boolean isPowerOn;

	// 생성자
	public Apliance(String brand) {
		this.brand = brand;
		isPowerOn = false;
	}

	// 매서드들
	public void turnOn() {
		isPowerOn = true;
		System.out.println(brand + "의 전원을 켭니다.");
	}

	public abstract void operate(); // 추상 매서드, 자식에서 내용을 재정의한다.

}
