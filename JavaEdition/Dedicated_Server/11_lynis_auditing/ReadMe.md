**Audit mit lynis**

---

Installation erfolgt über den Befehl: ```sudo apt install lynis```

Untersuchung starten mit dem Befehl: ```sudo lynis audit system```

Aus dem Reports "warning" oder "suggestion" ausgeben, Befehl: ```sudo grep -E "^warning|^suggestion" /var/log/lynis-report.dat```

---

_Weiterführende Informationen:_
* [systemctl](https://wiki.ubuntuusers.de/systemd/systemctl/)
