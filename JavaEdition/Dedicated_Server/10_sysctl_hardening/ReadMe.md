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
| Erklärung   | <p>Die Einstellung `net.ipv4.ip_forward` ist eine wichtige Konfigurationsmöglichkeit in Linux, die die IP-Paketweiterleitung auf einem System steuert. IP-Paketweiterleitung bezieht sich auf die Fähigkeit eines Linux-Systems, IP-Pakete von einer Netzwerkschnittstelle zu empfangen und diese Pakete an eine andere Netzwerkschnittstelle weiterzuleiten, anstatt sie nur für die lokale Verarbeitung zu behalten.</p><p>Wenn `net.ipv4.ip_forward` auf den Wert `0` (standardmäßig) gesetzt ist, ist die IP-Weiterleitung deaktiviert. Das bedeutet, dass das System keine IP-Pakete von einer Schnittstelle empfängt und sie an eine andere Schnittstelle weiterleitet. Das System verarbeitet nur den lokalen Verkehr.</p><p>Wenn `net.ipv4.ip_forward` auf den Wert `1` gesetzt wird, wird die IP-Weiterleitung aktiviert. Das System fungiert dann als IP-Router und kann IP-Pakete zwischen den angeschlossenen Netzwerkschnittstellen weiterleiten. Dies ist nützlich, wenn das Linux-System als Router oder Gateway zwischen verschiedenen Netzwerken fungieren soll.<br>Die Aktivierung der IP-Weiterleitung ist erforderlich, wenn ein Linux-System als Router oder Gateway in einem Netzwerk eingesetzt werden soll. Es ermöglicht dem System, Datenverkehr zwischen verschiedenen Netzwerkschnittstellen weiterzuleiten, wodurch der Datenaustausch zwischen Netzwerken ermöglicht wird. Dies ist besonders wichtig in komplexen Netzwerktopologien, in denen Datenverkehr zwischen Subnetzen oder verschiedenen Netzwerken geroutet werden muss.<br>Es ist jedoch wichtig zu beachten, dass die Aktivierung der IP-Weiterleitung auch Sicherheitsüberlegungen erfordert, da ein System, das als Router fungiert, den Datenverkehr zwischen Netzwerken kontrolliert. Es sollte angemessen konfiguriert und abgesichert werden, um unerwünschten Datenverkehr zu verhindern und die Sicherheit des Netzwerks zu gewährleisten.</p> |

---

| #           | Beschreibung                                       |
| ----------- | -------------------------------------------------- |
| Einstellung | **net.ipv4.icmp_ignore_bogus_error_responses = 1** |
| Erklärung   | <p>Die Einstellung `net.ipv4.icmp_ignore_bogus_error_responses` in Linux ist eine Sicherheitskonfigurationsoption, die dazu dient, das Ignorieren bestimmter ICMP-Fehlerantworten (auch "bogus error responses" genannt) zu steuern. ICMP (Internet Control Message Protocol) ist ein Protokoll, das verwendet wird, um Fehler- und Kontrollnachrichten im Internet Protocol (IP) zu übertragen.<p><p>Wenn `net.ipv4.icmp_ignore_bogus_error_responses` auf den Wert `1` gesetzt ist, bedeutet dies, dass das System bestimmte als "bogus" oder unerwünscht erachtete ICMP-Fehlerantworten ignoriert. Diese ICMP-Fehlerantworten könnten beispielsweise von potenziell bösartigen Quellen stammen oder zur Irreführung eines Systems verwendet werden.</p><p>Der Begriff "bogus error responses" bezieht sich auf ICMP-Fehlerantworten, die nicht den üblichen und erwarteten Verkehrsmustern entsprechen. Einige Angriffsversuche im Netzwerk können ICMP-Fehlerantworten verwenden, um Informationen zu sammeln oder Verwirrung zu stiften. Durch das Ignorieren solcher Antworten kann die Sicherheit des Systems erhöht werden, da es weniger anfällig für potenziell schädliche Netzwerkaktivitäten wird.</p><p>Es ist wichtig zu beachten, dass das Ignorieren von ICMP-Fehlerantworten in bestimmten Situationen sinnvoll sein kann, jedoch in anderen Fällen potenziell dazu führen kann, dass legitime Netzwerkprobleme nicht erkannt und behoben werden. Die Verwendung dieser Option sollte daher sorgfältig abgewogen werden, und sie sollte nur aktiviert werden, wenn es gute Gründe gibt, ICMP-Fehlerantworten als "bogus" zu kennzeichnen und zu ignorieren. Die Standardeinstellung für diese Option ist in der Regel `0` (deaktiviert), um sicherzustellen, dass alle ICMP-Fehlerantworten behandelt werden.</p> |

