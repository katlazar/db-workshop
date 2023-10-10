package org.goforjava.domain;

import org.goforjava.db.DB;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class WorkshopEmployeeStatsService implements EmployeeStatsService{

    private final DB<Employee> employeeDB;
    private final DB<Department> departmentDB;

    public WorkshopEmployeeStatsService(DB<Employee> employeeDB, DB<Department> departmentDB) {
        this.employeeDB = employeeDB;
        this.departmentDB = departmentDB;
    }

    @Override
    public List<Employee> findEmployeesOlderThen(long years) {
        return employeeDB
                .findAll()
                .stream()
                .filter(e->Period.between(e.getBirthDate(), LocalDate.now()).getYears()>=years)
                .toList();
    }

    @Override
    public List<Employee> findThreeTopCompensatedEmployees() {
        return employeeDB
                .findAll()
                .stream()
                .sorted(Comparator.comparing(Employee::getGrossSalary).reversed())
                .limit(3)
                .toList();
    }

    @Override
    public Optional<Department> findDepartmentWithLowestCompensationAverage() {
        Map<Id, Double> idDepAndAverSalary = employeeDB
                .findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId,Collectors.averagingDouble(Employee::getGrossSalary)));
        return Optional.of(departmentDB
                        .findById(idDepAndAverSalary
                                .entrySet()
                                .stream()
                                .min(Map.Entry.comparingByValue())
                                                .get().getKey())
                                                        .get());
    }

    @Override
    public List<Employee> findEmployeesBasedIn(Location location) {
        return employeeDB
                .findAll()
                .stream()
                .filter(e-> departmentDB
                        .findById(e.getDepartmentId())
                        .get()
                        .getLocation()
                        .equals(location))
                .toList();
    }

    @Override
    public Map<Integer, Long> countEmployeesByHireYear() {
        return employeeDB
                .findAll()
                .stream()
                .collect(Collectors.groupingBy(e -> e.getHireDate().getYear(),Collectors.counting()));
    }

    @Override
    public Map<Location, Long> countEmployeesByLocation() {
        return employeeDB
                .findAll()
                .stream()
                .collect(Collectors.groupingBy(e -> departmentDB
                        .findById(e.getDepartmentId())
                        .get()
                        .getLocation(),Collectors.counting()));
    }
}
