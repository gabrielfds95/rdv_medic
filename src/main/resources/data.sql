--INSERT INTO users (username, email) VALUES
  --                                      ('gabriel', 'gabriel@example.com'),
    --                                    ('paul', 'paul@example.com');

-- Table Médecin
CREATE TABLE Medecin (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         nom VARCHAR(100) NOT NULL,
                         prenom VARCHAR(100) NOT NULL,
                         specialite VARCHAR(100) NOT NULL
);

-- Table Patient
CREATE TABLE Patient (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         nom VARCHAR(100) NOT NULL,
                         prenom VARCHAR(100) NOT NULL,
                         age INT NOT NULL
);

-- Table Créneau
CREATE TABLE Creneau (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         date_creneau DATE NOT NULL,
                         heure_creneau TIME NOT NULL,
                         medecin_id INT NOT NULL,
                         patient_id INT NOT NULL,
                         FOREIGN KEY (medecin_id) REFERENCES Medecin(id),
                         FOREIGN KEY (patient_id) REFERENCES Patient(id)
);

-- Table Rendezvous
--CREATE TABLE Rendezvous (
  --                          id INT PRIMARY KEY AUTO_INCREMENT,
    --                        statut VARCHAR(50) NOT NULL,
      --                      motif VARCHAR(255),
        --                    creneau_id INT NOT NULL,
          --                  FOREIGN KEY (creneau_id) REFERENCES Creneau(id)
--);
