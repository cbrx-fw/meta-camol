DESCRIPTION = "CPU-freq tweaks for camol"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

inherit allarch systemd

#PV = "${DISTRO_VERSION}"

SRC_URI = "file://cpu-ondemand.timer \
           file://cpu-ondemand.service \
          "	

do_compile() {
	:
}


do_install () {

	install -d ${D}${base_libdir}/systemd/system/multi-user.target.wants
	install -m 0644 ${WORKDIR}/cpu-ondemand.* ${D}${base_libdir}/systemd/system/
	ln -sf ../cpu-ondemand.timer ${D}${systemd_unitdir}/system/multi-user.target.wants/cpu-ondemand.timer
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "cpu-ondemand.timer"

FILES_${PN} += "${base_libdir}/systemd"
RDEPENDS_${PN} = "cpufrequtils"

