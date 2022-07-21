-- DATABASE
-- CREATE DATABASE IF NOT EXISTS medical_center_scheduling;
-- DROP
DROP TABLE IF EXISTS scheduling;
-- TABLE
CREATE TABLE scheduling (
                         patient_id varchar(255) NOT NULL,
                         schedule_id varchar(255) NOT NULL,
                         doctor_id varchar(255) NOT NULL,
                         date datetime(6) DEFAULT NULL,
                         PRIMARY KEY (schedule_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
