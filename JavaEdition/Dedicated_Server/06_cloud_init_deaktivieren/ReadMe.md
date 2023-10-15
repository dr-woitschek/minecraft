**cloud-init deaktivieren**

---

Führe folgende Befehl aus:
1. ```sudo touch /etc/cloud/cloud-init.disabled```
2. ```sudo reboot```

Nacharbeiten/Aufräumen:
1. ```sudo apt purge cloud-init -y```
2. ```sudo rm -rf /etc/cloud```
3. ```sudo rm -rf /var/lib/cloud```
4. ```sudo reboot```

---

_Weiterführende Informationen:_
* [cloud-init](https://help.ubuntu.com/community/CloudInit/)
* [rm](https://wiki.ubuntuusers.de/rm/)
