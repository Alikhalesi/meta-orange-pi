LICENSE = "CLOSED"
inherit module

RPROVIDES:${PN}="kernel-module-${PN}"
MODULE_NAME = "stm-programmer"
S = "${WORKDIR}/git"

SRC_URI = "git://github.com/alikhalesi/LinuxDriver;protocol=https;branch=master"
SRCREV = "${AUTOREV}"
SRC_URI[sha256sum] = "ad39cc021a3a57deddfce93f0ba03a0117706b4a03da3dc3e50434765e655bf3"