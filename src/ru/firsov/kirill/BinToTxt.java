package ru.firsov.kirill;

import java.io.File;

public class BinToTxt extends BaseBinToTxt{

    private StringBuffer aString;

    /**
     * @param fileIn  file to read
     * @param fileOut file to write
     */
    public BinToTxt(File fileIn, File fileOut) {
        super(fileIn, fileOut);
    }

    @Override
    protected void read() {
        super.read();
        aString = new StringBuffer(aByte.length);
        for (int i = 0; i < aByte.length; i++) {
            aString.append(String.format("%8s", Integer.toBinaryString(aByte[i] & 0xFF).replace(' ', '0')));
        }
    }

    void writeTxt() {
        super.writeTxt(aString);
    }
}
