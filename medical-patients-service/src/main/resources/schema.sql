-- DROP
DROP TABLE IF EXISTS patients;
-- TABLE
CREATE TABLE patients (
                         patient_id varchar(255) NOT NULL,
                         age int(11) DEFAULT NULL,
                         name varchar(255) DEFAULT NULL,
                         phone varchar(255) DEFAULT NULL,
                         username varchar(255) NOT NULL,
                         password varchar(255) NOT NULL,
                         PRIMARY KEY (patient_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABLE ROLES
CREATE TABLE roles (
                       role_id varchar(255) NOT NULL,
                       name varchar(255) NOT NULL ,
                       PRIMARY KEY (role_id)
) ENGINE = InnoDB DEFAULT CHARSET=latin1 ;

-- TABLE PATIENTS_HAS_ROLE

CREATE TABLE patients_has_roles (
                                   patient_id varchar(255) not null ,
                                   role_id varchar(255) not null ,
                                   constraint patients_role_pk primary key (patient_id, role_id),
                                   constraint patients_fk foreign key (patient_id) references patients (patient_id),
                                   constraint roles_fk foreign key (role_id) references roles (role_id)
) ENGINE = InnoDB DEFAULT CHARSET = latin1;