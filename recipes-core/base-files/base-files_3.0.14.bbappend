FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

dirs755 += "/run \
"

do_install_append () {
	ln -snf ../run ${D}${localstatedir}/run
	ln -snf ../run/lock ${D}${localstatedir}/lock
	echo /usr/bin/rssh >> ${D}${sysconfdir}/shells
}
