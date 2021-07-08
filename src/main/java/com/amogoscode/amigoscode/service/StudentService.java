package com.amogoscode.amigoscode.service;

import com.amogoscode.amigoscode.model.Student;
import com.amogoscode.amigoscode.repository.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    @Autowired
    private final StudentRepo studentRepo;

//    @Autowired
//    public StudentService(StudentRepo studentRepo){
//        this.studentRepo = studentRepo;
//    }

    public List<Student> getStudentList(){
        return studentRepo.findAll();
    }

    public void addStudent(Student st){
        Optional<Student> studentOptional =
                studentRepo.findStudentByEmail(st.getEmail());
        if(studentOptional.isPresent()){
            //for including this message - add this option in application.properties
            throw new IllegalStateException("User with this email already exists");
        }
        studentRepo.save(st);
    }

    public void delete(Long id) {
            if(!studentRepo.existsById(id)){
                throw new IllegalStateException("student with id: " + id +
                        " does not exists");
            }
            studentRepo.deleteById(id);
    }
}
