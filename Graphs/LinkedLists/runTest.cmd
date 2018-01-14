@echo off
echo "Compiling code base..."
FOR %%I IN (*.java) DO (
	javac %%I

	if %ErrorLevel% EQU 2 (
		echo "Found error when compiling file: "%%I
	)
)

echo "Running Test now..."

java TestingLinkedLists