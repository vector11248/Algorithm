import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class BYR {
    public static void main(String[] args) throws IOException {
        try {
            URL url = new URL("http://yzb.bupt.edu.cn/content/content.php?p=8_4_44");
            InputStream in = url.openStream();
            int temp;
            while ((temp=in.read())!=-1){
                System.out.print((char)temp);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
