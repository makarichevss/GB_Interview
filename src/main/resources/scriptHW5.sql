use temp_schema;

create table `temp_schema`.`student` (
                                  `id` int not null auto_increment,
                                  `name` varchar(45) not null ,
                                  `mark` int not null ,
                                  primary key (`id`));

