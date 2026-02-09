
public abstract class Vehicle implements Feedable {
	private String vehicleColor;
	private long vehicleID;
	private String color;
	
	public Vehicle(String color, long id) {
		setVehicleColor(color);
		vehicleID = id;
	}
	
	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	public long getId() {
		return vehicleID;
	}
	public void setId(long id) {
		this.vehicleID = id;
	}
	
	public abstract double drive();
	
	@Override
	public String toString() {
		return "Vehicle [color=" + color + ", id=" + vehicleID + "]";
	}

	
}
