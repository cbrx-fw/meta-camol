SUMMARY = "Utilities to support aufs"
SECTION = "libs"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=892f569a555ba9c07a568a7c0c4fa63a"

SRC_URI = "git://git.code.sf.net/p/aufs/aufs-util;branch=aufs3.2"

SRCREV = "d7f91849723b1f5203c11babe865594ac4b485c3"

S = "${WORKDIR}/git"

EXTRA_OEMAKE += 'CFLAGS="${CFLAGS} -I${STAGING_INCDIR}/uapi"'

do_configure_prepend() {
	sed -e 's/-static -s/-static/' -i ${S}/Makefile || true
	sed -e 's/644 -s/644/' -i ${S}/libau/Makefile || true
}

do_compile() {
	make CFLAGS="${CFLAGS} -I${STAGING_INCDIR}/uapi" auibusy auplink mount.aufs umount.aufs etc_default_aufs
	make CFLAGS="${CFLAGS} -I${STAGING_INCDIR}/uapi -fPIC -DNDEBUG -D_REENTRANT -I. -DRdu64" -C libau rdu64.o
	make CFLAGS="${CFLAGS} -I${STAGING_INCDIR}/uapi -fPIC -DNDEBUG -D_REENTRANT -I." -C libau
}

do_install() {
	make DESTDIR=${D} install_sbin install_ubin install_etc install_ulib
}
