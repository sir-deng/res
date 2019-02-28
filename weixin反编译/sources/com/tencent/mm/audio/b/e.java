package com.tencent.mm.audio.b;

import android.media.AudioRecord;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantLock;

public final class e extends f {
    boolean fkP;
    private boolean flA = false;
    private boolean flB = false;
    AudioRecord fld;
    int flp;
    private int fls = 12800;
    private b flt = new b();
    com.tencent.mm.compatible.b.a flu = null;
    com.tencent.mm.audio.b.c.a flv;
    private final Object flw = new Object();
    final byte[] flx = new byte[0];
    final Object fly = new Object();
    private Timer flz = null;
    boolean mIsMute = false;
    int mStatus = 0;

    class a extends TimerTask {
        private int flC = (e.this.flp * 2);
        private int flD = e.this.flp;
        byte[] flE = new byte[this.flC];

        a() {
        }

        public final void run() {
            if (!e.this.mIsPause) {
                int vv = (int) (0.8d * ((double) e.this.vv()));
                if (vv < e.this.flp * 8) {
                    vv = e.this.flp * 8;
                }
                if (e.this.vw() > vv) {
                    vv = 8;
                } else {
                    vv = 1;
                }
                for (int i = 0; i < vv; i++) {
                    int t = e.this.t(this.flE, this.flD);
                    if (e.this.flv != null && t == 0) {
                        e.this.flv.q(this.flE, this.flD);
                    }
                }
            }
        }
    }

