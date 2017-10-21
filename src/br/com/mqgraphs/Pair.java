package br.com.mqgraphs;

public class Pair {

    int key;

    int value;

    public Pair(int k, int v) {
        key = k;
        value = v;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key + "[" + value + "] ";
    }
}
