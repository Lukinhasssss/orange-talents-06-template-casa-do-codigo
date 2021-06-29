insert into tb_author(name, email, description, registered_at) values('Alex Green', 'alex@gmail.com', 'Descrição do Alex', TIMESTAMP WITH TIME ZONE '2021-06-28T10:00:00.12345Z');
insert into tb_author(name, email, description, registered_at) values('Ana Grey', 'ana@gmail.com', 'Descrição da Ana', TIMESTAMP WITH TIME ZONE '2021-06-28T11:00:00.12345Z');
insert into tb_author(name, email, description, registered_at) values('Bob Brown', 'bob@gmail.com', 'Descrição do Bob', TIMESTAMP WITH TIME ZONE '2021-06-28T12:00:00.12345Z');

insert into tb_category(name) values('Programação');
insert into tb_category(name) values('Mobile');
insert into tb_category(name) values('Front-end');
insert into tb_category(name) values('Design & UX');

-- insert into tb_book(title, resume, sumary, price, pages, isbn, publication_date, category_id, author_id) values ('Título do livro 1', 'Resumo do livro 1', 'Sumário do livro 1' 21.89, 120, '987abc', TIMESTAMP WITH TIME ZONE '2021-09-15', 3, 1);
-- insert into tb_book(title, resume, sumary, price, pages, isbn, publication_date, category_id, author_id) values ('Título do livro 2', 'Resumo do livro 2', 'Sumário do livro 2' 198.90, 100, '123qwerty', TIMESTAMP WITH TIME ZONE '2021-09-16', 3, 2);
-- insert into tb_book(title, resume, sumary, price, pages, isbn, publication_date, category_id, author_id) values ('Título do livro 3', 'Resumo do livro 3', 'Sumário do livro 3' 79.99, 220, 'qwerty123', TIMESTAMP WITH TIME ZONE '2021-10-06', 1, 3);
-- insert into tb_book(title, resume, sumary, price, pages, isbn, publication_date, category_id, author_id) values ('Título do livro 4', 'Resumo do livro 4', 'Sumário do livro 4' 32.00, 480, 'abc987', TIMESTAMP WITH TIME ZONE '2021-11-07', 2, 2);