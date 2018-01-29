LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PV = "${DISTRO_VERSION}"
PR = "r11"
PE = "2"

SRC_URI = "file://lsb_release \
           file://release_version \
"

PACKAGES = "${PN}"
PACKAGE_ARCH = "${MACHINE_ARCH}"

def get_layers(bb, d):
    layers = (d.getVar("BBLAYERS", d, 1) or "").split()
    layers_branch_rev = ["%-17s = \"%s:%s\"" % (os.path.basename(i), \
        base_get_metadata_git_branch(i, None).strip().strip('()'), \
        base_get_metadata_git_revision(i, None)) \
        for i in layers]
    i = len(layers_branch_rev)-1
    p1 = layers_branch_rev[i].find("=")
    s1= layers_branch_rev[i][p1:]
    while i > 0:
        p2 = layers_branch_rev[i-1].find("=")
        s2= layers_branch_rev[i-1][p2:]
        if s1 == s2:
            layers_branch_rev[i-1] = layers_branch_rev[i-1][0:p2]
            i -= 1
        else:
            i -= 1
            p1 = layers_branch_rev[i].find("=")
            s1= layers_branch_rev[i][p1:]

    layertext = "Configured Openembedded layers:\n%s\n" % '\n'.join(layers_branch_rev)
    layertext = layertext.replace('<','')
    layertext = layertext.replace('>','')
    return layertext

do_install() {
	install -d ${D}${sysconfdir}
	echo "Cambrionix Linux ${DISTRO_VERSION} (EtherSync Core)" > ${D}${sysconfdir}/camol-version
	echo "Built from branch: ${METADATA_BRANCH}" >> ${D}${sysconfdir}/camol-version
	echo "Revision: ${METADATA_REVISION}" >> ${D}${sysconfdir}/camol-version
	echo "Target system: ${TARGET_SYS}" >> ${D}${sysconfdir}/camol-version
	echo "Release Version: $(cat ${WORKDIR}/release_version)" >> ${D}${sysconfdir}/camol-version
	echo $(date) >> ${D}${sysconfdir}/camol-version

	echo "${@get_layers(bb, d)}" > ${D}${sysconfdir}/camol-build-info

	install -d ${D}${bindir}
	install -m 0755 ${WORKDIR}/lsb_release ${D}${bindir}/
}
