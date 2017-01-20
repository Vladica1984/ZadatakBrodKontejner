package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

/**
 * Created by androiddevelopment on 20.1.17..
 */
public class zadatak2DodavanjeVrednosti {
    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:brodKontejner.db");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

