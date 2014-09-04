INHERIT += "package_ipk"

CAMOL_FEED_CONFIGS ?= "camol-feed-configs"

EXTRAOPKGCONFIG = "opkg-config-base ${CAMOL_FEED_CONFIGS}"

CAMOL_IPK_UPDATE_ALTERNATIVES ?= "update-alternatives-cworth"

DISTRO_UPDATE_ALTERNATIVES = "${CAMOL_IPK_UPDATE_ALTERNATIVES}"

# we need the same provider for opkg and u-a
PREFERRED_PROVIDER_virtual/update-alternatives-native ?= "opkg-native"
PREFERRED_PROVIDER_virtual/update-alternatives = "${CAMOL_IPK_UPDATE_ALTERNATIVES}"
VIRTUAL-RUNTIME_update-alternatives = "${CAMOL_IPK_UPDATE_ALTERNATIVES}"

