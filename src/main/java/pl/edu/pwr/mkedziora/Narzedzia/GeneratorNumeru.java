package pl.edu.pwr.mkedziora.Narzedzia;


import pl.edu.pwr.mkedziora.Zamowienia.Produkt;
import pl.edu.pwr.mkedziora.Zamowienia.Zamawiajacy;
import pl.edu.pwr.mkedziora.Zamowienia.Zamowienie;

import java.util.Objects;

public class GeneratorNumeru {

    public static String generuj(Zamowienie zamowienie) {
        Zamawiajacy klient = zamowienie.getZamawiajacy();

        int numer = Objects.hash(
                klient.getImie(),
                klient.getNazwisko(),
                klient.getEmail(),
                klient.getTelefon()
        );

        for (Produkt produkt : zamowienie.getProdukty()) {
            numer = Objects.hash(
                    numer,
                    produkt.getKod(),
                    produkt.getIlosc(),
                    produkt.getJednostkaMiary()
            );
        }

        return "ZAM-" + Integer.toUnsignedString(numer);
    }

}
