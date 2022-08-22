package com.praxis.dapconnect.data;

import com.github.javafaker.Faker;
import com.praxis.dapconnect.module.department.Department;
import com.praxis.dapconnect.module.department.DepartmentRepository;
import com.praxis.dapconnect.module.content.Content;
import com.praxis.dapconnect.module.content.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {
    private DepartmentRepository departmentRepository;
    private ContentRepository contentRepository;
    private Faker faker;
    @Autowired
    public SampleDataLoader(DepartmentRepository departmentRepository, ContentRepository contentRepository, Faker faker) {
        this.contentRepository = contentRepository;
        this.departmentRepository = departmentRepository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {
// create 100 rows of people in the database
//        List<Department> departments = IntStream.rangeClosed(1, 1)
//                .mapToObj(i -> new Department(
//                        this.faker.name().firstName(),
//                        "admin",
//                        Long.parseLong("0")
//                )).collect(Collectors.toList());
//
//        departmentRepository.saveAll(departments);

        List<Content> contents = IntStream.rangeClosed(1, 1)
                .mapToObj(i -> new Content(
                        "2022-08-01",
                        this.faker.address().zipCode(),
                        "2022-08-01",
                        "1",
                        "000",
                        "111",
                        "1",
                        this.faker.book().title(),
                        this.faker.book().publisher(),
                        this.faker.address().fullAddress(),
                        this.faker.address().firstName(),
                        this.faker.address().lastName(),
                        this.faker.address().fullAddress(),
                        "1",
                        "2022-08-01",
                        "admin"
                )).collect(Collectors.toList());
        contentRepository.saveAll(contents);
    }
}
