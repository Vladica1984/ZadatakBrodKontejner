package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Brod;

import java.io.IOException;
import java.util.List;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class Luka {

    public static Integer brojPristiglihBrodova = 0;

    static Dao<Brod, Integer> brodDao;

    public Luka(Integer brojPristiglihBrodova) {
        this.brojPristiglihBrodova = brojPristiglihBrodova;
    }

    public static void main(String[] args) {

        ConnectionSource connectionSource = null;
        try {

            connectionSource = new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");

            brodDao = DaoManager.createDao(connectionSource, Brod.class);

            List<Brod> sviBrodovi = brodDao.queryForAll();

            BrodNit b1 = new BrodNit(sviBrodovi.get(0));
            BrodNit b2 = new BrodNit(sviBrodovi.get(1));

            b1.start();
            b2.start();

            b1.join();
            b2.join();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connectionSource != null) {
                try {
                    //Zatvaranje konekcije sa bazom
                    connectionSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
