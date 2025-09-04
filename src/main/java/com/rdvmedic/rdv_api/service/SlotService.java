package com.rdvmedic.rdv_api.service;

import java.util.Optional;

import com.rdvmedic.rdv_api.model.Doctor;
import com.rdvmedic.rdv_api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rdvmedic.rdv_api.model.Slot;
import com.rdvmedic.rdv_api.repository.SlotRepository;

import lombok.Data;

@Data
@Service
public class SlotService {

    //chaque méthode a pour unique objectif d’appeler une méthode de SlotRepository

    @Autowired
    private SlotRepository slotRepository;

    @Autowired
    private DoctorRepository doctorRepository;


    public Optional<Slot> getSlot(final int id) {
        return slotRepository.findById(id);
    }

    public Iterable<Slot> getSlots() {
        return slotRepository.findAll();
    }

    public void deleteSlot(final int id) {
        slotRepository.deleteById(id);
    }

    public Slot addSlot(int id, Slot slot) {
        // On récupère le médecin en base avec son id
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        // On rattache le médecin au créneau
        slot.setDoctor(doctor);

        // On enregistre le créneau en base
        return slotRepository.save(slot);
    }
}