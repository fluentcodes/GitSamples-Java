package samples.time;

import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;

/**
 * based on code from Charles Ohene
 */
public class LocalDateTest {
    @Test
    public void testLocalDate() {
        //LocalDate via statische KonstruktorMethoden
        LocalDate gestern = LocalDate.of(2015, Month.JULY, 29);
        System.out.println("Gestern: " + gestern);
        LocalDate heute = LocalDate.now();
        LocalDate neujahr = LocalDate.parse("2015-01-01");
        //Abfragen
        heute.getDayOfMonth();
        heute.getMonth();
        heute.getYear();
        
        boolean b1 = heute.isAfter(neujahr);
        boolean b2 = neujahr.isBefore(heute);
        
        //Mutatoren (Dates sind per se immutable!)
        LocalDate zukunft = heute.plusDays(3).plusMonths(12);
        System.out.println("Zukunft: "+zukunft);
        
        //Berechnung
        LocalDate bDayOfJoe = LocalDate.of(2000, Month.JANUARY,1);
        System.out.println("Joes alter = "+getAlterInYears(bDayOfJoe));
        
    }
    public static int getAlterInYears(LocalDate bDay){
            return bDay.until(LocalDate.now()).getYears();
        }
}