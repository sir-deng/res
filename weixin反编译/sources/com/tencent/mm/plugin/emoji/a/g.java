package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.a.f.a;

public final class g extends f {
    private int lzL = 0;
    private int lzM = 0;
    private int lzN = 0;

    public final /* synthetic */ Object getItem(int i) {
        return super.oY(i);
    }

    public g(Context context) {
        super(context);
    }

    public final int getCount() {
        return super.getCount();
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        final a aVar = (a) view.getTag();
        if (this.lzL > 0) {
            if (i == 0) {
                aVar.lzj.setVisibility(0);
                aVar.lzj.setText(this.mContext.getString(R.l.eaJ));
            } else if (this.lzM > 0 && i == this.lzL) {
                aVar.lzj.setVisibility(0);
                aVar.lzj.setText(this.mContext.getString(R.l.eaU));
            } else if (i == this.lzL + this.lzM) {
                aVar.lzj.setVisibility(0);
                aVar.lzj.setText(this.mContext.getString(R.l.eay));
            } else {
                aVar.lzj.setVisibility(8);
            }
        } else if (this.lzM > 0) {
            if (i == 0) {
                aVar.lzj.setVisibility(0);
                aVar.lzj.setText(this.mContext.getString(R.l.eaU));
            } else if (i == this.lzL + this.lzM) {
                aVar.lzj.setVisibility(0);
                aVar.lzj.setText(this.mContext.getString(R.l.eay));
            } else {
                aVar.lzj.setVisibility(8);
            }
        }
        if (aVar.lzl != null) {
            aVar.lzl.postDelayed(new Runnable() {
                public final void run() {
                    aVar.lzl.setPressed(false);
                }
            }, 100);
        }
        return super.b(i, view, viewGroup);
    }

    public final f oY(int i) {
        return super.oY(i);
    }

    public final int aBl() {
        return this.lzL;
    }

    public final void oV(int i) {
        this.lzL = i;
    }

    public final int aBm() {
        return this.lzM;
    }

    public final void oW(int i) {
        this.lzM = i;
    }

    public final int aBn() {
        return this.lzN;
    }

    public final void oX(int i) {
        this.lzN = i;
    }
}
