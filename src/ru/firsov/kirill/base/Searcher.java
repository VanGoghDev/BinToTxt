package ru.firsov.kirill.base;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Searcher extends BinToTxt{
    /**
     * @param fileIn  file to read
     * @param fileOut file to write
     */

    public Searcher(File fileIn, File fileOut) {
        super(fileIn, fileOut);
    }

    public void search(int key) throws IOException {
        try (DataInputStream input = new DataInputStream(new FileInputStream(this.fileIn))) {
            int counter = 0;
            while (input.available() > 0) {
                byte b = input.readByte();
                if (b == key) {
                    counter++;
                    System.out.println(b + " ");
                    System.out.println(counter + " values printed");
                    break;
                } else {
                    counter++;
                    System.out.println(b + " ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
