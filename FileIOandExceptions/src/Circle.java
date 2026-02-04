
public class Circle extends GeometricObject {
	
	public double radius;
	
	
	public Circle() {
		this.radius = 1.0;
	}
	
	public Circle(String color, boolean isFilled, double radius) {
		super(color, isFilled);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	//Methods
	public double getArea() {
		return Math.PI * radius * radius;
	}
	
	public double modifyRadius(int modifier) {
		radius = radius * modifier;
		return radius;
	}
	
	public static double getArea(int radius) {
		return Math.PI *radius * radius;
	}
	
	public double getCircumference () {
		return 2 * Math.PI * radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", getColor()=" + getColor() + 
				", isFilled()=" + isFilled() + ", getDateCreated()=" 
				+ getDateCreated() + "]";
	}
	
	
	
}
