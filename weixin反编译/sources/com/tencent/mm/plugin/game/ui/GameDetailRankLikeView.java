package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.plugin.game.c.ed;
import com.tencent.mm.plugin.game.c.ee;
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.model.ag.a;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;

public class GameDetailRankLikeView extends LinearLayout implements OnClickListener {
    String mAppId;
    int niV;
    ag ntP;
    a ntQ;
    private Drawable ntR;
    private Drawable ntS;
    private Animation ntT;
    private ImageView ntU;
    private TextView ntV;

    public GameDetailRankLikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.ntR = getContext().getResources().getDrawable(R.g.bCI);
        this.ntS = getContext().getResources().getDrawable(R.g.bCH);
        this.ntT = AnimationUtils.loadAnimation(getContext(), R.a.bqr);
        inflate(getContext(), R.i.dkf, this);
        setOnClickListener(this);
        this.ntU = (ImageView) findViewById(R.h.csX);
        this.ntV = (TextView) findViewById(R.h.csY);
    }

    final void aSf() {
        if (this.ntQ != null) {
            if (this.ntQ.nji) {
                this.ntU.setImageDrawable(this.ntR);
            } else {
                this.ntU.setImageDrawable(this.ntS);
            }
            int i = this.ntQ.njh;
            if (i > 99) {
                this.ntV.setText("99+");
                return;
            } else if (i == 0) {
                this.ntV.setText("");
                return;
            } else {
                this.ntV.setText(String.valueOf(i));
                return;
            }
        }
        setVisibility(8);
    }

    public void onClick(View view) {
        if (q.FY().equals(this.ntQ.fEx)) {
            if (this.ntQ.njh > 0) {
                Intent intent = new Intent(getContext(), GameDetailRankLikedUI.class);
                intent.putExtra("extra_appdi", this.mAppId);
                getContext().startActivity(intent);
            }
        } else if (!this.ntQ.nji) {
            this.ntQ.nji = true;
            a aVar = this.ntQ;
            aVar.njh++;
            this.ntP.aRp();
            String str = this.mAppId;
            String str2 = this.ntQ.fEx;
            b.a aVar2 = new b.a();
            aVar2.hnT = new ed();
            aVar2.hnU = new ee();
            aVar2.uri = "/cgi-bin/mmgame-bin/upfriend";
            aVar2.hnS = 1330;
            b Kf = aVar2.Kf();
            ed edVar = (ed) Kf.hnQ.hnY;
            edVar.nkU = str;
            edVar.npV = str2;
            u.a(Kf, new u.a() {
                public final int a(int i, int i2, String str, b bVar, k kVar) {
                    if (!(i == 0 && i2 == 0)) {
                        x.e("MicroMsg.GameDetailRankLikeView", "CGI return is not OK. (%d, %d)(%s)", Integer.valueOf(i), Integer.valueOf(i2), str);
                    }
                    return 0;
                }
            });
            ap.a(getContext(), 12, 1203, 1, 2, this.mAppId, this.niV, null);
            aSf();
            this.ntU.startAnimation(this.ntT);
        }
    }
}
