General Administration
==

# 1. log in

command: `ssh -i ./instaclustr-test-key.pem ubuntu@54.183.229.102 -p 2222`

Saw the following, which suggests some security updates need to be performed. Also reboot is needed.

```
9 packages can be updated.
2 of these updates are security updates.
To see these additional updates run: apt list --upgradable

*** System restart required ***
```

Then saw a warning below

```
WARNING! Your environment specifies an invalid locale.
 The unknown environment variables are:
   LC_CTYPE=en_GB.UTF-8 LC_ALL=
 This can affect your user experience significantly, including the
 ability to manage packages. You may install the locales by running:

   sudo apt-get install language-pack-en
     or
   sudo locale-gen en_GB.UTF-8
...
```

Then run `locale`. It seems the `LC_CTYPE` should be set to `en_US.UTF-8` or the `en_GB.UTF-8` should be installed.

```
locale: Cannot set LC_CTYPE to default locale: No such file or directory
locale: Cannot set LC_ALL to default locale: No such file or directory
LANG=en_US.UTF-8
LANGUAGE=
LC_CTYPE=en_GB.UTF-8
LC_NUMERIC="en_US.UTF-8"
LC_TIME="en_US.UTF-8"
LC_COLLATE="en_US.UTF-8"
LC_MONETARY="en_US.UTF-8"
LC_MESSAGES="en_US.UTF-8"
LC_PAPER="en_US.UTF-8"
LC_NAME="en_US.UTF-8"
LC_ADDRESS="en_US.UTF-8"
LC_TELEPHONE="en_US.UTF-8"
LC_MEASUREMENT="en_US.UTF-8"
LC_IDENTIFICATION="en_US.UTF-8"
LC_ALL=
```

# 2. check disk

`df -h` shows the disk is almost full:

```
Filesystem      Size  Used Avail Use% Mounted on
udev            488M  4.0K  488M   1% /dev
tmpfs           100M  864K   99M   1% /run
/dev/xvda1      7.7G  7.5G  187M  98% /
```

Using `du -h -d=1 <dir>` repeatedly allows me to find this guy:

```
$ ll /var/lib/reallybigfile -h
-rw-r--r-- 1 root root 6.2G Apr  7 00:48 /var/lib/reallybigfile
```

# 3. check cpu/mem

Using `top` and sort by mem and cpu I found this suspicious program:

```
PID USER      PR  NI    VIRT    RES    SHR S %CPU %MEM     TIME+ COMMAND
353 root      20   0  751560 723620   2616 S  0.0 71.3   0:09.24 python3 /var/lib/.instaclustr/hungryprogram.py
```

Then I went to see what this guy is doing:

```
$ cat /var/lib/.instaclustr/hungryprogram.py
import sys
import time
count = 700
megabyte = (0,) * (1024 * 1024 // 8)

data = megabyte * count

while True:
        time.sleep(1)
```

# 4. other checks
Used `lsof` and `nmon` but couldn't find anything suspicious related with network, filesystem etc so I stopped here.