---

| #           | Beschreibung                                      |
| ----------- | ------------------------------------------------- |
| Einstellung | **net.ipv4.conf.default.accept_source_route = 0** |
| Erklärung   | <p>Die Einstellung `net.ipv4.conf.default.accept_source_route` in Linux steuert, ob das System IP-Pakete akzeptiert, die sogenannte "Source Routing" Option verwenden. Source Routing ist eine Technik, bei der der Absender eines IP-Pakets den Weg festlegt, den das Paket im Netzwerk nehmen soll, anstatt dies dem normalen Routing-Algorithmus des Netzwerks zu überlassen.</p><p>Wenn `net.ipv4.conf.default.accept_source_route` auf den Wert `0` gesetzt ist, bedeutet dies, dass das System IP-Pakete ablehnt, die Source Routing verwenden. Mit anderen Worten, das System wird keine IP-Pakete akzeptieren, bei denen der Absender den Pfad, den das Paket durch das Netzwerk nimmt, festgelegt hat. Dies ist eine sicherheitsrelevante Maßnahme, die verhindert, dass potenziell bösartiger oder gefälschter Datenverkehr, der Source Routing verwendet, in das Netzwerk gelangt.</p><p>Die Standardeinstellung für `net.ipv4.conf.default.accept_source_route` ist normalerweise `0`, was darauf abzielt, die Sicherheit des Systems und des Netzwerks zu erhöhen. Das Aktivieren von Source Routing kann dazu verwendet werden, Angriffe zu maskieren oder Datenverkehr durch ungewöhnliche Pfade zu leiten, was potenziell gefährlich ist. Daher ist es ratsam, diese Einstellung normalerweise deaktiviert zu lassen, es sei denn, es gibt spezielle Anforderungen, bei denen Source Routing erforderlich ist. In den meisten Netzwerken ist es jedoch eine bewährte Praxis, Source Routing zu deaktivieren, um die Sicherheit zu gewährleisten.</p> |

---

| #           | Beschreibung         |
| ----------- | -------------------- |
| Einstellung | **kernel.sysrq = 0** |
| Erklärung   | <p>Die Einstellung `kernel.sysrq` in Linux steuert die Verwendung des SysRq-Taste (System Request-Taste) auf der Tastatur. Die SysRq-Taste ist eine spezielle Taste auf der Tastatur, die normalerweise mit der Taste "Print Screen" (PrtSc) geteilt wird und in der Regel mit "SysRq" beschriftet ist. Diese Taste kann verwendet werden, um auf niedriger Ebene mit dem Kernel zu interagieren und verschiedene Debugging- und Systemverwaltungsaufgaben auszuführen.</p><p>Wenn `kernel.sysrq` auf den Wert `0` gesetzt ist, ist die Verwendung der SysRq-Taste deaktiviert. Das bedeutet, dass das System keine SysRq-Befehle akzeptiert, wenn die SysRq-Taste gedrückt wird.</p><p>Die SysRq-Taste kann dazu verwendet werden, in Notfällen auf das System zuzugreifen, wenn es nicht mehr auf andere Weise reagiert. Einige der Funktionen, die über die SysRq-Taste verfügbar sind, umfassen das Auslösen eines Soft-Reboots, das Synchronisieren des Dateisystems, das Anhalten aller Prozesse und mehr. Die Verwendung der SysRq-Taste sollte jedoch mit Vorsicht erfolgen, da einige Befehle das System beeinträchtigen können.</p><p>In den meisten produktiven Systemen wird die Verwendung der SysRq-Taste deaktiviert (auf `0` gesetzt), um unbeabsichtigte oder missbräuchliche Verwendung zu verhindern und die Systemstabilität sicherzustellen. Wenn jedoch ein Systemadministrator oder Entwickler spezifische Debugging- oder Diagnoseaufgaben durchführen muss, kann die Aktivierung der SysRq-Funktion (durch Setzen von `kernel.sysrq` auf `1`) vorübergehend erfolgen, gefolgt von der Deaktivierung, wenn die Aufgaben abgeschlossen sind.</p> |

---

