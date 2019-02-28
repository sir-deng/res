package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;

@a(7)
public class WebSearchVoiceUI extends WebSearchBaseActivity {
    private String frp;
    private com.tencent.mm.pluginsdk.ui.websearch.a tLl;
    private View tLm;
    private String tpV;

    protected final int getLayoutId() {
        return R.i.dul;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.frp = getIntent().getStringExtra("sessionId");
            this.tpV = getIntent().getStringExtra("subSessionId");
        }
        this.tLm = findViewById(R.h.cXm);
        this.mController.hideTitleView();
        if (this.tLl == null) {
            this.tLl = new com.tencent.mm.pluginsdk.ui.websearch.a(this.mController.xRr);
            this.tLl.vGg = new com.tencent.mm.pluginsdk.ui.websearch.a.a() {
                public final void bUM() {
                    WebSearchVoiceUI.this.setResult(0);
                    g.pWK.h(15178, Integer.valueOf(4), Long.valueOf(System.currentTimeMillis()), "", WebSearchVoiceUI.this.frp, WebSearchVoiceUI.this.tpV);
                    WebSearchVoiceUI.this.finish();
                }

                public final void Qb(String str) {
                    if (!TextUtils.isEmpty(str) && str.length() > 2) {
                        str = str.substring(0, str.length() - 1);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("text", str);
                    WebSearchVoiceUI.this.setResult(0, intent);
                    g.pWK.h(15178, Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), str, WebSearchVoiceUI.this.frp, WebSearchVoiceUI.this.tpV);
                    WebSearchVoiceUI.this.finish();
                }

                public final void kF(boolean z) {
                    if (z) {
                        g.pWK.h(15178, Integer.valueOf(2), Long.valueOf(System.currentTimeMillis()), "", WebSearchVoiceUI.this.frp, WebSearchVoiceUI.this.tpV);
                    }
                }
            };
        }
        this.tLl.ccP();
        com.tencent.mm.pluginsdk.ui.websearch.a aVar = this.tLl;
        x.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", Integer.valueOf(aVar.vvZ), Boolean.valueOf(aVar.vzh));
        if (aVar.vzh) {
            aVar.vzh = false;
            View findViewById = aVar.findViewById(R.h.cWz);
            LayoutParams layoutParams = findViewById.getLayoutParams();
            int i = aVar.vvZ;
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, i);
            }
            layoutParams.height = i;
            findViewById.setLayoutParams(layoutParams);
            aVar.ccR();
            aVar.requestLayout();
        }
        this.tLl.setVisibility(0);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        ((ViewGroup) findViewById(R.h.cIB)).addView(this.tLl, layoutParams2);
        g.pWK.h(15178, Integer.valueOf(1), Long.valueOf(System.currentTimeMillis()), "", this.frp, this.tpV);
    }

    public void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        finish();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.tLl != null) {
            this.tLl.destroy();
        }
    }
}
