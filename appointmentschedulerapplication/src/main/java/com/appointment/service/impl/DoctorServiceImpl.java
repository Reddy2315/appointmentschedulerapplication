package com.appointment.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.dto.DoctorDTO;
import com.appointment.entity.Doctor;
import com.appointment.exception.NotFoundException;
import com.appointment.repository.DoctorRepository;
import com.appointment.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private ModelMapper modelMapper;

    public DoctorServiceImpl(DoctorRepository doctorRepository, ModelMapper modelMapper) {
        this.doctorRepository = doctorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        return doctorRepository.findAll().stream()
                .map(doctor -> modelMapper.map(doctor, DoctorDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDTO getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Doctor not found"));
        return modelMapper.map(doctor, DoctorDTO.class);
    }

    @Override
    public DoctorDTO createDoctor(DoctorDTO doctorDTO) {
        Doctor doctor = modelMapper.map(doctorDTO, Doctor.class);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return modelMapper.map(savedDoctor, DoctorDTO.class);
    }

    @Override
    public DoctorDTO updateDoctor(Long id, DoctorDTO doctorDTO) {
        Doctor existingDoctor = doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Doctor not found"));
        modelMapper.map(doctorDTO, existingDoctor);
        Doctor updatedDoctor = doctorRepository.save(existingDoctor);
        return modelMapper.map(updatedDoctor, DoctorDTO.class);
    }

    @Override
    public void deleteDoctor(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Doctor not found"));
        doctorRepository.delete(doctor);
    }

    @Override
    public List<DoctorDTO> getDoctorsBySpecialization(String specialization) {
        return doctorRepository.findDoctorsBySpecialization(specialization).stream()
                .map(doctor -> modelMapper.map(doctor, DoctorDTO.class))
                .collect(Collectors.toList());
    }
//    @Override
//    public List<DoctorDTO> getDoctorsBySpecialty(String specialty) {
//        return doctorRepository.findDoctorsBySpecialty(specialty).stream()
//                .map(doctor -> modelMapper.map(doctor, DoctorDTO.class))
//                .collect(Collectors.toList());
//    }
}