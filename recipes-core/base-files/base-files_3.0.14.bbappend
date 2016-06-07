FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

dirs755 += "/run \
"

do_install_append () {
	ln -snf ../run ${D}${localstatedir}/run
	ln -snf ../run/lock ${D}${localstatedir}/lock
	echo /usr/bin/rssh >> ${D}${sysconfdir}/shells
	install -d ${D}/dev
	mknod -m 622 ${D}/dev/console c 5 1
}

FILES_${PN} += " /dev "
