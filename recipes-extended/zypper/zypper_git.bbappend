FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://camol.repo"

do_install_append() {
	install -d ${D}${sysconfdir}/zypp/repos.d
	install -m 0644 ${WORKDIR}/camol.repo ${D}${sysconfdir}/zypp/repos.d/
}

FILES_${PN} += "${sysconfdir}/zypp/repos.d/camol.repo"
