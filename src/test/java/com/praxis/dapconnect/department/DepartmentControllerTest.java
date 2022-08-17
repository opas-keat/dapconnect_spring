package com.praxis.dapconnect.department;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentControllerTest {

    @Autowired
    DepartmentController departmentController;

    @Test
    void version() {
        assertEquals( "The actual version is 1.0.0", departmentController.version());
    }

    @Test
    void getAllProduct() {
        Pageable paging = PageRequest.of(0, 10);
        Integer departmentLength = departmentController.getAllProduct(paging).getSize();
        assertEquals(10, departmentLength);
    }

    @Test
    void getDepartmentById() {

    }

    @Test
    void deleteProduct() {
    }
}