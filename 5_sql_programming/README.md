SQL Programming

1. List the title, release year, genre and director of all ​'action'​ movies.

```
postgres=# SELECT title, release_year, genre, director FROM movies WHERE genre='action';

      title       | release_year | genre  |     director
------------------+--------------+--------+------------------
 Independence Day |         1996 | action | Roland Emmerich
 Jurassic Park    |         1993 | action | Steven Spielberg
 Die Hard         |         1988 | action | John McTiernan
(3 rows)
```

2. List the actors and their birth year for all movies directed by ​'Wes Anderson'​.

```
postgres=# SELECT DISTINCT actors.name, actors.birth_year FROM actors JOIN movie_cast ON actors.name=movie_cast.actor JOIN movies ON movie_cast.movie=movies.title WHERE movies.director='Wes Anderson';

     name      | birth_year
---------------+------------
 Bruce Willis  |       1955
 Bill Murray   |       1950
 Jeff Goldblum |       1952
(3 rows)
```

3. List the title, release year, genre and director of all movies staring ​'Jeff Goldblum'
but not ​'Bruce Willis'​.

```
postgres=# SELECT movies.title, movies.release_year, movies.genre, movies.director FROM movies JOIN movie_cast on movies.title=movie_cast.movie JOIN actors ON movie_cast.actor=actors.name WHERE actors.name='Jeff Goldblum' EXCEPT SELECT movies.title, movies.release_year, movies.genre, movies.director FROM movies JOIN movie_cast on movies.title=movie_cast.movie JOIN actors ON movie_cast.actor=actors.name WHERE actors.name='Bruce Willis';


          title           | release_year | genre  |     director
--------------------------+--------------+--------+------------------
 Jurassic Park            |         1993 | action | Steven Spielberg
 Independence Day         |         1996 | action | Roland Emmerich
 The Grand Budapest Hotel |         2014 | comedy | Wes Anderson
(3 rows)

```
