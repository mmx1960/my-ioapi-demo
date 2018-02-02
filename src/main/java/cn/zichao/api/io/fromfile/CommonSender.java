package cn.zichao.api.io.fromfile;


import cn.zichao.api.io.Receiver;
import cn.zichao.api.io.Sender;

import java.io.BufferedReader;
import java.io.IOException;

public class CommonSender implements Sender<String, IOException> {
    BufferedReader sender;


     public CommonSender(BufferedReader sender) {
        this.sender = sender;

    }

    @Override
    public<ReceiverThrowableType extends Throwable> void sendTo(Receiver<String,ReceiverThrowableType > receiver) throws IOException, ReceiverThrowableType {
         String line;
         while ((line = sender.readLine())!= null){
             receiver.receive(line);
         }
    }
}
