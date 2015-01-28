PRINC := "${@int(PRINC) + 1}"

SRCREV = "18811d22e9923893555b88a482aa967db0e7892a"

SRC_URI = "git://git.kernel.org/pub/scm/utils/kernel/kmod/kmod.git \
           file://depmod-search.conf \
"

PV = "15"
