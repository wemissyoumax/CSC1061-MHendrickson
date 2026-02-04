
public class Rectangle extends GeometricObject {
	
	private double width;
	private double height;
	
	
	public Rectangle() {
		this.height = 3.0;
		this.width = 4.0;
	}
	
	public Rectangle(String color, boolean isFilled, double width, double height) {
		super(color, isFilled);
		this.height = height;
		this.width = width;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	//Methods
	public double getPerimeter() {
		return width + width + height + height;
	}
	
	public double calcArea(double width, double height) {
		return width * height;
	}

	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", getWidth()=" + 
	getWidth() + ", getHeight()="+ getHeight() + ", getColor()=" + getColor() + 
	", isFilled()=" + isFilled() + ", getDateCreated()="+ getDateCreated() + "]";
		
	}
	
	
	
}
