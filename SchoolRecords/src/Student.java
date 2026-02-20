
public class Student extends Person {
	private String status;
	
	public Student() {
		
	}
	
	public Student(String name, String address, String phoneNumber,
			String email, String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "\nStatus: " + status;
	}
	
	
}
