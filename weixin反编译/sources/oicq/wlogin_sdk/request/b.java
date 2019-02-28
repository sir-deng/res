package oicq.wlogin_sdk.request;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.tools.util;

public final class b {
    private static /* synthetic */ int[] AFh;
    public i AEY = new i();
    private j AEZ = new j(this.AEY);
    private f AFa = new f(this.AEY);
    private g AFb = new g(this.AEY);
    private h AFc = new h(this.AEY);
    private e AFd = new e(this.AEY);
    public d AFe = null;
    private int AFf = 66560;
    private int AFg = 1404;
    private Context mContext = null;

    public enum a {
        USER_WITH_PWD,
        USER_WITH_MD5,
        USER_WITH_A1
    }

    private static /* synthetic */ int[] cKE() {
        int[] iArr = AFh;
        if (iArr == null) {
            iArr = new int[a.values().length];
            try {
                iArr[a.USER_WITH_A1.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[a.USER_WITH_MD5.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[a.USER_WITH_PWD.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            AFh = iArr;
        }
        return iArr;
    }

    public b(Context context, int i) {
        this.mContext = context;
        i iVar = this.AEY;
        iVar._context = context;
        iVar.AFM = i;
        iVar.AGg = new c(context);
        Object obj = new byte[16];
        iVar.AFD.nextBytes(obj);
        System.arraycopy(obj, 0, iVar.AFG, 0, 16);
        cKD();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] a(long r16, oicq.wlogin_sdk.request.b.a r18, java.lang.String r19) {
        /*
        r15 = this;
        r2 = new java.lang.StringBuilder;
        r3 = "wtlogin login with GetStWithPasswd:user:";
        r2.<init>(r3);
        r0 = r16;
        r2 = r2.append(r0);
        r3 = " appid:522017402 dwSigMap:8256";
        r2 = r2.append(r3);
        r3 = " ...";
        r2 = r2.append(r3);
        r2 = r2.toString();
        oicq.wlogin_sdk.tools.util.adi(r2);
        r2 = r19.length();
        r3 = 16;
        if (r2 <= r3) goto L_0x0034;
    L_0x002b:
        r2 = 0;
        r3 = 16;
        r0 = r19;
        r19 = r0.substring(r2, r3);
    L_0x0034:
        monitor-enter(r15);
        r2 = cKE();	 Catch:{ all -> 0x01a0 }
        r3 = r18.ordinal();	 Catch:{ all -> 0x01a0 }
        r2 = r2[r3];	 Catch:{ all -> 0x01a0 }
        switch(r2) {
            case 1: goto L_0x0045;
            case 2: goto L_0x00d4;
            case 3: goto L_0x00ff;
            default: goto L_0x0042;
        };	 Catch:{ all -> 0x01a0 }
    L_0x0042:
        monitor-exit(r15);	 Catch:{ all -> 0x01a0 }
        r2 = 0;
    L_0x0044:
        return r2;
    L_0x0045:
        if (r19 == 0) goto L_0x004d;
    L_0x0047:
        r2 = r19.length();	 Catch:{ all -> 0x01a0 }
        if (r2 != 0) goto L_0x0056;
    L_0x004d:
        r2 = "USER_WITH_PWD userPasswd null";
        oicq.wlogin_sdk.tools.util.adi(r2);	 Catch:{ all -> 0x01a0 }
        monitor-exit(r15);	 Catch:{ all -> 0x01a0 }
        r2 = 0;
        goto L_0x0044;
    L_0x0056:
        r9 = oicq.wlogin_sdk.tools.c.adg(r19);	 Catch:{ all -> 0x01a0 }
        r2 = 0;
    L_0x005b:
        r3 = r15.AEY;	 Catch:{ all -> 0x01a0 }
        r4 = r15.mContext;	 Catch:{ all -> 0x01a0 }
        r4 = oicq.wlogin_sdk.tools.util.ja(r4);	 Catch:{ all -> 0x01a0 }
        r3.AFQ = r4;	 Catch:{ all -> 0x01a0 }
        r3 = r15.AEY;	 Catch:{ all -> 0x01a0 }
        r4 = r15.mContext;	 Catch:{ all -> 0x01a0 }
        r4 = oicq.wlogin_sdk.tools.util.jd(r4);	 Catch:{ all -> 0x01a0 }
        r4 = r4.getBytes();	 Catch:{ all -> 0x01a0 }
        r3.AFS = r4;	 Catch:{ all -> 0x01a0 }
        r3 = r15.AEY;	 Catch:{ all -> 0x01a0 }
        r0 = r16;
        r3._uin = r0;	 Catch:{ all -> 0x01a0 }
        r3 = r15.AEY;	 Catch:{ all -> 0x01a0 }
        r4 = 522017402; // 0x1f1d5a7a float:3.3320884E-20 double:2.57910865E-315;
        r3.AFJ = r4;	 Catch:{ all -> 0x01a0 }
        r3 = r15.AEY;	 Catch:{ all -> 0x01a0 }
        r4 = 8256; // 0x2040 float:1.1569E-41 double:4.079E-320;
        r3.AFK = r4;	 Catch:{ all -> 0x01a0 }
        r3 = r15.AEY;	 Catch:{ all -> 0x01a0 }
        r4 = new oicq.wlogin_sdk.a.f;	 Catch:{ all -> 0x01a0 }
        r4.<init>();	 Catch:{ all -> 0x01a0 }
        r3.AFH = r4;	 Catch:{ all -> 0x01a0 }
        r3 = r15.AEZ;	 Catch:{ all -> 0x01a0 }
        r15.AFe = r3;	 Catch:{ all -> 0x01a0 }
        if (r2 == 0) goto L_0x017a;
    L_0x0095:
        r3 = r15.AEZ;	 Catch:{ all -> 0x01a0 }
        r4 = 522017402; // 0x1f1d5a7a float:3.3320884E-20 double:2.57910865E-315;
        r2 = r15.AEY;	 Catch:{ all -> 0x01a0 }
        r8 = r2.AGe;	 Catch:{ all -> 0x01a0 }
        r10 = r15.AFg;	 Catch:{ all -> 0x01a0 }
        r11 = r15.AFf;	 Catch:{ all -> 0x01a0 }
        r12 = 8256; // 0x2040 float:1.1569E-41 double:4.079E-320;
        r2 = r15.AEY;	 Catch:{ all -> 0x01a0 }
        r13 = r2.AGb;	 Catch:{ all -> 0x01a0 }
        r6 = r16;
        r2 = r3.a(r4, r6, r8, r9, r10, r11, r12, r13);	 Catch:{ all -> 0x01a0 }
    L_0x00ae:
        monitor-exit(r15);	 Catch:{ all -> 0x01a0 }
        r3 = new java.lang.StringBuilder;
        r4 = "wtlogin login with GetStWithPasswd:user:";
        r3.<init>(r4);
        r0 = r16;
        r3 = r3.append(r0);
        r4 = " appid:522017402 dwSigMap:8256";
        r3 = r3.append(r4);
        r4 = " end";
        r3 = r3.append(r4);
        r3 = r3.toString();
        oicq.wlogin_sdk.tools.util.adi(r3);
        goto L_0x0044;
    L_0x00d4:
        if (r19 == 0) goto L_0x00dc;
    L_0x00d6:
        r2 = r19.length();	 Catch:{ all -> 0x01a0 }
        if (r2 != 0) goto L_0x00e6;
    L_0x00dc:
        r2 = "USER_WITH_MD5 userPasswd null";
        oicq.wlogin_sdk.tools.util.adi(r2);	 Catch:{ all -> 0x01a0 }
        monitor-exit(r15);	 Catch:{ all -> 0x01a0 }
        r2 = 0;
        goto L_0x0044;
    L_0x00e6:
        r2 = "ISO-8859-1";
        r0 = r19;
        r2 = r0.getBytes(r2);	 Catch:{ Exception -> 0x00fa }
        r2 = r2.clone();	 Catch:{ Exception -> 0x00fa }
        r2 = (byte[]) r2;	 Catch:{ Exception -> 0x00fa }
        r3 = 0;
        r9 = r2;
        r2 = r3;
        goto L_0x005b;
    L_0x00fa:
        r2 = move-exception;
        monitor-exit(r15);	 Catch:{ all -> 0x01a0 }
        r2 = 0;
        goto L_0x0044;
    L_0x00ff:
        r2 = r15.AEY;	 Catch:{ all -> 0x01a0 }
        r4 = 522017402; // 0x1f1d5a7a float:3.3320884E-20 double:2.57910865E-315;
        r0 = r16;
        r2 = r2.N(r0, r4);	 Catch:{ all -> 0x01a0 }
        if (r2 == 0) goto L_0x0115;
    L_0x010c:
        r3 = r2._en_A1;	 Catch:{ all -> 0x01a0 }
        if (r3 == 0) goto L_0x0115;
    L_0x0110:
        r3 = r2._en_A1;	 Catch:{ all -> 0x01a0 }
        r3 = r3.length;	 Catch:{ all -> 0x01a0 }
        if (r3 > 0) goto L_0x014a;
    L_0x0115:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01a0 }
        r3 = "userAccount:";
        r2.<init>(r3);	 Catch:{ all -> 0x01a0 }
        r0 = r16;
        r2 = r2.append(r0);	 Catch:{ all -> 0x01a0 }
        r3 = " appid:522017402";
        r2 = r2.append(r3);	 Catch:{ all -> 0x01a0 }
        r3 = " GetA1ByAccount return: null";
        r2 = r2.append(r3);	 Catch:{ all -> 0x01a0 }
        r2 = r2.toString();	 Catch:{ all -> 0x01a0 }
        oicq.wlogin_sdk.tools.util.adi(r2);	 Catch:{ all -> 0x01a0 }
        r9 = 0;
    L_0x0139:
        if (r9 == 0) goto L_0x0140;
    L_0x013b:
        r2 = r9.length;	 Catch:{ all -> 0x01a0 }
        r3 = 16;
        if (r2 >= r3) goto L_0x0177;
    L_0x0140:
        r2 = "USER_WITH_A1 tmp_pwd null";
        oicq.wlogin_sdk.tools.util.adi(r2);	 Catch:{ all -> 0x01a0 }
        monitor-exit(r15);	 Catch:{ all -> 0x01a0 }
        r2 = 0;
        goto L_0x0044;
    L_0x014a:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01a0 }
        r4 = "userAccount:";
        r3.<init>(r4);	 Catch:{ all -> 0x01a0 }
        r0 = r16;
        r3 = r3.append(r0);	 Catch:{ all -> 0x01a0 }
        r4 = " appid:522017402";
        r3 = r3.append(r4);	 Catch:{ all -> 0x01a0 }
        r4 = " GetA1ByAccount return: not null";
        r3 = r3.append(r4);	 Catch:{ all -> 0x01a0 }
        r3 = r3.toString();	 Catch:{ all -> 0x01a0 }
        oicq.wlogin_sdk.tools.util.adi(r3);	 Catch:{ all -> 0x01a0 }
        r2 = r2._en_A1;	 Catch:{ all -> 0x01a0 }
        r2 = r2.clone();	 Catch:{ all -> 0x01a0 }
        r2 = (byte[]) r2;	 Catch:{ all -> 0x01a0 }
        r9 = r2;
        goto L_0x0139;
    L_0x0177:
        r2 = 1;
        goto L_0x005b;
    L_0x017a:
        r2 = 4;
        r8 = new byte[r2];	 Catch:{ all -> 0x01a0 }
        r2 = 0;
        r4 = oicq.wlogin_sdk.request.i.cKH();	 Catch:{ all -> 0x01a0 }
        oicq.wlogin_sdk.tools.util.d(r8, r2, r4);	 Catch:{ all -> 0x01a0 }
        r2 = r15.AEZ;	 Catch:{ all -> 0x01a0 }
        r3 = 522017402; // 0x1f1d5a7a float:3.3320884E-20 double:2.57910865E-315;
        r5 = r15.AEY;	 Catch:{ all -> 0x01a0 }
        r7 = r5.AGe;	 Catch:{ all -> 0x01a0 }
        r10 = r15.AFg;	 Catch:{ all -> 0x01a0 }
        r11 = r15.AFf;	 Catch:{ all -> 0x01a0 }
        r12 = 8256; // 0x2040 float:1.1569E-41 double:4.079E-320;
        r5 = r15.AEY;	 Catch:{ all -> 0x01a0 }
        r13 = r5.AGb;	 Catch:{ all -> 0x01a0 }
        r5 = r16;
        r2 = r2.a(r3, r5, r7, r8, r9, r10, r11, r12, r13);	 Catch:{ all -> 0x01a0 }
        goto L_0x00ae;
    L_0x01a0:
        r2 = move-exception;
        monitor-exit(r15);	 Catch:{ all -> 0x01a0 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: oicq.wlogin_sdk.request.b.a(long, oicq.wlogin_sdk.request.b$a, java.lang.String):byte[]");
    }

    public final byte[] f(long j, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        byte[] bY;
        util.adi("user:" + j + " CheckPicture ...");
        synchronized (this) {
            this.AFe = this.AFb;
            bY = this.AFb.bY(bArr);
        }
        util.adi("user:" + j + " CheckPicture end");
        return bY;
    }

    public final byte[] gK(long j) {
        Object obj;
        synchronized (this) {
            g gVar = this.AEY.AFI;
            obj = new byte[gVar.AGt];
            if (gVar.AGt > 0) {
                System.arraycopy(gVar.AFt, gVar.AGv, obj, 0, gVar.AGt);
            }
        }
        util.adi("user:" + j + " GetPicture data len:" + obj.length);
        return obj;
    }

    public final void gL(long j) {
        util.adi("user:" + j + " ClearUserSigInfo");
        this.AEY.h(Long.valueOf(j));
    }

    private int cKD() {
        synchronized (this) {
            Object jf = util.jf(this.mContext);
            if (jf == null || jf.length <= 0) {
                jf = util.iY(this.mContext);
                if (jf == null || jf.length <= 0) {
                    jf = new String("%4;7t>;28<fc.5*6").getBytes();
                    this.AEY.AFZ = 0;
                } else {
                    this.AEY.AFZ = 1;
                }
                util.b(this.mContext, jf);
                this.AEY.AFY = 1;
                this.AEY.AGa = 1;
            } else {
                this.AEY.AFZ = 1;
                this.AEY.AFY = 0;
                this.AEY.AGa = 0;
            }
            this.AEY.AFN = new byte[jf.length];
            System.arraycopy(jf, 0, this.AEY.AFN, 0, jf.length);
            Object obj = new byte[(jf.length + 1)];
            obj[0] = (byte) 35;
            System.arraycopy(jf, 0, obj, 1, jf.length);
            this.AEY.AFE = util.cg(obj);
            i.AFO = (byte[]) this.AEY.AFN.clone();
            this.AEY.AFP = util.iZ(this.mContext);
            int jb = util.jb(this.mContext);
            this.AEY.AFQ = util.ja(this.mContext);
            if (jb != this.AEY.AFQ) {
                util.jc(this.mContext);
                util.at(this.mContext, this.AEY.AFQ);
            }
            this.AEY.AFS = util.jd(this.mContext).getBytes();
            this.AEY.AGb = util.je(this.mContext);
            this.AEY.AFR = util.jg(this.mContext);
            this.AEY.AFU = util.bZ(this.mContext, new String(this.AEY.AFR));
            this.AEY.AFV = util.ca(this.mContext, new String(this.AEY.AFR));
            String str = Build.MODEL;
            if (str == null) {
                this.AEY.AFW = new byte[0];
            } else {
                this.AEY.AFW = str.getBytes();
            }
            if (util.isFileExist("/system/bin/su") || util.isFileExist("/system/xbin/su") || util.isFileExist("/sbin/su")) {
                jb = 1;
            } else {
                jb = 0;
            }
            i iVar = this.AEY;
            if (jb != 0) {
                jb = 1;
            } else {
                jb = 0;
            }
            iVar.AFX = jb;
            str = VERSION.RELEASE;
            if (str == null) {
                str = "";
            }
            util.adi("WtloginHelper init ok: android version:" + str + " release time:" + util.cKT());
        }
        return 0;
    }
}