| #           | Beschreibung                 |
| ----------- | ---------------------------- |
| Einstellung | **kernel.core_uses_pid = 1** |
| Erklärung   | <p>Die Einstellung `kernel.core_uses_pid` ist eine Konfigurationsoption in Linux, die die Formatierung von Core-Dump-Dateien (auch bekannt als Kerneldump-Dateien) steuert. Core-Dump-Dateien enthalten Informationen über den Speicherzustand eines Prozesses im Falle eines Absturzes oder eines unerwarteten Beendens des Prozesses. Sie sind nützlich für das Debuggen von Anwendungen und die Ermittlung von Absturzursachen.</p><p>Wenn `kernel.core_uses_pid` auf den Wert `1` gesetzt ist, bedeutet dies, dass die Core-Dump-Dateien den Prozess-ID (PID) des abgestürzten Prozesses im Dateinamen enthalten. Mit anderen Worten, der Dateiname der Core-Dump-Datei wird den PID des abgestürzten Prozesses beinhalten, um die Zuordnung zwischen der Datei und dem Prozess zu erleichtern.</p><p>Die Verwendung der PID im Dateinamen kann hilfreich sein, um Core-Dump-Dateien besser zu organisieren und zu identifizieren, insbesondere in Umgebungen, in denen viele Prozesse gleichzeitig ausgeführt werden. Dies erleichtert die Zuordnung von Core-Dump-Dateien zu den jeweiligen Prozessen und deren Debugging.</p><p>Die Standardeinstellung für `kernel.core_uses_pid` variiert je nach Linux-Distribution und Version. In einigen Systemen kann die Verwendung von PIDs im Dateinamen aktiviert sein (auf `1` gesetzt), während in anderen dies standardmäßig deaktiviert ist (auf `0` gesetzt). Die Wahl, ob diese Einstellung aktiviert oder deaktiviert sein sollte, hängt von den spezifischen Anforderungen und Vorlieben des Systemadministrators und Entwicklers ab.</p> |

---

| #           | Beschreibung                                                             |
| ----------- | ------------------------------------------------------------------------ |
| Einstellung | **net.ipv4.tcp_syncookies = 1** <br> **net.ipv4.tcp_synack_retries = 5** |
| Erklärung   | <p>`net.ipv4.tcp_syncookies = 1`:</p><p>- Wenn `net.ipv4.tcp_syncookies` auf den Wert `1` gesetzt ist, bedeutet dies, dass die TCP-Syn-Cookies aktiviert sind. TCP-Syn-Cookies sind eine Sicherheitsmaßnahme gegen Synflooding-Angriffe. Ein Synflooding-Angriff tritt auf, wenn ein Angreifer eine große Anzahl von TCP-Verbindungsanfragen mit gefälschten IP-Adressen an ein Zielsystem sendet, um dieses zu überlasten oder zu beeinträchtigen.</p><p>- Mit aktivierten TCP-Syn-Cookies erkennt das System, wenn es eine ungewöhnlich hohe Anzahl von eingehenden TCP-Syn-Anfragen erhält. In diesem Fall wird das System den normalen Verbindungsaufbau abkürzen und spezielle "Syn-Cookies" verwenden, um die Verbindung herzustellen. Dies hilft dabei, das System vor Synflooding-Angriffen zu schützen, da die Ressourcen des Systems nicht übermäßig beansprucht werden.</p><p>- Die Aktivierung von TCP-Syn-Cookies ist eine gängige Sicherheitspraxis in Umgebungen mit öffentlich zugänglichen Servern, um sich vor DDoS-Angriffen (Distributed Denial of Service) zu schützen.</p><p>`net.ipv4.tcp_synack_retries = 5`:</p><p>- Diese Einstellung legt die Anzahl der Versuche fest, die ein System unternimmt, um auf eine TCP-SYN-ACK-Nachricht (Bestätigung einer eingehenden Verbindungsanforderung) zu antworten, bevor es aufgibt. In diesem Fall sind es 5 Versuche.</p><p>- Wenn ein System eine TCP-Verbindung aufbauen möchte und eine SYN-ACK-Nachricht als Antwort auf seine SYN-Anfrage empfängt, sendet es normalerweise eine ACK-Nachricht zurück. Dieser Prozess kann jedoch durch Netzwerkprobleme gestört werden, z. B. wenn die SYN-ACK-Nachricht verloren geht. `net.ipv4.tcp_synack_retries` legt fest, wie oft das System versucht, eine SYN-ACK-Nachricht zu bestätigen, bevor es aufgibt.</p><p>- Ein höherer Wert für `net.ipv4.tcp_synack_retries` kann dazu beitragen, Verbindungsprobleme in instabilen Netzwerken zu überwinden. Dies ist jedoch auch mit einer längeren Verzögerung bei der Fehlererkennung und -behandlung verbunden, da das System mehrere Versuche unternimmt, bevor es ein Problem als dauerhaft betrachtet.</p> |

---

