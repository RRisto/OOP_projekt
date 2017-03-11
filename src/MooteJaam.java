
public class MooteJaam {
    private String nimi;
    private String kood="";
    private String temperatuur="";

    public MooteJaam(String nimi, String kood, String temperatuur) {
        this.nimi = nimi;
        this.kood = kood;
        this.temperatuur = temperatuur;
    }

    @Override
    public String toString() {
        return "jaam: " + nimi + ", kood: " + kood +
                ", temperatuur: ";
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public void setKood(String kood) {
        this.kood = kood;
    }

    public void setTemperatuur(String temperatuur) {
        this.temperatuur = temperatuur;
    }

    public String getNimi() {

        return nimi;
    }

    public String getKood() {
        return kood;
    }

    public String getTemperatuur() {
        return temperatuur;
    }
}
