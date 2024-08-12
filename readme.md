# CodeMerger

CodeMerger is a simple Java tool designed to merge all source code files with a specific extension (e.g., `.java`) from a specified directory into a single `.txt` file. This can be useful for consolidating code for easy review, sharing, documentation or sending to AI.

## Features

- Merges all files of a given extension from a directory and its subdirectories.
- Writes the combined content into a single `.txt` file.
- Adds comments indicating the original file paths to track where each piece of code came from.

## Requirements

- Java

## How to Use

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/CodeMerger.git
   cd CodeMerger
   
2. **Set your directory and extension on source code**
    ```bash
    String directory = "source_code_directory";  // Set your directory path
    String targetExtension = ".java";  // Set your file extension (e.g., .java)

3. **Compile the Java Code**
    ```bash
   javac MergeCodeFiles.java

4. **Run it**
    ```bash
   java MergeCodeFiles

5. **The merged code will be on the desktop**
