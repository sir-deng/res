package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class a extends b {
    String mUrl = null;
    private String nRP = null;
    private boolean yfj = false;
    private com.tencent.mm.y.b.b.b yfk = null;
    private String yfl = "";

    public a(Context context, com.tencent.mm.y.b.b.b bVar) {
        super(context);
        this.yfk = bVar;
        refresh();
    }

    public final int getLayoutId() {
        return R.i.det;
    }

    private void refresh() {
        as.Hm().FO();
        if (com.tencent.mm.y.b.b.a(this.yfk)) {
            x.i("MicroMsg.ChattingMonitoredBanner", "hy: start show banner: %s, %s, %s, %b", this.yfk, this.nRP, this.mUrl, Boolean.valueOf(this.yfj));
            if (this.yfk == com.tencent.mm.y.b.b.b.Chatting) {
                as.Hm().FO();
                this.nRP = com.tencent.mm.y.b.b.Iv();
                as.Hm().FO();
                this.mUrl = com.tencent.mm.y.b.b.Iw();
                as.Hm().FO();
                this.yfj = com.tencent.mm.y.b.b.Ix();
            } else {
                as.Hm().FO();
                this.nRP = com.tencent.mm.y.b.b.Is();
                as.Hm().FO();
                this.mUrl = com.tencent.mm.y.b.b.It();
                as.Hm().FO();
                this.yfj = com.tencent.mm.y.b.b.Iu();
            }
            TextView textView = (TextView) getView().findViewById(R.h.bUI);
            ImageView imageView = (ImageView) getView().findViewById(R.h.bWn);
            if (bi.oN(this.nRP)) {
                textView.setText(R.l.dHn);
            } else {
                textView.setText(this.nRP);
            }
            textView.setSelected(true);
            if (bi.oN(this.mUrl)) {
                getView().findViewById(R.h.cxk).setBackgroundResource(R.e.btY);
                imageView.setImageResource(R.g.bDN);
                textView.setTextColor(ad.getContext().getResources().getColor(R.e.white));
            } else {
                getView().findViewById(R.h.cxk).setBackgroundResource(R.g.bGU);
                imageView.setImageResource(R.g.bDO);
                textView.setTextColor(ad.getContext().getResources().getColor(R.e.btZ));
            }
            getView().setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    a.this.ED(1);
                    a aVar = a.this;
                    String str = a.this.mUrl;
                    if (bi.oN(str)) {
                        x.e("MicroMsg.ChattingMonitoredBanner", "hy: not provide url");
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    d.b((Context) aVar.vvl.get(), "webview", ".ui.tools.WebViewUI", intent);
                }
            });
            if (getView().getVisibility() != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                g.Do();
                this.yfl = stringBuilder.append(com.tencent.mm.kernel.a.Cn()).append("_").append(System.currentTimeMillis()).toString();
                ED(0);
            }
            setVisibility(0);
            if (this.yfj) {
                imageView.setVisibility(0);
                imageView.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        x.i("MicroMsg.ChattingMonitoredBanner", "hy: user required close the banner");
                        a.this.ED(2);
                        as.Hm().FO().c(com.tencent.mm.y.b.b.b.Main);
                        as.Hm().FO().c(com.tencent.mm.y.b.b.b.Chatting);
                        a.this.setVisibility(8);
                    }
                });
                return;
            }
            imageView.setVisibility(8);
            return;
        }
        x.i("MicroMsg.ChattingMonitoredBanner", "hy: should not show banner");
        setVisibility(8);
    }

    public final void setVisibility(int i) {
        super.setVisibility(i);
        getView().findViewById(R.h.cxk).setVisibility(i);
    }

    public final boolean alN() {
        refresh();
        return super.alN();
    }

    public final void destroy() {
    }

    final void ED(int i) {
        int i2 = 1;
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
        Object[] objArr = new Object[3];
        objArr[0] = this.yfl;
        objArr[1] = Integer.valueOf(i);
        if (this.yfk == com.tencent.mm.y.b.b.b.Main) {
            i2 = 0;
        }
        objArr[2] = Integer.valueOf(i2);
        gVar.h(14439, objArr);
        com.tencent.mm.plugin.report.service.g.pWK.a(633, (long) i, 1, false);
    }
}
