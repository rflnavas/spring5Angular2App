
/*USUARIOS*/
/* Creamos algunos usuarios con sus roles */
INSERT INTO dusers (username, password, enabled, name, email) VALUES ('rafa','$2a$10$017l6J8mOfH9VSy16p7KLOiWWk4bd4H/Wl9StiBRjhBocGiVhVBle',1, 'Rafa','profesor@bolsadeideas.com');
INSERT INTO dusers (username, password, enabled, name, email) VALUES ('admin','$2a$10$ohr28bkRmaRPNmahcIrIqemVle1r6myCw6i63ACk7i204AHMMt3s2',1, 'David','jhon.doe@bolsadeideas.com');

/*ROLES*/
INSERT INTO roles (rolename) VALUES ('ROLE_USER');
INSERT INTO roles (rolename) VALUES ('ROLE_ADMIN');

INSERT INTO dusers_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO dusers_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO dusers_roles (user_id, role_id) VALUES (2, 1);



/*Clientes*/
insert into clientes (id, name, surname, email, creation_date) values(1, 'John', 'Doe', 'john.doe@gmail.com', '2019-01-02');
insert into clientes (id, name, surname, email, creation_date) values(2, 'Tom', 'Sullivan', 'tom.sull@gmail.com', '2019-01-15');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(3, 'Paul', 'LeClerk', 'paulcl3rk@hotmail.com', '2019-02-19', '1987-08-14');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(4, 'Sarah', 'Parson', 'sarahparson@acme.com', '2019-02-22', '1987-05-12');
insert into clientes (id, name, surname, email, creation_date) values(5, 'Gillian', 'Ferguson', 'giferguson012@gmail.com', '2019-03-04');
insert into clientes (id, name, surname, email, creation_date) values(6, 'Matthew', 'Robins', 'matthew.robbins@gmail.com', '2019-03-05');
insert into clientes (id, name, surname, email, creation_date) values(7, 'Jessica', 'Fowler', 'jessica.fowler@gmail.com', '2019-03-12');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(8, 'Christine', 'Gutierrez', 'christgurri2019@gmail.com', '2019-03-23', '1987-03-30');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(9, 'Pierre', 'De la Fontaine', 'pierre.armee@gmail.com', '2019-03-30', '1984-09-05');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(10, 'Carmen', 'Sánchez', 'carmen.sanchez@gmail.com', '2019-03-30','1983-09-21');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(11, 'Klim', 'Obenhorff', 'klim.obenhrf399@hotmail.com', '2019-04-01', '1987-03-30');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(12, 'Rose', 'Alker', 'rose.alker@hotmail.com', '2019-05-11', '1974-09-09');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(13, 'Lucille', 'Cousineau', 'lucille019@yahoo.fr', '2019-05-12', '1988-11-22');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(14, 'Aleksander', 'Van der Camp', 'aleksey_vdc@gmail.com', '2019-05-14', '1979-12-30');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(15, 'Joseph', 'Blatzkovich', 'jblaskoc@gmail.com', '2019-06-04', '1999-08-14');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(16, 'David', 'Logan', 'david_logan@gmail.com', '2019-06-23', '2000-03-12');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(17, 'Hannah', 'Chastain', 'hannah.chastain123@gmail.com', '2019-06-20', '1986-10-06');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(18, 'Carlos', 'Reyes', 'carolus.thethird@gmail.com', '2019-06-21', '1975-02-16');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(19, 'Jesse', 'Pinkman', 'jesse.pinkman.bb@gmail.com', '2019-06-30', '1986-10-06');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(20, 'Demi', 'Roussos', 'demmi.roussos@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(21, 'Demi', 'Roussos', 'demmi.roussos3@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(22, 'Demi', 'Roussos', 'demmi.roussos4@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(23, 'Demi', 'Roussos', 'demmi.roussos5@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(24, 'Demi', 'Roussos', 'demmi.roussos6@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(25, 'Demi', 'Roussos', 'demmi.roussos7a@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(26, 'Demi', 'Roussos', 'demmi.roussos5ak@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(27, 'Demi', 'Roussos', 'demmi.roussos8@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(28, 'Demi', 'Roussos', 'demmi.roussos7@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(29, 'Demi', 'Roussos', 'demmi.roussos8a@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(30, 'Demi', 'Roussos', 'demmi.roussos9a@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(31, 'Demi', 'Roussos', 'demmi.roussos10@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(32, 'Demi', 'Roussos', 'demmi.roussos11@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(33, 'Demi', 'Roussos', 'demmi.roussos12@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(34, 'Demi', 'Roussos', 'demmi.roussos13@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(35, 'Demi', 'Roussos', 'demmi.roussos14@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(36, 'Demi', 'Roussos', 'demmi.roussos15@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(37, 'Demi', 'Roussos', 'demmi.roussos16@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(38, 'Demi', 'Roussos', 'demmi.roussos15a@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(39, 'Demi', 'Roussos', 'demmi.roussos15b@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(40, 'Demi', 'Roussos', 'demmi.roussos15c@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(41, 'Demi', 'Roussos', 'demmi.roussos15d@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(42, 'Demi', 'Roussos', 'demmi.roussos15e@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(43, 'Demi', 'Roussos', 'demmi.roussos15f@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(44, 'Demi', 'Roussos', 'demmi.roussos15g@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(45, 'Demi', 'Roussos', 'demmi.roussos15h@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(46, 'Demi', 'Roussos', 'demmi.roussos15i@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(47, 'Demi', 'Roussos', 'demmi.roussos15j@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(48, 'Demi', 'Roussos', 'demmi.roussos15k@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(49, 'Demi', 'Roussos', 'demmi.roussos15l@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(50, 'Demi', 'Roussos', 'demmi.roussos15m@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(51, 'Demi', 'Roussos', 'demmi.roussos15o1@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(52, 'Demi', 'Roussos', 'demmi.roussos15o2@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(53, 'Demi', 'Roussos', 'demmi.roussos15o3@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(54, 'Demi', 'Roussos', 'demmi.roussos15o4@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(55, 'Demi', 'Roussos', 'demmi.roussos15o5@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(56, 'Demi', 'Roussos', 'demmi.roussos15o6@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(57, 'Demi', 'Roussos', 'demmi.roussos15o7@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(58, 'Demi', 'Roussos', 'demmi.roussos15o8@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(59, 'Demi', 'Roussos', 'demmi.roussos1509@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(60, 'Demi', 'Roussos', 'demmi.roussos15ok@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(61, 'Demi', 'Roussos', 'demmi.roussos15ok8@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(62, 'Demi', 'Roussos', 'demmi.roussos15ok9@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(63, 'Demi', 'Roussos', 'demmi.roussos15ok9p@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(64, 'Demi', 'Roussos', 'demmi.roussos15ok7@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(65, 'Demi', 'Roussos', 'demmi.roussos15ok3@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(66, 'Demi', 'Roussos', 'demmi.roussos16o@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(67, 'Demi', 'Roussos', 'demmi.roussos17o@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(68, 'Demi', 'Roussos', 'demmi.roussos18o@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(69, 'Demi', 'Roussos', 'demmi.roussos19o@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(70, 'Demi', 'Roussos', 'demmi.roussos005o@gmail.com', '2019-07-17', '1961-01-29');
insert into clientes (id, name, surname, email, creation_date, birthdate) values(71, 'Demi', 'Roussos', 'demmi.roussos66o@gmail.com', '2019-07-17', '1961-01-29');