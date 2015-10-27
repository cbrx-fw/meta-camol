INHERIT += "package_ipk"

CAMOL_FEED_CONFIGS ?= "camol-feed-configs"

EXTRAOPKGCONFIG = "opkg-config-base ${CAMOL_FEED_CONFIGS}"

CAMOL_IPK_UPDATE_ALTERNATIVES ?= "update-alternatives-opkg"

DISTRO_UPDATE_ALTERNATIVES = "${CAMOL_IPK_UPDATE_ALTERNATIVES}"

# we need the same provider for opkg and u-a
PREFERRED_PROVIDER_virtual/update-alternatives-native ?= "opkg-utils-native"
PREFERRED_PROVIDER_virtual/update-alternatives = "opkg-utils"
VIRTUAL-RUNTIME_update-alternatives = "${CAMOL_IPK_UPDATE_ALTERNATIVES}"

