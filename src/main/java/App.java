import service.Human;
import service.Json;

/**
 * Created by Администратор on 14.09.15.
 */
public class App {
    public static void main(String[] args){



        Human human=new Human();
        Json json=new Json();

        StringBuilder string= new StringBuilder();
        string.append("Lena").append(";")
                .append("Smile").append(";")
                .append("Java").append(";")
                 .append("13.03.1988");


        json.fromJson(string.toString(),human);





    }

}
