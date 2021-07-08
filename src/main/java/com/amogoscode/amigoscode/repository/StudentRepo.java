package com.amogoscode.amigoscode.repository;

import com.amogoscode.amigoscode.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

    //@Query("SELECT s FROM Student s WHERE s.email = ?1") - actual query (JPQL)
    Optional<Student> findStudentByEmail(String email);
}
