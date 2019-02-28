package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.b.a;
import com.tencent.mm.sdk.platformtools.x;

public class GameInfoViewForeign extends RelativeLayout {
    private int gBu = 0;
    private Context mContext;
    int niV = 0;
    private int nxn = 2;
    private TextView nxr;
    private OnClickListener nxs = new OnClickListener() {
        public final void onClick(View view) {
            int p;
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                a aQy = b.aQy();
                if (aQy.fEo == 2) {
                    p = c.p(GameInfoViewForeign.this.mContext, aQy.url, "game_center_msgcenter");
                } else {
                    Intent intent = new Intent(GameInfoViewForeign.this.mContext, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", 1001);
                    GameInfoViewForeign.this.mContext.startActivity(intent);
                    p = 6;
                }
            } else {
                p = c.p(GameInfoViewForeign.this.mContext, (String) view.getTag(), "game_center_msgcenter");
            }
            ap.a(GameInfoViewForeign.this.mContext, 10, 1001, GameInfoViewForeign.this.nxn, p, 0, null, GameInfoViewForeign.this.niV, 0, null, null, ap.cS("resource", "5"));
        }
    };

    public GameInfoViewForeign(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(this.nxs);
        this.nxr = (TextView) findViewById(R.h.cmW);
        aSj();
        x.i("MicroMsg.GameInfoViewForeign", "initView finished");
    }

    public final void aSj() {
        this.gBu = SubCoreGameCenter.aRK().aRe();
        if (this.gBu > 0 && this.gBu <= 99) {
            this.nxr.setVisibility(0);
            this.nxr.setText(this.gBu);
        } else if (this.gBu > 99) {
            this.nxr.setVisibility(0);
            this.nxr.setText("99+");
            this.nxr.setTextSize(1, 9.0f);
        } else {
            this.nxr.setVisibility(4);
        }
    }
}
