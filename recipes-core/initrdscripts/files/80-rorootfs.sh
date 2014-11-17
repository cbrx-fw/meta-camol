#!/bin/sh

mkdir /rw
mount /dev/mmcblk0p3 /rw

if [ -e /rw/update_flag ]; then
	umount /rw
	BOOT_ROOT="/root"
	mkdir /root
	mount /dev/mmcblk0p2 /root
else
	mkdir /ro
	mkdir /aufs

	BOOT_ROOT="/aufs"
	mount /dev/mmcblk0p2 /ro
	mount -t aufs aufs /aufs -o noatime,dirs=/rw:/ro=ro
fi
