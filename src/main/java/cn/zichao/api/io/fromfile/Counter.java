package cn.zichao.api.io.fromfile;

import cn.zichao.api.io.Function;

public class Counter<T> implements Function<T,T> {
    private int count;
    @Override
    public T map(T o) {
        count++;
        return o;
    }

    public int getCount(){
        return this.count;
    }
}
