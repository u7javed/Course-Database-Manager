package course;

public class Grade {
	
	String name;
	double grade;
	double weight;
	
	public Grade(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	//setters and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	

}
