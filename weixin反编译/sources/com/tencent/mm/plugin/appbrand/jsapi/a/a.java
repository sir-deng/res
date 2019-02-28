package com.tencent.mm.plugin.appbrand.jsapi.a;

import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mm.plugin.appbrand.q.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends ClickableSpan {
    private String jjF;
    private int jjG = ad.getContext().getResources().getColor(d.bsE);

    public a(String str) {
        this.jjF = str;
    }

    public final void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.jjG);
        textPaint.setUnderlineText(false);
    }

    public final void onClick(View view) {
        if (bi.oN(this.jjF)) {
            x.e("MicroMsg.ExposeSpan", "exposeUrl is null, return");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.jjF);
        intent.putExtra("forceHideShare", true);
        com.tencent.mm.bl.d.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
        x.d("MicroMsg.ExposeSpan", "expose click, exposeUrl:%s", this.jjF);
    }
}
