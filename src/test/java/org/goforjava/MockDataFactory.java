package org.goforjava;

import org.goforjava.db.DB;
import org.goforjava.domain.Department;
import org.goforjava.domain.Employee;
import org.goforjava.domain.Id;
import org.goforjava.domain.Location;

import java.time.LocalDate;

public class MockDataFactory {

    DB<Employee> employeeDB;
    DB<Department> departmentDB;

    public MockDataFactory(DB<Employee> employeeDB, DB<Department> departmentDB) {
        this.employeeDB = employeeDB;
        this.departmentDB = departmentDB;
    }

    public void populateDepartments() {
        departmentDB.put(new Id("d1"), new Department(new Id("d1"), "Ministerstwo Magii", Location.POLAND));
        departmentDB.put(new Id("d2"), new Department(new Id("d2"), "Departament Tajemnic", Location.POLAND));
        departmentDB.put(new Id("d3"), new Department(new Id("d3"), "Departament Kontroli Nad Magicznymi Stworzeniami", Location.FRANCE));
        departmentDB.put(new Id("d4"), new Department(new Id("d4"), "Departament Przestrzegania Prawa Magicznego", Location.GERMANY));
        departmentDB.put(new Id("d5"), new Department(new Id("d5"), "Departament Międzynarodowej Współpracy w Magicznych Sprawach", Location.SPAIN));
        departmentDB.put(new Id("d6"), new Department(new Id("d6"), "Departament Mgieł i Dymów", Location.SPAIN));
        departmentDB.put(new Id("d7"), new Department(new Id("d7"), "Ministerstwo Mioteł", Location.FRANCE));
    }

