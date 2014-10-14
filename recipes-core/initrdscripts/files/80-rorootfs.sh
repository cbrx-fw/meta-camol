#!/bin/sh

mkdir /ro
mkdir /rw
mkdir /aufs

BOOT_ROOT="/aufs"
mount /dev/mmcblk0p2 /ro
mount /dev/mmcblk0p3 /rw
mount -t aufs aufs /aufs -o noatime,dirs=/rw:/ro=ro
