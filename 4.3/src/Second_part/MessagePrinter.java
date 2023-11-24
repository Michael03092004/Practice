package Second_part;

import java.io.IOException;

public class MessagePrinter {
    public void print(String msg, Printable p) {
        try{
            p.print(msg);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
