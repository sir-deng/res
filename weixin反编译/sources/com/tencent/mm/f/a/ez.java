package com.tencent.mm.f.a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

public final class ez extends com.tencent.mm.sdk.b.b {
    public a fuM;
    public b fuN;

    public static final class a {
        public Context context;
        public String[] fnP;
        public int fuh = 0;
        public String[] selectionArgs;
        public Uri uri;
    }

    public static final class b {
        public Cursor fui;
    }

    public ez() {
        this((byte) 0);
    }

    private ez(byte b) {
        this.fuM = new a();
        this.fuN = new b();
        this.xmE = false;
        this.frD = null;
    }
}
