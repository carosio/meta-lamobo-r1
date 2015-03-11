require recipes-kernel/linux/linux-yocto.inc

DESCRIPTION = "Linux kernel for Allwinner a10/a20 processors"

COMPATIBLE_MACHINE = "(bananapi|cubieboard|cubieboard2|cubietruck|forfun-q88db|lamobo-r1|mele|meleg|olinuxino-a10|olinuxino-a10lime|olinuxino-a10s|olinuxino-a13|olinuxino-a13som|olinuxino-a20|olinuxino-a20lime|olinuxino-a20lime2|olinuxino-a20som)"

LINUX_VERSION ?= "3.19.1"

PV = "${LINUX_VERSION}+git${SRCPV}"

PR = "r1"

SRCREV_pn-${PN} = "c0546fe54ef28e3bc98b061642e13ade5d8dabb2"

MACHINE_KERNEL_PR_append = "a"

SRC_URI = "git://github.com/pokymobo/linux-yocto-lamobo-r1.git;protocol=git \
        file://defconfig \
        "
S = "${WORKDIR}/git"
