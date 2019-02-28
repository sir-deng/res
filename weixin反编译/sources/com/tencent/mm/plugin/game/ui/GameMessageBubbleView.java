package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.t.d;
import com.tencent.mm.plugin.game.model.u;
import com.tencent.mm.plugin.game.model.w;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class GameMessageBubbleView extends LinearLayout implements OnClickListener {
    private Context mContext;
    private boolean mHasInit = false;
    private View nza;
    private TextView nzb;
    private ImageView nzc;
    private t nzd;
    private final long nze = 500;
    private long nzf = 0;

    public GameMessageBubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if (!this.mHasInit) {
            this.nzc = (ImageView) findViewById(R.h.cmQ);
            this.nzb = (TextView) findViewById(R.h.cmP);
            this.nza = findViewById(R.h.cmR);
            setVisibility(8);
            this.mHasInit = true;
        }
    }

    public final void aSo() {
        SubCoreGameCenter.aRL();
        this.nzd = w.aQY();
        if (this.nzd == null) {
            this.nza.setOnClickListener(null);
            setVisibility(8);
            return;
        }
        this.nzd.aQT();
        if (this.nzd.field_msgType == 100 && (bi.oN(this.nzd.nhW.gCB) || bi.oN(this.nzd.nhW.niG) || bi.oN(this.nzd.nhW.niH) || !this.nzd.nhX.containsKey(this.nzd.nhW.niH))) {
            x.w("MicroMsg.GameMessageHeaderView", "bubble is invalid");
            this.nza.setOnClickListener(null);
            setVisibility(8);
            return;
        }
        this.nzb.setText(this.nzd.nhW.gCB);
        o.PG().a(this.nzd.nhW.niG, this.nzc);
        this.nza.setOnClickListener(this);
        setVisibility(0);
    }

    public final void aSp() {
        this.nza.setOnClickListener(null);
        setVisibility(8);
    }

    public void onClick(View view) {
        if (System.currentTimeMillis() - this.nzf > 500 && this.nzd != null) {
            SubCoreGameCenter.aRL();
            w.aQZ();
            int a;
            if (this.nzd.field_msgType == 100) {
                if (!bi.oN(this.nzd.nhW.niH)) {
                    d dVar = (d) this.nzd.nhX.get(this.nzd.nhW.niH);
                    if (dVar != null) {
                        a = u.a(this.mContext, this.nzd, dVar, this.nzd.field_appId, 1007);
                        if (a != 0) {
                            ap.a(this.mContext, 10, 1007, 1, a, 0, this.nzd.field_appId, 0, this.nzd.niA, this.nzd.field_gameMsgId, this.nzd.niB, null);
                        }
                        if (dVar.niJ != 4) {
                            this.nzd.field_isRead = true;
                            SubCoreGameCenter.aRK().c(this.nzd, new String[0]);
                        }
                    }
                }
                this.nzf = System.currentTimeMillis();
                return;
            }
            if (!(this.nzd == null || this.nzd.nhZ == 3)) {
                this.nzd.field_isRead = true;
                SubCoreGameCenter.aRK().c(this.nzd, new String[0]);
            }
            switch (this.nzd.nhZ) {
                case 1:
                    String str = this.nzd.nhL;
                    if (!bi.oN(str)) {
                        a = c.p(this.mContext, str, "game_center_bubble");
                        break;
                    } else {
                        a = 0;
                        break;
                    }
                case 2:
                    if (!bi.oN(this.nzd.field_appId)) {
                        Bundle bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", this.nzd.field_appId);
                        bundle.putInt("game_report_from_scene", 1007);
                        a = c.a(this.mContext, this.nzd.field_appId, null, bundle);
                        break;
                    }
                    x.e("MicroMsg.GameMessageHeaderView", "message type : " + this.nzd.field_msgType + " ,message.field_appId is null.");
                    a = 0;
                    break;
                case 3:
                    Intent intent = new Intent(this.mContext, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", 1007);
                    this.mContext.startActivity(intent);
                    a = 6;
                    break;
                default:
                    x.e("MicroMsg.GameMessageHeaderView", "unknown bubble_action = " + this.nzd.nhZ);
                    return;
            }
            ap.a(this.mContext, 10, 1007, 1, a, 0, this.nzd.field_appId, 0, this.nzd.field_msgType, this.nzd.field_gameMsgId, this.nzd.niB, null);
            this.nzf = System.currentTimeMillis();
        }
    }
}
