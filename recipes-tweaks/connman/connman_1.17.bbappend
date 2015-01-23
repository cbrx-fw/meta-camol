FILESEXTRAPATHS_prepend := "${THISDIR}/camol:"

SRC_URI += "file://settings"

do_install_append() {
	install -d ${D}${localstatedir}/lib/connman/
	install -m 0644 ${WORKDIR}/settings ${D}${localstatedir}/lib/connman/
}

PACKAGES =+ "${PN}-camol-settings"

FILES_${PN}-camol-settings = "${localstatedir}/lib/connman/settings"
RDEPENDS_${PN}-camol-settings = "${PN}"
