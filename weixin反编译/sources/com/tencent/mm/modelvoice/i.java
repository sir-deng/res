package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.io.File;
import java.io.FileInputStream;

public final class i implements d {
    private static Object hYG = new Object();
    private static int hYH = -1;
    private static int hYI;
    private static int hYN = 100;
    public int fli;
    private b hYA;
    private com.tencent.mm.modelvoice.d.a hYB;
    private d.b hYC;
    private volatile boolean hYD;
    private String hYE;
    private String hYF;
    private int hYJ;
    private int hYK;
    private com.tencent.mm.audio.c.b hYL;
    private int hYM;
    private OnCompletionListener hYO;
    private OnErrorListener hYP;
    private a hYz;
    private AudioTrack mAudioTrack;
    private String mFileName;
    public int mSampleRate;
    private int mStatus;

    private class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(i iVar, byte b) {
            this();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r12 = this;
            r0 = -16;
            android.os.Process.setThreadPriority(r0);	 Catch:{ Exception -> 0x00ad }
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r0 = r0.mSampleRate;	 Catch:{ Exception -> 0x00ad }
            r1 = 2;
            r2 = 2;
            r0 = android.media.AudioTrack.getMinBufferSize(r0, r1, r2);	 Catch:{ Exception -> 0x00ad }
            r0 = r0 * 2;
            r9 = new byte[r0];	 Catch:{ Exception -> 0x00ad }
            r1 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r1 = r1.mSampleRate;	 Catch:{ Exception -> 0x00ad }
            r1 = r1 * 20;
            r1 = r1 / 1000;
            r10 = (short) r1;	 Catch:{ Exception -> 0x00ad }
            r1 = "MicroMsg.SilkPlayer";
            r2 = "frameLen: %d, playBufferSize: %d";
            r3 = 2;
            r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00ad }
            r4 = 0;
            r5 = java.lang.Short.valueOf(r10);	 Catch:{ Exception -> 0x00ad }
            r3[r4] = r5;	 Catch:{ Exception -> 0x00ad }
            r4 = 1;
            r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00ad }
            r3[r4] = r0;	 Catch:{ Exception -> 0x00ad }
            com.tencent.mm.sdk.platformtools.x.d(r1, r2, r3);	 Catch:{ Exception -> 0x00ad }
            r0 = "MicroMsg.SilkPlayer";
            r1 = "Thread start";
            com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ Exception -> 0x00ad }
        L_0x0043:
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r0 = r0.mStatus;	 Catch:{ Exception -> 0x00ad }
            r1 = 1;
            if (r0 == r1) goto L_0x0055;
        L_0x004c:
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r0 = r0.mStatus;	 Catch:{ Exception -> 0x00ad }
            r1 = 2;
            if (r0 != r1) goto L_0x02e4;
        L_0x0055:
            r1 = com.tencent.mm.modelvoice.i.hYG;	 Catch:{ Exception -> 0x00ad }
            monitor-enter(r1);	 Catch:{ Exception -> 0x00ad }
            r0 = com.tencent.mm.modelvoice.i.hYI;	 Catch:{ all -> 0x0145 }
            r2 = com.tencent.mm.modelvoice.i.this;	 Catch:{ all -> 0x0145 }
            r2 = r2.hYJ;	 Catch:{ all -> 0x0145 }
            if (r0 == r2) goto L_0x0095;
        L_0x0066:
            r0 = "MicroMsg.SilkPlayer";
            r2 = "[%d] diff id, useDeocder: %d";
            r3 = 2;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0145 }
            r4 = 0;
            r5 = com.tencent.mm.modelvoice.i.this;	 Catch:{ all -> 0x0145 }
            r5 = r5.hYJ;	 Catch:{ all -> 0x0145 }
            r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x0145 }
            r3[r4] = r5;	 Catch:{ all -> 0x0145 }
            r4 = 1;
            r5 = com.tencent.mm.modelvoice.i.hYI;	 Catch:{ all -> 0x0145 }
            r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x0145 }
            r3[r4] = r5;	 Catch:{ all -> 0x0145 }
            com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);	 Catch:{ all -> 0x0145 }
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ all -> 0x0145 }
            r2 = com.tencent.mm.modelvoice.i.this;	 Catch:{ all -> 0x0145 }
            r2 = r2.mFileName;	 Catch:{ all -> 0x0145 }
            r0.nR(r2);	 Catch:{ all -> 0x0145 }
        L_0x0095:
            monitor-exit(r1);	 Catch:{ all -> 0x0145 }
        L_0x0096:
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r0 = r0.hYD;	 Catch:{ Exception -> 0x00ad }
            if (r0 == 0) goto L_0x0148;
        L_0x009e:
            r0 = "MicroMsg.SilkPlayer";
            r1 = "waitting for switching complete";
            com.tencent.mm.sdk.platformtools.x.d(r0, r1);	 Catch:{ Exception -> 0x00ad }
            r0 = 20;
            java.lang.Thread.sleep(r0);	 Catch:{ Exception -> 0x00ad }
            goto L_0x0096;
        L_0x00ad:
            r0 = move-exception;
            r1 = com.tencent.mm.plugin.report.service.g.pWK;
            r2 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
            r4 = 0;
            r6 = 1;
            r8 = 0;
            r1.a(r2, r4, r6, r8);
            r1 = "MicroMsg.SilkPlayer";
            r2 = "exception:%s";
            r3 = 1;
            r3 = new java.lang.Object[r3];
            r4 = 0;
            r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
            r3[r4] = r0;
            com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
            r0 = com.tencent.mm.modelvoice.i.this;
            r0 = r0.hYP;
            if (r0 == 0) goto L_0x00e1;
        L_0x00d5:
            r0 = com.tencent.mm.modelvoice.i.this;
            r0 = r0.hYP;
            r1 = 0;
            r2 = 0;
            r3 = 0;
            r0.onError(r1, r2, r3);
        L_0x00e1:
            r0 = com.tencent.mm.modelvoice.i.this;
            r1 = 0;
            r0.mStatus = r1;
        L_0x00e7:
            r1 = com.tencent.mm.modelvoice.i.hYG;
            monitor-enter(r1);
            r0 = com.tencent.mm.modelvoice.i.hYI;	 Catch:{ all -> 0x02f4 }
            r2 = com.tencent.mm.modelvoice.i.this;	 Catch:{ all -> 0x02f4 }
            r2 = r2.hYJ;	 Catch:{ all -> 0x02f4 }
            if (r0 != r2) goto L_0x0117;
        L_0x00f8:
            com.tencent.mm.modelvoice.MediaRecorder.SilkDecUnInit();	 Catch:{ all -> 0x02f4 }
            r0 = "MicroMsg.SilkPlayer";
            r2 = "[%d] SilkDecUnInit";
            r3 = 1;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x02f4 }
            r4 = 0;
            r5 = com.tencent.mm.modelvoice.i.this;	 Catch:{ all -> 0x02f4 }
            r5 = r5.hYJ;	 Catch:{ all -> 0x02f4 }
            r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x02f4 }
            r3[r4] = r5;	 Catch:{ all -> 0x02f4 }
            com.tencent.mm.sdk.platformtools.x.i(r0, r2, r3);	 Catch:{ all -> 0x02f4 }
            com.tencent.mm.modelvoice.i.hYI = -1;	 Catch:{ all -> 0x02f4 }
        L_0x0117:
            monitor-exit(r1);	 Catch:{ all -> 0x02f4 }
            r0 = com.tencent.mm.modelvoice.i.this;
            r0 = r0.mStatus;
            r1 = 3;
            if (r0 == r1) goto L_0x02f7;
        L_0x0121:
            r0 = com.tencent.mm.modelvoice.i.this;
            r0 = r0.hYB;
            if (r0 == 0) goto L_0x0132;
        L_0x0129:
            r0 = com.tencent.mm.modelvoice.i.this;
            r0 = r0.hYB;
            r0.vi();
        L_0x0132:
            r0 = com.tencent.mm.modelvoice.i.this;
            r0 = r0.hYO;
            if (r0 == 0) goto L_0x0144;
        L_0x013a:
            r0 = com.tencent.mm.modelvoice.i.this;
            r0 = r0.hYO;
            r1 = 0;
            r0.onCompletion(r1);
        L_0x0144:
            return;
        L_0x0145:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0145 }
            throw r0;	 Catch:{ Exception -> 0x00ad }
        L_0x0148:
            r11 = com.tencent.mm.modelvoice.MediaRecorder.SilkDoDec(r9, r10);	 Catch:{ Exception -> 0x00ad }
            if (r11 >= 0) goto L_0x01a3;
        L_0x014e:
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r1 = 0;
            r0.mStatus = r1;	 Catch:{ Exception -> 0x00ad }
            r1 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ Exception -> 0x00ad }
            r2 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
            r4 = 0;
            r6 = 1;
            r8 = 0;
            r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x00ad }
            r1 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ Exception -> 0x00ad }
            r2 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
            r4 = 4;
            r6 = 1;
            r8 = 0;
            r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x00ad }
            r0 = "MicroMsg.SilkPlayer";
            r1 = "[%d] SilkDoDec failed: %d";
            r2 = 2;
            r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x00ad }
            r3 = 0;
            r4 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r4 = r4.hYJ;	 Catch:{ Exception -> 0x00ad }
            r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x00ad }
            r2[r3] = r4;	 Catch:{ Exception -> 0x00ad }
            r3 = 1;
            r4 = java.lang.Integer.valueOf(r11);	 Catch:{ Exception -> 0x00ad }
            r2[r3] = r4;	 Catch:{ Exception -> 0x00ad }
            com.tencent.mm.sdk.platformtools.x.e(r0, r1, r2);	 Catch:{ Exception -> 0x00ad }
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r0 = r0.hYL;	 Catch:{ Exception -> 0x00ad }
            if (r0 == 0) goto L_0x0043;
        L_0x0194:
            r0 = com.tencent.mm.platformtools.r.igr;	 Catch:{ Exception -> 0x00ad }
            if (r0 == 0) goto L_0x0043;
        L_0x0198:
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r0 = r0.hYL;	 Catch:{ Exception -> 0x00ad }
            r0.vM();	 Catch:{ Exception -> 0x00ad }
            goto L_0x0043;
        L_0x01a3:
            r0 = com.tencent.mm.platformtools.r.igr;	 Catch:{ Exception -> 0x00ad }
            if (r0 == 0) goto L_0x01ba;
        L_0x01a7:
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r0 = r0.hYL;	 Catch:{ Exception -> 0x00ad }
            if (r0 == 0) goto L_0x01ba;
        L_0x01af:
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r0 = r0.hYL;	 Catch:{ Exception -> 0x00ad }
            r1 = r10 * 2;
            r0.u(r9, r1);	 Catch:{ Exception -> 0x00ad }
        L_0x01ba:
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x020b }
            r0 = r0.mAudioTrack;	 Catch:{ Exception -> 0x020b }
            r1 = 0;
            r2 = r10 * 2;
            r0.write(r9, r1, r2);	 Catch:{ Exception -> 0x020b }
        L_0x01c6:
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r0.hYK = r0.hYK + 1;	 Catch:{ Exception -> 0x00ad }
            if (r11 != 0) goto L_0x0238;
        L_0x01cd:
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r1 = 0;
            r0.mStatus = r1;	 Catch:{ Exception -> 0x00ad }
            r0 = "MicroMsg.SilkPlayer";
            r1 = "[%d] play completed";
            r2 = 1;
            r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x00ad }
            r3 = 0;
            r4 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r4 = r4.hYJ;	 Catch:{ Exception -> 0x00ad }
            r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x00ad }
            r2[r3] = r4;	 Catch:{ Exception -> 0x00ad }
            com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ Exception -> 0x00ad }
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r0 = r0.hYL;	 Catch:{ Exception -> 0x00ad }
            if (r0 == 0) goto L_0x0043;
        L_0x01f4:
            r0 = com.tencent.mm.platformtools.r.igr;	 Catch:{ Exception -> 0x00ad }
            if (r0 == 0) goto L_0x0043;
        L_0x01f8:
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r0 = r0.hYL;	 Catch:{ Exception -> 0x00ad }
            r0.vM();	 Catch:{ Exception -> 0x00ad }
            r0 = new com.tencent.mm.modelvoice.i$a$1;	 Catch:{ Exception -> 0x00ad }
            r0.<init>();	 Catch:{ Exception -> 0x00ad }
            com.tencent.mm.sdk.platformtools.ah.y(r0);	 Catch:{ Exception -> 0x00ad }
            goto L_0x0043;
        L_0x020b:
            r0 = move-exception;
            r1 = "MicroMsg.SilkPlayer";
            r2 = "write audio track failed: %s";
            r3 = 1;
            r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00ad }
            r4 = 0;
            r0 = r0.getMessage();	 Catch:{ Exception -> 0x00ad }
            r3[r4] = r0;	 Catch:{ Exception -> 0x00ad }
            com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);	 Catch:{ Exception -> 0x00ad }
            r1 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ Exception -> 0x00ad }
            r2 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
            r4 = 0;
            r6 = 1;
            r8 = 0;
            r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x00ad }
            r1 = com.tencent.mm.plugin.report.service.g.pWK;	 Catch:{ Exception -> 0x00ad }
            r2 = 161; // 0xa1 float:2.26E-43 double:7.95E-322;
            r4 = 5;
            r6 = 1;
            r8 = 0;
            r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x00ad }
            goto L_0x01c6;
        L_0x0238:
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r0 = r0.mStatus;	 Catch:{ Exception -> 0x00ad }
            r1 = 2;
            if (r0 != r1) goto L_0x02b9;
        L_0x0241:
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r1 = r0.hYF;	 Catch:{ Exception -> 0x00ad }
            monitor-enter(r1);	 Catch:{ Exception -> 0x00ad }
            r0 = "MicroMsg.SilkPlayer";
            r2 = "before mOk.notify";
            com.tencent.mm.sdk.platformtools.x.v(r0, r2);	 Catch:{ Exception -> 0x028c }
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x028c }
            r0 = r0.hYF;	 Catch:{ Exception -> 0x028c }
            r0.notify();	 Catch:{ Exception -> 0x028c }
            r0 = "MicroMsg.SilkPlayer";
            r2 = "after mOk.notify";
            com.tencent.mm.sdk.platformtools.x.v(r0, r2);	 Catch:{ Exception -> 0x028c }
        L_0x0263:
            monitor-exit(r1);	 Catch:{ all -> 0x02a1 }
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r1 = r0.hYE;	 Catch:{ Exception -> 0x00ad }
            monitor-enter(r1);	 Catch:{ Exception -> 0x00ad }
            r0 = "MicroMsg.SilkPlayer";
            r2 = "before mpause.wait";
            com.tencent.mm.sdk.platformtools.x.v(r0, r2);	 Catch:{ Exception -> 0x02a4 }
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x02a4 }
            r0 = r0.hYE;	 Catch:{ Exception -> 0x02a4 }
            r0.wait();	 Catch:{ Exception -> 0x02a4 }
            r0 = "MicroMsg.SilkPlayer";
            r2 = "after mpause.wait";
            com.tencent.mm.sdk.platformtools.x.v(r0, r2);	 Catch:{ Exception -> 0x02a4 }
        L_0x0286:
            monitor-exit(r1);	 Catch:{ all -> 0x0289 }
            goto L_0x0043;
        L_0x0289:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0289 }
            throw r0;	 Catch:{ Exception -> 0x00ad }
        L_0x028c:
            r0 = move-exception;
            r2 = "MicroMsg.SilkPlayer";
            r3 = "exception:%s";
            r4 = 1;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x02a1 }
            r5 = 0;
            r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);	 Catch:{ all -> 0x02a1 }
            r4[r5] = r0;	 Catch:{ all -> 0x02a1 }
            com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x02a1 }
            goto L_0x0263;
        L_0x02a1:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x02a1 }
            throw r0;	 Catch:{ Exception -> 0x00ad }
        L_0x02a4:
            r0 = move-exception;
            r2 = "MicroMsg.SilkPlayer";
            r3 = "exception:%s";
            r4 = 1;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0289 }
            r5 = 0;
            r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);	 Catch:{ all -> 0x0289 }
            r4[r5] = r0;	 Catch:{ all -> 0x0289 }
            com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x0289 }
            goto L_0x0286;
        L_0x02b9:
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r1 = r0.hYF;	 Catch:{ Exception -> 0x00ad }
            monitor-enter(r1);	 Catch:{ Exception -> 0x00ad }
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x02cf }
            r0 = r0.hYF;	 Catch:{ Exception -> 0x02cf }
            r0.notify();	 Catch:{ Exception -> 0x02cf }
        L_0x02c9:
            monitor-exit(r1);	 Catch:{ all -> 0x02cc }
            goto L_0x0043;
        L_0x02cc:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x02cc }
            throw r0;	 Catch:{ Exception -> 0x00ad }
        L_0x02cf:
            r0 = move-exception;
            r2 = "MicroMsg.SilkPlayer";
            r3 = "exception:%s";
            r4 = 1;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x02cc }
            r5 = 0;
            r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);	 Catch:{ all -> 0x02cc }
            r4[r5] = r0;	 Catch:{ all -> 0x02cc }
            com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);	 Catch:{ all -> 0x02cc }
            goto L_0x02c9;
        L_0x02e4:
            r0 = com.tencent.mm.modelvoice.i.this;	 Catch:{ Exception -> 0x00ad }
            r0 = r0.mStatus;	 Catch:{ Exception -> 0x00ad }
            r1 = 3;
            if (r0 == r1) goto L_0x00e7;
        L_0x02ed:
            r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            java.lang.Thread.sleep(r0);	 Catch:{ Exception -> 0x00ad }
            goto L_0x00e7;
        L_0x02f4:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x02f4 }
            throw r0;
        L_0x02f7:
            r0 = com.tencent.mm.modelvoice.i.this;
            r0 = r0.mAudioTrack;
            if (r0 == 0) goto L_0x0144;
        L_0x02ff:
            r0 = "MicroMsg.SilkPlayer";
            r1 = "mAudioTrack.stop()";
            com.tencent.mm.sdk.platformtools.x.i(r0, r1);
            r0 = com.tencent.mm.modelvoice.i.this;
            r0 = r0.mAudioTrack;
            r0.stop();
            r0 = com.tencent.mm.modelvoice.i.this;
            r0 = r0.mAudioTrack;
            r0.release();
            r0 = com.tencent.mm.modelvoice.i.this;
            r0.mAudioTrack = null;
            goto L_0x0144;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.i.a.run():void");
        }
    }

    public final int getStatus() {
        return this.mStatus;
    }

    public i() {
        this.hYB = null;
        this.hYC = null;
        this.fli = 2;
        this.mSampleRate = 16000;
        this.mFileName = "";
        this.mStatus = 0;
        this.hYD = false;
        this.hYE = "";
        this.hYF = "";
        this.hYK = 0;
        this.hYL = null;
        this.hYM = 8;
        this.hYO = new OnCompletionListener() {
            public final void onCompletion(MediaPlayer mediaPlayer) {
                if (i.this.hYA != null) {
                    x.i("MicroMsg.SilkPlayer", "silkPlayer play onCompletion abandonFocus");
                    i.this.hYA.zk();
                }
                try {
                    i.this.mStatus = 0;
                    if (i.this.mAudioTrack != null) {
                        x.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                        i.this.mAudioTrack.stop();
                        i.this.mAudioTrack.release();
                        i.this.mAudioTrack = null;
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.SilkPlayer", "exception:%s", bi.i(e));
                    x.e("MicroMsg.SilkPlayer", "setCompletion File[" + i.this.mFileName + "] ErrMsg[" + e.getStackTrace() + "]");
                }
            }
        };
        this.hYP = new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                x.i("MicroMsg.SilkPlayer", "onError");
                if (i.this.hYA != null) {
                    i.this.hYA.zk();
                }
                if (i.this.hYC != null) {
                    i.this.hYC.onError();
                }
                try {
                    i.this.mStatus = -1;
                    if (i.this.mAudioTrack != null) {
                        x.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
                        i.this.mAudioTrack.stop();
                        i.this.mAudioTrack.release();
                        i.this.mAudioTrack = null;
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.SilkPlayer", "setErrorListener File[" + i.this.mFileName + "] ErrMsg[" + e.getStackTrace() + "]");
                }
                return false;
            }
        };
        hYH++;
        this.hYJ = hYH;
        x.i("MicroMsg.SilkPlayer", "[%d] new Instance", Integer.valueOf(this.hYJ));
    }

    public i(Context context) {
        this();
        this.hYA = new b(context);
    }

    public final void a(com.tencent.mm.modelvoice.d.a aVar) {
        this.hYB = aVar;
    }

    public final void a(d.b bVar) {
        this.hYC = bVar;
    }

    public final void aO(boolean z) {
        x.d("MicroMsg.SilkPlayer", "setSpeakerOn: %b", Boolean.valueOf(z));
        this.hYD = true;
        this.fli = 2;
        cc(z);
        try {
            this.mAudioTrack.play();
        } catch (Exception e) {
            g.pWK.a(161, 0, 1, false);
            g.pWK.a(161, 3, 1, false);
            x.e("MicroMsg.SilkPlayer", "audioTrack error:%s", e.getMessage());
        }
        this.hYD = false;
    }

    private void cc(boolean z) {
        int i;
        int i2;
        int minBufferSize;
        AudioTrack dVar;
        if (this.mAudioTrack != null) {
            x.i("MicroMsg.SilkPlayer", "mAudioTrack.stop()");
            try {
                this.mAudioTrack.stop();
                this.mAudioTrack.release();
            } catch (Exception e) {
                x.e("MicroMsg.SilkPlayer", "mAudioTrack.stop() error: %s", e.getMessage());
            }
            this.mAudioTrack = null;
        }
        int i3 = this.mSampleRate;
        int i4 = this.fli;
        int i5 = this.hYM;
        if (z) {
            i = 3;
        } else {
            boolean i6 = false;
        }
        if (q.gHG.gEr) {
            q.gHG.dump();
            if (z && q.gHG.gEU >= 0) {
                i2 = q.gHG.gEU;
                minBufferSize = AudioTrack.getMinBufferSize(i3, i4, 2);
                x.i("AudioDeviceFactory", "speakerOn: %b, type: %d, sampleRate: %d, channelConfig: %d, PlayBufSize: %d, bufTimes: %d", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(minBufferSize), Integer.valueOf(i5));
                dVar = new d(i2, i3, i4, 2, i5 * minBufferSize);
                if (dVar.getState() == 0) {
                    dVar.release();
                    x.i("AudioDeviceFactory", "reconstruct AudioTrack");
                    if (i2 == 0) {
                    }
                    dVar = new d(i2 == 0 ? 3 : 0, i3, i4, 2, i5 * minBufferSize);
                }
                x.i("AudioDeviceFactory", "AudioTrack state: " + dVar.getState());
                this.mAudioTrack = dVar;
                if (this.mAudioTrack != null) {
                }
                g.pWK.a(161, 0, 1, false);
                g.pWK.a(161, 2, 1, false);
                if (this.mAudioTrack == null) {
                    this.mAudioTrack.release();
                    this.mAudioTrack = null;
                }
            } else if (!z && q.gHG.gEV >= 0) {
                i2 = q.gHG.gEV;
                minBufferSize = AudioTrack.getMinBufferSize(i3, i4, 2);
                x.i("AudioDeviceFactory", "speakerOn: %b, type: %d, sampleRate: %d, channelConfig: %d, PlayBufSize: %d, bufTimes: %d", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(minBufferSize), Integer.valueOf(i5));
                dVar = new d(i2, i3, i4, 2, i5 * minBufferSize);
                if (dVar.getState() == 0) {
                    dVar.release();
                    x.i("AudioDeviceFactory", "reconstruct AudioTrack");
                    dVar = new d(i2 == 0 ? 3 : 0, i3, i4, 2, i5 * minBufferSize);
                }
                x.i("AudioDeviceFactory", "AudioTrack state: " + dVar.getState());
                this.mAudioTrack = dVar;
                if (this.mAudioTrack != null || this.mAudioTrack.getState() == 0) {
                    g.pWK.a(161, 0, 1, false);
                    g.pWK.a(161, 2, 1, false);
                    if (this.mAudioTrack == null) {
                        this.mAudioTrack.release();
                        this.mAudioTrack = null;
                    }
                }
                return;
            }
        }
        i2 = i6;
        minBufferSize = AudioTrack.getMinBufferSize(i3, i4, 2);
        x.i("AudioDeviceFactory", "speakerOn: %b, type: %d, sampleRate: %d, channelConfig: %d, PlayBufSize: %d, bufTimes: %d", Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(minBufferSize), Integer.valueOf(i5));
        dVar = new d(i2, i3, i4, 2, i5 * minBufferSize);
        if (dVar.getState() == 0) {
            dVar.release();
            x.i("AudioDeviceFactory", "reconstruct AudioTrack");
            if (i2 == 0) {
            }
            dVar = new d(i2 == 0 ? 3 : 0, i3, i4, 2, i5 * minBufferSize);
        }
        x.i("AudioDeviceFactory", "AudioTrack state: " + dVar.getState());
        this.mAudioTrack = dVar;
        if (this.mAudioTrack != null) {
        }
        g.pWK.a(161, 0, 1, false);
        g.pWK.a(161, 2, 1, false);
        try {
            if (this.mAudioTrack == null) {
                this.mAudioTrack.release();
                this.mAudioTrack = null;
            }
        } catch (Exception e2) {
        }
    }

    public final boolean K(String str, boolean z) {
        return L(str, z);
    }

    public final boolean c(String str, boolean z, int i) {
        return L(str, z);
    }

    private boolean L(String str, boolean z) {
        int i = 2;
        if (this.mStatus != 0) {
            x.e("MicroMsg.SilkPlayer", "startPlay error status:" + this.mStatus);
            return false;
        }
        if (r.igr) {
            ax(str, com.tencent.mm.audio.b.g.flI);
        }
        x.i("MicroMsg.SilkPlayer", "startPlay");
        this.mStatus = 1;
        this.mFileName = str;
        synchronized (hYG) {
            nR(str);
        }
        if (r.igr) {
            int i2;
            String str2 = com.tencent.mm.audio.b.g.flH;
            if (this.fli == 2) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            this.hYL = new com.tencent.mm.audio.c.b(str2, i2, this.mSampleRate);
        }
        String str3 = "MicroMsg.SilkPlayer";
        String str4 = "startPlay, sampleRate: %d, channelCnt: %d ";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.mSampleRate);
        if (this.fli == 2) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        x.d(str3, str4, objArr);
        try {
            return cd(z);
        } catch (Throwable e) {
            try {
                return cd(true);
            } catch (Exception e2) {
                x.e("MicroMsg.SilkPlayer", "startPlay File[" + this.mFileName + "] failed");
                x.e("MicroMsg.SilkPlayer", "exception:%s", bi.i(e));
                this.mStatus = -1;
                return false;
            }
        }
    }

    private void nR(String str) {
        int available;
        hYI = this.hYJ;
        x.i("MicroMsg.SilkPlayer", "[%d] SilkDecInit", Integer.valueOf(this.hYJ));
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            available = fileInputStream.available();
            x.d("MicroMsg.SilkPlayer", "SilkDecInit streamlen:%d", Integer.valueOf(available));
            if (!f.xN().xS() || available >= 5000) {
                this.hYM = 8;
            } else {
                this.hYM = 1;
            }
            byte[] bArr = new byte[available];
            fileInputStream.read(bArr, 0, available);
            this.mSampleRate = MediaRecorder.SilkGetEncSampleRate(new byte[]{bArr[0]});
            MediaRecorder.SilkDecUnInit();
            MediaRecorder.SilkDecInit(this.mSampleRate, bArr, available);
            available = -1;
            c fp = com.tencent.mm.y.c.c.IL().fp("100268");
            if (fp.isValid()) {
                available = bi.getInt((String) fp.civ().get("SilkAudioPlayerAgcOn"), 0);
            }
            if (1 == available || available == 0) {
                MediaRecorder.SetVoiceSilkDecControl(hYN, new byte[]{(byte) available}, 1);
            }
            fileInputStream.close();
        } catch (Throwable e) {
            g.pWK.a(161, 0, 1, false);
            g.pWK.a(161, 1, 1, false);
            x.e("MicroMsg.SilkPlayer", "exception:%s", bi.i(e));
        }
        x.d("MicroMsg.SilkPlayer", "[%d] skip %d frames", Integer.valueOf(this.hYJ), Integer.valueOf(this.hYK));
        byte[] bArr2 = new byte[(AudioTrack.getMinBufferSize(this.mSampleRate, 2, 2) * 2)];
        short s = (short) ((this.mSampleRate * 20) / 1000);
        for (available = 0; available < this.hYK; available++) {
            if (MediaRecorder.SilkDoDec(bArr2, s) <= 0) {
                x.e("MicroMsg.SilkPlayer", "[%d], skip frame failed: %d", Integer.valueOf(this.hYJ), Integer.valueOf(MediaRecorder.SilkDoDec(bArr2, s)));
                return;
            }
        }
    }

    private boolean cd(boolean z) {
        if (!e.bO(this.mFileName)) {
            return false;
        }
        try {
            cc(z);
            if (this.mAudioTrack == null) {
                return false;
            }
            if (this.hYA != null) {
                this.hYA.requestFocus();
            }
            return UE();
        } catch (Throwable e) {
            if (this.hYA != null) {
                this.hYA.zk();
            }
            x.e("MicroMsg.SilkPlayer", "playImp : fail, exception = " + e.getMessage());
            x.e("MicroMsg.SilkPlayer", "exception:%s", bi.i(e));
            return false;
        }
    }

    private boolean UE() {
        if (this.mAudioTrack == null) {
            return false;
        }
        try {
            x.i("MicroMsg.SilkPlayer", "play");
            this.mAudioTrack.play();
            this.hYz = new a();
            com.tencent.mm.sdk.f.e.b(this.hYz, "SilkPlayer_play_" + this.hYJ, 10);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.SilkPlayer", "audioTrack error:%s", e.getMessage());
            g.pWK.a(161, 0, 1, false);
            g.pWK.a(161, 3, 1, false);
            return false;
        }
    }

    public final boolean aM(boolean z) {
        if (this.mStatus != 1) {
            return false;
        }
        this.mStatus = 2;
        synchronized (this.hYF) {
            try {
                x.v("MicroMsg.SilkPlayer", "before mOk.wait");
                long currentTimeMillis = System.currentTimeMillis();
                this.hYF.wait();
                x.v("MicroMsg.SilkPlayer", "after mOk.wait time:" + (System.currentTimeMillis() - currentTimeMillis));
            } catch (Throwable e) {
                x.e("MicroMsg.SilkPlayer", "exception:%s", bi.i(e));
                return false;
            }
        }
        if (this.hYA != null && z) {
            this.hYA.zk();
        }
        return true;
    }

    public final boolean vd() {
        if (this.mStatus != 2) {
            return false;
        }
        this.mStatus = 1;
        synchronized (this.hYE) {
            try {
                x.v("MicroMsg.SilkPlayer", "before mpause.notify");
                this.hYE.notify();
                x.v("MicroMsg.SilkPlayer", "after mpause.notify");
            } catch (Throwable e) {
                x.e("MicroMsg.SilkPlayer", "exception:%s", bi.i(e));
                return false;
            }
        }
        if (this.hYA != null) {
            this.hYA.requestFocus();
        }
        return true;
    }

    public final boolean isPlaying() {
        return this.mStatus == 1;
    }

    public final boolean vp() {
        x.i("MicroMsg.SilkPlayer", "stop  status:" + this.mStatus);
        if (this.mStatus == 1 || this.mStatus == 2) {
            this.mStatus = 3;
            synchronized (this.hYE) {
                try {
                    this.hYE.notify();
                    if (this.hYA != null) {
                        this.hYA.zk();
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.SilkPlayer", "exception:%s", bi.i(e));
                    if (this.hYA != null) {
                        this.hYA.zk();
                    }
                    return false;
                } catch (Throwable th) {
                    if (this.hYA != null) {
                        this.hYA.zk();
                    }
                }
            }
            return true;
        }
        x.e("MicroMsg.SilkPlayer", "stop  error status:" + this.mStatus);
        return false;
    }

    public final double vg() {
        return 0.0d;
    }

    public final void b(com.tencent.mm.compatible.util.b.a aVar) {
        if (aVar != null && this.hYA != null) {
            this.hYA.a(aVar);
        }
    }

    public final String ax(String str, String str2) {
        Throwable e;
        String str3 = null;
        if (this.mStatus != 0) {
            x.e("MicroMsg.SilkPlayer", "startPlay error status:" + this.mStatus);
            return str3;
        }
        this.mStatus = 1;
        this.mFileName = str;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                int available = fileInputStream.available();
                byte[] bArr = new byte[available];
                fileInputStream.read(bArr, 0, available);
                this.mSampleRate = MediaRecorder.SilkGetEncSampleRate(new byte[]{bArr[0]});
                MediaRecorder.SilkDecInit(this.mSampleRate, bArr, available);
                x.i("MicroMsg.SilkPlayer", "[%d] SilkDecInit in silkToPcm", Integer.valueOf(this.hYJ));
                fileInputStream.close();
                return nS(str2);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = str3;
            x.e("MicroMsg.SilkPlayer", "silkToPcm, file[%s], exception: %s", this.mFileName, e.getMessage());
            x.e("MicroMsg.SilkPlayer", "exception:%s", bi.i(e));
            this.mStatus = -1;
            if (fileInputStream == null) {
                return str3;
            }
            try {
                fileInputStream.close();
                return str3;
            } catch (Throwable e4) {
                x.printErrStackTrace("MicroMsg.SilkPlayer", e4, "", new Object[0]);
                return str3;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String nS(java.lang.String r12) {
        /*
        r11 = this;
        r10 = 2;
        r0 = 0;
        r9 = 1;
        r8 = 0;
        r1 = "MicroMsg.SilkPlayer";
        r2 = "hakon silkToPcmImpl()";
        com.tencent.mm.sdk.platformtools.x.d(r1, r2);
        r1 = r11.mFileName;
        r1 = com.tencent.mm.a.e.bO(r1);
        if (r1 != 0) goto L_0x0026;
    L_0x0015:
        r1 = "MicroMsg.SilkPlayer";
        r2 = "hakon silkToPcmImpl(), file not exist, fileName = %s";
        r3 = new java.lang.Object[r9];
        r4 = r11.mFileName;
        r3[r8] = r4;
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
        r12 = r0;
    L_0x0025:
        return r12;
    L_0x0026:
        r1 = "MicroMsg.SilkPlayer";
        r2 = "hakon silkToPcmImpl thread start";
        com.tencent.mm.sdk.platformtools.x.d(r1, r2);	 Catch:{ Exception -> 0x012f }
        r1 = -16;
        android.os.Process.setThreadPriority(r1);	 Catch:{ Exception -> 0x012f }
        r1 = r11.mSampleRate;	 Catch:{ Exception -> 0x012f }
        r2 = 2;
        r3 = 2;
        r1 = android.media.AudioTrack.getMinBufferSize(r1, r2, r3);	 Catch:{ Exception -> 0x012f }
        r1 = r1 << 1;
        r1 = new byte[r1];	 Catch:{ Exception -> 0x012f }
        r2 = r11.mSampleRate;	 Catch:{ Exception -> 0x012f }
        r2 = r2 * 20;
        r2 = r2 / 1000;
        r3 = (short) r2;	 Catch:{ Exception -> 0x012f }
        nT(r12);	 Catch:{ Exception -> 0x012f }
        r2 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x012f }
        r2.<init>(r12);	 Catch:{ Exception -> 0x012f }
    L_0x004f:
        r4 = r11.mStatus;	 Catch:{ Exception -> 0x0061 }
        if (r4 == r9) goto L_0x0057;
    L_0x0053:
        r4 = r11.mStatus;	 Catch:{ Exception -> 0x0061 }
        if (r4 != r10) goto L_0x00b2;
    L_0x0057:
        r4 = com.tencent.mm.modelvoice.MediaRecorder.SilkDoDec(r1, r3);	 Catch:{ Exception -> 0x0061 }
        if (r4 >= 0) goto L_0x0099;
    L_0x005d:
        r4 = 0;
        r11.mStatus = r4;	 Catch:{ Exception -> 0x0061 }
        goto L_0x004f;
    L_0x0061:
        r1 = move-exception;
    L_0x0062:
        r3 = "MicroMsg.SilkPlayer";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f1 }
        r5 = "hakon silkToPcmImpl thread exception: ";
        r4.<init>(r5);	 Catch:{ Exception -> 0x00f1 }
        r5 = r1.getMessage();	 Catch:{ Exception -> 0x00f1 }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00f1 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x00f1 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4);	 Catch:{ Exception -> 0x00f1 }
        r3 = "MicroMsg.SilkPlayer";
        r4 = "exception:%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x00f1 }
        r6 = 0;
        r1 = com.tencent.mm.sdk.platformtools.bi.i(r1);	 Catch:{ Exception -> 0x00f1 }
        r5[r6] = r1;	 Catch:{ Exception -> 0x00f1 }
        com.tencent.mm.sdk.platformtools.x.e(r3, r4, r5);	 Catch:{ Exception -> 0x00f1 }
        r1 = 0;
        r11.mStatus = r1;	 Catch:{ Exception -> 0x00f1 }
        if (r2 == 0) goto L_0x0097;
    L_0x0094:
        r2.close();	 Catch:{ IOException -> 0x0120 }
    L_0x0097:
        r12 = r0;
        goto L_0x0025;
    L_0x0099:
        r5 = r11.hYD;	 Catch:{ Exception -> 0x0061 }
        if (r5 == 0) goto L_0x00a3;
    L_0x009d:
        r6 = 20;
        java.lang.Thread.sleep(r6);	 Catch:{ Exception -> 0x0061 }
        goto L_0x0099;
    L_0x00a3:
        r5 = 0;
        r6 = r3 * 2;
        r2.write(r1, r5, r6);	 Catch:{ Exception -> 0x0061 }
        r2.flush();	 Catch:{ Exception -> 0x0061 }
        if (r4 != 0) goto L_0x004f;
    L_0x00ae:
        r4 = 0;
        r11.mStatus = r4;	 Catch:{ Exception -> 0x0061 }
        goto L_0x004f;
    L_0x00b2:
        r1 = "MicroMsg.SilkPlayer";
        r3 = "hakon silkToPcmImpl thread end";
        com.tencent.mm.sdk.platformtools.x.d(r1, r3);	 Catch:{ Exception -> 0x0061 }
        r2.close();	 Catch:{ Exception -> 0x0061 }
        r1 = com.tencent.mm.modelvoice.MediaRecorder.SilkDecUnInit();	 Catch:{ Exception -> 0x00f1 }
        r2 = "MicroMsg.SilkPlayer";
        r3 = "[%d] SilkDecUnInit in silkToPcmImpl";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x00f1 }
        r5 = 0;
        r6 = r11.hYJ;	 Catch:{ Exception -> 0x00f1 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00f1 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x00f1 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ Exception -> 0x00f1 }
        if (r1 == 0) goto L_0x0025;
    L_0x00d9:
        r2 = "MicroMsg.SilkPlayer";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00f1 }
        r4 = "hakon silkToPcmImpl res: ";
        r3.<init>(r4);	 Catch:{ Exception -> 0x00f1 }
        r1 = r3.append(r1);	 Catch:{ Exception -> 0x00f1 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00f1 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r1);	 Catch:{ Exception -> 0x00f1 }
        goto L_0x0025;
    L_0x00f1:
        r1 = move-exception;
        r2 = "MicroMsg.SilkPlayer";
        r3 = new java.lang.StringBuilder;
        r4 = "hakon silkToPcmImpl exception: ";
        r3.<init>(r4);
        r4 = r1.getMessage();
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        r2 = "MicroMsg.SilkPlayer";
        r3 = "exception:%s";
        r4 = new java.lang.Object[r9];
        r1 = com.tencent.mm.sdk.platformtools.bi.i(r1);
        r4[r8] = r1;
        com.tencent.mm.sdk.platformtools.x.e(r2, r3, r4);
        r12 = r0;
        goto L_0x0025;
    L_0x0120:
        r1 = move-exception;
        r2 = "MicroMsg.SilkPlayer";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x00f1 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r1, r3, r4);	 Catch:{ Exception -> 0x00f1 }
        goto L_0x0097;
    L_0x012f:
        r1 = move-exception;
        r2 = r0;
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.i.nS(java.lang.String):java.lang.String");
    }

    private static boolean nT(String str) {
        if (str == null) {
            return false;
        }
        try {
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf == -1) {
                x.w("MicroMsg.SilkPlayer", "ensureFileFloder end == -1");
                return false;
            }
            File file = new File(str.substring(0, lastIndexOf + 1));
            if (!file.exists()) {
                boolean z = file.mkdirs() || file.isDirectory();
                x.i("MicroMsg.SilkPlayer", "ensureFileFloder mkdir:%s,sucess:%s", r3, Boolean.valueOf(z));
            }
            return true;
        } catch (Exception e) {
            x.w("MicroMsg.SilkPlayer", "ensureFileFloder Exception:", e.getMessage());
            return false;
        }
    }
}
