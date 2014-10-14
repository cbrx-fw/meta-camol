LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
# initramfs image allowing to boot from location as specified on kernel
# command line, from the choices of block device, loop back images (including
# recursive) and NFS.

PACKAGE_INSTALL = "busybox initramfs-module-initfs initramfs-module-rorootfs"
IMAGE_FSTYPES = "cpio.gz"
IMAGE_LINGUAS = ""
IMAGE_FEATURES = ""
IMAGE_LOGIN_MANAGER = ""
IMAGE_INIT_MANAGER = ""
IMAGE_INITSCRIPTS = ""
IMAGE_DEV_MANAGER = ""

FEED_DEPLOYDIR_BASE_URI = ""
LDCONFIGDEPEND = ""

# avoid circular dependencies
EXTRA_IMAGEDEPENDS = ""

# Remove any kernel-image that the kernel-module-* packages may have pulled in.
PACKAGE_REMOVE = "kernel-image-* update-modules"
ROOTFS_POSTPROCESS_COMMAND += "opkg-cl ${IPKG_ARGS} -force-depends \
                                remove ${PACKAGE_REMOVE};"

inherit image
