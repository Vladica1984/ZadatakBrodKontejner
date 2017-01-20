package zadaci;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Brod;
import model.Kontejner;

import java.io.IOException;
import java.util.List;

import static zadaci.zadatak2DodavanjeVrednosti.brodDao;
import static zadaci.zadatak2DodavanjeVrednosti.kontejnerDao;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class zadatak3IzmenaVrednosti {
    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");

            brodDao = DaoManager.createDao(connectionSource, Brod.class);
            kontejnerDao = DaoManager.createDao(connectionSource, Kontejner.class);

            List<Kontejner> kontejner = kontejnerDao.queryForAll();
            for (Kontejner k: kontejner)
                System.out.println("Kontejner = " + k);

            List<Kontejner> pronadjenKontejner = kontejnerDao.queryForEq(Kontejner.POLJE_OPIS, "Morski plodovi");
            Kontejner kontejnerZaIzmenu = pronadjenKontejner.get(0);
            kontejnerZaIzmenu.setOpis("Plodovi mora");
            kontejnerDao.update(kontejnerZaIzmenu);

            kontejner = kontejnerDao.queryForAll();
            for (Kontejner k: kontejner)
                System.out.println("Kontejner = " + k);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connectionSource != null) {
                try {
                    connectionSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
