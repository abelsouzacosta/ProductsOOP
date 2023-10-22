import UI.UI;
import domain.exceptions.ArrayListFullException;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) {
        try {
            UI.bootstrap();
        } catch (ArrayListFullException e) {
            throw new RuntimeException(e.getMessage());
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
