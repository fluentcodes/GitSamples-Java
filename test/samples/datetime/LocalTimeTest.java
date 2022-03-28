package samples.datetime;

import java.time.*;
import org.junit.Test;

/**
 * based on code from Charles Ohene
 */
public class LocalTimeTest {
    LocalTime now = LocalTime.now();
    LocalTime midday = LocalTime.NOON;

    @Test
    public void testLocalDateTime() {
        // wieder immutable, OHNE öffentliche Konstruktoren und keine setter() sondern wit
        midday = LocalTime.of(12, 0, 0, 0);    //h, min, sec, nanos
        System.out.println("Mittag = " + midday);

        //mutate
        int hours = now.getHour();
        LocalTime back3Hours = now.withHour(hours - 3);
        LocalTime int12Hours = now.plusHours(12);
        System.out.println("Jetzt: " + now + "\t in12h: " + int12Hours);
    }

    @Test
    public void testDuration() {
        //Duration - Zeitliches Intervall (eher zahlbasierend: 15min oder 2h etc
        Duration eightSec = Duration.ofSeconds(8);
        Duration twoSec = Duration.ofSeconds(2);
        Duration achtKomma5Sec = eightSec.plusNanos(500);
        System.out.println("8+2sec = " + eightSec.plus(twoSec));
        Duration jetztBisMittag = Duration.between(now, midday);   //evtl. negativ
    }

    @Test
    public void testPeriod() {
        //Period - Zeitspanne aber datumsbasiert
        Period lebenszeit = Period.of(100, 12, 28);   //100 Jahre, 12 Monate, 28 Tage
        Period schwangerschaft = Period.ofMonths(9);
        LocalDate bDayOfJoe = LocalDate.of(2000, Month.JANUARY, 1);
        Period zeitSeitJoesGeburt = bDayOfJoe.until(LocalDate.now());
        System.out.println("Wie alt ist Joe nochmal? " + zeitSeitJoesGeburt.getYears());
        System.out.println("Wie viele Monate sind das genau? " + zeitSeitJoesGeburt.toTotalMonths());
    }

    /**
     * What the hell they don't use enum :-((!
     * Example from https://www.javatpoint.com/java-zoneid
     */
    @Test
    public void testZoneId() {
        ZoneId zoneIndia = ZoneId.of("Asia/Kolkata");
        ZoneId zoneFrance = ZoneId.of("Europe/Paris");
        ZoneId zoneBrasil = ZoneId.of("America/Sao_Paulo");
        ZoneId zoneAustralia = ZoneId.of("Australia/Sydney");
        ZoneId zoneJapan = ZoneId.of("Asia/Tokyo");

        LocalTime timeIndia = LocalTime.now(zoneIndia);
        LocalTime timeFrance = LocalTime.now(zoneFrance);
        LocalTime timeBrasil = LocalTime.now(zoneBrasil);
        LocalTime timeAustralia = LocalTime.now(zoneAustralia);
        LocalTime timeJapan = LocalTime.now(zoneJapan);

        System.out.println(timeIndia);
        System.out.println(timeFrance);
        System.out.println(timeBrasil);
        System.out.println(timeAustralia);
        System.out.println(timeJapan);
        System.out.println(timeIndia.isBefore(timeJapan));
    }

}
