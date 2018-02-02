package cn.zichao.api.io;

public interface Receiver<T,ReceiverThrowableType extends Throwable> {

     void receive(T item)
            throws ReceiverThrowableType;
}
