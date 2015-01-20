#!/bin/sh

if [ -e /boot/never_booted -a -e /boot/first_boot ]; then
  PSE=$(ps -e|grep esusbsrvr)
  if [ "${PSE}" != "" ]; then
    rm /boot/never_booted
    rm /boot/first_boot
  fi
fi
