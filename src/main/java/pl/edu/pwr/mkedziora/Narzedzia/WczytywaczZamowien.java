package pl.edu.pwr.mkedziora.Narzedzia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import pl.edu.pwr.mkedziora.Zamowienia.Zamowienie;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.json.JsonMapper;

public class WczytywaczZamowien {

    public static List<Zamowienie> wczytaj(Path katalog) {

        JsonMapper mapper = new JsonMapper();
        List<Path> pliki;
        List<Zamowienie> zamowienia = new ArrayList<>();

        try (Stream<Path> sciezki = Files.list(katalog))
        {
            pliki = sciezki.filter(p -> p.getFileName().toString().toLowerCase(Locale.ROOT).endsWith(".json")).toList();

            for (Path plik : pliki) {

                    String json = Files.readString(plik);
                    Zamowienie zamowienie = mapper.readValue(json, Zamowienie.class);
                    zamowienie.nadajNumer(GeneratorNumeru.generuj(zamowienie));
                    zamowienia.add(zamowienie);
                    System.out.println(plik.getFileName() + " -> " + zamowienie.numer());
            }
        }
        catch (IOException e)
        {
            throw new IllegalArgumentException(e);
        }

        return zamowienia;
    }
}
