DESCRIPTION = "libdvbsi++ by obi@saftware.de"
DEPENDS = "dreambox-dvbincludes"
MAINTAINER = "Felix Domke <tmbinc@elitdvb.net>"

SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/dvb/libdvbsi++;method=ext;rsh=ssh"
SRC_URI += " \
	    file://SkipEmptyEPG.diff \
	   "
PR = "r0"
PV = "0.0+cvs${SRCDATE}"

S = "${WORKDIR}/libdvbsi++"

inherit autotools pkgconfig

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
		bindir=${STAGING_BINDIR} \
		includedir=${STAGING_INCDIR} \
		libdir=${STAGING_LIBDIR} \
		datadir=${STAGING_DATADIR}
}

EXTRA_OECONF = "--with-target=native"
