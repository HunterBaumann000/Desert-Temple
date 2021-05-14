package edu.wctc.Game;

public class SystemOutput {

    public void out(String string){
        System.out.println(string);
    }

    public void battleOptionsMenu(){
        System.out.println("");
        System.out.println("What will you do?");
        System.out.println("1) Basic Attack");
        System.out.println("2) Power Attack (Recoil)");
        System.out.println("3) Run Away");

        System.out.print("Choice: ");
        System.out.println("");
    }

    public void chooseCharacterMenu(){
        System.out.println("What character type do you choose?");
        System.out.println("----------------------------------");
        System.out.println("1) Tank (High Health - Low Base Damage)");
        System.out.println("2) Assassin (Low Health - High Base Damage)");
        System.out.println("3) Knight (High Resistance)");
        System.out.println("4) Adventurer (Average Stats)");

        System.out.print("Choice: ");
        System.out.println("");
    }

    public void weaponMenu(){
        System.out.println("");
        System.out.println("Now for your weapon, play it safe or gamble?");
        System.out.println(" 1) Stick with basic weapon. ");
        System.out.println(" 2) Gamble for random weapon. ");

        System.out.print("Choice: ");
        System.out.println("");
    }

    public void desert(){
        System.out.println(
                "                              A\n" +
                        "                             /_\\\n" +
                        "                     :      /_|_\\\n" +
                        "                    :::    /|__|_\\\n" +
                        "                   ::.::  /|_|__|_\\      :\n" +
                        "                  ::.:.::/__|_|__|_\\    :.:\n" +
                        "                 :..:.:./_|__|__|__|\\  :.:.:\n" +
                        "                :.:..:./|__|___|__|__\\:.:..::\n" +
                        " ..............::..:../__|___|__|___|_\\..:..::................\n" +
                        "    ..........:..:..:/_|__|___|___|___|\\:..:..::::::::::::::::::::\n" +
                        "::::::::::::::.:..:./___|___|___|___|___\\....................\n" +
                        "        .........../..!...!...!...!...!..\\...............");
    }

    public void skull(){
        System.out.println("      ___                                 ___\n" +
                "   .-'   `-.                           .-'   `-.\n" +
                "  / /\\   /\\ \\                         / /\\   /\\ \\\n" +
                " . /__\\ /__\\ .                       . /__\\ /__\\ .\n" +
                " |___  ^  ___|                       |___  ^  ___|\n" +
                "     |   |                               |___|\n" +
                "     |[[[|            DEAD               |||||");
    }
}
