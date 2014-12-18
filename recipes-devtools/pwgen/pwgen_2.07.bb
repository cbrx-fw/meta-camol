DESCRIPTION = "Password generator which creates passwords which can be easily memorized by a human"
HOMEPAGE = "http://sf.net/projects/pwgen/"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-1.0;md5=e9e36a9de734199567a4d769498f743d"

SRC_URI = "${SOURCEFORGE_MIRROR}/pwgen/pwgen-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "910b1008cdd86445e9e01305d21ee4c5"
SRC_URI[sha256sum] = "eb74593f58296c21c71cd07933e070492e9222b79cedf81d1a02ce09c0e11556"
