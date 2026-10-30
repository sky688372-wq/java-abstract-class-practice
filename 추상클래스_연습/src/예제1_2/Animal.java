package 예제1_2;

public abstract class Animal {
	public String name;
	
	public Animal(String name) {
		this.name = name;
	}
	
	public void breath() {
		System.out.println(name + "가(이) 숨을 쉰다.");
	}
	
	public abstract void sound(); // 추상 클래스 선언
}
