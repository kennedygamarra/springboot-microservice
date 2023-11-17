package com.microservice.course.controller;

import com.microservice.course.entities.Course;
import com.microservice.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @PostMapping("/create")
    public void saveCourse(@RequestBody Course course) {
        courseService.save(course);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping("/find-all")
    public ResponseEntity<Iterable<Course>> findAll() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/find-students/{idCourse}")
    public ResponseEntity<?> findStudentsByCourseId(@PathVariable Long idCourse) {
        return ResponseEntity.ok(courseService.findStudentsByCourse(idCourse));
    }
}
