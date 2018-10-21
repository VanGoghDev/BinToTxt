package ru.firsov.kirill.base;

public class ConvertBinary {

    /**
     * binBuf is a StringBuffer which contains a value of binary representation of decimal value
     */
    StringBuffer binBuf = new StringBuffer();

    public void convert(int number) {
        int remainder;

        if (number <= 1) {
            System.out.print(number);
            binBuf.append(Integer.toString(number));
            return; // KICK OUT OF THE RECURSION
        }

        remainder = number % 2;
        convert(number >> 1);
        System.out.println(remainder);
        binBuf.append(Integer.toString(remainder));
    }
}
