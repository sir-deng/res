package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.sdk.platformtools.bi;

public class f extends com.tencent.mm.plugin.emoji.a.a.a {
    private final String TAG = "MicroMsg.emoji.EmojiStoreMainAdapter";
    public boolean lzG = false;
    public boolean lzH = true;
    public boolean lzI = false;
    public boolean lzJ = true;

    public class a extends a {
        public a(Context context, View view) {
            super(context, view);
        }

        protected final void aAU() {
            this.lyZ.setVisibility(8);
            aAZ();
            this.lzc.setVisibility(8);
            this.lzg.setVisibility(8);
            this.lzh.setVisibility(8);
            this.lyY.setVisibility(0);
            this.jOY.setVisibility(0);
            this.lze.setVisibility(0);
            this.lzd.setVisibility(0);
            this.lzf.setVisibility(0);
        }

        protected final int[] aAV() {
            int aa = com.tencent.mm.bu.a.aa(this.mContext, R.f.bxe);
            return new int[]{aa, aa};
        }

        protected final int aAW() {
            return com.tencent.mm.bu.a.aa(this.mContext, R.f.bxd);
        }

        protected final boolean aBd() {
            return f.this.lzH;
        }
    }

    public f(Context context) {
        super(context);
    }

    protected final a c(Context context, View view) {
        a aVar = new a(context, view);
        aVar.a(this.lAn);
        return aVar;
    }

    public final void clear() {
        super.clear();
    }

    public View b(int i, View view, ViewGroup viewGroup) {
        boolean z = true;
        a aVar = (a) view.getTag();
        com.tencent.mm.plugin.emoji.a.a.f oY = oY(i);
        if (this.lzI) {
            oY.lAE = true;
            oY.lAC = false;
            oY.lAD = false;
        }
        if (!(aVar == null || oY == null)) {
            oY.lAD = this.lzJ;
            so soVar = oY.lAz;
            if (soVar == null) {
                aVar.oU(0);
                z = false;
            } else {
                aVar.setTitle(soVar.fpg);
                aVar.yy(soVar.nkL);
                if (!bi.oN(soVar.nlA)) {
                    o.PG().a(soVar.nlA, aVar.aAX(), com.tencent.mm.plugin.emoji.e.f.cn("", soVar.nlA));
                }
                if (bi.oN(soVar.whp)) {
                    aVar.oS(8);
                } else {
                    o.PG().a(soVar.whp, aVar.aAY(), com.tencent.mm.plugin.emoji.e.f.cn("", soVar.whp));
                    aVar.oS(0);
                }
                aVar.oU(8);
            }
            if (!z) {
                sx sxVar = oY.lAy;
                if (sxVar != null) {
                    aVar.setTitle(sxVar.whv);
                    if (com.tencent.mm.plugin.emoji.h.a.d(sxVar)) {
                        o.PG().a("", aVar.aAX());
                        aVar.oR(R.g.bCZ);
                    } else {
                        o.PG().a(sxVar.nlA, aVar.aAX(), com.tencent.mm.plugin.emoji.e.f.cn(sxVar.vPI, sxVar.nlA));
                    }
                    boolean cs = e.cs(sxVar.whz, 2);
                    if (!TextUtils.isEmpty(sxVar.wig)) {
                        aVar.aAY().setImageDrawable(null);
                        aVar.aAY().setVisibility(0);
                        o.PG().a(sxVar.wig, aVar.aAY(), com.tencent.mm.plugin.emoji.e.f.cn("", sxVar.wig));
                    } else if (cs) {
                        aVar.oS(0);
                        aVar.oT(R.g.bBZ);
                    } else {
                        aVar.oS(8);
                    }
                    aVar.yy(sxVar.wif);
                    if (this.lzG && aVar.lyX != null) {
                        aVar.lyX.setBackgroundResource(R.g.bBz);
                    }
                }
            }
        }
        return view;
    }

    public int aBl() {
        return 0;
    }

    public void oV(int i) {
    }

    public int aBm() {
        return 0;
    }

    public void oW(int i) {
    }

    public int aBn() {
        return 0;
    }

    public void oX(int i) {
    }
}
