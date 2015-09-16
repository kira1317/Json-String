import service.Human;
import service.Json;

import java.io.IOException;
import java.util.Calendar;

/**
 * Created by Администратор on 14.09.15.
 */
public class App {
    public static void main(String[] args) throws IOException {

        Calendar calendar=Calendar.getInstance();
        calendar.set(1988, 3, 13);

        Human human=new Human("Lena","Smile","Java",calendar);

        Json json=new Json();
        try {
            json.toJson(human.toString(), human);
        } catch (IOException e) {
            e.printStackTrace();
        }

        json.fromJson(human);

    }

}
