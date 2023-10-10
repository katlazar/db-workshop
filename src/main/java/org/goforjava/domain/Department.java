package org.goforjava.domain;

public class Department {
    private final Id id;
    private final String name;
    private final Location location;

    public Department(Id id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public Id getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location=" + location +
                '}';
    }

}
