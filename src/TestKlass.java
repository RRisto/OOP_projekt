import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class TestKlass {
    public static void main(String[] args) throws Exception {
        //http://everythingwithjava.blogspot.com.ee/2015/07/how-to-start-web-scraping-with-java.html
        org.jsoup.nodes.Document doc;
        String kohad = "";
        String tempMin="";

        try {
            doc = Jsoup.connect("http://www.ilmateenistus.ee/ilma_andmed/xml/forecast.php").get();
            kohad = doc.select("forecast>night>place>name").text();
            tempMin=doc.select("forecast>night>place>tempmin").text();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Kohad on " +kohad);
        System.out.println("Temp on "+tempMin);
        //System.out.println(kohad.length());

        ArrayList<Koht> kohaList=new ArrayList<>();
        String[] kohadTükid=kohad.split(" ");
        String[] tempMinTükid=tempMin.split(" ");
        System.out.println(kohadTükid.length);

        for (int i=0; i<kohadTükid.length;i++) {
            kohaList.add(new Koht(kohadTükid[i], Integer.parseInt(tempMinTükid[i])));
        }
        System.out.println(kohaList.toString());

        //vaatlusandmed
        ArrayList<MooteJaam> jaamad=new ArrayList<>();
        try {
            doc = Jsoup.connect("http://www.ilmateenistus.ee/ilma_andmed/xml/observations.php").get();


            System.out.println("olen siin");
            Elements mooteJaamad = doc.select("station");
            for (Element jaam : mooteJaamad) {
                System.out.println(jaam.select("name").text());
                System.out.println("kood: "+jaam.select("wmocode").text());
                System.out.println("temperatuur: "+jaam.select("airtemperature").text());

                jaamad.add(new MooteJaam(jaam.select("name").text(),jaam.select("wmocode").text(),
                        jaam.select("airtemperature").text()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(jaamad.toString());
    }
}

