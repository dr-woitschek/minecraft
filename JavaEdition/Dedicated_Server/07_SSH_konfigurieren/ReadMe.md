**ssh konfigurieren**

---

_SSH Schlüsselpaar mit PuTTYGen erstellen_

| Beschreibung          | Bild |
| --------------------- | ---- |
| starte ```puttygen.exe```                                                                                                                                                     | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/07_SSH_konfigurieren/Bilder/Schritt_01_PuTTYGen_01.jpg"> |
| setze ```Parameters``` <br/> ```Type of key generate:``` ```EdDSA``` <br/> ```Curve to use for generating this key:``` ```Ed25519 (255 bits)``` und klicke auf ```Generate``` | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/07_SSH_konfigurieren/Bilder/Schritt_01_PuTTYGen_02.jpg"> |
| ```Generate``` abgeschlossen                                                                                                                                                  | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/07_SSH_konfigurieren/Bilder/Schritt_01_PuTTYGen_03.jpg"> |
| speichern der ```Putty Key-Datei```                                                                                                                                           | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/07_SSH_konfigurieren/Bilder/Schritt_01_PuTTYGen_04.jpg"> |

---

_PuTTY starten_

| Beschreibung          | Bild |
| --------------------- | ---- |
| starte ```putty.exe```                                                                                      | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/07_SSH_konfigurieren/Bilder/Schritt_02_PuTTY_01.jpg"> |
| ```Host Name (or IP address)``` eingeben                                                                    | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/07_SSH_konfigurieren/Bilder/Schritt_02_PuTTY_02.jpg"> |
| In der ```Category``` ```Data``` die ```Login details``` ausfüllen <br/> dannach drücken wir auf ```Open``` | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/07_SSH_konfigurieren/Bilder/Schritt_02_PuTTY_03.jpg"> |
| Verbindung aufgebaut und angemeldet                                                                         | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/07_SSH_konfigurieren/Bilder/Schritt_02_PuTTY_04.jpg"> |

---

_SSH Key hinterlegen_

| Beschreibung          | Bild |
| --------------------- | ---- |
| prüfe ob der Ordner ```.ssh``` vorhanden ist, erstellen kannst du ihn mit dem Befehl ```mkdir .ssh```                               | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/07_SSH_konfigurieren/Bilder/Schritt_03_authorized_keys_01.jpg"> |
| öffne die Datei mit einem beliebigen Editor ```nano .ssh/authorized_keys```                                                         | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/07_SSH_konfigurieren/Bilder/Schritt_03_authorized_keys_02.jpg"> |
| kopiere aus ```PuTTYGEN``` den Inhalt ```Public key for pasting into OpenSSH authorized_keys file``` (STRG+C) in die Zwischenablage | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/07_SSH_konfigurieren/Bilder/Schritt_03_authorized_keys_03.jpg"> |
| füge den Inhalt in die Datei ```.ssh/authorized_keys file``` ein (STRG+V) und speichere diese ab                                    | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/07_SSH_konfigurieren/Bilder/Schritt_03_authorized_keys_04.jpg"> |
| überprüfe die Berechtigung der Datei ```.ssh/authorized_keys file``` mit dem Befehl ```ls -aFlh .ssh/authorized_keys```             | Ausgabe: <br/> ```-rw------- 1 minecraft minecraft 121 Okt 15 12:31 .ssh/authorized_keys```                                                                            |

---

_Anpassen der PuTTY Session_

| Beschreibung          | Bild |
| --------------------- | ---- |
| starte ```putty.exe``` und erstelle die eine ```Session```                                                                                           | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/07_SSH_konfigurieren/Bilder/Schritt_04_PuTTY_01.jpg"> |
| in der ```Category``` ```SSH``` ```Auth``` muss die gespeicherte _Private key_-Datei angegeben werden                                                | <img width="50%" src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/07_SSH_konfigurieren/Bilder/Schritt_04_PuTTY_02.jpg"> |

---

_Weiterführende Informationen:_
* [ssh](https://wiki.ubuntuusers.de/SSH/)
* [PuTTY-Tools](https://www.chiark.greenend.org.uk/~sgtatham/putty/latest.html/)
