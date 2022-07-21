INSERT INTO doctors (doctor_id, speciality, name, password, username) VALUES ('99C3710ADDD04CF9B2038CBDE2736B54', 'Cardiologista', 'Augusto', '$2a$10$zpXeBqtrmsST8acbbe5fT.IBQTPj5mZD2n6tkYKC/1WcpO4meowTa', 'augusto@email.com');
INSERT INTO doctors (doctor_id, speciality, name, password, username) VALUES ('99C3710ADDD04CF9B2038CBDE2736B55', 'Urologista', 'Vicente', '$2a$10$zpXeBqtrmsST8acbbe5fT.IBQTPj5mZD2n6tkYKC/1WcpO4meowTa', 'vicente@email.com');

INSERT INTO roles (role_id, name) VALUES ('6663710ADDD04CF9B2038CBDE2736R01', 'ROLE_OPERATOR');
INSERT INTO roles (role_id, name) VALUES ('6663710ADDD04CF9B2038CBDE2736R02', 'ROLE_ADMIN');

INSERT INTO doctors_has_roles (doctor_id, role_id) VALUES ('99C3710ADDD04CF9B2038CBDE2736B54', '6663710ADDD04CF9B2038CBDE2736R01');
INSERT INTO doctors_has_roles (doctor_id, role_id) VALUES ('99C3710ADDD04CF9B2038CBDE2736B54', '6663710ADDD04CF9B2038CBDE2736R02');
INSERT INTO doctors_has_roles (doctor_id, role_id) VALUES ('99C3710ADDD04CF9B2038CBDE2736B55', '6663710ADDD04CF9B2038CBDE2736R01');