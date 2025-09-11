package com.rdvmedic.rdv_api.controller;

import com.rdvmedic.rdv_api.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rdvmedic.rdv_api.model.Patient;
import com.rdvmedic.rdv_api.service.PatientService;

import java.util.List;

//permet d’indiquer à Spring que cette classe est un bean
//et indique à Spring d’insérer le retour de la méthode
// au format JSON dans le corps de la réponse HTTP
@RestController

public class PatientController {

    @Autowired
    private PatientService patientService;

    /**
     * Read - Get all employees
     * @return - An Iterable object of Employee full filled
     */
    @GetMapping("/patients")
    //les requêtes HTTP de type GET à l’URL /patients exécuteront le code de cette
    // méthode. Et ce code est tout simple : il s’agit d’appeler la méthode getPatients()
    // du service, ce dernier appellera la méthode findAll() du repository, et nous obtiendrons
    // ainsi tous les patients enregistrés en base de données
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

}