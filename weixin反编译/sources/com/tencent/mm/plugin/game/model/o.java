package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.x;

public final class o {
    public int mode = 1;
    public d nhC;
    public boolean nhD = false;
    public int progress = 0;
    public int status = 0;

    public o(d dVar) {
        this.nhC = dVar;
    }

    public final void cQ(Context context) {
        if (this.nhC != null) {
            int i = this.nhC.fRG;
            int i2 = this.nhC.fRG;
            x.i("MicroMsg.GameDownloadInfo", "AppId: %s, Initial downloadMode: %d", this.nhC.field_appId, Integer.valueOf(i));
            if (i == 2) {
                i2 = 3;
            }
            if (i2 == 3 && !g.m(context, "wx3909f6add1206543")) {
                i2 = 1;
            }
            if (i2 != 1) {
                FileDownloadTaskInfo yo = f.aAK().yo(this.nhC.field_appId);
                if (yo.status == 1 || yo.status == 2 || yo.status == 3) {
                    i2 = 1;
                }
            }
            this.mode = i2;
            x.i("MicroMsg.GameDownloadInfo", "AppId: %s, Final downloadMode: %d", this.nhC.field_appId, Integer.valueOf(i2));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aQQ() {
        /*
        r10 = this;
        r9 = 3;
        r8 = 2;
        r7 = 1;
        r6 = 0;
        r0 = r10.nhC;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = r10.mode;
        switch(r0) {
            case 1: goto L_0x0032;
            case 2: goto L_0x00b2;
            case 3: goto L_0x00b2;
            default: goto L_0x000e;
        };
    L_0x000e:
        r10.status = r6;
    L_0x0010:
        r0 = "MicroMsg.GameDownloadInfo";
        r1 = "Updating Download Status, AppId: %s, downloadMode: %d, downloadStatus: %d";
        r2 = new java.lang.Object[r9];
        r3 = r10.nhC;
        r3 = r3.field_appId;
        r2[r6] = r3;
        r3 = r10.mode;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r7] = r3;
        r3 = r10.status;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r8] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        goto L_0x0008;
    L_0x0032:
        r0 = com.tencent.mm.plugin.downloader.model.f.aAK();
        r1 = r10.nhC;
        r1 = r1.field_appId;
        r0 = r0.yo(r1);
        r1 = r0.lyv;
        if (r1 == 0) goto L_0x0045;
    L_0x0042:
        r10.status = r6;
        goto L_0x0008;
    L_0x0045:
        r2 = r0.fxb;
        r4 = 0;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 == 0) goto L_0x007a;
    L_0x004d:
        r2 = r0.fxa;
        r2 = (double) r2;
        r4 = r0.fxb;
        r4 = (double) r4;
        r2 = r2 / r4;
        r4 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r2 = r2 * r4;
        r1 = (int) r2;
        r10.progress = r1;
    L_0x005a:
        r1 = "MicroMsg.GameDownloadInfo";
        r2 = new java.lang.StringBuilder;
        r3 = "status = ";
        r2.<init>(r3);
        r3 = r0.status;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.d(r1, r2);
        r1 = r0.status;
        switch(r1) {
            case 0: goto L_0x0083;
            case 1: goto L_0x007d;
            case 2: goto L_0x0080;
            case 3: goto L_0x0086;
            case 4: goto L_0x009c;
            default: goto L_0x0077;
        };
    L_0x0077:
        r10.status = r6;
        goto L_0x0010;
    L_0x007a:
        r10.progress = r6;
        goto L_0x005a;
    L_0x007d:
        r10.status = r7;
        goto L_0x0010;
    L_0x0080:
        r10.status = r8;
        goto L_0x0010;
    L_0x0083:
        r10.status = r6;
        goto L_0x0010;
    L_0x0086:
        r1 = r0.path;
        r1 = com.tencent.mm.a.e.bO(r1);
        if (r1 == 0) goto L_0x0091;
    L_0x008e:
        r10.status = r9;
        goto L_0x0010;
    L_0x0091:
        r1 = com.tencent.mm.plugin.downloader.model.f.aAK();
        r2 = r0.id;
        r1.bY(r2);
        goto L_0x000e;
    L_0x009c:
        r0 = r10.progress;
        if (r0 == 0) goto L_0x00ae;
    L_0x00a0:
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r0 = com.tencent.mm.sdk.platformtools.ao.isConnected(r0);
        if (r0 != 0) goto L_0x00ae;
    L_0x00aa:
        r10.status = r8;
        goto L_0x0010;
    L_0x00ae:
        r10.status = r6;
        goto L_0x0010;
    L_0x00b2:
        r0 = r10.nhC;
        if (r0 == 0) goto L_0x0008;
    L_0x00b6:
        com.tencent.mm.plugin.game.model.bj.aRF();
        r0 = r10.nhC;
        r0 = r0.fRI;
        r0 = com.tencent.mm.plugin.game.model.bj.CF(r0);
        r1 = "MicroMsg.GameDownloadInfo";
        r2 = "query download status : %d";
        r3 = new java.lang.Object[r7];
        r4 = java.lang.Integer.valueOf(r0);
        r3[r6] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);
        switch(r0) {
            case 1: goto L_0x00d9;
            case 2: goto L_0x00d9;
            case 3: goto L_0x00dd;
            case 4: goto L_0x00e1;
            default: goto L_0x00d5;
        };
    L_0x00d5:
        r10.status = r6;
        goto L_0x0010;
    L_0x00d9:
        r10.status = r7;
        goto L_0x0010;
    L_0x00dd:
        r10.status = r8;
        goto L_0x0010;
    L_0x00e1:
        r10.status = r9;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.model.o.aQQ():void");
    }

    public final void aQR() {
        this.mode = 1;
        this.nhD = true;
    }
}
