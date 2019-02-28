package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.pluginsdk.h.n;
import com.tencent.mm.protocal.c.sx;

public final class d extends com.tencent.mm.plugin.emoji.a.a.a {

    public class a extends a {
        public a(Context context, View view) {
            super(context, view);
        }

        protected final void aAU() {
            this.lyZ.setVisibility(8);
            this.lzb.setVisibility(8);
            this.lza.setVisibility(0);
            this.lzc.setVisibility(8);
            this.lzg.setVisibility(8);
            this.lzh.setVisibility(8);
            this.lyY.setVisibility(0);
            this.jOY.setVisibility(0);
            this.lze.setVisibility(0);
            this.lzd.setVisibility(0);
            this.lzd.setBackgroundDrawable(null);
            this.lzf.setVisibility(0);
        }

        protected final int[] aAV() {
            int aa = com.tencent.mm.bu.a.aa(this.mContext, R.f.bxg);
            return new int[]{aa, aa};
        }

        protected final int aAW() {
            return com.tencent.mm.bu.a.aa(this.mContext, R.f.bxh);
        }

        protected final boolean aBd() {
            return true;
        }
    }

    public d(Context context) {
        super(context);
    }

    protected final a c(Context context, View view) {
        a aVar = new a(context, view);
        aVar.a(this.lAn);
        return aVar;
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        a aVar = (a) view.getTag();
        f oY = oY(i);
        if (!(aVar == null || oY == null)) {
            oY.lAC = false;
            oY.lAD = false;
            sx sxVar = oY.lAy;
            if (sxVar != null) {
                aVar.setTitle(sxVar.whv);
                o.PG().a(sxVar.nlA, aVar.aAX(), com.tencent.mm.plugin.emoji.e.f.cn(sxVar.vPI, sxVar.nlA));
                aVar.yx(n.al("yyyy-MM-dd", ((long) sxVar.wid) * 1000));
            }
        }
        return view;
    }

    public final int aBl() {
        return 0;
    }

    public final void oV(int i) {
    }

    public final int aBm() {
        return 0;
    }

    public final void oW(int i) {
    }

    public final int aBn() {
        return 0;
    }

    public final void oX(int i) {
    }
}
