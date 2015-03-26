require recipes-kernel/linux/linux-yocto.inc

DESCRIPTION = "Linux kernel for the Lamobo-R1 board"

COMPATIBLE_MACHINE = "sun7i-a20-lamobo-r1"

LINUX_VERSION ?= "3.19.1"

PV = "${LINUX_VERSION}+git${SRCPV}"

PR = "r1"

SRCREV_pn-${PN} = "5f7d7d169feef2c7c5d6f3ebbe13a9bfba2a0a32"

MACHINE_KERNEL_PR_append = "a"

SRC_URI = "git://github.com/pokymobo/linux-yocto-lamobo-r1.git;branch=standard/lamobo-r1;protocol=git \
        file://defconfig \
        "

S = "${WORKDIR}/git"
