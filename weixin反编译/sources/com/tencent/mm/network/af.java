package com.tencent.mm.network;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.ICallBack;
import com.tencent.mm.a.n;
import com.tencent.mm.ai.a;
import com.tencent.mm.plugin.appbrand.jsapi.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public final class af implements ICallBack {
    private static WakerLock icV = null;
    private static int icW = 1000000205;
    private static int icX = g.CTRL_INDEX;
    private static byte[] icY;
    private static byte[] icZ;

    private static String exception2String(Exception exception) {
        Writer stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public final boolean makesureAuthed() {
        boolean z = false;
        if (aa.VX() == null) {
            return z;
        }
        try {
            return aa.VX().VC();
        } catch (Exception e) {
            x.e("StnCallBack", exception2String(e));
            new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[z]).append(", ").append(e.getStackTrace()[1]);
            return z;
        }
    }

    public final String[] onNewDns(String str) {
        return new String[0];
    }

    public final void onPush(final int i, final byte[] bArr) {
        if (aa.VZ() != null) {
            try {
                if (icV == null) {
                    icV = new WakerLock(aa.getContext());
                }
                icV.lock(1000, "StnLogic.onNotify");
                aa.VV().post(new Runnable() {
                    public final void run() {
                        aa.VZ().onPush(i, bArr);
                    }
                });
            } catch (Exception e) {
                x.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
            }
        }
    }

    public final boolean req2Buf(int i, Object obj, ByteArrayOutputStream byteArrayOutputStream, int[] iArr, int i2) {
        boolean z = false;
        if (aa.VY() == null) {
            return z;
        }
        try {
            return aa.VY().a(i, byteArrayOutputStream, iArr, i2);
        } catch (Exception e) {
            x.e("StnCallBack", exception2String(e));
            new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[z]).append(", ").append(e.getStackTrace()[1]);
            return z;
        }
    }

    public final int buf2Resp(int i, Object obj, byte[] bArr, int[] iArr, int[] iArr2, int i2) {
        int i3 = -1;
        if (aa.VY() == null) {
            return i3;
        }
        try {
            return aa.VY().a(i, bArr, iArr, iArr2);
        } catch (Exception e) {
            x.e("StnCallBack", exception2String(e));
            new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
            return i3;
        }
    }

    public final int onTaskEnd(int i, Object obj, int i2, int i3) {
        Exception exception;
        int i4;
        if (aa.VY() == null) {
            return 0;
        }
        try {
            int iU = aa.VY().iU(i);
            try {
                final int i5 = i;
                final Object obj2 = obj;
                final int i6 = i2;
                final int i7 = i3;
                aa.VV().post(new Runnable() {
                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        /*
                        r25 = this;
                        r15 = com.tencent.mm.network.aa.VY();
                        r0 = r25;
                        r0 = r2;
                        r16 = r0;
                        r0 = r25;
                        r2 = r4;
                        r0 = r25;
                        r5 = r5;
                        r4 = -1;
                        r14 = 0;
                        r0 = r15.ict;
                        r17 = r0;
                        monitor-enter(r17);
                        r18 = r15.iV(r16);	 Catch:{ all -> 0x02d1 }
                        r3 = -1;
                        r0 = r18;
                        if (r3 != r0) goto L_0x0045;
                    L_0x0022:
                        r3 = "MicroMsg.MMNativeNetTaskAdapter";
                        r4 = "mmcgi onGYNetEnd GET FROM QUEUE failed. native:[%d,%d] taskId:%d ";
                        r6 = 3;
                        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x02d1 }
                        r7 = 0;
                        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x02d1 }
                        r6[r7] = r2;	 Catch:{ all -> 0x02d1 }
                        r2 = 1;
                        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x02d1 }
                        r6[r2] = r5;	 Catch:{ all -> 0x02d1 }
                        r2 = 2;
                        r5 = java.lang.Integer.valueOf(r16);	 Catch:{ all -> 0x02d1 }
                        r6[r2] = r5;	 Catch:{ all -> 0x02d1 }
                        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r6);	 Catch:{ all -> 0x02d1 }
                        monitor-exit(r17);	 Catch:{ all -> 0x02d1 }
                    L_0x0044:
                        return;
                    L_0x0045:
                        r6 = 0;
                        switch(r2) {
                            case 0: goto L_0x01e0;
                            case 1: goto L_0x01e3;
                            case 2: goto L_0x01e6;
                            case 3: goto L_0x01e9;
                            case 4: goto L_0x01ec;
                            case 5: goto L_0x01ef;
                            case 6: goto L_0x01f2;
                            case 7: goto L_0x01f5;
                            case 8: goto L_0x020a;
                            case 9: goto L_0x020d;
                            default: goto L_0x0049;
                        };	 Catch:{ all -> 0x02d1 }
                    L_0x0049:
                        r3 = "MicroMsg.MMNativeNetTaskAdapter";
                        r7 = "c2JavaErrorType not exits c_errType:%d";
                        r8 = 1;
                        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x02d1 }
                        r9 = 0;
                        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x02d1 }
                        r8[r9] = r2;	 Catch:{ all -> 0x02d1 }
                        com.tencent.mm.sdk.platformtools.x.f(r3, r7, r8);	 Catch:{ all -> 0x02d1 }
                    L_0x005c:
                        if (r6 != 0) goto L_0x005f;
                    L_0x005e:
                        r5 = 0;
                    L_0x005f:
                        r2 = 3;
                        if (r6 != r2) goto L_0x0063;
                    L_0x0062:
                        r5 = -1;
                    L_0x0063:
                        r2 = com.tencent.mm.network.aa.VT();	 Catch:{ all -> 0x02d1 }
                        r2 = r2.icL;	 Catch:{ all -> 0x02d1 }
                        if (r2 != 0) goto L_0x0079;
                    L_0x006b:
                        r2 = 1;
                        if (r6 != r2) goto L_0x0079;
                    L_0x006e:
                        r2 = "MicroMsg.MMNativeNetTaskAdapter";
                        r3 = "network not available";
                        com.tencent.mm.sdk.platformtools.x.i(r2, r3);	 Catch:{ all -> 0x02d1 }
                        r6 = 2;
                        r5 = -1;
                    L_0x0079:
                        r2 = r15.ict;	 Catch:{ all -> 0x02d1 }
                        r2 = r2[r18];	 Catch:{ all -> 0x02d1 }
                        r0 = r2.icx;	 Catch:{ all -> 0x02d1 }
                        r19 = r0;
                        r2 = r15.ict;	 Catch:{ all -> 0x02d1 }
                        r2 = r2[r18];	 Catch:{ all -> 0x02d1 }
                        r2 = r2.icy;	 Catch:{ all -> 0x02d1 }
                        r3 = r15.ict;	 Catch:{ all -> 0x02d1 }
                        r3 = r3[r18];	 Catch:{ all -> 0x02d1 }
                        r0 = r3.startTime;	 Catch:{ all -> 0x02d1 }
                        r20 = r0;
                        r3 = r15.ict;	 Catch:{ all -> 0x02d1 }
                        r7 = 0;
                        r3[r18] = r7;	 Catch:{ all -> 0x02d1 }
                        if (r6 != 0) goto L_0x0597;
                    L_0x0096:
                        r3 = r19.KP();	 Catch:{ RemoteException -> 0x058c }
                        r3 = r3.KT();	 Catch:{ RemoteException -> 0x058c }
                        if (r3 == 0) goto L_0x0597;
                    L_0x00a0:
                        r6 = 4;
                        r3 = r19.KP();	 Catch:{ RemoteException -> 0x058c }
                        r5 = r3.KT();	 Catch:{ RemoteException -> 0x058c }
                        r12 = r5;
                        r13 = r6;
                    L_0x00ab:
                        r11 = r19.getType();	 Catch:{ RemoteException -> 0x058f }
                        r22 = com.tencent.mm.network.aa.VX();	 Catch:{ RemoteException -> 0x0235 }
                        r3 = r19.KP();	 Catch:{ RemoteException -> 0x0235 }
                        r23 = r3.Ky();	 Catch:{ RemoteException -> 0x0235 }
                        r3 = "MicroMsg.AutoAuth";
                        r4 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x021f }
                        r5 = "summerauth onGYNetEnd threadId: 0";
                        r4.<init>(r5);	 Catch:{ RemoteException -> 0x021f }
                        r5 = " errType: ";
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r4 = r4.append(r13);	 Catch:{ RemoteException -> 0x021f }
                        r5 = " errCode: ";
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r4 = r4.append(r12);	 Catch:{ RemoteException -> 0x021f }
                        r5 = " errMsg: ";
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r5 = 0;
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r5 = " rr: ";
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r0 = r19;
                        r4 = r4.append(r0);	 Catch:{ RemoteException -> 0x021f }
                        r5 = " type: ";
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r5 = r19.getType();	 Catch:{ RemoteException -> 0x021f }
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r5 = " netIdGetCertBeforeAutoAuth: ";
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r0 = r22;
                        r5 = r0.ibC;	 Catch:{ RemoteException -> 0x021f }
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r4 = r4.toString();	 Catch:{ RemoteException -> 0x021f }
                        com.tencent.mm.sdk.platformtools.x.d(r3, r4);	 Catch:{ RemoteException -> 0x021f }
                        if (r12 == 0) goto L_0x0210;
                    L_0x011c:
                        r0 = r22;
                        r3 = r0.ibt;	 Catch:{ RemoteException -> 0x021f }
                        r3 = r3 + 1;
                        r0 = r22;
                        r0.ibt = r3;	 Catch:{ RemoteException -> 0x021f }
                    L_0x0126:
                        r24 = r19.KP();	 Catch:{ RemoteException -> 0x021f }
                        r3 = r19.getType();	 Catch:{ RemoteException -> 0x021f }
                        switch(r3) {
                            case 126: goto L_0x0258;
                            case 381: goto L_0x051a;
                            case 701: goto L_0x0258;
                            case 702: goto L_0x0258;
                            default: goto L_0x0131;
                        };
                    L_0x0131:
                        r3 = r19.Kn();	 Catch:{ RemoteException -> 0x0235 }
                        r5 = r12;
                        r4 = r13;
                    L_0x0137:
                        monitor-exit(r17);	 Catch:{ all -> 0x02d1 }
                        r6 = "MicroMsg.MMNativeNetTaskAdapter";
                        r7 = "mmcgi onTaskEnd type:%d time:%d hash[%d,%d] [%d,%d]";
                        r8 = 6;
                        r8 = new java.lang.Object[r8];
                        r9 = 0;
                        r10 = java.lang.Integer.valueOf(r11);
                        r8[r9] = r10;
                        r9 = 1;
                        r12 = com.tencent.mm.sdk.platformtools.bi.bA(r20);
                        r10 = java.lang.Long.valueOf(r12);
                        r8[r9] = r10;
                        r9 = 2;
                        r10 = java.lang.Integer.valueOf(r16);
                        r8[r9] = r10;
                        r9 = 3;
                        r3 = java.lang.Integer.valueOf(r3);
                        r8[r9] = r3;
                        r3 = 4;
                        r9 = java.lang.Integer.valueOf(r4);
                        r8[r3] = r9;
                        r3 = 5;
                        r9 = java.lang.Integer.valueOf(r5);
                        r8[r3] = r9;
                        com.tencent.mm.sdk.platformtools.x.i(r6, r7, r8);
                        r3 = 4;
                        if (r3 != r4) goto L_0x018f;
                    L_0x0175:
                        r3 = -1;
                        if (r3 == r5) goto L_0x0183;
                    L_0x0178:
                        r3 = -2;
                        if (r3 == r5) goto L_0x0183;
                    L_0x017b:
                        r3 = -24;
                        if (r3 == r5) goto L_0x0183;
                    L_0x017f:
                        r3 = -34;
                        if (r3 != r5) goto L_0x018f;
                    L_0x0183:
                        r3 = com.tencent.mm.network.aa.VV();
                        r6 = new com.tencent.mm.network.z$1;
                        r6.<init>(r11, r5);
                        r3.post(r6);
                    L_0x018f:
                        r3 = r19.KP();	 Catch:{ Exception -> 0x01b0 }
                        r6 = r3.KS();	 Catch:{ Exception -> 0x01b0 }
                        if (r6 == 0) goto L_0x057a;
                    L_0x0199:
                        r3 = r6.length();	 Catch:{ Exception -> 0x01b0 }
                        if (r3 <= 0) goto L_0x057a;
                    L_0x019f:
                        r3 = r19.KP();	 Catch:{ Exception -> 0x01b0 }
                        r8 = r3.Ky();	 Catch:{ Exception -> 0x01b0 }
                        r3 = r18;
                        r7 = r19;
                        r2.a(r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x01b0 }
                        goto L_0x0044;
                    L_0x01b0:
                        r2 = move-exception;
                        r3 = "MicroMsg.MMNativeNetTaskAdapter";
                        r4 = "onGYNetEnd cb %s";
                        r5 = 1;
                        r5 = new java.lang.Object[r5];
                        r6 = 0;
                        r7 = r2.getMessage();
                        r5[r6] = r7;
                        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);
                        r3 = "MicroMsg.MMNativeNetTaskAdapter";
                        r4 = "exception:%s taskid:%d";
                        r5 = 2;
                        r5 = new java.lang.Object[r5];
                        r6 = 0;
                        r2 = com.tencent.mm.sdk.platformtools.bi.i(r2);
                        r5[r6] = r2;
                        r2 = 1;
                        r6 = java.lang.Integer.valueOf(r16);
                        r5[r2] = r6;
                        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);
                        goto L_0x0044;
                    L_0x01e0:
                        r6 = 0;
                        goto L_0x005c;
                    L_0x01e3:
                        r6 = 2;
                        goto L_0x005c;
                    L_0x01e6:
                        r6 = 2;
                        goto L_0x005c;
                    L_0x01e9:
                        r6 = 1;
                        goto L_0x005c;
                    L_0x01ec:
                        r6 = 1;
                        goto L_0x005c;
                    L_0x01ef:
                        r6 = 1;
                        goto L_0x005c;
                    L_0x01f2:
                        r6 = 1;
                        goto L_0x005c;
                    L_0x01f5:
                        r2 = -3002; // 0xfffffffffffff446 float:NaN double:NaN;
                        if (r2 == r5) goto L_0x01fd;
                    L_0x01f9:
                        r2 = -3003; // 0xfffffffffffff445 float:NaN double:NaN;
                        if (r2 != r5) goto L_0x0200;
                    L_0x01fd:
                        r6 = 4;
                        goto L_0x005c;
                    L_0x0200:
                        r2 = -10001; // 0xffffffffffffd8ef float:NaN double:NaN;
                        if (r2 != r5) goto L_0x0207;
                    L_0x0204:
                        r6 = 6;
                        goto L_0x005c;
                    L_0x0207:
                        r6 = 5;
                        goto L_0x005c;
                    L_0x020a:
                        r6 = 4;
                        goto L_0x005c;
                    L_0x020d:
                        r6 = 1;
                        goto L_0x005c;
                    L_0x0210:
                        r3 = r19.getType();	 Catch:{ RemoteException -> 0x021f }
                        r4 = 10;
                        if (r3 == r4) goto L_0x0126;
                    L_0x0218:
                        r3 = 0;
                        r0 = r22;
                        r0.ibt = r3;	 Catch:{ RemoteException -> 0x021f }
                        goto L_0x0126;
                    L_0x021f:
                        r3 = move-exception;
                        r4 = "MicroMsg.AutoAuth";
                        r5 = "exception:%s";
                        r6 = 1;
                        r6 = new java.lang.Object[r6];	 Catch:{ RemoteException -> 0x0235 }
                        r7 = 0;
                        r3 = com.tencent.mm.sdk.platformtools.bi.i(r3);	 Catch:{ RemoteException -> 0x0235 }
                        r6[r7] = r3;	 Catch:{ RemoteException -> 0x0235 }
                        com.tencent.mm.sdk.platformtools.x.e(r4, r5, r6);	 Catch:{ RemoteException -> 0x0235 }
                        goto L_0x0131;
                    L_0x0235:
                        r3 = move-exception;
                        r4 = r11;
                        r5 = r12;
                        r6 = r13;
                    L_0x0239:
                        r7 = "MicroMsg.MMNativeNetTaskAdapter";
                        r8 = "exception:%s taskid:%d";
                        r9 = 2;
                        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x02d1 }
                        r10 = 0;
                        r3 = com.tencent.mm.sdk.platformtools.bi.i(r3);	 Catch:{ all -> 0x02d1 }
                        r9[r10] = r3;	 Catch:{ all -> 0x02d1 }
                        r3 = 1;
                        r10 = java.lang.Integer.valueOf(r16);	 Catch:{ all -> 0x02d1 }
                        r9[r3] = r10;	 Catch:{ all -> 0x02d1 }
                        com.tencent.mm.sdk.platformtools.x.e(r7, r8, r9);	 Catch:{ all -> 0x02d1 }
                        r3 = r14;
                        r11 = r4;
                        r4 = r6;
                        goto L_0x0137;
                    L_0x0258:
                        r3 = "MicroMsg.AutoAuth";
                        r4 = "summerauth end type: %d, ret:[%d,%d][%s]";
                        r5 = 4;
                        r5 = new java.lang.Object[r5];	 Catch:{ RemoteException -> 0x021f }
                        r6 = 0;
                        r7 = r19.getType();	 Catch:{ RemoteException -> 0x021f }
                        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ RemoteException -> 0x021f }
                        r5[r6] = r7;	 Catch:{ RemoteException -> 0x021f }
                        r6 = 1;
                        r7 = java.lang.Integer.valueOf(r13);	 Catch:{ RemoteException -> 0x021f }
                        r5[r6] = r7;	 Catch:{ RemoteException -> 0x021f }
                        r6 = 2;
                        r7 = java.lang.Integer.valueOf(r12);	 Catch:{ RemoteException -> 0x021f }
                        r5[r6] = r7;	 Catch:{ RemoteException -> 0x021f }
                        r6 = 3;
                        r7 = 0;
                        r5[r6] = r7;	 Catch:{ RemoteException -> 0x021f }
                        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);	 Catch:{ RemoteException -> 0x021f }
                        r3 = r24.KT();	 Catch:{ RemoteException -> 0x021f }
                        if (r3 != 0) goto L_0x028b;
                    L_0x0287:
                        if (r13 != 0) goto L_0x028b;
                    L_0x0289:
                        if (r12 == 0) goto L_0x032a;
                    L_0x028b:
                        r3 = r19.getType();	 Catch:{ RemoteException -> 0x021f }
                        r4 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
                        if (r3 != r4) goto L_0x02d4;
                    L_0x0293:
                        r3 = "MicroMsg.AutoAuth";
                        r4 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x021f }
                        r5 = "net.end: reg err: type=";
                        r4.<init>(r5);	 Catch:{ RemoteException -> 0x021f }
                        r5 = r19.getType();	 Catch:{ RemoteException -> 0x021f }
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r5 = " err=";
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r4 = r4.append(r13);	 Catch:{ RemoteException -> 0x021f }
                        r5 = ",";
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r4 = r4.append(r12);	 Catch:{ RemoteException -> 0x021f }
                        r5 = " errmsg=";
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r5 = 0;
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r4 = r4.toString();	 Catch:{ RemoteException -> 0x021f }
                        com.tencent.mm.sdk.platformtools.x.e(r3, r4);	 Catch:{ RemoteException -> 0x021f }
                        goto L_0x0131;
                    L_0x02d1:
                        r2 = move-exception;
                        monitor-exit(r17);	 Catch:{ all -> 0x02d1 }
                        throw r2;
                    L_0x02d4:
                        switch(r12) {
                            case -213: goto L_0x02d9;
                            case -205: goto L_0x02d9;
                            case -100: goto L_0x02d9;
                            default: goto L_0x02d7;
                        };
                    L_0x02d7:
                        goto L_0x0131;
                    L_0x02d9:
                        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();	 Catch:{ RemoteException -> 0x021f }
                        r4 = "auth_hold_prefs";
                        r5 = 0;
                        r3 = r3.getSharedPreferences(r4, r5);	 Catch:{ RemoteException -> 0x021f }
                        r3 = r3.edit();	 Catch:{ RemoteException -> 0x021f }
                        r4 = "auth_ishold";
                        r5 = 1;
                        r3 = r3.putBoolean(r4, r5);	 Catch:{ RemoteException -> 0x021f }
                        r3.commit();	 Catch:{ RemoteException -> 0x021f }
                        r3 = -213; // 0xffffffffffffff2b float:NaN double:NaN;
                        if (r12 != r3) goto L_0x0306;
                    L_0x02f8:
                        r3 = com.tencent.mm.plugin.report.d.pVE;	 Catch:{ RemoteException -> 0x021f }
                        r4 = 148; // 0x94 float:2.07E-43 double:7.3E-322;
                        r6 = 31;
                        r8 = 1;
                        r10 = 0;
                        r3.a(r4, r6, r8, r10);	 Catch:{ RemoteException -> 0x021f }
                        goto L_0x0131;
                    L_0x0306:
                        r3 = -100;
                        if (r12 != r3) goto L_0x0318;
                    L_0x030a:
                        r3 = com.tencent.mm.plugin.report.d.pVE;	 Catch:{ RemoteException -> 0x021f }
                        r4 = 148; // 0x94 float:2.07E-43 double:7.3E-322;
                        r6 = 32;
                        r8 = 1;
                        r10 = 0;
                        r3.a(r4, r6, r8, r10);	 Catch:{ RemoteException -> 0x021f }
                        goto L_0x0131;
                    L_0x0318:
                        r3 = -205; // 0xffffffffffffff33 float:NaN double:NaN;
                        if (r12 != r3) goto L_0x0131;
                    L_0x031c:
                        r3 = com.tencent.mm.plugin.report.d.pVE;	 Catch:{ RemoteException -> 0x021f }
                        r4 = 148; // 0x94 float:2.07E-43 double:7.3E-322;
                        r6 = 33;
                        r8 = 1;
                        r10 = 0;
                        r3.a(r4, r6, r8, r10);	 Catch:{ RemoteException -> 0x021f }
                        goto L_0x0131;
                    L_0x032a:
                        r3 = r19.KQ();	 Catch:{ RemoteException -> 0x021f }
                        r4 = "MicroMsg.AutoAuth";
                        r5 = "summerauth accinfo doAuthEnd type:%d, ret:%d loginDecodeFailedTry:%d";
                        r6 = 3;
                        r6 = new java.lang.Object[r6];	 Catch:{ RemoteException -> 0x021f }
                        r7 = 0;
                        r8 = r19.getType();	 Catch:{ RemoteException -> 0x021f }
                        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ RemoteException -> 0x021f }
                        r6[r7] = r8;	 Catch:{ RemoteException -> 0x021f }
                        r7 = 1;
                        r8 = java.lang.Integer.valueOf(r3);	 Catch:{ RemoteException -> 0x021f }
                        r6[r7] = r8;	 Catch:{ RemoteException -> 0x021f }
                        r7 = 2;
                        r0 = r22;
                        r8 = r0.hPp;	 Catch:{ RemoteException -> 0x021f }
                        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ RemoteException -> 0x021f }
                        r6[r7] = r8;	 Catch:{ RemoteException -> 0x021f }
                        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);	 Catch:{ RemoteException -> 0x021f }
                        r4 = 2;
                        if (r3 != r4) goto L_0x0416;
                    L_0x035a:
                        r3 = r19.getType();	 Catch:{ RemoteException -> 0x021f }
                        r4 = 702; // 0x2be float:9.84E-43 double:3.47E-321;
                        if (r3 != r4) goto L_0x0131;
                    L_0x0362:
                        r3 = com.tencent.mm.plugin.report.d.pVE;	 Catch:{ RemoteException -> 0x021f }
                        r4 = 148; // 0x94 float:2.07E-43 double:7.3E-322;
                        r6 = 34;
                        r8 = 1;
                        r10 = 0;
                        r3.a(r4, r6, r8, r10);	 Catch:{ RemoteException -> 0x021f }
                        r0 = r22;
                        r3 = r0.hPp;	 Catch:{ RemoteException -> 0x021f }
                        r3 = r3 + 1;
                        r0 = r22;
                        r0.hPp = r3;	 Catch:{ RemoteException -> 0x021f }
                        r0 = r22;
                        r3 = r0.hPp;	 Catch:{ RemoteException -> 0x021f }
                        r4 = 1;
                        if (r3 <= r4) goto L_0x03a7;
                    L_0x037f:
                        r3 = "MicroMsg.AutoAuth";
                        r4 = "summerauth loginDecodeFailedTry beyond 1 no more try!";
                        com.tencent.mm.sdk.platformtools.x.w(r3, r4);	 Catch:{ RemoteException -> 0x021f }
                        r3 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x021f }
                        r4 = "auth_decode_failed_";
                        r3.<init>(r4);	 Catch:{ RemoteException -> 0x021f }
                        r4 = 0;
                        r5 = "";
                        r4 = com.tencent.mm.sdk.platformtools.bi.aD(r4, r5);	 Catch:{ RemoteException -> 0x021f }
                        r3 = r3.append(r4);	 Catch:{ RemoteException -> 0x021f }
                        r3 = r3.toString();	 Catch:{ RemoteException -> 0x021f }
                        r0 = r22;
                        r0.d(r13, r12, r3);	 Catch:{ RemoteException -> 0x021f }
                        goto L_0x0131;
                    L_0x03a7:
                        r5 = r24.Cn();	 Catch:{ RemoteException -> 0x03df }
                        r3 = r24.KU();	 Catch:{ RemoteException -> 0x03df }
                        r4 = com.tencent.mm.sdk.platformtools.bi.by(r3);	 Catch:{ RemoteException -> 0x03df }
                        if (r4 == 0) goto L_0x0401;
                    L_0x03b5:
                        r3 = "";
                        r4 = r3;
                    L_0x03b9:
                        r3 = com.tencent.mm.sdk.platformtools.bi.by(r23);	 Catch:{ RemoteException -> 0x03df }
                        if (r3 == 0) goto L_0x0407;
                    L_0x03bf:
                        r3 = "";
                    L_0x03c2:
                        r0 = r22;
                        r3 = r0.g(r4, r3, r5);	 Catch:{ RemoteException -> 0x03df }
                        if (r3 == 0) goto L_0x040c;
                    L_0x03ca:
                        r0 = r22;
                        r3 = r0.iby;	 Catch:{ RemoteException -> 0x03df }
                        r0 = r23;
                        r3.hpt = r0;	 Catch:{ RemoteException -> 0x03df }
                    L_0x03d2:
                        r0 = r22;
                        r3 = r0.ibz;	 Catch:{ RemoteException -> 0x03df }
                        r4 = 0;
                        r5 = 0;
                        r0 = r19;
                        r0.a(r3, r4, r5);	 Catch:{ RemoteException -> 0x03df }
                        goto L_0x0131;
                    L_0x03df:
                        r3 = move-exception;
                        r4 = "MicroMsg.AutoAuth";
                        r5 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x021f }
                        r6 = "summerauth save serverid aak failed 1 cookie:";
                        r5.<init>(r6);	 Catch:{ RemoteException -> 0x021f }
                        r6 = com.tencent.mm.sdk.platformtools.bi.bA(r23);	 Catch:{ RemoteException -> 0x021f }
                        r5 = r5.append(r6);	 Catch:{ RemoteException -> 0x021f }
                        r5 = r5.toString();	 Catch:{ RemoteException -> 0x021f }
                        r6 = 0;
                        r6 = new java.lang.Object[r6];	 Catch:{ RemoteException -> 0x021f }
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r3, r5, r6);	 Catch:{ RemoteException -> 0x021f }
                        com.tencent.mm.sdk.platformtools.x.cfX();	 Catch:{ RemoteException -> 0x021f }
                        throw r3;	 Catch:{ RemoteException -> 0x021f }
                    L_0x0401:
                        r3 = com.tencent.mm.sdk.platformtools.bi.bA(r3);	 Catch:{ RemoteException -> 0x03df }
                        r4 = r3;
                        goto L_0x03b9;
                    L_0x0407:
                        r3 = com.tencent.mm.sdk.platformtools.bi.bA(r23);	 Catch:{ RemoteException -> 0x03df }
                        goto L_0x03c2;
                    L_0x040c:
                        r3 = "MicroMsg.AutoAuth";
                        r4 = "summerauth save serverid aak failed 1";
                        com.tencent.mm.sdk.platformtools.x.w(r3, r4);	 Catch:{ RemoteException -> 0x03df }
                        goto L_0x03d2;
                    L_0x0416:
                        r3 = 0;
                        r0 = r22;
                        r0.hPp = r3;	 Catch:{ RemoteException -> 0x021f }
                        r5 = r19.KO();	 Catch:{ RemoteException -> 0x021f }
                        r3 = "MicroMsg.AutoAuth";
                        r4 = "summerauth accinfo %d: username:%s, wxusername:%s, ticket:%s, session:%s, uin:%d";
                        r6 = 6;
                        r6 = new java.lang.Object[r6];	 Catch:{ RemoteException -> 0x04f8 }
                        r7 = 0;
                        r8 = r19.getType();	 Catch:{ RemoteException -> 0x04f8 }
                        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ RemoteException -> 0x04f8 }
                        r6[r7] = r8;	 Catch:{ RemoteException -> 0x04f8 }
                        r7 = 1;
                        r8 = r5.getUserName();	 Catch:{ RemoteException -> 0x04f8 }
                        r6[r7] = r8;	 Catch:{ RemoteException -> 0x04f8 }
                        r7 = 2;
                        r8 = r24.KY();	 Catch:{ RemoteException -> 0x04f8 }
                        r6[r7] = r8;	 Catch:{ RemoteException -> 0x04f8 }
                        r7 = 3;
                        r8 = r24.KU();	 Catch:{ RemoteException -> 0x04f8 }
                        r8 = com.tencent.mm.sdk.platformtools.bi.bx(r8);	 Catch:{ RemoteException -> 0x04f8 }
                        r8 = com.tencent.mm.sdk.platformtools.bi.Wz(r8);	 Catch:{ RemoteException -> 0x04f8 }
                        r6[r7] = r8;	 Catch:{ RemoteException -> 0x04f8 }
                        r7 = 4;
                        r8 = r24.CM();	 Catch:{ RemoteException -> 0x04f8 }
                        r8 = com.tencent.mm.sdk.platformtools.bi.bx(r8);	 Catch:{ RemoteException -> 0x04f8 }
                        r8 = com.tencent.mm.sdk.platformtools.bi.Wz(r8);	 Catch:{ RemoteException -> 0x04f8 }
                        r6[r7] = r8;	 Catch:{ RemoteException -> 0x04f8 }
                        r7 = 5;
                        r8 = r24.Cn();	 Catch:{ RemoteException -> 0x04f8 }
                        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ RemoteException -> 0x04f8 }
                        r6[r7] = r8;	 Catch:{ RemoteException -> 0x04f8 }
                        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r6);	 Catch:{ RemoteException -> 0x04f8 }
                        r6 = r24.Cn();	 Catch:{ RemoteException -> 0x04f8 }
                        r3 = r24.KU();	 Catch:{ RemoteException -> 0x04f8 }
                        r4 = com.tencent.mm.sdk.platformtools.bi.by(r3);	 Catch:{ RemoteException -> 0x04f8 }
                        if (r4 == 0) goto L_0x04d7;
                    L_0x047b:
                        r3 = "";
                        r4 = r3;
                    L_0x047f:
                        r3 = com.tencent.mm.sdk.platformtools.bi.by(r23);	 Catch:{ RemoteException -> 0x04f8 }
                        if (r3 == 0) goto L_0x04dd;
                    L_0x0485:
                        r3 = "";
                    L_0x0488:
                        r0 = r22;
                        r3 = r0.g(r4, r3, r6);	 Catch:{ RemoteException -> 0x04f8 }
                        if (r3 == 0) goto L_0x04e2;
                    L_0x0490:
                        r0 = r22;
                        r3 = r0.iby;	 Catch:{ RemoteException -> 0x04f8 }
                        r0 = r23;
                        r3.hpt = r0;	 Catch:{ RemoteException -> 0x04f8 }
                        r0 = r22;
                        r3 = r0.iby;	 Catch:{ RemoteException -> 0x04f8 }
                        r4 = r5.getUserName();	 Catch:{ RemoteException -> 0x04f8 }
                        r3.username = r4;	 Catch:{ RemoteException -> 0x04f8 }
                        r0 = r22;
                        r3 = r0.iby;	 Catch:{ RemoteException -> 0x04f8 }
                        r4 = r24.KY();	 Catch:{ RemoteException -> 0x04f8 }
                        r3.ibj = r4;	 Catch:{ RemoteException -> 0x04f8 }
                        r0 = r22;
                        r3 = r0.iby;	 Catch:{ RemoteException -> 0x04f8 }
                        r4 = r24.CM();	 Catch:{ RemoteException -> 0x04f8 }
                        r5 = r24.Cn();	 Catch:{ RemoteException -> 0x04f8 }
                        r3.v(r4, r5);	 Catch:{ RemoteException -> 0x04f8 }
                        r0 = r22;
                        r3 = r0.iby;	 Catch:{ RemoteException -> 0x04f8 }
                        r4 = r24.KA();	 Catch:{ RemoteException -> 0x04f8 }
                        r3.ibi = r4;	 Catch:{ RemoteException -> 0x04f8 }
                        r3 = r24.Cn();	 Catch:{ RemoteException -> 0x04f8 }
                        com.tencent.mm.a.o.getString(r3);	 Catch:{ RemoteException -> 0x04f8 }
                    L_0x04cc:
                        r3 = "MicroMsg.AutoAuth";
                        r4 = "summerauth decode and save ok!";
                        com.tencent.mm.sdk.platformtools.x.i(r3, r4);	 Catch:{ RemoteException -> 0x021f }
                        goto L_0x0131;
                    L_0x04d7:
                        r3 = com.tencent.mm.sdk.platformtools.bi.bA(r3);	 Catch:{ RemoteException -> 0x04f8 }
                        r4 = r3;
                        goto L_0x047f;
                    L_0x04dd:
                        r3 = com.tencent.mm.sdk.platformtools.bi.bA(r23);	 Catch:{ RemoteException -> 0x04f8 }
                        goto L_0x0488;
                    L_0x04e2:
                        r3 = com.tencent.mm.plugin.report.d.pVE;	 Catch:{ RemoteException -> 0x04f8 }
                        r4 = 148; // 0x94 float:2.07E-43 double:7.3E-322;
                        r6 = 35;
                        r8 = 1;
                        r10 = 0;
                        r3.a(r4, r6, r8, r10);	 Catch:{ RemoteException -> 0x04f8 }
                        r3 = "MicroMsg.AutoAuth";
                        r4 = "summerauth save serverid aak failed 2";
                        com.tencent.mm.sdk.platformtools.x.w(r3, r4);	 Catch:{ RemoteException -> 0x04f8 }
                        goto L_0x04cc;
                    L_0x04f8:
                        r3 = move-exception;
                        r4 = "MicroMsg.AutoAuth";
                        r5 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x021f }
                        r6 = "summerauth save serverid aak failed 2 cookie:";
                        r5.<init>(r6);	 Catch:{ RemoteException -> 0x021f }
                        r6 = com.tencent.mm.sdk.platformtools.bi.bA(r23);	 Catch:{ RemoteException -> 0x021f }
                        r5 = r5.append(r6);	 Catch:{ RemoteException -> 0x021f }
                        r5 = r5.toString();	 Catch:{ RemoteException -> 0x021f }
                        r6 = 0;
                        r6 = new java.lang.Object[r6];	 Catch:{ RemoteException -> 0x021f }
                        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r3, r5, r6);	 Catch:{ RemoteException -> 0x021f }
                        com.tencent.mm.sdk.platformtools.x.cfX();	 Catch:{ RemoteException -> 0x021f }
                        throw r3;	 Catch:{ RemoteException -> 0x021f }
                    L_0x051a:
                        if (r13 != 0) goto L_0x0541;
                    L_0x051c:
                        if (r12 != 0) goto L_0x0541;
                    L_0x051e:
                        r3 = r19.KP();	 Catch:{ RemoteException -> 0x021f }
                        r3 = r3.KV();	 Catch:{ RemoteException -> 0x021f }
                        r4 = r19.KP();	 Catch:{ RemoteException -> 0x021f }
                        r4 = r4.KW();	 Catch:{ RemoteException -> 0x021f }
                        r5 = r19.KP();	 Catch:{ RemoteException -> 0x021f }
                        r5 = r5.KX();	 Catch:{ RemoteException -> 0x021f }
                        com.tencent.mm.protocal.ac.H(r3, r4, r5);	 Catch:{ RemoteException -> 0x021f }
                        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ RemoteException -> 0x021f }
                        r0 = r22;
                        r0.ibB = r4;	 Catch:{ RemoteException -> 0x021f }
                    L_0x0541:
                        r3 = com.tencent.mm.platformtools.r.ifN;	 Catch:{ RemoteException -> 0x021f }
                        r4 = 10003; // 0x2713 float:1.4017E-41 double:4.942E-320;
                        if (r3 != r4) goto L_0x0594;
                    L_0x0547:
                        r3 = com.tencent.mm.platformtools.r.ifO;	 Catch:{ RemoteException -> 0x021f }
                        if (r3 <= 0) goto L_0x0594;
                    L_0x054b:
                        r3 = com.tencent.mm.platformtools.r.ifO;	 Catch:{ RemoteException -> 0x021f }
                        r4 = 1;
                        if (r3 > r4) goto L_0x0553;
                    L_0x0550:
                        r3 = 0;
                        com.tencent.mm.platformtools.r.ifO = r3;	 Catch:{ RemoteException -> 0x021f }
                    L_0x0553:
                        r4 = 4;
                        r3 = 0;
                        r5 = "";
                        r6 = "";
                        r7 = 0;
                        com.tencent.mm.protocal.ac.H(r5, r6, r7);	 Catch:{ RemoteException -> 0x021f }
                    L_0x055f:
                        r0 = r22;
                        r5 = r0.ibC;	 Catch:{ RemoteException -> 0x021f }
                        r6 = -1;
                        if (r5 == r6) goto L_0x0131;
                    L_0x0566:
                        if (r4 != 0) goto L_0x0573;
                    L_0x0568:
                        if (r3 != 0) goto L_0x0573;
                    L_0x056a:
                        r3 = 0;
                        r4 = 0;
                        r0 = r22;
                        r1 = r19;
                        r0.a(r1, r3, r4);	 Catch:{ RemoteException -> 0x021f }
                    L_0x0573:
                        r3 = -1;
                        r0 = r22;
                        r0.ibC = r3;	 Catch:{ RemoteException -> 0x021f }
                        goto L_0x0131;
                    L_0x057a:
                        r6 = 0;
                        r3 = r19.KP();	 Catch:{ Exception -> 0x01b0 }
                        r8 = r3.Ky();	 Catch:{ Exception -> 0x01b0 }
                        r3 = r18;
                        r7 = r19;
                        r2.a(r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x01b0 }
                        goto L_0x0044;
                    L_0x058c:
                        r3 = move-exception;
                        goto L_0x0239;
                    L_0x058f:
                        r3 = move-exception;
                        r5 = r12;
                        r6 = r13;
                        goto L_0x0239;
                    L_0x0594:
                        r3 = r12;
                        r4 = r13;
                        goto L_0x055f;
                    L_0x0597:
                        r12 = r5;
                        r13 = r6;
                        goto L_0x00ab;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.network.af.2.run():void");
                    }
                });
                return iU;
            } catch (Exception e) {
                exception = e;
                i4 = iU;
                x.e("StnCallBack", exception2String(exception));
                new StringBuilder().append(exception.getClass().getSimpleName()).append(":").append(exception.getStackTrace()[0]).append(", ").append(exception.getStackTrace()[1]);
                return i4;
            }
        } catch (Exception e2) {
            exception = e2;
            i4 = 0;
        }
    }

    public final void reportConnectInfo(int i, int i2) {
        try {
            aa.VU().iW(i);
            a.hC(i);
        } catch (Throwable e) {
            x.e("StnCallBack", "reportConnectInfo :%s", bi.i(e));
        }
    }

    public final int getLongLinkIdentifyCheckBuffer(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2, int[] iArr) {
        iArr[0] = icX;
        iArr[1] = icW;
        if (a(byteArrayOutputStream, byteArrayOutputStream2) != 0 && byteArrayOutputStream.size() != 0 && byteArrayOutputStream2.size() != 0) {
            return StnLogic.ECHECK_NOW;
        }
        requestDoSync();
        return StnLogic.ECHECK_NEXT;
    }

    public final boolean onLongLinkIdentifyResp(byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || bArr2 == null)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr2);
            } catch (IOException e) {
            }
            onPush(icW, byteArrayOutputStream.toByteArray());
        }
        return true;
    }

    public final String[] requestNetCheckShortLinkHosts() {
        return new String[0];
    }

    private static int a(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2) {
        if (aa.VX() == null) {
            return 0;
        }
        try {
            byte[] VD = aa.VX().VD();
            if (VD != null) {
                byteArrayOutputStream.write(VD);
                icY = VD;
            }
            VD = aa.VX().gRB;
            if (VD != null) {
                byteArrayOutputStream2.write(VD);
                icZ = VD;
            }
            return aa.VX().iby.Cn();
        } catch (Exception e) {
            x.e("StnCallBack", exception2String(e));
            if (icY == null || icZ == null) {
                return 0;
            }
            try {
                byteArrayOutputStream.write(icY);
                byteArrayOutputStream2.write(icZ);
                return 0;
            } catch (IOException e2) {
                return 0;
            }
        }
    }

    public final void requestDoSync() {
        if (aa.VZ() != null) {
            try {
                aa.VV().post(new Runnable() {
                    public final void run() {
                        aa.VZ().onPush(24, n.eh(7));
                    }
                });
            } catch (Exception e) {
                x.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
            }
        }
    }

    public final boolean isLogoned() {
        boolean z = false;
        if (aa.VX() == null) {
            return z;
        }
        try {
            return aa.VX().iby.Kz();
        } catch (Exception e) {
            x.e("StnCallBack", exception2String(e));
            new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[z]).append(", ").append(e.getStackTrace()[1]);
            return z;
        }
    }

    public final void networkAnalysisCallBack(int i, int i2, boolean z, String str) {
        x.i("StnCallBack", "networkAnalysisCallBack: status:%d, stage:%d, isDetectEnd:%b, kvInfo:%s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), str);
        try {
            aa.VX().ibG.networkAnalysisCallBack(i, i2, z, str);
        } catch (Throwable e) {
            x.printErrStackTrace("StnCallBack", e, "", new Object[0]);
            new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
        }
    }
}
