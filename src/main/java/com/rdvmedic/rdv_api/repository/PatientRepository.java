package com.rdvmedic.rdv_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rdvmedic.rdv_api.model.Patient;


//@Repository est une annotation Spring pour indiquer que la classe est un bean,
// et que son rôle est de communiquer avec une source de données (en l'occurrence
// la base de données).
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}

