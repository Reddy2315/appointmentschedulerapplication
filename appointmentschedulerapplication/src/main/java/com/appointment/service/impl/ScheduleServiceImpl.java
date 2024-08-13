package com.appointment.service.impl;

import com.appointment.dto.DoctorDTO;
import com.appointment.dto.ScheduleDTO;
import com.appointment.entity.Doctor;
import com.appointment.entity.Schedule;
import com.appointment.exception.NotFoundException;
import com.appointment.repository.DoctorRepository;
import com.appointment.repository.ScheduleRepository;
import com.appointment.service.DoctorService;
import com.appointment.service.ScheduleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final DoctorRepository doctorRepository;
    private final ModelMapper modelMapper;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository, DoctorRepository doctorRepository, ModelMapper modelMapper) {
        this.scheduleRepository = scheduleRepository;
        this.doctorRepository = doctorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ScheduleDTO createSchedule(ScheduleDTO scheduleDTO) {
        Schedule schedule = modelMapper.map(scheduleDTO, Schedule.class);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return modelMapper.map(savedSchedule, ScheduleDTO.class);
    }

    @Override
    public ScheduleDTO updateSchedule(Long id, ScheduleDTO scheduleDTO) {
        Schedule existingSchedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Schedule not found"));
        modelMapper.map(scheduleDTO, existingSchedule);
        Schedule updatedSchedule = scheduleRepository.save(existingSchedule);
        return modelMapper.map(updatedSchedule, ScheduleDTO.class);
    }

    @Override
    public ScheduleDTO getScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Schedule not found"));
        return modelMapper.map(schedule, ScheduleDTO.class);
    }

//    @Override
//    public List<ScheduleDTO> getSchedulesByDoctorAndDay(Long doctorId, String day) {
//        return scheduleRepository.findByDoctorIdAndDay(doctorId, day).stream()
//                .map(schedule -> modelMapper.map(schedule, ScheduleDTO.class))
//                .collect(Collectors.toList());
//    }
    @Override
    public List<ScheduleDTO> getSchedulesByDoctorAndDay(Long doctorId, String day) {
        return scheduleRepository.findByDoctorIdAndDay(doctorId, day).stream()
                .map(schedule -> modelMapper.map(schedule, ScheduleDTO.class))
                .collect(Collectors.toList());
    }
}