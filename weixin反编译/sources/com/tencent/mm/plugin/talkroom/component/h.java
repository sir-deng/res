package com.tencent.mm.plugin.talkroom.component;

import android.media.AudioTrack;
import android.os.Looper;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.plugin.talkroom.component.e.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends a implements Runnable {
    private static final int sgK = com.tencent.mm.plugin.talkroom.model.a.sgK;
    private AudioTrack afZ;
    private int bufferSize = (((sgK / 1000) * 20) * 2);
    private boolean fib = false;
    private boolean fwD = true;
    private boolean hZb = false;
    private ag handler = new ag(Looper.getMainLooper());
    private boolean iaK = true;
    private final Object lock = new Object();
    private int nXo = 0;
    private int sgL = sgK;
    private final c sgM;
    private boolean sgN = false;
    private long sgO = 0;
    private int sgP;
    private long sgQ = 0;
    private v2engine sgv;
    private short sgw;
    private short sgx;

    public h(v2engine v2engine, c cVar) {
        this.sgv = v2engine;
        this.sgM = cVar;
        this.hZb = true;
        if (this.afZ != null && this.afZ.getState() == 1) {
            this.afZ.stop();
        }
        if (this.afZ != null) {
            try {
                this.afZ.release();
            } catch (Exception e) {
            }
        }
        v2engine.Hn().h(true, false);
        int bc = v2engine.Hn().bc(true);
        int minBufferSize = AudioTrack.getMinBufferSize(this.sgL, 2, 2);
        if (minBufferSize != -2 && minBufferSize != -1) {
            this.afZ = new d(bc, this.sgL, 2, 2, minBufferSize * 8);
            this.hZb = false;
        }
    }

    public final void byf() {
        this.fwD = true;
        if (this.afZ != null && this.afZ.getState() == 1) {
            this.afZ.pause();
        }
    }

    public final void bFk() {
        if (this.afZ != null && this.afZ.getState() == 1) {
            this.afZ.play();
        }
        synchronized (this.lock) {
            this.fwD = false;
            this.lock.notify();
        }
        this.sgx = (short) 0;
        this.sgw = (short) 0;
    }

    public final void release() {
        x.i("MicroMsg.TalkRoomPlayer", "release");
        this.fib = true;
        if (this.afZ != null && this.afZ.getState() == 1) {
            this.afZ.stop();
        }
        if (this.afZ != null) {
            this.afZ.release();
        }
        synchronized (this.lock) {
            this.fwD = false;
            this.lock.notify();
        }
    }

    public final void run() {
        while (!this.fib) {
            if (this.hZb) {
                try {
                    Thread.sleep(50);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.TalkRoomPlayer", e, "", new Object[0]);
                }
            } else {
                synchronized (this.lock) {
                    if (this.fwD) {
                        try {
                            this.lock.wait();
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.TalkRoomPlayer", e2, "", new Object[0]);
                        }
                    }
                }
                long j = this.sgQ;
                this.sgQ = bi.Wz();
                j = this.sgQ - j;
                if (j < 20 && j > 0) {
                    try {
                        synchronized (this.lock) {
                            this.lock.wait(j);
                        }
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.TalkRoomPlayer", e22, "", new Object[0]);
                    }
                }
                try {
                    int GetAudioData;
                    PByteArray pByteArray = new PByteArray();
                    final PInt pInt = new PInt();
                    final PInt pInt2 = new PInt();
                    int IsSilenceFrame = this.sgv.IsSilenceFrame();
                    if (IsSilenceFrame == 0) {
                        GetAudioData = this.sgv.GetAudioData(pByteArray, this.bufferSize, pInt, pInt2);
                    } else {
                        GetAudioData = 0;
                    }
                    if (GetAudioData < 0) {
                        this.nXo++;
                        x.e("MicroMsg.TalkRoomPlayer", "GetAudioData err %d,  errcount %d", Integer.valueOf(GetAudioData), Integer.valueOf(this.nXo));
                        if (this.nXo >= 100) {
                            this.nXo = 0;
                            this.fwD = true;
                        }
                    } else {
                        boolean z;
                        if (IsSilenceFrame == 0) {
                            if (this.afZ.getPlayState() != 3) {
                                this.afZ.play();
                            }
                            byte[] bArr = pByteArray.value;
                            int length = pByteArray.value.length;
                            for (GetAudioData = 0; GetAudioData < length / 2; GetAudioData++) {
                                short s = (short) ((bArr[GetAudioData * 2] & 255) | (bArr[(GetAudioData * 2) + 1] << 8));
                                if (s > this.sgw) {
                                    this.sgw = s;
                                }
                            }
                            this.afZ.write(pByteArray.value, 0, pByteArray.value.length);
                        } else if (this.iaK) {
                            this.afZ.pause();
                        }
                        if (IsSilenceFrame == 0) {
                            this.sgO = bi.Wz();
                            z = false;
                        } else if (bi.bB(this.sgO) < 1000) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if ((!((!this.iaK && this.sgP == pInt2.value) || z || pInt.value == 0) || (!this.iaK && z)) && !this.sgN) {
                            if (!(z || pInt2.value == 0)) {
                                this.sgP = pInt2.value;
                            }
                            this.handler.postAtFrontOfQueueV2(new Runnable() {
                                public final void run() {
                                    h.this.sgN = true;
                                    try {
                                        h.this.sgM.j(pInt.value, pInt2.value, z);
                                    } catch (Throwable e) {
                                        x.printErrStackTrace("MicroMsg.TalkRoomPlayer", e, "", new Object[0]);
                                    }
                                    h.this.sgN = false;
                                }
                            });
                            this.iaK = z;
                        }
                    }
                } catch (Throwable e222) {
                    x.printErrStackTrace("MicroMsg.TalkRoomPlayer", e222, "", new Object[0]);
                    x.e("MicroMsg.TalkRoomPlayer", e222.toString());
                }
            }
        }
    }

    public final int bFj() {
        if (this.sgx < this.sgw) {
            this.sgx = this.sgw;
        }
        if (this.sgx == (short) 0) {
            return 0;
        }
        short s = (short) ((this.sgw * 100) / this.sgx);
        this.sgw = (short) 0;
        return s;
    }

    public final void start() {
        e.b(this, "TalkRoomPlayer_start").start();
    }
}
