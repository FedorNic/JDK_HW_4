package Code.JDK.Home_work.HW_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Создать класс справочник сотрудников, который содержит внутри коллекцию сотрудников,
каждый сотрудник должен иметь следующие атрибуты:
Табельный номер
Номер телефона
Имя
Стаж
Добавить метод, который ищет сотрудника по стажу (может быть список)
Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
Добавить метод, который ищет сотрудника по табельному номеру
Добавить метод добавление нового сотрудника в справочник сотрудников
 */

public class EmployeeDirectory {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee(1, "+79602616322", "Федор", 13),
                new Employee(2, "+79522406608", "Алеся", 9),
                new Employee(3, "+79092115617", "Василий", 9),
                new Employee(4, "+79214873222", "Михаил", 20),
                new Employee(5, "+79602673421", "Антон", 15)));
        System.out.println();
        System.out.println("Список всех сотрудников в справочнике");
        System.out.println("-----------------------------------------");
        System.out.println(employees.toString().replace("[", "").replace("]", ""));

        System.out.println();
        System.out.println("Список сотрудников в справочнике со стажем 9 лет");
        System.out.println("-----------------------------------------");
        System.out.println(findEmployeeByExperience(employees, 9).toString().replace("[", "").replace("]", ""));

        System.out.println();
        System.out.println("Список сотрудников в справочнике по имени Федор");
        System.out.println("-----------------------------------------");
        printPhoneNumberByEmployeeName(employees, "Федор");

        System.out.println();
        System.out.println("Список сотрудников в справочнике с табельным номером 4");
        System.out.println("-----------------------------------------");
        System.out.println(findEmployeeByJobNumber(employees, 4));

        System.out.println();
        addEmployeeToList(employees);

        System.out.println();
        System.out.println("Список сотрудников в справочнике после добавления");
        System.out.println("-----------------------------------------");
        System.out.println(employees.toString().replace("[", "").replace("]", ""));
    }

    /**
     * Метод, который ищет сотрудника по стажу
     *
     * @param staff      - список сотрудников
     * @param experience - стаж
     * @return - отфильтрованный список сотрудников
     */
    static List<Employee> findEmployeeByExperience(List<Employee> staff, int experience) {
        List<Employee> listByCondition = new ArrayList<>();
        for (Employee employee : staff) {
            if (employee.getExperience() == experience) {
                listByCondition.add(employee);
            }
        }
        return listByCondition;
    }

    /**
     * Метод, который выводит номер телефона сотрудника по имени
     *
     * @param staff - список сотрудников
     * @param name  - имя
     */
    static void printPhoneNumberByEmployeeName(List<Employee> staff, String name) {
        List<Employee> listByCondition = new ArrayList<>();
        for (Employee employee : staff) {
            if (employee.getName().equals(name)) {
                listByCondition.add(employee);
            }
        }
        System.out.println(listByCondition.toString().replace("[", "").replace("]", ""));
    }

    /**
     * Метод, который ищет сотрудника по табельному номеру
     *
     * @param staff  - список сотрудников
     * @param number - табельный номер
     * @return - отфильтрованный список сотрудников
     */
    static Employee findEmployeeByJobNumber(List<Employee> staff, int number) {
        for (Employee employee : staff) {
            if (employee.getNumber() == number) {
                return employee;
            }
        }
        return null;
    }

    /**
     * Метод добавления нового сотрудника в справочник сотрудников
     *
     * @param staff - список сотрудников
     */
    static void addEmployeeToList(List<Employee> staff) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Введите имя нового сотрудника");
        String name = scanner.nextLine();
        System.out.println("Введите номер телефона нового сотрудника");
        String phone = scanner.nextLine();
        System.out.println("Введите стаж нового сотрудника");
        Scanner scanner2 = new Scanner(System.in);
        int experience = scanner2.nextInt();
        int number = 0;
        for (Employee employee : staff) {
            if (employee.getNumber() > number) {
                number = employee.getNumber();
            }
        }
        staff.add(new Employee(number + 1, phone, name, experience));
    }
}