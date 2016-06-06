PRINC := "${@int(PRINC) + 1}"

do_install_append () {
	rm ${D}${sysconfdir}/avahi/services/ssh.service
	rm ${D}${sysconfdir}/avahi/services/sftp-ssh.service
}
