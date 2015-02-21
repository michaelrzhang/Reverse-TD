package src.shape;

public class OverlapTest{
	public static void main(String[] args){
		Circle c1 = new Circle(2,2,2);
		Circle c2 = new Circle(5,5,2);
		System.out.println(Shape.overlaps(c1, c2));
		Circle c3 = new Circle(2,2,2);
		Circle c4 = new Circle(5.999,5.999,2);
		System.out.println(Shape.overlaps(c3, c4));
		Circle c5 = new Circle(2,2,2);
		Circle c6 = new Circle(6.01,6.01,2);
		System.out.println(Shape.overlaps(c5, c6));
	}
}