**Erstanmeldung**

---

| Beschreibung          | Bild |
| --------------------- | ---- |
| Erstanmeldung mit dem erstellen Benutzer | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/02_Erstanmeldung/Bilder/Grundkonfiguration_01.jpeg"> |
| Befehl ausführen: <br/> ```sudo apt update```  | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/02_Erstanmeldung/Bilder/Grundkonfiguration_02.jpeg"> |
| Befehl ausführen: <br/> ```sudo apt upgrade``` | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/02_Erstanmeldung/Bilder/Grundkonfiguration_03.jpeg"><img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/02_Erstanmeldung/Bilder/Grundkonfiguration_04.jpeg"> |
| Befehl ausführen: <br/> ```sudo apt install mc net-tools``` | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/02_Erstanmeldung/Bilder/Grundkonfiguration_05.jpeg"><img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/02_Erstanmeldung/Bilder/Grundkonfiguration_06.jpeg"> |

---

**Woitschek's Anpassungen - _Midnight Commander_**

| Beschreibung          | Bild |
| --------------------- | ---- |
| starte den _Midnight Commander_ mit dem Befehl ```mc```                                                                                                                                                          | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/02_Erstanmeldung/Bilder/WoitschekAnpassung_01.jpeg"><img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/02_Erstanmeldung/Bilder/WoitschekAnpassung_02.jpeg"> |
| mit ```F9``` in die Menüleiste wechseln in <br/> ```Optionen``` <br/> ```Configuration...```                                                                                                                     | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/02_Erstanmeldung/Bilder/WoitschekAnpassung_03.jpeg"> |
| setze die Option <br/> ```[x] Use internal editor``` <br/> und beende den Dialog mit ```OK``` <br/><br/> Jetzt kann mit ```F4``` wird der interne Editor ```mcedit``` zum bearbeiten von Dateien benutzt werden. | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/02_Erstanmeldung/Bilder/WoitschekAnpassung_04.jpeg"> |
| mit ```F9``` in die Menüleiste wechseln in <br/> ```Optionen``` <br/> ```Paneloptions...```                                                                                                                      | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/02_Erstanmeldung/Bilder/WoitschekAnpassung_05.jpeg"> |
| setze die Option <br/> ```[x] Lynx-like motion``` <br/> und beende den Dialog mit ```OK``` <br/><br/> Mit den Pfeiltasten kann man jetzt durch die Ordnerstrukturen navigieren.                                  | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/02_Erstanmeldung/Bilder/WoitschekAnpassung_06.jpeg"> |

**Woitschek's Anpassungen - _.bashrc_**

| Beschreibung          | Bild |
| --------------------- | ---- |
| wähle mit den Pfeiltasten die Datei _.bashrc_ aus                                                                                                                                                        | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/02_Erstanmeldung/Bilder/WoitschekAnpassung_07.jpeg"> |
| mit ```F4``` wechselst du jetzt in den Editor ```mcedit```                                                                                                                                               | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/02_Erstanmeldung/Bilder/WoitschekAnpassung_08.jpeg"> |
| suche die Zeile ```#force_color_prompts=yes``` und entferne ```#```                                                                                                                                      | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/02_Erstanmeldung/Bilder/WoitschekAnpassung_09.jpeg"> |
| suche die Zeilen ```#alias dir='dir --color=auto'``` bzw. ```#alias vdir='vdir --color=auto'``` und entferne ```#```                                                                                     | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/02_Erstanmeldung/Bilder/WoitschekAnpassung_10.jpeg"> |
| suche die Zeilen ```#alias ll= ...``` und folgende und erweitere/passe diese an:<br/>```alias ll='ls -aFlh'```<br/>```alias l='ls -aFlh'```<br/>```alias ..='cd ..'```<br/>```alias cd..='cd ..'```<br/> | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/02_Erstanmeldung/Bilder/WoitschekAnpassung_11.jpeg"> |
| mit ```F10``` wird der Editor beendet und man wird zum speichern der Datei aufgefordert                                                                                                                  | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/02_Erstanmeldung/Bilder/WoitschekAnpassung_12.jpeg"> |
| Prompt vorher                                                                                                                                                                                            | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/02_Erstanmeldung/Bilder/WoitschekAnpassung_13.jpeg"> |
| Prompt jetzt                                                                                                                                                                                             | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/02_Erstanmeldung/Bilder/WoitschekAnpassung_14.jpeg"> |

---

_Weiterführende Informationen:_
* [apt](https://wiki.ubuntuusers.de/apt/apt/)
* [mc](https://wiki.ubuntuusers.de/Midnight_Commander/)
* [net-tools\netstat](https://wiki.ubuntuusers.de/netstat/)
* [net-tools](https://net-tools.sourceforge.io/)
* [Lynx](https://wiki.ubuntuusers.de/Lynx/)
* [ls](https://wiki.ubuntuusers.de/ls/)
* [alias](https://wiki.ubuntuusers.de/alias/)
* [bashrc](https://wiki.ubuntuusers.de/Bash/bashrc/)
