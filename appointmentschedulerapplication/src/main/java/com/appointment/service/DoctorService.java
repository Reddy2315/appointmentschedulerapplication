package com.appointment.service;

import java.util.List;

import com.appointment.dto.DoctorDTO;

public interface DoctorService {
    List<DoctorDTO> getAllDoctors();
    DoctorDTO getDoctorById(Long id);
    DoctorDTO createDoctor(DoctorDTO doctorDTO);
    DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO);
    void deleteDoctor(Long id);
    List<DoctorDTO> getDoctorsBySpecialization(String specialty);
    
}