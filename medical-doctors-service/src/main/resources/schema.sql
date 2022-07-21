-- DROP
DROP TABLE IF EXISTS doctors;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS doctors_has_roles;
-- TABLE DOCTORS
CREATE TABLE doctors (
                         doctor_id varchar(255) NOT NULL,
                         speciality varchar(255) DEFAULT NULL,
                         name varchar(255) DEFAULT NULL,
                         password varchar(255) DEFAULT NULL,
                         username varchar(255) DEFAULT NULL,
                         PRIMARY KEY (doctor_id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- TABLE ROLES
CREATE TABLE roles (
    role_id varchar(255) NOT NULL,
    name varchar(255) NOT NULL ,
    PRIMARY KEY (role_id)
) ENGINE = InnoDB DEFAULT CHARSET=latin1 ;

-- TABLE DOCTORS_HAS_ROLE

CREATE TABLE doctors_has_roles (
    doctor_id varchar(255) not null ,
    role_id varchar(255) not null ,
    constraint doctors_role_pk primary key (doctor_id, role_id),
    constraint doctors_fk foreign key (doctor_id) references doctors (doctor_id),
    constraint roles_fk foreign key (role_id) references roles (role_id)
) ENGINE = InnoDB DEFAULT CHARSET = latin1;