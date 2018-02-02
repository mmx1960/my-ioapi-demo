package cn.zichao.api.io;

public interface Function<From, To>
{
    To map(From from);
}