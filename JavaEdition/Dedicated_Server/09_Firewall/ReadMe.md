**Firewall**

---

**Wir überprüfen den Status der Firewall**

Befehl: ```sudo ufw status```

Ausgabe:
```
Status: inactive
```

---

**Standardeinstellungen festlegen**
**Eingehende Verbindungen ablehnen und ausgehende Verbindungen zugelassen**

Befehl: ```sudo ufw default deny incoming```

Ausgabe:
```
Default incoming policy changed to 'deny'
(be sure to update your rules accordingly)
```

Befehl: ```sudo ufw default allow outgoing```

Ausgabe:
```
Default outgoing policy changed to 'allow'
(be sure to update your rules accordingly)
```

---

**SSH Port freigeben**

Befehl: ```sudo ufw allow 33771/tcp```

Ausgabe:
```
Rules updated
Rules updated (v6)
```

---

**Firewall einschalten**

Befehl: ```sudo ufw enable```

Ausgabe:
```
Command may disrupt existing ssh connections. Proceed with operation (y|n)? y
Firewall is active and enabled on system startup
```

---

**Wir überprüfen den Status der Firewall**

Befehl: ```sudo ufw status```

Ausgabe:
```
Status: active

To                         Action      From
--                         ------      ----
33771/tcp                  ALLOW       Anywhere
33771/tcp (v6)             ALLOW       Anywhere (v6)
```

---

**fail2ban Installieren**:

1. Installation durchführen
   * Befehl: ```sudo apt install fail2ban```
2. Automatischer Dienststart beim starten
   * Befehl: ```sudo systemctl enable fail2ban```
3. Dienst jetzt starten
   * Befehl: ```sudo systemctl start fail2ban```
4. Überprüfen des Statuses
   * Befehl: ```sudo systemctl status fail2ban```

Ausgabe:
```
fail2ban.service - Fail2Ban Service
     Loaded: loaded (/lib/systemd/system/fail2ban.service; enabled; vendor preset: enabled)
     Active: active (running) since Sun 2023-10-15 14:54:27 UTC; 5s ago
       Docs: man:fail2ban(1)
   Main PID: 2552 (fail2ban-server)
      Tasks: 5 (limit: 4515)
     Memory: 11.8M
        CPU: 92ms
     CGroup: /system.slice/fail2ban.service
             └─2552 /usr/bin/python3 /usr/bin/fail2ban-server -xf start

Okt 15 14:54:27 server1 systemd[1]: Started Fail2Ban Service.
Okt 15 14:54:27 server1 fail2ban-server[2552]: Server ready
```

**fail2ban Konfigurieren**:

1. Standard-Jail-Konfiguration "erstellen"
   * Befehl: ```sudo cp /etc/fail2ban/jail.conf /etc/fail2ban/jail.local```
2. Standard-Jail-Konfiguration bearbeiten
   * Befehl: ```sudo mcedit /etc/fail2ban/jail.local```
   * Optional: ```sudo sed -i -e '/^#/d' -e '/^$/d' /etc/fail2ban/jail.local```
     * entfernt alle Kommentar- und Leerzeilen
3. eigenes Netzwerk ausnehmen
   * füge in die Sektion ```[DEFAULT]``` dein IP-Netz hinzu
     * Zum Beispiel: ```ignoreip = 127.0.0.1/8 ::1 192.168.0.0/24```
4. Einstellungen die von Interesse sind:
   * ```bantime``` = Zeitangabe wie lang ein ban dauert
   * ```findtime``` = Zeitspanne in der Interaktionen stattfinden
   * ```maxretry``` = Anzahl der Fehlversuche
5. SSH-Dienst aktivieren
   * füge unterhalb der Sektion ```[sshd]``` folgende Zeilen ein:
     * ```enabled = true```
6. Dienst neu starten
   * Befehl: ```sudo systemctl restart fail2ban```
7. Konfiguration Überprüfen
   * Befehl: ```sudo fail2ban-client ping```
   * Antwort: ```Server replied: pong```
8. Status des SSH-Dienstes prüfen
   * Befehl: ```sudo fail2ban-client status sshd```

Ausgabe:
```
Status for the jail: sshd
|- Filter
|  |- Currently failed: 0
|  |- Total failed:     0
|  `- File list:        /var/log/auth.log
`- Actions
   |- Currently banned: 0
   |- Total banned:     0
   `- Banned IP list:
```
9. Optionen prüfen
   * Befehl: ```sudo fail2ban-client get sshd ignoreip```
Ausgabe:
```
These IP addresses/networks are ignored:
|- 127.0.0.0/8
|- 192.168.0.0/24
`- ::1
```
   * Befehl: ```sudo fail2ban-client get sshd bantime```
Ausgabe:
```
600
```
   * Befehl: ```sudo fail2ban-client get sshd maxretry```
Ausgabe:
```
5
```
   * Befehl: ```sudo fail2ban-client get sshd actions```
Ausgabe:
```
The jail sshd has the following actions:
iptables-multiport
```
   * Befehl: ```sudo fail2ban-client get sshd findtime```
Ausgabe:
```
600
```

---

**Anregung: Geo-IP-Blocking**

* [https://www.ip2location.com/free/visitor-blocker](https://www.ip2location.com/free/visitor-blocker/)
* [https://www.countryipblocks.net/acl.php](https://www.countryipblocks.net/acl.php/)

---

_Weiterführende Informationen:_
* [ufw](https://wiki.ubuntuusers.de/ufw/)
* [fail2ban](https://wiki.ubuntuusers.de/fail2ban/)
* [systemctl](https://wiki.ubuntuusers.de/systemd/systemctl/)
