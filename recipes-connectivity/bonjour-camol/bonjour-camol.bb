DESCRIPTION = "Use Bonjour mdnsd to advertise EtherSync on network"
SECTION = "network"
LICENSE = "Apache-2.0"

PR = "r0"

SRC_URI = "file://bonjour-camol.service \
          "

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

do_install() {

	install -d ${D}${base_libdir}/systemd/system/multi-user.target.wants/
	install -m 0644 ${S}/../bonjour-camol.service ${D}${base_libdir}/systemd/system
	# systemd configuration
	ln -s ../bonjour-camol.service ${D}${base_libdir}/systemd/system/multi-user.target.wants/bonjour-camol.service
}

FILES_${PN} = "${base_libdir}/systemd \
		"
