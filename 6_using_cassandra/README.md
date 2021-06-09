Using Cassandra
==

## 1. log in
```
cqlsh 34.199.147.101 9042 -u $USER -p $PASS
```

## 2. create keyspace and table
```
iccassandra@cqlsh> CREATE KEYSPACE movie WITH REPLICATION = {'class': 'SimpleStrategy', 'replication_factor': 1};

iccassandra@cqlsh> CREATE TABLE movie.movies (
  title text PRIMARY KEY,
  release_year int,
  genre text,
  director text
);
```

## 3. import data
```
iccassandra@cqlsh> COPY movie.movies (title,release_year,genre,director) FROM './movies.csv' WITH DELIMITER=',' AND HEADER=TRUE;
```

## 4. verify
```

iccassandra@cqlsh> SELECT * FROM movie.movies;
 title                    | director         | genre  | release_year
--------------------------+------------------+--------+--------------
               The Player |    Robert Altman | comedy |         1992
            Jurassic Park | Steven Spielberg | action |         1993
         Moonrise Kingdom |     Wes Anderson | comedy |         2012
             Ghostbusters |     Ivan Reitman | comedy |         1984
         Independence Day |  Roland Emmerich | action |         1996
                 Die Hard |   John McTiernan | action |         1988
 The Grand Budapest Hotel |     Wes Anderson | comedy |         2014

(7 rows)
```
