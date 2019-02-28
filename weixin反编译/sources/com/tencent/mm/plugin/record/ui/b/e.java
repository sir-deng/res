package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.record.b.m;
import com.tencent.mm.plugin.record.ui.RecordVoiceBaseView;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e implements b {
    RecordVoiceBaseView pMD;
    private m pMl = new m();

    public final View dq(Context context) {
        View inflate = View.inflate(context, R.i.dqH, null);
        RecordVoiceBaseView recordVoiceBaseView = (RecordVoiceBaseView) inflate.findViewById(R.h.cWE);
        recordVoiceBaseView.pMl = this.pMl;
        m mVar = recordVoiceBaseView.pMl;
        for (Object obj : mVar.gzt) {
            if (recordVoiceBaseView == obj) {
                break;
            }
        }
        mVar.gzt.add(recordVoiceBaseView);
        return inflate;
    }

    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        View findViewById = view.findViewById(R.h.cey);
        this.pMD = (RecordVoiceBaseView) view.findViewById(R.h.cWE);
        if (bVar.bjS == 0) {
            this.pMD.setVisibility(8);
            findViewById.setVisibility(0);
        } else if (bVar.bjS == 1) {
            findViewById.setVisibility(8);
            this.pMD.setVisibility(0);
            String a = com.tencent.mm.plugin.record.b.b.a(bVar);
            com.tencent.mm.sdk.b.b fwVar = new fw();
            fwVar.fwl.type = 17;
            fwVar.fwl.fwn = bVar.fvZ;
            a.xmy.m(fwVar);
            int i2 = fwVar.fwm.ret;
            if (!com.tencent.mm.a.e.bO(a)) {
                if (bi.oN(bVar.fvZ.wjN)) {
                    findViewById.setVisibility(0);
                    this.pMD.setVisibility(8);
                } else {
                    x.d("MicroMsg.VoiceViewWrapper", "restart voice %s, url %s", Long.valueOf(bVar.pLp.field_localId), bVar.fvZ.wjN);
                    com.tencent.mm.sdk.b.b fwVar2 = new fw();
                    fwVar2.fwl.type = 16;
                    fwVar2.fwl.frf = bVar.pLp.field_localId;
                    a.xmy.m(fwVar2);
                }
            }
            RecordVoiceBaseView recordVoiceBaseView = this.pMD;
            int i3 = bVar.fvZ.duration;
            recordVoiceBaseView.path = bi.aD(a, "");
            recordVoiceBaseView.fws = i2;
            if (recordVoiceBaseView.duration != i3) {
                recordVoiceBaseView.duration = i3;
                recordVoiceBaseView.setText(((int) q.bw((long) i3)) + "''");
            }
        }
    }

    public final void destroy() {
        m mVar = this.pMl;
        mVar.stopPlay();
        mVar.asA();
        m.kIB = null;
        mVar.gzt.clear();
    }

    public final void pause() {
        if (this.pMl != null && this.pMl.gzt.size() > 0) {
            for (m.a onFinish : this.pMl.gzt) {
                onFinish.onFinish();
            }
        }
    }
}
