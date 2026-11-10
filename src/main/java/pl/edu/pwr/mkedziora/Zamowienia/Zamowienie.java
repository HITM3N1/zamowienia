package pl.edu.pwr.mkedziora.Zamowienia;

import java.util.List;

public class Zamowienie {
    private Zamawiajacy zamawiajacy;
    private List<Produkt> produkty;
    private String numer; // Nadawany przez program, nie wczytywany z JSON.

    public Zamowienie() {
    }

    public Zamawiajacy getZamawiajacy() {
        return zamawiajacy;
    }

    public void setZamawiajacy(Zamawiajacy zamawiajacy) {
        this.zamawiajacy = zamawiajacy;
    }

    public List<Produkt> getProdukty() {
        return produkty;
    }

    public void setProdukty(List<Produkt> produkty) {
        this.produkty = produkty;
    }

    public String numer() {
        return numer;
    }

    public void nadajNumer(String numer) {
        this.numer = numer;
    }
}
