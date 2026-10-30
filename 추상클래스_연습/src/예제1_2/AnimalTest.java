package 예제1_2;

public class AnimalTest {

	// 객체의 타입에 따라서 다른 매서드 실행
	public static void animalSound(Animal animal) {
		animal.sound();
	}

	public static void main(String[] args) {
		Animal an = new Dog("스누피"); // 업 캐스팅된 상태에서는 부모의 멤버와 자식에서 재정의된 매서드들만 사용 가능
		an.sound(); // 자식의 재정의 된 매서드 호출
		an.breath(); // 부모의 매서드 호출
		AnimalTest.animalSound(an); // 객체마다 Animal을 상속받았음으로 각 클래스에 있는 sound매서드 실행
		// Animal을 상속 받는 매서드들은 sound()를 재정의 해야함으로 자식의 재정의된 매서드가 실행된다.

		System.out.println(); // 줄바꿈용

		an = new Cat("토미"); // Cat 객체를 업 캐스팅
		an.sound();
		an.breath();
		AnimalTest.animalSound(an);

	}
}
