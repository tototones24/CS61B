# Makefile for Lab #1.

# This is a "makefile": a set of directions for performing various tasks 
# on a set of files. The make program (the GNU variant of the make program, 
# and called just 'make' on Linux and MacOS X systems) uses this file as
# its script.

#    make	      # Defaults to the first target: default



STYLE_FLAGS = -s lab1-suppress.xml

# Define $(SRCS) to be a list of Java files.
SRCS = HelloMany.java HelloConstants.java

MAIN_CLASSES = HelloMany.class

# The targets following .PHONY aren't actually files; they serve as commands.
.PHONY: compile default

# By default, compile all sources
default: compile

# To compile all source files, bring HelloMany.class and HelloConstants.class up to date.
compile: $(MAIN_CLASSES)

# HelloMany.class is up-to-date if it exists and is younger (was changed more
# recently than) all the files in $(SRCS).  If it isn't, use the 'javac' 
# command to build it.
$(MAIN_CLASSES): $(SRCS)
	javac -g $(SRCS)

