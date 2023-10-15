**IPv6 deaktivieren**

---

1. Editiere die Datei _/etc/default/grub_ mit dem Befehl ```sudo nano /etc/default/grub```
2. suche die Zeile ```GRUB_CMDLINE_LINUX_DEFAULT=""``` und erweitere diese um die  Option ```ipv6.disable=1```
   * von ```GRUB_CMDLINE_LINUX_DEFAULT=""```
   * nach ```GRUB_CMDLINE_LINUX_DEFAULT="ipv6.disable=1"```
3. beende den Editor und speichere die Datei
4. führe den Befehl ```sudo update-grub``` aus

---

_Weiterführende Informationen:_
* [nano](https://wiki.ubuntuusers.de/Nano/)
* [GRUB](https://wiki.ubuntuusers.de/GRUB_2/)
