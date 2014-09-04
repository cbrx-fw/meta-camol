DESCRIPTION = "Task packages for the Cambrionix Linux distribution"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

PR = "r1"
ALLOW_EMPTY = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "\
    camol-e-base-depends \
    camol-e-depends"

RDEPENDS_camol-e-base-depends := "\
    camol-x11-base-depends \
    rxvt-unicode xstroke xtscal xrandr xmodmap xdpyinfo \
    ttf-bitstream-vera \
    elementary-tests expedite e-wm \
    glibc-charmap-utf-8 glibc-localedata-i18n"
#xserver-kdrive-fbdev 

RDEPENDS_camol-e-depends := "\
                        pango-module-basic-fc \
                        gdk-pixbuf-loader-bmp \
                        gdk-pixbuf-loader-gif \
                        gdk-pixbuf-loader-jpeg \
                        gdk-pixbuf-loader-png \
                        gdk-pixbuf-loader-pnm \
                        gdk-pixbuf-loader-xbm \
                        gdk-pixbuf-loader-xpm"
