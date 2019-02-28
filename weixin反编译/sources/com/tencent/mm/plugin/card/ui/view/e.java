package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.kq;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends i {
    private View lcd;

    public final void initView() {
    }

    public final void update() {
        b awp = this.lcl.awp();
        kq kqVar = awp.aui().vZa;
        if (kqVar != null) {
            x.i("MicroMsg.CardAnnoucementView", "card tp annoucement  endtime: " + kqVar.quA);
            x.i("MicroMsg.CardAnnoucementView", "card tp annoucement  text: " + kqVar.text);
            x.i("MicroMsg.CardAnnoucementView", "card tp annoucement  thumb_url: " + kqVar.vYz);
        }
        if (kqVar != null && !TextUtils.isEmpty(kqVar.text) && awp.aug()) {
            if (this.lcd == null) {
                this.lcd = ((ViewStub) findViewById(R.h.bPF)).inflate();
            }
            ((TextView) this.lcd.findViewById(R.h.cEn)).setText(kqVar.text);
            this.lcd.setOnClickListener(this.lcl.awt());
        } else if (this.lcd != null) {
            this.lcd.setVisibility(8);
        }
    }

    public final void axD() {
        if (this.lcd != null) {
            this.lcd.setVisibility(8);
        }
    }
}
