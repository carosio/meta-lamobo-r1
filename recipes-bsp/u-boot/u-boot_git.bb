DESCRIPTION = "U-Boot port for sunxi"

require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

# No patches for other machines yet

COMPATIBLE_MACHINE = "(bananapi|cubieboard|cubieboard2|cubietruck|forfun-q88db|mele|meleg|olinuxino-a10|olinuxino-a10lime|olinuxino-a10s|olinuxino-a13|olinuxino-a13som|olinuxino-a20|olinuxino-a20lime|olinuxino-a20lime2|olinuxino-a20som)"

DEFAULT_PREFERENCE_bananapi="1"
DEFAULT_PREFERENCE_cubieboard="1"
DEFAULT_PREFERENCE_cubieboard2="1"
DEFAULT_PREFERENCE_cubietruck="1"
DEFAULT_PREFERENCE_forfun-q88db="1"
DEFAULT_PREFERENCE_mele="1"
DEFAULT_PREFERENCE_meleg="1"
DEFAULT_PREFERENCE_olinuxino-a10="1"
DEFAULT_PREFERENCE_olinuxino-a10lime="1"
DEFAULT_PREFERENCE_olinuxino-a10s="1"
DEFAULT_PREFERENCE_olinuxino-a13="1"
DEFAULT_PREFERENCE_olinuxino-a13som="1"
DEFAULT_PREFERENCE_olinuxino-a20="1"
DEFAULT_PREFERENCE_olinuxino-a20lime="1"
DEFAULT_PREFERENCE_olinuxino-a20lime2="1"
DEFAULT_PREFERENCE_olinuxino-a20som="1"

SRC_URI = "git://github.com/LeMaker/u-boot-bananapi.git;protocol=git;branch=lemaker"

PE = "1"

PV = "v2014.12"
SRCREV = "bb5691c9ce9880949c8d7871c4a37548e95d773e"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"

SPL_BINARY="u-boot-sunxi-with-spl.bin"
