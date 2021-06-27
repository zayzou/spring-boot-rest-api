package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

     @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public void RegisterNewStudent(@RequestBody  Student student){
          studentService.addNewStudent(student);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
         studentService.deleteStudent(id);
    }

    @CrossOrigin(origins = "*")
    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long id,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email
                              ){
         studentService.updateStudent(id,name,email);

    }

    @CrossOrigin("*")
    @GetMapping(path = "count")
    public Long getNumberOfStudent(){
         return studentService.getNumberOfStudent();
    }




}
