--INSERT INTO users (username, email) VALUES
  --                                      ('gabriel', 'gabriel@example.com'),
    --                                    ('paul', 'paul@example.com');

-- Table Médecin
CREATE TABLE Doctor (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         first_name VARCHAR(100) NOT NULL,
                         last_name VARCHAR(100) NOT NULL,
                         speciality VARCHAR(100) NOT NULL
);

-- Table Patient
CREATE TABLE Patient (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         first_name VARCHAR(100) NOT NULL,
                         last_name VARCHAR(100) NOT NULL,
                         age INT NOT NULL
);

-- Table Créneau
CREATE TABLE Slot (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         slot_date DATE NOT NULL,
                         slot_time TIME NOT NULL,
                         doctor_id INT NOT NULL,
                         patient_id INT NOT NULL,
                         FOREIGN KEY (doctor_id) REFERENCES Doctor(id),
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
