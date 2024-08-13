package com.appointment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointment.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
//    List<Schedule> findByDoctorIdAndDay(Long doctorId, String day);
	 List<Schedule> findByDoctorIdAndDay(Long doctorId, String day);
}