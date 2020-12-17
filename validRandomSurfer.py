#!/usr/bin/env python
# coding=utf-8
import functools
import sys

for line in sys.stdin:
    print(line)
    result = functools.reduce(lambda a,b : float(a) + float(b),line.strip().split(" "))
    print(result)
    if 1 == result:
        print("Valid")
    else:
        print("Invalid")
