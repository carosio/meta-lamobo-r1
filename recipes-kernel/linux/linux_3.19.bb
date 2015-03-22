require recipes-kernel/linux/linux-yocto.inc

DESCRIPTION = "Linux kernel for the Lamobo-R1 board"

COMPATIBLE_MACHINE = "sun7i-a20-lamobo-r1"

LINUX_VERSION ?= "3.19.1"

PV = "${LINUX_VERSION}+git${SRCPV}"

PR = "r1"

SRCREV_pn-${PN} = "4b2fee21dce2ead623ffb03454b666a3f7fb9c90"

MACHINE_KERNEL_PR_append = "a"

SRC_URI = "git://github.com/pokymobo/linux-yocto-lamobo-r1.git;branch=standard/lamobo-r1;protocol=git \
        file://defconfig \
        "

S = "${WORKDIR}/git"
