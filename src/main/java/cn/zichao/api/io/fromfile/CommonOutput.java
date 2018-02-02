package cn.zichao.api.io.fromfile;

import cn.zichao.api.io.Output;
import cn.zichao.api.io.Receiver;
import cn.zichao.api.io.Sender;

import java.io.*;

public class CommonOutput implements Output<String,IOException> {
    private BufferedWriter output;
    private Receiver receiver;
    public CommonOutput(File file) throws IOException {
        //file.deleteOnExit();
        this.output = new BufferedWriter(new FileWriter(file));
        this.receiver = new CommonReceiver(output);
    }


    public Receiver receiver(){
        return this.receiver;
    }

    @Override
    public <SenderThrowableType extends Throwable>void receiveFrom(Sender<String,SenderThrowableType> sender) throws IOException, SenderThrowableType {
        sender.sendTo(receiver());
        output.close();
    }

    public static Output text(File file) throws IOException {

        return new CommonOutput(file);
    }
}
