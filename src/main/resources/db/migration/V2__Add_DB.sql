insert into public.admin(first_name, last_name, email, status)
values ('Artem', 'Art', 'art@mail.ru', 'CREATED');

insert into public.client(first_name, last_name, date_birth, email, status)
values ('Ivan', 'Ivanov', '1998-05-05', 'iii@mail.ru', 'CREATED');

insert into public.center(city, address, phone, email, open_data, admin_id, status)
values ('Moscow', 'Lenina', 8005007, 'aaa@mail.ru', '2022-01-01', 1, 'CREATED');

insert into public.manager(first_name, last_name, date_birth, employment_date, phone, email, center_id, status)
values ('Petr', 'Petrov', '1998-05-05', '2022-01-01', 1624070, 'ppp@mail.ru', 1, 'CREATED');

insert into public.request(visit_date, travel_date, client_id, center_id, manager_id, status)
values ('2022-01-08', '2022-08-08', 1, 1, 1, 'CREATED');

insert into public.visa(visa_type, visa_term, purpose, country, price, admin_id, center_id, status)
values ('long', 180, 'tourism', 'italy', 10000, 1, 1, 'CREATED');