DESCRIPTION = "Task packages for the Cambrionix Linux distribution"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PR = "r0"

inherit packagegroup

RDEPENDS_${PN} = "\
    kernel-module-hmac \
    kernel-module-sha256-generic \
    kernel-module-authenc \
    kernel-module-authencsn \
    kernel-module-cbc \
    kernel-module-des-generic \
    kernel-module-ecb \
"
