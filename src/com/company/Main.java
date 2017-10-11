package com.company;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String args[]) {
        int minNumClubbers = 10; // минимальное кол-во персонажей в клубе;
        int maxNumClubbers = 100; // максимальное кол-во персонажей в клубе;

        /* получаем произвольное кол-во персонажей из интервала [minNumClubbers;maxNumClubbers] */
        Random random = new Random();
        int numberClubbers = minNumClubbers + random.nextInt(maxNumClubbers - minNumClubbers + 1);

        /* меняем музыку в клубе каждые 5 секунд */
        Timer timer = new Timer();
        timer.schedule(new PlayClubMusic(numberClubbers), 0, 5000);
    }
}

class PlayClubMusic extends TimerTask {
    public static int numDancing;

    public PlayClubMusic(int numDancing) {
        this.numDancing = numDancing;
    }

    public void run() {
        Random random = new Random();

        /* задаем жанры музыки в клубе с помощью массива строк */
        String[] arrMusic = {"RnB", "Electrohouse", "Pop-music"};

        Clubber clubber[] = new Clubber[numDancing];
        for (int i = 0; i < numDancing; i++) {
            clubber[i] = new Clubber();
            /* генерируем любимую музыку для каждого из персонажей */
            clubber[i].clubberLovedMusic = arrMusic[random.nextInt(arrMusic.length)];
        }

        /* генерируем музыку, играющую в данные 5 секунд в клубе */
        String clubMusicNow = arrMusic[random.nextInt(arrMusic.length)];

        for (int j = 0; j < numDancing; j++)
            System.out.println(clubber[j].clubbingNow(clubMusicNow));

        /* разделим 5-секундные сеты для более удобного просмотра выходных данных с консоли*/
        System.out.println("\nEnd of 5-second set\n");
    }
}
