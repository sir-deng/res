package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.tencent.mm.R;

public class GameRankView extends FrameLayout {
    private Context mContext;
    ListView nAc;
    View nAd;
    s nAe;
    private GameRankFooter nAf;

    public GameRankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nAc = (ListView) findViewById(R.h.cnf);
        this.nAf = (GameRankFooter) View.inflate(this.mContext, R.i.dli, null);
        GameRankFooter gameRankFooter = this.nAf;
        gameRankFooter.nzR.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                s a = GameRankView.this.nAe;
                if (a.nzC.size() > a.nzE) {
                    if (a.nzE + 25 >= a.nzC.size()) {
                        a.nzE = a.nzC.size();
                        a.nzH.aSs();
                        a.nzJ = true;
                    } else {
                        a.nzE += 25;
                        a.nzH.aSr();
                    }
                    a.nzD = a.nzC.subList(0, a.nzE);
                    if (a.nzI || a.nzK <= a.nzE) {
                        a.nzH.aSt();
                    } else if (a.nzG != null) {
                        a.nzH.a(a.nzG);
                    } else {
                        a.nzH.aSt();
                    }
                    a.notifyDataSetChanged();
                }
            }
        });
        this.nAc.addFooterView(this.nAf);
        this.nAe = new s(this.mContext, this.nAf);
        this.nAd = findViewById(R.h.cnd);
    }
}
