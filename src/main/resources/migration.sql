DROP TABLE IF EXISTS public.master
CREATE TABLE public.master (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name varchar(15) NOT NULL,
    surname varchar(15) NOT NULL,
    patronymic varchar(15),
    birthday DATE NOT NULL,
    sex varchar(6) NOT NULL,
    phone1 varchar(11) NOT NULL,
    name2 varchar(11),
    city varchar(15) NOT NULL,
    type_of_employment varchar(15) NOT NULL,
    car BOOLEAN NOT NULL DEFAULT FALSE,
    preferred_area varchar(15),
    img varchar(255) NOT NULL,
    status varchar(255) NOT NULL,
    note_about_master varchar(255) NOT NULL,
    age float NOT NULL DEFAULT 3.5
);
alter table master drop column age;
alter table master
    add created date not null;

alter table master
    add updated date;

alter table master
    add rating int NOT NULL ;
alter table master drop column name2;
alter table master alter column rating type float using rating::float;


CREATE TABLE public.employer_documents (
   id BIGSERIAL NOT NULL PRIMARY KEY,
   passport_num varchar(4) NOT NULL,
   passport_series varchar(6) NOT NULL,
   date_of_issue DATE NOT NULL,
   department_code varchar(7) NOT NULL,
   issued_by DATE NOT NULL,
   registration varchar(100) NOT NULL,
   sex varchar(6) NOT NULL,
   status varchar(20) NOT NULL
);

CREATE TABLE public.type_of_work (
  id BIGSERIAL NOT NULL PRIMARY KEY,
  type_of_work varchar(20) NOT NULL
);
ALTER TABLE type_of_work
ADD created TIMESTAMP NOT NULL ,
ADD updated TIMESTAMP NOT NULL ,
ADD status varchar(10) NOT NULL ;



CREATE TABLE public.master_to_type_of_work (
master_id int NOT NULL REFERENCES master(id) ,
type_of_work_id int NOT NULL REFERENCES type_of_work(id)
);


DROP TABLE IF EXISTS public.advert_channel
CREATE TABLE public.advert_channel (
id BIGSERIAL NOT NULL PRIMARY KEY ,
advert_channel_name varchar(25) NOT NULL,
status varchar(10) NOT NULL,
created TIMESTAMP NOT NULL,
updated TIMESTAMP NOT NUll
);

CREATE TABLE public.reason_cancellation (
id BIGSERIAL NOT NULL PRIMARY KEY,
reason_cancellation varchar(80) NOT NULL,
created TIMESTAMP NOT NULL,
updated TIMESTAMP NOT NUll,
status varchar(10) NOT NULL
);

CREATE TABLE public.order_current_step (
id BIGSERIAL NOT NULL PRIMARY KEY ,
order_current_step varchar(160) NOT NULL
);

CREATE TABLE public.orders (
id BIGSERIAL NOT NULL PRIMARY KEY ,
description varchar(150) NOT NULL ,
advert_channel_id int NOT NULL ,
type_of_work_id int NOT NULL,
client_id int,
arrival_time TIMESTAMP,
order_current_step_id int NOT NULL,
reason_cancellation_id int
);

CREATE TABLE public.order_current_step_to_orders (
order_id int NOT NULL REFERENCES orders(id),
order_current_step_id int NOT NULL REFERENCES order_current_step(id)
);

ALTER  TABLE employer_documents
ADD employer_type varchar(25),
ADD created TIMESTAMP NOT NULL,
ADD updated TIMESTAMP NOT NULL;


CREATE TABLE public.client (
id BIGSERIAL NOT NULL PRIMARY KEY,
name varchar(20) NOT NULL,
surname varchar(30),
age varchar(5),
phone1 varchar(12) NOT NULL ,
phone2 varchar(12),
sex varchar(6) NOT NULL ,
description varchar(255) NOT NULL ,
created TIMESTAMP NOT NULL,
updated TIMESTAMP NOT NULL ,
status varchar(20) NOT NULL
);

CREATE TABLE public.operator_call_center (
id BIGSERIAL NOT NULL PRIMARY KEY ,
name varchar(20) NOT NULL ,
surname varchar(20) NOT NULL ,
age varchar(25) NOT NULL ,
birthday DATE NOT NULL ,
sex varchar(6) NOT NULL ,
phone1 varchar(11) NOT NULL ,
phone2 varchar(11),
city varchar(20) NOT NULL ,
img varchar(255),
status varchar(20) NOT NULL ,
note_about_operator varchar(255) NOT NULL ,
rating int
);

ALTER TABLE operator_call_center RENAME COLUMN age TO birthday;

ALTER TABLE operator_call_center ADD COLUMN created date,
ADD COLUMN updated date;

alter table operator_call_center alter column patronyic drop not null;

CREATE TABLE public.master_review (
  id BIGSERIAL NOT NULL PRIMARY KEY ,
  review varchar(255) NOT NULL,
  created date NOT NULL ,
  updated date NOT NULL,
  status varchar(15),
  master_id bigint NOT NULL
);
alter table master_review
    add constraint master_review_master_id_fk
        foreign key (master_id) references master;







