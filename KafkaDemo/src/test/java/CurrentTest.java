import com.alibaba.fastjson.JSONObject;
import com.consumer.releaseorder.ReleaseOrderValueDTO;
import com.producer.labelling.ReceiveLabellingValueDTO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.*;

public class CurrentTest {

    ///private static
    public static void main(String[] args) throws InterruptedException {
        String a = "D:\\aaa.txt";
        String JSON = "";
        String nextString = "";
        try {
            InputStream stream = new FileInputStream(a);

            if (stream != null) {
                InputStreamReader streamReader = new InputStreamReader(stream, "GB2312");
                BufferedReader reader = new BufferedReader(streamReader);
                while ((nextString = reader.readLine()) != null)
                    JSON = new StringBuilder().append(JSON).append(nextString).toString();
            }
            System.out.println(JSON);
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }

}
