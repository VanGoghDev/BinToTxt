package ru.firsov.kirill;

import ru.firsov.kirill.base.BinToTxt;

import java.io.File;

/**
 * ^ @project BinaryToTxt
 *
 * @author Kirill Firsov on 02.10.2018.
 */

public class Main {

    public static void main(String[] args) {

        //Some file paths
        File fileIn = new File("C:/Users/User/IdeaProjects/Parser/001.bin");
        File fileOut = new File("C:/Users/User/IdeaProjects/Parser/003.txt");

        BinToTxt binToTxt = new BinToTxt(fileIn, fileOut);
        binToTxt.read();
        binToTxt.writeTxt();
    }
}
