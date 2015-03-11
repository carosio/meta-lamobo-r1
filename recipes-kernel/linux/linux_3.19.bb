require recipes-kernel/linux/linux-yocto.inc

DESCRIPTION = "Linux kernel for the Lamobo-R1 board"

COMPATIBLE_MACHINE = "lamobo-r1"

LINUX_VERSION ?= "3.19.1"

PV = "${LINUX_VERSION}+git${SRCPV}"

PR = "r1"

SRCREV_pn-${PN} = "c0546fe54ef28e3bc98b061642e13ade5d8dabb2"

MACHINE_KERNEL_PR_append = "a"

SRC_URI = "git://github.com/pokymobo/linux-yocto-lamobo-r1.git;protocol=git \
        file://defconfig \
        "
S = "${WORKDIR}/git"
