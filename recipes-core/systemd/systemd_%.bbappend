FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://var-run.conf \
           file://journald.conf \
           file://camol.conf \
           file://first_boot.service \
           file://first_boot.sh \
"

do_install_append() {
	cp ${WORKDIR}/journald.conf ${D}${sysconfdir}/systemd
	install -d ${D}${localstatedir}/volatile
	mv ${D}${localstatedir}/log ${D}${localstatedir}/volatile/log
	cp ${WORKDIR}/camol.conf ${D}${libdir}/tmpfiles.d
	install -d ${D}${base_libdir}/systemd/system/multi-user.target.wants/
	install -m 0644 ${WORKDIR}/first_boot.service ${D}${base_libdir}/systemd/system
	ln -s ../first_boot.service ${D}${base_libdir}/systemd/system/multi-user.target.wants/first_boot.service
	install -d ${D}${base_prefix}/usr/bin
	install -m 0700 ${WORKDIR}/first_boot.sh ${D}/usr/bin
	install -d ${D}${includedir}/systemd
	install -m 0644 ${WORKDIR}/git/src/systemd/sd-daemon.h ${D}${includedir}/systemd
}

FILES_${PN} += " ${base_libdir}/systemd \
		${base_prefix}/usr/bin \
"

PACKAGECONFIG_remove = "resolved"
PACKAGECONFIG_remove = "networkd"
