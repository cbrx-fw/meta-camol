DESCRIPTION = "Bonjour is a networking technology that lets you create an instant network of computers and devices without any configuration."
SECTION = "network"
LICENSE = "Apache-2.0"

PR = "r3"

SRC_URI = "http://www.opensource.apple.com/darwinsource/tarballs/other/mDNSResponder-${PV}.tar.gz \
           file://bonjour.service \
          "

S = "${WORKDIR}/mDNSResponder-${PV}"

LIC_FILES_CHKSUM = "file://LICENSE;md5=31c50371921e0fb731003bbc665f29bf"

EXTRA_OEMAKE = 'CC="${CC} ${LDFLAGS}" STRIP=echo os=linux'
PARALLEL_MAKE = ""

do_compile() {
	oe_runmake -C ${S}/mDNSPosix Daemon
	oe_runmake -C ${S}/mDNSPosix libdns_sd
	oe_runmake -C ${S}/mDNSPosix nss_mdns
	oe_runmake -C ${S}/Clients
}

do_install() {

	install -d ${D}${sbindir}
	install -m 0755 mDNSPosix/build/prod/mdnsd ${D}${sbindir}/mdnsd
	install -m 0755 Clients/build/dns-sd ${D}${sbindir}/dns-sd

	install -d ${D}${includedir}
	install -m 0644 mDNSShared/dns_sd.h ${D}${includedir}

	install -d ${D}${base_libdir}/systemd/system/multi-user.target.wants/
	install -m 0755 mDNSPosix/build/prod/libdns_sd.so ${D}${base_libdir}
	install -m 0644 ${S}/../bonjour.service ${D}${base_libdir}/systemd/system
	# systemd configuration
	ln -s ../bonjour.service ${D}${base_libdir}/systemd/system/multi-user.target.wants/bonjour.service

	install -d ${D}${sysconfdir}
	install -m 0444 mDNSPosix/nss_mdns.conf ${D}${sysconfdir}
	install -m 0755 mDNSPosix/build/prod/libnss_mdns-0.2.so ${D}${base_libdir}
	ln -s ./libnss_mdns-0.2.so ${D}${base_libdir}/libnss_mdns.so.2
}

do_configure() {
}

PACKAGES =+ "${PN}-nss"

FILES_${PN} =  "${base_libdir}/systemd \
		${sbindir} \
"

FILES_${PN}-nss = "${sysconfdir} \
                   ${base_libdir}/libnss_mdns* \
"

pkg_postinst_${PN}-nss () {
	sed -e '/^hosts:/s/\s*\<mdns4\>//' \
		-e 's/\(^hosts:.*\)\(\<files\>\)\(.*\)\(\<dns\>\)\(.*\)/\1\2 mdns\3\4\5/' \
		-i $D/etc/nsswitch.conf
}

pkg_prerm_${PN}-nss () {
	sed -e '/^hosts:/s/\s*\<mdns\>//' \
		-i /etc/nsswitch.conf
}

SRC_URI[md5sum] = "6eff6d243a12a3d4b6fca03c05a9893b"
SRC_URI[sha256sum] = "3239d9bb1e1e017be1ae12cff90802194b6e0312de628a1f324530b00b833018"
