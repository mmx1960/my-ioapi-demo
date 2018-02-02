package cn.zichao.api.io;



public interface Output<T, ReceiverThrowableType extends Throwable> {
     <SenderThrowableType extends Throwable> void receiveFrom(Sender<T, SenderThrowableType> sender)
            throws ReceiverThrowableType, SenderThrowableType;


}
