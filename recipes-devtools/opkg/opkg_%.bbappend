FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " file://0002-Move-cache-dir.patch "

do_install_append() {
	sed -i -e 's:# option check_signature:option check_signature:' ${D}${sysconfdir}/opkg/opkg.conf
}
