CREATE TABLE public.person (
	id SERIAL PRIMARY KEY,
	"name" varchar(100) NOT NULL,
	age INT NOT NULL,
	birthday date NOT NULL
);

CREATE TABLE public.address (
	id SERIAL PRIMARY KEY,
	zipcode varchar(8) NOT NULL,
	person INT NOT NULL
);

ALTER TABLE public.address ADD CONSTRAINT fk_person FOREIGN KEY (person) REFERENCES public.person(id);

INSERT INTO public.person("name", age, birthday) VALUES('Brian Domingues', 46, '1976-01-15');
INSERT INTO public.person("name", age, birthday) VALUES('Alvaro Toretto', 45, '1977-03-11');

INSERT INTO public.address(zipcode, person) VALUES('23424567', 1);
INSERT INTO public.address(zipcode, person) VALUES('26545675', 1);

INSERT INTO public.address(zipcode, person) VALUES('23543567', 2);
INSERT INTO public.address(zipcode, person) VALUES('24324567', 2);