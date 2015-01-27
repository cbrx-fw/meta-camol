PRINC := "${@int(PRINC) + 1}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRCREV = "dee4c244254bb49d1ffa8bd7171ae9cce596d2d0"
SRC_URI += "file://journald.conf \
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
}

FILES_${PN} += " ${base_libdir}/systemd \
		${base_prefix}/usr/bin \
"
