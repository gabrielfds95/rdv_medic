package com.rdvmedic.rdv_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


//@Data est une annotation Lombok. Nul besoin d’ajouter les getters et les setters.
// La librairie Lombok s’en charge pour nous. Très utile pour alléger le code.
import lombok.Data;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;




@Data

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

    //nom et prenom sont annotés avec @Column pour faire le
    // lien avec le nom du champ de la table, (inutile si nom du champ de la table est identique).
    @Column(name="first_name")
    private String first_name;

    @Column(name="last_name")
    private String last_name;

    private String speciality;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false) // clé étrangère
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false) // clé étrangère
    private Patient patient;

}