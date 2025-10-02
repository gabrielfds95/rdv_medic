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
@Table(name = "User")
public class User {

    //L’attribut id correspond à la clé primaire de la table, et
    // est donc annoté @Id. D’autre part, comme l’id est auto-incrémenté,
    // j’ai ajouté l’annotation @GeneratedValue(strategy = GenerationType.IDENTITY).
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;

    private String password;

    private String role;

    @OneToMany(mappedBy = "user")
    private List<Slot> slot;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail(){
        return role;
    }
    public void setRole(String role){
        this.role= role;
    }

}