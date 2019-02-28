package com.tencent.mm.plugin.multitalk.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.r;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.ArrayList;
import java.util.List;

public final class c implements OnClickListener {
    private TextView kKN;
    private MultiTalkMainUI oNL;
    private View oNM;
    private TextView oNN;
    private ImageView oNO;
    private LinearLayout oNP;
    private ImageButton oNQ;
    private ImageButton oNR;

    public c(MultiTalkMainUI multiTalkMainUI) {
        this.oNL = multiTalkMainUI;
        this.oNM = multiTalkMainUI.findViewById(R.h.cql);
        this.oNN = (TextView) multiTalkMainUI.findViewById(R.h.cqn);
        this.oNO = (ImageView) multiTalkMainUI.findViewById(R.h.cqm);
        this.oNP = (LinearLayout) multiTalkMainUI.findViewById(R.h.cOL);
        this.kKN = (TextView) multiTalkMainUI.findViewById(R.h.cpW);
        this.oNQ = (ImageButton) multiTalkMainUI.findViewById(R.h.cqo);
        this.oNR = (ImageButton) multiTalkMainUI.findViewById(R.h.cqk);
        this.oNQ.setOnClickListener(this);
        this.oNR.setOnClickListener(this);
    }

    public final void n(MultiTalkGroup multiTalkGroup) {
        int i;
        this.oNM.setVisibility(0);
        String bdr = i.bdr();
        List arrayList = new ArrayList();
        if (!bi.oN(bdr)) {
            for (i = 0; i < multiTalkGroup.zZG.size(); i++) {
                if (!((MultiTalkGroupMember) multiTalkGroup.zZG.get(i)).zZH.equals(bdr)) {
                    arrayList.add(((MultiTalkGroupMember) multiTalkGroup.zZG.get(i)).zZH);
                }
            }
            this.oNN.setText(com.tencent.mm.pluginsdk.ui.d.i.a(this.oNL, r.gw(bdr)));
            b.a(this.oNO, bdr, 0.1f, true);
        }
        if (arrayList.size() > 0) {
            this.kKN.setVisibility(0);
            this.kKN.setText(R.l.ewG);
            this.oNP.setVisibility(0);
            this.oNP.removeAllViews();
            for (i = 0; i < arrayList.size(); i++) {
                View imageView = new ImageView(this.oNL.mController.xRr);
                LayoutParams layoutParams = new LinearLayout.LayoutParams(b.oNE, b.oNE);
                if (i != 0) {
                    layoutParams.leftMargin = b.oNC;
                }
                imageView.setLayoutParams(layoutParams);
                this.oNP.addView(imageView);
                b.a(imageView, (String) arrayList.get(i), 0.1f, false);
            }
            return;
        }
        this.kKN.setVisibility(8);
        this.oNP.setVisibility(8);
    }

    public final void bdH() {
        this.oNM.setVisibility(8);
    }

    public final void onClick(View view) {
        if (view.getId() == R.h.cqk) {
            o.bdB().c(true, false, false);
        } else if (view.getId() == R.h.cqo) {
            e bdB = o.bdB();
            if (bdB.bcZ()) {
                x.i("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: %s", i.h(bdB.oLN));
                o.bdA().oLv.dH(bdB.oLN.zZC, bdB.oLN.zVs);
                return;
            }
            x.e("MicroMsg.MT.MultiTalkManager", "acceptCurrentMultiTalk: Not in MultiTalking");
        }
    }
}
