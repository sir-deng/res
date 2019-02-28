package com.tencent.mm.plugin.clean.ui.newui;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.clean.c.c;
import com.tencent.mm.plugin.clean.c.g;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.c.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.e;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONObject;

public class CleanNewUI extends MMActivity implements g {
    private long llB;
    private String llC = "com.tencent.qqpimsecure";
    private String llD = "00B1208638DE0FCD3E920886D658DAF6";
    private String llE = "11206657";
    private JSONObject llF;
    private LinearLayout lmV;
    private TextView lmW;
    private TextView lmX;
    private Button lmY;
    private Button lmZ;
    private c lnE;
    private TextView lna;
    private LinearLayout lnb;
    private TextView lnc;
    private TextView lnd;
    private Button lne;
    private View lnf;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.dTZ);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                CleanNewUI.this.finish();
                return false;
            }
        });
        this.lmV = (LinearLayout) findViewById(R.h.cZs);
        this.lmW = (TextView) findViewById(R.h.cZt);
        this.lmX = (TextView) findViewById(R.h.cZu);
        this.lmY = (Button) findViewById(R.h.cZq);
        this.lmZ = (Button) findViewById(R.h.cZp);
        this.lmZ.setVisibility(8);
        this.lna = (TextView) findViewById(R.h.cDA);
        this.lmY.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.CleanNewUI", "goto clean msg ui");
                CleanNewUI.this.startActivityForResult(new Intent(CleanNewUI.this, CleanMsgUI.class), 0);
            }
        });
        this.lmZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.CleanNewUI", "clean wechat cache");
            }
        });
        this.lnb = (LinearLayout) findViewById(R.h.cwS);
        this.lnc = (TextView) findViewById(R.h.cwT);
        this.lnd = (TextView) findViewById(R.h.cwU);
        this.lne = (Button) findViewById(R.h.cEE);
        this.lnf = findViewById(R.h.cEF);
        this.lne.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.CleanNewUI", "qq mgr btn click");
                com.tencent.mm.plugin.report.service.g.pWK.a(282, 5, 1, false);
                if (!CleanNewUI.this.azd()) {
                    if (CleanNewUI.this.aze()) {
                        h.a(CleanNewUI.this, CleanNewUI.this.getString(R.l.dTP, new Object[]{bi.fL(CleanNewUI.this.llB)}), "", CleanNewUI.this.getString(R.l.dEK), CleanNewUI.this.getString(R.l.dEy), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                try {
                                    x.i("MicroMsg.CleanNewUI", "download url:%s, md5:%s", new URL(CleanNewUI.this.llF.getString(SlookSmartClipMetaTag.TAG_TYPE_URL)), CleanNewUI.this.llF.getString("md5"));
                                    a aVar = new a();
                                    aVar.yt("wesecure.apk");
                                    aVar.yr(r0.toString());
                                    aVar.et(true);
                                    aVar.yu(r1);
                                    aVar.oP(1);
                                    f.aAK().a(aVar.lyp);
                                } catch (Throwable e) {
                                    x.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
                                }
                                com.tencent.mm.plugin.report.service.g.pWK.a(282, 7, 1, false);
                            }
                        }, null);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen");
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("showShare", false);
                    d.b(CleanNewUI.this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
        if (bi.chj() || com.tencent.mm.sdk.platformtools.f.fei == 1) {
            this.lne.setVisibility(8);
            this.lnf.setVisibility(0);
        }
        this.lnc.setText(bi.by(c.ayJ() - c.ayK()));
        this.lnd.setText(getString(R.l.dTS, new Object[]{bi.by(r2)}));
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(e.h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
        sendBroadcast(intent);
        try {
            b bVar = new b();
            bVar.xmM = "https://";
            bVar.host = "jtool.qq.com";
            bVar.uri = "/channel?productId=31&channelId=102133";
            new com.tencent.mm.sdk.c.a((HttpURLConnection) new URL(bVar.getUrl()).openConnection()).a(bVar, new com.tencent.mm.sdk.c.b.c("") {
                public final void onComplete() {
                    x.d("MicroMsg.CleanNewUI", "request onComplete:%s", this.content);
                    try {
                        JSONObject jSONObject = new JSONObject(this.content);
                        as.Hm();
                        com.tencent.mm.y.c.Db().a(w.a.USERINFO_CLEANUI_QQMGRINFO_STRING, this.content);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
                        com.tencent.mm.plugin.report.service.g.pWK.a(282, 8, 1, false);
                    }
                }
            }, new ag());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanNewUI", e, e.getMessage(), new Object[0]);
        }
        com.tencent.mm.plugin.clean.c.d.a(new com.tencent.mm.plugin.clean.c.a.b());
        if (com.tencent.mm.plugin.clean.c.d.ayR() == null) {
            com.tencent.mm.plugin.clean.c.a.b ayP = com.tencent.mm.plugin.clean.c.d.ayP();
            if (ayP != null) {
                this.lnE = new c(ayP, this);
                com.tencent.mm.sdk.f.e.post(this.lnE, "CleanUI_clean");
                this.lmZ.setEnabled(false);
                this.lmW.setVisibility(8);
                this.lmX.setVisibility(8);
                this.lna.setVisibility(0);
                this.lna.setText(getString(R.l.dDS, new Object[]{"0%"}));
            }
        }
    }

    public void onResume() {
        super.onResume();
        if (com.tencent.mm.plugin.clean.c.d.ayR() != null) {
            q(com.tencent.mm.plugin.clean.c.d.ayS(), c.ayJ());
        }
    }

    private void q(long j, long j2) {
        this.lmZ.setEnabled(true);
        this.lna.setVisibility(8);
        this.lmW.setVisibility(0);
        this.lmX.setVisibility(0);
        this.lmW.setText(bi.by(j));
        int i = (int) ((100 * j) / j2);
        this.lmX.setText(getString(R.l.dUa, new Object[]{i + "%"}));
    }

    protected final int getLayoutId() {
        return R.i.deG;
    }

    public final void co(int i, int i2) {
        this.lna.setText(getString(R.l.dDS, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void a(long j, long j2, long j3, ArrayList<com.tencent.mm.plugin.clean.c.b> arrayList, long j4, HashSet<String> hashSet) {
        x.i("MicroMsg.CleanNewUI", "wechatSize[%d] accSize[%d] otherAccSize[%d]", Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
        com.tencent.mm.plugin.clean.c.d.bV(j);
        com.tencent.mm.plugin.clean.c.d.bS(j2);
        com.tencent.mm.plugin.clean.c.d.bU(j4);
        com.tencent.mm.plugin.clean.c.d.b(hashSet);
        com.tencent.mm.plugin.clean.c.d.bT(j3);
        com.tencent.mm.plugin.clean.c.d.m(arrayList);
        q(com.tencent.mm.plugin.clean.c.d.ayS(), c.ayJ());
    }

    private boolean aze() {
        as.Hm();
        String str = (String) com.tencent.mm.y.c.Db().get(w.a.USERINFO_CLEANUI_QQMGRINFO_STRING, (Object) "");
        if (bi.oN(str)) {
            return false;
        }
        try {
            this.llF = new JSONObject(str);
            this.llC = this.llF.getString(DownloadInfoColumns.PACKAGENAME);
            this.llF.get("md5");
            this.llE = this.llF.getString("launcherID");
            this.llD = this.llF.getString("signature");
            this.llF.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
            this.llB = this.llF.getLong("size");
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
            return false;
        }
    }

    private boolean azd() {
        aze();
        if (!p.m(this.mController.xRr, this.llC)) {
            return false;
        }
        Signature[] aX = p.aX(this, this.llC);
        if (aX == null || aX[0] == null) {
            return false;
        }
        String s = com.tencent.mm.a.g.s(aX[0].toByteArray());
        if (s == null || !s.equalsIgnoreCase(this.llD)) {
            return false;
        }
        try {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(this.llC);
            if (launchIntentForPackage != null) {
                Bundle bundle = new Bundle();
                p.g(bundle, this.llE);
                launchIntentForPackage.putExtras(bundle);
                launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                startActivity(launchIntentForPackage);
                com.tencent.mm.plugin.report.service.g.pWK.a(282, 6, 1, false);
                return true;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
        }
        return true;
    }
}
