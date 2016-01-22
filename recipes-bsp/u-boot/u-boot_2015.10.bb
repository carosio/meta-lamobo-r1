DESCRIPTION = "U-Boot port for sunxi"

require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

COMPATIBLE_MACHINE = "sun7i-a20-lamobo-r1"

DEFAULT_PREFERENCE_lamobo-r1="1"

SRC_URI += "file://006-add-lamobo-r1.patch"
SRC_URI += "file://uEnv.txt"

PE = "1"

PV = "v2015.10"
SRCREV = "5ec0003b19cbdf06ccd6941237cbc0d1c3468e2d"

UBOOT_ENV = "boot"
UBOOT_ENV_SUFFIX = "scr"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SPL_BINARY="u-boot-sunxi-with-spl.bin"

do_compile_append() {
    ${S}/tools/mkimage -C none -A arm -T script -d ${WORKDIR}/uEnv.txt ${WORKDIR}/${UBOOT_ENV_BINARY}
}
