package com.tencent.mm.plugin.clean.ui.fileindexui;

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
import com.tencent.mm.f.a.jj;
import com.tencent.mm.plugin.clean.b.a;
import com.tencent.mm.plugin.clean.b.c;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
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
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONObject;

public class CleanNewUI extends MMActivity {
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
    private TextView lna;
    private LinearLayout lnb;
    private TextView lnc;
    private TextView lnd;
    private Button lne;
    private View lnf;
    private boolean lnh = false;
    private a lni;
    private long lnj = 0;
    private long lnk = 0;
    private long lnl = 0;
    private long lnm = 0;
    private c lnn = new c() {
        public final void bK(int i, int i2) {
            if (!CleanNewUI.this.lnh) {
                CleanNewUI.this.cq(i, i2);
            }
        }

        public final void a(long j, long j2, long j3, HashSet<String> hashSet, HashMap<String, Long> hashMap) {
            CleanNewUI.this.lnm = bi.Wy();
            CleanNewUI cleanNewUI = CleanNewUI.this;
            j.azc().lkH = j;
            j.azc().lkI = j2;
            j.azc().lkJ = j3;
            j.azc().llu = hashMap;
            j.azc().lli = hashSet;
            ah.y(new AnonymousClass8(j));
            g.pWK.a(714, 53, 1, false);
            long g = CleanNewUI.this.lnk - CleanNewUI.this.lnj;
            long i = CleanNewUI.this.lnm - CleanNewUI.this.lnl;
            x.d("MicroMsg.CleanNewUI", "scan cost wxfile[%d %d %d] folder[%d %d %d] all[%d]", Long.valueOf(CleanNewUI.this.lnk), Long.valueOf(CleanNewUI.this.lnj), Long.valueOf(g), Long.valueOf(CleanNewUI.this.lnm), Long.valueOf(CleanNewUI.this.lnl), Long.valueOf(i), Long.valueOf(g + i));
            g.pWK.h(14556, Integer.valueOf("newui_wxfile".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.this.lnj), Long.valueOf(CleanNewUI.this.lnk), Long.valueOf(g));
            g.pWK.h(14556, Integer.valueOf("newui_folder".hashCode()), Integer.valueOf(0), Long.valueOf(CleanNewUI.this.lnl), Long.valueOf(CleanNewUI.this.lnm), Long.valueOf(i));
            g.pWK.h(14556, Integer.valueOf("newui_all".hashCode()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(g + i));
        }
    };
    private com.tencent.mm.sdk.b.c<jj> lno = new com.tencent.mm.sdk.b.c<jj>() {
        {
            this.xmG = jj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jj jjVar = (jj) bVar;
            if (!(jjVar == null || jjVar.fAF == null)) {
                x.i("MicroMsg.CleanNewUI", "%s manual scan [%d %d %b]", CleanNewUI.this.atu(), Long.valueOf(jjVar.fAF.fAG), Long.valueOf(jjVar.fAF.fAH), Boolean.valueOf(jjVar.fAF.fdr));
                if (jjVar.fAF.fdr) {
                    CleanNewUI.this.lnk = bi.Wy();
                    CleanNewUI.this.azi();
                    g.pWK.a(714, 51, 1, false);
                } else {
                    int i = (int) (((((float) jjVar.fAF.fAG) * 1.0f) / ((float) jjVar.fAF.fAH)) * 100.0f);
                    CleanNewUI cleanNewUI = CleanNewUI.this;
                    if (i <= 0) {
                        i = 0;
                    }
                    cleanNewUI.cq(i, 100);
                }
            }
            return false;
        }
    };

    /* renamed from: com.tencent.mm.plugin.clean.ui.fileindexui.CleanNewUI$8 */
    class AnonymousClass8 implements Runnable {
        final /* synthetic */ long lnr;

        AnonymousClass8(long j) {
            this.lnr = j;
        }

        public final void run() {
            CleanNewUI cleanNewUI = CleanNewUI.this;
            long j = this.lnr;
            j.azc();
            cleanNewUI.q(j, j.ayJ());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.dTT);
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
        this.lmY.setEnabled(false);
        this.lmZ = (Button) findViewById(R.h.cZp);
        this.lmZ.setVisibility(8);
        this.lna = (TextView) findViewById(R.h.cDA);
        this.lmY.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.i("MicroMsg.CleanNewUI", "%s goto clean msg ui", CleanNewUI.this.atu());
                g.pWK.a(714, 2, 1, false);
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
                g.pWK.a(714, 3, 1, false);
                if (!CleanNewUI.this.azd()) {
                    if (CleanNewUI.this.aze()) {
                        h.a(CleanNewUI.this, CleanNewUI.this.getString(R.l.dTP, new Object[]{bi.fL(CleanNewUI.this.llB)}), "", CleanNewUI.this.getString(R.l.dEK), CleanNewUI.this.getString(R.l.dEy), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                try {
                                    x.i("MicroMsg.CleanNewUI", "download url:%s, md5:%s", new URL(CleanNewUI.this.llF.getString(SlookSmartClipMetaTag.TAG_TYPE_URL)), CleanNewUI.this.llF.getString("md5"));
                                    com.tencent.mm.plugin.downloader.model.g.a aVar = new com.tencent.mm.plugin.downloader.model.g.a();
                                    aVar.yt("wesecure.apk");
                                    aVar.yr(r0.toString());
                                    aVar.et(true);
                                    aVar.yu(r1);
                                    aVar.oP(1);
                                    f.aAK().a(aVar.lyp);
                                } catch (Throwable e) {
                                    x.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
                                }
                                g.pWK.a(714, 4, 1, false);
                            }
                        }, null);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", "http://weixin.qq.com/cgi-bin/readtemplate?t=w_safe&qqpimenter=shoushen");
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("showShare", false);
                    d.b(CleanNewUI.this.mController.xRr, "webview", ".ui.tools.WebViewUI", intent);
                    g.pWK.a(714, 5, 1, false);
                }
            }
        });
        if (bi.chj() || com.tencent.mm.sdk.platformtools.f.fei == 1) {
            this.lne.setVisibility(8);
            this.lnf.setVisibility(0);
        }
        j.azc();
        long ayJ = j.ayJ();
        j.azc();
        this.lnc.setText(bi.by(ayJ - j.ayK()));
        this.lnd.setText(getString(R.l.dTS, new Object[]{bi.by(r4)}));
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(e.h.xMS, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
        sendBroadcast(intent);
        try {
            com.tencent.mm.sdk.c.b.b bVar = new com.tencent.mm.sdk.c.b.b();
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
                        g.pWK.a(714, 6, 1, false);
                    }
                }
            }, new ag());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanNewUI", e, e.getMessage(), new Object[0]);
        }
        if (com.tencent.mm.plugin.i.b.atn().atq()) {
            x.i("MicroMsg.CleanNewUI", "%s it scan finish", atu());
            this.lnh = false;
            azi();
            this.lna.setText(getString(R.l.dDS, new Object[]{"0%"}));
            g.pWK.a(714, 50, 1, false);
        } else {
            x.w("MicroMsg.CleanNewUI", "%s it scan not finish", atu());
            this.lnj = bi.Wy();
            this.lnh = true;
            com.tencent.mm.sdk.b.a.xmy.a(this.lno);
            com.tencent.mm.plugin.i.b.atn().eb(true);
            azh();
            cq(0, 100);
        }
        g.pWK.a(714, 1, 1, false);
    }

    public void onResume() {
        super.onResume();
        if (this.lnm > 0 && j.azc().lkH != 0) {
            long j = j.azc().lkH;
            j.azc();
            q(j, j.ayJ());
        }
    }

    protected void onDestroy() {
        boolean z = false;
        super.onDestroy();
        x.i("MicroMsg.CleanNewUI", "%s stop maunal scan needScanWxFileIndex[%b]", atu(), Boolean.valueOf(this.lnh));
        if (this.lnh) {
            com.tencent.mm.sdk.b.a.xmy.c(this.lno);
            com.tencent.mm.plugin.i.b atn = com.tencent.mm.plugin.i.b.atn();
            String str = "MicroMsg.CalcWxService";
            String str2 = "%s stop manual scan now manualScanTask[%b]";
            Object[] objArr = new Object[2];
            objArr[0] = atn.atu();
            if (atn.kNu != null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            atn.i(new Runnable() {
                public final void run() {
                    b.this.kNt = false;
                    if (b.this.kNu != null) {
                        if (b.this.kNp != null) {
                            b.this.kNp;
                            ah.K(b.this.kNu);
                        }
                        b.this.kNu.isStop = true;
                        b.this.kNu = null;
                        g.pWK.a(664, 8, 1, false);
                    }
                }
            });
        }
        if (this.lni != null) {
            this.lni.stop();
        }
    }

    private void q(long j, long j2) {
        this.lmZ.setEnabled(true);
        this.lna.setVisibility(8);
        this.lmW.setVisibility(0);
        this.lmX.setVisibility(0);
        this.lmY.setEnabled(true);
        this.lmW.setText(bi.by(j));
        if (((int) ((100 * j) / j2)) > 0) {
            this.lmX.setText(getString(R.l.dUa, new Object[]{r0 + "%"}));
            return;
        }
        this.lmX.setText(R.l.dUb);
    }

    private void azh() {
        this.lmZ.setEnabled(false);
        this.lmW.setVisibility(8);
        this.lmX.setVisibility(8);
        this.lna.setVisibility(0);
    }

    private void azi() {
        this.lni = new a(this.lnn);
        this.lnl = bi.Wy();
        com.tencent.mm.sdk.f.e.post(this.lni, "cleanUI_calc");
        azh();
        g.pWK.a(714, 52, 1, false);
    }

    protected final int getLayoutId() {
        return R.i.deG;
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
                g.pWK.a(714, 7, 1, false);
                return true;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CleanNewUI", e, "", new Object[0]);
        }
        return true;
    }

    public final void cq(final int i, final int i2) {
        ah.y(new Runnable() {
            public final void run() {
                CleanNewUI.this.lna.setText(CleanNewUI.this.getString(R.l.dDS, new Object[]{((i * 100) / i2) + "%"}));
            }
        });
    }

    private String atu() {
        return hashCode();
    }
}
