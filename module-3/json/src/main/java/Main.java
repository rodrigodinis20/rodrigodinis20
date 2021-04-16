import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();


        Ipinfo info2 = mapper.readValue(new URL("http://ipinfo.io/json"), Ipinfo.class);

        System.out.println(info2);







    }
}
