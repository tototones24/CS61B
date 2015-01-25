#defines where all the source files are
SRCS := $(wildcard creatures/*.java) $(wildcard huglife/*.java)

#gives a default rule that happens to be called porcupines.
#if you call make with no commands, this rule will execute, since
#it's the first one in the file.
#
#The $(SRCS) part says that this rule should only run if every
#file listed under SRCS is available. Since we just generated
#the list of SRCS, this check is redundant and we could
#have had this line say only "porcupines:".
#
#The third line says what to do when this rule runs. In this case,
#we just use javac on all available source files. 
#
#Note that it is important that we run the compiler from the
#directory above creatures and huglife. If you were to go into
#the huglife directory and try to compile files from there,
#the compiler wouldn't know where to find creatures.
#
#If you're interested in making a Makefile for the creatures package,
#see the optional exercises of lab 5.
porcupine: $(SRCS)
	javac $(SRCS)

clean:
	$(RM) *.class creatures/*.class huglife/*.class