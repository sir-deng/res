package com.tencent.mm.plugin.emoji.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.ct;
import com.tencent.mm.plugin.emoji.a.a.d;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends com.tencent.mm.plugin.emoji.a.a.a {
    private final String TAG = "MicroMsg.emoji.EmojiMineAdapter";
    private ProgressDialog lzx;

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

        protected final boolean a(com.tencent.mm.plugin.emoji.model.h.a aVar, View view) {
            aBb();
            return super.a(aVar, view);
        }

        protected final void b(com.tencent.mm.plugin.emoji.model.h.a aVar, View view) {
            super.b(aVar, view);
            if (com.tencent.mm.plugin.emoji.h.a.zu(aBa())) {
                b ctVar = new ct();
                ctVar.frP.frQ = aBa();
                ctVar.frP.status = com.tencent.mm.plugin.emoji.h.a.aDF() ? 7 : 3;
                ctVar.frP.progress = getProgress();
                ctVar.frP.frR = this.lyW.lAB;
                com.tencent.mm.sdk.b.a.xmy.m(ctVar);
            }
        }

        protected final int[] aAV() {
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.bur);
            return new int[]{dimensionPixelSize, dimensionPixelSize};
        }

        protected final int aAW() {
            return -1;
        }

        protected final boolean aBd() {
            return true;
        }

        public final void aBg() {
            if (this.lyW != null) {
                switch (aBb()) {
                    case 0:
                    case 3:
                        this.lzc.setVisibility(8);
                        this.lzd.setBackgroundResource(R.g.bAc);
                        this.lzd.setVisibility(0);
                        this.lzf.setVisibility(0);
                        this.lzf.setText(R.l.eaF);
                        this.lzf.setTextColor(this.mContext.getResources().getColorStateList(R.e.bum));
                        this.lzg.setVisibility(4);
                        this.lzg.setImageResource(R.g.bBP);
                        this.lzh.setVisibility(4);
                        return;
                    case 6:
                        aBe();
                        return;
                    default:
                        this.lzc.setVisibility(8);
                        this.lzd.setBackgroundResource(R.g.bAf);
                        this.lzd.setVisibility(0);
                        this.lzf.setVisibility(0);
                        this.lzf.setText(R.l.ebs);
                        this.lzf.setTextColor(this.mContext.getResources().getColorStateList(R.e.brz));
                        this.lzg.setVisibility(4);
                        this.lzg.setImageResource(R.g.bBP);
                        this.lzh.setVisibility(4);
                        return;
                }
            }
        }
    }

    public c(Context context) {
        super(context);
    }

    public final void notifyDataSetChanged() {
        if (this.lAm == null) {
            this.lAm = a(null);
        }
        super.notifyDataSetChanged();
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        a aVar = (a) view.getTag();
        f oY = oY(i);
        if (!(aVar == null || oY == null)) {
            sx sxVar = oY.lAy;
            if (sxVar != null) {
                if (com.tencent.mm.plugin.emoji.h.a.d(sxVar)) {
                    aVar.setTitle(R.l.ebr);
                    aVar.oR(R.g.bCZ);
                } else {
                    if (bi.oN(sxVar.whv)) {
                        aVar.setTitle(sxVar.vPI);
                    } else {
                        aVar.setTitle(sxVar.whv);
                    }
                    if (bi.oN(sxVar.nlA)) {
                        x.i("MicroMsg.emoji.EmojiMineAdapter", "Icon rul is null");
                    } else {
                        o.PG().a(sxVar.nlA, aVar.aAX(), com.tencent.mm.plugin.emoji.e.f.cn(sxVar.vPI, sxVar.nlA));
                    }
                }
                if (i + 1 == getCount()) {
                    aVar.lyX.setBackgroundResource(R.g.bBz);
                } else {
                    aVar.lyX.setBackgroundResource(R.g.bBy);
                }
            }
        }
        return view;
    }

    protected final a c(Context context, View view) {
        a aVar = new a(context, view);
        aVar.a(this.lAn);
        return aVar;
    }

    protected final com.tencent.mm.plugin.emoji.a.a.c a(com.tencent.mm.plugin.emoji.model.f fVar) {
        return new d(fVar);
    }

    public final void be(String str, int i) {
        if (i == 7) {
            super.be(str, i);
        }
    }

    public final void clear() {
        if (this.lzx != null) {
            this.lzx.cancel();
        }
        super.clear();
    }

    protected final void aBk() {
        super.aBk();
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
