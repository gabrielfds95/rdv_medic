package com.rdvmedic.rdv_api.model;

import jakarta.persistence.*;


//@Data est une annotation Lombok. Nul besoin d’ajouter les getters et les setters.
// La librairie Lombok s’en charge pour nous. Très utile pour alléger le code.
//import lombok.Data;

import java.util.List;


//@Data

//@Entity est une annotation qui indique que la classe
// correspond à une table de la base de données.
@Entity

//@Table(name=”Doctor”) indique le nom de la table associée
@Table(name = "Doctor")
public class Doctor {

    //L’attribut id correspond à la clé primaire de la table, et
    // est donc annoté @Id. D’autre part, comme l’id est auto-incrémenté,
    // j’ai ajouté l’annotation @GeneratedValue(strategy = GenerationType.IDENTITY).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //nom et prenom sont annotés avec @Column pour faire le
    // lien avec le nom du champ de la table, (inutile si nom du champ de la table est identique).
    //@Column(name="first_name")
    //inutile si auto create avec hibernate car il crée a partir du model + il converti automatique camelCase en snake_case
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "speciality")
    private String speciality;

    @OneToMany(mappedBy = "doctor")
    private List<Slot> slot;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
        }

    public void setLastName(String lastName) {
        this.lastName = lastName;

    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}