package com.tencent.mm.plugin.appbrand.media;

import android.media.AudioRecord;
import android.os.Looper;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.f.a.lk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.appbrand.media.encode.c;
import com.tencent.mm.plugin.appbrand.media.encode.d;
import com.tencent.mm.plugin.appbrand.media.record.RecordParam;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;

public final class f {
    private al jER = null;
    public com.tencent.mm.plugin.appbrand.media.record.a jFf = null;
    public boolean jFg = false;
    Object jFh = new Object();
    public RecordParam jFi;
    public int jFj = a.jFu;
    c jFk = null;
    boolean jFl = false;
    int jFm = 0;
    long jFn = 0;
    private int jFo = 0;
    private ag jFp;
    private com.tencent.mm.plugin.appbrand.media.record.a.a jFq = new com.tencent.mm.plugin.appbrand.media.record.a.a() {
        public final void q(byte[] bArr, int i) {
            if (f.this.jFk != null && f.this.jFf != null) {
                f fVar = f.this;
                int i2 = f.this.jFm;
                com.tencent.mm.plugin.appbrand.media.record.a aVar = f.this.jFf;
                fVar.jFm = (aVar.fkr != null ? aVar.fkr.fkO : 20) + i2;
                try {
                    if (!f.this.jFk.a(f.this.jFl, bArr, i)) {
                        x.e("MicroMsg.AudioRecordMgr", "encode pcm fail!");
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AudioRecordMgr", e, "onRecPcmDataReady", new Object[0]);
                    if (f.this.jFi != null && "mp3".equalsIgnoreCase(f.this.jFi.jiA)) {
                        j.ln(19);
                    } else if (f.this.jFi != null && "aac".equalsIgnoreCase(f.this.jFi.jiA)) {
                        j.ln(23);
                    }
                }
            }
        }

        public final void aK(int i, int i2) {
            x.i("MicroMsg.AudioRecordMgr", "onRecError state:%d, detailState:%d", Integer.valueOf(i), Integer.valueOf(i2));
            f.this.onError(1);
        }
    };
    private com.tencent.mm.plugin.appbrand.media.encode.c.a jFr = new com.tencent.mm.plugin.appbrand.media.encode.c.a() {
        public final void c(byte[] bArr, int i, boolean z) {
            f fVar = f.this;
            x.i("MicroMsg.AudioRecordMgr", "onFrameRecorded  buffSize:%d, isLastFrameL:%b", Integer.valueOf(i), Boolean.valueOf(z));
            b lkVar = new lk();
            lkVar.fDC.state = "frameRecorded";
            if (fVar.jFi != null) {
                lkVar.fDC.appId = fVar.jFi.appId;
            }
            lkVar.fDC.action = 5;
            Object obj = new byte[i];
            System.arraycopy(bArr, 0, obj, 0, i);
            lkVar.fDC.fDD = obj;
            lkVar.fDC.fDE = z;
            com.tencent.mm.sdk.b.a.xmy.a(lkVar, Looper.getMainLooper());
        }
    };
    private long mDuration = 0;
    private String mFilePath;
    private long mStartTime = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.media.f$6 */
    class AnonymousClass6 implements Runnable {
        final /* synthetic */ RecordParam jFt;

        public AnonymousClass6(RecordParam recordParam) {
            this.jFt = recordParam;
        }

        public final void run() {
            synchronized (f.this.jFh) {
                f.this.jFi = this.jFt;
                f.a(f.this);
            }
        }
    }

    public enum a {
        ;

        static {
            jFu = 1;
            jFv = 2;
            jFw = 3;
            jFx = 4;
            jFy = 5;
            jFz = 6;
            jFA = new int[]{jFu, jFv, jFw, jFx, jFy, jFz};
        }
    }

    static /* synthetic */ void a(f fVar) {
        try {
            x.i("MicroMsg.AudioRecordMgr", "_start in runnable");
            if (fVar.aiX()) {
                fVar.jFl = false;
                fVar.jFm = 0;
                if (fVar.aiW()) {
                    int i;
                    c cVar = fVar.jFk;
                    com.tencent.mm.plugin.appbrand.media.record.a aVar = fVar.jFf;
                    if (aVar.fkr != null) {
                        com.tencent.mm.audio.b.c cVar2 = aVar.fkr;
                        if (cVar2.flk > 0) {
                            i = cVar2.flk;
                        } else {
                            int minBufferSize = AudioRecord.getMinBufferSize(cVar2.mSampleRate, cVar2.fli, 2);
                            x.i("MicroMsg.MMPcmRecorder", "getDefaultMinBufferSize minBufSize:%d", Integer.valueOf(minBufferSize));
                            if (minBufferSize == -2 || minBufferSize == -1) {
                                i = 0;
                            } else {
                                cVar2.flk = minBufferSize * cVar2.fkR;
                                i = cVar2.flk;
                            }
                        }
                    } else {
                        i = 0;
                    }
                    cVar.lo(i);
                    fVar.jFk.lp(fVar.jFi.afs);
                    fVar.jFo = 0;
                    fVar.mDuration = (long) fVar.jFi.duration;
                    fVar.mStartTime = System.currentTimeMillis();
                    fVar.jFn = fVar.mDuration;
                    x.i("MicroMsg.AudioRecordMgr", "mDuration:%d, mCurrentTime:%d", Long.valueOf(fVar.mDuration), Long.valueOf(fVar.mStartTime));
                    fVar.aja().post(new Runnable() {
                        public final void run() {
                            f.a(f.this, f.this.jFn);
                        }
                    });
                    x.i("MicroMsg.AudioRecordMgr", "onStart");
                    fVar.jFj = a.jFv;
                    fVar.jFg = true;
                    b lkVar = new lk();
                    lkVar.fDC.action = 0;
                    lkVar.fDC.state = "start";
                    if (fVar.jFi != null) {
                        lkVar.fDC.appId = fVar.jFi.appId;
                    }
                    com.tencent.mm.sdk.b.a.xmy.a(lkVar, Looper.getMainLooper());
                    x.i("MicroMsg.AudioRecordMgr", "start record success");
                    return;
                }
                fVar.onError(6);
                x.e("MicroMsg.AudioRecordMgr", "start record fail");
                return;
            }
            fVar.onError(2);
            x.e("MicroMsg.AudioRecordMgr", "init encoder fail");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AudioRecordMgr", e, "_start", new Object[0]);
            fVar.onError(4);
        }
    }

    static /* synthetic */ void a(f fVar, long j) {
        fVar.TN();
        x.i("MicroMsg.AudioRecordMgr", "startTimer");
        fVar.jER = new al(new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean uG() {
                x.i("MicroMsg.AudioRecordMgr", "timer, onTimerExpired to stop record");
                f.this.vj();
                return true;
            }
        }, false);
        fVar.jER.K(j, j);
    }

