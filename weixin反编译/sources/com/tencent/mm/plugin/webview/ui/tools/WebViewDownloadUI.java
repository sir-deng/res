package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.f.a.gq;
import com.tencent.mm.f.a.i;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class WebViewDownloadUI extends MMActivity {
    private long jfS;
    private TextView lsa;
    private int lyj;
    private Context mContext;
    private boolean tDC;
    private Button tDI;
    private TextView tDJ;
    private a tDK;
    private String tDL;
    private TextView tDM;
    private int tDN;
    private o tDO = new o() {
        public final void onTaskStarted(long j, String str) {
            x.i("MicroMsg.WebViewDownloadUI", "onTaskStarted id=%d, savedFilePath=%s", Long.valueOf(j), str);
        }

        public final void c(long j, String str, boolean z) {
            x.i("MicroMsg.WebViewDownloadUI", "onTaskFinished id=%d, savedFilePath=%s, hasChangeUrl=%b", Long.valueOf(j), str, Boolean.valueOf(z));
            Toast.makeText(WebViewDownloadUI.this.mController.xRr, WebViewDownloadUI.this.getString(R.l.eWT), 1).show();
            WebViewDownloadUI.this.finish();
        }

        public final void c(long j, int i, boolean z) {
            x.i("MicroMsg.WebViewDownloadUI", "onTaskFailed id=%d, errCode=%d, hasChangeUrl=%b", Long.valueOf(j), Integer.valueOf(i), Boolean.valueOf(z));
            Toast.makeText(WebViewDownloadUI.this.mController.xRr, WebViewDownloadUI.this.getString(R.l.eWQ), 1).show();
            WebViewDownloadUI.this.finish();
        }

        public final void onTaskRemoved(long j) {
            x.i("MicroMsg.WebViewDownloadUI", "onTaskRemoved id=%d", Long.valueOf(j));
            WebViewDownloadUI.this.finish();
        }

        public final void onTaskPaused(long j) {
            x.i("MicroMsg.WebViewDownloadUI", "onTaskPaused id=%d", Long.valueOf(j));
        }

        public final void cl(long j) {
        }

        public final void k(long j, String str) {
            x.i("MicroMsg.WebViewDownloadUI", "onTaskResumed id=%d, savedFilePath=%s", Long.valueOf(j), str);
        }
    };

    private enum a {
        TO_DOWNLOAD,
        DOWNLOADING
    }

    static /* synthetic */ void a(WebViewDownloadUI webViewDownloadUI, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        b gqVar = new gq();
        gqVar.fxE.url = str;
        gqVar.fxE.frM = str2;
        gqVar.fxE.extInfo = str3;
        gqVar.fxE.appId = str4;
        com.tencent.mm.sdk.b.a.xmy.m(gqVar);
        g.pWK.h(14217, str4, Integer.valueOf(2), str6, str, Integer.valueOf(0));
        com.tencent.mm.plugin.downloader.model.g.a aVar = new com.tencent.mm.plugin.downloader.model.g.a();
        aVar.yr(str);
        aVar.ys(str5);
        aVar.yt(str7);
        aVar.yu(str2);
        aVar.setAppId(str4);
        aVar.cu(str8);
        aVar.et(true);
        aVar.oP(webViewDownloadUI.lyj);
        long a = f.aAK().a(aVar.lyp);
        x.i("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick, lastDownloadId = %d, downloadId=%d", Long.valueOf(webViewDownloadUI.jfS), Long.valueOf(a));
        webViewDownloadUI.jfS = a;
        b iVar = new i();
        iVar.fnQ.fnS = a;
        iVar.fnQ.fnR = false;
        iVar.fnQ.scene = webViewDownloadUI.tDN;
        com.tencent.mm.sdk.b.a.xmy.m(iVar);
        webViewDownloadUI.tDC = true;
        if (a <= 0) {
            Toast.makeText(webViewDownloadUI.mController.xRr, webViewDownloadUI.getString(R.l.eWQ), 1).show();
            webViewDownloadUI.finish();
            return;
        }
        Toast.makeText(webViewDownloadUI.mController.xRr, webViewDownloadUI.getString(R.l.eWL), 1).show();
        webViewDownloadUI.a(a.DOWNLOADING);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        setMMTitle(getString(R.l.eWV));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                WebViewDownloadUI.this.finish();
                return true;
            }
        });
        overridePendingTransition(com.tencent.mm.ui.MMFragmentActivity.a.xSL, com.tencent.mm.ui.MMFragmentActivity.a.xSM);
        this.tDI = (Button) findViewById(R.h.ccJ);
        this.tDJ = (TextView) findViewById(R.h.ccz);
        TextView textView = (TextView) findViewById(R.h.ccU);
        this.tDM = (TextView) findViewById(R.h.ccP);
        ImageView imageView = (ImageView) findViewById(R.h.ccS);
        this.lsa = (TextView) findViewById(R.h.ccT);
        a(a.TO_DOWNLOAD);
        final String stringExtra = getIntent().getStringExtra("task_name");
        final String stringExtra2 = getIntent().getStringExtra("task_url");
        final String stringExtra3 = getIntent().getStringExtra("alternative_url");
        long longExtra = getIntent().getLongExtra("task_size", 0);
        final String stringExtra4 = getIntent().getStringExtra("file_md5");
        final String stringExtra5 = getIntent().getStringExtra("extInfo");
        String stringExtra6 = getIntent().getStringExtra("fileType");
        final String stringExtra7 = getIntent().getStringExtra("appid");
        final String stringExtra8 = getIntent().getStringExtra("package_name");
        String stringExtra9 = getIntent().getStringExtra("thumb_url");
        CharSequence stringExtra10 = getIntent().getStringExtra("title");
        final String stringExtra11 = getIntent().getStringExtra("page_url");
        this.tDN = getIntent().getIntExtra("page_scene", 0);
        g.pWK.h(14217, stringExtra7, Integer.valueOf(1), stringExtra11, stringExtra2, Integer.valueOf(0));
        this.lyj = bi.getInt(stringExtra6, 1);
        if (bi.oN(stringExtra10)) {
            stringExtra10 = bi.oM(stringExtra);
        }
        if (!bi.oN(stringExtra10)) {
            textView.setText(stringExtra10);
            textView.setVisibility(0);
        }
        if (longExtra > 0) {
            this.tDL = bi.fL(longExtra);
            this.tDM.setText(this.tDL);
            this.tDI.setText(getString(R.l.eWN, new Object[]{this.tDL}));
        }
        com.tencent.mm.ap.a.a PG = com.tencent.mm.ap.o.PG();
        com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
        aVar.hFA = R.k.dBT;
        aVar.hFl = true;
        PG.a(stringExtra9, imageView, aVar.PQ());
        this.tDI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick state=%s", WebViewDownloadUI.this.tDK);
                switch (WebViewDownloadUI.this.tDK) {
                    case TO_DOWNLOAD:
                        if (!ao.isNetworkConnected(WebViewDownloadUI.this.mContext)) {
                            Toast.makeText(WebViewDownloadUI.this.mContext, WebViewDownloadUI.this.getString(R.l.emu), 0).show();
                            x.i("MicroMsg.WebViewDownloadUI", "startDownload fail, network not ready");
                            return;
                        } else if (ao.isWifi(WebViewDownloadUI.this.mContext)) {
                            WebViewDownloadUI.a(WebViewDownloadUI.this, stringExtra2, stringExtra4, stringExtra5, stringExtra7, stringExtra3, stringExtra11, stringExtra, stringExtra8);
                            return;
                        } else {
                            g.pWK.h(14217, stringExtra7, Integer.valueOf(4), stringExtra11, stringExtra2, Integer.valueOf(0));
                            h.a(WebViewDownloadUI.this, WebViewDownloadUI.this.getString(R.l.eWR), WebViewDownloadUI.this.getString(R.l.eWS), WebViewDownloadUI.this.getString(R.l.eWM), WebViewDownloadUI.this.getString(R.l.dEy), false, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    g.pWK.h(14217, stringExtra7, Integer.valueOf(5), stringExtra11, stringExtra2, Integer.valueOf(0));
                                    WebViewDownloadUI.a(WebViewDownloadUI.this, stringExtra2, stringExtra4, stringExtra5, stringExtra7, stringExtra3, stringExtra11, stringExtra, stringExtra8);
                                    dialogInterface.dismiss();
                                }
                            }, new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    g.pWK.h(14217, stringExtra7, Integer.valueOf(6), stringExtra11, stringExtra2, Integer.valueOf(0));
                                    dialogInterface.dismiss();
                                }
                            }, R.e.buj);
                            return;
                        }
                    default:
                        x.e("MicroMsg.WebViewDownloadUI", "downloadOpBtn.onClick unexpected download state");
                        return;
                }
            }
        });
        this.tDJ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, downloadId = %d, state=%s", Long.valueOf(WebViewDownloadUI.this.jfS), WebViewDownloadUI.this.tDK);
                g.pWK.h(14217, stringExtra7, Integer.valueOf(3), stringExtra11, stringExtra2, Integer.valueOf(0));
                if (WebViewDownloadUI.this.jfS <= 0) {
                    x.e("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask fail, unexpected branch! ");
                } else {
                    x.i("MicroMsg.WebViewDownloadUI", "doCancelDownloadTask, ret = %d", Integer.valueOf(f.aAK().bY(WebViewDownloadUI.this.jfS)));
                    if (f.aAK().bY(WebViewDownloadUI.this.jfS) > 0) {
                        Toast.makeText(WebViewDownloadUI.this.mController.xRr, WebViewDownloadUI.this.getString(R.l.eWP), 1).show();
                        WebViewDownloadUI.this.finish();
                        return;
                    }
                }
                Toast.makeText(WebViewDownloadUI.this.mController.xRr, WebViewDownloadUI.this.getString(R.l.eWO), 1).show();
            }
        });
        f.aAK();
        c.a(this.tDO);
    }

    protected void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.WebViewDownloadUI", "onDestroy hasCallback=%b", Boolean.valueOf(this.tDC));
        if (!this.tDC) {
            b iVar = new i();
            iVar.fnQ.fnR = true;
            iVar.fnQ.scene = this.tDN;
            com.tencent.mm.sdk.b.a.xmy.m(iVar);
            this.tDC = true;
        }
        f.aAK();
        c.b(this.tDO);
    }

    protected final int getLayoutId() {
        return R.i.dum;
    }

    private void a(a aVar) {
        x.i("MicroMsg.WebViewDownloadUI", "setDownloadState old=%s new=%s", this.tDK, aVar);
        this.tDK = aVar;
        switch (this.tDK) {
            case TO_DOWNLOAD:
                this.tDI.setVisibility(0);
                this.lsa.setVisibility(8);
                this.tDJ.setVisibility(8);
                break;
            case DOWNLOADING:
                this.tDI.setVisibility(8);
                this.tDJ.setVisibility(0);
                this.lsa.setVisibility(0);
                if (!bi.oN(this.tDL)) {
                    this.tDM.setVisibility(0);
                    return;
                }
                break;
            default:
                return;
        }
        this.tDM.setVisibility(8);
    }
}
