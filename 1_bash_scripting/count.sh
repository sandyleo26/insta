#!/bin/bash

DIR=$1
find $DIR -type f | xargs wc -w
