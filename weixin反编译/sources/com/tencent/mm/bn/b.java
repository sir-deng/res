package com.tencent.mm.bn;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.Editable;
import android.view.MotionEvent;
import com.tencent.mm.api.e;
import com.tencent.mm.api.i;
import com.tencent.mm.api.j;
import com.tencent.mm.api.l;
import com.tencent.mm.api.m;
import com.tencent.mm.cache.d;
import com.tencent.mm.d.a;

public interface b {
    boolean H(MotionEvent motionEvent);

    d a(a aVar);

    void a(Editable editable, int i);

    void a(e eVar);

    void a(j jVar, boolean z);

    void a(m.a aVar);

    void a(com.tencent.mm.view.a aVar);

    void aC(boolean z);

    <T extends com.tencent.mm.d.b> T b(com.tencent.mm.api.d dVar);

    void c(i iVar);

    com.tencent.mm.api.d[] cdR();

    l cdS();

    void cdT();

    com.tencent.mm.view.a cdU();

    m.a cdV();

    <T extends com.tencent.mm.d.b> T cdW();

    float cdX();

    float cdY();

    Bitmap cdZ();

    boolean cea();

    Context getContext();

    void onAttachedToWindow();

    void onDestroy();

    void onDraw(Canvas canvas);

    void onFinish();

    boolean sT();

    void sX();
}
