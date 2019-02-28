package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.b;
import com.tencent.mm.plugin.game.model.b.a;
import com.tencent.mm.sdk.platformtools.x;

public class GameInfoView extends RelativeLayout implements OnClickListener {
    private int gBu = 0;
    Context mContext;
    int niV = 0;
    FrameLayout nwW;
    ImageView nwX;
    private TextView nwY;
    FrameLayout nwZ;
    ImageView nxa;
    ImageView nxb;
    ImageView nxc;
    RelativeLayout nxd;
    ImageView nxe;
    TextView nxf;
    ImageView nxg;
    String nxh = "";
    String nxi = "";
    String nxj = "";
    ImageView nxk;
    String nxl = "";
    private int nxm = 1;
    private int nxn = 2;
    private int nxo = 3;
    int nxp = 4;
    String nxq;

    public GameInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.nxd = (RelativeLayout) findViewById(R.h.ckP);
        this.nxd.setOnClickListener(this);
        this.nxe = (ImageView) findViewById(R.h.cDT);
        this.nxf = (TextView) findViewById(R.h.cEd);
        this.nxg = (ImageView) findViewById(R.h.bMr);
        this.nwW = (FrameLayout) findViewById(R.h.cmU);
        this.nwW.setOnClickListener(this);
        this.nwX = (ImageView) findViewById(R.h.cvY);
        this.nwY = (TextView) findViewById(R.h.cmW);
        this.nwZ = (FrameLayout) findViewById(R.h.cmj);
        this.nwZ.setOnClickListener(this);
        this.nxa = (ImageView) findViewById(R.h.cnG);
        this.nxb = (ImageView) findViewById(R.h.cnH);
        this.nxk = (ImageView) findViewById(R.h.cJI);
        this.nxc = (ImageView) findViewById(R.h.cJO);
        this.nxc.setOnClickListener(this);
        x.i("MicroMsg.GameInfoView", "initView finished");
    }

    public final void aSj() {
        this.gBu = SubCoreGameCenter.aRK().aRe();
        if (this.gBu > 0 && this.gBu <= 99) {
            this.nwY.setVisibility(0);
            this.nwY.setText(this.gBu);
        } else if (this.gBu > 99) {
            this.nwY.setVisibility(0);
            this.nwY.setText("99+");
            this.nwY.setTextSize(1, 9.0f);
        } else {
            this.nwY.setVisibility(8);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        a aQy;
        int p;
        Intent intent;
        String cS;
        if (id == R.h.ckP) {
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                ap.a(this.mContext, 10, 1001, this.nxp, c.p(this.mContext, (String) view.getTag(), "game_center_profile"), this.niV, this.nxq);
            }
        } else if (id == R.h.cmU) {
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                aQy = b.aQy();
                if (aQy.fEo == 2) {
                    p = c.p(this.mContext, aQy.url, "game_center_msgcenter");
                } else {
                    intent = new Intent(this.mContext, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", 1001);
                    intent.putExtra("game_unread_msg_count", this.gBu);
                    intent.putExtra("game_manage_url", this.nxl);
                    this.mContext.startActivity(intent);
                    p = 6;
                }
            } else {
                p = c.p(this.mContext, (String) view.getTag(), "game_center_msgcenter");
            }
            if (this.nwY.getVisibility() == 0) {
                cS = ap.cS("resource", "5");
            } else {
                cS = null;
            }
            ap.a(this.mContext, 10, 1001, this.nxn, p, 0, null, this.niV, 0, null, null, cS);
        } else if (id == R.h.cmj) {
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                p = c.p(this.mContext, (String) view.getTag(), "game_center_giftcenter");
                if (this.nxb.getVisibility() == 0) {
                    cS = ap.cS("resource", "5");
                } else {
                    cS = null;
                }
                ap.a(this.mContext, 10, 1001, this.nxo, p, 0, null, this.niV, 0, null, null, cS);
            }
        } else if (id == R.h.cJO) {
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                aQy = b.aQy();
                if (aQy.fEo == 2) {
                    p = c.p(this.mContext, aQy.url, "game_center_msgcenter");
                } else {
                    intent = new Intent(this.mContext, GameSearchUI.class);
                    intent.putExtra("game_report_from_scene", 1001);
                    this.mContext.startActivity(intent);
                    p = 6;
                }
            } else {
                p = c.p(this.mContext, (String) view.getTag(), "game_center_msgcenter");
            }
            ap.a(this.mContext, 14, 1401, 1, p, 0, null, this.niV, 0, null, null, null);
        }
    }
}
