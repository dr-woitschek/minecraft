**/etc/sysctl.conf abhärten**

---

**Grundsätzliches - Was ist der Unterschied zwischen den "all", "default" oder "eth0 (Gerätename)" Einstellungen:**
```net.ipv4.conf.all.accept_source_route = 0```
```net.ipv4.conf.default.accept_source_route = 0```
```net.ipv4.conf.eth0.accept_source_route = 1```

- "all" ändert die Einstellung für alle existierenden Geräte, egal welche Einstellung die Geräte selbst besitzen.
- "default" ist die Standardeinstellung für neu hinzugefügte Geräte.
- Im Beispiel angeführte Einstellung für "eth0" gilt nur für das Gerät.

---

Edit mit Befehl:
```sudo nano /etc/sysctl.conf```

---

| #           | Beschreibung           |
| ----------- | ---------------------- |
| Einstellung | **net.ipv4.ip_forward = 0** |
| Erklärung   | Die Einstellung `net.ipv4.ip_forward` ist eine wichtige Konfigurationsmöglichkeit in Linux, die die IP-Paketweiterleitung auf einem System steuert. IP-Paketweiterleitung bezieht sich auf die Fähigkeit eines Linux-Systems, IP-Pakete von einer Netzwerkschnittstelle zu empfangen und diese Pakete an eine andere Netzwerkschnittstelle weiterzuleiten, anstatt sie nur für die lokale Verarbeitung zu behalten.<br><br>- Wenn `net.ipv4.ip_forward` auf den Wert `0` (standardmäßig) gesetzt ist, ist die IP-Weiterleitung deaktiviert. Das bedeutet, dass das System keine IP-Pakete von einer Schnittstelle empfängt und sie an eine andere Schnittstelle weiterleitet. Das System verarbeitet nur den lokalen Verkehr.<br><br>- Wenn `net.ipv4.ip_forward` auf den Wert `1` gesetzt wird, wird die IP-Weiterleitung aktiviert. Das System fungiert dann als IP-Router und kann IP-Pakete zwischen den angeschlossenen Netzwerkschnittstellen weiterleiten. Dies ist nützlich, wenn das Linux-System als Router oder Gateway zwischen verschiedenen Netzwerken fungieren soll.<br>Die Aktivierung der IP-Weiterleitung ist erforderlich, wenn ein Linux-System als Router oder Gateway in einem Netzwerk eingesetzt werden soll. Es ermöglicht dem System, Datenverkehr zwischen verschiedenen Netzwerkschnittstellen weiterzuleiten, wodurch der Datenaustausch zwischen Netzwerken ermöglicht wird. Dies ist besonders wichtig in komplexen Netzwerktopologien, in denen Datenverkehr zwischen Subnetzen oder verschiedenen Netzwerken geroutet werden muss.<br>Es ist jedoch wichtig zu beachten, dass die Aktivierung der IP-Weiterleitung auch Sicherheitsüberlegungen erfordert, da ein System, das als Router fungiert, den Datenverkehr zwischen Netzwerken kontrolliert. Es sollte angemessen konfiguriert und abgesichert werden, um unerwünschten Datenverkehr zu verhindern und die Sicherheit des Netzwerks zu gewährleisten. |

---

Reload, Befehl: ```sudo sysctl -p```

Reboot, Befehl: ```sudo reboot```

Anmerkung: sollte Kernel panic entstehen ```kernel.panic=10```

---

_Weiterführende Informationen:_
* [systemctl](https://wiki.ubuntuusers.de/systemd/systemctl/)
