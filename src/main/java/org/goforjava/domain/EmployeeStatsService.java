package org.goforjava.domain;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EmployeeStatsService {

    List<Employee> findEmployeesOlderThen(long years);

    List<Employee> findThreeTopCompensatedEmployees();

    Optional<Department> findDepartmentWithLowestCompensationAverage();

    List<Employee> findEmployeesBasedIn(Location location);

    Map<Integer, Long> countEmployeesByHireYear();

    Map<Location, Long> countEmployeesByLocation();

}
