FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DESCRIPTION = "Linux kernel for the Lamobo-R1 board"

SRC_URI += "file://sun7i-a20-lamobo-r1;type=kmeta;destsuffix=sun7i-a20-lamobo-r1"

COMPATIBLE_MACHINE_sun7i-a20-lamobo-r1 = "sun7i-a20-lamobo-r1"

PROVIDES += "linux-sunxi"

KBRANCH_sun7i-a20-lamobo-r1 = "standard/base"
KMACHINE_sun7i-a20-lamobo-r1 = "sun7i-a20-lamobo-r1"

KERNEL_FEATURES_append_sun7i-a20-lamobo-r1 = "bsp/sun7i-a20-lamobo-r1/sun7i-a20-lamobo-r1.scc"

# We need to pass it as param since kernel might support more then one
# machine, with different entry points
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"
