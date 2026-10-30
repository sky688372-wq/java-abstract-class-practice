package 예제1_5;

public class Rectangle extends Shape {
	@Override
	public void draw() {
		System.out.println("사각형 그리기");
	}
	
	@Override
	public void area(double row, double colum) {
		System.out.printf("사각형의 넓이: %.2f\n", row * colum);
	}
}
