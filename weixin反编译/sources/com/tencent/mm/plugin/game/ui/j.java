package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class j extends BaseAdapter {
    int DD;
    private Context mContext;
    int niV;
    private ag ntJ;

    private class a {
        public ImageView hxJ;
        public TextView jSh;
        public TextView ntL;
        public TextView ntM;
        public TextView ntN;
        GameDetailRankLikeView ntO;

        private a() {
        }

        /* synthetic */ a(j jVar, byte b) {
            this();
        }
    }

    public j(Context context) {
        this.mContext = context;
    }

    public final void a(ag agVar) {
        this.ntJ = agVar;
        ah.y(new Runnable() {
            public final void run() {
                j.this.notifyDataSetChanged();
            }
        });
    }

    public final int getCount() {
        return this.ntJ == null ? 0 : this.ntJ.njf.size();
    }

    public final Object getItem(int i) {
        return this.ntJ.njf.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(this.DD, viewGroup, false);
            a aVar2 = new a();
            aVar2.ntL = (TextView) inflate.findViewById(R.h.clJ);
            aVar2.hxJ = (ImageView) inflate.findViewById(R.h.clG);
            aVar2.jSh = (TextView) inflate.findViewById(R.h.clI);
            aVar2.ntM = (TextView) inflate.findViewById(R.h.clL);
            aVar2.ntN = (TextView) inflate.findViewById(R.h.clK);
            aVar2.ntO = (GameDetailRankLikeView) inflate.findViewById(R.h.clH);
            aVar2.ntO.niV = this.niV;
            f((ViewGroup) inflate);
            inflate.setTag(aVar2);
            view = inflate;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.game.model.ag.a aVar3 = (com.tencent.mm.plugin.game.model.ag.a) getItem(i);
        aVar.ntL.setText(aVar3.njg);
        b.a(aVar.hxJ, aVar3.fEx, 0.5f, false);
        as.Hm();
        x Xv = c.Ff().Xv(aVar3.fEx);
        if (Xv != null) {
            aVar.jSh.setText(new SpannableString(i.b(this.mContext, Xv.AX(), aVar.jSh.getTextSize())));
        } else {
            aVar.jSh.setText("");
        }
        if (bi.oN(aVar3.tag)) {
            aVar.ntM.setVisibility(8);
        } else {
            aVar.ntM.setVisibility(0);
            aVar.ntM.setText(aVar3.tag);
        }
        if (bi.oN(aVar3.njj)) {
            aVar.ntN.setText(aVar3.mRP);
            GameDetailRankLikeView gameDetailRankLikeView = aVar.ntO;
            ag agVar = this.ntJ;
            gameDetailRankLikeView.ntP = agVar;
            gameDetailRankLikeView.mAppId = agVar.mAppId;
            gameDetailRankLikeView.ntQ = (com.tencent.mm.plugin.game.model.ag.a) agVar.njf.get(i);
            gameDetailRankLikeView.aSf();
            aVar.ntO.setVisibility(0);
        } else {
            aVar.ntN.setText(aVar3.njj);
            aVar.ntO.setVisibility(8);
        }
        return view;
    }

    private void f(ViewGroup viewGroup) {
        viewGroup.setClipChildren(false);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                ((ViewGroup) childAt).setClipChildren(false);
                f((ViewGroup) childAt);
            }
        }
    }
}
