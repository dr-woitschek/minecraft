**SSH absichern**

---

1. Wir erstellen eine Sicherheitskopie der vorhandenen SSHD-Konfigurationsdatei.
* Befehl: ```sudo cp /etc/ssh/sshd_config /etc/ssh/sshd_config.BACKUP```
* Überprüfen mit dem Befehl: ```sudo ls -aFlh /etc/ssh/sshd_config*```

Ausgabe:
```

-rw-r--r-- 1 root root 3,2K Jul 19 19:41 /etc/ssh/sshd_config
-rw-r--r-- 1 root root 3,2K Okt 15 12:58 /etc/ssh/sshd_config.BACKUP

```



---

_Weiterführende Informationen:_
* [ssh](https://wiki.ubuntuusers.de/SSH/)
* [PuTTY-Tools](https://www.chiark.greenend.org.uk/~sgtatham/putty/latest.html/)
