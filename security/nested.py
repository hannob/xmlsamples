#!/usr/bin/python3
# SPDX-License-Identifier: 0BSD

DEPTH = 100000

print("<!DOCTYPE nested [<!ENTITY a 'a'>")

before = "a"
for i in range(1, DEPTH):
    ent = ""
    x = i
    while x > 0:
        ent = chr(ord("a") + x % 26) + ent
        x = x // 26
    print(f"<!ENTITY {ent} '&{before};'>")
    before = ent

print(f"]><x>&{ent};</x>")
