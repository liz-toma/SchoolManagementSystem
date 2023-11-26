package org.liz.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Eliza Toma
 * <p>
 * Department
 */
@Getter
@Setter
@EqualsAndHashCode
public class Department {
    private static int nextId = 1;

    private String id;
    private String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        id = String.format("D%03d", nextId++);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
