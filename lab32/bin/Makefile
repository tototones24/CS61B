# Makefile for Lab #2

#    make	      # Defaults to the first target: default
#    make default    # Same as make
#    make compile    # Same as make 
#    make check   # Compile if needed and run tests of DoubleChain
                  # and ExponentialWindow classes.
#    make clean      # Remove extraneous or rebuildable files
#    make style   # checks your style

# Define $(SRCS) to be a list of Java files.
SRCS = ExponentialWindow.java DoubleChain.java TestDoubleChain.java TestExponentialWindow.java

MAIN_CLASSES = TestExponentialWindow.class TestDoubleChain.class

# Compiler flags for Java compilation

JFLAGS = -g

# The targets following .PHONY aren't actually files; they serve as commands.
.PHONY: compile default check clean check-dchain check-ewindow

# By default, compile all sources
default: compile

compile: $(MAIN_CLASSES)

style:
	style61b $(SRCS)

check: check-dchain check-ewindow

check-dchain: DoubleChain.class TestDoubleChain.class 
	java TestDoubleChain

check-ewindow: ExponentialWindow.class TestExponentialWindow.class
	java TestExponentialWindow

# Remove extraneous or reconstructable files.
clean:
	rm -f *.class 

$(MAIN_CLASSES): $(SRCS)
	javac $(JFLAGS) $(SRCS)
