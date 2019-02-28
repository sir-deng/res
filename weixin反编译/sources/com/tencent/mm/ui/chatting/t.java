package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.l;
import com.tencent.mm.bl.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public final class t {
    SharedPreferences hbz;
    public LinearLayout lNK = null;
    long lVx = -1;
    Context mContext;
    String pAa;
    String pAb;
    public String pzZ;
    public ChatFooterCustom yCJ;
    public FrameLayout yCK;
    public FrameLayout yCL;
    public TextView yCM;
    public ImageView yCN;
    a yCO = a.DEFAULT;
    public int yCP = -1;
    public boolean yCQ;
    String yCR = null;
    public String yCS;
    public OnClickListener yCT = new OnClickListener() {
        public final void onClick(View view) {
            new Intent().putExtra("composeType", 1);
            d.y(t.this.mContext, "qqmail", ".ui.ComposeUI");
        }
    };
    public OnClickListener yCU = new OnClickListener() {
        public final void onClick(View view) {
            t tVar;
            switch (t.this.yCO) {
                case NEED_INSTALL:
                    g.pWK.h(11288, Integer.valueOf(7));
                    tVar = t.this;
                    x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[installQQMail]");
                    bi.i(tVar.yCR, tVar.mContext);
                    return;
                case DOWNLOADING:
                    tVar = t.this;
                    x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[cancelDownload]");
                    f.aAK().bY(tVar.lVx);
                    tVar.csK();
                    return;
                case NEED_DOWNLOAD:
                    g.pWK.h(11288, Integer.valueOf(6));
                    t tVar2 = t.this;
                    if (!ao.isConnected(tVar2.mContext)) {
                        h.a(tVar2.mContext, com.tencent.mm.bu.a.ac(tVar2.mContext, R.l.dQA), "", com.tencent.mm.bu.a.ac(tVar2.mContext, R.l.dQv), null);
                        return;
                    } else if (ao.isWifi(tVar2.mContext)) {
                        h.a(tVar2.mContext, R.l.dQy, 0, R.l.dQt, R.l.dQs, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                t.b(t.this);
                            }
                        }, null);
                        return;
                    } else {
                        h.a(tVar2.mContext, R.l.dQx, 0, R.l.dQt, R.l.dQs, new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                t.b(t.this);
                            }
                        }, null);
                        return;
                    }
                case INSTALLED:
                    Intent launchIntentForPackage;
                    g.pWK.h(11288, Integer.valueOf(5));
                    t tVar3 = t.this;
                    x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[openQQMail]");
                    x.i("MicroMsg.ChattingQQMailFooterHandler", "mQQMailScheme = %s", tVar3.yCS);
                    if (bi.oN(tVar3.yCS)) {
                        launchIntentForPackage = tVar3.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
                    } else {
                        launchIntentForPackage = new Intent();
                        launchIntentForPackage.setData(Uri.parse(tVar3.yCS));
                        launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        if (VERSION.SDK_INT >= 11) {
                            launchIntentForPackage.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
                        }
                        if (!bi.k(tVar3.mContext, launchIntentForPackage)) {
                            launchIntentForPackage = tVar3.mContext.getPackageManager().getLaunchIntentForPackage("com.tencent.androidqqmail");
                        }
                    }
                    x.i("MicroMsg.ChattingQQMailFooterHandler", "intent = %s", launchIntentForPackage);
                    com.tencent.mm.by.a.post(new AnonymousClass5(launchIntentForPackage));
                    return;
                case NO_URL:
                    if (t.this.yCQ) {
                        t.a(t.this);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private com.tencent.mm.pluginsdk.ui.tools.i.a yCV = new com.tencent.mm.pluginsdk.ui.tools.i.a() {
        public final void vt(int i) {
            t.this.yCP = i;
            t.this.csL();
        }

        public final void ahO() {
            t.this.yCM.setText(R.l.dQD);
        }
    };

    /* renamed from: com.tencent.mm.ui.chatting.t$5 */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ Intent pAs;

        AnonymousClass5(Intent intent) {
            this.pAs = intent;
        }

        public final void run() {
            com.tencent.mm.pluginsdk.model.app.g.a(t.this.mContext, this.pAs, t.this.mContext.getString(R.l.dQD), null, null);
        }
    }

    private enum a {
        DEFAULT,
        NEED_DOWNLOAD,
        DOWNLOADING,
        NEED_INSTALL,
        INSTALLED,
        NO_URL
    }

    static /* synthetic */ void a(t tVar) {
        x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[handleNoUrl]");
        h.a(tVar.mContext, com.tencent.mm.bu.a.ac(tVar.mContext, R.l.dQz), "", com.tencent.mm.bu.a.ac(tVar.mContext, R.l.dQv), null);
    }

    static /* synthetic */ void b(t tVar) {
        x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initQQMailDownloadUrlAndMD5]");
        e.post(new Runnable() {
            public final void run() {
                Throwable th;
                Throwable e;
                HttpURLConnection httpURLConnection = null;
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(t.this.pzZ).openConnection();
                    try {
                        httpURLConnection2.setInstanceFollowRedirects(false);
                        httpURLConnection2.connect();
                        t.this.pAa = httpURLConnection2.getHeaderField("Location");
                        InputStream inputStream = httpURLConnection2.getInputStream();
                        int headerFieldInt = httpURLConnection2.getHeaderFieldInt("Content-Length", -1);
                        if (headerFieldInt <= 0) {
                            x.e("MicroMsg.ChattingQQMailFooterHandler", "error content-length");
                            inputStream.close();
                        } else {
                            byte[] bArr = new byte[headerFieldInt];
                            inputStream.read(bArr);
                            inputStream.close();
                            byte[] a = l.a(Base64.decode(bArr, 0), l.k(t.this.mContext, "rsa_public_key_forwx.pem"));
                            t.this.pAb = new String(a);
                            ah.y(new Runnable() {
                                public final void run() {
                                    if (bi.oN(t.this.pAa) || bi.oN(t.this.pAb)) {
                                        t.a(t.this);
                                        return;
                                    }
                                    t tVar = t.this;
                                    x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[downloadQQMail]");
                                    com.tencent.mm.plugin.downloader.model.g.a aVar = new com.tencent.mm.plugin.downloader.model.g.a();
                                    aVar.yr(tVar.pAa);
                                    aVar.yt(tVar.mContext.getResources().getString(R.l.dZt));
                                    aVar.yu(tVar.pAb);
                                    aVar.et(true);
                                    aVar.oP(1);
                                    tVar.lVx = f.aAK().a(aVar.lyp);
                                    if (tVar.lVx > 0) {
                                        tVar.hbz = tVar.mContext.getSharedPreferences("QQMAIL", 4);
                                        tVar.hbz.edit().putLong("qqmail_downloadid", tVar.lVx).apply();
                                        tVar.csK();
                                    }
                                }
                            });
                        }
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    } catch (Throwable e2) {
                        th = e2;
                        httpURLConnection = httpURLConnection2;
                        e = th;
                    } catch (Throwable e22) {
                        th = e22;
                        httpURLConnection = httpURLConnection2;
                        e = th;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw e;
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.ChattingQQMailFooterHandler", e, "", new Object[0]);
                        t.a(t.this);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw e;
                    }
                }
            }
        }, "QQMailDownloadUrlAndMD5");
    }

    public t(ChatFooterCustom chatFooterCustom) {
        this.mContext = chatFooterCustom.getContext();
        this.yCJ = chatFooterCustom;
    }

    public final void csJ() {
        if (this.yCO == a.INSTALLED) {
            this.yCN.setImageResource(R.k.dAx);
        } else {
            this.yCN.setImageResource(R.k.dAy);
        }
    }

    public final void csK() {
        a aVar;
        if (!p.m(this.mContext, "com.tencent.androidqqmail")) {
            this.hbz = this.mContext.getSharedPreferences("QQMAIL", 4);
            this.lVx = this.hbz.getLong("qqmail_downloadid", -1);
            if (this.lVx >= 0) {
                FileDownloadTaskInfo bZ = f.aAK().bZ(this.lVx);
                int i = bZ.status;
                this.yCR = bZ.path;
                switch (i) {
                    case 1:
                        aVar = a.DOWNLOADING;
                        break;
                    case 3:
                        if (!com.tencent.mm.a.e.bO(this.yCR)) {
                            if (!bi.oN(this.pzZ)) {
                                aVar = a.NEED_DOWNLOAD;
                                break;
                            } else {
                                aVar = a.NO_URL;
                                break;
                            }
                        }
                        aVar = a.NEED_INSTALL;
                        break;
                    default:
                        if (!bi.oN(this.pzZ)) {
                            aVar = a.NEED_DOWNLOAD;
                            break;
                        } else {
                            aVar = a.NO_URL;
                            break;
                        }
                }
            }
            aVar = bi.oN(this.pzZ) ? a.NO_URL : a.NEED_DOWNLOAD;
        } else {
            aVar = a.INSTALLED;
        }
        this.yCO = aVar;
        csJ();
        x.i("MicroMsg.ChattingQQMailFooterHandler", "dz[initRightBtnTv: status:%s]", this.yCO.toString());
        switch (this.yCO) {
            case NEED_INSTALL:
                this.yCM.setText(R.l.dQw);
                return;
            case DOWNLOADING:
                this.yCM.setText(R.l.dQu);
                return;
            case NEED_DOWNLOAD:
            case INSTALLED:
            case NO_URL:
                i.a(this.yCV);
                return;
            default:
                i.a(this.yCV);
                return;
        }
    }

    public final void csL() {
        if (this.yCP == 0) {
            this.yCM.setText(R.l.dQD);
        } else if (this.yCP > 99) {
            this.yCM.setText(R.l.dQC);
        } else {
            this.yCM.setText(String.format(com.tencent.mm.bu.a.ac(this.mContext, R.l.dQB), new Object[]{Integer.valueOf(this.yCP)}));
        }
    }
}
