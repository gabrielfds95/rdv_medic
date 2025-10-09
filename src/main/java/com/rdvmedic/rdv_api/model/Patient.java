package com.rdvmedic.rdv_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


//@Data est une annotation Lombok. Nul besoin d’ajouter les getters et les setters.
// La librairie Lombok s’en charge pour nous. Très utile pour alléger le code.
import lombok.Data;

import jakarta.persistence.OneToMany;
import java.util.List;


@Data

//@Entity est une annotation qui indique que la classe
// correspond à une table de la base de données.
@Entity

//@Table(name=”employees”) indique le nom de la table associée
@Table(name = "Patient")
public class Patient extends User {

    //L’attribut id correspond à la clé primaire de la table, et
    // est donc annoté @Id. D’autre part, comme l’id est auto-incrémenté,
    // j’ai ajouté l’annotation @GeneratedValue(strategy = GenerationType.IDENTITY).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private int age;

    private String email;

    @OneToMany(mappedBy = "patient")
    private List<Slot> slot;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email= email;
    }

}