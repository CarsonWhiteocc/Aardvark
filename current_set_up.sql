create database phase1;

use phase1;

create table BLOODTYPE (id_Bloodtype int not null auto_increment, bType varchar(3) not null, 
primary key (id_Bloodtype));

create table BANK (id_Bank int not null auto_increment, Location varchar(45) not null, Open_Date Date, 
primary key (id_Bank));

create table VAMPIRE(id_Vampire int not null auto_increment, FName varchar(45) not null, 
LName varchar(45) not null, primary key (id_Vampire));

create table DONOR(id_Donor int not null auto_increment, Bloodtype_id int not null, Lst_Donation Date, 
Pers_Info varchar(100) not null, Date_Start Date not null, primary key (id_Donor), 
foreign key (Bloodtype_id) references BLOODTYPE(id_Bloodtype));

create table BLOODBAG(id_BloodBag int not null auto_increment, Donor_Id int not null, Retr_Date Date not null, 
primary key (id_BloodBag), foreign key (Donor_Id) references DONOR(id_Donor));

create table INVENTORY(Bloodbag_id int not null auto_increment, Bank_id int, primary key (Bloodbag_id, Bank_id), 
foreign key (Bloodbag_id) references BLOODBAG(id_Bloodbag), 
foreign key (Bank_id) references BANK(id_Bank));

create table VACCOUNT(id_Account int not null auto_increment, Vampire_id int not null unique, preference int, 
allowance int, Create_Date Date, primary key (id_Account), 
foreign key (Vampire_id) references VAMPIRE(id_Vampire), 
foreign key (preference) references BLOODTYPE(id_Bloodtype));

create table Transaction(Account_id int, Bloodbag_id int, 
TDate date not null, primary key(Account_id, Bloodbag_id), 
foreign key (Account_id) references VACCOUNT(id_Account), 
foreign key (Bloodbag_id) references BLOODBAG(id_BloodBag));

insert into BLOODTYPE(id_Bloodtype, bType) values (1, 'A+');
insert into BLOODTYPE(id_Bloodtype, bType) values (2, 'A-');
insert into BLOODTYPE(id_Bloodtype, bType) values (3, 'B+');
insert into BLOODTYPE(id_Bloodtype, bType) values (4, 'B-');
insert into BLOODTYPE(id_Bloodtype, bType) values (5, 'O+');
insert into BLOODTYPE(id_Bloodtype, bType) values (6, 'O-');
insert into BLOODTYPE(id_Bloodtype, bType) values (7, 'AB+');
insert into BLOODTYPE(id_Bloodtype, bType) values (8, 'AB-');

insert into DONOR(id_Donor, Bloodtype_id, Lst_Donation, Pers_Info, Date_Start) 
values (101, 5, '2022-10-31', 'Likes Chocolate', '2020-1-1');
insert into DONOR(id_Donor, Bloodtype_id, Lst_Donation, Pers_Info, Date_Start) 
values (102, 3, '2021-8-20', 'Partied too hard on the eve of the new millennium', '1999-12-31');
insert into DONOR(id_Donor, Bloodtype_id, Lst_Donation, Pers_Info, Date_Start) 
values (103, 4, null, 'Worked for JP Morgan', '2007-9-27');

insert into BLOODBAG(id_BLoodBag, Donor_Id, Retr_Date) values (1, 101, '2022-10-1');
insert into BLOODBAG(id_BloodBag, Donor_Id, Retr_Date) values(2, 101, '2022-10-31');
insert into BLOODBAG(id_Bloodbag, Donor_Id, Retr_Date) values(3, 102, '2005-2-2');
insert into BLOODBAG(id_Bloodbag, Donor_Id, Retr_Date) values(4, 102, '2021-8-20');
insert into bloodbag(id_Bloodbag, Donor_id, Retr_date) values(5, 101, '2022-10-15');

insert into Bank(id_Bank, Location, Open_Date) values (1, '1012 Spooky Drive, Howl Michigan', '1856-10-31');
insert into Bank(id_Bank, Location, Open_Date) values (2, '456 Dead Road, Hell Michigan', '1913-8-15');

insert into INVENTORY(Bloodbag_id, Bank_id) values (2, 1);
insert into INVENTORY(bloodbag_id, Bank_id) values (3, 2);
insert into INVENTORY(bloodbag_id, Bank_id) values (4, 2);

insert into VAMPIRE(id_Vampire, FName, LName) values(101, 'Michael', 'Morbius');
insert into VAMPIRE(id_Vampire, FName, LName) values(102, 'John', 'Jonhston');
insert into VAMPIRE(FName, Lname) values('Jimmy', 'Jim');

insert into VACCOUNT(id_Account, Vampire_id, allowance, Create_Date) values (1, 101, 3, '2022-4-1');
insert into VACCOUNT(id_Account, Vampire_id, allowance, Create_Date, preference) values (2, 102, 5, '1988-6-21', 2);

insert into TRANSACTION(Account_id, Bloodbag_id, TDate) values (1, 1, '2022-10-30');
insert into Transaction(Account_id, Bloodbag_id, TDate) values (2, 5, '2023-1-4');

create view addAccount as select id_Vampire, FName, LName from Vampire left join VAccount on Vampire_id = id_Vampire where id_Account is null;

create view viewAccount as select id_account, Vampire_id, allowance, Create_Date, bType as preference from Vaccount left join Bloodtype on id_Bloodtype = preference;

create view cusView as select id_BloodBag, bType, Retr_Date, Location, Donor_id, Pers_Info from Inventory join BLoodbag on Bloodbag_id = id_Bloodbag join Donor on Donor_id = id_Donor join Bloodtype on id_Bloodtype = Bloodtype_id join Bank on Bank_id = id_Bank;

create view newBank as select * from Bank where Open_Date is null;
