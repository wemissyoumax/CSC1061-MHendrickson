
public class TestGeometricObject {

	public static void main(String[] args) {
		
		Circle cir1 = new Circle("green", true, 2.0);
		System.out.println("Area of cir1: " + cir1.getArea());
		
		int radius = 5;
		System.out.println("A circle with radius " + radius +
				 "will have area " + Circle.getArea(5));
		
		Rectangle rec1 = new Rectangle ("Red", true, 2.0, 3.0);
		System.out.println("Perimeter = " + rec1.getPerimeter());
		
		Database db = new Database();
		db.write(cir1);
		GeometricObject ob = db.readObject();
		System.out.println(ob);
//		db.write(rec1);
	}

}
