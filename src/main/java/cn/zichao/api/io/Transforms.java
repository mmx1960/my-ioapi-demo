package cn.zichao.api.io;

public class Transforms {
    public static <T, ReceiverThrowableType extends Throwable>
    Output<T, ReceiverThrowableType> filter(final Specification<T> specification, final Output<T, ReceiverThrowableType> output) {
        return new Output<T, ReceiverThrowableType>() {
            @Override
            public <SenderThrowableType extends Throwable> void receiveFrom(Sender<T, SenderThrowableType> sender) throws ReceiverThrowableType, SenderThrowableType {
                output.receiveFrom(new Sender<T, SenderThrowableType>() {
                    @Override
                    public <ReceiverThrowableType extends Throwable> void sendTo(Receiver<T, ReceiverThrowableType> receiver) throws ReceiverThrowableType, SenderThrowableType {
                        sender.sendTo(new Receiver<T, ReceiverThrowableType>() {
                            @Override
                            public void receive(T item) throws ReceiverThrowableType {
                                if (specification.test(item)){
                                    receiver.receive(item);
                                }
                            }
                        });
                    }
                });
            }
        };
    }

    public static <From,To,ReceiverThrowableType extends Throwable>
    Output<From, ReceiverThrowableType> map(final Function<From,To> function, final Output<To, ReceiverThrowableType> output){
        return new Output<From, ReceiverThrowableType>() {
            @Override
            public <SenderThrowableType extends Throwable> void receiveFrom(Sender<From, SenderThrowableType> sender) throws ReceiverThrowableType, SenderThrowableType {
                output.receiveFrom(new Sender<To, SenderThrowableType>() {
                    @Override
                    public <ReceiverThrowableType extends Throwable> void sendTo(Receiver<To, ReceiverThrowableType> receiver) throws ReceiverThrowableType, SenderThrowableType {
                        sender.sendTo(new Receiver<From, ReceiverThrowableType>() {
                            @Override
                            public void receive(From item) throws ReceiverThrowableType {
                                receiver.receive(function.map(item));
                            }
                        });
                    }
                });
            }
        };
    }
}
