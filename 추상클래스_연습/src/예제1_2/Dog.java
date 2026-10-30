package 예제1_2;

public class Dog extends Animal {

	// 생성자
	public Dog(String name) {
		super(name);
	}

	@Override
	public void sound() {
		System.out.println(name + ": 멍멍");
	}

}
