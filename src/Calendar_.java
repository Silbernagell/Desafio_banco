import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;

public class Calendar_ {
    
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();

        DateFormat dtHora = DateFormat.getDateTimeInstance();
        System.out.println("Data hora: " + dtHora.format(data)); 
    }
}
