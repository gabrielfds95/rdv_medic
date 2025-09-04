package com.rdvmedic.rdv_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;


//@Data est une annotation Lombok. Nul besoin d’ajouter les getters et les setters.
// La librairie Lombok s’en charge pour nous. Très utile pour alléger le code.
//import lombok.Data;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;




//@Data

//@Entity est une annotation qui indique que la classe
// correspond à une table de la base de données.
@Entity

//@Table(name=”employees”) indique le nom de la table associée
@Table(name = "Slot")
public class Slot {

    //L’attribut id correspond à la clé primaire de la table, et
    // est donc annoté @Id. D’autre part, comme l’id est auto-incrémenté,
    // j’ai ajouté l’annotation @GeneratedValue(strategy = GenerationType.IDENTITY).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate slotDate;

    private LocalTime slotTime;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false) // clé étrangère
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false) // clé étrangère
    private Patient patient;

    // Getter et setter pour doctor
    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getSlotDate() {
        return slotDate;
    }

    public void setSlotDate(LocalDate slotDate) {
        this.slotDate = slotDate;
    }

    public LocalTime getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(LocalTime slotTime) {
        this.slotTime = slotTime;
    }

}