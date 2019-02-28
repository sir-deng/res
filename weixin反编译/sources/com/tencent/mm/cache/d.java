package com.tencent.mm.cache;

import android.graphics.Canvas;

public interface d<T> extends Cloneable {
    void a(Canvas canvas, boolean z);

    void add(T t);

    void ba(boolean z);

    int bb(boolean z);

    void c(Canvas canvas);

    void onCreate();

    void onDestroy();

    T pop();

    void uQ();

    void xC();
}
