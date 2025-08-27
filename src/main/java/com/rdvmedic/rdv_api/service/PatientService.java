package com.rdvmedic.rdv_api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rdvmedic.rdv_api.model.Patient;
import com.rdvmedic.rdv_api.repository.PatientRepository;

import lombok.Data;


@Data
@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Optional<Patient> getPatient(final int id) {
        return patientRepository.findById(id);
    }

    public Iterable<Patient> getPatients() {
        return patientRepository.findAll();
    }

    public void deletePatient(final int id) {
        patientRepository.deleteById(id);
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
