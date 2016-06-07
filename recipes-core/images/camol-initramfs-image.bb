SUMMARY = "Initramfs image for Cambrionix Linux"
DESCRIPTION = "Small image capable of bootstraping AUFS."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PACKAGE_INSTALL = "busybox initramfs-module-initfs initramfs-module-rorootfs"
IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
IMAGE_LINGUAS = ""
IMAGE_FEATURES = ""
BAD_RECOMMENDATIONS += "busybox-syslog"

export IMAGE_BASENAME = "camol-initramfs-image"

inherit core-image
