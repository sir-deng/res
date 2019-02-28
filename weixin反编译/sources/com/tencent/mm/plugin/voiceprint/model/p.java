package com.tencent.mm.plugin.voiceprint.model;

import android.os.Message;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;

public final class p implements com.tencent.mm.compatible.b.f.a {
    public static int fmB = 100;
    public k fhZ = null;
    public String fileName = "";
    public com.tencent.mm.compatible.util.b hZB;
    private int kGs = 0;
    public long mEr = 0;
    public boolean scC = false;
    public int scF = 0;
    public b snn;
    public String sno;
    public boolean snp = false;
    public a snq = null;

    public interface a {
        void bGs();
    }

    private final class b extends Thread {
        ag handler;

        public b() {
            this.handler = new ag(p.this) {
                public final void handleMessage(Message message) {
                    if (p.this.scF > 0) {
                        p.this.scF = 2;
                    }
                }
            };
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r7 = this;
            r6 = 0;
            r0 = com.tencent.mm.plugin.voiceprint.model.p.this;
            r0 = r0.fhZ;
            if (r0 != 0) goto L_0x0013;
        L_0x0009:
            r0 = "MicroMsg.VoicePrintRecoder";
            r1 = "Stop Record Failed recorder == null";
            com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        L_0x0012:
            return;
        L_0x0013:
            r1 = com.tencent.mm.plugin.voiceprint.model.p.this;
            monitor-enter(r1);
            r0 = com.tencent.mm.plugin.voiceprint.model.p.this;	 Catch:{ all -> 0x00ac }
            r0 = r0.fileName;	 Catch:{ all -> 0x00ac }
            r2 = 1;
            r0 = com.tencent.mm.plugin.voiceprint.model.m.aJ(r0, r2);	 Catch:{ all -> 0x00ac }
            r2 = "MicroMsg.VoicePrintRecoder";
            r3 = "fullPathName %s";
            r4 = 1;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00ac }
            r5 = 0;
            r4[r5] = r0;	 Catch:{ all -> 0x00ac }
            com.tencent.mm.sdk.platformtools.x.d(r2, r3, r4);	 Catch:{ all -> 0x00ac }
            r2 = com.tencent.mm.plugin.voiceprint.model.p.this;	 Catch:{ all -> 0x00ac }
            r2.sno = r0;	 Catch:{ all -> 0x00ac }
            r2 = com.tencent.mm.plugin.voiceprint.model.p.this;	 Catch:{ all -> 0x00ac }
            r2 = r2.hZB;	 Catch:{ all -> 0x00ac }
            if (r2 == 0) goto L_0x0045;
        L_0x003c:
            r2 = com.tencent.mm.plugin.voiceprint.model.p.this;	 Catch:{ all -> 0x00ac }
            r2 = r2.hZB;	 Catch:{ all -> 0x00ac }
            r2.requestFocus();	 Catch:{ all -> 0x00ac }
        L_0x0045:
            r2 = com.tencent.mm.plugin.voiceprint.model.p.this;	 Catch:{ all -> 0x00ac }
            r2 = r2.fhZ;	 Catch:{ all -> 0x00ac }
            r0 = r2.cI(r0);	 Catch:{ all -> 0x00ac }
            if (r0 != 0) goto L_0x00af;
        L_0x0051:
            r0 = com.tencent.mm.plugin.voiceprint.model.p.this;	 Catch:{ all -> 0x00ac }
            r0.fileName = null;	 Catch:{ all -> 0x00ac }
            r0 = "MicroMsg.VoicePrintRecoder";
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ac }
            r3 = "Thread Start Record  Error fileName[";
            r2.<init>(r3);	 Catch:{ all -> 0x00ac }
            r3 = com.tencent.mm.plugin.voiceprint.model.p.this;	 Catch:{ all -> 0x00ac }
            r3 = r3.fileName;	 Catch:{ all -> 0x00ac }
            r2 = r2.append(r3);	 Catch:{ all -> 0x00ac }
            r3 = "]";
            r2 = r2.append(r3);	 Catch:{ all -> 0x00ac }
            r2 = r2.toString();	 Catch:{ all -> 0x00ac }
            com.tencent.mm.sdk.platformtools.x.d(r0, r2);	 Catch:{ all -> 0x00ac }
            r0 = com.tencent.mm.plugin.voiceprint.model.p.this;	 Catch:{ all -> 0x00ac }
            r0 = r0.fhZ;	 Catch:{ all -> 0x00ac }
            r0.vj();	 Catch:{ all -> 0x00ac }
            r0 = com.tencent.mm.plugin.voiceprint.model.p.this;	 Catch:{ all -> 0x00ac }
            r0.fhZ = null;	 Catch:{ all -> 0x00ac }
            r0 = com.tencent.mm.plugin.voiceprint.model.p.this;	 Catch:{ all -> 0x00ac }
            r0 = r0.hZB;	 Catch:{ all -> 0x00ac }
            if (r0 == 0) goto L_0x0098;
        L_0x008f:
            r0 = com.tencent.mm.plugin.voiceprint.model.p.this;	 Catch:{ all -> 0x00ac }
            r0 = r0.hZB;	 Catch:{ all -> 0x00ac }
            r0.zk();	 Catch:{ all -> 0x00ac }
        L_0x0098:
            r0 = com.tencent.mm.plugin.voiceprint.model.p.this;	 Catch:{ all -> 0x00ac }
            r0 = r0.snq;	 Catch:{ all -> 0x00ac }
            if (r0 == 0) goto L_0x00a9;
        L_0x00a0:
            r0 = com.tencent.mm.plugin.voiceprint.model.p.this;	 Catch:{ all -> 0x00ac }
            r0 = r0.snq;	 Catch:{ all -> 0x00ac }
            r0.bGs();	 Catch:{ all -> 0x00ac }
        L_0x00a9:
            monitor-exit(r1);	 Catch:{ all -> 0x00ac }
            goto L_0x0012;
        L_0x00ac:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00ac }
            throw r0;
        L_0x00af:
            r0 = com.tencent.mm.plugin.voiceprint.model.p.this;	 Catch:{ all -> 0x00ac }
            r2 = com.tencent.mm.sdk.platformtools.bi.Wz();	 Catch:{ all -> 0x00ac }
            r0.mEr = r2;	 Catch:{ all -> 0x00ac }
            r0 = "MicroMsg.VoicePrintRecoder";
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ac }
            r3 = "Thread Started Record fileName[";
            r2.<init>(r3);	 Catch:{ all -> 0x00ac }
            r3 = com.tencent.mm.plugin.voiceprint.model.p.this;	 Catch:{ all -> 0x00ac }
            r3 = r3.fileName;	 Catch:{ all -> 0x00ac }
            r2 = r2.append(r3);	 Catch:{ all -> 0x00ac }
            r3 = "]";
            r2 = r2.append(r3);	 Catch:{ all -> 0x00ac }
            r2 = r2.toString();	 Catch:{ all -> 0x00ac }
            com.tencent.mm.sdk.platformtools.x.d(r0, r2);	 Catch:{ all -> 0x00ac }
            monitor-exit(r1);	 Catch:{ all -> 0x00ac }
            r0 = r7.handler;
            r2 = 1;
            r0.sendEmptyMessageDelayed(r6, r2);
            goto L_0x0012;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voiceprint.model.p.b.run():void");
        }
    }

    public final void er(int i) {
        x.d("MicroMsg.VoicePrintRecoder", " Recorder onBluetoothHeadsetStateChange :" + i);
        if (!this.scC) {
            this.scC = true;
            as.Hn().b((com.tencent.mm.compatible.b.f.a) this);
            this.fhZ = new k();
            this.snn = new b();
            this.snn.start();
            this.snp = false;
            this.scF = 1;
        }
    }

    public final boolean vp() {
        long j = 0;
        as.Hn().xQ();
        this.snp = false;
        x.d("MicroMsg.VoicePrintRecoder", "stop Record :" + this.fileName);
        synchronized (this) {
            x.d("MicroMsg.VoicePrintRecoder", "stop synchronized Record :" + this.fileName);
            if (this.fhZ != null) {
                this.fhZ.vj();
            }
        }
        if (this.scF != 2) {
            this.fileName = null;
            this.snp = false;
            x.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName);
        } else {
            if (this.mEr > 0) {
                j = bi.bB(this.mEr);
            }
            this.kGs = (int) j;
            if (this.kGs < 1000) {
                x.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fileName + " by voiceLen: " + this.kGs);
                this.fileName = "";
                this.snp = false;
            } else {
                this.snp = true;
                x.d("MicroMsg.VoicePrintRecoder", "Stop file success: " + this.fileName);
            }
            this.fileName = "";
        }
        this.scF = -1;
        x.d("MicroMsg.VoicePrintRecoder", "bLongEnough " + this.snp);
        if (this.hZB != null) {
            this.hZB.zk();
        }
        return this.snp;
    }
}
