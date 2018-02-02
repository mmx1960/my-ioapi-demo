package cn.zichao.api.io.fromfile;


import cn.zichao.api.io.Receiver;

import java.io.BufferedWriter;

public class CommonReceiver implements Receiver {
    BufferedWriter receive;

    public CommonReceiver(BufferedWriter receive){
        this.receive = receive;
    }

    @Override
    public void receive(Object item) throws Throwable {
        receive.append((String)item).append("\r\n");
    }
}
