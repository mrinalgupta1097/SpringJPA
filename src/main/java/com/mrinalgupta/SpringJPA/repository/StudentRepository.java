package com.mrinalgupta.SpringJPA.repository;

import com.mrinalgupta.SpringJPA.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
