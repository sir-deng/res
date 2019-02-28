package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.dx;

public final class a extends b<dx> {

    static class a {
        public ImageView nqo;
        public TextView nqp;
        public TextView nqq;

        a() {
        }
    }

    public a(Context context) {
        super(context);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        dx dxVar = (dx) getItem(i);
        if (view == null) {
            view = View.inflate(this.mContext, R.i.daN, null);
            a aVar2 = new a();
            aVar2.nqo = (ImageView) view.findViewById(R.h.cmn);
            aVar2.nqq = (TextView) view.findViewById(R.h.bIm);
            aVar2.nqp = (TextView) view.findViewById(R.h.cmX);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        Bitmap CI = CI(dxVar.nkU);
        if (CI == null) {
            aVar.nqo.setImageResource(R.g.byY);
        } else {
            aVar.nqo.setImageBitmap(CI);
        }
        aVar.nqp.setText(g.l(this.mContext, dxVar.nkU));
        if (g.Sf(dxVar.nkU)) {
            aVar.nqq.setText(R.l.enn);
        } else {
            aVar.nqq.setText(R.l.eno);
        }
        return view;
    }
}
