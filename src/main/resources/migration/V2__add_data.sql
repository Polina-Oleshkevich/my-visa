insert into public.admin(first_name, last_name, email, login, password, status)
values ('Artem', 'Art', 'art@mail.ru', 'Art', 123, 'CREATED');

insert into public.client(first_name, last_name, date_birth, email, login, password, status)
values ('Ivan', 'Ivanov', '1998-05-05', 'iii@mail.ru', 'aaa', 123, 'CREATED');

insert into public.center(city, address, phone, email, open_data, admin_id, status)
values ('Krasnodar', 'str. Krasnaya 155, 607', '89898989898', 'polina.visa@mail.ru', '01.01.2022', 1, 'CREATED');

insert into public.manager(first_name, last_name, date_birth, employment_date, phone, email, login, password, status)
values ('Ivan', 'Petrov', 1998-05-05, '01.01.2022', '89181624070', 'ppp@mail.ru', 'ppp', 123, 'CREATED');

insert into public.request(country, travel_date, status)
values ('italy', '01.08.2022', 'CREATED');

insert into public.visa(visa_type, visa_term, purpose, country, price, status)
values ('long', '180', 'tourism', 'Italy', '10000', 'CREATED');

insert into public.user(username, password, enabled)
values ('Petrov', 123, 'true');

insert into public.authority(authority, user)
values ('ROLE_MANAGER', 'Petrov');

insert into public.authority(authority, user)
values ('ROLE_ADMIN', 'Art');