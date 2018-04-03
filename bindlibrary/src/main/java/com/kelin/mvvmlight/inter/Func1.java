package com.kelin.mvvmlight.inter;

/**
 * Created by zhuyuanshuju on 2018/3/26.
 */

public interface Func1<T, R> extends Function {
    R call(T t);
}