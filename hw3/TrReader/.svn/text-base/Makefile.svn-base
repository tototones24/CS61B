
# All Java sources.  If you add more files, be sure to add them here as
# well.
SRCS = TrReader.java Translate.java

CLASSES = $(SRCS:.java=.class)

JFLAGS = -g

.PHONY: default style clean

default: $(CLASSES)

style:
	style61b $(SRCS)

clean:
	$(RM) *.class *~

check:
	@echo No tests defined. Edit the Makefile and replace this message to add an automated test. See makefiles for previous assignments for examples.

$(CLASSES): $(SRCS)
	@echo "If you receive an error that TrReader is not abstract and ..., you should NOT make TrReader abstract. The problem is javacs other complaint."
	javac $(JFLAGS) $(SRCS)
