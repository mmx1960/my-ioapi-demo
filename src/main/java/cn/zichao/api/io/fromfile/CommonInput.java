package cn.zichao.api.io.fromfile;

import cn.zichao.api.io.Input;
import cn.zichao.api.io.Output;
import cn.zichao.api.io.Sender;

import java.io.*;


public class CommonInput implements Input<String,IOException> {
    private BufferedReader input;
    private Sender sender;

    Sender sender(){
        return this.sender;
    }

    public CommonInput(File file) throws IOException{
        this.input = new BufferedReader(new FileReader(file));
        this.sender = new CommonSender(input);
    }

    @Override
    public <ReceiverThrowableType extends Throwable> void transferTo(Output<String,ReceiverThrowableType> output) throws IOException, ReceiverThrowableType {
        output.receiveFrom(sender());
        input.close();
    }
    public static CommonInput text(File file) throws IOException {
        return new CommonInput(file);
    }
}
