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

/opt/mcpaper/paper-1.20.1-196.jar     100%[=======================================================================>]  41,23M  12,0MB/s in 3,5s

2023-10-23 17:42:04 (11,8 MB/s) - ‘/opt/mcpaper/paper-1.20.1-196.jar’ saved [43230582/43230582]

```

---
