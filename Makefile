# Define variables
SRC_DIR = woz
OUT_DIR = class_files
SRCS := $(wildcard $(SRC_DIR)/*.java)
CLASSES := $(patsubst $(SRC_DIR)/%.java,$(OUT_DIR)/%.class,$(SRCS))
JAVAC = javac
MKDIR_P = mkdir -p
MAIN_CLASS = woz.Game

# Default target to compile all .java files
all: $(OUT_DIR) $(CLASSES)

# Create the output directory if it doesn't exist
$(OUT_DIR):
	$(MKDIR_P) $(OUT_DIR)

# Compile .java files into .class files
$(OUT_DIR)/%.class: $(SRC_DIR)/%.java
	$(JAVAC) -d $(OUT_DIR) $<

# Run the Java program
run: all
	java -cp $(OUT_DIR) $(MAIN_CLASS)

# Clean target to remove compiled .class files
clean:
	rm -rf $(OUT_DIR)

.PHONY: all run clean
