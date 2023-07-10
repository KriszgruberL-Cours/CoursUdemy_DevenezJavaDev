package com.espacex.exoBase;

public class BureauDeChange {
    public static void main(String[] args) {
        int euro;
        float dollars;
        float results = convert(1500);
        System.out.print(results);
    }

    public static float convert(int toConvert) {
        return toConvert * 1.22f;
    }
}
