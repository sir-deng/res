package com.tencent.mm.view.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.plugin.m.a.d;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.f;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;

public final class b extends a {

    class a {
        ImageView jIs;

        public a(View view) {
            this.jIs = (ImageView) view.findViewById(e.bLk);
        }
    }

    public b(Context context, com.tencent.mm.view.f.a aVar) {
        super(context, aVar);
    }

    public final int getCount() {
        return this.zNu;
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = v.fw(this.mContext).inflate(f.lPm, null);
            com.tencent.mm.view.f.a aVar2 = this.zMD;
            if (aVar2.zPK == 0) {
                aVar2.zPK = aVar2.cBK() / aVar2.abd("TAG_DEFAULT_TAB");
            }
            view.setLayoutParams(new LayoutParams(aVar2.zPK, this.zMD.zPH));
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == getCount() - 1) {
            aVar.jIs.setImageResource(d.bBF);
            aVar.jIs.setContentDescription(this.mContext.getString(h.dYD));
        } else {
            int i2 = ((this.zNu - 1) * this.zNv) + i;
            if (i2 > this.kLd - 1) {
                aVar.jIs.setImageDrawable(null);
                aVar.jIs.setContentDescription("");
                x.i("MicroMsg.emoji.DefaultSmileyAdapter", "real position is bigger real count.");
            } else {
                Drawable mx = com.tencent.mm.bw.e.chP().mx(i2);
                aVar.jIs.setImageDrawable(mx);
                CharSequence text = com.tencent.mm.bw.e.chP().getText(i2);
                if (bi.oN(text)) {
                    text = view.getResources().getString(h.ebl);
                }
                aVar.jIs.setContentDescription(text);
                if (mx == null) {
                    x.i("MicroMsg.emoji.DefaultSmileyAdapter", "drawable is null. realPosition:%d description:%s", Integer.valueOf(i2), text);
                }
            }
        }
        return view;
    }
}
