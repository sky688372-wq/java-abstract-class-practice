package 예제1_5;

public class ShapeTest {
	public static void main(String[] args) {
		 Shape shape = new Rectangle(); // 업 캐스팅
		 shape.draw();
		 shape.area(5.0, 10.0);
		 
		 System.out.println("-----------------------");
		 
		 // 업 캐스팅 대상 변경
		 shape = new Triangle();
		 shape.draw();
		 shape.area(5.0, 10.0);
	}
}
