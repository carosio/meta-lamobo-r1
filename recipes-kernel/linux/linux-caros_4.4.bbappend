FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PROVIDES += "linux-sunxi"

DESCRIPTION = "Linux kernel for the Lamobo-R1 board"

COMPATIBLE_MACHINE = "sun7i-a20-lamobo-r1"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

PR = "r1"

KBRANCH = "yocto/lamobo-r1"
SRC_URI = "git://github.com/thz/linux;name=machine;branch=${KBRANCH}"
SRC_URI += "git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-4.4;destsuffix=${KMETA}"

SRCREV_machine = "c965cfaa938710ec00289e143a96630d301c0836"

# TODO this full-spec should be changed to feature-file-mechanism:
SRC_URI += "file://defconfig"
SRC_URI += "file://netfilter.cfg"
SRC_URI += "file://b53.cfg"
do_patch_append() {
	cat ${WORKDIR}/*.cfg >> ${WORKDIR}/defconfig
}

# We need to pass it as param since kernel might support more then one
# machine, with different entry points
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

