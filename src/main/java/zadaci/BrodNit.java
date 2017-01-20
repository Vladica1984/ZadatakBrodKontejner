package zadaci;

import com.j256.ormlite.dao.Dao;
import model.Brod;

import java.util.Random;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class BrodNit extends Thread {

    private Brod brod;

    public BrodNit(Brod brod) {
        this.brod = brod;
    }

    public void run() {
        System.out.println("Brod " + brod.getNaziv() + " je napustio luku");
        Random random = new Random();
        do {
            try {
                synchronized (Luka.brojPristiglihBrodova) {
                    for (int i = 0; i < 2; i++) {
                        long vreme = Math.round(2500 + random.nextDouble() * 5000);
                        this.sleep(vreme);
                        Luka.brojPristiglihBrodova++;
                    }
                    System.out.println("Brod " + brod.getNaziv() + " je stigao na odrediste");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (Luka.brojPristiglihBrodova < 2);
    }
}

