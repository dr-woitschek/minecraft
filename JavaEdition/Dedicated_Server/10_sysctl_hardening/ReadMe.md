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

| #           | Beschreibung                |
| ----------- | --------------------------- |
| Einstellung | **net.ipv4.ip_forward = 0** |
| Erklärung   | Die Einstellung `net.ipv4.ip_forward` ist eine wichtige Konfigurationsmöglichkeit in Linux, die die IP-Paketweiterleitung auf einem System steuert. IP-Paketweiterleitung bezieht sich auf die Fähigkeit eines Linux-Systems, IP-Pakete von einer Netzwerkschnittstelle zu empfangen und diese Pakete an eine andere Netzwerkschnittstelle weiterzuleiten, anstatt sie nur für die lokale Verarbeitung zu behalten.<br><br>- Wenn `net.ipv4.ip_forward` auf den Wert `0` (standardmäßig) gesetzt ist, ist die IP-Weiterleitung deaktiviert. Das bedeutet, dass das System keine IP-Pakete von einer Schnittstelle empfängt und sie an eine andere Schnittstelle weiterleitet. Das System verarbeitet nur den lokalen Verkehr.<br><br>- Wenn `net.ipv4.ip_forward` auf den Wert `1` gesetzt wird, wird die IP-Weiterleitung aktiviert. Das System fungiert dann als IP-Router und kann IP-Pakete zwischen den angeschlossenen Netzwerkschnittstellen weiterleiten. Dies ist nützlich, wenn das Linux-System als Router oder Gateway zwischen verschiedenen Netzwerken fungieren soll.<br>Die Aktivierung der IP-Weiterleitung ist erforderlich, wenn ein Linux-System als Router oder Gateway in einem Netzwerk eingesetzt werden soll. Es ermöglicht dem System, Datenverkehr zwischen verschiedenen Netzwerkschnittstellen weiterzuleiten, wodurch der Datenaustausch zwischen Netzwerken ermöglicht wird. Dies ist besonders wichtig in komplexen Netzwerktopologien, in denen Datenverkehr zwischen Subnetzen oder verschiedenen Netzwerken geroutet werden muss.<br>Es ist jedoch wichtig zu beachten, dass die Aktivierung der IP-Weiterleitung auch Sicherheitsüberlegungen erfordert, da ein System, das als Router fungiert, den Datenverkehr zwischen Netzwerken kontrolliert. Es sollte angemessen konfiguriert und abgesichert werden, um unerwünschten Datenverkehr zu verhindern und die Sicherheit des Netzwerks zu gewährleisten. |

---

| #           | Beschreibung                                       |
| ----------- | -------------------------------------------------- |
| Einstellung | **net.ipv4.icmp_ignore_bogus_error_responses = 1** |
| Erklärung   | <p>Die Einstellung `net.ipv4.icmp_ignore_bogus_error_responses` in Linux ist eine Sicherheitskonfigurationsoption, die dazu dient, das Ignorieren bestimmter ICMP-Fehlerantworten (auch "bogus error responses" genannt) zu steuern. ICMP (Internet Control Message Protocol) ist ein Protokoll, das verwendet wird, um Fehler- und Kontrollnachrichten im Internet Protocol (IP) zu übertragen.<p><p>Wenn `net.ipv4.icmp_ignore_bogus_error_responses` auf den Wert `1` gesetzt ist, bedeutet dies, dass das System bestimmte als "bogus" oder unerwünscht erachtete ICMP-Fehlerantworten ignoriert. Diese ICMP-Fehlerantworten könnten beispielsweise von potenziell bösartigen Quellen stammen oder zur Irreführung eines Systems verwendet werden.</p><p>Der Begriff "bogus error responses" bezieht sich auf ICMP-Fehlerantworten, die nicht den üblichen und erwarteten Verkehrsmustern entsprechen. Einige Angriffsversuche im Netzwerk können ICMP-Fehlerantworten verwenden, um Informationen zu sammeln oder Verwirrung zu stiften. Durch das Ignorieren solcher Antworten kann die Sicherheit des Systems erhöht werden, da es weniger anfällig für potenziell schädliche Netzwerkaktivitäten wird.</p><p>Es ist wichtig zu beachten, dass das Ignorieren von ICMP-Fehlerantworten in bestimmten Situationen sinnvoll sein kann, jedoch in anderen Fällen potenziell dazu führen kann, dass legitime Netzwerkprobleme nicht erkannt und behoben werden. Die Verwendung dieser Option sollte daher sorgfältig abgewogen werden, und sie sollte nur aktiviert werden, wenn es gute Gründe gibt, ICMP-Fehlerantworten als "bogus" zu kennzeichnen und zu ignorieren. Die Standardeinstellung für diese Option ist in der Regel `0` (deaktiviert), um sicherzustellen, dass alle ICMP-Fehlerantworten behandelt werden.</p> |

---

| #           | Beschreibung                                      |
| ----------- | ------------------------------------------------- |
| Einstellung | **net.ipv4.conf.default.accept_source_route = 0** |
| Erklärung   |  |

---


Reload, Befehl: ```sudo sysctl -p```

Reboot, Befehl: ```sudo reboot```

Anmerkung: sollte Kernel panic entstehen ```kernel.panic=10```

---

_Weiterführende Informationen:_
* [systemctl](https://wiki.ubuntuusers.de/systemd/systemctl/)