    public void populateEmployees() {
        employeeDB.put(new Id("e1"), new Employee(new Id("e1"), "Harry Potter", LocalDate.of(1980, 7, 31), LocalDate.of(1998, 7, 31), 5000L, "Auror", new Id("d1")));
        employeeDB.put(new Id("e2"), new Employee(new Id("e2"), "Hermione Granger", LocalDate.of(1979, 9, 19), LocalDate.of(1998, 7, 31), 4800L, "Auror", new Id("d1")));
        employeeDB.put(new Id("e3"), new Employee(new Id("e3"), "Ron Weasley", LocalDate.of(1980, 3, 1), LocalDate.of(1998, 7, 31), 4800L, "Auror", new Id("d1")));
        employeeDB.put(new Id("e4"), new Employee(new Id("e4"), "Luna Lovegood", LocalDate.of(1981, 2, 13), LocalDate.of(2001, 9, 1), 4500L, "Badacz Magicznych Stworzeń", new Id("d3")));
        employeeDB.put(new Id("e5"), new Employee(new Id("e5"), "Nymphadora Tonks", LocalDate.of(1973, 12, 26), LocalDate.of(1998, 7, 31), 5200L, "Auror", new Id("d1")));
        employeeDB.put(new Id("e6"), new Employee(new Id("e6"), "Minerva McGonagall", LocalDate.of(1935, 10, 4), LocalDate.of(1956, 7, 31), 5500L, "Nauczyciel Zaklęć", new Id("d7")));
        employeeDB.put(new Id("e7"), new Employee(new Id("e7"), "Albus Dumbledore", LocalDate.of(1881, 8, 8), LocalDate.of(1956, 7, 31), 6000L, "Dyrektor Szkoły Magii", new Id("d7")));
        employeeDB.put(new Id("e8"), new Employee(new Id("e8"), "Severus Snape", LocalDate.of(1960, 1, 9), LocalDate.of(1981, 7, 31), 4800L, "Nauczyciel Eliksirów", new Id("d7")));
        employeeDB.put(new Id("e9"), new Employee(new Id("e9"), "Rubeus Hagrid", LocalDate.of(1928, 12, 6), LocalDate.of(1981, 7, 31), 4600L, "Strażnik Klucza", new Id("d7")));
        employeeDB.put(new Id("e10"), new Employee(new Id("e10"), "Bellatrix Lestrange", LocalDate.of(1951, 9, 14), LocalDate.of(1978, 7, 31), 5200L, "Strażnik Azkabanu", new Id("d4")));
        employeeDB.put(new Id("e11"), new Employee(new Id("e11"), "Sirius Black", LocalDate.of(1959, 11, 3), LocalDate.of(1978, 7, 31), 5200L, "Strażnik Azkabanu", new Id("d4")));
        employeeDB.put(new Id("e12"), new Employee(new Id("e12"), "Gilderoy Lockhart", LocalDate.of(1964, 1, 26), LocalDate.of(1996, 7, 31), 5500L, "Nauczyciel Obrony Przed Czarną Magią", new Id("d7")));
        employeeDB.put(new Id("e13"), new Employee(new Id("e13"), "Dolores Umbridge", LocalDate.of(1965, 8, 26), LocalDate.of(1996, 7, 31), 5400L, "Dziennikarka", new Id("d5")));
        employeeDB.put(new Id("e14"), new Employee(new Id("e14"), "Cedric Diggory", LocalDate.of(1977, 9, 22), LocalDate.of(1994, 7, 31), 4700L, "Kapitan Gryfonów", new Id("d7")));
        employeeDB.put(new Id("e15"), new Employee(new Id("e15"), "Fleur Delacour", LocalDate.of(1977, 8, 30), LocalDate.of(1994, 7, 31), 4700L, "Strażnik Klucza", new Id("d7")));
        employeeDB.put(new Id("e16"), new Employee(new Id("e16"), "Narcissa Malfoy", LocalDate.of(1955, 6, 5), LocalDate.of(1973, 7, 31), 5200L, "Członek Wysokiej Rady Czarodziejów", new Id("d1")));
        employeeDB.put(new Id("e17"), new Employee(new Id("e17"), "Lucius Malfoy", LocalDate.of(1954, 4, 24), LocalDate.of(1973, 7, 31), 5200L, "Członek Wysokiej Rady Czarodziejów", new Id("d1")));
        employeeDB.put(new Id("e18"), new Employee(new Id("e18"), "Argus Filch", LocalDate.of(1943, 4, 2), LocalDate.of(1973, 7, 31), 4600L, "Filch", new Id("d7")));
        employeeDB.put(new Id("e19"), new Employee(new Id("e19"), "Rita Skeeter", LocalDate.of(1960, 8, 24), LocalDate.of(1993, 7, 31), 5400L, "Dziennikarka", new Id("d5")));
        employeeDB.put(new Id("e20"), new Employee(new Id("e20"), "Cornelius Fudge", LocalDate.of(1935, 9, 8), LocalDate.of(1988, 7, 31), 5100L, "Minister Magii", new Id("d1")));
        employeeDB.put(new Id("e21"), new Employee(new Id("e21"), "Kingsley Shacklebolt", LocalDate.of(1955, 12, 1), LocalDate.of(1988, 7, 31), 5400L, "Auror", new Id("d1")));
        employeeDB.put(new Id("e22"), new Employee(new Id("e22"), "Arthur Weasley", LocalDate.of(1950, 2, 6), LocalDate.of(1973, 7, 31), 5000L, "Pracownik Biura Ochrony Czarodziejów", new Id("d4")));
        employeeDB.put(new Id("e23"), new Employee(new Id("e23"), "Molly Weasley", LocalDate.of(1949, 10, 30), LocalDate.of(1973, 7, 31), 5000L, "Rodzina", new Id("d7")));
        employeeDB.put(new Id("e24"), new Employee(new Id("e24"), "Ginny Weasley", LocalDate.of(1981, 8, 11), LocalDate.of(1999, 7, 31), 4800L, "Auror", new Id("d1")));
        employeeDB.put(new Id("e25"), new Employee(new Id("e25"), "Fred Weasley", LocalDate.of(1978, 4, 1), LocalDate.of(1996, 7, 31), 4700L, "Właściciel Sklepu Śartgonów", new Id("d6")));
        employeeDB.put(new Id("e26"), new Employee(new Id("e26"), "George Weasley", LocalDate.of(1978, 4, 1), LocalDate.of(1996, 7, 31), 4700L, "Właściciel Sklepu Śartgonów", new Id("d6")));
        employeeDB.put(new Id("e27"), new Employee(new Id("e27"), "Percy Weasley", LocalDate.of(1976, 8, 22), LocalDate.of(1994, 7, 31), 4800L, "Pracownik Ministerstwa Magii", new Id("d1")));
        employeeDB.put(new Id("e28"), new Employee(new Id("e28"), "Bill Weasley", LocalDate.of(1970, 11, 29), LocalDate.of(1994, 7, 31), 4900L, "Pracownik Banku Gringotta", new Id("d6")));
        employeeDB.put(new Id("e29"), new Employee(new Id("e29"), "Charlie Weasley", LocalDate.of(1972, 12, 12), LocalDate.of(1994, 7, 31), 4900L, "Strażnik Smoków", new Id("d5")));
        employeeDB.put(new Id("e30"), new Employee(new Id("e30"), "Cedric Diggory", LocalDate.of(1977, 9, 22), LocalDate.of(1994, 7, 31), 4700L, "Kapitan Gryfonów", new Id("d7")));
    }
}
