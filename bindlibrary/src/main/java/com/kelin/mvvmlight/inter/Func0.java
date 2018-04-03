package com.kelin.mvvmlight.inter;

import java.util.concurrent.Callable;

/**
 * Created by zhuyuanshuju on 2018/3/26.
 */

public interface Func0<R> extends Function, Callable<R> {
    @Override
    R call();
}