| #           | Beschreibung                                                                               |
| ----------- | ------------------------------------------------------------------------------------------ |
| Einstellung | **net.ipv4.conf.all.send_redirects = 0** <br> **net.ipv4.conf.default.send_redirects = 0** |
| Erklärung   | <p>Die Einstellungen `net.ipv4.conf.all.send_redirects` und `net.ipv4.conf.default.send_redirects` in Linux steuern die Möglichkeit des Systems, sogenannte ICMP-Redirect-Nachrichten zu senden. ICMP-Redirect-Nachrichten werden normalerweise verwendet, um einem Host mitzuteilen, dass er seinen Routing-Pfad ändern sollte, um den Datenverkehr effizienter zu leiten.</p><p>Wenn `net.ipv4.conf.all.send_redirects` und `net.ipv4.conf.default.send_redirects` beide auf den Wert `0` gesetzt sind, bedeutet dies, dass das System keine ICMP-Redirect-Nachrichten senden kann. Das System wird also keine ICMP-Redirect-Nachrichten an andere Hosts senden, um Änderungen im Routing-Pfad vorzuschlagen.</p><p>Die Deaktivierung der Sendung von ICMP-Redirect-Nachrichten ist in Sicherheitskontexten oft ratsam, da das Senden solcher Nachrichten potenziell von Angreifern ausgenutzt werden kann, um den Datenverkehr umzuleiten oder Informationen über das Netzwerk offenzulegen. Wenn diese Einstellungen deaktiviert sind, wird das System weniger anfällig für solche potenziell bösartigen Aktivitäten.</p><p>Es ist jedoch wichtig zu beachten, dass das Deaktivieren von ICMP-Redirect-Nachrichten auch dazu führen kann, dass in einigen Netzwerksituationen weniger effizientes Routing erfolgt. ICMP-Redirects können dazu beitragen, den Datenverkehr effizienter zu leiten und Engpässe zu vermeiden. Daher sollte die Entscheidung zur Deaktivierung dieser Einstellungen sorgfältig getroffen werden, basierend auf den spezifischen Anforderungen und Sicherheitsrichtlinien des Netzwerks. In sicherheitskritischen Umgebungen oder auf Routern und Gateways, die dem Internet ausgesetzt sind, wird jedoch oft empfohlen, die Sendung von ICMP-Redirect-Nachrichten zu deaktivieren, um potenzielle Sicherheitsrisiken zu minimieren.</p> |

---

| #           | Beschreibung                                  |
| ----------- | --------------------------------------------- |
| Einstellung | **net.ipv4.conf.all.accept_source_route = 0** |
| Erklärung   | <p>Die Einstellung `net.ipv4.conf.all.accept_source_route` in Linux steuert, ob das System IP-Pakete akzeptiert, die die sogenannte "Source Routing" Option verwenden. Source Routing ist eine Technik, bei der der Absender eines IP-Pakets den Weg festlegt, den das Paket im Netzwerk nehmen soll, anstatt dies dem normalen Routing-Algorithmus des Netzwerks zu überlassen.</p><p>Wenn `net.ipv4.conf.all.accept_source_route` auf den Wert `0` gesetzt ist, bedeutet dies, dass das System keine IP-Pakete akzeptiert, die Source Routing verwenden. Mit anderen Worten, das System wird keine IP-Pakete akzeptieren, bei denen der Absender den Pfad, den das Paket durch das Netzwerk nimmt, festgelegt hat. Dies ist eine sicherheitsrelevante Maßnahme, die verhindert, dass potenziell bösartiger oder gefälschter Datenverkehr, der Source Routing verwendet, in das Netzwerk gelangt.</p><p>Die Standardeinstellung für `net.ipv4.conf.all.accept_source_route` ist normalerweise `0`, was darauf abzielt, die Sicherheit des Systems und des Netzwerks zu erhöhen. Das Aktivieren von Source Routing kann dazu verwendet werden, Angriffe zu maskieren oder Datenverkehr durch ungewöhnliche Pfade zu leiten, was potenziell gefährlich ist. Daher ist es ratsam, diese Einstellung normalerweise deaktiviert zu lassen, es sei denn, es gibt spezielle Anforderungen, bei denen Source Routing erforderlich ist. In den meisten Netzwerken ist es jedoch eine bewährte Praxis, Source Routing zu deaktivieren, um die Sicherheit zu gewährleisten.</p> |

---

