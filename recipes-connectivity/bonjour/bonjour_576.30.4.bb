DESCRIPTION = "Bonjour is a networking technology that lets you create an instant network of computers and devices without any configuration."
SECTION = "network"
LICENSE = "Apache-2.0"

PR = "r0"

SRC_URI = "http://opensource.apple.com/tarballs/mDNSResponder/mDNSResponder-${PV}.tar.gz \
           file://bonjour.service \
          "

S = "${WORKDIR}/mDNSResponder-${PV}"

LIC_FILES_CHKSUM = "file://LICENSE;md5=31c50371921e0fb731003bbc665f29bf"

EXTRA_OEMAKE = 'CC="${CC} ${LDFLAGS}" STRIP=echo os=linux'
PARALLEL_MAKE = ""

do_compile() {
	oe_runmake -C ${S}/mDNSPosix Daemon
	oe_runmake -C ${S}/mDNSPosix libdns_sd
	oe_runmake -C ${S}/Clients
}

do_install() {

	install -d ${D}${sbindir}
	install -m 0755 mDNSPosix/build/prod/mdnsd ${D}${sbindir}/mdnsd
	install -m 0755 Clients/build/dns-sd ${D}${sbindir}/dns-sd

	install -d ${D}${includedir}
	install -m 0755 mDNSShared/dns_sd.h ${D}${includedir}
	install -d ${D}${libdir}
	install -m 0755 mDNSPosix/build/prod/libdns_sd.so ${D}${libdir}

	install -d ${D}${base_libdir}/systemd/system/multi-user.target.wants/
	install -m 0644 ${S}/../bonjour.service ${D}${base_libdir}/systemd/system
	# systemd configuration
	ln -s ../bonjour.service ${D}${base_libdir}/systemd/system/multi-user.target.wants/bonjour.service
}

do_configure() {
}

FILES_${PN} = "${base_libdir}/systemd \
		/usr/sbin \
		"

SRC_URI[md5sum] = "940057ac8b513b00e8e9ca12ef796762"
SRC_URI[sha256sum] = "4737cb51378377e11d0edb7bcdd1bec79cbdaa7b27ea09c13e3006e58f8d92c0"
