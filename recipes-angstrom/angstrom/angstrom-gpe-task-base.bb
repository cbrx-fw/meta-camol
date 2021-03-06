DESCRIPTION = "Task packages for the Angstrom distribution"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

PR = "r40"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = "\
    gpe-scap \
    matchbox \
    matchbox-panel-hacks \
    matchbox-applet-startup-monitor \
    rxvt-unicode \
    gpe-terminal \
    matchbox-keyboard \
    xkbd \
    xkbd-layout-ru \
    xst \
    xhost \
    xrdb \
    gpe-soundserver \
    gpe-dm \
    gpe-login \
    gpe-session-scripts \
    gpe-icons \
    gpe-confd \
    gpe-autostarter \
    ${@base_contains("MACHINE_FEATURES", "touchscreen", "libgtkstylus", "",d)} \
    suspend-desktop \
    teleport \
    xauth \
    gdk-pixbuf-loader-png \
    gdk-pixbuf-loader-xpm \
    gdk-pixbuf-loader-jpeg \
    pango-module-basic-x \
    pango-module-basic-fc \
    ${@base_contains("COMBINED_FEATURES", "bluetooth", "gnome-bluetooth", "",d)} \
    "

RRECOMMENDS_${PN} = " \
    gpe-theme-clearlooks \
    xcursor-transparent-theme \
"
