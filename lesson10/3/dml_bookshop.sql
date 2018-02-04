use bookshop;

#book
insert into book values (null, 'Azbyka', 245.0, 'n', 2006, 2008-11-11);
insert into book values (null, 'Gore ot yma', 235.0, 'y', 2001, 2001-09-14);
insert into book values (null, 'Master i margarita', 600.0, 'y', 2011, 2002-07-24);
insert into book values (null, 'Idiot', 149.99, 'n', 2006, 1999-03-31);
insert into book values (null, 'Don Quixote', 750.15, 'y', 2016, 1991-05-21);
insert into book values (null, 'Romeo and Juliet', 625.70, 'y', 2001, 1996-01-10);
insert into book values (null, 'Fairy tales', 600.90, 'y', 1992, 2015-12-09);
insert into book values (null, 'Coloring book', 2250.0, 'n', 1988, 2007-09-05);

#order
insert into orders values (null, 1, 2007-09-05, 'processing');
insert into orders values (null, 7, 2015-12-09, 'processing');
insert into orders values (null, 7, 2003-05-07, 'processing');
insert into orders values (null, 7, 1999-03-03, 'processing');
insert into orders values (null, 1, 2011-02-04, 'processing');
insert into orders values (null, 1, 2009-03-11, 'processing');
insert into orders values (null, 5, 2005-05-25, 'processing');
insert into orders values (null, 5, 2017-07-17, 'processing');
insert into orders values (null, 4, 2016-08-17, 'processing');
insert into orders values (null, 4, 2016-07-18, 'processing');

#request
insert into requests values (null, 1);
insert into requests values (null, 2);
insert into requests values (null, 3);
insert into requests values (null, 4);
insert into requests values (null, 1);
insert into requests values (null, 8);
insert into requests values (null, 8);
