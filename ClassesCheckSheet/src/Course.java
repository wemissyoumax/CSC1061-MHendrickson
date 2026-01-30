
public class Course {
	
	String courseName;
	double numStudents;
	double maxStudents;
	float numCredits;
	
	public Course(String courseName, double numStudents, double maxStudents, float numCredits) {
		super();
		this.courseName = courseName;
		this.numStudents = numStudents;
		this.maxStudents = maxStudents;
		this.numCredits = numCredits;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getNumStudents() {
		return numStudents;
	}

	public void setNumStudents(double numStudents) {
		this.numStudents = numStudents;
	}

	public double getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(double maxStudents) {
		this.maxStudents = maxStudents;
	}

	public float getNumCredits() {
		return numCredits;
	}

	public void setNumCredits(float numCredits) {
		this.numCredits = numCredits;
	}

	@Override
	public String toString() {
		return "Course = " + courseName + 
				"\n Number of Students = " + numStudents + 
				"\n Maximum Number of Students = " + maxStudents
				+ "\n Number of Credits = " + numCredits;
	}
	
	
}
