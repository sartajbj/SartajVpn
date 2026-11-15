# Sartaj VPN

Android preview app created by Sartaj Bajauri.

This build provides a polished lightweight UI and country selector. It is **not a functioning VPN tunnel yet**. The Connect button deliberately explains this rather than pretending traffic is protected.

## Build APK
GitHub Actions automatically builds a debug APK on pushes to `main`. You can also run the workflow manually from the Actions tab. Download the `SartajVPN-debug-apk` artifact from a successful run.

## Before calling it a real VPN
Deploy WireGuard servers in each advertised country, integrate the official WireGuard Android tunnel library and Android VPN permission flow, then add secure per-user key provisioning, DNS handling, IPv4/IPv6 routing, kill-switch testing, reconnect/failover, and subscription handling. No server is bundled in this APK.
