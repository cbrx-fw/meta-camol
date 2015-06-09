inherit systemd

PRINC := "${@int(PRINC) + 1}"

EXTRA_OECONF += "--with-systemdunitdir=${systemd_unitdir}/system/"

SYSTEMD_PACKAGES = "${PN}-systemd"
SYSTEMD_SERVICE_${PN}-systemd = "connman.service"

FILESEXTRAPATHS_prepend := "${THISDIR}/camol:"

SRC_URI += "file://settings"

do_install_append() {
	install -d ${D}${localstatedir}/lib/connman/
	install -m 0644 ${WORKDIR}/settings ${D}${localstatedir}/lib/connman/
}

PACKAGES =+ "${PN}-camol-settings"

FILES_${PN}-camol-settings = "${localstatedir}/lib/connman/settings"
RDEPENDS_${PN}-camol-settings = "${PN}"
FILES_${PN} += " ${systemd_unitdir}/system/ "
