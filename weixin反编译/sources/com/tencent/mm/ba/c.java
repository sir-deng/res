package com.tencent.mm.ba;

import android.graphics.Bitmap;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class c {
    private static c hMi;
    private at hMj = null;

    class b implements com.tencent.mm.sdk.platformtools.at.a {
        private String hFn;
        private String hMk;
        private a hMl;
        private boolean success = false;
        private String username;

        public b(String str, String str2, a aVar) {
            this.username = str;
            this.hMk = str2;
            this.hMl = aVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean JH() {
            /*
            r11 = this;
            r6 = 3;
            r8 = 2;
            r3 = 0;
            r2 = 1;
            r1 = 0;
            r0 = r11.username;
            r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
            if (r0 == 0) goto L_0x000f;
        L_0x000d:
            r0 = r1;
        L_0x000e:
            return r0;
        L_0x000f:
            r0 = r11.username;
            r0 = com.tencent.mm.ba.c.lR(r0);
            r11.hFn = r0;
            r0 = "";
            r4 = com.tencent.mm.kernel.g.Do();
            r4 = r4.CF();
            if (r4 == 0) goto L_0x005f;
        L_0x0024:
            r0 = "http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d";
            r4 = 4;
            r4 = new java.lang.Object[r4];
            r5 = com.tencent.mm.protocal.d.vHl;
            r5 = java.lang.Integer.valueOf(r5);
            r4[r1] = r5;
            com.tencent.mm.kernel.g.Do();
            r5 = com.tencent.mm.kernel.a.Cn();
            r5 = com.tencent.mm.a.o.getString(r5);
            r4[r2] = r5;
            r5 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r5 = com.tencent.mm.sdk.platformtools.ao.getNetTypeForStat(r5);
            r5 = java.lang.Integer.valueOf(r5);
            r4[r8] = r5;
            r5 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r5 = com.tencent.mm.sdk.platformtools.ao.getStrength(r5);
            r5 = java.lang.Integer.valueOf(r5);
            r4[r6] = r5;
            r0 = java.lang.String.format(r0, r4);
        L_0x005f:
            r4 = "MicroMsg.RemarkImageStorage";
            r5 = "get remark image user: %s referer: %s  url:%s";
            r6 = new java.lang.Object[r6];
            r7 = r11.username;
            r6[r1] = r7;
            r6[r2] = r0;
            r7 = r11.hMk;
            r6[r8] = r7;
            com.tencent.mm.sdk.platformtools.x.d(r4, r5, r6);
            r11.success = r1;
            r4 = r11.hMk;	 Catch:{ Exception -> 0x0249, all -> 0x01ec }
            r5 = 0;
            r6 = com.tencent.mm.network.b.a(r4, r5);	 Catch:{ Exception -> 0x0249, all -> 0x01ec }
            r4 = "GET";
            r6.setRequestMethod(r4);	 Catch:{ Exception -> 0x024e, all -> 0x023a }
            r4 = "referer";
            r6.setRequestProperty(r4, r0);	 Catch:{ Exception -> 0x024e, all -> 0x023a }
            r0 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
            r6.setConnectTimeout(r0);	 Catch:{ Exception -> 0x024e, all -> 0x023a }
            r0 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
            r6.setReadTimeout(r0);	 Catch:{ Exception -> 0x024e, all -> 0x023a }
            r0 = com.tencent.mm.network.b.a(r6);	 Catch:{ Exception -> 0x024e, all -> 0x023a }
            if (r0 == 0) goto L_0x00c5;
        L_0x0099:
            r0 = "MicroMsg.RemarkImageStorage";
            r4 = "checkHttpConnection failed! url:%s";
            r5 = 1;
            r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x024e, all -> 0x023a }
            r7 = 0;
            r8 = r11.hMk;	 Catch:{ Exception -> 0x024e, all -> 0x023a }
            r5[r7] = r8;	 Catch:{ Exception -> 0x024e, all -> 0x023a }
            com.tencent.mm.sdk.platformtools.x.e(r0, r4, r5);	 Catch:{ Exception -> 0x024e, all -> 0x023a }
            r0 = r6.aBw;	 Catch:{ Exception -> 0x00b2 }
            r0.disconnect();	 Catch:{ Exception -> 0x00b2 }
        L_0x00af:
            r0 = r2;
            goto L_0x000e;
        L_0x00b2:
            r0 = move-exception;
            r3 = "MicroMsg.RemarkImageStorage";
            r4 = "exception:%s";
            r5 = new java.lang.Object[r2];
            r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
            r5[r1] = r0;
            com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);
            goto L_0x00af;
        L_0x00c5:
            r4 = r6.getInputStream();	 Catch:{ Exception -> 0x024e, all -> 0x023a }
            if (r4 != 0) goto L_0x010f;
        L_0x00cb:
            r0 = "MicroMsg.RemarkImageStorage";
            r5 = "getInputStream failed. url:%s";
            r7 = 1;
            r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0253, all -> 0x023d }
            r8 = 0;
            r9 = r11.hMk;	 Catch:{ Exception -> 0x0253, all -> 0x023d }
            r7[r8] = r9;	 Catch:{ Exception -> 0x0253, all -> 0x023d }
            com.tencent.mm.sdk.platformtools.x.d(r0, r5, r7);	 Catch:{ Exception -> 0x0253, all -> 0x023d }
            r0 = r6.aBw;	 Catch:{ Exception -> 0x00e9 }
            r0.disconnect();	 Catch:{ Exception -> 0x00e9 }
        L_0x00e1:
            if (r4 == 0) goto L_0x00e6;
        L_0x00e3:
            r4.close();	 Catch:{ Exception -> 0x00fc }
        L_0x00e6:
            r0 = r2;
            goto L_0x000e;
        L_0x00e9:
            r0 = move-exception;
            r3 = "MicroMsg.RemarkImageStorage";
            r5 = "exception:%s";
            r6 = new java.lang.Object[r2];
            r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
            r6[r1] = r0;
            com.tencent.mm.sdk.platformtools.x.e(r3, r5, r6);
            goto L_0x00e1;
        L_0x00fc:
            r0 = move-exception;
            r3 = "MicroMsg.RemarkImageStorage";
            r4 = "exception:%s";
            r5 = new java.lang.Object[r2];
            r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
            r5[r1] = r0;
            com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);
            goto L_0x00e6;
        L_0x010f:
            r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            r0 = new byte[r0];	 Catch:{ Exception -> 0x0253, all -> 0x023d }
            r5 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0253, all -> 0x023d }
            r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0253, all -> 0x023d }
            r7.<init>();	 Catch:{ Exception -> 0x0253, all -> 0x023d }
            r8 = r11.hFn;	 Catch:{ Exception -> 0x0253, all -> 0x023d }
            r7 = r7.append(r8);	 Catch:{ Exception -> 0x0253, all -> 0x023d }
            r8 = ".tmp";
            r7 = r7.append(r8);	 Catch:{ Exception -> 0x0253, all -> 0x023d }
            r7 = r7.toString();	 Catch:{ Exception -> 0x0253, all -> 0x023d }
            r5.<init>(r7);	 Catch:{ Exception -> 0x0253, all -> 0x023d }
        L_0x012e:
            r3 = r4.read(r0);	 Catch:{ Exception -> 0x013a, all -> 0x0242 }
            r7 = -1;
            if (r3 == r7) goto L_0x0168;
        L_0x0135:
            r7 = 0;
            r5.write(r0, r7, r3);	 Catch:{ Exception -> 0x013a, all -> 0x0242 }
            goto L_0x012e;
        L_0x013a:
            r0 = move-exception;
            r3 = r4;
            r4 = r5;
            r5 = r6;
        L_0x013e:
            r6 = "MicroMsg.RemarkImageStorage";
            r7 = "exception:%s";
            r8 = 1;
            r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x0246 }
            r9 = 0;
            r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);	 Catch:{ all -> 0x0246 }
            r8[r9] = r0;	 Catch:{ all -> 0x0246 }
            com.tencent.mm.sdk.platformtools.x.e(r6, r7, r8);	 Catch:{ all -> 0x0246 }
            r0 = 0;
            r11.success = r0;	 Catch:{ all -> 0x0246 }
            if (r5 == 0) goto L_0x015b;
        L_0x0156:
            r0 = r5.aBw;	 Catch:{ Exception -> 0x01b2 }
            r0.disconnect();	 Catch:{ Exception -> 0x01b2 }
        L_0x015b:
            if (r3 == 0) goto L_0x0160;
        L_0x015d:
            r3.close();	 Catch:{ Exception -> 0x01c5 }
        L_0x0160:
            if (r4 == 0) goto L_0x0165;
        L_0x0162:
            r4.close();	 Catch:{ Exception -> 0x01d8 }
        L_0x0165:
            r0 = r2;
            goto L_0x000e;
        L_0x0168:
            r0 = 1;
            r11.success = r0;	 Catch:{ Exception -> 0x013a, all -> 0x0242 }
            r0 = r6.aBw;	 Catch:{ Exception -> 0x018c }
            r0.disconnect();	 Catch:{ Exception -> 0x018c }
        L_0x0170:
            if (r4 == 0) goto L_0x0175;
        L_0x0172:
            r4.close();	 Catch:{ Exception -> 0x019f }
        L_0x0175:
            r5.close();	 Catch:{ Exception -> 0x0179 }
            goto L_0x0165;
        L_0x0179:
            r0 = move-exception;
            r3 = "MicroMsg.RemarkImageStorage";
            r4 = "exception:%s";
            r5 = new java.lang.Object[r2];
            r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
            r5[r1] = r0;
            com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);
            goto L_0x0165;
        L_0x018c:
            r0 = move-exception;
            r3 = "MicroMsg.RemarkImageStorage";
            r6 = "exception:%s";
            r7 = new java.lang.Object[r2];
            r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
            r7[r1] = r0;
            com.tencent.mm.sdk.platformtools.x.e(r3, r6, r7);
            goto L_0x0170;
        L_0x019f:
            r0 = move-exception;
            r3 = "MicroMsg.RemarkImageStorage";
            r4 = "exception:%s";
            r6 = new java.lang.Object[r2];
            r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
            r6[r1] = r0;
            com.tencent.mm.sdk.platformtools.x.e(r3, r4, r6);
            goto L_0x0175;
        L_0x01b2:
            r0 = move-exception;
            r5 = "MicroMsg.RemarkImageStorage";
            r6 = "exception:%s";
            r7 = new java.lang.Object[r2];
            r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
            r7[r1] = r0;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x015b;
        L_0x01c5:
            r0 = move-exception;
            r3 = "MicroMsg.RemarkImageStorage";
            r5 = "exception:%s";
            r6 = new java.lang.Object[r2];
            r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
            r6[r1] = r0;
            com.tencent.mm.sdk.platformtools.x.e(r3, r5, r6);
            goto L_0x0160;
        L_0x01d8:
            r0 = move-exception;
            r3 = "MicroMsg.RemarkImageStorage";
            r4 = "exception:%s";
            r5 = new java.lang.Object[r2];
            r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
            r5[r1] = r0;
            com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);
            goto L_0x0165;
        L_0x01ec:
            r0 = move-exception;
            r4 = r3;
            r6 = r3;
        L_0x01ef:
            if (r6 == 0) goto L_0x01f6;
        L_0x01f1:
            r5 = r6.aBw;	 Catch:{ Exception -> 0x0201 }
            r5.disconnect();	 Catch:{ Exception -> 0x0201 }
        L_0x01f6:
            if (r3 == 0) goto L_0x01fb;
        L_0x01f8:
            r3.close();	 Catch:{ Exception -> 0x0214 }
        L_0x01fb:
            if (r4 == 0) goto L_0x0200;
        L_0x01fd:
            r4.close();	 Catch:{ Exception -> 0x0227 }
        L_0x0200:
            throw r0;
        L_0x0201:
            r5 = move-exception;
            r6 = "MicroMsg.RemarkImageStorage";
            r7 = "exception:%s";
            r8 = new java.lang.Object[r2];
            r5 = com.tencent.mm.sdk.platformtools.bi.i(r5);
            r8[r1] = r5;
            com.tencent.mm.sdk.platformtools.x.e(r6, r7, r8);
            goto L_0x01f6;
        L_0x0214:
            r3 = move-exception;
            r5 = "MicroMsg.RemarkImageStorage";
            r6 = "exception:%s";
            r7 = new java.lang.Object[r2];
            r3 = com.tencent.mm.sdk.platformtools.bi.i(r3);
            r7[r1] = r3;
            com.tencent.mm.sdk.platformtools.x.e(r5, r6, r7);
            goto L_0x01fb;
        L_0x0227:
            r3 = move-exception;
            r4 = "MicroMsg.RemarkImageStorage";
            r5 = "exception:%s";
            r2 = new java.lang.Object[r2];
            r3 = com.tencent.mm.sdk.platformtools.bi.i(r3);
            r2[r1] = r3;
            com.tencent.mm.sdk.platformtools.x.e(r4, r5, r2);
            goto L_0x0200;
        L_0x023a:
            r0 = move-exception;
            r4 = r3;
            goto L_0x01ef;
        L_0x023d:
            r0 = move-exception;
            r10 = r4;
            r4 = r3;
            r3 = r10;
            goto L_0x01ef;
        L_0x0242:
            r0 = move-exception;
            r3 = r4;
            r4 = r5;
            goto L_0x01ef;
        L_0x0246:
            r0 = move-exception;
            r6 = r5;
            goto L_0x01ef;
        L_0x0249:
            r0 = move-exception;
            r4 = r3;
            r5 = r3;
            goto L_0x013e;
        L_0x024e:
            r0 = move-exception;
            r4 = r3;
            r5 = r6;
            goto L_0x013e;
        L_0x0253:
            r0 = move-exception;
            r5 = r6;
            r10 = r3;
            r3 = r4;
            r4 = r10;
            goto L_0x013e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ba.c.b.JH():boolean");
        }

        public final boolean JI() {
            if (this.success) {
                com.tencent.mm.loader.stub.b.deleteFile(this.hFn);
                new File(this.hFn + ".tmp").renameTo(new File(this.hFn));
                this.hMl.bS(true);
                return true;
            }
            this.hMl.bS(false);
            return false;
        }
    }

    public interface a {
        void bS(boolean z);
    }

    public static c QS() {
        if (hMi == null) {
            hMi = new c();
        }
        return hMi;
    }

    private c() {
    }

    public static String lR(String str) {
        if (bi.oN(str)) {
            return null;
        }
        return i.a(com.tencent.mm.plugin.ad.a.Fr(), "remark_", g.s((str + "ZnVjaw==").getBytes()), ".png", 1);
    }

    public static boolean lS(String str) {
        x.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", str, lR(str));
        return new File(lR(str)).exists();
    }

    public static boolean lT(String str) {
        x.d("MicroMsg.RemarkImageStorage", "remove remark image: %s, path:%s", str, lR(str));
        return com.tencent.mm.loader.stub.b.deleteFile(lR(str));
    }

    public final Bitmap lU(String str) {
        int i = 0;
        Bitmap ab = d.ab(lR(str), 0, 0);
        if (!(ab == null || ab.isRecycled())) {
            i = 1;
        }
        return i != 0 ? ab : null;
    }

    public final void a(String str, String str2, a aVar) {
        if (!bi.oN(str2) && !lS(str)) {
            if (this.hMj == null || this.hMj.cgG()) {
                this.hMj = new at(1, "download-remark-img", 1);
            }
            this.hMj.c(new b(str, str2, aVar));
        }
    }
}
