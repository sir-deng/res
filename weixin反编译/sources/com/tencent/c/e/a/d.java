package com.tencent.c.e.a;

import android.content.Context;
import com.tencent.c.e.a.a.f;

public final class d {
    int AcO;
    long AcP;
    int action;
    Context context;
    int requestType;
    long xos;

    public static final class a {
        int AcO;
        public long AcP;
        int action;
        Context context;
        int requestType;
        long xos;

        public /* synthetic */ a(Context context, int i, int i2, byte b) {
            this(context, i, i2);
        }

        private a(Context context, int i, int i2) {
            this.requestType = 0;
            this.AcO = 0;
            this.action = 0;
            this.AcP = f.Adh * 12;
            this.xos = 0;
            if (i < 0) {
                throw new IllegalArgumentException("scenes invalid: " + i);
            }
            this.context = context.getApplicationContext();
            this.AcO = i;
            this.action = i2;
        }
    }

    public /* synthetic */ d(a aVar, byte b) {
        this(aVar);
    }

    private d(a aVar) {
        this.requestType = aVar.requestType;
        this.AcO = aVar.AcO;
        this.action = aVar.action;
        this.AcP = aVar.AcP;
        this.xos = aVar.xos;
        this.context = aVar.context;
    }
}
