**IPv6 deaktivieren**

---

1. Editiere die Datei _/etc/default/grub_ mit dem Befehl ```sudo nano /etc/default/grub```
2. suche die Zeile ```GRUB_CMDLINE_LINUX_DEFAULT=""``` und erweitere diese um die  Option ```ipv6.disable=1```
   * von ```GRUB_CMDLINE_LINUX_DEFAULT=""```
   * nach ```GRUB_CMDLINE_LINUX_DEFAULT="ipv6.disable=1"```
3. beende den Editor und speichere die Datei
4. führe den Befehl ```sudo update-grub``` aus

mit dem Befehl ```ip a``` oder ```ifconfig``` kannst du deine IP-Konfiguration ausgeben:

```

ens33: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500
        inet 192.168.0.109  netmask 255.255.255.0  broadcast 192.168.0.255
        inet6 fe00::00a:00ff:abcd:1a2b  prefixlen 64  scopeid 0x20<link>
        ether 00:00:00:ab:ab:ab  txqueuelen 1000  (Ethernet)
        RX packets 23705  bytes 21911488 (21.9 MB)
        RX errors 0  dropped 8002  overruns 0  frame 0
        TX packets 2392  bytes 189760 (189.7 KB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0

lo: flags=73<UP,LOOPBACK,RUNNING>  mtu 65536
        inet 127.0.0.1  netmask 255.0.0.0
        inet6 ::1  prefixlen 128  scopeid 0x10<host>
        loop  txqueuelen 1000  (Local Loopback)
        RX packets 182  bytes 16002 (16.0 KB)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 182  bytes 16002 (16.0 KB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0

```

Reboot mit dem Befehlt ```sudo reboot``` wird ein neustart ausgeführt

```

ens33: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500
        inet 192.168.0.109  netmask 255.255.255.0  broadcast 192.168.0.255
        ether 00:00:00:ab:ab:ab  txqueuelen 1000  (Ethernet)
        RX packets 39  bytes 5684 (5.6 KB)
        RX errors 0  dropped 12  overruns 0  frame 0
        TX packets 23  bytes 5897 (5.8 KB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0

lo: flags=73<UP,LOOPBACK,RUNNING>  mtu 65536
        inet 127.0.0.1  netmask 255.0.0.0
        loop  txqueuelen 1000  (Local Loopback)
        RX packets 80  bytes 5920 (5.9 KB)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 80  bytes 5920 (5.9 KB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0

```

---

_Weiterführende Informationen:_
* [ip](https://wiki.ubuntuusers.de/ip/)
