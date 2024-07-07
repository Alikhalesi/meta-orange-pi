FILESEXTRAPATHS:prepend := "${THISDIR}/u-boot:"

SRC_URI += "file://boot.cmd \
file://nousb.cfg \
"
#file://nousb.cfg
UBOOT_ENV_SUFFIX := "scr"
UBOOT_ENV := "boot"

do_install:append() {

	# bb.plain("***********************************************");
    # bb.plain("*                                             *");
    # bb.plain("*  UBOOT Install APPEND  *");
    # bb.plain("*                                             *");
    # bb.plain("***********************************************");

 
     #install -d ${D}
     #install -d ${D}/boot
     #install -m 0755 ${DEPLOYDIR}/boot.scr ${D}/boot
     #install -m 0755 ${DEPLOYDIR}/sun8i-h3-orangepi-one.dtb ${D}/boot
   
}

FILES:${PN} += "boot/boot.scr"