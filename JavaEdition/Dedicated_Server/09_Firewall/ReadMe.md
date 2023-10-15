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

**Anregung: Geo-IP-Blocking**

[https://www.ip2location.com/free/visitor-blocker](https://www.ip2location.com/free/visitor-blocker/)

[https://www.countryipblocks.net/acl.php](https://www.countryipblocks.net/acl.php/)

---

_Weiterführende Informationen:_
* [ufw](https://wiki.ubuntuusers.de/ufw/)
