package com.tencent.mm.plugin.address.model;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.address.d.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.protocal.c.bca;
import com.tencent.mm.sdk.platformtools.x;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class l {
    private static final Pattern ioz = Pattern.compile("(-|\\s)+");
    public a iov = new a();
    public final List<RcptItem> iow = new ArrayList();
    public final HashMap<String, List<RcptItem>> iox = new HashMap();
    public final HashMap<String, List<RcptItem>> ioy = new HashMap();
    public String path;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void XQ() {
        /*
        r13 = this;
        r0 = "MicroMsg.WalletAddrMgr";
        r1 = "load data";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        com.tencent.mm.y.as.Hm();
        r8 = com.tencent.mm.y.c.FJ();
        r0 = "MicroMsg.WalletAddrMgr";
        r1 = "initAddressData";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r9 = r0.getAssets();
        r4 = 0;
        r3 = 0;
        r2 = 0;
        r6 = "";
        r5 = "";
        r10 = new java.util.ArrayList;
        r10.<init>();
        r7 = 0;
        r1 = new java.io.FileReader;	 Catch:{ IOException -> 0x02d0, all -> 0x017f }
        r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x02d0, all -> 0x017f }
        r0.<init>();	 Catch:{ IOException -> 0x02d0, all -> 0x017f }
        r0 = r0.append(r8);	 Catch:{ IOException -> 0x02d0, all -> 0x017f }
        r11 = "address";
        r0 = r0.append(r11);	 Catch:{ IOException -> 0x02d0, all -> 0x017f }
        r0 = r0.toString();	 Catch:{ IOException -> 0x02d0, all -> 0x017f }
        r1.<init>(r0);	 Catch:{ IOException -> 0x02d0, all -> 0x017f }
        r2 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x02d5, all -> 0x02c9 }
        r2.<init>(r1);	 Catch:{ IOException -> 0x02d5, all -> 0x02c9 }
        r10.clear();	 Catch:{ IOException -> 0x005b }
    L_0x0051:
        r0 = r2.readLine();	 Catch:{ IOException -> 0x005b }
        if (r0 == 0) goto L_0x0156;
    L_0x0057:
        r10.add(r0);	 Catch:{ IOException -> 0x005b }
        goto L_0x0051;
    L_0x005b:
        r0 = move-exception;
    L_0x005c:
        r3 = "MicroMsg.WalletAddrMgr";
        r11 = "";
        r12 = 0;
        r12 = new java.lang.Object[r12];	 Catch:{ all -> 0x02cc }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r0, r11, r12);	 Catch:{ all -> 0x02cc }
        if (r1 == 0) goto L_0x006d;
    L_0x006a:
        r1.close();	 Catch:{ Exception -> 0x0170 }
    L_0x006d:
        if (r2 == 0) goto L_0x0072;
    L_0x006f:
        r2.close();	 Catch:{ Exception -> 0x0170 }
    L_0x0072:
        if (r7 != 0) goto L_0x00aa;
    L_0x0074:
        r10.clear();	 Catch:{ IOException -> 0x02bf, all -> 0x01c4 }
        r0 = "address";
        r3 = r9.open(r0);	 Catch:{ IOException -> 0x02bf, all -> 0x01c4 }
        r1 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x02c4, all -> 0x01c4 }
        r0 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x02c4, all -> 0x01c4 }
        r4 = "utf-8";
        r0.<init>(r3, r4);	 Catch:{ IOException -> 0x02c4, all -> 0x01c4 }
        r1.<init>(r0);	 Catch:{ IOException -> 0x02c4, all -> 0x01c4 }
    L_0x008b:
        r0 = r1.readLine();	 Catch:{ IOException -> 0x0095 }
        if (r0 == 0) goto L_0x019a;
    L_0x0091:
        r10.add(r0);	 Catch:{ IOException -> 0x0095 }
        goto L_0x008b;
    L_0x0095:
        r0 = move-exception;
        r2 = r3;
    L_0x0097:
        r3 = "MicroMsg.WalletAddrMgr";
        r4 = "";
        r9 = 0;
        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x02bc }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r0, r4, r9);	 Catch:{ all -> 0x02bc }
        if (r1 == 0) goto L_0x00a8;
    L_0x00a5:
        r1.close();	 Catch:{ IOException -> 0x01b5 }
    L_0x00a8:
        if (r2 == 0) goto L_0x00aa;
    L_0x00aa:
        r0 = "MicroMsg.WalletAddrMgr";
        r1 = new java.lang.StringBuilder;
        r2 = "read from addr ";
        r1.<init>(r2);
        r1 = r1.append(r7);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r7 = r10.size();
        r0 = 0;
        r2 = r5;
        r3 = r6;
        r5 = r0;
    L_0x00c8:
        if (r5 >= r7) goto L_0x026a;
    L_0x00ca:
        r0 = r10.get(r5);
        r0 = (java.lang.String) r0;
        r1 = r5 + 1;
        if (r1 >= r7) goto L_0x01da;
    L_0x00d4:
        r1 = r5 + 1;
        r1 = r10.get(r1);
        r1 = (java.lang.String) r1;
    L_0x00dc:
        r4 = "\t";
        r6 = "-";
        r0 = r0.replace(r4, r6);
        r4 = "　";
        r6 = "-";
        r0 = r0.replace(r4, r6);
        r4 = "\t";
        r6 = "-";
        r1 = r1.replace(r4, r6);
        r4 = "　";
        r6 = "-";
        r6 = r1.replace(r4, r6);
        r1 = 0;
        r4 = 6;
        r1 = r0.substring(r1, r4);
        r4 = 6;
        r9 = r0.substring(r4);
        r0 = new java.lang.StringBuilder;
        r4 = "-";
        r0.<init>(r4);
        r0 = r0.append(r9);
        r0 = r0.toString();
        r4 = ioz;
        r4 = r4.split(r0);
        r0 = r4.length;
        r11 = 3;
        if (r0 != r11) goto L_0x01df;
    L_0x0129:
        r0 = new com.tencent.mm.plugin.address.model.RcptItem;
        r11 = 1;
        r11 = r4[r11];
        r12 = 2;
        r4 = r4[r12];
        r0.<init>(r11, r1, r4);
        r4 = r0;
    L_0x0135:
        if (r4 != 0) goto L_0x01e3;
    L_0x0137:
        r0 = "MicroMsg.WalletAddrMgr";
        r1 = new java.lang.StringBuilder;
        r4 = "analyze address data. missing ";
        r1.<init>(r4);
        r1 = r1.append(r9);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        r0 = r2;
        r1 = r3;
    L_0x014f:
        r2 = r5 + 1;
        r3 = r1;
        r5 = r2;
        r2 = r0;
        goto L_0x00c8;
    L_0x0156:
        r3 = 1;
        r1.close();	 Catch:{ Exception -> 0x0160 }
        r2.close();	 Catch:{ Exception -> 0x0160 }
        r7 = r3;
        goto L_0x0072;
    L_0x0160:
        r0 = move-exception;
        r1 = "MicroMsg.WalletAddrMgr";
        r7 = "";
        r11 = 0;
        r11 = new java.lang.Object[r11];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r7, r11);
        r7 = r3;
        goto L_0x0072;
    L_0x0170:
        r0 = move-exception;
        r1 = "MicroMsg.WalletAddrMgr";
        r3 = "";
        r11 = 0;
        r11 = new java.lang.Object[r11];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r3, r11);
        goto L_0x0072;
    L_0x017f:
        r0 = move-exception;
        r1 = r2;
    L_0x0181:
        if (r1 == 0) goto L_0x0186;
    L_0x0183:
        r1.close();	 Catch:{ Exception -> 0x018c }
    L_0x0186:
        if (r3 == 0) goto L_0x018b;
    L_0x0188:
        r3.close();	 Catch:{ Exception -> 0x018c }
    L_0x018b:
        throw r0;
    L_0x018c:
        r1 = move-exception;
        r2 = "MicroMsg.WalletAddrMgr";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x018b;
    L_0x019a:
        r1.close();	 Catch:{ IOException -> 0x0095 }
        r3.close();	 Catch:{ IOException -> 0x0095 }
        r1.close();	 Catch:{ IOException -> 0x01a7 }
    L_0x01a3:
        if (r3 == 0) goto L_0x00aa;
    L_0x01a5:
        goto L_0x00aa;
    L_0x01a7:
        r0 = move-exception;
        r1 = "MicroMsg.WalletAddrMgr";
        r2 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r4);
        goto L_0x01a3;
    L_0x01b5:
        r0 = move-exception;
        r1 = "MicroMsg.WalletAddrMgr";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r3, r4);
        goto L_0x00a8;
    L_0x01c4:
        r0 = move-exception;
        r1 = r2;
    L_0x01c6:
        if (r1 == 0) goto L_0x01cb;
    L_0x01c8:
        r1.close();	 Catch:{ IOException -> 0x01cc }
    L_0x01cb:
        throw r0;
    L_0x01cc:
        r1 = move-exception;
        r2 = "MicroMsg.WalletAddrMgr";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r3, r4);
        goto L_0x01cb;
    L_0x01da:
        r1 = "";
        goto L_0x00dc;
    L_0x01df:
        r0 = 0;
        r4 = r0;
        goto L_0x0135;
    L_0x01e3:
        r0 = "----";
        r0 = r9.startsWith(r0);
        if (r0 == 0) goto L_0x0212;
    L_0x01ec:
        r0 = r13.ioy;
        r0 = r0.containsKey(r2);
        if (r0 != 0) goto L_0x01fe;
    L_0x01f4:
        r0 = r13.ioy;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r0.put(r2, r1);
    L_0x01fe:
        r0 = r13.ioy;
        r0 = r0.get(r2);
        r0 = (java.util.List) r0;
        r0.add(r4);
        r1 = r13.ioy;
        r1.put(r2, r0);
        r0 = r2;
        r1 = r3;
        goto L_0x014f;
    L_0x0212:
        r0 = "---";
        r0 = r9.startsWith(r0);
        if (r0 == 0) goto L_0x024d;
    L_0x021b:
        r0 = r13.iox;
        r0 = r0.containsKey(r3);
        if (r0 != 0) goto L_0x022d;
    L_0x0223:
        r0 = r13.iox;
        r2 = new java.util.ArrayList;
        r2.<init>();
        r0.put(r3, r2);
    L_0x022d:
        r0 = r13.iox;
        r0 = r0.get(r3);
        r0 = (java.util.List) r0;
        r2 = "----";
        r2 = aK(r6, r2);
        if (r2 == 0) goto L_0x0241;
    L_0x023e:
        r2 = 1;
        r4.iou = r2;
    L_0x0241:
        r0.add(r4);
        r2 = r13.iox;
        r2.put(r3, r0);
        r0 = r1;
        r1 = r3;
        goto L_0x014f;
    L_0x024d:
        r0 = "-";
        r0 = r9.startsWith(r0);
        if (r0 == 0) goto L_0x02d9;
    L_0x0256:
        r0 = "---";
        r0 = aK(r6, r0);
        if (r0 == 0) goto L_0x0262;
    L_0x025f:
        r0 = 1;
        r4.iou = r0;
    L_0x0262:
        r0 = r13.iow;
        r0.add(r4);
        r0 = r2;
        goto L_0x014f;
    L_0x026a:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0 = r0.append(r8);
        r1 = "addrmgr";
        r0 = r0.append(r1);
        r0 = r0.toString();
        r13.path = r0;
        r0 = new java.io.File;
        r1 = r13.path;
        r0.<init>(r1);
        r1 = r0.exists();
        if (r1 != 0) goto L_0x0290;
    L_0x028d:
        r0.mkdir();
    L_0x0290:
        r0 = r13.path;
        r1 = 0;
        r2 = -1;
        r0 = com.tencent.mm.a.e.d(r0, r1, r2);
        r1 = r13.XS();
        r0 = decrypt(r0, r1);
        r1 = new com.tencent.mm.plugin.address.d.a;	 Catch:{ Exception -> 0x02ae }
        r1.<init>();	 Catch:{ Exception -> 0x02ae }
        r0 = r1.aH(r0);	 Catch:{ Exception -> 0x02ae }
        r0 = (com.tencent.mm.plugin.address.d.a) r0;	 Catch:{ Exception -> 0x02ae }
        r13.iov = r0;	 Catch:{ Exception -> 0x02ae }
    L_0x02ad:
        return;
    L_0x02ae:
        r0 = move-exception;
        r1 = "MicroMsg.WalletAddrMgr";
        r2 = "";
        r3 = 0;
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);
        goto L_0x02ad;
    L_0x02bc:
        r0 = move-exception;
        goto L_0x01c6;
    L_0x02bf:
        r0 = move-exception;
        r1 = r2;
        r2 = r4;
        goto L_0x0097;
    L_0x02c4:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
        goto L_0x0097;
    L_0x02c9:
        r0 = move-exception;
        goto L_0x0181;
    L_0x02cc:
        r0 = move-exception;
        r3 = r2;
        goto L_0x0181;
    L_0x02d0:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
        goto L_0x005c;
    L_0x02d5:
        r0 = move-exception;
        r2 = r3;
        goto L_0x005c;
    L_0x02d9:
        r0 = r2;
        r1 = r3;
        goto L_0x014f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.address.model.l.XQ():void");
    }

    public final b jk(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.iov.ioD.size()) {
                return null;
            }
            b bVar = (b) this.iov.ioD.get(i3);
            if (bVar.id == i) {
                return bVar;
            }
            i2 = i3 + 1;
        }
    }

    public final boolean a(b bVar) {
        if (this.iov == null) {
            this.iov = new a();
        }
        for (int i = 0; i < this.iov.ioD.size(); i++) {
            if (((b) this.iov.ioD.get(i)).id == bVar.id) {
                this.iov.ioD.remove(i);
                return true;
            }
        }
        return false;
    }

    public final boolean q(LinkedList<bca> linkedList) {
        this.iov.ioD.clear();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bca bca = (bca) it.next();
            b bVar = new b();
            bVar.id = bca.id;
            bVar.ioM = bca.wPi.wRo;
            bVar.ioG = bca.wPc.wRo;
            bVar.ioJ = bca.wPf.wRo;
            bVar.ioH = bca.wPd.wRo;
            bVar.ioK = bca.wPg.wRo;
            bVar.ioL = bca.wPh.wRo;
            bVar.ioF = bca.wPb.wRo;
            bVar.ioI = bca.wPe.wRo;
            this.iov.ioD.add(bVar);
        }
        return true;
    }

    public final void XR() {
        try {
            byte[] toByteArray = this.iov.toByteArray();
            long currentTimeMillis = System.currentTimeMillis();
            toByteArray = encrypt(toByteArray, XS());
            com.tencent.mm.loader.stub.b.deleteFile(this.path);
            e.b(this.path, toByteArray, toByteArray.length);
            x.d("MicroMsg.WalletAddrMgr", "hakon saveAddr time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
        }
    }

    private byte[] XS() {
        return g.s(("addrmgr" + this.path).toString().getBytes()).substring(8, 16).getBytes();
    }

    private static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(1, generateSecret, new IvParameterSpec("12345678".getBytes()));
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
            return null;
        }
    }

    private static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        try {
            Key generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(2, generateSecret, new IvParameterSpec("12345678".getBytes()));
            return instance.doFinal(bArr);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
            return null;
        }
    }

    public final List<RcptItem> pe(String str) {
        return this.iox.containsKey(str) ? (List) this.iox.get(str) : new ArrayList();
    }

    public final List<RcptItem> pf(String str) {
        return this.ioy.containsKey(str) ? (List) this.ioy.get(str) : new ArrayList();
    }

    private static boolean aK(String str, String str2) {
        if (str.substring(6).startsWith(str2)) {
            return true;
        }
        return false;
    }

    public final RcptItem v(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        RcptItem f = f(this.iow, str);
        if (f == null || TextUtils.isEmpty(f.code)) {
            return null;
        }
        f = f(pe(f.code), str2);
        if (f == null || TextUtils.isEmpty(f.code)) {
            return null;
        }
        if (TextUtils.isEmpty(str3)) {
            return f;
        }
        RcptItem f2 = f(pf(f.code), str3);
        if (f2 != null) {
            return f2;
        }
        return f;
    }

    private static RcptItem f(List<RcptItem> list, String str) {
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return null;
            }
            RcptItem rcptItem = (RcptItem) list.get(i2);
            if (rcptItem != null && str.equals(rcptItem.name)) {
                return rcptItem;
            }
            i = i2 + 1;
        }
    }

    public final boolean w(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        RcptItem f = f(this.iow, str);
        if (f == null || TextUtils.isEmpty(f.code)) {
            return false;
        }
        f = f(pe(f.code), str2);
        if (f == null || TextUtils.isEmpty(f.code)) {
            return false;
        }
        if (TextUtils.isEmpty(str3) || f(pf(f.code), str3) != null) {
            return true;
        }
        return false;
    }
}
