Bash Scripting
==


# `count.sh`
Example:
```
$ ./count.sh ..
      28 ../README.md
       8 ../.gitignore
       6 ../.github/CODEOWNERS
      19 ../.git/config
      ...
```

# `histogram.sh`
Note: `GNU Awk 5.1.0` is used.

Example:
```
$ ./histogram.sh ../README.md
( ) =================== (19)
(() = (1)
()) = (1)
(.) ========== (10)
(/) = (1)
(1) == (2)
(2) = (1)
(3) = (1)
...

```
