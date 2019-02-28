package com.tencent.mm.audio.b;

import android.media.AudioManager;
import android.media.AudioRecord;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.audio.c.b;
import com.tencent.mm.compatible.b.e;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.compatible.b.h;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.f.a.jm;
import com.tencent.mm.f.a.lq;
import com.tencent.mm.f.a.lr;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class c {
    public int fkJ = 0;
    int fkK = 0;
    int fkL = 0;
    int fkM = 0;
    private int fkN = 1;
    public int fkO = 120;
    private boolean fkP = false;
    boolean fkQ = false;
    public int fkR = 10;
    private int fkS = -1;
    public int fkT = -123456789;
    private boolean fkU = false;
    long fkV = -1;
    int fkW;
    boolean fkX = false;
    int fkY;
    private boolean fkZ = false;
    int fla = 0;
    boolean flb = false;
    boolean flc = false;
    private AudioRecord fld;
    public a fle;
    private f flf;
    private g flg;
    b flh;
    public int fli = 2;
    public int flj = 1;
    public int flk = 0;
    private com.tencent.mm.audio.b.f.a fll = new com.tencent.mm.audio.b.f.a() {
        public final void c(int i, byte[] bArr) {
            c cVar;
            int i2;
            int i3;
            c.this.fla++;
            if (c.this.flc && System.currentTimeMillis() - c.this.fkV <= 1000 && ((long) (c.this.fla - 10)) > (System.currentTimeMillis() - c.this.fkV) / ((long) c.this.fkO)) {
                com.tencent.mm.plugin.report.service.g.pWK.a(151, 0, 1, false);
                com.tencent.mm.plugin.report.service.g.pWK.a(151, 4, 1, false);
                x.e("MicroMsg.MMPcmRecorder", "return too many data, force stop, %d, %d", Integer.valueOf(c.this.fla), Long.valueOf((System.currentTimeMillis() - c.this.fkV) / ((long) c.this.fkO)));
                c.this.flb = true;
            }
            if (c.this.flh != null) {
                c.this.flh.u(bArr, i);
            }
            if (i > 0) {
                cVar = c.this;
                if (!(cVar.fkX && -2 == cVar.fkL)) {
                    int i4 = i / cVar.fkW;
                    for (i2 = 5; i2 <= cVar.fkY + i4; i2 += 5) {
                        i3 = ((i2 - cVar.fkY) - 1) * cVar.fkW;
                        int i5 = cVar.fkW + i3;
                        if (i3 < 0 || i5 > i) {
                            x.e("MicroMsg.MMPcmRecorder", "error start: %d, end: %d", Integer.valueOf(i3), Integer.valueOf(i5));
                            break;
                        }
                        while (i3 < i5) {
                            if (bArr[i3] != (byte) 0) {
                                cVar.fkL = -1;
                                cVar.fkX = true;
                                break;
                            }
                            i3++;
                        }
                        cVar.fkL++;
                    }
                    cVar.fkY = (cVar.fkY + i4) % 5;
                    if (cVar.fkL == 20) {
                        cVar.fkJ = 6;
                        x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_ERROR");
                        if (cVar.fkK == -1 && cVar.fkM == -1) {
                            cVar.fkJ = 11;
                            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                        } else if (cVar.fkK == -1) {
                            cVar.fkJ = 8;
                            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                        } else if (cVar.fkM == -1) {
                            cVar.fkJ = 9;
                            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
                        }
                        com.tencent.mm.plugin.report.service.g.pWK.a(151, 0, 1, false);
                        com.tencent.mm.plugin.report.service.g.pWK.a(151, 5, 1, false);
                        cVar.fkL = -2;
                        cVar.vt();
                    }
                }
            }
            if (!c.this.fkQ) {
                return;
            }
            if (i > 0) {
                cVar = c.this;
                if (cVar.fkK != -1) {
                    i3 = 0;
                    for (i2 = 0; i2 < i / 2; i2++) {
                        short s = (short) ((bArr[(i2 * 2) + 1] << 8) | (bArr[(i2 * 2) + 0] & 255));
                        if (s >= (short) 32760 || s == Short.MIN_VALUE) {
                            i3++;
                        }
                        if (i3 >= 5) {
                            cVar.fkK++;
                            break;
                        }
                    }
                    if (cVar.fkK > 100) {
                        cVar.fkJ = 7;
                        x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_ERROR");
                        if (cVar.fkL == -2 && cVar.fkM == -1) {
                            cVar.fkJ = 11;
                            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                        } else if (cVar.fkL == -2) {
                            cVar.fkJ = 8;
                            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_ERROR");
                        } else if (cVar.fkM == -1) {
                            cVar.fkJ = 10;
                            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
                        }
                        com.tencent.mm.plugin.report.service.g.pWK.a(151, 0, 1, false);
                        com.tencent.mm.plugin.report.service.g.pWK.a(151, 6, 1, false);
                        cVar.vt();
                        cVar.fkK = -1;
                        return;
                    }
                    return;
                }
                return;
            }
            c cVar2 = c.this;
            if (cVar2.fkM != -1 && i < 0) {
                cVar2.fkM++;
                if (cVar2.fkM >= 50) {
                    cVar2.fkJ = 5;
                    x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_READRET_ERROR");
                    if (cVar2.fkL == -2 && cVar2.fkK == -1) {
                        cVar2.fkJ = 11;
                        x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_DISTORTION_READRET_ERROR");
                    } else if (cVar2.fkL == -2) {
                        cVar2.fkJ = 9;
                        x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DATAZERO_READRET_ERROR");
                    } else if (cVar2.fkK == -1) {
                        cVar2.fkJ = 10;
                        x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_DISTORTION_READRET_ERROR");
                    }
                    com.tencent.mm.plugin.report.service.g.pWK.a(151, 0, 1, false);
                    com.tencent.mm.plugin.report.service.g.pWK.a(151, 7, 1, false);
                    cVar2.vt();
                    cVar2.fkM = -1;
                }
            }
        }
    };
    public int mSampleRate = 8000;

    public interface a {
        void aK(int i, int i2);

        void q(byte[] bArr, int i);
    }

    public c(int i, int i2, int i3) {
        this.fkN = i2;
        this.mSampleRate = i;
        this.fkS = i3;
        if (this.fkN == 2) {
            this.fli = 3;
        } else {
            this.fli = 2;
        }
        if (this.fkS == 0 && q.gHP.gGy > 0) {
            this.fkO = q.gHP.gGy;
        }
        if (q.gHP.gGJ > 0) {
            this.fli = q.gHP.gGJ;
        }
        if (q.gHP.gGt > 0) {
            this.fkR = q.gHP.gGt;
        }
        if (q.gHG.gEW) {
            this.flh = new b(g.flH, this.fkN, this.mSampleRate);
        }
        this.flc = 1 == g.t("EnableRecorderCheckUnreasonableData", 1);
        x.i("MicroMsg.MMPcmRecorder", "MMPcmRecorder sampleRate:%d channelCnt:%d durationPreFrame:%d newBufPreFrame:%b Biz:%d", Integer.valueOf(this.mSampleRate), Integer.valueOf(this.fkN), Integer.valueOf(this.fkO), Boolean.valueOf(this.fkP), Integer.valueOf(this.fkS));
    }

    public final void et(int i) {
        this.fkO = i;
        x.i("MicroMsg.MMPcmRecorder", "mDurationPreFrame: " + this.fkO);
    }

    public final void aQ(boolean z) {
        this.fkP = z;
        x.i("MicroMsg.MMPcmRecorder", "mNewBufPreFrame: " + this.fkP);
    }

    public final void vr() {
        this.fkQ = true;
        x.i("MicroMsg.MMPcmRecorder", "mCheckAudioQuality: " + this.fkQ);
    }

    public final void n(int i, boolean z) {
        if (10 == this.fkR || z) {
            this.fkR = i;
            x.i("MicroMsg.MMPcmRecorder", "mMultipleOfMinBuffer: " + this.fkR);
        }
    }

    public final void aR(boolean z) {
        this.fkU = z;
        x.i("MicroMsg.MMPcmRecorder", "mUsePreProcess: " + this.fkU);
    }

    private boolean init() {
        Object obj;
        this.flj = 1;
        boolean z = q.gHP.gGu != 2;
        int yw = m.yw();
        int i = q.gHG.gFj;
        if ((yw & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            if (i <= 0) {
                i = 0;
            }
            x.i("MicroMsg.MMPcmRecorder", "CPU ARMv7, enableRecTimerMode: " + i);
        } else {
            i = 1;
        }
        if (i == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        x.d("MicroMsg.MMPcmRecorder", "init, start getMinBufferSize");
        int minBufferSize = AudioRecord.getMinBufferSize(this.mSampleRate, this.fli, 2);
        if (minBufferSize == -2 || minBufferSize == -1) {
            this.flj = 3;
            this.fkJ = 1;
            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_MINBUFFER_ERROR " + minBufferSize);
            vt();
            return false;
        }
        int i2;
        AudioRecord audioRecord;
        boolean z2;
        a aVar;
        boolean z3;
        g gVar;
        x.d("MicroMsg.MMPcmRecorder", "finish getMinBufferSize, minBufSize: %d", Integer.valueOf(minBufferSize));
        this.fkW = (((this.mSampleRate * 20) * this.fkN) * 2) / 1000;
        int i3 = ((this.mSampleRate * this.fkO) * this.fkN) / 1000;
        int i4 = i3 * 2;
        x.i("MicroMsg.MMPcmRecorder", "Construct AudioRecord, minBufSize:%d, sampleRate:%d, sampleCntPreFrame:%d, sizePreFrame:%d, timesOfMinBuffer:%d, readMode:%b", Integer.valueOf(minBufferSize), Integer.valueOf(this.mSampleRate), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(this.fkR), Boolean.valueOf(z));
        yw = this.fkS;
        i = 1;
        if (1 == yw || 6 == yw || 7 == yw) {
            i = VERSION.SDK_INT < 11 ? 1 : 7;
            if (q.gHG.gEr) {
                i = 1;
            }
            if (q.gHG.gEQ >= 0) {
                i = q.gHG.gEQ;
            }
            if (6 == yw && q.gHG.gFt >= 0) {
                i2 = q.gHG.gFt;
                this.fld = new com.tencent.mm.compatible.b.c(i2, this.mSampleRate, this.fli, this.fkR * minBufferSize);
                if (this.fld.getState() == 0) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(151, 0, 1, false);
                    com.tencent.mm.plugin.report.service.g.pWK.a(151, 2, 1, false);
                    this.fld.release();
                    this.fkJ = 2;
                    x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
                    if (7 != i2) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    this.fld = new com.tencent.mm.compatible.b.c(i, this.mSampleRate, this.fli, this.fkR * minBufferSize);
                }
                if (this.fld.getState() != 0) {
                    com.tencent.mm.plugin.report.service.g.pWK.a(151, 0, 1, false);
                    com.tencent.mm.plugin.report.service.g.pWK.a(151, 2, 1, false);
                    this.fld.release();
                    this.fld = null;
                    this.flj = 2;
                    this.fkJ = 3;
                    x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
                    vt();
                    return false;
                }
                if (z) {
                    this.flf = new d(this.fld, this.fle, this.fkP, i3, i4);
                } else {
                    audioRecord = this.fld;
                    z2 = this.fkP;
                    aVar = this.fle;
                    z3 = (this.fkS != 1 || this.fkS == 6) && obj != null;
                    this.flf = new e(audioRecord, z2, i4, aVar, z3);
                }
                this.flf.a(this.fll);
                if (-123456789 != this.fkT) {
                    this.flf.eu(this.fkT);
                }
                if (this.fkU) {
                    this.flg = new g();
                    gVar = this.flg;
                    audioRecord = this.fld;
                    yw = this.fkS;
                    x.d("MicroMsg.MMAudioPreProcess", "api " + VERSION.SDK_INT);
                    if (!f.fO(16)) {
                        if (audioRecord == null) {
                            x.d("MicroMsg.MMAudioPreProcess", "audio is null");
                        } else if (1 != yw) {
                            if (q.gHP.gGQ == 1) {
                                x.d("MicroMsg.MMAudioPreProcess", "disable by config");
                            } else {
                                if (q.gHP.gGR != 2) {
                                    gVar.gEh = new i(audioRecord);
                                    if (gVar.gEh != null && gVar.gEh.isAvailable()) {
                                        gVar.gEh.xM();
                                    }
                                }
                                if (q.gHP.gGS != 2) {
                                    gVar.gEi = new e(audioRecord);
                                    if (gVar.gEi != null && gVar.gEi.isAvailable()) {
                                        gVar.gEi.xM();
                                    }
                                }
                                if (q.gHP.gGT != 2) {
                                    gVar.gEj = new h(audioRecord);
                                    if (gVar.gEj != null && gVar.gEj.isAvailable()) {
                                        gVar.gEj.xM();
                                    }
                                }
                            }
                        } else if (q.gHP.gGx == 1) {
                            x.d("MicroMsg.MMAudioPreProcess", "disable by config");
                        } else {
                            gVar.gEh = new i(audioRecord);
                            if (gVar.gEh != null && gVar.gEh.isAvailable()) {
                                gVar.gEh.xM();
                            }
                            gVar.gEi = new e(audioRecord);
                            if (gVar.gEi != null && gVar.gEi.isAvailable()) {
                                gVar.gEi.xM();
                            }
                            gVar.gEj = new h(audioRecord);
                            if (gVar.gEj != null && gVar.gEj.isAvailable()) {
                                gVar.gEj.xM();
                            }
                        }
                    }
                }
                return true;
            }
        }
        i2 = i;
        try {
            this.fld = new com.tencent.mm.compatible.b.c(i2, this.mSampleRate, this.fli, this.fkR * minBufferSize);
            if (this.fld.getState() == 0) {
                com.tencent.mm.plugin.report.service.g.pWK.a(151, 0, 1, false);
                com.tencent.mm.plugin.report.service.g.pWK.a(151, 2, 1, false);
                this.fld.release();
                this.fkJ = 2;
                x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEWAUDIORECORD_ERROR");
                if (7 != i2) {
                    i = 0;
                } else {
                    i = 1;
                }
                this.fld = new com.tencent.mm.compatible.b.c(i, this.mSampleRate, this.fli, this.fkR * minBufferSize);
            }
            if (this.fld.getState() != 0) {
                if (z) {
                    this.flf = new d(this.fld, this.fle, this.fkP, i3, i4);
                } else {
                    audioRecord = this.fld;
                    z2 = this.fkP;
                    aVar = this.fle;
                    if (this.fkS != 1) {
                    }
                    this.flf = new e(audioRecord, z2, i4, aVar, z3);
                }
                this.flf.a(this.fll);
                if (-123456789 != this.fkT) {
                    this.flf.eu(this.fkT);
                }
                if (this.fkU) {
                    this.flg = new g();
                    gVar = this.flg;
                    audioRecord = this.fld;
                    yw = this.fkS;
                    x.d("MicroMsg.MMAudioPreProcess", "api " + VERSION.SDK_INT);
                    if (f.fO(16)) {
                        if (audioRecord == null) {
                            x.d("MicroMsg.MMAudioPreProcess", "audio is null");
                        } else if (1 != yw) {
                            if (q.gHP.gGx == 1) {
                                gVar.gEh = new i(audioRecord);
                                gVar.gEh.xM();
                                gVar.gEi = new e(audioRecord);
                                gVar.gEi.xM();
                                gVar.gEj = new h(audioRecord);
                                gVar.gEj.xM();
                            } else {
                                x.d("MicroMsg.MMAudioPreProcess", "disable by config");
                            }
                        } else if (q.gHP.gGQ == 1) {
                            if (q.gHP.gGR != 2) {
                                gVar.gEh = new i(audioRecord);
                                gVar.gEh.xM();
                            }
                            if (q.gHP.gGS != 2) {
                                gVar.gEi = new e(audioRecord);
                                gVar.gEi.xM();
                            }
                            if (q.gHP.gGT != 2) {
                                gVar.gEj = new h(audioRecord);
                                gVar.gEj.xM();
                            }
                        } else {
                            x.d("MicroMsg.MMAudioPreProcess", "disable by config");
                        }
                    }
                }
                return true;
            }
            com.tencent.mm.plugin.report.service.g.pWK.a(151, 0, 1, false);
            com.tencent.mm.plugin.report.service.g.pWK.a(151, 2, 1, false);
            this.fld.release();
            this.fld = null;
            this.flj = 2;
            this.fkJ = 3;
            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_SECNEWAUDIORECORD_ERROR");
            vt();
            return false;
        } catch (Exception e) {
            x.e("MicroMsg.MMPcmRecorder", "new AudioRecord failed");
            this.fkJ = 12;
            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_NEW_AUDIORECORD_EXCEPTION");
            com.tencent.mm.plugin.report.service.g.pWK.a(151, 0, 1, false);
            com.tencent.mm.plugin.report.service.g.pWK.a(151, 1, 1, false);
            return false;
        }
    }

    public final void aS(boolean z) {
        x.i("MicroMsg.MMPcmRecorder", "switchMute mute:" + z);
        if (this.flf != null) {
            this.flf.aS(z);
        }
    }

    public final boolean vs() {
        boolean z = false;
        x.d("MicroMsg.MMPcmRecorder", JsApiStartRecordVoice.NAME);
        com.tencent.mm.sdk.b.b lqVar = new lq();
        lqVar.fDS.type = 1;
        lqVar.fDS.fDU = true;
        com.tencent.mm.sdk.b.a.xmy.m(lqVar);
        this.fkV = System.currentTimeMillis();
        this.fkX = false;
        if (lqVar.fDT.fDW) {
            x.e("MicroMsg.MMPcmRecorder", "can't start record due to permission tips policy");
            this.fkJ = 13;
        } else {
            AudioManager audioManager = (AudioManager) ad.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            if (audioManager == null || !audioManager.isMicrophoneMute()) {
                this.fkZ = false;
                com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
                x.i("MicroMsg.MMPcmRecorder", "startRecord, " + Thread.currentThread().getStackTrace()[2].getMethodName());
                if (this.fld != null) {
                    x.e("MicroMsg.MMPcmRecorder", "start error ,is recording ");
                } else {
                    aVar.gJu = SystemClock.elapsedRealtime();
                    x.d("MicroMsg.MMPcmRecorder", "startRecordInternal, start init");
                    if (init()) {
                        x.i("MicroMsg.MMPcmRecorder", "init cost: " + aVar.zp() + "ms");
                        aVar.gJu = SystemClock.elapsedRealtime();
                        this.fld.startRecording();
                        x.i("MicroMsg.MMPcmRecorder", "startRecording cost: " + aVar.zp());
                        if (this.fld.getRecordingState() != 3) {
                            com.tencent.mm.plugin.report.service.g.pWK.a(151, 0, 1, false);
                            com.tencent.mm.plugin.report.service.g.pWK.a(151, 3, 1, false);
                            this.flj = 2;
                            this.fkJ = 4;
                            x.e("MicroMsg.MMPcmRecorder", "[error] RECORDER_STARTRECORDING_ERROR");
                            vt();
                        } else if (this.flf != null) {
                            z = this.flf.vs();
                        } else {
                            x.e("MicroMsg.MMPcmRecorder", "mRecordMode is null");
                        }
                    } else {
                        x.e("MicroMsg.MMPcmRecorder", "startRecord init error");
                    }
                }
                if (!z) {
                    vj();
                    lqVar = new lr();
                    lqVar.fDX.type = 1;
                    com.tencent.mm.sdk.b.a.xmy.m(lqVar);
                }
            } else {
                x.e("MicroMsg.MMPcmRecorder", "microphone is mute");
                this.fkJ = 14;
                com.tencent.mm.sdk.b.a.xmy.m(new jm());
                com.tencent.mm.plugin.report.service.g.pWK.a(151, 0, 1, false);
                com.tencent.mm.plugin.report.service.g.pWK.a(151, 8, 1, false);
            }
        }
        return z;
    }

    public final synchronized boolean vj() {
        boolean z = true;
        synchronized (this) {
            if (true == this.fkZ) {
                x.i("MicroMsg.MMPcmRecorder", "already have stopped");
            } else {
                boolean z2;
                this.fkZ = true;
                com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
                if (this.flh != null) {
                    this.flh.vM();
                    this.flh = null;
                }
                aVar.gJu = SystemClock.elapsedRealtime();
                if (this.flf != null) {
                    this.flf.uF();
                    this.flf = null;
                }
                x.i("MicroMsg.MMPcmRecorder", "cost " + aVar.zp() + "ms to call stopRecord");
                x.i("MicroMsg.MMPcmRecorder", "stopRecord, " + Thread.currentThread().getStackTrace()[2].getMethodName());
                if (this.fld == null) {
                    x.e("MicroMsg.MMPcmRecorder", "audioRecord is null");
                    z2 = false;
                } else if (this.fld.getState() != 1) {
                    x.e("MicroMsg.MMPcmRecorder", "audioRecord sate error " + this.fld.getState());
                    z2 = false;
                } else {
                    aVar.gJu = SystemClock.elapsedRealtime();
                    this.fld.stop();
                    this.fld.release();
                    this.fld = null;
                    x.i("MicroMsg.MMPcmRecorder", "cost " + aVar.zp() + "ms to call stop and release");
                    z2 = true;
                }
                if (!(this.fkX || -1 == this.fkV || System.currentTimeMillis() - this.fkV < 2000) || this.flb) {
                    x.i("MicroMsg.MMPcmRecorder", "stopRecord publish PermissionShowDlgEvent");
                    com.tencent.mm.sdk.b.b lrVar = new lr();
                    lrVar.fDX.type = 1;
                    com.tencent.mm.sdk.b.a.xmy.m(lrVar);
                    z = false;
                }
                com.tencent.mm.sdk.b.b lqVar = new lq();
                lqVar.fDS.type = 1;
                lqVar.fDS.fDU = false;
                lqVar.fDS.fDV = z;
                com.tencent.mm.sdk.b.a.xmy.m(lqVar);
                x.i("MicroMsg.MMPcmRecorder", "doNewIDKeyStatOnStopRecord, mRecordDetailState: %d", Integer.valueOf(this.fkJ));
                ArrayList arrayList = new ArrayList();
                arrayList.add(new IDKey(357, 0, 1));
                if (this.fkJ != 0) {
                    arrayList.add(new IDKey(357, 1, 1));
                }
                switch (this.fkJ) {
                    case 1:
                        arrayList.add(new IDKey(357, 2, 1));
                        break;
                    case 2:
                        arrayList.add(new IDKey(357, 3, 1));
                        break;
                    case 3:
                        arrayList.add(new IDKey(357, 4, 1));
                        break;
                    case 4:
                        arrayList.add(new IDKey(357, 5, 1));
                        break;
                    case 5:
                        arrayList.add(new IDKey(357, 6, 1));
                        break;
                    case 6:
                        arrayList.add(new IDKey(357, 7, 1));
                        break;
                    case 7:
                        arrayList.add(new IDKey(357, 8, 1));
                        break;
                    case 8:
                        arrayList.add(new IDKey(357, 9, 1));
                        break;
                    case 9:
                        arrayList.add(new IDKey(357, 10, 1));
                        break;
                    case 10:
                        arrayList.add(new IDKey(357, 11, 1));
                        break;
                    case 11:
                        arrayList.add(new IDKey(357, 12, 1));
                        break;
                    case 12:
                        arrayList.add(new IDKey(357, 13, 1));
                        break;
                }
                x.i("MicroMsg.MMPcmRecorder", "do idkey, infolist size: %d", Integer.valueOf(arrayList.size()));
                com.tencent.mm.plugin.report.service.g.pWK.a(arrayList, false);
                z = z2;
            }
        }
        return z;
    }

    final void vt() {
        if (this.fle != null) {
            this.fle.aK(this.flj, this.fkJ);
        }
    }

    public final int vu() {
        if (this.flf != null) {
            return this.flf.vu();
        }
        return -1;
    }
}
