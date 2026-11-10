package pl.edu.pwr.mkedziora.Narzedzia;

import java.net.URL;
import java.nio.file.Path;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import io.github.cdimascio.dotenv.Dotenv;

public class Ustawienia {

    public static Path getKatalogZamowien() {

        private static final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        String sciezka = dotenv.get("ZAMOWIENIA_DIR");
        URL zasob;
        if (sciezka == null || sciezka.isBlank()) {
            zasob = Ustawienia.class.getClassLoader().getResource("appsettings.properties");
        }

         konfiguracja.getString("zamowienia.folder");


        URL zasob =

        Parameters parametry = new Parameters();
        FileBasedConfigurationBuilder<PropertiesConfiguration> builder = new FileBasedConfigurationBuilder<>(PropertiesConfiguration.class).configure(parametry.properties().setURL(zasob).setEncoding("UTF-8"));

        try {
            PropertiesConfiguration konfiguracja = builder.getConfiguration();
            String sciezka = konfiguracja.getString("katalog");
            Path katalogZamowien = Path.of(sciezka).toAbsolutePath().normalize();

            return katalogZamowien;
        }
        catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}
