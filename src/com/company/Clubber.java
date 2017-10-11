package com.company;

public class Clubber {
    public String clubberLovedMusic;

    public String clubbingNow(String clubMusic) {
        String danceStyle;

        if (this.clubberLovedMusic == clubMusic)
            danceStyle = clubMusic + " dancing";
        else danceStyle = "Vodka drinking";

        return danceStyle;
    }
}

