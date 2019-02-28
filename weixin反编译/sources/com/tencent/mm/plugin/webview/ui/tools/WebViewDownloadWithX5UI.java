package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.f.a.gq;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.xweb.x5.sdk.d;
import java.util.HashMap;

@a(2)
public class WebViewDownloadWithX5UI extends MMActivity {
    private Context mContext;
    private Button tDI;
    private final com.tencent.mm.plugin.webview.modeltools.a tDX = new com.tencent.mm.plugin.webview.modeltools.a();

    static /* synthetic */ void a(WebViewDownloadWithX5UI webViewDownloadWithX5UI, String str, String str2) {
        int i;
        b gqVar = new gq();
        gqVar.fxE.url = str;
        gqVar.fxE.frM = "";
        gqVar.fxE.extInfo = "";
        gqVar.fxE.appId = "";
        com.tencent.mm.sdk.b.a.xmy.m(gqVar);
        g.pWK.h(14217, "", Integer.valueOf(2), str2, str, Integer.valueOf(1));
        int tbsVersion = d.getTbsVersion(webViewDownloadWithX5UI);
        if (as.Hp()) {
            as.Hm();
            String str3 = (String) c.Db().get(274528, (Object) "");
            if (TextUtils.isEmpty(str3) || !p.m(webViewDownloadWithX5UI.mController.xRr, str3)) {
                i = 0;
            } else {
                x.i("MicroMsg.WebViewDownloadWithX5UI", "use always option PackageName is %s", str3);
                i = 1;
            }
        } else {
            i = 0;
        }
        if (i != 0 || tbsVersion <= 0) {
            com.tencent.mm.plugin.webview.modeltools.a.d(webViewDownloadWithX5UI, str);
            return;
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
        hashMap.put(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, "9");
        x.i("MicroMsg.WebViewDownloadWithX5UI", "startQbOrMiniQBToLoadUrl ret = %b", Boolean.valueOf(d.a(webViewDownloadWithX5UI, str, hashMap, new ValueCallback<String>() {
            public final /* synthetic */ void onReceiveValue(Object obj) {
                x.i("MicroMsg.WebViewDownloadWithX5UI", "onReceiveValue Value = %s", (String) obj);
                if ("closeMiniQb".equals((String) obj)) {
                    WebViewDownloadWithX5UI.this.finish();
                }
            }
        })));
        if (!d.a(webViewDownloadWithX5UI, str, hashMap, /* anonymous class already generated */)) {
            com.tencent.mm.plugin.webview.modeltools.a.d(webViewDownloadWithX5UI, str);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        setMMTitle(getString(R.l.eWV));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WebViewDownloadWithX5UI.this.finish();
                return true;
            }
        });
        overridePendingTransition(MMFragmentActivity.a.xSL, MMFragmentActivity.a.xSM);
        this.tDI = (Button) findViewById(R.h.ccJ);
        ImageView imageView = (ImageView) findViewById(R.h.ccS);
        TextView textView = (TextView) findViewById(R.h.ccU);
        final String stringExtra = getIntent().getStringExtra("task_url");
        CharSequence stringExtra2 = getIntent().getStringExtra("title");
        final long longExtra = getIntent().getLongExtra("task_size", 0);
        final String stringExtra3 = getIntent().getStringExtra("page_url");
        x.i("MicroMsg.WebViewDownloadWithX5UI", "onCreate: url=%s,taskSize=%d, thumbUrl=%s", stringExtra, Long.valueOf(longExtra), getIntent().getStringExtra("thumb_url"));
        if (longExtra > 0) {
            String fL = bi.fL(longExtra);
            this.tDI.setText(getString(R.l.eWN, new Object[]{fL}));
        }
        if (as.Hp()) {
            com.tencent.mm.ap.a.a PG = o.PG();
            com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
            aVar.hFA = R.k.dBT;
            aVar.hFl = true;
            PG.a(r7, imageView, aVar.PQ());
        } else {
            imageView.setImageResource(R.k.dBT);
        }
        textView.setVisibility(0);
        if (bi.oN(stringExtra2)) {
            textView.setText(getString(R.l.eWU));
        } else {
            textView.setText(stringExtra2);
        }
        g.pWK.h(14217, "", Integer.valueOf(1), stringExtra3, stringExtra, Integer.valueOf(1));
        this.tDI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (ao.isNetworkConnected(WebViewDownloadWithX5UI.this.mContext)) {
                    as.Hm();
                    if (!c.isSDCardAvailable()) {
                        Toast.makeText(WebViewDownloadWithX5UI.this.mContext, WebViewDownloadWithX5UI.this.getString(R.l.emw), 0).show();
                        x.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, sdcard not ready");
                        return;
                    } else if (longExtra > 0 && !f.aD(longExtra)) {
                        Toast.makeText(WebViewDownloadWithX5UI.this.mContext, WebViewDownloadWithX5UI.this.getString(R.l.emv), 0).show();
                        x.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, not enough space, require size = " + longExtra);
                        return;
                    } else if (ao.isWifi(WebViewDownloadWithX5UI.this.mContext)) {
                        WebViewDownloadWithX5UI.a(WebViewDownloadWithX5UI.this, stringExtra, stringExtra3);
                        return;
                    } else {
                        g.pWK.h(14217, "", Integer.valueOf(4), stringExtra3, stringExtra, Integer.valueOf(1));
                        h.a(WebViewDownloadWithX5UI.this, WebViewDownloadWithX5UI.this.getString(R.l.eWR), WebViewDownloadWithX5UI.this.getString(R.l.eWS), WebViewDownloadWithX5UI.this.getString(R.l.eWM), WebViewDownloadWithX5UI.this.getString(R.l.dEy), false, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                g.pWK.h(14217, "", Integer.valueOf(5), stringExtra3, stringExtra, Integer.valueOf(1));
                                WebViewDownloadWithX5UI.a(WebViewDownloadWithX5UI.this, stringExtra, stringExtra3);
                                dialogInterface.dismiss();
                            }
                        }, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                g.pWK.h(14217, "", Integer.valueOf(6), stringExtra3, stringExtra, Integer.valueOf(1));
                                dialogInterface.dismiss();
                            }
                        }, R.e.buj);
                        return;
                    }
                }
                Toast.makeText(WebViewDownloadWithX5UI.this.mContext, WebViewDownloadWithX5UI.this.getString(R.l.emu), 0).show();
                x.i("MicroMsg.WebViewDownloadWithX5UI", "startDownload fail, network not ready");
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dum;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (com.tencent.mm.plugin.webview.modeltools.a.b(this, i, i2, intent) && -1 == i2) {
            finish();
        }
    }
}
