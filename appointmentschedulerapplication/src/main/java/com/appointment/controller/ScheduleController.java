package com.appointment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appointment.dto.ScheduleDTO;
import com.appointment.service.ScheduleService;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
	@Autowired
    private ScheduleService scheduleService;

    @PostMapping("/appointment")
    public ResponseEntity<ScheduleDTO> createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        return ResponseEntity.ok(scheduleService.createSchedule(scheduleDTO));
    }

    @PutMapping("/appointment/{id}")
    public ResponseEntity<ScheduleDTO> updateSchedule(@PathVariable Long id, @RequestBody ScheduleDTO scheduleDTO) {
        return ResponseEntity.ok(scheduleService.updateSchedule(id, scheduleDTO));
    }

    @GetMapping("/appointment/{id}")
    public ResponseEntity<ScheduleDTO> getScheduleById(@PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.getScheduleById(id));
    }

    @GetMapping("/doctor/{id}/{day}")
    public ResponseEntity<List<ScheduleDTO>> getSchedulesByDoctorAndDay(
            @PathVariable Long doctorId,
            @PathVariable String day) {
        return ResponseEntity.ok(scheduleService.getSchedulesByDoctorAndDay(doctorId, day));
    }
}
