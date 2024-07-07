SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
COMPATIBLE_MACHINE = "(sun4i|sun5i|sun7i|sun8i|sun50i)"

inherit kernel
#require recipes-kernel/linux/linux-yocto.inc
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
# Since we're not using git, this doesn't make a difference, but we need to fill
# in something or kernel-yocto.bbclass will fail.
KBRANCH ?= "master"

# Pull in the devicetree files into the rootfs
RDEPENDS_${KERNEL_PACKAGE_NAME}-base += "kernel-devicetree"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

S = "${WORKDIR}/linux-6.9"

#KBUILD_DEFCONFIG:orange-pie-one?= "multi_v7_defconfig"


KERNEL_FEATURES:remove = "cfg/fs/vfat.scc"
#  file://0001-make-yyloc-extern-for-compatibility-with-gdb-9.patch 

SRC_URI = " \
    https://mirrors.edge.kernel.org/pub/linux/kernel/v6.x/linux-6.9.tar.xz \
    file://defconfig         \  
    file://sunxi-append.cfg \
    "



SRC_URI[sha256sum] = "24fa01fb989c7a3e28453f117799168713766e119c5381dac30115f18f268149"

SRCREV = "a38297e3fb012ddfa7ce0321a7e5a8daeb1872b6"
#SRCREV = "e21a712a9685488f5ce80495b37b9fdbe96c230d"


#DELTA_KERNEL_DEFCONFIG ?="defconfig sunxi-append.cfg"



do_configure:prepend() {
    bbnote "Copying defconfig"
   # cp ${S}/arch/${ARCH}/configs/sunxi_defconfig ${WORKDIR}/defconfig
   # cp  ${WORKDIR}/armbian-orange.cfg ${WORKDIR}/defconfig
}

do_configure:append () {
    bbnote "Merging fragment"
  #  ${S}/scripts/kconfig/merge_config.sh -m -O ${B} ${B}/.config ${WORKDIR}/sunxi-append.cfg
   # ${KERNEL_CONFIG_COMMAND}


    
}


