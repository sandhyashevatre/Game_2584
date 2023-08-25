package com.learning.hello.game;


public class Tile {
    private int value;

    public Tile() {
        value = 0; //default 
    }

    public Tile(int number) {
        value = number;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        if (value == 0) {
            return "   "; // Replace with any appropriate character for an empty cell
        } else {
            return String.format("%3d", value);
        }
    }
}