Network theory
==

# A. Given a /8 base network(e.g. 10.0.0.0), show how to subnet it so there are at least 64 networks available.

Suppose the we the network needs to at least to have 256 ip addresses (254 usable ones), then we can use CIDR prefix from /15 to /30. For example using /15, the subnet mask is `255.254.0.0`. This will yield 125(all one and all zero subnet not included) subnets, each having 131,070 available hosts.

# B. Explain what NAT/PAT are.

NAT stands for Network Address Translation, in which the private IP address or local address are translated into the public IP address.

PAT stands for Port Address Translation, in which private IP addresses are translated into the public IP address via Port numbers. PAT can be considered a type of NAT where the multiple private IP addresses are mapped into a single public IP (many-to-one) by using ports.

Which method of address translation you use depends on the types of networks that you are translating and the number of available IP addresses that you have. NAT requires one-to-one mapping while PAT allows many-to-one.

The reason we need NAT/PAT is because an internal network user having a private IP (unregistered) could not connect to the internet or external network because each device in a network must have a unique IP address. NAT works on a router connecting two networks together, and it translates the internal network private address (i.e. not globally unique) into the legal public address.

Additionally, it was devised to conserve the IP addresses. As the internet users were facing a problem of IP address scarcity, where the number of users was increased more than the limited range of IP addresses. For this reason, NAT and PAT protocols are used.

# C. Explain what a VPN is.

VPN stands for virtual private network. A virtual private network (VPN) is a technology that creates a safe and encrypted connection over a less secure network, such as the internet. A VPN creates a private “tunnel” from your device to the VPN server and hides your vital data through encryption. After a VPN connection is established, when you browse a website, the traffic comes from the VPN server rather than your computer. The VPN acts as an intermediary of sorts thereby hiding your IP address – and protecting your identity.

VPN can be classified into

### 1. Remote access
A host-to-network configuration is analogous to connecting a computer to a local area network. This type provides access to an enterprise network,

### 2. Site-to-site
A site-to-site configuration connects two networks. This configuration expands a network across geographically disparate offices, or a group of offices to a data center installation.

### 3. Extranet-based site-to-site
In the context of site-to-site configurations, the terms intranet and extranet are used to describe two different use cases.An intranet site-to-site VPN describes a configuration where the sites connected by the VPN belong to the same organization, whereas an extranet site-to-site VPN joins sites belonging to multiple organizations.
