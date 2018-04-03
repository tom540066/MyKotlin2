package com.kelin.mvvmlight.inter;

/**
 * Created by zhuyuanshuju on 2018/3/26.
 */

public interface Action1<T> extends Function {
    void call(T t);
}
