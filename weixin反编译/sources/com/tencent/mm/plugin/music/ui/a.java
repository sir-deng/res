package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.js;
import com.tencent.mm.f.a.jt;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends b {
    private c jil;
    private TextView oSM;

    public a(Context context) {
        super(context);
        if (this.view != null) {
            this.oSM = (TextView) this.view.findViewById(R.h.cyl);
            this.view.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    ati Qz = com.tencent.mm.au.b.Qz();
                    Intent intent;
                    if (Qz == null || !Qz.wHO || TextUtils.isEmpty(Qz.wHP)) {
                        intent = new Intent();
                        g.pWK.h(11992, Integer.valueOf(1));
                        intent.putExtra("key_scene", 1);
                        d.b((Context) a.this.vvl.get(), "music", ".ui.MusicMainUI", intent);
                        return;
                    }
                    x.i("MusicBanner", "barBackToWebView is true, start to jump Url:%s", Qz.wHP);
                    intent = new Intent();
                    intent.putExtra("rawUrl", r0);
                    d.b((Context) a.this.vvl.get(), "webview", ".ui.tools.WebViewUI", intent);
                }
            });
        }
        this.jil = new c<jt>() {
            {
                this.xmG = jt.class.getName().hashCode();
            }

            public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                switch (((jt) bVar).fBu.action) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        a.this.bfl();
                        break;
                }
                return false;
            }
        };
        com.tencent.mm.sdk.b.a.xmy.b(this.jil);
    }

    public final int getLayoutId() {
        return R.i.cym;
    }

    public final void setVisibility(int i) {
        if (this.view != null) {
            this.view.findViewById(R.h.cym).setVisibility(i);
        }
    }

    public final boolean alN() {
        return bfl();
    }

    public final void destroy() {
        com.tencent.mm.sdk.b.a.xmy.c(this.jil);
    }

    private boolean bfl() {
        int i = 8;
        if (com.tencent.mm.au.b.Qx()) {
            ati Qz = com.tencent.mm.au.b.Qz();
            CharSequence charSequence = ad.getContext().getString(R.l.exb) + ad.getContext().getString(R.l.exc) + Qz.wHv;
            if (this.oSM != null) {
                this.oSM.setText(charSequence);
            }
            if (!Qz.wHM) {
                i = 0;
            }
            setVisibility(i);
            if (Qz.wHM) {
                return false;
            }
            return true;
        }
        com.tencent.mm.sdk.b.b jsVar = new js();
        jsVar.fBo.action = 10;
        com.tencent.mm.sdk.b.a.xmy.m(jsVar);
        if (jsVar.fBp.foB) {
            setVisibility(0);
            return true;
        }
        setVisibility(8);
        return false;
    }

    public final int getOrder() {
        return 1;
    }
}
