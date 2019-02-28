package com.tencent.mm.ac;

import android.annotation.SuppressLint;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;
import org.xwalk.core.XWalkUpdater;

public final class e implements com.tencent.mm.ad.e {
    h hmF = null;
    b hmO = null;
    k hmP = null;
    boolean hmQ = false;
    private at hmR = null;

    public interface b {
        int ba(int i, int i2);
    }

    @SuppressLint({"DefaultLocale"})
    class a implements com.tencent.mm.sdk.platformtools.at.a {
        public h hmB = null;
        public String hmS = null;
        public boolean hmT = true;
        private com.tencent.mm.compatible.util.g.a hmU;

        public a(h hVar) {
            this.hmB = hVar;
            n.JF();
            this.hmS = d.x(hVar.getUsername(), true);
            this.hmU = new com.tencent.mm.compatible.util.g.a();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean JH() {
            /*
            r11 = this;
            r7 = 3;
            r9 = 2;
            r3 = 0;
            r1 = 0;
            r2 = 1;
            r0 = r11.hmB;
            if (r0 != 0) goto L_0x000b;
        L_0x0009:
            r0 = r1;
        L_0x000a:
            return r0;
        L_0x000b:
            r0 = r11.hmB;
            r5 = r0.JM();
            r0 = "";
            r4 = com.tencent.mm.kernel.g.Do();
            r4 = r4.CF();
            if (r4 == 0) goto L_0x0059;
        L_0x001e:
            r0 = "http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d";
            r4 = 4;
            r4 = new java.lang.Object[r4];
            r6 = com.tencent.mm.protocal.d.vHl;
            r6 = java.lang.Integer.valueOf(r6);
            r4[r1] = r6;
            com.tencent.mm.kernel.g.Do();
            r6 = com.tencent.mm.kernel.a.Cn();
            r6 = com.tencent.mm.a.o.getString(r6);
            r4[r2] = r6;
            r6 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r6 = com.tencent.mm.sdk.platformtools.ao.getNetTypeForStat(r6);
            r6 = java.lang.Integer.valueOf(r6);
            r4[r9] = r6;
            r6 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r6 = com.tencent.mm.sdk.platformtools.ao.getStrength(r6);
            r6 = java.lang.Integer.valueOf(r6);
            r4[r7] = r6;
            r0 = java.lang.String.format(r0, r4);
        L_0x0059:
            r4 = "MicroMsg.GetHDHeadImgHelper";
            r6 = "dkreferer dkavatar user: %s referer: %s  url:%s";
            r7 = new java.lang.Object[r7];
            r8 = r11.hmB;
            r8 = r8.getUsername();
            r7[r1] = r8;
            r7[r2] = r0;
            r7[r9] = r5;
            com.tencent.mm.sdk.platformtools.x.d(r4, r6, r7);
            r11.hmT = r2;
            r4 = 0;
            r6 = com.tencent.mm.network.b.a(r5, r4);	 Catch:{ Exception -> 0x0147 }
            r4 = "GET";
            r6.setRequestMethod(r4);	 Catch:{ Exception -> 0x014b }
            r4 = "referer";
            r6.setRequestProperty(r4, r0);	 Catch:{ Exception -> 0x014b }
            r0 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
            r6.setConnectTimeout(r0);	 Catch:{ Exception -> 0x014b }
            r0 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
            r6.setReadTimeout(r0);	 Catch:{ Exception -> 0x014b }
            r0 = com.tencent.mm.network.b.a(r6);	 Catch:{ Exception -> 0x014b }
            if (r0 == 0) goto L_0x00a5;
        L_0x0093:
            r0 = "MicroMsg.GetHDHeadImgHelper";
            r4 = "checkHttpConnection failed! url:%s";
            r7 = 1;
            r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x014b }
            r8 = 0;
            r7[r8] = r5;	 Catch:{ Exception -> 0x014b }
            com.tencent.mm.sdk.platformtools.x.e(r0, r4, r7);	 Catch:{ Exception -> 0x014b }
            r0 = r2;
            goto L_0x000a;
        L_0x00a5:
            r4 = r6.getInputStream();	 Catch:{ Exception -> 0x014b }
            if (r4 != 0) goto L_0x00bd;
        L_0x00ab:
            r0 = "MicroMsg.GetHDHeadImgHelper";
            r7 = "getInputStream failed. url:%s";
            r8 = 1;
            r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x014f }
            r9 = 0;
            r8[r9] = r5;	 Catch:{ Exception -> 0x014f }
            com.tencent.mm.sdk.platformtools.x.d(r0, r7, r8);	 Catch:{ Exception -> 0x014f }
            r0 = r2;
            goto L_0x000a;
        L_0x00bd:
            r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            r0 = new byte[r0];	 Catch:{ Exception -> 0x014f }
            r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014f }
            r5.<init>();	 Catch:{ Exception -> 0x014f }
            r7 = r11.hmS;	 Catch:{ Exception -> 0x014f }
            r5 = r5.append(r7);	 Catch:{ Exception -> 0x014f }
            r7 = ".tmp";
            r5 = r5.append(r7);	 Catch:{ Exception -> 0x014f }
            r5 = r5.toString();	 Catch:{ Exception -> 0x014f }
            r5 = com.tencent.mm.modelsfs.FileOp.iH(r5);	 Catch:{ Exception -> 0x014f }
        L_0x00db:
            r7 = r4.read(r0);	 Catch:{ Exception -> 0x00e7 }
            r8 = -1;
            if (r7 == r8) goto L_0x0112;
        L_0x00e2:
            r8 = 0;
            r5.write(r0, r8, r7);	 Catch:{ Exception -> 0x00e7 }
            goto L_0x00db;
        L_0x00e7:
            r0 = move-exception;
            r3 = r4;
            r4 = r5;
            r5 = r6;
        L_0x00eb:
            r6 = "MicroMsg.GetHDHeadImgHelper";
            r7 = "exception:%s";
            r8 = new java.lang.Object[r2];
            r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
            r8[r1] = r0;
            com.tencent.mm.sdk.platformtools.x.e(r6, r7, r8);
            r11.hmT = r2;
        L_0x00fe:
            if (r5 == 0) goto L_0x0105;
        L_0x0100:
            r0 = r5.aBw;	 Catch:{ Exception -> 0x0123 }
            r0.disconnect();	 Catch:{ Exception -> 0x0123 }
        L_0x0105:
            if (r3 == 0) goto L_0x010a;
        L_0x0107:
            r3.close();	 Catch:{ Exception -> 0x0123 }
        L_0x010a:
            if (r4 == 0) goto L_0x010f;
        L_0x010c:
            r4.close();	 Catch:{ Exception -> 0x0123 }
        L_0x010f:
            r0 = r2;
            goto L_0x000a;
        L_0x0112:
            r0 = 0;
            r11.hmT = r0;	 Catch:{ Exception -> 0x00e7 }
            r5.close();	 Catch:{ Exception -> 0x00e7 }
            r0 = r6.aBw;	 Catch:{ Exception -> 0x014f }
            r0.disconnect();	 Catch:{ Exception -> 0x014f }
            r4.close();	 Catch:{ Exception -> 0x0155 }
            r4 = r3;
            r5 = r3;
            goto L_0x00fe;
        L_0x0123:
            r0 = move-exception;
            r3 = "MicroMsg.GetHDHeadImgHelper";
            r4 = "exception:%s";
            r5 = new java.lang.Object[r2];
            r6 = com.tencent.mm.sdk.platformtools.bi.i(r0);
            r5[r1] = r6;
            com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);
            r3 = "MicroMsg.GetHDHeadImgHelper";
            r4 = "close conn failed : %s";
            r5 = new java.lang.Object[r2];
            r0 = r0.getMessage();
            r5[r1] = r0;
            com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);
            goto L_0x010f;
        L_0x0147:
            r0 = move-exception;
            r4 = r3;
            r5 = r3;
            goto L_0x00eb;
        L_0x014b:
            r0 = move-exception;
            r4 = r3;
            r5 = r6;
            goto L_0x00eb;
        L_0x014f:
            r0 = move-exception;
            r5 = r6;
            r10 = r3;
            r3 = r4;
            r4 = r10;
            goto L_0x00eb;
        L_0x0155:
            r0 = move-exception;
            r5 = r3;
            r10 = r3;
            r3 = r4;
            r4 = r10;
            goto L_0x00eb;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ac.e.a.JH():boolean");
        }

        public final boolean JI() {
            if (e.this.hmQ) {
                return false;
            }
            if (this.hmT || bi.oN(this.hmS)) {
                e.this.hmO.ba(4, -1);
                return false;
            }
            x.d("MicroMsg.GetHDHeadImgHelper", "dkavatar user:" + this.hmB.getUsername() + " urltime:" + this.hmU.zp());
            if (com.tencent.mm.y.ak.a.hhw != null) {
                com.tencent.mm.y.ak.a.hhw.aV((int) FileOp.mi(this.hmS + ".tmp"), 0);
            }
            FileOp.deleteFile(this.hmS);
            FileOp.at(this.hmS + ".tmp", this.hmS);
            k.ad(this.hmS, e.this.hmF.getUsername());
            e.this.hmO.ba(0, 0);
            return true;
        }
    }

    public e() {
        g.CN().a(158, (com.tencent.mm.ad.e) this);
    }

    public final void JJ() {
        g.CN().b(158, (com.tencent.mm.ad.e) this);
    }

    public final int a(String str, b bVar) {
        Assert.assertTrue("GetHDHeadImg must set callback", true);
        if (bi.oN(str)) {
            bVar.ba(3, XWalkUpdater.ERROR_SET_VERNUM);
            return XWalkUpdater.ERROR_SET_VERNUM;
        }
        String Xk;
        this.hmO = bVar;
        if (com.tencent.mm.storage.x.gB(str)) {
            Xk = com.tencent.mm.storage.x.Xk(str);
        } else {
            Xk = str;
        }
        this.hmF = n.JW().jp(Xk);
        x.d("MicroMsg.GetHDHeadImgHelper", "GetHDHeadImg: %s", Xk);
        if (this.hmF == null || !this.hmF.getUsername().equals(Xk)) {
            this.hmF = new h();
            this.hmF.username = Xk;
        }
        if (bi.oN(this.hmF.JM())) {
            x.w("MicroMsg.GetHDHeadImgHelper", "dkhurl [%s] has NO URL flag:%d !", str, Integer.valueOf(this.hmF.fWZ));
            this.hmP = new k(Xk);
            if (g.CN().a(this.hmP, 0)) {
                return 0;
            }
            bVar.ba(3, -102);
            return -102;
        }
        h hVar = this.hmF;
        if (this.hmR == null || this.hmR.cgG()) {
            this.hmR = new at(1, "get-hd-headimg", 1);
        }
        if (this.hmR.c(new a(hVar)) == 0) {
            return 0;
        }
        bVar.ba(3, -103);
        return -103;
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.hmO.ba(i, i2);
    }
}