| #           | Beschreibung                                                                               |
| ----------- | ------------------------------------------------------------------------------------------ |
| Einstellung | **net.ipv4.conf.all.accept_redirects = 0** <br> **net.ipv4.conf.all.secure_redirects = 0** |
| Erklärung   | <p>Die Einstellungen `net.ipv4.conf.all.accept_redirects` und `net.ipv4.conf.all.secure_redirects` in Linux steuern die Behandlung von ICMP-Redirect-Nachrichten durch das System. ICMP-Redirect-Nachrichten werden normalerweise verwendet, um einem Host mitzuteilen, dass er seinen Routing-Pfad ändern sollte, um den Datenverkehr effizienter zu leiten. Die genannten Einstellungen beeinflussen, ob das System diese Nachrichten akzeptiert und wie sicher sie behandelt werden.</p><p>1. `net.ipv4.conf.all.accept_redirects = 0`:</p><p>- Wenn `net.ipv4.conf.all.accept_redirects` auf den Wert `0` gesetzt ist, bedeutet dies, dass das System ICMP-Redirect-Nachrichten ablehnt. Das System wird keine ICMP-Redirect-Nachrichten akzeptieren, die Änderungen im Routing-Pfad vorschlagen.</p><p>- Diese Einstellung wird oft aus Sicherheitsgründen aktiviert, um sicherzustellen, dass das System keine unerwünschten Routing-Anweisungen von anderen Hosts akzeptiert, da ICMP-Redirect-Nachrichten potenziell von Angreifern ausgenutzt werden können, um den Datenverkehr umzuleiten oder Informationen über das Netzwerk offenzulegen.</p><p>2. `net.ipv4.conf.all.secure_redirects = 0`:</p><p>- Wenn `net.ipv4.conf.all.secure_redirects` auf den Wert `0` gesetzt ist, bedeutet dies, dass das System keine als "sicher" gekennzeichneten ICMP-Redirect-Nachrichten akzeptiert. Die als sicher gekennzeichneten Nachrichten sollen von Gateways (Routern) in vertrauenswürdigen Teilen des Netzwerks stammen.</p><p>- Diese Einstellung wird ebenfalls aus Sicherheitsgründen aktiviert, um sicherzustellen, dass selbst ICMP-Redirect-Nachrichten von vertrauenswürdigen Routern nicht akzeptiert werden. Die Annahme solcher Nachrichten könnte in einigen Szenarien als potenzielles Sicherheitsrisiko angesehen werden.</p> |

---

| #           | Beschreibung                                                                                                                                                                                                                                          |
| ----------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Einstellung | **net.ipv4.conf.all.log_martians = 1** <br> **net.ipv4.conf.default.log_martians = 1** <br> **net.ipv4.conf.default.accept_source_route = 0** <br> **net.ipv4.conf.default.accept_redirects = 0** <br> **net.ipv4.conf.default.secure_redirects = 0** |
| Erklärung   | <p></p> |

---

| #           | Beschreibung                                                                               |
| ----------- | ------------------------------------------------------------------------------------------ |
| Einstellung | **net.ipv4.tcp_rmem = 4096 87380 8388608** <br> **net.ipv4.tcp_wmem = 4096 87380 8388608** |
| Erklärung   | <p></p> |

---

| #           | Beschreibung                                 |
| ----------- | -------------------------------------------- |
| Einstellung | **net.ipv4.icmp_echo_ignore_broadcasts = 1** |
| Erklärung   | <p></p> |

---

| #           | Beschreibung                        |
| ----------- | ----------------------------------- |
| Einstellung | **net.ipv4.conf.all.rp_filter = 1** |
| Erklärung   | <p></p> |

---

| #           | Beschreibung                            |
| ----------- | --------------------------------------- |
| Einstellung | **net.ipv4.conf.default.rp_filter = 1** |
| Erklärung   | <p></p> |

---

| #           | Beschreibung            |
| ----------- | ----------------------- |
| Einstellung | **fs.file-max = 65535** |
| Erklärung   | <p></p> |

---

| #           | Beschreibung               |
| ----------- | -------------------------- |
| Einstellung | **kernel.pid_max = 65536** |
| Erklärung   | <p></p> |

---

| #           | Beschreibung                                  |
| ----------- | --------------------------------------------- |
| Einstellung | **net.ipv4.ip_local_port_range = 2000 65000** |
| Erklärung   | <p></p> |

---

| #           | Beschreibung                 |
| ----------- | ---------------------------- |
| Einstellung | **net.ipv4.tcp_rfc1337 = 1** |
| Erklärung   | <p></p> |

---

Reload, Befehl: ```sudo sysctl -p```

Reboot, Befehl: ```sudo reboot```

Anmerkung: sollte Kernel panic entstehen ```kernel.panic=10```

---

_Weiterführende Informationen:_
* [systemctl](https://wiki.ubuntuusers.de/systemd/systemctl/)
