FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
#require recipes-kernel/linux/linux-dtb.inc

PROVIDES += "linux-sunxi"

DESCRIPTION = "Linux kernel for the Lamobo-R1 board"

COMPATIBLE_MACHINE = "sun7i-a20-lamobo-r1"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

#LINUX_VERSION ?= "4.4"

#LOCALVERSION = "-sunxi"

PR = "r1"

# 4.4 should have everything upstreamed by now
KBRANCH = "yocto/lamobo-r1"
SRC_URI = "git://github.com/thz/linux;name=machine;branch=${KBRANCH}"
SRC_URI += "git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-4.4;destsuffix=${KMETA}"

SRCREV_machine = "6bc75dd677bb0232532dc597cee91f4305efcb2b"

SRC_URI += "file://defconfig"
KERNEL_DEFCONFIG ?= "sunxi_defconfig"

# We need to pass it as param since kernel might support more then one
# machine, with different entry points
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

