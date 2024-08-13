package com.appointment.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ScheduleDTO {

    private Long id;

    @NotBlank(message = "Day cannot be blank")
    private String day;

    @NotNull(message = "Start time cannot be null")
    private LocalDateTime startTime;  // Changed to LocalDateTime

    @NotNull(message = "End time cannot be null")
    private LocalDateTime endTime;  // Changed to LocalDateTime

    @NotNull(message = "Doctor cannot be null")
    private DoctorDTO doctor;

    // No-argument constructor
    public ScheduleDTO() {}

    // Parameterized constructor
    public ScheduleDTO(Long id, String day, LocalDateTime startTime, LocalDateTime endTime, DoctorDTO doctor) {
        this.id = id;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.doctor = doctor;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public DoctorDTO getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDTO doctor) {
        this.doctor = doctor;
    }
}
