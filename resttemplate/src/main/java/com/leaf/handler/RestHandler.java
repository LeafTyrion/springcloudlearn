package com.leaf.handler;

import com.leaf.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.lang.model.type.NullType;
import java.util.Collection;

@RestController
@RequestMapping("/rest")
public class RestHandler {

    @Autowired
    RestTemplate restTemplate;

    String url01= "http://localhost:8010/student/findAll";
    String url02= "http://localhost:8010/student/findById/{id}";
    String url03= "http://localhost:8010/student/save";
    String url04= "http://localhost:8010/student/update";
    String url05= "http://localhost:8010/student/deleteById/{id}";


    @GetMapping("/findAll")
    public Collection findAll() {
        return restTemplate.getForObject(url01, Collection.class);
    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable int id) {
        return restTemplate.getForEntity(url02, Student.class,id).getBody();
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student) {
        restTemplate.postForObject(url03, student, Student.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student) {
        restTemplate.put(url04, student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id) {
        restTemplate.delete(url05,id);
    }
}
