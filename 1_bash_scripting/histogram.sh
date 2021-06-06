#!/bin/bash

IN_FILE=$1
gawk 'BEGIN {FS=""} {for(i=1;i<=NF;i++)w[$i]++}END{for(i in w) {t=sprintf("%-*s", w[i], ""); gsub(" ", "=", t); printf("(%s) %s (%s)\n", i,t,w[i])}}' $IN_FILE
