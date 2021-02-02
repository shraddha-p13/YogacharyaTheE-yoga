CREATE TABLE blog_details
(
	id char(32) NOT NULL,
	name varchar(100) NOT NULL,
    description text,
	CONSTRAINT blog_id_pk PRIMARY KEY (id)
);

CREATE TABLE course_details
(
	id char(32) NOT NULL,
	name varchar(100) NOT NULL,
    course_level varchar(100) NOT NULL,
	CONSTRAINT course_details_id_pk PRIMARY KEY (id)
);

CREATE TABLE diet_plan_details
(
	id char(32) NOT NULL,
	name varchar(100) NOT NULL,
    description text,
	CONSTRAINT diet_plan_details_id_pk PRIMARY KEY (id)
);

CREATE TABLE diet_recipe_details
(
	id char(32) NOT NULL,
	name varchar(100) NOT NULL,
    description text,
	CONSTRAINT diet_recipe_details_id_pk PRIMARY KEY (id)
);


CREATE TABLE user_details
(
	id char(32) NOT NULL,
	first_name varchar(100) NOT NULL,
	last_name varchar(100) NOT NULL,
	email varchar(100) NOT NULL,
	password varchar(20) NOT NULL,
	contact_number varchar(10) NOT NULL,
	CONSTRAINT user_details_id_pk PRIMARY KEY (id)
);

CREATE TABLE role
(
	id char(32)  NOT NULL,
	role_name   varchar(100) NOT NULL,
	CONSTRAINT role_id_pk PRIMARY KEY (id)
);

CREATE TABLE user_role_details
(
	id char(32)  NOT NULL,
	user_id  char(32) ,
	role_id char(32),
	CONSTRAINT role_id_pk PRIMARY KEY (id),
	CONSTRAINT fk_user_details_id FOREIGN KEY (user_id)
      REFERENCES user_details (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_user_role_id FOREIGN KEY (role_id)
      REFERENCES role (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE course_instructor_details
(
	id char(32)  NOT NULL,
	course_id  char(32) ,
	instructor_id char(32),
	link text,
	CONSTRAINT course_instructor_details_id_pk PRIMARY KEY (id),
	CONSTRAINT fk_course_details_id FOREIGN KEY (course_id)
      REFERENCES course_details (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_course_user_details_id FOREIGN KEY (instructor_id)
      REFERENCES user_details (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

INSERT INTO role(id,role_name)
VALUES
('4721002268c24ae1e3a29e50ec87ebf9','ADMIN'),
('f22890418b164aa1bdf76452342ffd8a','INSTRUCTOR'),
('79b246bde5084b9c914a07536cdf4ba8','TRAINEE');
