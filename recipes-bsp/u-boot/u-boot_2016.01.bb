DESCRIPTION = "U-Boot port for sunxi"

require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

COMPATIBLE_MACHINE = "sun7i-a20-lamobo-r1"

DEFAULT_PREFERENCE_lamobo-r1="1"

SRC_URI += "file://uEnv.txt"

PE = "1"

PV = "v2016.01"
SRCREV = "fa85e826c16b9ce1ad302a57e9c4b24db0d8b930"

UBOOT_ENV = "boot"
UBOOT_ENV_SUFFIX = "scr"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SPL_BINARY="u-boot-sunxi-with-spl.bin"

do_compile_append() {
    ${S}/tools/mkimage -C none -A arm -T script -d ${WORKDIR}/uEnv.txt ${WORKDIR}/${UBOOT_ENV_BINARY}
}