    static /* synthetic */ void b(f fVar) {
        try {
            x.i("MicroMsg.AudioRecordMgr", "_resume in runnable");
            if (fVar.jFk == null) {
                fVar.onError(3);
                x.e("MicroMsg.AudioRecordMgr", "resume record fail");
            } else if (fVar.jFn <= 0) {
                fVar.aiZ();
                x.e("MicroMsg.AudioRecordMgr", "resume record fail, record time reach max time, to stop record");
            } else if (fVar.aiW()) {
                fVar.mStartTime = System.currentTimeMillis();
                x.i("MicroMsg.AudioRecordMgr", "mLimitTime:%d, currentTime:%d", Long.valueOf(fVar.jFn), Long.valueOf(fVar.mStartTime));
                fVar.aja().post(new Runnable() {
                    public final void run() {
                        f.a(f.this, f.this.jFn);
                    }
                });
                x.i("MicroMsg.AudioRecordMgr", "onResume");
                fVar.jFj = a.jFw;
                fVar.jFg = true;
                b lkVar = new lk();
                lkVar.fDC.action = 1;
                lkVar.fDC.state = "resume";
                if (fVar.jFi != null) {
                    lkVar.fDC.appId = fVar.jFi.appId;
                }
                com.tencent.mm.sdk.b.a.xmy.a(lkVar, Looper.getMainLooper());
                x.i("MicroMsg.AudioRecordMgr", "resume record success");
            } else {
                fVar.onError(7);
                x.e("MicroMsg.AudioRecordMgr", "resume record fail");
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AudioRecordMgr", e, "_resume", new Object[0]);
            fVar.onError(5);
        }
    }

    final void TN() {
        x.i("MicroMsg.AudioRecordMgr", "stopTimer");
        if (this.jER != null) {
            this.jER.TN();
        }
        this.jER = null;
    }

    public final boolean vh() {
        return this.jFj == a.jFx;
    }

    public final boolean aiV() {
        return this.jFj == a.jFy;
    }

    public final boolean vj() {
        x.i("MicroMsg.AudioRecordMgr", JsApiStopRecordVoice.NAME);
        if (this.jFf == null && this.jFk == null) {
            x.e("MicroMsg.AudioRecordMgr", "mRecord is null and mAudioEncoder is null, stop fail");
            return false;
        }
        e.post(new Runnable() {
            public final void run() {
                synchronized (f.this.jFh) {
                    f.this.aiZ();
                }
            }
        }, "app_brand_stop_record");
        return true;
    }

    private boolean aiW() {
        x.i("MicroMsg.AudioRecordMgr", "startRecordInternal");
        if (this.jFf != null) {
            this.jFf.vj();
            this.jFf = null;
            x.i("MicroMsg.AudioRecordMgr", "mRecorder is not null, stop it, and not callback stop event");
        }
        if (this.jFf == null) {
            this.jFf = new com.tencent.mm.plugin.appbrand.media.record.a(this.jFi);
            this.jFf.jFU = this.jFq;
        }
        com.tencent.mm.plugin.appbrand.media.record.a aVar = this.jFf;
        x.i("MicroMsg.AppBrandRecorder", JsApiStartRecordVoice.NAME);
        if (aVar.fkr != null) {
            aVar.fkr.vj();
            aVar.fkr = null;
        }
        aVar.jFT = System.currentTimeMillis();
        x.i("MicroMsg.AppBrandRecorder", "start time ticket:%d", Long.valueOf(aVar.jFT));
        aVar.fkr = new com.tencent.mm.audio.b.c(aVar.sampleRate, aVar.aef, aVar.fkS);
        if ("mp3".equalsIgnoreCase(aVar.jFS.jiA)) {
            aVar.fkr.et(40);
        } else {
            aVar.fkr.et(20);
        }
        aVar.fkr.aQ(false);
        aVar.fkr.fle = aVar.jFV;
        x.i("MicroMsg.AudioRecordMgr", "record start:%b", Boolean.valueOf(aVar.fkr.vs()));
        return aVar.fkr.vs();
    }

    private boolean aiX() {
        c aVar;
        boolean tQ;
        x.i("MicroMsg.AudioRecordMgr", "initEncode");
        if (this.jFk != null) {
            this.jFk.close();
            this.jFk = null;
        }
        String str = this.jFi.jiA;
        String str2 = this.jFi.gIR;
        File file = new File(g.Dq().gRT, SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder append = new StringBuilder(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE).append(ac.VF(str2));
        if (!TextUtils.isEmpty(str)) {
            if ("aac".equalsIgnoreCase(str)) {
                str = ".m4a";
            } else if ("mp3".equalsIgnoreCase(str)) {
                str = ".mp3";
            } else if ("wav".equalsIgnoreCase(str)) {
                str = ".wav";
            }
            x.d("MicroMsg.AudioRecordUtil", "getAudioFilePath audio name %s path %s", append.append(str).toString(), new File(file, append.append(str).toString()).getAbsoluteFile());
            this.mFilePath = r3.getAbsolutePath();
            x.i("MicroMsg.AudioRecordMgr", "mFilePath:%s", this.mFilePath);
            str = this.jFi.jiA;
            x.i("MicroMsg.AudioEncodeFactory", "createEncodeByType:%s", str);
            if (g.tP(str)) {
                if ("aac".equalsIgnoreCase(str)) {
                    aVar = new com.tencent.mm.plugin.appbrand.media.encode.a();
                } else if ("mp3".equalsIgnoreCase(str)) {
                    aVar = new d();
                } else if ("wav".equalsIgnoreCase(str)) {
                    aVar = new com.tencent.mm.plugin.appbrand.media.encode.e();
                }
                this.jFk = aVar;
                if (this.jFk == null) {
                    return false;
                }
                tQ = g.tQ(this.mFilePath);
                if (tQ) {
                    x.e("MicroMsg.AudioRecordMgr", "prepare cache file fail");
                    return tQ;
                }
                try {
                    tQ = this.jFk.f(this.mFilePath, this.jFi.sampleRate, this.jFi.jFX, this.jFi.jFY);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AudioRecordMgr", e, "init encoder fail", new Object[0]);
                    tQ = false;
                }
                this.jFk.a(this.jFr);
                return tQ;
            }
            aVar = null;
            this.jFk = aVar;
            if (this.jFk == null) {
                return false;
            }
            tQ = g.tQ(this.mFilePath);
            if (tQ) {
                tQ = this.jFk.f(this.mFilePath, this.jFi.sampleRate, this.jFi.jFX, this.jFi.jFY);
                this.jFk.a(this.jFr);
                return tQ;
            }
            x.e("MicroMsg.AudioRecordMgr", "prepare cache file fail");
            return tQ;
        }
        str = "";
        x.d("MicroMsg.AudioRecordUtil", "getAudioFilePath audio name %s path %s", append.append(str).toString(), new File(file, append.append(str).toString()).getAbsoluteFile());
        this.mFilePath = r3.getAbsolutePath();
        x.i("MicroMsg.AudioRecordMgr", "mFilePath:%s", this.mFilePath);
        str = this.jFi.jiA;
        x.i("MicroMsg.AudioEncodeFactory", "createEncodeByType:%s", str);
        if (g.tP(str)) {
            if ("aac".equalsIgnoreCase(str)) {
                aVar = new com.tencent.mm.plugin.appbrand.media.encode.a();
            } else if ("mp3".equalsIgnoreCase(str)) {
                aVar = new d();
            } else if ("wav".equalsIgnoreCase(str)) {
                aVar = new com.tencent.mm.plugin.appbrand.media.encode.e();
            }
            this.jFk = aVar;
            if (this.jFk == null) {
                return false;
            }
            tQ = g.tQ(this.mFilePath);
            if (tQ) {
                x.e("MicroMsg.AudioRecordMgr", "prepare cache file fail");
                return tQ;
            }
            tQ = this.jFk.f(this.mFilePath, this.jFi.sampleRate, this.jFi.jFX, this.jFi.jFY);
            this.jFk.a(this.jFr);
            return tQ;
        }
        aVar = null;
        this.jFk = aVar;
        if (this.jFk == null) {
            return false;
        }
        tQ = g.tQ(this.mFilePath);
        if (tQ) {
            tQ = this.jFk.f(this.mFilePath, this.jFi.sampleRate, this.jFi.jFX, this.jFi.jFY);
            this.jFk.a(this.jFr);
            return tQ;
        }
        x.e("MicroMsg.AudioRecordMgr", "prepare cache file fail");
        return tQ;
    }

    final void aiY() {
        x.i("MicroMsg.AudioRecordMgr", "pause record in runnable");
        boolean vj;
        try {
            if (vh()) {
                x.e("MicroMsg.AudioRecordMgr", "is paused, don't pause again");
                return;
            }
            if (this.jFf != null) {
                vj = this.jFf.vj();
                this.jFf = null;
            } else {
                vj = false;
            }
            aja().post(new Runnable() {
                public final void run() {
                    f.this.TN();
                }
            });
            x.i("MicroMsg.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis() - this.mStartTime), Integer.valueOf(this.jFo));
            this.jFo = (int) (((long) this.jFo) + r4);
            this.jFn = this.mDuration - ((long) this.jFo);
            x.i("MicroMsg.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", Long.valueOf(this.jFn), Integer.valueOf(this.jFo));
            x.i("MicroMsg.AudioRecordMgr", "stop:%b", Boolean.valueOf(vj));
            if (vj) {
                x.i("MicroMsg.AudioRecordMgr", "onPause");
                this.jFj = a.jFx;
                this.jFg = false;
                b lkVar = new lk();
                lkVar.fDC.action = 3;
                lkVar.fDC.state = "pause";
                if (this.jFi != null) {
                    lkVar.fDC.appId = this.jFi.appId;
                }
                com.tencent.mm.sdk.b.a.xmy.a(lkVar, Looper.getMainLooper());
                x.i("MicroMsg.AudioRecordMgr", "pause record success");
                return;
            }
            onError(8);
            x.e("MicroMsg.AudioRecordMgr", "pause record fail");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AudioRecordMgr", e, "_pause", new Object[0]);
            vj = false;
        }
    }

    private void aiZ() {
        x.i("MicroMsg.AudioRecordMgr", "stop record in runnable");
        boolean vj;
        try {
            if (aiV()) {
                x.e("MicroMsg.AudioRecordMgr", "is stopped, don't stop again");
                return;
            }
            if (this.jFf != null) {
                vj = this.jFf.vj();
                this.jFf = null;
            } else {
                x.e("MicroMsg.AudioRecordMgr", "mRecorder is null, has stop record!");
                vj = true;
            }
            this.jFl = true;
            x.i("MicroMsg.AudioRecordMgr", "mPcmDuration:%d", Integer.valueOf(this.jFm));
            if (this.jFk != null) {
                this.jFk.flush();
                this.jFk.close();
                this.jFk = null;
            }
            aja().post(new Runnable() {
                public final void run() {
                    f.this.TN();
                }
            });
            long currentTimeMillis = System.currentTimeMillis();
            x.i("MicroMsg.AudioRecordMgr", "currentTime:%d, interval:%d, mRealRecordedTime:%d", Long.valueOf(currentTimeMillis), Long.valueOf(System.currentTimeMillis() - this.mStartTime), Integer.valueOf(this.jFo));
            this.jFo = (int) (((long) this.jFo) + r6);
            this.jFn = this.mDuration - ((long) this.jFo);
            x.i("MicroMsg.AudioRecordMgr", "mLimitTime:%d, mRealRecordTime:%d", Long.valueOf(this.jFn), Integer.valueOf(this.jFo));
            x.i("MicroMsg.AudioRecordMgr", "stop:%b", Boolean.valueOf(vj));
            if (vj) {
                long length;
                x.i("MicroMsg.AudioRecordMgr", "onStop");
                this.jFj = a.jFy;
                this.jFg = false;
                b lkVar = new lk();
                lkVar.fDC.action = 2;
                lkVar.fDC.state = "stop";
                if (this.jFi != null) {
                    lkVar.fDC.appId = this.jFi.appId;
                }
                lkVar.fDC.duration = this.jFo;
                lkVar.fDC.filePath = this.mFilePath;
                com.tencent.mm.f.a.lk.a aVar = lkVar.fDC;
                File file = new File(this.mFilePath);
                if (file.exists()) {
                    x.i("MicroMsg.AudioRecordUtil", "exist audio file");
                    length = file.length();
                } else {
                    x.i("MicroMsg.AudioRecordUtil", "audio file not exit, path:%s", r0);
                    length = -1;
                }
                aVar.fileSize = (int) length;
                com.tencent.mm.sdk.b.a.xmy.a(lkVar, Looper.getMainLooper());
                x.i("MicroMsg.AudioRecordMgr", "stop record success");
            } else {
                onError(9);
                x.e("MicroMsg.AudioRecordMgr", "stop record fail");
            }
            this.jFi = null;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AudioRecordMgr", e, "_stop", new Object[0]);
            vj = false;
        }
    }

    private ag aja() {
        if (this.jFp == null) {
            this.jFp = new ag(Looper.getMainLooper());
        }
        return this.jFp;
    }

    protected final void onError(int i) {
        x.i("MicroMsg.AudioRecordMgr", "onError errType:%d", Integer.valueOf(i));
        if (this.jFj != a.jFz) {
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(689);
            iDKey.SetKey(1);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(689);
            iDKey2.SetKey(i.lm(i));
            iDKey2.SetValue(1);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            com.tencent.mm.plugin.report.service.g.pWK.a(arrayList, true);
        }
        this.jFj = a.jFz;
        this.jFg = false;
        b lkVar = new lk();
        lkVar.fDC.action = 4;
        lkVar.fDC.state = "error";
        if (this.jFi != null) {
            lkVar.fDC.appId = this.jFi.appId;
        }
        lkVar.fDC.errCode = i;
        com.tencent.mm.f.a.lk.a aVar = lkVar.fDC;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("errType:" + i + ", err:");
        switch (i) {
            case 1:
                stringBuilder.append("error PCM record callback");
                break;
            case 2:
                stringBuilder.append("init encoder fail, occur exception");
                break;
            case 3:
                stringBuilder.append("encoder un initial occur exception");
                break;
            case 4:
                stringBuilder.append("start record occur exception");
                break;
            case 5:
                stringBuilder.append("resume record occur exception");
                break;
            case 6:
                stringBuilder.append("fail to start record");
                break;
            case 7:
                stringBuilder.append("fail to resume record");
                break;
            case 8:
                stringBuilder.append("fail to pause record");
                break;
            case 9:
                stringBuilder.append("fail to stop record");
                break;
            case 15:
                stringBuilder.append("check param invalid");
                break;
            case 16:
                stringBuilder.append("not support format type");
                break;
            case 17:
                stringBuilder.append("fail to init mp3 encoder");
                break;
            case 18:
                stringBuilder.append("mp3 file not found exception");
                break;
            case 19:
                stringBuilder.append("mp3 encode exception");
                break;
            case 20:
                stringBuilder.append("mp3 write buffer exception");
                break;
            case 21:
                stringBuilder.append("fail to init aac encoder");
                break;
            case 22:
                stringBuilder.append("fail to create mp4 file");
                break;
            case 23:
                stringBuilder.append("aac encode exception");
                break;
            case 24:
                stringBuilder.append("create cache file fail");
                break;
            case 25:
                stringBuilder.append("init encoder fail");
                break;
            case 26:
                stringBuilder.append("not support sample rate");
                break;
            default:
                stringBuilder.append("unknow error");
                break;
        }
        aVar.foE = stringBuilder.toString();
        com.tencent.mm.sdk.b.a.xmy.a(lkVar, Looper.getMainLooper());
    }
}
