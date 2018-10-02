# BinToTxt
Programm converts strange symbols of binary file into 0 and 1 of txt file

All you need is to initialize constructor with filePaths of input and output files. (Input.bin, Output.txt)
```Java
    /**
     * @param fileIn  file to read
     * @param fileOut file to write
     */
    public BinToTxt(File fileIn, File fileOut) {
        super(fileIn, fileOut);
    }
```

As a result, you`ll have a file with 0 1 sequence.
