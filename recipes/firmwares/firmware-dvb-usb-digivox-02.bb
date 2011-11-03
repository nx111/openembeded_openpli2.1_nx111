require linux-firmware.inc

DESCRIPTION = "Firmware for dvb-usb-digivox-02"

SRCREV = "46c66487a85cd05a4acbd5eb4828f72783d1be4c"

do_install() {
	install -d ${D}${base_libdir}/firmware
	install -m 0644 dvb-usb-digivox-02.fw ${D}${base_libdir}/firmware
}
