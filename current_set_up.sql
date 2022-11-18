create database phase1;

use phase1;

create table BLOODTYPE (id_Bloodtype int, bType varchar(3) not null, 
primary key (id_Bloodtype));

create table BANK (id_Bank int, Location varchar(45) not null, Open_Date Date, 
primary key (id_Bank));

create table VAMPIRE(id_Vampire int, FName varchar(45) not null, 
LName varchar(45) not null, primary key (id_Vampire));

create table DONOR(id_Donor int, id_Bloodtype int not null, Lst_Donation Date, 
Pers_Info varchar(45) not null, Date_Start Date not null, primary key (id_Donor), 
foreign key (id_Bloodtype) references BLOODTYPE(id_Bloodtype));

create table BLOODBAG(id_BloodBag int, Donor_Id int not null, Retr_Date Date not null, 
primary key (id_BloodBag), foreign key (Donor_Id) references DONOR(id_Donor));

create table INVENTORY(id_BloodBag int, id_Bank int, primary key (id_BloodBag, id_Bank), 
foreign key (id_Bloodbag) references BLOODBAG(id_BloodBag), 
foreign key (id_Bank) references BANK(id_Bank));

create table VACCOUNT(id_Account int, id_Vampire int not null, preference int, 
allowance int, Create_Date Date, primary key (id_Account), 
foreign key (id_Vampire) references VAMPIRE(id_Vampire), 
foreign key (preference) references BLOODTYPE(id_Bloodtype));

create table Transaction(id_Account int, id_BloodBag int, 
TDate date not null, primary key(id_Account, id_BloodBag), 
foreign key (id_Account) references VACCOUNT(id_Account), 
foreign key (id_BloodBag) references BLOODBAG(id_BloodBag);

insert into BLOODTYPE(id_Bloodtype, bType) values (1, 'A+');
insert into BLOODTYPE(id_Bloodtype, bType) values (2, 'A-');
insert into BLOODTYPE(id_Bloodtype, bType) values (3, 'B+');
insert into BLOODTYPE(id_Bloodtype, bType) values (4, 'B-');
insert into BLOODTYPE(id_Bloodtype, bType) values (5, 'O+');
insert into BLOODTYPE(id_Bloodtype, bType) values (6, 'O-');
insert into BLOODTYPE(id_Bloodtype, bType) values (7, 'AB+');
insert into BLOODTYPE(id_Bloodtype, bType) values (8, 'AB-');

insert into DONOR(id_Donor, id_BloodType, Lst_Donation, Pers_Info, Date_Start) 
values (101, 5, '2022-10-31', 'Likes Chocolate', '2020-1-1');

insert into BLOODBAG(id_BLoodBag, Donor_Id, Retr_Date) values (1, 101, '2022-10-1');
insert into BLOODBAG(id_BloodBag, Donor_Id, Retr_Date) values(2, 101, '2022-10-31');

insert into Bank(id_Bank, Location, Open_Date) values (1, '1012 Spooky Drive, Howl Michigan', '1856-10-31');

insert into INVENTORY(id_BloodBag, id_Bank) values (2, 1);

insert into VAMPIRE(id_Vampire, FName, LName) values(101, 'Michael', 'Morbius');

insert into VACCOUNT(id_Account, id_Vampire, allowance, Create_Date) values (1, 101, 3, '2022-4-1');

insert into TRANSACTION(id_Account, id_BloodBag, TDate) values (1, 1, '2022-10-30');
