do_install_append() {
	install -d ${D}${localstatedir}/volatile/run
}
