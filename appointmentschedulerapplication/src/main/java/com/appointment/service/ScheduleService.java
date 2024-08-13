package com.appointment.service;

import java.util.List;

import com.appointment.dto.ScheduleDTO;

public interface ScheduleService {
    ScheduleDTO createSchedule(ScheduleDTO scheduleDTO);
    ScheduleDTO updateSchedule(Long id, ScheduleDTO scheduleDTO);
    ScheduleDTO getScheduleById(Long id);
    List<ScheduleDTO> getSchedulesByDoctorAndDay(Long doctorId, String day);
}