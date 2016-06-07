SUMMARY = "Initramfs files"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
DEPENDS = "virtual/kernel"

do_install() {
        install -d ${D}/dev
        mknod -m 622 ${D}/dev/console c 5 1
}

FILES_${PN} += " /dev "

# Due to kernel depdendency
PACKAGE_ARCH = "${MACHINE_ARCH}"
