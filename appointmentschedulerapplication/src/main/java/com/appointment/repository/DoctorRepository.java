package com.appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appointment.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

//    List<Doctor> findBySpecialization(String specialization);
//
//    @Query("SELECT d FROM Doctor d WHERE d.specialization = :specialization")
//    List<Doctor> findDoctorsBySpecialization(@Param("specialization") String specialization);
	
//	List<Doctor> findBySpecialization(String specialization);

    @Query("SELECT d FROM Doctor d WHERE d.specialization = :specialization")
    List<Doctor> findDoctorsBySpecialization(@Param("specialization") String specialization);
}



