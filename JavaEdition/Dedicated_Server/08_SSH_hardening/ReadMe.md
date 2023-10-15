**SSH absichern**

---

**1. Wir erstellen eine Sicherheitskopie der vorhandenen SSHD-Konfigurationsdatei**

Befehl: ```sudo cp /etc/ssh/sshd_config /etc/ssh/sshd_config.BACKUP```

Überprüfen mit dem Befehl: ```sudo ls -aFlh /etc/ssh/sshd_config*```

Ausgabe:
```

-rw-r--r-- 1 root root 3,2K Jul 19 19:41 /etc/ssh/sshd_config
-rw-r--r-- 1 root root 3,2K Okt 15 12:58 /etc/ssh/sshd_config.BACKUP

```

> Optional: Mit dem Befehl ```sudo sed -i -e '/^#/d' -e '/^$/d' /etc/ssh/sshd_config``` entfernen wir alle Kommentare und Leerzeilen.

---

Anpassen der Datei _/etc/ssh/sshd_config_

Mit dem Befehl ```sudo nano /etc/ssh/sshd_config``` bearbeiten wir die Konfigurationsdatei.

| Einstellung          | Beschreibung |
| -------------------- | ------------ |
| Include /etc/ssh/sshd_config.d/*.conf | Bindet die festgelegte Konfigurationsdatei ein. Es können mehrere Pfadnamen festgelegt werden und jeder Pfadname darf Platzhalter enthalten, die expandiert und in lexikalischer Reihenfolge verarbeitet werden. Von Dateien ohne absolute Pfade wird vermutet, dass sie in /etc/ssh liegen. Innerhalb eines Match-Blocks kann eine Include -Direktive auftauchen, um bedingte Einbindung durchzuführen. |
| Port 33771                            | Legt die Port-Nummer fest, an der sshd auf Anfragen warten soll. Mehrere Optionen dieser Art sind erlaubt.<br/><br/>Standard-Einstellung: 22 |
| KbdInteractiveAuthentication no       | Legt fest, ob interaktive Anmeldung über die Tastatur erlaubt wird. Das Argument für dieses Schlüsselwort muss yes oder no lauten. Die Vorgabe ist, den Wert zu verwenden, auf den ChallengeResponseAuthentication gesetzt ist.<br/><br/>Standard-Einstellung: yes |
	

---

_Weiterführende Informationen:_
* [ssh](https://wiki.ubuntuusers.de/SSH/)
* [sed](https://wiki.ubuntuusers.de/sed/)
