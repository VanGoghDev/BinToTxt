package ru.firsov.kirill.base;

import java.io.File;

public class BinToTxt extends BaseBinToTxt{

    protected StringBuffer aString;

    private int inputTypeSize;

    public BinToTxt(File fileIn) {
        super(fileIn);
    }

    public BinToTxt(File fileIn, File fileOut) {
        super(fileIn, fileOut);
    }


    @Override
    public void read() {
        super.read();
        aString = new StringBuffer(aByte.length);
        for (int i = 0; i < aByte.length; i++) {
            aString.append(String.format("%8s", Integer.toBinaryString(aByte[i] & 0xFF).replace(' ', '0')));
        }
    }

    /**
     *
     * @param key   find value. Should be decimal!!!
     * @param type  Needs to count the number of bytes to step over (for each type it is different values
     *              for int it`s 32, for byte it`s 8 and so on)
     */
    public void search(int key, String type){
        ConvertBinary convertBinary = new ConvertBinary();
        convertBinary.convert(key);
        char[] binary = new char[convertBinary.binBuf.length()];
        int success = 0;
        int counter = 0;
        convertBinary.binBuf.getChars(0, convertBinary.binBuf.length(), binary, 0);
        if (type.equals("Byte")) {
            inputTypeSize = 8;
            for (int i = 0; i < aString.length() - inputTypeSize; i++) {
                for (int j = 0; j < inputTypeSize; j++) {
                    if (aString.charAt(i+j) == convertBinary.binBuf.charAt(j)) {
                        success += 1;
                    } else {
                        success = 0;
                        continue;
                    }
                    if (success == inputTypeSize) break;
                }
            }
            System.out.println("found");
        } else {
            System.out.println("Unknown data type");
        }
    }

    public StringBuffer getaString() {
        return aString;
    }

    public void setaString(StringBuffer aString) {
        this.aString = aString;
    }

    public void writeTxt() {
        super.writeTxt(aString);
    }
}
