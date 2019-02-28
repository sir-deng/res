package com.tencent.mm.f.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ad.k;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vp;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.List;

public final class fw extends com.tencent.mm.sdk.b.b {
    public a fwl;
    public b fwm;

    public static final class b {
        public List auX;
        public List fwA;
        public boolean fwB = false;
        public boolean fwC = false;
        public boolean fwD = false;
        public double fwE = 0.0d;
        public String fwx;
        public ve fwy;
        public e fwz;
        public String path;
        public int ret = -1;
        public String thumbUrl;
    }

    public static final class a {
        public Context context;
        public String desc;
        public k frW;
        public long frf;
        public vn frm;
        public uz fwn;
        public Intent fwo;
        public com.tencent.mm.sdk.e.j.a fwp;
        public Runnable fwq;
        public String fwr;
        public int fws = 0;
        public int fwt = 0;
        public String fwu;
        public String fwv;
        public vp fww;
        public ag handler;
        public String path;
        public String title;
        public String toUser;
        public int type = 0;
    }

    public fw() {
        this((byte) 0);
    }

    private fw(byte b) {
        this.fwl = new a();
        this.fwm = new b();
        this.xmE = false;
        this.frD = null;
    }
}
