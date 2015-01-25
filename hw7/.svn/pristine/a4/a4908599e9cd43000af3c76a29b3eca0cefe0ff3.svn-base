JFLAGS = -g -Xlint:unchecked

%.class: %.java
	javac $(JFLAGS) $<

JAVA_SRCS = Inversions.java SortInts.java Sum.java

.PHONY: default style clean

default: $(JAVA_SRCS:.java=.class)

# Check style of source files with style61b.
style:
	style61b $(JAVA_SRCS)

clean:
	rm -f *.class *.o *~ csort
