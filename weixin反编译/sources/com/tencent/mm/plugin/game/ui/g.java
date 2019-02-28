package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.aj;
import com.tencent.mm.plugin.game.c.l;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public final class g extends LinearLayout implements OnClickListener {
    private LayoutInflater DF = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));
    private String mAppId;
    private Context mContext;
    private int niV;

    public g(Context context) {
        super(context);
        this.mContext = context;
        setOrientation(0);
    }

    public final void a(aj ajVar, String str, int i, int i2) {
        if (ajVar == null || bi.cC(ajVar.nmz)) {
            setVisibility(8);
            return;
        }
        if (ajVar.nmz.size() == 1) {
            ajVar.nmz.add(null);
            ajVar.nmz.add(null);
        } else if (ajVar.nmz.size() == 2) {
            ajVar.nmz.add(null);
        }
        this.mAppId = str;
        this.niV = i2;
        Iterator it = ajVar.nmz.iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            LinearLayout linearLayout = (LinearLayout) this.DF.inflate(R.i.djF, this, false);
            addView(linearLayout, new LayoutParams(-2, -2, 1.0f));
            ImageView imageView = (ImageView) linearLayout.findViewById(R.h.ceJ);
            TextView textView = (TextView) linearLayout.findViewById(R.h.ceK);
            TextView textView2 = (TextView) linearLayout.findViewById(R.h.ceI);
            if (lVar == null) {
                imageView.setImageResource(R.g.bCO);
                textView.setText(R.l.bCO);
                textView.setTextColor(this.mContext.getResources().getColor(R.e.bsz));
            } else {
                linearLayout.setOnClickListener(this);
                e.aSC().h(imageView, lVar.nlA);
                textView.setText(lVar.fpg);
                if (bi.oN(lVar.nkL)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(lVar.nkL);
                    textView2.setVisibility(0);
                }
                linearLayout.setTag(lVar);
                if (i == 2) {
                    ap.a(this.mContext, 10, 1002, lVar.nlw, str, i2, ap.CD(lVar.nlr));
                }
            }
        }
    }

    public final void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof l)) {
            x.w("MicroMsg.GameBlockEntranceView", "getTag is null");
            return;
        }
        l lVar = (l) view.getTag();
        if (bi.oN(lVar.nkN)) {
            x.w("MicroMsg.GameBlockEntranceView", "jumpUrl is null");
            return;
        }
        ap.a(this.mContext, 10, 1002, lVar.nlw, c.p(this.mContext, lVar.nkN, "game_center_mygame_comm"), this.mAppId, this.niV, ap.CD(lVar.nlr));
    }
}
