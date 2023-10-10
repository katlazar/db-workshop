package org.goforjava.db;

import org.goforjava.domain.Department;
import org.goforjava.domain.Id;
import org.goforjava.domain.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepartmentDBTest {

    DB<Department> departmentDB = new DepartmentDB();

    @Test
    void shouldFindDepartmentById() {
        //given
        Id id = Id.of("id-1");
        departmentDB.put(id, new Department(id, "department-1", Location.POLAND));

        //when
        var department = departmentDB.findById(id);

        //then
        assertTrue(department.isPresent());
        assertEquals(id, department.get().getId());
        assertEquals("department-1", department.get().getName());
    }

    @Test
    void shouldFindAll() {
        //given
        departmentDB.put(Id.of("id-1"), new Department(Id.of("id-1"), "department-1", Location.POLAND));
        departmentDB.put(Id.of("id-2"), new Department(Id.of("id-2"), "department-2", Location.POLAND));
        departmentDB.put(Id.of("id-3"), new Department(Id.of("id-3"), "department-3", Location.POLAND));
        departmentDB.put(Id.of("id-3"), new Department(Id.of("id-3"), "department-4", Location.POLAND));

        //when
        var departments = departmentDB.findAll();

        //then
        assertEquals(3, departments.size());
    }



}
