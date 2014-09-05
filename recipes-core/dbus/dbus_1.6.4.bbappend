do_install_append() {
	install -d ${D}${localstatedir}/volatile
	mv ${D}${localstatedir}/run ${D}${localstatedir}/volatile/run
}
