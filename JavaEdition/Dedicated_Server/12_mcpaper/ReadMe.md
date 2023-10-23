**Minecraft Paper Server**

---

Installation von _openjdk_ und _screen_ über den Befehl:
* ```sudo apt install openjdk-17-jre-headless```
* ```sudo apt install screen```

---

Minecraft Standard-Port in der Firewall erlauben:
* ```sudo ufw allow 25565/tcp```

---

Minecraft Server Benutzer mit seperatem Home-Verzeichnis erstellen:
* ```sudo adduser --gecos "" --home /opt/mcpaper mcpaper```

| adduser-Parameter             | Erklärung                                                              |
| ----------------------------- | ---------------------------------------------------------------------- |
| ```--gecos ""```              | überspringt die Abfragen für optional vollen Namen, Telefonnummer usw. |
| ```--home /opt/mcpaper```     | erstellt ein Home-Verzeichnis                                          |

Ausgabe:

```

Adding user `mcpaper' ...
Adding new group `mcpaper' (1001) ...
Adding new user `mcpaper' (1001) with group `mcpaper' ...
Creating home directory `/opt/mcpaper' ...
Copying files from `/etc/skel' ...
New password:
Retype new password:
passwd: password updated successfully

```

---

Download Paper Server:
* Alle Paper-Informationen: [https://papermc.io/](https://papermc.io/)
* ```sudo wget --continue https://api.papermc.io/v2/projects/paper/versions/1.20.1/builds/196/downloads/paper-1.20.1-196.jar --output-document=/opt/mcpaper/paper-1.20.1-196.jar```

| wget-Parameter                                            | Erklärung                                                     |
| --------------------------------------------------------- | ------------------------------------------------------------- |
| ```--continue```                                          | Versucht einen teilweise durchgeführten Download fortzusetzen |
| ```--output-document=/opt/mcpaper/paper-1.20.1-196.jar``` | schreibe in die Ordner/Datei                                  |

Ausgabe:

```

--2023-10-23 17:42:00--  https://api.papermc.io/v2/projects/paper/versions/1.20.1/builds/196/downloads/paper-1.20.1-196.jar
Resolving api.papermc.io (api.papermc.io)... 172.67.72.198, 104.26.13.138, 104.26.12.138, ...
Connecting to api.papermc.io (api.papermc.io)|172.67.72.198|:443... connected.
HTTP request sent, awaiting response... 200 OK
Length: 43230582 (41M) [application/java-archive]
Saving to: ‘/opt/mcpaper/paper-1.20.1-196.jar’

/opt/mcpaper/paper-1.20.1-196.jar     100%[====================================================>]  41,23M  12,0MB/s in 3,5s

2023-10-23 17:42:04 (11,8 MB/s) - ‘/opt/mcpaper/paper-1.20.1-196.jar’ saved [43230582/43230582]

```

---

Datei-Berechtigung:
* ```sudo chown mcpaper:mcpaper /opt/mcpaper/paper-1.20.1-196.jar```
* ```sudo ls -aFlh /opt/mcpaper/```

Ausgabe:

```

drwxr-x--- 2 mcpaper mcpaper 4,0K Okt 23 17:50 ./
drwxr-xr-x 3 root    root    4,0K Okt 23 17:40 ../
-rw------- 1 mcpaper mcpaper   16 Okt 23 17:51 .bash_history
-rw-r--r-- 1 mcpaper mcpaper  220 Okt 23 17:27 .bash_logout
-rw-r--r-- 1 mcpaper mcpaper 3,7K Okt 23 17:27 .bashrc
-rw-r--r-- 1 mcpaper mcpaper  42M Sep 21 16:59 paper-1.20.1-196.jar
-rw-r--r-- 1 mcpaper mcpaper  807 Okt 23 17:27 .profile

```

---

Switch User und auf gehts:

|   #   | Befehl                                     | Erklärung                                                                                                                  |
| :---: | ------------------------------------------ | -------------------------------------------------------------------------------------------------------------------------- |
|   1   | ```sudo su - mcpaper```                    | Benutzerwechsel                                                                                                            |
|   2   | ```cd ~```                                 | wechle ins Home-Verzeichnis                                                                                                |
|   3   | ```mkdir Server```                         | erstelle einen Ordner                                                                                                      |
|   4   | ```mv paper-1.20.1-196.jar Server/```      | verschiebe die Datei in den neu erstellten Ordner                                                                          |
|   5   | ```cd ~/Server/```                         | wechle ins Verzeichnis                                                                                                     |
|   6   | ```screen```                               | starte Screen                                                                                                              |
|   7   | ```java -jar paper-1.20.1-196.jar nogui``` | 1. Server start                                                                                                            |
|       | **Konsolenausgabe**                        | <img src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/12_mcpaper/1_Server_start.jpg"> |
|   8   | ```echo eula=true >> eula.txt```           | Eula.txt erstellen                                                                                                         |
|   9   | ```java -jar paper-1.20.1-196.jar nogui``` | 2. Server start                                                                                                            |
|       | **Konsolenausgabe**                        | <img src="https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Dedicated_Server/12_mcpaper/2_Server_start.jpg"> |
|       |                                            | Der Server ist jetzt unter ip:port erreichbar                                                                              |

---

Weitere Informationen:
* Server Konfigurationsdatei _server.properties_ [https://minecraft.wiki/w/Server.properties](https://minecraft.wiki/w/Server.properties)
* Server Start Parameter [https://docs.papermc.io/paper/aikars-flags](https://docs.papermc.io/paper/aikars-flags)
* der _screen_-Befehl [https://wiki.ubuntuusers.de/Screen/](https://wiki.ubuntuusers.de/Screen/)
  - Liste aller screens Ausgeben: ```screen -list```
  - screen holen: ```screen -x```
  - screen verlassen: ```screen A + D``` (A + D als Tastenkombination, wie Alt + F4)

---
