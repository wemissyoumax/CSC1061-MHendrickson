
public class Address implements Cloneable {
	
	public String street;
	public String city;
	public String state;
	public long zip;
	
	public Address clone() throws CloneNotSupportedException {
		Address clone = (Address) super.clone();
		return clone; 
	}
}
