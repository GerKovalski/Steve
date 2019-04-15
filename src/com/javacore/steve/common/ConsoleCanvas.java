package com.javacore.steve.common;

public class ConsoleCanvas extends Canvas {
    @Override
    public void drawText(String text) {
        System.out.println(text);
    }

    @Override
    public void drawSquare(int size) {
        if (size < 3) {
            System.out.println("Wrong size");
            return;
        }

        for (int i = 0; i < size; i++) {
            if ((i + 1) % (size - 1) == 1) {
                for (int j = 0; j < size; j++) {
                    System.out.print("#");
                }
                System.out.println();
            } else {

                System.out.print("#");
                for (int j = 1; j < size-1; j++) {
                    System.out.print(" ");
                }
                System.out.println("#");
            }
        }
    }

}
