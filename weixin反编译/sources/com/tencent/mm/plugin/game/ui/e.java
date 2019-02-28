package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.bj;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.z;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.k;
import java.util.Set;

public final class e {
    private static Object lock = new Object();
    private Context mContext;
    private Dialog nft;
    int niV = 0;
    String nqO = null;
    private i nra = null;
    private w nrb = null;
    private r nrc = null;
    private v nrd = null;
    OnClickListener nre = null;
    private int nrf = 3000;
    private al nrg = new al(Looper.getMainLooper(), new a() {
        public final boolean uG() {
            if (e.this.nft != null) {
                e.this.nft.cancel();
            }
            return true;
        }
    }, false);

    public e(Context context) {
        this.mContext = context;
    }

    public final void a(d dVar, o oVar) {
        if (dVar == null || oVar == null) {
            x.e("MicroMsg.GameActionBtnHandler", "Null appInfo or null downloadInfo");
            return;
        }
        View view = new View(this.mContext);
        view.setTag(dVar);
        x.i("MicroMsg.GameActionBtnHandler", "App Status: %d, Download Mode: %d, Download Status: %d", Integer.valueOf(dVar.status), Integer.valueOf(oVar.mode), Integer.valueOf(oVar.status));
        if (g.m(this.mContext, dVar.field_appId) || dVar.aQA()) {
            oVar.mode = 1;
        }
        if (oVar.mode == 3) {
            bj.aRF();
            int h = bj.h(this.mContext, "com.tencent.android.qqdownloader", dVar.fRM);
            x.i("MicroMsg.GameActionBtnHandler", "qqdownloader install status:[%d], yybSupportedVersionCode:[%d]", Integer.valueOf(h), Integer.valueOf(dVar.fRM));
            if (h == -1 || h == 1 || h == 2) {
                oVar.mode = 1;
            }
        }
        FileDownloadTaskInfo yo;
        switch (dVar.status) {
            case 0:
            case 3:
            case 4:
                c CB = SubCoreGameCenter.aRK().CB(dVar.field_appId);
                if (CB != null) {
                    x.i("MicroMsg.GameActionBtnHandler", "delete msg, appid = " + CB.field_appId);
                    SubCoreGameCenter.aRK().a(CB, new String[0]);
                }
                switch (oVar.mode) {
                    case 3:
                        yo = f.aAK().yo(dVar.field_appId);
                        if (yo != null && yo.id > 0) {
                            f.aAK().bY(yo.id);
                        }
                        if (this.nrb == null) {
                            this.nrb = new w(this.mContext);
                        }
                        w wVar = this.nrb;
                        int i = this.niV;
                        String str = this.nqO;
                        wVar.niV = i;
                        wVar.nqO = str;
                        this.nrb.onClick(view);
                        break;
                    case 4:
                        if (!bi.oN(dVar.fRD)) {
                            x.i("MicroMsg.GameActionBtnHandler", "gp download url is not null and download flag is download directly by gp store");
                            q.aY(this.mContext, dVar.fRD);
                            ap.a(this.mContext, dVar.scene, dVar.fGe, dVar.position, 25, dVar.field_appId, this.niV, dVar.fpi, this.nqO);
                            break;
                        }
                        break;
                    default:
                        x.d("MicroMsg.GameActionBtnHandler", "summertoken downloadInfo.mode[%d]", Integer.valueOf(oVar.mode));
                        if (this.nra == null) {
                            this.nra = new i(this.mContext);
                        }
                        this.nra.rg(this.niV);
                        this.nra.cU(this.nqO, "");
                        this.nra.onClick(view);
                        break;
                }
                if (dVar.ngK) {
                    Set cN = com.tencent.mm.plugin.game.model.g.cN(this.mContext);
                    if (!a(cN, dVar.field_appId)) {
                        if (oVar.mode != 3) {
                            View inflate = LayoutInflater.from(this.mContext).inflate(R.i.dkA, null);
                            ((LinearLayout) inflate.findViewById(R.h.cwl)).setGravity(17);
                            TextView textView = (TextView) inflate.findViewById(R.h.cwk);
                            TextView textView2 = (TextView) inflate.findViewById(R.h.cwo);
                            ((ImageView) inflate.findViewById(R.h.cwn)).setBackgroundResource(R.g.bBN);
                            textView.setText(R.l.emA);
                            textView2.setText(R.l.emz);
                            this.nft = new k(this.mContext, R.m.eZd);
                            this.nft.setContentView(inflate);
                            this.nft.setCancelable(true);
                            this.nft.setCanceledOnTouchOutside(true);
                            this.nft.show();
                            long j = (long) this.nrf;
                            this.nrg.K(j, j);
                        }
                        SubCoreGameCenter.aRN();
                        z.b(dVar.field_appId, 1, 0, null, null);
                        cN.add(dVar.field_appId);
                        this.mContext.getSharedPreferences("game_center_pref", 0).edit().putStringSet("show_download_gift_tips", cN).commit();
                        return;
                    }
                    return;
                }
                return;
            case 1:
                if (this.nrd == null) {
                    this.nrd = new v(this.mContext);
                    this.nrd.nBG = this.nre;
                }
                this.nrd.niV = this.niV;
                this.nrd.onClick(view);
                ap.a(this.mContext, dVar.scene, dVar.fGe, dVar.position, 9, dVar.field_appId, this.niV, dVar.fpi, this.nqO);
                return;
            case 2:
                yo = f.aAK().yo(dVar.field_appId);
                if (yo != null && yo.id > 0) {
                    f.aAK().bY(yo.id);
                }
                if (this.nrc == null) {
                    this.nrc = new r(this.mContext);
                }
                this.nrc.kKY = this.niV;
                this.nrc.nzB = dVar.fRH;
                this.nrc.onClick(view);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.widget.ProgressBar r8, android.widget.Button r9, com.tencent.mm.plugin.game.model.d r10, com.tencent.mm.plugin.game.model.o r11) {
        /*
        r7 = this;
        r4 = 3;
        r6 = 1;
        r3 = 12;
        r2 = 8;
        r5 = 0;
        if (r8 == 0) goto L_0x000b;
    L_0x0009:
        if (r9 != 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        r9.setEnabled(r6);
        r9.setVisibility(r5);
        r0 = r7.mContext;
        r0 = com.tencent.mm.pluginsdk.model.app.g.a(r0, r10);
        if (r0 == 0) goto L_0x007e;
    L_0x001a:
        r0 = r10.field_packageName;
        r0 = com.tencent.mm.plugin.game.d.c.CQ(r0);
        r1 = r10.versionCode;
        if (r1 <= r0) goto L_0x0068;
    L_0x0024:
        r1 = r11.status;
        if (r1 != r6) goto L_0x0052;
    L_0x0028:
        r8.setVisibility(r5);
        r1 = r11.progress;
        r8.setProgress(r1);
        r9.setVisibility(r2);
    L_0x0033:
        r1 = "MicroMsg.GameActionBtnHandler";
        r2 = "AppId: %s installed, local: %d, server: %d";
        r3 = new java.lang.Object[r4];
        r4 = r10.field_appId;
        r3[r5] = r4;
        r0 = java.lang.Integer.valueOf(r0);
        r3[r6] = r0;
        r0 = 2;
        r4 = r10.versionCode;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r0] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        goto L_0x000b;
    L_0x0052:
        r1 = r10.scene;
        if (r1 != r3) goto L_0x0062;
    L_0x0056:
        r1 = com.tencent.mm.R.l.emo;
        r9.setText(r1);
    L_0x005b:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x0033;
    L_0x0062:
        r1 = com.tencent.mm.R.l.emd;
        r9.setText(r1);
        goto L_0x005b;
    L_0x0068:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        r1 = r10.scene;
        if (r1 != r3) goto L_0x0078;
    L_0x0072:
        r1 = com.tencent.mm.R.l.emm;
        r9.setText(r1);
        goto L_0x0033;
    L_0x0078:
        r1 = com.tencent.mm.R.l.emL;
        r9.setText(r1);
        goto L_0x0033;
    L_0x007e:
        r0 = r10.aQA();
        if (r0 == 0) goto L_0x009c;
    L_0x0084:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        r0 = r10.scene;
        if (r0 != r3) goto L_0x0095;
    L_0x008e:
        r0 = com.tencent.mm.R.l.emm;
        r9.setText(r0);
        goto L_0x000b;
    L_0x0095:
        r0 = com.tencent.mm.R.l.emL;
        r9.setText(r0);
        goto L_0x000b;
    L_0x009c:
        r0 = r10.status;
        switch(r0) {
            case 0: goto L_0x00c7;
            case 1: goto L_0x014c;
            case 2: goto L_0x016d;
            case 3: goto L_0x017a;
            case 4: goto L_0x01e0;
            default: goto L_0x00a1;
        };
    L_0x00a1:
        r9.setVisibility(r2);
        r8.setVisibility(r2);
    L_0x00a7:
        r0 = "MicroMsg.GameActionBtnHandler";
        r1 = "updateBtnStateAndText: %s, Status: %d, Text: %s";
        r2 = new java.lang.Object[r4];
        r3 = r10.field_appId;
        r2[r5] = r3;
        r3 = r10.status;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r6] = r3;
        r3 = 2;
        r4 = r9.getText();
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        goto L_0x000b;
    L_0x00c7:
        if (r11 != 0) goto L_0x00d1;
    L_0x00c9:
        r9.setVisibility(r2);
        r8.setVisibility(r2);
        goto L_0x000b;
    L_0x00d1:
        r0 = r11.status;
        switch(r0) {
            case 0: goto L_0x00d7;
            case 1: goto L_0x0105;
            case 2: goto L_0x0125;
            case 3: goto L_0x013c;
            default: goto L_0x00d6;
        };
    L_0x00d6:
        goto L_0x00a7;
    L_0x00d7:
        r0 = r10.scene;
        if (r0 != r3) goto L_0x00ff;
    L_0x00db:
        r0 = r10.ngK;
        if (r0 == 0) goto L_0x00f9;
    L_0x00df:
        r0 = r10.field_appId;
        r1 = r7.mContext;
        r1 = com.tencent.mm.plugin.game.model.g.cN(r1);
        r0 = a(r1, r0);
        if (r0 != 0) goto L_0x00f9;
    L_0x00ed:
        r0 = com.tencent.mm.R.l.emt;
        r9.setText(r0);
    L_0x00f2:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00a7;
    L_0x00f9:
        r0 = com.tencent.mm.R.l.emH;
        r9.setText(r0);
        goto L_0x00f2;
    L_0x00ff:
        r0 = com.tencent.mm.R.l.emG;
        r9.setText(r0);
        goto L_0x00f2;
    L_0x0105:
        r0 = r11.mode;
        if (r0 != r4) goto L_0x0115;
    L_0x0109:
        r0 = com.tencent.mm.R.l.emJ;
        r9.setText(r0);
    L_0x010e:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00a7;
    L_0x0115:
        r0 = r11.mode;
        if (r0 != r6) goto L_0x00a7;
    L_0x0119:
        r0 = r11.progress;
        r8.setProgress(r0);
        r9.setVisibility(r2);
        r8.setVisibility(r5);
        goto L_0x00a7;
    L_0x0125:
        r0 = r10.scene;
        if (r0 != r3) goto L_0x0136;
    L_0x0129:
        r0 = com.tencent.mm.R.l.ems;
        r9.setText(r0);
    L_0x012e:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00a7;
    L_0x0136:
        r0 = com.tencent.mm.R.l.emI;
        r9.setText(r0);
        goto L_0x012e;
    L_0x013c:
        r0 = r10.scene;
        if (r0 != r3) goto L_0x0146;
    L_0x0140:
        r0 = com.tencent.mm.R.l.emF;
        r9.setText(r0);
        goto L_0x010e;
    L_0x0146:
        r0 = com.tencent.mm.R.l.emE;
        r9.setText(r0);
        goto L_0x010e;
    L_0x014c:
        r0 = r10.ngD;
        if (r0 == 0) goto L_0x0160;
    L_0x0150:
        r9.setEnabled(r5);
        r0 = com.tencent.mm.R.l.emb;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00a7;
    L_0x0160:
        r0 = com.tencent.mm.R.l.ema;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00a7;
    L_0x016d:
        r0 = com.tencent.mm.R.l.elZ;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00a7;
    L_0x017a:
        if (r11 != 0) goto L_0x0189;
    L_0x017c:
        r0 = com.tencent.mm.R.l.elY;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x000b;
    L_0x0189:
        r0 = r11.status;
        switch(r0) {
            case 0: goto L_0x0190;
            case 1: goto L_0x019d;
            case 2: goto L_0x01b9;
            case 3: goto L_0x01d0;
            default: goto L_0x018e;
        };
    L_0x018e:
        goto L_0x00a7;
    L_0x0190:
        r0 = com.tencent.mm.R.l.elY;
        r9.setText(r0);
    L_0x0195:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00a7;
    L_0x019d:
        r0 = r11.mode;
        if (r0 != r4) goto L_0x01a8;
    L_0x01a1:
        r0 = com.tencent.mm.R.l.emJ;
        r9.setText(r0);
        goto L_0x00a7;
    L_0x01a8:
        r0 = r11.mode;
        if (r0 != r6) goto L_0x00a7;
    L_0x01ac:
        r0 = r11.progress;
        r8.setProgress(r0);
        r9.setVisibility(r2);
        r8.setVisibility(r5);
        goto L_0x00a7;
    L_0x01b9:
        r0 = r10.scene;
        if (r0 != r3) goto L_0x01ca;
    L_0x01bd:
        r0 = com.tencent.mm.R.l.ems;
        r9.setText(r0);
    L_0x01c2:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00a7;
    L_0x01ca:
        r0 = com.tencent.mm.R.l.emI;
        r9.setText(r0);
        goto L_0x01c2;
    L_0x01d0:
        r0 = r10.scene;
        if (r0 != r3) goto L_0x01da;
    L_0x01d4:
        r0 = com.tencent.mm.R.l.emF;
        r9.setText(r0);
        goto L_0x0195;
    L_0x01da:
        r0 = com.tencent.mm.R.l.emE;
        r9.setText(r0);
        goto L_0x0195;
    L_0x01e0:
        r0 = com.tencent.mm.R.l.emc;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00a7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.ui.e.a(android.widget.ProgressBar, android.widget.Button, com.tencent.mm.plugin.game.model.d, com.tencent.mm.plugin.game.model.o):void");
    }

    private static boolean a(Set<String> set, String str) {
        if (set == null || set.isEmpty() || !set.contains(str)) {
            return false;
        }
        return true;
    }
}
