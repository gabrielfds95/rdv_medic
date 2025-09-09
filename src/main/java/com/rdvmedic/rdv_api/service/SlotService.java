package com.rdvmedic.rdv_api.service;

import java.util.List;
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

    public Slot addSlot(int doctorId, Slot slot) {
        // On récupère le médecin en base avec son id
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));


        /* Vérifie si un créneau existe déjà pour ce médecin à cette date et heure
        Optional<Slot> existingSlot = slotRepository.findSlotByDoctorAndDateTime(
                doctorId, slot.getSlotDate(),slot.getSlotTime());

        if (existingSlot.isPresent()) {
            // Si le créneau existe déjà, on lève une exception ou on peut retourner le créneau existant
            throw new RuntimeException("Slot already exists for this doctor at this date and time");
        }*/

        // On rattache le médecin au créneau
        slot.setDoctor(doctor);

        // On enregistre le créneau en base
        return slotRepository.save(slot);
    }

    //public List<Slot> : La méthode retourne une liste de créneaux.
    //doctorId : C’est l’ID du médecin reçu depuis le controller.
    //slotRepository.findByDoctorId(doctorId) : Utilise le repository
    // pour interroger la base de données et récupérer tous les créneaux associés à ce médecin.
    public List<Slot> getSlotsByDoctor(int doctorId) {
        return slotRepository.findByDoctorId(doctorId);
    }

}