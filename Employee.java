package Code.JDK.Home_work.HW_4;

/*
Табельный номер
Номер телефона
Имя
Стаж
 */

public class Employee {
    int number;
    String phone;
    String name;
    int experience;

    public Employee(int number, String phone, String name, int experience) {
        this.number = number;
        this.phone = phone;
        this.name = name;
        this.experience = experience;
    }

    public int getNumber() {
        return number;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return  "\n Табельный номер = " + number + '\'' +
                ", Номер телефона = '" + phone + '\'' +
                ", Имя = '" + name + '\'' +
                ", Стаж = " + experience;
    }
}