package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.c.ag;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.e.a.a;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.sdk.platformtools.bi;

public class GameFeedSubscriptView extends LinearLayout implements OnClickListener {
    private ImageView lpW;
    private ag nwg;
    private TextView nwh;
    private TextView nwi;
    private LinearLayout nwj;
    private TextView nwk;
    private TextView nwl;
    private TextView nwm;

    public GameFeedSubscriptView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        View inflate = LayoutInflater.from(getContext()).inflate(R.i.dkw, this, true);
        this.nwh = (TextView) inflate.findViewById(R.h.csP);
        this.nwi = (TextView) inflate.findViewById(R.h.csQ);
        this.nwj = (LinearLayout) inflate.findViewById(R.h.bLQ);
        this.lpW = (ImageView) inflate.findViewById(R.h.bLD);
        this.nwk = (TextView) inflate.findViewById(R.h.cAo);
        this.nwl = (TextView) inflate.findViewById(R.h.cUj);
        this.nwm = (TextView) inflate.findViewById(R.h.cIn);
        this.nwh.setOnClickListener(this);
        this.nwi.setOnClickListener(this);
        this.nwj.setOnClickListener(this);
        this.nwm.setOnClickListener(this);
    }

    public final void a(ag agVar) {
        if (agVar == null || (agVar.nmv == null && agVar.nmw == null)) {
            setVisibility(8);
            return;
        }
        this.nwg = agVar;
        setVisibility(0);
        if (agVar.nmv != null) {
            this.nwh.setVisibility(8);
            this.nwi.setVisibility(8);
            this.nwj.setVisibility(8);
            switch (agVar.nmv.nlH) {
                case 1:
                    this.nwi.setVisibility(0);
                    this.nwi.setText(agVar.nmv.nkL);
                    break;
                case 2:
                    this.nwh.setVisibility(0);
                    this.nwh.setText(agVar.nmv.nkL);
                    break;
                case 3:
                    this.nwj.setVisibility(0);
                    if (!bi.oN(agVar.nmv.nlG)) {
                        a aVar = new a();
                        aVar.hFJ = true;
                        e.aSC().a(this.lpW, agVar.nmv.nlG, aVar.aSD());
                        this.lpW.setVisibility(0);
                    }
                    this.nwk.setText(agVar.nmv.nkW);
                    this.nwl.setText(agVar.nmv.nkL);
                    break;
            }
        }
        if (agVar.nmw != null) {
            this.nwm.setText(agVar.nmw.nkL);
            this.nwm.setVisibility(0);
            return;
        }
        this.nwm.setVisibility(8);
    }

    public void onClick(View view) {
        if (this.nwg != null) {
            if (view.getId() == R.h.csP || view.getId() == R.h.csQ || view.getId() == R.h.bLQ) {
                if (this.nwg.nmv != null && !bi.oN(this.nwg.nmv.nkN)) {
                    c.ac(getContext(), this.nwg.nmv.nkN);
                    ro(1);
                }
            } else if (view.getId() == R.h.cIn && this.nwg.nmw != null && !bi.oN(this.nwg.nmw.nkN)) {
                c.ac(getContext(), this.nwg.nmw.nkN);
                ro(2);
            }
        }
    }

    private void ro(int i) {
        String M;
        if (i == 1) {
            M = ap.M(this.nwg.nlr, "clickType", "leftCorner");
        } else {
            M = ap.M(this.nwg.nlr, "clickType", "rightCorner");
        }
        ap.a(getContext(), 10, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, this.nwg.nlw, 7, this.nwg.nlV, GameIndexListView.aSh(), M);
    }
}
