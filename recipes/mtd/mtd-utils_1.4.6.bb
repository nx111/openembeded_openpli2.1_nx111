require mtd-utils.inc

PR_append = ".1"

DEPENDS += "util-linux-ng lzo2"


# At the moment, only needed for vuplus box
DEFAULT_PREFERENCE = "-1"


PARALLEL_MAKE = ""
ARM_INSTRUCTION_SET = "arm"

# This is the default package, thus we lock to a specific git version so 
# upstream changes will not break builds.

TAG = "v${PV}"

SRC_URI = "git://git.infradead.org/mtd-utils.git;protocol=git;tag=${TAG} \
	  "

S = "${WORKDIR}/git/"
