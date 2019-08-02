package com.jnshu.utils;

import java.util.List;
import java.util.Map;

public interface Cache {
    public abstract void set(String s, Object obj, int i);

    public abstract Object get(String s);

    public abstract Map getMulti(List list);

    public abstract Object[] getMulti(String as[]);

    public abstract boolean exists(String s);

    public abstract void delete(String s);


}
