DESCRIPTION = "U-Boot port for sunxi"

require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

COMPATIBLE_MACHINE = "lamobo-r1"

DEFAULT_PREFERENCE_lamobo-r1="1"

SRC_URI += "file://002-add-linksprite-pcduino.diff \
	file://003-add-lemaker-bananapro.diff \
	file://004-add-olimex-a13-som.diff \
	file://005-add-gmac-tx-delay-variant.patch \
	file://006-add-lamobo-r1.patch \
"

PE = "1"

PV = "v2015.01"
SRCREV = "bb5691c9ce9880949c8d7871c4a37548e95d773e"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SPL_BINARY="u-boot-sunxi-with-spl.bin"
