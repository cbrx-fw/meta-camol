FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://journald.conf \
            file://camol.conf \
"

do_install_append() {
	cp ${WORKDIR}/journald.conf ${D}${sysconfdir}/systemd
	install -d ${D}${localstatedir}/volatile
	mv ${D}${localstatedir}/log ${D}${localstatedir}/volatile/log
	cp ${WORKDIR}/camol.conf ${D}${libdir}/tmpfiles.d
}
