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

BBLAYERS ?= " \\
/home/john/opensource/yocto/poky-fido-13.0.0/meta \\
/home/john/opensource/yocto/poky-fido-13.0.0/meta-yocto \\
/home/john/opensource/yocto/poky-fido-13.0.0/meta-yocto-bsp \\
/home/john/opensource/yocto/poky-fido-13.0.0/meta-lamobo-r1 \\
/home/john/opensource/yocto/poky-fido-13.0.0/meta-openembedded/meta-networking \\
/home/john/opensource/yocto/poky-fido-13.0.0/meta-openembedded/meta-oe \\
/home/john/opensource/yocto/poky-fido-13.0.0/meta-openembedded/meta-python \\
"
BBLAYERS_NON_REMOVABLE ?= " \\
/home/john/opensource/yocto/poky-fido-13.0.0/meta \\
/home/john/opensource/yocto/poky-fido-13.0.0/meta-yocto \\
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
