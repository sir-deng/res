package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.j;
import com.tencent.mm.plugin.voiceprint.model.q;
import com.tencent.mm.plugin.voiceprint.model.q.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public class VoiceUnLockUI extends BaseVoicePrintUI implements a {
    private q soH;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.soH = new q(this);
        x.d("MicroMsg.VoicePrintUnLockService", "getVoiceText");
        as.CN().a(new d(73, ""), 0);
    }

    protected final void bGw() {
        x.d("MicroMsg.VoiceUnLockUI", "sendVoice, filename:%s", this.snA);
        if (!bi.oN(this.snA) && !bi.oN(this.soH.sne)) {
            k jVar = new j(this.snA, this.soH.snf);
            jVar.smM = true;
            as.CN().a(jVar, 0);
            this.snv.setEnabled(false);
            this.sny.bGF();
        }
    }

    protected final void aWX() {
        findViewById(R.h.cIk).setVisibility(8);
        this.sny.bGF();
        this.sny.yJ(R.l.eTQ);
        this.sny.bGI();
        this.snv.setEnabled(false);
    }

    public final void Nf(String str) {
        this.sne = str;
        this.sny.bGH();
        this.sny.Ng(str);
        this.sny.bGG();
        this.snv.setEnabled(true);
    }

    public final void jh(boolean z) {
        this.sny.bGG();
        this.snv.setEnabled(true);
        if (z) {
            x.d("MicroMsg.VoiceUnLockUI", "unlock success");
            bGE();
            return;
        }
        this.sny.yK(R.l.eTP);
        this.sny.bGJ();
    }

    protected void bGE() {
        Intent intent = new Intent();
        intent.putExtra("kscene_type", 73);
        intent.setClass(this, VoicePrintFinishUI.class);
        startActivity(intent);
        finish();
    }

    public final void bGp() {
        bGv();
    }

    protected void onDestroy() {
        super.onDestroy();
        e eVar = this.soH;
        as.CN().b(611, eVar);
        as.CN().b(613, eVar);
        eVar.snu = null;
    }
}
