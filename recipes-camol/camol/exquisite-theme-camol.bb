DDESCRIPTION = "Cambrionix Linux theme for exquisite"
HOMEPAGE = "http://www.enlightenment.org"
LICENSE = "BSD"
SECTION = "x11"

DEPENDS = "edje-native"
RRECOMMENDS_${PN} = "exquisite"

PR = "r1"
PV = "1.2"

inherit update-alternatives

ALTERNATIVE_NAME = "exquisite-config"
ALTERNATIVE_LINK = "${sysconfdir}/exquisite/config"
ALTERNATIVE_PATH = "${sysconfdir}/exquisite/config-camol"
ALTERNATIVE_PRIORITY = "20"

SRC_URI = "file://camol/"

S = "${WORKDIR}/camol"

do_compile() {
   edje_cc exquisite-ang.edc camol.edj
}

do_install() {
    install -d ${D}${sysconfdir}/exquisite
    install -d ${D}${datadir}/exquisite/data/themes
    install -m 0644 ${S}/camol.edj ${D}${datadir}/exquisite/data/themes/
    echo 'THEME="-t camol"' > ${D}${sysconfdir}/exquisite/config-camol
}

PACKAGE_ARCH = "all"
CONFFILES_${PN} = "${sysconfdir}/exquisite/config-camol"
FILES_${PN} = "${sysconfdir}/exquisite ${datadir}/exquisite/data/themes"
