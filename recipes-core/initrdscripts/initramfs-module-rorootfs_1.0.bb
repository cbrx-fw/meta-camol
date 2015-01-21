LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "	file://80-rorootfs.sh \
"
PR = "r2"
DESCRIPTION = "An initramfs module for setting up a ro rootfs."
RDEPENDS_${PN} = "aufs-util initramfs-module-initfs"

do_install() {
	install -d ${D}${base_prefix}/initrd.d
        install -m 0755 ${WORKDIR}/80-rorootfs.sh ${D}${base_prefix}/initrd.d/
}

PACKAGE_ARCH = "all"
FILES_${PN} += " ${base_prefix}/initrd.d/* \
"
