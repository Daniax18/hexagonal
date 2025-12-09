create table customer(
    customer_id int AUTO_INCREMENT PRIMARY KEY,
    customer_name varchar(100),
    customer_mdp varchar(100),
    customer_email varchar(100),
    customer_tel varchar(100),
    customer_dtn date
);

insert into customer values(256, 'Jean', 'Jean', 'jean@gmail.com', '1234', '1990/12/01');