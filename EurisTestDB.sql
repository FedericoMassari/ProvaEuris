create database catalog;
use catalog;
create table articles (
    code int primary key auto_increment,
    name varchar(50),
    cost varchar(50)
);

insert into articles (name, cost) values 
('pc', '6p 12s 4d'),
('ps2', '6p 3s 2d'),
('chair', '2p 2s 2d'),
('pizza', '7p 5s 6d'),
('notebook', '12p 4s 6d'),
('bed', '7p 9s 8d'),
('table', '4p 12s 10d'),
('beer', '3p 2s 1d'),
('boardgame', '15p 6s 5d'),
('guitar', '1p 4s 5d');