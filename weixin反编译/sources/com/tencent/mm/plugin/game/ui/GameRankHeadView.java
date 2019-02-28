package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.n.b;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.x;

public class GameRankHeadView extends LinearLayout implements OnClickListener {
    TextView jtn;
    d njs;
    TextView ntM;
    b nuo;
    o nuq;
    TextView nzX;
    private ImageView nzY;

    public GameRankHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jtn = (TextView) findViewById(R.h.clS);
        this.nzX = (TextView) findViewById(R.h.clE);
        this.ntM = (TextView) findViewById(R.h.clR);
        this.nzY = (ImageView) findViewById(R.h.cmO);
        x.i("MicroMsg.GameRankHeadView", "initView finished");
    }

    final void aSg() {
        if (g.a(getContext(), this.njs)) {
            if (this.njs.versionCode > c.CQ(this.njs.field_packageName)) {
                this.ntM.setText(R.l.emo);
                return;
            } else {
                this.ntM.setText(R.l.emm);
                return;
            }
        }
        switch (this.njs.status) {
            case 0:
                if (this.nuq == null) {
                    this.ntM.setVisibility(8);
                    this.nzY.setVisibility(8);
                    return;
                }
                this.ntM.setVisibility(0);
                this.nzY.setVisibility(0);
                switch (this.nuq.status) {
                    case 0:
                        this.ntM.setText(R.l.emj);
                        return;
                    case 1:
                        this.ntM.setText(R.l.emk);
                        return;
                    case 2:
                        this.ntM.setText(R.l.emi);
                        return;
                    case 3:
                        this.ntM.setText(R.l.eml);
                        return;
                    default:
                        return;
                }
            default:
                this.ntM.setText(R.l.emj);
                return;
        }
    }

    public void onClick(View view) {
        new e(getContext()).a(this.njs, new o(this.njs));
    }
}
