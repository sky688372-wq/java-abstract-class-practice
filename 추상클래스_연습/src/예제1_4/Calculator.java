package 예제1_4;

public abstract class Calculator {
	public abstract void add(int n1, int n2);
	public abstract void subtrack(int n1, int n2);
	
	// 가변 인자값을 받도록 선언
	public abstract void average(int... nums);
}
