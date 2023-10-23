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

Switch User und erster start:

| Befehl                                | Erklärung                                         |
| ------------------------------------- | ------------------------------------------------- |
| ```sudo su - mcpaper```               | Benutzerwechsel                                   |
| ```cd ~```                            | wechle ins Home-Verzeichnis                       |
| ```mkdir Server```                    | erstelle einen Ordner                             |
| ```mv paper-1.20.1-196.jar Server/``` | verschiebe die Datei in den neu erstellten Ordner |
| ```cd ~/Server/```                    | wechle ins Verzeichnis                            |
| ```screen```                          | starte Screen                                     |

Erster Server start: ```java -jar paper-1.20.1-196.jar nogui```

Ausgabe:

```

Downloading mojang_1.20.1.jar
Applying patches
Starting org.bukkit.craftbukkit.Main
*** Warning, you've not updated in a while! ***
*** Please download a new build as per instructions from https://papermc.io/downloads/paper ***
System Info: Java 17 (OpenJDK 64-Bit Server VM 17.0.8.1+1-Ubuntu-0ubuntu122.04) Host: Linux 5.15.0-87-generic (amd64)
Loading libraries, please wait...
[17:56:47 WARN]: Failed to load eula.txt
[17:56:47 INFO]: You need to agree to the EULA in order to run the server. Go to eula.txt for more info.

```

* Eula.txt erstellen: ```echo eula=true >> eula.txt```
* Zweiter Server start: ```java -jar paper-1.20.1-196.jar nogui```

Ausgabe:

```

Starting org.bukkit.craftbukkit.Main
*** Warning, you've not updated in a while! ***
*** Please download a new build as per instructions from https://papermc.io/downloads/paper ***
System Info: Java 17 (OpenJDK 64-Bit Server VM 17.0.8.1+1-Ubuntu-0ubuntu122.04) Host: Linux 5.15.0-87-generic (amd64)
Loading libraries, please wait...
[18:16:05 INFO]: Environment: authHost='https://authserver.mojang.com', accountsHost='https://api.mojang.com', sessionHost='https://sessionserver.mojang.com', servicesHost='https://api.minecraftservices.com', name='PROD'
[18:16:05 INFO]: Found new data pack file/bukkit, loading it automatically
[18:16:07 INFO]: Loaded 7 recipes
[18:16:08 INFO]: Starting minecraft server version 1.20.1
[18:16:08 INFO]: Loading properties
[18:16:08 INFO]: This server is running Paper version git-Paper-196 (MC: 1.20.1) (Implementing API version 1.20.1-R0.1-SNAPSHOT) (Git: 773dd72)
[18:16:08 INFO]: Server Ping Player Sample Count: 12
[18:16:08 INFO]: Using 4 threads for Netty based IO
[18:16:09 INFO]: [ChunkTaskScheduler] Chunk system is using 1 I/O threads, 1 worker threads, and gen parallelism of 1 threads
[18:16:09 WARN]: [!] The timings profiler has been enabled but has been scheduled for removal from Paper in the future.
    We recommend installing the spark profiler as a replacement: https://spark.lucko.me/
    For more information please visit: https://github.com/PaperMC/Paper/issues/8948
[18:16:09 INFO]: Default game type: SURVIVAL
[18:16:09 INFO]: Generating keypair
[18:16:09 INFO]: Starting Minecraft server on *:25565
[18:16:09 INFO]: Using epoll channel type
[18:16:09 INFO]: Paper: Using libdeflate (Linux x86_64) compression from Velocity.
[18:16:09 INFO]: Paper: Using OpenSSL 3.0.x (Linux x86_64) cipher from Velocity.
[18:16:09 INFO]: Preparing level "world"
[18:16:27 INFO]: Preparing start region for dimension minecraft:overworld
[18:16:27 INFO]: Time elapsed: 123 ms
[18:16:27 INFO]: Preparing start region for dimension minecraft:the_nether
[18:16:27 INFO]: Time elapsed: 60 ms
[18:16:27 INFO]: Preparing start region for dimension minecraft:the_end
[18:16:27 INFO]: Time elapsed: 64 ms
[18:16:27 INFO]: Running delayed init tasks
[18:16:27 INFO]: Done (19.231s)! For help, type "help"
[18:16:27 INFO]: Timings Reset

```
