public class Student {
    private Double GPA;
    private String name;
    private String address;

    // Constructor
    public Student(Double GPA, String name, String address) {
        this.GPA = GPA;
        this.name = name;
        this.address = address;
    }

    public Double getGPA() {
        return GPA;
    }

    // Setter for GPA
    public void setStudentId(Double GPA) {
        this.GPA = GPA;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }
}