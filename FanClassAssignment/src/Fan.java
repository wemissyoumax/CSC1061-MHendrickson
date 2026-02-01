
public class Fan {
	
	public static final int Slow = 1;
	public static final int Medium = 2;
	public static final int Fast = 3;
	
	private int speed;
	private boolean on;
	private double radius;
	private String color;
	private int id;
	
	private static int nextId = 1;
	
	public Fan() {
		speed = Slow;
		radius = 5;
		color = "blue";
		id = nextId++;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public boolean isOn() {
		return on;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public String getColor() {
		return color;
	}
	
	public int getId() {
		return id;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;	
	}
	
	public void setOn(boolean on) {
		this.on = on;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		if (on) {
			return "Fan ID: " + id +
					", Speed: " + speed +
					", Color: " + color +
					", Radius: " + radius;
		} else {
			return "Fan ID: " + id +
					", Speed: " + speed +
					", Color: " + color +
					", Radius: " + radius +
					", fan is Off";
		}
	}
}
