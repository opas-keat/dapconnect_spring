package com.praxis.dapconnect.data;

import com.github.javafaker.Faker;
import com.praxis.dapconnect.domain.model.entity.Department;
import com.praxis.dapconnect.domain.model.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {
    @Autowired
    private DepartmentRepository repository;
    @Autowired
    private Faker faker;

    @Override
    public void run(String... args) throws Exception {
// create 100 rows of people in the database
        List<Department> people = IntStream.rangeClosed(1,10)
                .mapToObj(i -> new Department(
                        faker.name().firstName(),
                        "admin"
                )).collect(Collectors.toList());

        repository.saveAll(people);

        Pageable paging = PageRequest.of(1, 3);
//        repository.findAll(paging).forEach(System.out::println);
    }
}
