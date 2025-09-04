
-- Table Médecin
/*CREATE TABLE Doctor (
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
*/
INSERT INTO doctor (first_name, last_name, speciality) VALUES
                                                           ('John', 'Dupont', 'Ostheo'),
                                                           ('Paul', 'Dupard', 'Dentiste');
INSERT INTO patient (first_name, last_name, age) VALUES
                                                     ('Marc', 'Galar', 34),
                                                     ('Jean', 'Dude', 21);

INSERT INTO slot (slot_date, slot_time, doctor_id, patient_id) VALUES
                                            ('2025-09-04','14:30:00',2, 1);