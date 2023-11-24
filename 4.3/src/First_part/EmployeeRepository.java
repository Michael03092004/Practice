package First_part;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeRepository {

    private final List<Employee> employeeList = Arrays.asList(
            new Employee("John", "Bread", 2000),
            new Employee("Michael", "Jordan", 3000),
            new Employee("Cherry", "Parrot", 7000),
            new Employee("Bill", "Gates", 1000),
            new Employee("Steve", "Jobs", 300)
    );


    public String[] getNameAndSurnameOfTop3BySalary() {

        return employeeList
                .stream()
                .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                .limit(3)
                .map(employee -> employee.getName() + " " + employee.getLastName())
                .toArray(String[]::new);
    }

    public Map<Speciality, List<Employee>> groupBySpeciality(){
        return employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getSpeciality));
    }

    public int getSalaryByHugeCriterialList() {
        return employeeList
                .stream()
                .filter(employee -> employee.getGender() == Gender.FEMALE &&
                        employee.getAge() < 30 && employee.getSpeciality() == Speciality.QA &&
                        employee.getWorkExperience() <= 5)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    public boolean checkIfPresentEmployeeWithWorkExperienceMoreThanTwenty(){
        return employeeList
                .stream()
                .anyMatch(employee -> employee.getWorkExperience() > 20);
    }

    public String getDescendingSalaryWithFullname(){
        return employeeList
                .stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .map(employee -> String.format("%s %s %s;",
                        employee.getName(), employee.getLastName(), employee.getSalary()))
                .toList()
                .toString();
    }

    public Map<Speciality, Double> getAverageSalaryBySpeciality(){
        return employeeList
                .stream()
                .collect(Collectors.groupingBy(
                        Employee::getSpeciality,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
    }
}
