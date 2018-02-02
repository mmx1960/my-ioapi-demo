package cn.zichao.api.io;

public interface Specification<T> {
    boolean test(T item);
}
