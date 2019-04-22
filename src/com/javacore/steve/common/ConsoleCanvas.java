package com.javacore.steve.common;

public class ConsoleCanvas extends Canvas {

    private char[][] pixels;
    private int width;
    private int heigth;

    public ConsoleCanvas(int width, int height) {
        this.width = width;
        this.heigth = height;
        init();
    }

    public void init() {
        pixels = new char[heigth][width];
        reset();
    }

    public void reset() {
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                pixels[i][j] = '.';
            }
        }
    }

    public void draw() {
        for (int i = 0; i < heigth; i++) {
            System.out.println("\n");
            for (int j = 0; j < heigth; j++) {
                System.out.print(pixels[i][j]);
            }
        }
    }

    public void setSymbolAt(int x, int y, char symbol) {
        pixels[x][y-1] = symbol;
    }

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

    public void drawSquareAt(int x, int y, int size) {
        reset();
        int ar_x = x;
        int ar_y = y;
        for (int i = 0; i < size; i++) {
            if ((i + 1) % (size - 1) == 1) {
                for (int j = 0; j < size; j++) {
                    pixels[ar_x][ar_y] = '#';
                    ar_y++;
                }
                ar_y = y;
            } else {
                pixels[ar_x][ar_y] = '#';
                ar_y++;
                for (int j = 1; j < size-1; j++) {
                    pixels[ar_x][ar_y] = '.';
                    ar_y++;
                }
                pixels[ar_x][ar_y] = '#';
                ar_y = y;
            }
            ar_x++;
        }
    }

    public void drawCircleAt(int x, int y, int radius) {
        reset();

        for (int i = x - radius; i < x + radius; i++) {
            for (int j = y - radius; j < y + radius; j++) {
                if (Math.pow(i-x,2) + Math.pow(j-y,2) < radius*radius) setSymbolAt(i,j,'#');
            }
        }

//        int arr_x_down = x;
//        int arr_y_down = y;
//        int arr_x_up = x;
//        int arr_y_up = y;
//        int first = 0;
//        int last = radius;
//        for (int i = 0; i <= radius/2; i++) {
//            for (int j = first; j < last; j++) {
//                pixels[arr_x_down][arr_y_down] = '#';
//                arr_y_down++;
//            }
//            for (int j = first; j < last; j++) {
//                pixels[arr_x_up][arr_y_up] = '#';
//                arr_y_up++;
//            }
//            arr_y_down = y + i + 1;
//            arr_y_up = y + i + 1;
//            first++;
//            last--;
//            arr_x_down++;
//            arr_x_up--;
//        }
    }

    public void drawStringAt() {

    }

}
