JAVA_FILES = $(wildcard *.java)
CLASS_FILES = $(JAVA_FILES:.java=.class)

TARGETS = \
	${CLASS_FILES} \

# major targets

all: ${TARGETS}

clean:
	touch ${TARGETS}
	rm    ${TARGETS}

mrproper: clean
	touch d~
	rm    *~

# minor targets

%.class: %.java
	javac $<

