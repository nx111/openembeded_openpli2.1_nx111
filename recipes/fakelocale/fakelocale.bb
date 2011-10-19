DESCRIPTION = "Fake locale support"
SECTION = "base"
PRIORITY = "required"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"
PR = "r2"

SRC_URI = "http://sources.dreamboxupdate.com/download/opendreambox/fakelocale.tar.gz file://locale.alias"

S = "${WORKDIR}/fakelocale"

LOCALEDIR = "${libdir}/locale"
LOCALEDIR2 = "/usr/share/locale"

LANGUAGES = "ar_AE cs_CZ da_DK de_DE el_GR es_ES et_EE fi_FI fr_FR fy_FY hr_HR \
	hu_HU is_IS it_IT lt_LT nl_NL no_NO pl_PL pt_PT ro_RO ru_RU sk_SK sl_SI \
	sr_YU sv_SE tr_TR ur_IN zh_CN hk_HK"

RPROVIDES = "virtual-locale-ar virtual-locale-cs virtual-locale-da \
	virtual-locale-de virtual-locale-el virtual-locale-es virtual-locale-et \
	virtual-locale-fi virtual-locale-fr virtual-locale-fy virtual-locale-hr \
	virtual-locale-hu virtual-locale-is virtual-locale-it virtual-locale-lt \
	virtual-locale-nl virtual-locale-no virtual-locale-pl virtual-locale-pt \
	virtual-locale-ro virtual-locale-ru virtual-locale-sk virtual-locale-sl \
	virtual-locale-sr virtual-locale-sv virtual-locale-tr virtual-locale-ur \
        virtual-locale-zh virtual-locale-hk"

LOCALE_FILES = " LC_TIME LC_TELEPHONE LC_PAPER LC_NUMERIC LC_NAME LC_MONETARY LC_MESSAGES/SYS_LC_MESSAGES LC_MEASUREMENT \
	LC_IDENTIFICATION LC_CTYPE LC_COLLATE LC_ADDRESS"

do_install() {
	install -d ${D}${LOCALEDIR}/fake/LC_MESSAGES
	install -d ${D}${LOCALEDIR2}

	for x in ${LOCALE_FILES}; do
		install ${S}/$x ${D}${LOCALEDIR}/fake/$x
	done
	
	for lang in ${LANGUAGES}; do
		ln -s fake ${D}${LOCALEDIR}/${lang}
	done

	install ${WORKDIR}/locale.alias ${D}${LOCALEDIR2}
}

FILES_${PN} = "${LOCALEDIR} ${LOCALEDIR2}"
PACKAGE_ARCH = "all"
