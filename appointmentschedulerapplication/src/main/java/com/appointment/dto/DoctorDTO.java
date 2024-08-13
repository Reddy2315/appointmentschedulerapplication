package com.appointment.dto;


import jakarta.validation.constraints.NotBlank;

public class DoctorDTO {

    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Specialization cannot be blank")
    private String specialization;  // Changed to match the entity field

    // No-argument constructor
    public DoctorDTO() {}

    // Parameterized constructor
    public DoctorDTO(Long id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
