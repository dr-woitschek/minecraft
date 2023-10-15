**/etc/sysctl.conf abhärten**

---

**Google war mein Freund um alles zusammenzufassen xD**

Edit mit Befehl: ```sudo nano /etc/sysctl.conf```

Edit:

```

# Controls IP packet forwarding
net.ipv4.ip_forward = 0

# Turn on protection for bad icmp error messages
net.ipv4.icmp_ignore_bogus_error_responses = 1

# Do not accept source routing
net.ipv4.conf.default.accept_source_route = 0

# Controls the System Request debugging functionality of the kernel
kernel.sysrq = 0

# Controls whether core dumps will append the PID to the core filename
# Useful for debugging multi-threaded applications
kernel.core_uses_pid = 1

# Controls the use of TCP syncookies
# Turn on SYN-flood protections
net.ipv4.tcp_syncookies = 1
net.ipv4.tcp_synack_retries = 5

# Send redirects, if router, but this is just server
# So no routing allowed
net.ipv4.conf.all.send_redirects = 0
net.ipv4.conf.default.send_redirects = 0

# Accept packets with SRR option? No
net.ipv4.conf.all.accept_source_route = 0

# Accept Redirects? No, this is not router
net.ipv4.conf.all.accept_redirects = 0
net.ipv4.conf.all.secure_redirects = 0

# Log packets with impossible addresses to kernel log? yes
net.ipv4.conf.all.log_martians = 1
net.ipv4.conf.default.log_martians = 1
net.ipv4.conf.default.accept_source_route = 0
net.ipv4.conf.default.accept_redirects = 0
net.ipv4.conf.default.secure_redirects = 0

# Increase TCP max buffer size setable using setsockopt()
net.ipv4.tcp_rmem = 4096 87380 8388608
net.ipv4.tcp_wmem = 4096 87380 8388608

# Ignore all ICMP ECHO and TIMESTAMP requests sent to it via broadcast/multicast
net.ipv4.icmp_echo_ignore_broadcasts = 1

# Prevent against the common 'syn flood attack'
net.ipv4.tcp_syncookies = 1

# Enable source validation by reversed path, as specified in RFC1812
net.ipv4.conf.all.rp_filter = 1

# Controls source route verification
net.ipv4.conf.default.rp_filter = 1

# increase system file descriptor limit
fs.file-max = 65535

# Allow for more PIDs
kernel.pid_max = 65536

# Increase system IP port limits
net.ipv4.ip_local_port_range = 2000 65000

# RFC 1337 fix
net.ipv4.tcp_rfc1337 = 1

```

Reload, Befehl: ```sudo sysctl -p```

Reboot, Befehl: ```sudo reboot```

Anmerkung: sollte Kernel panic entstehen ```kernel.panic=10```

---

_Weiterführende Informationen:_
* [systemctl](https://wiki.ubuntuusers.de/systemd/systemctl/)
