**statische IPv4 einstellen**

---

_derzeitige IP-Informationen auslesen:_

1. Ausgabe der IP-Konfiguration mit dem Befehl ```ifconfig```:

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
> Wir merken uns: Netzwerkkarten-Bezeichner ```ens33``` und _inet_ ```192.168.0.109```

---

2. Ausgabe der Routing-Konfiguration mit dem Befehl ```route -n```:

```

Kernel IP routing table
Destination     Gateway         Genmask         Flags Metric Ref    Use Iface
0.0.0.0         192.168.0.254   0.0.0.0         UG    100    0        0 ens33
192.168.0.0     0.0.0.0         255.255.255.0   U     100    0        0 ens33
192.168.0.254   0.0.0.0         255.255.255.255 UH    100    0        0 ens33

```
> Wir merken uns: _Gateway_ ```192.168.0.254```

---

3. Ausgabe der DNS-Konfiguration mit dem Befehl ```resolvectl status```:

```

Global
       Protocols: -LLMNR -mDNS -DNSOverTLS DNSSEC=no/unsupported
resolv.conf mode: stub

Link 2 (ens33)
    Current Scopes: DNS
         Protocols: +DefaultRoute +LLMNR -mDNS -DNSOverTLS DNSSEC=no/unsupported
Current DNS Server: 192.168.0.1
       DNS Servers: 192.168.0.1
        DNS Domain: workgroup

```
> Wir merken uns: _DNS Servers_ ```192.168.0.1``` und _DNS Domain_ ```workgroup```

---

4. Anpassung von _netplan_
Befehl: ```sudo netplan generate```

Die YAML-Datei ```/etc/netplan/00-installer-config.yaml``` sollte so aussehen:

```

network:
  ethernets: 2
    ens33:
      dhcp4: true
  version: 2

```

Befehl: ```sudo touch /etc/netplan/01-netcfg.yaml``` erstellt die Datei

Befehl: ```sudo chmod 600 /etc/netplan/01-netcfg.yaml``` verändert die Datei-Berechtigung

Befehl: ```sudo nano /etc/netplan/01-netcfg.yaml``` editiert die Datei

Die YAML-Datei ```/etc/netplan/01-netcfg.yaml``` füllen:
> Beachte: benutze vorher ausgelesenen Informationen!
> Beachte: beachte das Format YAML!

```

network:
  version: 2
  renderer: networkd
  ethernets:
    ens33:
      addresses:
        - 192.168.0.88/24
      nameservers:
        search: [workgroup]
        addresses: [192.168.0.1]
      routes:
        - to: default
          via: 192.168.0.254

```

---

5. Check der Konfiguration
Befehl: ```sudo netplan try -timeout 180```

> Veranlasst ebenso wie netplan apply die unmittelbare Anwendung der Konfiguration, setzt sie aber nach Ablauf der hinter -timeout angegebenen Sekunden wieder automatisch auf die vorherige Konfiguration zurück. Der Nutzer kann die Konfiguration innerhalb dieser Zeitspanne interaktiv annehmen oder ablehnen. Wird -timeout nicht angegeben so beträgt das Zeitintervall standardmäßig 120 Sekunden.

> Die Nutzung von netplan try ist damit insbesondere sinnvoll, wenn man neue Netzwerkkonfigurationen auf einem System per Fernwartung einrichten will.

---

6. Abschluss und Reboot

Befehl: ```sudo netplan apply```

Befehl: ```sudo reboot```

---

_Weiterführende Informationen:_
* [ip](https://wiki.ubuntuusers.de/ip/)
* [route](https://wiki.ubuntuusers.de/Router/Routing-Funktion/)
* [resolvectl](https://wiki.ubuntuusers.de/systemd/systemd-resolved/)
* [Systeminformationen ermitteln](https://wiki.ubuntuusers.de/Systeminformationen_ermitteln/)
* [netplan](https://wiki.ubuntuusers.de/Netplan/)
* [yaml](https://de.wikipedia.org/wiki/YAML)
