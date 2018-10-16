package exersize3;

public class ClassWithFields {
    @Save
    private String name = "Kostya";
    @Save
    private String gender = "Male";
    private String univer = "KPI";
    @Save
    private int age = 20;

    public ClassWithFields() {
        super();
    }

    public ClassWithFields(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ClassWithFields{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", univer='" + univer + '\'' +
                ", age=" + age +
                '}';
    }
}
