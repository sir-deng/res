package com.tencent.mm.audio.b;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.audio.c.d;
import com.tencent.mm.bd.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private static Object fkn = new Object();
    private com.tencent.mm.audio.b.c.a fkA = new com.tencent.mm.audio.b.c.a() {
        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void q(byte[] r9, int r10) {
            /*
            r8 = this;
            r1 = 1;
            r0 = 0;
            r2 = "MicroMsg.MMAudioRecorder";
            r3 = "onRecPcmDataReady, markStop: %s";
            r4 = new java.lang.Object[r1];
            r5 = com.tencent.mm.audio.b.b.this;
            r5 = r5.fkw;
            r5 = java.lang.Boolean.valueOf(r5);
            r4[r0] = r5;
            com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);
            r2 = com.tencent.mm.audio.b.b.this;
            r2 = r2.fkt;
            r3 = com.tencent.mm.audio.b.b.b.STOPPED;
            if (r2 != r3) goto L_0x0035;
        L_0x0023:
            r2 = com.tencent.mm.audio.b.b.this;
            r2 = r2.fkw;
            if (r2 != 0) goto L_0x0035;
        L_0x002b:
            r0 = "MicroMsg.MMAudioRecorder";
            r1 = "recorder has been stopped";
            com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        L_0x0034:
            return;
        L_0x0035:
            r2 = com.tencent.mm.audio.b.b.fkn;
            monitor-enter(r2);
            r3 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x00d1 }
            r3 = r3.fkw;	 Catch:{ all -> 0x00d1 }
            if (r3 == 0) goto L_0x007d;
        L_0x0042:
            r3 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x00d1 }
            r3 = r3.fkr;	 Catch:{ all -> 0x00d1 }
            if (r3 == 0) goto L_0x00c7;
        L_0x004a:
            r0 = "MicroMsg.MMAudioRecorder";
            r3 = "do stop pcm recorder, last frame data: %s, read: %s";
            r4 = 2;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00d1 }
            r5 = 0;
            r4[r5] = r9;	 Catch:{ all -> 0x00d1 }
            r5 = 1;
            r6 = java.lang.Integer.valueOf(r10);	 Catch:{ all -> 0x00d1 }
            r4[r5] = r6;	 Catch:{ all -> 0x00d1 }
            com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);	 Catch:{ all -> 0x00d1 }
            r0 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x00d1 }
            r0 = r0.fkr;	 Catch:{ all -> 0x00d1 }
            r0.vj();	 Catch:{ all -> 0x00d1 }
            r0 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x00d1 }
            r0 = r0.fkr;	 Catch:{ all -> 0x00d1 }
            r3 = 0;
            r0.fle = r3;	 Catch:{ all -> 0x00d1 }
            r0 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x00d1 }
            r0.fkr = null;	 Catch:{ all -> 0x00d1 }
            r0 = r1;
        L_0x0078:
            r1 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x00d1 }
            r1.fkw = false;	 Catch:{ all -> 0x00d1 }
        L_0x007d:
            monitor-exit(r2);	 Catch:{ all -> 0x00d1 }
            r1 = com.tencent.mm.audio.b.b.this;
            r2 = r1.fkl;
            r2 = com.tencent.mm.sdk.platformtools.bi.bA(r2);
            r1 = com.tencent.mm.audio.b.b.this;
            r4 = r1.fkk;
            r6 = 0;
            r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
            if (r1 <= 0) goto L_0x00d4;
        L_0x0094:
            r1 = com.tencent.mm.audio.b.b.this;
            r4 = r1.fkk;
            r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r1 <= 0) goto L_0x00d4;
        L_0x009e:
            r0 = "MicroMsg.MMAudioRecorder";
            r1 = new java.lang.StringBuilder;
            r4 = "Stop now ! expire duration ms:";
            r1.<init>(r4);
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.x.w(r0, r1);
            r0 = new com.tencent.mm.sdk.platformtools.ag;
            r1 = android.os.Looper.getMainLooper();
            r0.<init>(r1);
            r1 = new com.tencent.mm.audio.b.b$2$1;
            r1.<init>();
            r0.post(r1);
            goto L_0x0034;
        L_0x00c7:
            r1 = "MicroMsg.MMAudioRecorder";
            r3 = "stop now, but recorder is null";
            com.tencent.mm.sdk.platformtools.x.i(r1, r3);	 Catch:{ all -> 0x00d1 }
            goto L_0x0078;
        L_0x00d1:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x00d1 }
            throw r0;
        L_0x00d4:
            r1 = "MicroMsg.MMAudioRecorder";
            r2 = new java.lang.StringBuilder;
            r3 = "read :";
            r2.<init>(r3);
            r2 = r2.append(r10);
            r3 = " time: ";
            r2 = r2.append(r3);
            r3 = com.tencent.mm.audio.b.b.this;
            r3 = r3.fkx;
            r4 = r3.zp();
            r2 = r2.append(r4);
            r3 = " dataReadedCnt: ";
            r2 = r2.append(r3);
            r3 = com.tencent.mm.audio.b.b.this;
            r3 = r3.fkm;
            r2 = r2.append(r3);
            r2 = r2.toString();
            com.tencent.mm.sdk.platformtools.x.d(r1, r2);
            if (r10 >= 0) goto L_0x013a;
        L_0x0112:
            r0 = com.tencent.mm.audio.b.b.this;
            r0 = r0.fkt;
            r1 = com.tencent.mm.audio.b.b.b.STOPPED;
            if (r0 != r1) goto L_0x0127;
        L_0x011c:
            r0 = "MicroMsg.MMAudioRecorder";
            r1 = "recorder has been stopped";
            com.tencent.mm.sdk.platformtools.x.w(r0, r1);
            goto L_0x0034;
        L_0x0127:
            r0 = new com.tencent.mm.sdk.platformtools.ag;
            r1 = android.os.Looper.getMainLooper();
            r0.<init>(r1);
            r1 = new com.tencent.mm.audio.b.b$2$2;
            r1.<init>();
            r0.post(r1);
            goto L_0x0034;
        L_0x013a:
            r1 = com.tencent.mm.audio.b.b.this;
            r2 = com.tencent.mm.audio.b.b.this;
            r2 = r2.fkm;
            r2 = r2 + r10;
            r1.fkm = r2;
            r1 = com.tencent.mm.audio.b.b.this;
            r1 = r1.fkf;
            monitor-enter(r1);
            r2 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r2 = r2.fki;	 Catch:{ all -> 0x02a3 }
            if (r2 != 0) goto L_0x01e8;
        L_0x0155:
            r2 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r2 = r2.fks;	 Catch:{ all -> 0x02a3 }
            r3 = com.tencent.mm.compatible.b.b.a.PCM;	 Catch:{ all -> 0x02a3 }
            if (r2 == r3) goto L_0x0169;
        L_0x015f:
            r2 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r2 = r2.fks;	 Catch:{ all -> 0x02a3 }
            r3 = com.tencent.mm.compatible.b.b.a.SILK;	 Catch:{ all -> 0x02a3 }
            if (r2 != r3) goto L_0x01e8;
        L_0x0169:
            r2 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r2 = r2.fkj;	 Catch:{ all -> 0x02a3 }
            if (r2 == 0) goto L_0x01e8;
        L_0x0171:
            r2 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r2 = r2.fkp;	 Catch:{ all -> 0x02a3 }
            if (r2 == 0) goto L_0x01e8;
        L_0x0179:
            r2 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r3 = new com.tencent.mm.bd.c;	 Catch:{ all -> 0x02a3 }
            r3.<init>();	 Catch:{ all -> 0x02a3 }
            r2.fki = r3;	 Catch:{ all -> 0x02a3 }
            r2 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r2 = r2.fki;	 Catch:{ all -> 0x02a3 }
            r3 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r3 = r3.mSampleRate;	 Catch:{ all -> 0x02a3 }
            r4 = "MicroMsg.SpeexEncoderWorker";
            r5 = "init ";
            com.tencent.mm.sdk.platformtools.x.i(r4, r5);	 Catch:{ all -> 0x02a3 }
            r4 = r2.hQO;	 Catch:{ all -> 0x02a3 }
            r4.clear();	 Catch:{ all -> 0x02a3 }
            r4 = new com.tencent.mm.bd.d$b;	 Catch:{ all -> 0x02a3 }
            r4.<init>();	 Catch:{ all -> 0x02a3 }
            r5 = com.tencent.mm.bd.d.getPrefix();	 Catch:{ all -> 0x02a3 }
            r4.hNW = r5;	 Catch:{ all -> 0x02a3 }
            r4.sampleRate = r3;	 Catch:{ all -> 0x02a3 }
            r3 = 1;
            r4.hQJ = r3;	 Catch:{ all -> 0x02a3 }
            r3 = 16;
            r4.hQK = r3;	 Catch:{ all -> 0x02a3 }
            r3 = "%s%d_%d_%d_%d";
            r5 = 5;
            r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x02a3 }
            r6 = 0;
            r7 = r4.hNW;	 Catch:{ all -> 0x02a3 }
            r5[r6] = r7;	 Catch:{ all -> 0x02a3 }
            r6 = 1;
            r7 = r4.sampleRate;	 Catch:{ all -> 0x02a3 }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x02a3 }
            r5[r6] = r7;	 Catch:{ all -> 0x02a3 }
            r6 = 2;
            r7 = r4.hQJ;	 Catch:{ all -> 0x02a3 }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x02a3 }
            r5[r6] = r7;	 Catch:{ all -> 0x02a3 }
            r6 = 3;
            r4 = r4.hQK;	 Catch:{ all -> 0x02a3 }
            r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x02a3 }
            r5[r6] = r4;	 Catch:{ all -> 0x02a3 }
            r4 = 4;
            r6 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x02a3 }
            r6 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x02a3 }
            r5[r4] = r6;	 Catch:{ all -> 0x02a3 }
            r3 = java.lang.String.format(r3, r5);	 Catch:{ all -> 0x02a3 }
            r2.mFileName = r3;	 Catch:{ all -> 0x02a3 }
        L_0x01e8:
            r2 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r2 = r2.fki;	 Catch:{ all -> 0x02a3 }
            if (r2 == 0) goto L_0x0222;
        L_0x01f0:
            r2 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r2 = r2.fki;	 Catch:{ all -> 0x02a3 }
            r3 = "MicroMsg.SpeexEncoderWorker";
            r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x02a3 }
            r5 = "push into queue queueLen:";
            r4.<init>(r5);	 Catch:{ all -> 0x02a3 }
            r5 = r2.hQO;	 Catch:{ all -> 0x02a3 }
            r5 = r5.size();	 Catch:{ all -> 0x02a3 }
            r4 = r4.append(r5);	 Catch:{ all -> 0x02a3 }
            r4 = r4.toString();	 Catch:{ all -> 0x02a3 }
            com.tencent.mm.sdk.platformtools.x.d(r3, r4);	 Catch:{ all -> 0x02a3 }
            if (r9 == 0) goto L_0x0222;
        L_0x0214:
            r3 = r9.length;	 Catch:{ all -> 0x02a3 }
            if (r3 <= 0) goto L_0x0222;
        L_0x0217:
            r2 = r2.hQO;	 Catch:{ all -> 0x02a3 }
            r3 = new com.tencent.mm.audio.b.g$a;	 Catch:{ all -> 0x02a3 }
            r4 = r9.length;	 Catch:{ all -> 0x02a3 }
            r3.<init>(r9, r4);	 Catch:{ all -> 0x02a3 }
            r2.add(r3);	 Catch:{ all -> 0x02a3 }
        L_0x0222:
            r2 = r9.length;	 Catch:{ all -> 0x02a3 }
            r3 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r3 = r3.fkv;	 Catch:{ all -> 0x02a3 }
            if (r3 == 0) goto L_0x025d;
        L_0x022b:
            r3 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r3 = r3.fku;	 Catch:{ all -> 0x02a3 }
            if (r3 != 0) goto L_0x02a6;
        L_0x0233:
            r3 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r4 = new com.tencent.mm.audio.c.c;	 Catch:{ all -> 0x02a3 }
            r4.<init>();	 Catch:{ all -> 0x02a3 }
            r3.fku = r4;	 Catch:{ all -> 0x02a3 }
            r3 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r3 = r3.fku;	 Catch:{ all -> 0x02a3 }
            r4 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r4 = r4.fkd;	 Catch:{ all -> 0x02a3 }
            r3 = r3.cL(r4);	 Catch:{ all -> 0x02a3 }
            if (r3 != 0) goto L_0x02a6;
        L_0x024f:
            r2 = "MicroMsg.MMAudioRecorder";
            r3 = "alvinluo init PcmWriter failed";
            com.tencent.mm.sdk.platformtools.x.e(r2, r3);	 Catch:{ all -> 0x02a3 }
            r2 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r2.fkv = false;	 Catch:{ all -> 0x02a3 }
        L_0x025d:
            r2 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r2 = r2.fks;	 Catch:{ all -> 0x02a3 }
            r3 = com.tencent.mm.compatible.b.b.a.SILK;	 Catch:{ all -> 0x02a3 }
            if (r2 != r3) goto L_0x02fa;
        L_0x0267:
            r2 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r2 = r2.fkg;	 Catch:{ all -> 0x02a3 }
            if (r2 != 0) goto L_0x0294;
        L_0x026f:
            r2 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r3 = new com.tencent.mm.audio.c.d;	 Catch:{ all -> 0x02a3 }
            r4 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r4 = r4.mSampleRate;	 Catch:{ all -> 0x02a3 }
            r5 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r5 = r5.fko;	 Catch:{ all -> 0x02a3 }
            r3.<init>(r4, r5);	 Catch:{ all -> 0x02a3 }
            r2.fkg = r3;	 Catch:{ all -> 0x02a3 }
            r2 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r2 = r2.fkg;	 Catch:{ all -> 0x02a3 }
            r3 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r3 = r3.fkd;	 Catch:{ all -> 0x02a3 }
            r2.cL(r3);	 Catch:{ all -> 0x02a3 }
        L_0x0294:
            r8.s(r9, r10);	 Catch:{ all -> 0x02a3 }
            r2 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r2 = r2.fkg;	 Catch:{ all -> 0x02a3 }
            r2.b(r9, r10, r0);	 Catch:{ all -> 0x02a3 }
            monitor-exit(r1);	 Catch:{ all -> 0x02a3 }
            goto L_0x0034;
        L_0x02a3:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x02a3 }
            throw r0;
        L_0x02a6:
            r3 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r3 = r3.fku;	 Catch:{ all -> 0x02a3 }
            if (r3 == 0) goto L_0x025d;
        L_0x02ae:
            r3 = com.tencent.mm.audio.b.b.this;	 Catch:{ all -> 0x02a3 }
            r3 = r3.fku;	 Catch:{ all -> 0x02a3 }
            if (r9 != 0) goto L_0x02c0;
        L_0x02b6:
            r2 = "MicroMsg.RawPcmWriter";
            r3 = "alvinlu pcmWriter pushBuf data is null";
            com.tencent.mm.sdk.platformtools.x.e(r2, r3);	 Catch:{ all -> 0x02a3 }
            goto L_0x025d;
        L_0x02c0:
            if (r2 <= 0) goto L_0x025d;
        L_0x02c2:
            monitor-enter(r3);	 Catch:{ all -> 0x02a3 }
            r4 = r3.fnd;	 Catch:{ all -> 0x02d2 }
            if (r4 == 0) goto L_0x02d5;
        L_0x02c7:
            r2 = "MicroMsg.RawPcmWriter";
            r4 = "avlinluo pcmWriter already stop";
            com.tencent.mm.sdk.platformtools.x.e(r2, r4);	 Catch:{ all -> 0x02d2 }
            monitor-exit(r3);	 Catch:{ all -> 0x02d2 }
            goto L_0x025d;
        L_0x02d2:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x02d2 }
            throw r0;	 Catch:{ all -> 0x02a3 }
        L_0x02d5:
            monitor-exit(r3);	 Catch:{ all -> 0x02d2 }
            r4 = r3.fne;	 Catch:{ all -> 0x02a3 }
            if (r4 != 0) goto L_0x02ea;
        L_0x02da:
            r4 = new com.tencent.mm.audio.c.c$a;	 Catch:{ all -> 0x02a3 }
            r5 = 0;
            r4.<init>(r3, r5);	 Catch:{ all -> 0x02a3 }
            r3.fne = r4;	 Catch:{ all -> 0x02a3 }
            r4 = r3.fne;	 Catch:{ all -> 0x02a3 }
            r5 = "RawPcmWriter_run";
            com.tencent.mm.sdk.f.e.post(r4, r5);	 Catch:{ all -> 0x02a3 }
        L_0x02ea:
            r4 = r3.fnf;	 Catch:{ all -> 0x02a3 }
            if (r4 == 0) goto L_0x025d;
        L_0x02ee:
            r3 = r3.fnf;	 Catch:{ all -> 0x02a3 }
            r4 = new com.tencent.mm.audio.b.g$a;	 Catch:{ all -> 0x02a3 }
            r4.<init>(r9, r2, r0);	 Catch:{ all -> 0x02a3 }
            r3.add(r4);	 Catch:{ all -> 0x02a3 }
            goto L_0x025d;
        L_0x02fa:
            monitor-exit(r1);	 Catch:{ all -> 0x02a3 }
            r0 = com.tencent.mm.audio.b.b.this;
            r0 = r0.mSampleRate;
            r1 = 16000; // 0x3e80 float:2.2421E-41 double:7.905E-320;
            if (r0 != r1) goto L_0x030a;
        L_0x0305:
            r9 = com.tencent.mm.audio.b.b.AnonymousClass2.r(r9, r10);
            r10 = r9.length;
        L_0x030a:
            r8.s(r9, r10);
            goto L_0x0034;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.audio.b.b.2.q(byte[], int):void");
        }

        private static byte[] r(byte[] bArr, int i) {
            int i2 = i % 4;
            if (i2 != 0) {
                i -= i2;
            }
            if (i <= 0) {
                return null;
            }
            byte[] bArr2 = new byte[(i / 2)];
            for (i2 = 0; i2 < i / 2; i2 += 2) {
                bArr2[i2] = bArr[i2 * 2];
                bArr2[i2 + 1] = bArr[(i2 * 2) + 1];
            }
            return bArr2;
        }

        private void s(byte[] bArr, int i) {
            for (int i2 = 0; i2 < i / 2; i2++) {
                short s = (short) ((bArr[i2 * 2] & 255) | (bArr[(i2 * 2) + 1] << 8));
                if (s > b.this.fkc) {
                    b.this.fkc = s;
                }
            }
        }

        public final void aK(int i, int i2) {
        }
    };
    private int fkc = 0;
    private String fkd = null;
    private int fke;
    private final Object fkf = new Object();
    private d fkg = null;
    private a fkh;
    private c fki = null;
    private com.tencent.mm.bd.d.a fkj = null;
    private long fkk = 0;
    private long fkl = 0;
    private int fkm = 0;
    private int fko = 16000;
    private boolean fkp = false;
    public MediaRecorder fkq;
    public c fkr = null;
    public com.tencent.mm.compatible.b.b.a fks;
    public b fkt;
    private com.tencent.mm.audio.c.c fku;
    public boolean fkv;
    private volatile boolean fkw = false;
    private com.tencent.mm.compatible.util.g.a fkx = new com.tencent.mm.compatible.util.g.a();
    private int fky = 0;
    private int fkz = 0;
    private int mSampleRate = 8000;

    public enum b {
        INITIALIZING,
        READY,
        RECORDING,
        ERROR,
        STOPPED
    }

    public interface a {
        void onError();
    }

    public b(com.tencent.mm.compatible.b.b.a aVar) {
        x.i("MicroMsg.MMAudioRecorder", "MMAudioRecorder recMode: " + aVar);
        this.fks = aVar;
        if (!com.tencent.mm.audio.b.g.b.vx()) {
            x.i("MicroMsg.MMAudioRecorder", "can't use silk encode, force to use amr mode now");
            this.fks = com.tencent.mm.compatible.b.b.a.AMR;
        }
        if (this.fks == com.tencent.mm.compatible.b.b.a.AMR) {
            this.fke = 7;
            this.fkq = new MediaRecorder();
        } else {
            vo();
            this.fke = 1;
        }
        this.fkw = false;
    }

    public final void a(a aVar) {
        if (this.fks == com.tencent.mm.compatible.b.b.a.AMR) {
            if (this.fkq != null) {
                this.fkh = aVar;
                this.fkq.setOnErrorListener(new OnErrorListener() {
                    public final void onError(MediaRecorder mediaRecorder, int i, int i2) {
                        if (b.this.fkh != null) {
                            b.this.fkh.onError();
                        }
                        try {
                            b.this.fkq.release();
                        } catch (Exception e) {
                            x.e("MicroMsg.MMAudioRecorder", e.getMessage());
                        }
                        b.this.fkt = b.ERROR;
                    }
                });
            }
        } else if (this.fkt == b.INITIALIZING) {
            this.fkh = aVar;
        } else {
            x.e("MicroMsg.MMAudioRecorder", "setOnErrorListener on wrong state");
        }
    }

    public final void setOutputFile(String str) {
        if (this.fks == com.tencent.mm.compatible.b.b.a.AMR) {
            if (this.fkq != null) {
                this.fkq.setOutputFile(str);
                this.fkd = str;
            }
        } else if (this.fkt == b.INITIALIZING) {
            this.fkd = str;
        } else {
            x.e("MicroMsg.MMAudioRecorder", "set output path on wrong state");
            this.fkt = b.ERROR;
        }
    }

    public final void setMaxDuration(int i) {
        if (this.fks != com.tencent.mm.compatible.b.b.a.AMR) {
            this.fkk = (long) i;
        } else if (this.fkq != null) {
            this.fkq.setMaxDuration(i);
        }
    }

    public final void vl() {
        if (this.fks == com.tencent.mm.compatible.b.b.a.AMR && this.fkq != null) {
            this.fkq.setAudioEncoder(1);
        }
    }

    public final void vm() {
        if (this.fks == com.tencent.mm.compatible.b.b.a.AMR && this.fkq != null) {
            this.fkq.setAudioSource(1);
        }
    }

    public final void vn() {
        if (this.fks == com.tencent.mm.compatible.b.b.a.AMR && this.fkq != null) {
            this.fkq.setOutputFormat(3);
        }
    }

    public final int getMaxAmplitude() {
        if (this.fks == com.tencent.mm.compatible.b.b.a.AMR) {
            if (this.fkq == null) {
                return 0;
            }
            return this.fkq.getMaxAmplitude();
        } else if (this.fkt != b.RECORDING) {
            return 0;
        } else {
            int i = this.fkc;
            this.fkc = 0;
            return i;
        }
    }

    public final void vo() {
        int nextInt;
        this.fkj = com.tencent.mm.bd.d.a.SR();
        if (this.fkj != null) {
            boolean z;
            com.tencent.mm.bd.d.a aVar = this.fkj;
            if (1 == g.t("EnableSpeexVoiceUpload", 0)) {
                z = true;
            } else {
                x.d("upload", "type " + com.tencent.mm.bd.d.chatType);
                int SQ = aVar.SQ();
                int SP = aVar.SP();
                g.Dr();
                Integer valueOf = Integer.valueOf(bi.e((Integer) g.Dq().Db().get(16646145, null)));
                x.d("upload", "daycount " + aVar.SQ() + "  count " + valueOf + " rate " + SP);
                if (valueOf.intValue() <= SQ && SP != 0 && ao.isWifi(ad.getContext())) {
                    g.Dr();
                    z = aVar.fXa == 0 ? true : aVar.fXa == bi.a((Integer) g.Dq().Db().get(12290, null), 0);
                    x.d("upload", "fitSex " + aVar.fXa + " " + z + " " + aVar.fXa);
                    if (z && aVar.SO()) {
                        nextInt = aVar.hRc.nextInt(SP);
                        x.d("upload", "luck " + nextInt);
                        if (nextInt == SP / 2) {
                            z = true;
                        }
                    }
                }
                z = false;
            }
            this.fkp = z;
        }
        if (this.fks == com.tencent.mm.compatible.b.b.a.SILK) {
            this.mSampleRate = bi.getInt(((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("VoiceSamplingRate"), 16000);
            this.fko = bi.getInt(((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("VoiceRate"), 16000);
            x.i("MicroMsg.MMAudioRecorder", "initMediaRecorder dynamicSample: %s sampleRate: %d dynamicEncoding: %s audioEncoding: %d", r3, Integer.valueOf(this.mSampleRate), r0, Integer.valueOf(this.fko));
        } else {
            if (this.fkp) {
                this.mSampleRate = 16000;
            } else {
                this.mSampleRate = 8000;
            }
            g.Dr();
            nextInt = bi.a((Integer) g.Dq().gRO.get(27), 0);
            x.i("MicroMsg.MMAudioRecorder", "sampleRate: " + this.mSampleRate + " notSupp16K: " + nextInt);
            if (nextInt == 1) {
                this.mSampleRate = 8000;
            }
        }
        this.fkc = 0;
        this.fkd = null;
        synchronized (this.fkf) {
            this.fki = null;
            this.fkg = null;
            this.fku = null;
        }
        this.fkm = 0;
        try {
            synchronized (fkn) {
                this.fkr = new c(this.mSampleRate, 1, 0);
                this.fkr.aQ(true);
                this.fkr.et(120);
                this.fkr.fle = this.fkA;
            }
            this.fkt = b.INITIALIZING;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                x.e("MicroMsg.MMAudioRecorder", e.getMessage());
            } else {
                x.e("MicroMsg.MMAudioRecorder", "Unknown error occured while initializing recording");
            }
            this.fkt = b.ERROR;
        }
    }

    public final void start() {
        if (this.fks != com.tencent.mm.compatible.b.b.a.AMR) {
            x.i("MicroMsg.MMAudioRecorder", "Start record now state: " + this.fkt + " recMode: " + this.fks);
            if (this.fkt == b.READY) {
                this.fkl = System.currentTimeMillis();
                this.fkm = 0;
                this.fkt = b.RECORDING;
                synchronized (fkn) {
                    this.fkr.vs();
                }
            } else {
                g.Dr();
                g.Dq().gRO.set(27, Integer.valueOf(1));
                x.e("MicroMsg.MMAudioRecorder", "start() called on illegal state");
                this.fkt = b.ERROR;
            }
            this.fkw = false;
        } else if (this.fkq != null) {
            this.fkq.start();
        }
    }

    public final void prepare() {
        if (this.fks == com.tencent.mm.compatible.b.b.a.AMR) {
            if (this.fkq != null) {
                this.fkq.prepare();
            }
        } else if (this.fkt != b.INITIALIZING || this.fkd == null) {
            this.fkt = b.ERROR;
            release();
        } else {
            this.fkt = b.READY;
        }
    }

    public final void release() {
        if (this.fks != com.tencent.mm.compatible.b.b.a.AMR) {
            if (this.fkt == b.RECORDING) {
                vp();
            } else {
                b bVar = b.READY;
            }
            synchronized (fkn) {
                if (this.fkr != null) {
                    this.fkr.vj();
                    this.fkr.fle = null;
                    this.fkr = null;
                }
            }
        } else if (this.fkq != null) {
            this.fkq.release();
        }
    }

    public final boolean vp() {
        if (this.fks == com.tencent.mm.compatible.b.b.a.AMR) {
            x.i("MicroMsg.MMAudioRecorder", "stop sysMediaRecorder: %s", this.fkq);
            if (this.fkq != null) {
                this.fkq.stop();
                this.fkq.release();
                this.fkq = null;
            }
            return true;
        }
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        x.i("MicroMsg.MMAudioRecorder", "stop now state: " + this.fkt);
        if (this.fkt != b.RECORDING) {
            x.e("MicroMsg.MMAudioRecorder", "stop() called on illegal state");
            this.fkt = b.ERROR;
            return true;
        }
        synchronized (fkn) {
            if (this.fkr != null) {
                this.fkw = true;
            } else {
                this.fkw = false;
            }
        }
        long zp = aVar.zp();
        this.fkt = b.STOPPED;
        long zp2 = aVar.zp();
        if (this.fkw) {
            x.i("MicroMsg.MMAudioRecorder", "start to wait pcmrecorder stop, markStop: %s", Boolean.valueOf(this.fkw));
            int i = 0;
            while (this.fkw) {
                i++;
                try {
                    Thread.sleep(20);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MMAudioRecorder", e, "", new Object[0]);
                }
                if (i >= 25) {
                    synchronized (fkn) {
                        x.i("MicroMsg.MMAudioRecorder", "wait pcmrecorder stop, reach maximum count!, mPcmRecorder: %s", this.fkr);
                        if (this.fkr != null) {
                            try {
                                this.fkr.vj();
                                this.fkr.fle = null;
                                this.fkr = null;
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.MMAudioRecorder", e2, "", new Object[0]);
                            }
                        }
                    }
                    x.i("MicroMsg.MMAudioRecorder", "finish to wait pcmrecorder stop, markStop: %s, count: %s", Boolean.valueOf(this.fkw), Integer.valueOf(i));
                }
            }
            x.i("MicroMsg.MMAudioRecorder", "finish to wait pcmrecorder stop, markStop: %s, count: %s", Boolean.valueOf(this.fkw), Integer.valueOf(i));
        }
        synchronized (this.fkf) {
            if (this.fkg != null) {
                this.fkg.vK();
            }
            if (this.fki != null) {
                c cVar = this.fki;
                x.i("MicroMsg.SpeexEncoderWorker", "stop ");
                new ag(Looper.getMainLooper()).post(new Runnable() {
                    public final void run() {
                        Looper.myQueue().addIdleHandler(new IdleHandler() {
                            public final boolean queueIdle() {
                                x.d("MicroMsg.SpeexEncoderWorker", "queueIdle  ");
                                e.SS().b(c.this);
                                return false;
                            }
                        });
                    }
                });
            }
            if (this.fkv && this.fku != null) {
                this.fku.vK();
            }
        }
        long bA = bi.bA(this.fkl);
        x.i("MicroMsg.MMAudioRecorder", "toNow " + bA + " startTickCnt: " + this.fkl + " pcmDataReadedCnt: " + this.fkm);
        if (bA > 2000 && this.fkm == 0) {
            g.Dr();
            g.Dq().gRO.set(27, Integer.valueOf(1));
            x.i("MicroMsg.MMAudioRecorder", "16k not suppourt");
        }
        x.i("MicroMsg.MMAudioRecorder", "Wait Stop Time Media:" + zp + " Read:" + zp2 + " Thr:" + aVar.zp());
        return false;
    }
}
