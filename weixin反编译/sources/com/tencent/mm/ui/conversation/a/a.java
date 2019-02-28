package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.ax.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class a extends b {
    int abP = 0;
    private View kvL = null;
    b zjr;
    private d zjs;
    a zjt;

    public interface a {
        void Pl(String str);

        void fU(String str, String str2);
    }

    public a(Context context) {
        super(context);
        if (this.view != null) {
            this.kvL = this.view.findViewById(R.h.bJA);
            this.zjs = new d();
            this.zjs.zjx = this.kvL;
            this.zjs.zjy = (Button) this.view.findViewById(R.h.bIZ);
            this.zjs.zjy.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (a.this.zjr != null && a.this.zjt != null) {
                        a.this.zjt.Pl(a.this.zjr.GN(a.this.abP).zjw.id);
                    }
                }
            });
            this.kvL.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (a.this.zjr != null && a.this.zjt != null) {
                        c GN = a.this.zjr.GN(a.this.abP);
                        a.this.zjt.fU(GN.zjw.id, GN.zjw.url);
                    }
                }
            });
        }
    }

    public final int getLayoutId() {
        return R.i.daj;
    }

    public final void destroy() {
        if (g.Do().CF()) {
            as.Hm();
            c.Db().b(this.zjr);
        }
    }

    public final void setVisibility(int i) {
        if (this.kvL != null) {
            this.kvL.setVisibility(i);
        }
    }

    public final void release() {
        this.zjr = null;
    }

    public final boolean alN() {
        this.zjr = new b((Context) this.vvl.get());
        this.zjt = new a() {
            public final void fU(String str, String str2) {
                com.tencent.mm.pluginsdk.j.a.a.cau();
                as.Hm();
                c.Fe().b(new o(2, str));
                x.d("MicroMsg.ADBanner", "jump to " + str2);
                com.tencent.mm.pluginsdk.q.a.vjg.a((Context) a.this.vvl.get(), str2, true);
            }

            public final void Pl(String str) {
                com.tencent.mm.pluginsdk.j.a.a.cau();
                as.Hm();
                c.Fe().b(new o(3, str));
            }
        };
        com.tencent.mm.pluginsdk.j.a.a en = com.tencent.mm.pluginsdk.j.a.a.en(ad.getContext());
        if (this.zjr != null) {
            if (en != null) {
                this.zjr.zjv = en;
                this.zjr.XH();
                int i = (this.zjr == null || this.zjr.getCount() <= 0 || this.zjr.GN(0).a(this.zjs) != 0) ? 0 : 1;
                if (i != 0) {
                    x.i("MicroMsg.ADBanner", "refreshAndReturnIsVisible[true]");
                    setVisibility(0);
                    return true;
                }
            }
            setVisibility(8);
        }
        setVisibility(8);
        return false;
    }
}
