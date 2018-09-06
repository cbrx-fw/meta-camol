DESCRIPTION = "Task packages for the Cambrionix Linux distribution"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PR = "r0"

inherit packagegroup

RDEPENDS_${PN} = "openssl \
                  tzdata-americas \
                  tzdata-africa \
                  tzdata-antarctica \
                  tzdata-arctic \
                  tzdata-asia \
                  tzdata-atlantic \
                  tzdata-australia \
                  tzdata-europe \
                  tzdata-misc \
                  tzdata-pacific \
                  tzdata-posix \
                  tzdata-right \
"
