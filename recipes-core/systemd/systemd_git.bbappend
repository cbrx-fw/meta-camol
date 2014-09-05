FILESEXTRAPATHS := "${THISDIR}/${PN}"

SRC_URI += "file://journald.conf"

do_install_append() {
	cp ${WORKDIR}/journald.conf ${D}${sysconfdir}/systemd
	mv ${D}${localstatedir}/log ${D}${localstatedir}/volatile/log
}
