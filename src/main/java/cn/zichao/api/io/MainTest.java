package cn.zichao.api.io;

import cn.zichao.api.io.fromfile.CommonInput;
import cn.zichao.api.io.fromfile.CommonOutput;
import cn.zichao.api.io.fromfile.Counter;

import java.io.File;
import java.io.IOException;

public class MainTest {
    public static void main(String[] args) throws IOException {
        File input = new File("a.txt");
        File output =File.createTempFile( "test", ".txt" ,new File("E:"));
        try {
            CommonInput.text(input).transferTo(Transforms.filter(new Specification<String>() {
                @Override
                public boolean test(String item) {

                    return item.length() != 0;
                }
            }, CommonOutput.text(output)));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


        File input1 = new File("a.txt");
        File output1 =File.createTempFile( "test", ".txt",new File("E:") );
        Counter<String> counter = new Counter();
        try {
            CommonInput.text(input1).transferTo(Transforms.map(counter,CommonOutput.text(output1)));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println(counter.getCount());

    }
}
