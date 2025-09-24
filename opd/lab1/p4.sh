# suppose we are in 'lab0' dir

cat n* 2>/dev/null | wc -m

ls -lR . 2>/tmp/error2 | grep ' l[^/]*$' | sort -k5n | tail -n 3

cat -n infernape0/mienshao infernape0/squirtle lucario5/kabuto lucario5/arcanine | sort -rk2

# how to pass file list to 'ls'? if 'Permission denied' is thrown, then ls will print a lot of junk
# grep -rl "to" . 2>&1 | ls -l 2>&1 | sort -nrk5

ls -luR . | grep ' t[^/]*$' | sort -k6M -k7n -k8

wc -m nidorino7 2>&1 | grep -o '^[0-9]*' >> nidorino7
