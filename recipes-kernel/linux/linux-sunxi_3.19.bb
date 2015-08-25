require recipes-kernel/linux/linux-dtb.inc

inherit kernel

DESCRIPTION = "Linux kernel for the Lamobo-R1 board"

COMPATIBLE_MACHINE = "sun7i-a20-lamobo-r1"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

LINUX_VERSION ?= "3.19.1"

LOCALVERSION = "-sunxi"

PV = "${LINUX_VERSION}+git${SRCPV}"

PR = "r1"

KBRANCH ?= "standard/lamobo-r1"

KERNEL_DEFCONFIG ?= "sunxi_defconfig"

SRCREV_pn-${PN} = "87ee090823b555e98b799622b741d256505bf3c9"

SRC_URI = "git://github.com/pokymobo/linux-yocto-lamobo-r1.git;branch=standard/lamobo-r1;protocol=git \
        file://defconfig \
        "
# We need to pass it as param since kernel might support more then one
# machine, with different entry points
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${WORKDIR}/git"
