SUMMARY = "Tool for some on-board ethernet switches"
HOMEPAGE = "http://www.openwrt.org"
SECTION = "console/network"
LICENSE = "GPLv2"
DEPENDS = "libnl"

SRC_URI = "svn://svn.openwrt.org/openwrt/trunk/package/network/config/swconfig;module=src;rev=45570;protocol=svn \
           file://no-uci.patch \
           file://use-stdbool.patch \
           file://libnl-link-fix.patch \
           file://LICENSE \
"

S = "${WORKDIR}/src"

LIC_FILES_CHKSUM = "file://${WORKDIR}/LICENSE;md5=94d55d512a9ba36caa9b7df079bae19f"

CFLAGS_append = " -I. -I${STAGING_INCDIR}/libnl3 -std=c99"

do_configure() {
	mkdir -p "${S}/linux"
	cp "${STAGING_KERNEL_DIR}/include/uapi/linux/switch.h" "${S}/linux"
	true
}

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}/${sbindir}
	install -m 0755 swconfig ${D}/${sbindir}
}
