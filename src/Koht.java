
public class Koht {
    private String nimi;
    private int tempMin;

    public Koht(String nimi, int tempMin) {
        this.nimi = nimi;
        this.tempMin = tempMin;
    }

    @Override
    public String toString() {
        return "\nKoht: " + nimi + ", tempmin: " + tempMin;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public String getNimi() {

        return nimi;
    }

    public int getTempMin() {
        return tempMin;
    }
}

