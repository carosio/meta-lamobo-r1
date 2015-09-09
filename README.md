###meta-lamobo-r1

Un-Official OpenEmbedded layer for the lamobo-r1 aka. bananapi router board (BPi-R1).



The following steps has just been tested under ubuntu 12.04 and it may also works on others *nix like OS.


####Install the essential packages

```shell
$ sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib \
     build-essential chrpath libsdl1.2-dev xterm
```

####Get poky-fido-13.0.0

```shell
$ wget http://downloads.yoctoproject.org/releases/yocto/yocto-1.8/poky-fido-13.0.0.tar.bz2

$ tar xvjf poky-fido-13.0.0.tar.bz2

$ cd poky-fido-13.0.0
```

####Get meta-lamobo-r1

```shell
$ git clone https://github.com/pokymobo/meta-lamobo-r1.git
```

####Get meta-openembedded

```shell
$ git clone -b fido https://github.com/openembedded/meta-openembedded.git
```

####Set compile config

```shell
$ source ./oe-init-build-env
```

Add meta-lamobo-r1, meta-networking, meta-oe and meta-python layers to ./conf/bblayer.conf, and it will be something like this:

```shell
$ cat ./conf/bblayers.conf
\# LAYER_CONF_VERSION is increased each time build/conf/bblayers.conf

\# changes incompatibly
LCONF_VERSION = "6"

BBPATH = "${TOPDIR}"
BBFILES ?= ""

BBLAYERS ?= " \
/home/john/opensource/yocto/poky-fido-13.0.0/meta \
/home/john/opensource/yocto/poky-fido-13.0.0/meta-yocto \
/home/john/opensource/yocto/poky-fido-13.0.0/meta-yocto-bsp \
/home/john/opensource/yocto/poky-fido-13.0.0/meta-lamobo-r1 \
/home/john/opensource/yocto/poky-fido-13.0.0/meta-openembedded/meta-networking \
/home/john/opensource/yocto/poky-fido-13.0.0/meta-openembedded/meta-oe \
/home/john/opensource/yocto/poky-fido-13.0.0/meta-openembedded/meta-python \
"
BBLAYERS_NON_REMOVABLE ?= " \
/home/john/opensource/yocto/poky-fido-13.0.0/meta \
/home/john/opensource/yocto/poky-fido-13.0.0/meta-yocto \
"
```

the parent path of poky maybe different in your pc.


And change the machine type to sun7i-a20-lamobo-r1 in `./conf/local.conf`

```shell
MACHINE ??= "sun7i-a20-lamobo-r1"
```

####Run compile command
```shell
$ bitbake core-image-minimal
```

This will cost a lot of time in your first compile, it will donwload the sources form internet and then compile the sources, so be patient with it.

You will get a image file under `./tmp/deploy/images/sun7i-a20-lamobo-r1/core-image-minimal-sun7i-a20-lamobo-r1.sunxi-sdimg`

Flash this image file with your tools to sd card to boot the system.

####Configuring the on-board switch
```shell
# basic switch settings
swconfig dev switch0 set reset_mib 1
swconfig dev switch0 set reset 1
swconfig dev switch0 set enable_vlan 1
swconfig dev switch0 set enable_jumbo 1
# setup vlans for ports, CPU is on port 8 and wants tagged frames
# lan ports vlan 1-4
# the switch chip ports map to the physical ports on the board:
#     LAN      WAN
# [ 4 0 1 2 ] [ 3 ]
swconfig dev switch0 port 4 set pvid 1
swconfig dev switch0 vlan 1 set ports "8t 4"
swconfig dev switch0 port 0 set pvid 2
swconfig dev switch0 vlan 2 set ports "8t 0"
swconfig dev switch0 port 1 set pvid 3
swconfig dev switch0 vlan 3 set ports "8t 1"
swconfig dev switch0 port 2 set pvid 4
swconfig dev switch0 vlan 4 set ports "8t 2"
# wan port vlan 5
swconfig dev switch0 port 3 set pvid 5
swconfig dev switch0 vlan 5 set ports "8t 3"
swconfig dev switch0 set apply 1

# add vlan interface to eth0
for v in $(seq 1 5); do
       ip link add link eth0 name eth0.${v} type vlan id ${v}
done

```

Don't forget edit your /etc/config/network accordingly!

i.e. add eth0.1, eth0.2, eth0.3, ... interfaces there as well


Also be aware that the VLAN interface link state is not linked to the physical port, you can query the link of each port via:
```shell
for v in $(seq 0 4); do
swconfig dev switch0 port $v get link
done
```

Per-port counters can be queried via:
```shell
for v in $(seq 0 4) 8; do
swconfig dev switch0 port $v get mib
done
```
