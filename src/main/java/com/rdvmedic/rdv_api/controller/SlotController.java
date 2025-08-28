package com.rdvmedic.rdv_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rdvmedic.rdv_api.model.Slot;
import com.rdvmedic.rdv_api.service.SlotService;

//permet d’indiquer à Spring que cette classe est un bean
//et indique à Spring d’insérer le retour de la méthode
// au format JSON dans le corps de la réponse HTTP
@RestController

public class SlotController {

    @Autowired
    private SlotService slotService;

    /**
     * Read - Get all employees
     * @return - An Iterable object of Employee full filled
     */
    @GetMapping("/slots")
    //les requêtes HTTP de type GET à l’URL /slots exécuteront le code de cette
    // méthode. Et ce code est tout simple : il s’agit d’appeler la méthode getSlots()
    // du service, ce dernier appellera la méthode findAll() du repository, et nous obtiendrons
    // ainsi tous les crénaux enregistrés en base de données
    public Iterable<Slot> getSlots() {
        return slotService.getSlots();
    }

}