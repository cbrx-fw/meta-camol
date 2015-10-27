DESCRIPTION = "Basic packagegroup to get a Cambrionix Linux powered device booting"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PR = "r5"

# packages which content depend on MACHINE_FEATURES need to be MACHINE_ARCH
#
PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

DEPENDS = "packagegroup-boot"

#
# minimal set of packages - needed to boot
#
RDEPENDS_${PN} = "\
	packagegroup-boot \
	camol-version \
    "

