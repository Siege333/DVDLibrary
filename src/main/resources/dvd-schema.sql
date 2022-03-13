drop table if exists dvd CASCADE; 
create table dvd (
dvd_id integer AUTO_INCREMENT, 
bbfc_rating varchar(255), 
genre varchar(255), 
main_actor varchar(255), 
main_actress varchar(255), 
release_date integer, 
running_time integer, 
film_title varchar(255), 
primary key (dvd_id)
);