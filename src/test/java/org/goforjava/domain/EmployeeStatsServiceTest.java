package org.goforjava.domain;

import org.goforjava.EmployeesTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeStatsServiceTest extends EmployeesTest {

    EmployeeStatsService employeeStatsService =
            new WorkshopEmployeeStatsService(employeeDB, departmentDB);


    @ParameterizedTest
    @CsvSource(value = {
            "100, 1",
            "80, 5",
            "70, 8",
            "55, 16",
            "43, 28",
    })
    void shouldFindEmployeesOlderThan(int minAge, int expectedCount) {
        //when
        var employeesOlderThen = employeeStatsService.findEmployeesOlderThen(minAge);

        //then
        assertEquals(expectedCount, employeesOlderThen.size());
    }

    @Test
    void shouldFindThreeTopCompensatedEmployees() {
        // when
        var threeTopCompensatedEmployees = employeeStatsService.findThreeTopCompensatedEmployees();

        // then
        assertEquals(3, threeTopCompensatedEmployees.size());
        assertEquals("e7", threeTopCompensatedEmployees.get(0).getId().getKey());
        assertEquals("e6", threeTopCompensatedEmployees.get(1).getId().getKey());
        assertEquals("e12", threeTopCompensatedEmployees.get(2).getId().getKey());
    }

    @Test
    void shouldFindDepartmentWithLowestCompensationAverage() {
        //when
        var departmentWithLowestCompensationAverage = employeeStatsService.findDepartmentWithLowestCompensationAverage();

        //then
        assertTrue(departmentWithLowestCompensationAverage.isPresent());
        assertEquals("d3", departmentWithLowestCompensationAverage.get().getId().getKey());
        assertEquals("Departament Kontroli Nad Magicznymi Stworzeniami", departmentWithLowestCompensationAverage.get().getName());
    }

    @Test
    void shouldFindEmployeesBasedInGivenLocation() {
        //when
        var employees = employeeStatsService.findEmployeesBasedIn(Location.GERMANY);

        //then
        assertEquals(3, employees.size());
        var collectedId = employees.stream().map(e -> e.getId().getKey()).collect(Collectors.toSet());
        assertTrue(collectedId.contains("e10"));
        assertTrue(collectedId.contains("e11"));
        assertTrue(collectedId.contains("e22"));
    }

    @Test
    void shouldCountEmployeesByHireYear() {
        //when
        var byHireYearCount = employeeStatsService.countEmployeesByHireYear();

        //then
        assertEquals(11, byHireYearCount.keySet().size());
        assertEquals(1, byHireYearCount.get(2001));
        assertEquals(2, byHireYearCount.get(1988));
        assertEquals(2, byHireYearCount.get(1956));
        assertEquals(5, byHireYearCount.get(1973));
        assertEquals(1, byHireYearCount.get(1993));
        assertEquals(6, byHireYearCount.get(1994));
        assertEquals(2, byHireYearCount.get(1978));
        assertEquals(4, byHireYearCount.get(1996));
        assertEquals(2, byHireYearCount.get(1981));
        assertEquals(4, byHireYearCount.get(1998));
        assertEquals(1, byHireYearCount.get(1999));
    }

    @Test
    void shouldCountEmployeesByLocation() {
        //when
        var byLocationCount = employeeStatsService.countEmployeesByLocation();

        //then
        assertEquals(4, byLocationCount.keySet().size());
        assertEquals(3, byLocationCount.get(Location.GERMANY));
        assertEquals(10, byLocationCount.get(Location.POLAND));
        assertEquals(6, byLocationCount.get(Location.SPAIN));
        assertEquals(11, byLocationCount.get(Location.FRANCE));
    }


}
