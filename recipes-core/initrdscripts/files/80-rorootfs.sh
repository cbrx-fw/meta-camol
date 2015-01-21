#!/bin/sh

mkdir /rw
mount /dev/mmcblk0p7 /rw

if [ -e /rw/boot/active ]; then
  ACTIVE=$(cat /rw/boot/active)
else
  ACTIVE='A'
  mkdir -p /rw/boot
  echo A>/rw/boot/active
fi
if [ ! ${ACTIVE} ]; then
  echo Undefined active state
  exit
fi
if [ -e /rw/boot/never_booted ]; then
  if [ -e /rw/boot/first_boot ]; then
    if [ $(cat /rw/boot/first_boot) = ${ACTIVE} ]; then
      echo Failed boot - reverting
      rm /rw/boot/first_boot
      rm /rw/boot/never_booted
      if [ ${ACTIVE} = 'A' ]; then
        ACTIVE='B'
        echo B>/rw/boot/active
      else
        ACTIVE='A'
        echo A>/rw/boot/active
      fi
    else	
      echo Illegal first boot state - clearing
      echo ${ACTIVE}>/rw/boot/first_boot
    fi
  else
    echo ${ACTIVE}>/rw/boot/first_boot
  fi
fi

if [ ${ACTIVE} = 'A' ]; then
  DRIVE='/dev/mmcblk0p5'
fi
if [ ${ACTIVE} = 'B' ]; then
  DRIVE='/dev/mmcblk0p6'
fi
if [ ! ${DRIVE} ]; then
  echo Illegal active state
  exit
fi
if [ -e /rw/update_flag ]; then
  rm /rw/update_flag
  umount /rw
  BOOT_ROOT="/new_root"
  mkdir /new_root
  mount ${DRIVE} /new_root
else
  mkdir /ro
  mkdir /aufs

  BOOT_ROOT="/aufs"
  mount ${DRIVE} /ro
  mount -t aufs aufs /aufs -o noatime,dirs=/rw:/ro=ro
fi
