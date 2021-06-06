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
Note: `gawk` is required. Please [install](https://www.gnu.org/software/gawk/manual/html_node/Installation.html) if you don't have it.

Example:
```
$ ./histogram.sh ../README.md
( ) =================== (19)
(.) ========== (10)
(/) = (1)
(1) == (2)
...

```
