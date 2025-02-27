**Minecraft Java Plugin**

---

**Vorbereitungen**

1. [IntelliJ IDEA Community Edition](https://www.jetbrains.com/de-de/idea/download/)
   - Standard-Installation
2. [Minecraft paperMC Server](https://papermc.io/downloads/all)
   - öffne `cmd.exe`
   - erstelle einen Server-Ordner `mkdir C:\Users\%username%\work\mc-server`
   - kopiere die Datei `paper-<versionsnummer>.jar` nach `C:\Users\%username%\work\mc-server`
   - erstelle im Ordner `C:\Users\%username%\work\mc-server` die Datei `start.cmd`
   - Inhalt der Datei `start.cmd`:
```

@echo off
set paper=paper-1.21.1-132.jar
set folder=C:\Users\%username%\work\mc-server
title Minecraft Server %paper%
cd \
cd "%folder%"
cls
java -Xms12G -Xmx12G -XX:+UseG1GC -XX:+ParallelRefProcEnabled -XX:MaxGCPauseMillis=200 -XX:+UnlockExperimentalVMOptions -XX:+DisableExplicitGC -XX:+AlwaysPreTouch -XX:G1NewSizePercent=40 -XX:G1MaxNewSizePercent=50 -XX:G1HeapRegionSize=16M -XX:G1ReservePercent=15 -XX:G1HeapWastePercent=5 -XX:G1MixedGCCountTarget=4 -XX:InitiatingHeapOccupancyPercent=20 -XX:G1MixedGCLiveThresholdPercent=90 -XX:G1RSetUpdatingPauseTimePercent=5 -XX:SurvivorRatio=32 -XX:+PerfDisableSharedMem -XX:MaxTenuringThreshold=1 -Dusing.aikars.flags=https://mcflags.emc.gs -Daikars.new.flags=true -jar %paper% --nogui
pause

```

---


---

_Weitere Informationen_
- [https://www.jetbrains.com/de-de/](https://www.jetbrains.com/de-de/)
- [https://papermc.io/](https://papermc.io/)