    final class b implements Runnable {
        b() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r11 = this;
            r2 = -1;
            r10 = 1;
            r9 = 2;
            r3 = 0;
            r0 = "MicroMsg.RecordModeAsyncRead";
            r1 = "RecordThread started. frameSize:%d";
            r4 = new java.lang.Object[r10];
            r5 = com.tencent.mm.audio.b.e.this;
            r5 = r5.flp;
            r5 = java.lang.Integer.valueOf(r5);
            r4[r3] = r5;
            com.tencent.mm.sdk.platformtools.x.i(r0, r1, r4);
            r0 = -123456789; // 0xfffffffff8a432eb float:-2.6642794E34 double:NaN;
            r1 = com.tencent.mm.audio.b.e.this;
            r1 = r1.fkT;
            if (r0 == r1) goto L_0x0043;
        L_0x0022:
            r0 = "MicroMsg.RecordModeAsyncRead";
            r1 = new java.lang.StringBuilder;
            r4 = "set priority to ";
            r1.<init>(r4);
            r4 = com.tencent.mm.audio.b.e.this;
            r4 = r4.fkT;
            r1 = r1.append(r4);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.x.i(r0, r1);
            r0 = com.tencent.mm.audio.b.e.this;
            r0 = r0.fkT;
            android.os.Process.setThreadPriority(r0);
        L_0x0043:
            r0 = com.tencent.mm.audio.b.e.this;
            r1 = r0.fly;
            monitor-enter(r1);
            r0 = com.tencent.mm.audio.b.e.this;	 Catch:{ all -> 0x009f }
            r0 = r0.mStatus;	 Catch:{ all -> 0x009f }
            if (r10 == r0) goto L_0x006a;
        L_0x004e:
            r0 = "MicroMsg.RecordModeAsyncRead";
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009f }
            r3 = "status is not inited, now status: ";
            r2.<init>(r3);	 Catch:{ all -> 0x009f }
            r3 = com.tencent.mm.audio.b.e.this;	 Catch:{ all -> 0x009f }
            r3 = r3.mStatus;	 Catch:{ all -> 0x009f }
            r2 = r2.append(r3);	 Catch:{ all -> 0x009f }
            r2 = r2.toString();	 Catch:{ all -> 0x009f }
            com.tencent.mm.sdk.platformtools.x.e(r0, r2);	 Catch:{ all -> 0x009f }
            monitor-exit(r1);	 Catch:{ all -> 0x009f }
        L_0x0069:
            return;
        L_0x006a:
            r0 = com.tencent.mm.audio.b.e.this;	 Catch:{ all -> 0x009f }
            r4 = 2;
            r0.mStatus = r4;	 Catch:{ all -> 0x009f }
            monitor-exit(r1);	 Catch:{ all -> 0x009f }
            r0 = com.tencent.mm.audio.b.e.this;
            r0 = r0.flp;
            r0 = new byte[r0];
        L_0x0076:
            r1 = com.tencent.mm.audio.b.e.this;
            r1 = r1.mStatus;
            if (r9 != r1) goto L_0x0095;
        L_0x007c:
            r1 = com.tencent.mm.audio.b.e.this;
            r1 = r1.flx;
            monitor-enter(r1);
            r4 = com.tencent.mm.audio.b.e.this;	 Catch:{ all -> 0x00c1 }
            r4 = r4.mIsPause;	 Catch:{ all -> 0x00c1 }
            if (r4 == 0) goto L_0x00a2;
        L_0x0087:
            r4 = com.tencent.mm.audio.b.e.this;	 Catch:{ InterruptedException -> 0x0245 }
            r4 = r4.flx;	 Catch:{ InterruptedException -> 0x0245 }
            r4.wait();	 Catch:{ InterruptedException -> 0x0245 }
        L_0x008e:
            r4 = com.tencent.mm.audio.b.e.this;	 Catch:{ all -> 0x00c1 }
            r4 = r4.mStatus;	 Catch:{ all -> 0x00c1 }
            if (r9 == r4) goto L_0x00a2;
        L_0x0094:
            monitor-exit(r1);	 Catch:{ all -> 0x00c1 }
        L_0x0095:
            r0 = "MicroMsg.RecordModeAsyncRead";
            r1 = "RecordThread exited.";
            com.tencent.mm.sdk.platformtools.x.i(r0, r1);
            goto L_0x0069;
        L_0x009f:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x009f }
            throw r0;
        L_0x00a2:
            monitor-exit(r1);	 Catch:{ all -> 0x00c1 }
            r1 = com.tencent.mm.audio.b.e.this;
            r1 = r1.fld;
            if (r1 != 0) goto L_0x00c4;
        L_0x00a9:
            r0 = "MicroMsg.RecordModeAsyncRead";
            r1 = "mAudioRecord is null, so stop record.";
            com.tencent.mm.sdk.platformtools.x.i(r0, r1);
            r0 = com.tencent.mm.audio.b.e.this;
            r1 = r0.fly;
            monitor-enter(r1);
            r0 = com.tencent.mm.audio.b.e.this;	 Catch:{ all -> 0x00be }
            r2 = 3;
            r0.mStatus = r2;	 Catch:{ all -> 0x00be }
            monitor-exit(r1);	 Catch:{ all -> 0x00be }
            goto L_0x0095;
        L_0x00be:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00be }
            throw r0;
        L_0x00c1:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00c1 }
            throw r0;
        L_0x00c4:
            r1 = com.tencent.mm.audio.b.e.this;
            r1 = r1.fkP;
            if (r1 == 0) goto L_0x00d0;
        L_0x00ca:
            r0 = com.tencent.mm.audio.b.e.this;
            r0 = r0.flp;
            r0 = new byte[r0];
        L_0x00d0:
            r1 = com.tencent.mm.audio.b.e.this;
            r4 = com.tencent.mm.audio.b.e.this;
            r4 = r4.flG;
            r4 = r4 + 1;
            r1.flG = r4;
            r1 = new com.tencent.mm.compatible.util.g$a;
            r1.<init>();
            r1 = com.tencent.mm.audio.b.e.this;
            r1 = r1.fld;
            r4 = com.tencent.mm.audio.b.e.this;
            r4 = r4.flp;
            r1 = r1.read(r0, r3, r4);
            r4 = com.tencent.mm.audio.b.e.this;
            r4 = r4.mStatus;
            if (r9 != r4) goto L_0x0095;
        L_0x00f1:
            r4 = com.tencent.mm.audio.b.e.this;
            r4 = r4.fll;
            if (r4 == 0) goto L_0x00fe;
        L_0x00f7:
            r4 = com.tencent.mm.audio.b.e.this;
            r4 = r4.fll;
            r4.c(r1, r0);
        L_0x00fe:
            r4 = com.tencent.mm.audio.b.e.this;
            r4 = r4.flp;
            if (r4 == r1) goto L_0x011a;
        L_0x0104:
            r4 = "MicroMsg.RecordModeAsyncRead";
            r5 = new java.lang.StringBuilder;
            r6 = "read len ";
            r5.<init>(r6);
            r5 = r5.append(r1);
            r5 = r5.toString();
            com.tencent.mm.sdk.platformtools.x.i(r4, r5);
        L_0x011a:
            r4 = com.tencent.mm.audio.b.e.this;
            r4 = r4.flp;
            if (r1 >= r4) goto L_0x012e;
        L_0x0120:
            r4 = "MicroMsg.RecordModeAsyncRead";
            r5 = "read too fast? sleep 10 ms";
            com.tencent.mm.sdk.platformtools.x.i(r4, r5);
            r4 = 10;
            java.lang.Thread.sleep(r4);	 Catch:{ InterruptedException -> 0x0242 }
        L_0x012e:
            r4 = com.tencent.mm.audio.b.e.this;
            r4 = r4.flv;
            if (r4 == 0) goto L_0x0076;
        L_0x0134:
            if (r1 <= 0) goto L_0x0076;
        L_0x0136:
            r4 = r0.length;
            if (r1 <= r4) goto L_0x013a;
        L_0x0139:
            r1 = r0.length;
        L_0x013a:
            r4 = com.tencent.mm.audio.b.e.this;
            r4 = r4.flu;
            if (r4 == 0) goto L_0x022a;
        L_0x0140:
            r4 = com.tencent.mm.audio.b.e.this;
            r4 = r4.mIsMute;
            if (r4 == 0) goto L_0x0149;
        L_0x0146:
            java.util.Arrays.fill(r0, r3, r1, r3);
        L_0x0149:
            r4 = com.tencent.mm.audio.b.e.this;
            r5 = r4.flu;
            if (r1 <= 0) goto L_0x0162;
        L_0x014f:
            r4 = r5.gDC;
            if (r4 == 0) goto L_0x0158;
        L_0x0153:
            r4 = r5.gDD;
            r4.lock();
        L_0x0158:
            r4 = r5.gDA;
            r6 = r5.gDB;
            if (r4 != r6) goto L_0x0186;
        L_0x015e:
            r4 = r5.gDx;
        L_0x0160:
            if (r1 <= r4) goto L_0x01c0;
        L_0x0162:
            r1 = r2;
        L_0x0163:
            if (r1 == 0) goto L_0x0076;
        L_0x0165:
            r4 = "MicroMsg.RecordModeAsyncRead";
            r5 = "WriteToBuffer Failed, ret:%d AudioBuffer length: %d";
            r6 = new java.lang.Object[r9];
            r1 = java.lang.Integer.valueOf(r1);
            r6[r3] = r1;
            r1 = com.tencent.mm.audio.b.e.this;
            r1 = r1.flu;
            r1 = r1.xL();
            r1 = java.lang.Integer.valueOf(r1);
            r6[r10] = r1;
            com.tencent.mm.sdk.platformtools.x.e(r4, r5, r6);
            goto L_0x0076;
        L_0x0186:
            r4 = r5.gDB;
            r4 = r4 + 1;
            r6 = r5.gDx;
            r4 = r4 % r6;
            r6 = r5.gDA;
            if (r4 != r6) goto L_0x0193;
        L_0x0191:
            r4 = r3;
            goto L_0x0160;
        L_0x0193:
            r4 = r5.gDA;
            r6 = r5.gDB;
            if (r4 >= r6) goto L_0x01af;
        L_0x0199:
            r4 = r5.gDB;
            r6 = r5.gDA;
            r4 = r4 - r6;
            r5.gDy = r4;
        L_0x01a0:
            r4 = r5.gDC;
            if (r4 == 0) goto L_0x01a9;
        L_0x01a4:
            r4 = r5.gDD;
            r4.unlock();
        L_0x01a9:
            r4 = r5.gDx;
            r6 = r5.gDy;
            r4 = r4 - r6;
            goto L_0x0160;
        L_0x01af:
            r4 = r5.gDA;
            r6 = r5.gDB;
            if (r4 <= r6) goto L_0x01a0;
        L_0x01b5:
            r4 = r5.gDB;
            r6 = r5.gDx;
            r4 = r4 + r6;
            r6 = r5.gDA;
            r4 = r4 - r6;
            r5.gDy = r4;
            goto L_0x01a0;
        L_0x01c0:
            r4 = r5.gDB;
            r4 = r4 + r1;
            r6 = r5.gDx;
            r4 = r4 % r6;
            r6 = r5.gDA;
            if (r4 != r6) goto L_0x01cc;
        L_0x01ca:
            r1 = r2;
            goto L_0x0163;
        L_0x01cc:
            r4 = r5.gDC;
            if (r4 == 0) goto L_0x01d5;
        L_0x01d0:
            r4 = r5.gDD;
            r4.lock();
        L_0x01d5:
            r4 = r5.gDA;
            r6 = r5.gDB;
            if (r4 >= r6) goto L_0x021a;
        L_0x01db:
            r4 = r5.gDx;
            r6 = r5.gDB;
            r4 = r4 - r6;
            if (r1 <= r4) goto L_0x021a;
        L_0x01e2:
            r4 = r5.gDz;
            r6 = r5.gDB;
            r7 = r5.gDx;
            r8 = r5.gDB;
            r7 = r7 - r8;
            java.lang.System.arraycopy(r0, r3, r4, r6, r7);
            r4 = r5.gDx;
            r6 = r5.gDB;
            r4 = r4 - r6;
            r6 = r5.gDz;
            r7 = r5.gDx;
            r8 = r5.gDB;
            r7 = r7 - r8;
            r7 = r1 - r7;
            java.lang.System.arraycopy(r0, r4, r6, r3, r7);
            r4 = r5.gDx;
            r6 = r5.gDB;
            r4 = r4 - r6;
            r1 = r1 - r4;
            r5.gDB = r1;
            r1 = r5.gDB;
            r4 = r5.gDx;
            r1 = r1 % r4;
            r5.gDB = r1;
        L_0x020e:
            r1 = r5.gDC;
            if (r1 == 0) goto L_0x0217;
        L_0x0212:
            r1 = r5.gDD;
            r1.unlock();
        L_0x0217:
            r1 = r3;
            goto L_0x0163;
        L_0x021a:
            r4 = r5.gDz;
            r6 = r5.gDB;
            java.lang.System.arraycopy(r0, r3, r4, r6, r1);
            r4 = r5.gDB;
            r1 = r1 + r4;
            r4 = r5.gDx;
            r1 = r1 % r4;
            r5.gDB = r1;
            goto L_0x020e;
        L_0x022a:
            r4 = com.tencent.mm.audio.b.e.this;
            r4 = r4.flv;
            if (r4 == 0) goto L_0x0076;
        L_0x0230:
            r4 = com.tencent.mm.audio.b.e.this;
            r4 = r4.mIsMute;
            if (r4 == 0) goto L_0x0239;
        L_0x0236:
            java.util.Arrays.fill(r0, r3, r1, r3);
        L_0x0239:
            r4 = com.tencent.mm.audio.b.e.this;
            r4 = r4.flv;
            r4.q(r0, r1);
            goto L_0x0076;
        L_0x0242:
            r4 = move-exception;
            goto L_0x012e;
        L_0x0245:
            r4 = move-exception;
            goto L_0x008e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.audio.b.e.b.run():void");
        }
    }

    public e(AudioRecord audioRecord, boolean z, int i, com.tencent.mm.audio.b.c.a aVar, boolean z2) {
        this.fld = audioRecord;
        this.fkP = z;
        this.flp = i;
        this.flv = aVar;
        this.flB = z2;
    }

    public final boolean vs() {
        boolean z = true;
        x.i("MicroMsg.RecordModeAsyncRead", JsApiStartRecordVoice.NAME);
        synchronized (this.fly) {
            this.mStatus = 1;
        }
        com.tencent.mm.sdk.f.e.b(this.flt, "RecordModeAsyncRead_record", 10);
        if (true == this.flB) {
            boolean z2;
            this.flu = new com.tencent.mm.compatible.b.a();
            if (this.flu == null) {
                x.e("MicroMsg.RecordModeAsyncRead", "new m_audioBuffer error ");
                z2 = false;
            } else {
                this.fls = this.flp * 20;
                x.i("MicroMsg.RecordModeAsyncRead", "audioBuffer init mAudioBufferSize: " + this.fls);
                com.tencent.mm.compatible.b.a aVar = this.flu;
                int i = this.fls;
                if (i <= 0) {
                    z2 = true;
                } else {
                    aVar.gDz = new byte[i];
                    if (aVar.gDz == null) {
                        z2 = true;
                    } else {
                        aVar.gDx = i;
                        if (aVar.gDC) {
                            aVar.gDD = new ReentrantLock();
                        }
                        z2 = false;
                    }
                }
                if (z2) {
                    x.e("MicroMsg.RecordModeAsyncRead", new StringBuilder("audioBuffer init failed, error code = -1").toString());
                    z2 = false;
                } else {
                    z2 = true;
                }
            }
            if (z2) {
                if (this.flA || this.flz != null) {
                    x.w("MicroMsg.RecordModeAsyncRead", "Timer has been created or, timer has been started, " + this.flA);
                } else {
                    this.flz = new Timer();
                    if (this.flz != null) {
                        z = false;
                    }
                }
                if (z) {
                    x.e("MicroMsg.RecordModeAsyncRead", new StringBuilder("InitAudioRecTimer failed, error code = -1").toString());
                    return false;
                }
                this.flz.scheduleAtFixedRate(new a(), 60, 20);
                this.flA = true;
            } else {
                x.e("MicroMsg.RecordModeAsyncRead", "initAudioBuffer failed");
                return false;
            }
        }
        return true;
    }

    public final void uF() {
        x.i("MicroMsg.RecordModeAsyncRead", JsApiStopRecordVoice.NAME);
        synchronized (this.fly) {
            this.mStatus = 3;
        }
        synchronized (this.flx) {
            this.flx.notify();
        }
        com.tencent.mm.sdk.f.e.Q(this.flt);
        try {
            com.tencent.mm.sdk.f.e.S(this.flt);
        } catch (InterruptedException e) {
        }
        if (this.flu != null) {
            if (this.flz != null) {
                this.flz.cancel();
                this.flz = null;
            }
            com.tencent.mm.compatible.b.a aVar = this.flu;
            aVar.gDx = 0;
            aVar.gDy = 0;
            aVar.gDA = 0;
            aVar.gDB = 0;
            aVar.gDz = null;
            synchronized (this.flw) {
                this.flu = null;
                this.flv = null;
            }
            this.flA = false;
            this.flu = null;
        }
    }

    public final int vv() {
        synchronized (this.flw) {
            if (this.flu != null) {
                int i = this.flu.gDx;
                return i;
            }
            return -1;
        }
    }

    public final int vw() {
        synchronized (this.flw) {
            if (this.flu != null) {
                int xL = this.flu.xL();
                return xL;
            }
            return -1;
        }
    }

    public final int t(byte[] bArr, int i) {
        int i2 = -1;
        synchronized (this.flw) {
            if (this.flu != null) {
                com.tencent.mm.compatible.b.a aVar = this.flu;
                if (i > 0 && i <= aVar.xL() && bArr != null && aVar.gDA != aVar.gDB) {
                    if (aVar.gDC) {
                        aVar.gDD.lock();
                    }
                    if (aVar.gDA < aVar.gDB) {
                        System.arraycopy(aVar.gDz, aVar.gDA, bArr, 0, i);
                        aVar.gDA += i;
                    } else if (i <= aVar.gDx - aVar.gDA) {
                        System.arraycopy(aVar.gDz, aVar.gDA, bArr, 0, i);
                        aVar.gDA += i;
                    } else {
                        System.arraycopy(aVar.gDz, aVar.gDA, bArr, 0, aVar.gDx - aVar.gDA);
                        System.arraycopy(aVar.gDz, 0, bArr, aVar.gDx - aVar.gDA, i - (aVar.gDx - aVar.gDA));
                        aVar.gDA = i - (aVar.gDx - aVar.gDA);
                    }
                    if (aVar.gDC) {
                        aVar.gDD.unlock();
                    }
                    i2 = 0;
                }
            }
        }
        return i2;
    }

    public final void aS(boolean z) {
        this.mIsMute = z;
    }
}
