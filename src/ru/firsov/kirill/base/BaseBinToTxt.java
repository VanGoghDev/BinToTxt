package ru.firsov.kirill.base;

import java.io.*;

public class BaseBinToTxt {

    private File fileIn;
    private File fileOut;

    byte[] aByte; //an array where data from file stored

    /**
     * @param fileIn file to read
     * @param fileOut file to write
     */
    public BaseBinToTxt(File fileIn, File fileOut) {
        this.fileIn = fileIn;
        this.fileOut = fileOut;
    }

    protected void read() {
        try (DataInputStream input = new DataInputStream(new FileInputStream(this.fileIn))) {

            int count = input.available();  //number of symbols in a file
            this.aByte = new byte[count];

            while (input.available() > 0) {
                input.read(aByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void writeTxt(StringBuffer aStr) {
        try (BufferedWriter bwr = new BufferedWriter(new FileWriter(fileOut))) {
            bwr.write(aStr.toString());
            bwr.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
