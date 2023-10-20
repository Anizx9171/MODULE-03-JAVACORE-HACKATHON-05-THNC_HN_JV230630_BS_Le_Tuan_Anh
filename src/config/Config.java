package config;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Config {
    public static DecimalFormat formatter = new DecimalFormat("###,###,###");
    public static Scanner scanner(){
        return new Scanner(System.in);
    }
}
