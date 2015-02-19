#!/bin/sh

if [ -e /boot/unbooted ]; then
  mv /boot/unbooted /boot/never_booted
  reboot
fi

if [ -e /boot/never_booted -a -e /boot/first_boot ]; then
  rm /boot/never_booted
  rm /boot/first_boot
fi
