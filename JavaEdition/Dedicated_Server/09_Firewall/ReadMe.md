**Firewall**

---

1. Wir überprüfen den Status der Firewall:
Befehl: ```sudo ufw status```

2. Standardeinstellungen festlegen: eingehende Verbindungen ablehnen und ausgehende Verbindungen zugelassen.
Befehl: ```sudo ufw default deny incoming```

Befehl: ```sudo ufw default allow outgoing```

3. SSH Port freigeben:
Befehl: ```sudo ufw allow <neuer ssh port>/tcp```

4. Firewall einschalten
Befehl: ```sudo ufw enable```

---

_Weiterführende Informationen:_
* [ufw](https://wiki.ubuntuusers.de/ufw/)
