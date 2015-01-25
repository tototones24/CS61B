#Makefile for the ECHashStrinsSet.java
.PHONY: default check clean style

STYLEPROG = style61b

JFLAGS = -g -Xlint:unchecked

# All .java files in this directory.
SRCS := $(wildcard *.java)

# As a convenience, you can compile a single Java file X.java in this directory
# with 'make X.class'
%.class: %.java
	javac $(JFLAGS) -cp ..:$(CLASSPATH) $<

# First, and therefore default, target.
default: sentinel

style: default
	$(STYLEPROG) $(SRCS) 

check:
	$(MAKE) -C .. check

# 'make clean' will clean up stuff you can reconstruct.
clean:
	$(RM) *~ *.class sentinel

### DEPENDENCIES ###

sentinel: $(SRCS)
	javac $(JFLAGS) -cp ..:$(CLASSPATH) $(SRCS)
	touch sentinel
