package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCodec.OnFrameRenderedListener;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.r;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.video.e.a.AnonymousClass1;
import com.google.android.exoplayer2.video.e.a.AnonymousClass2;
import com.google.android.exoplayer2.video.e.a.AnonymousClass3;
import com.google.android.exoplayer2.video.e.a.AnonymousClass4;
import com.tencent.mm.BuildConfig;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class c extends com.google.android.exoplayer2.e.b {
    private static final int[] aDe = new int[]{1920, 1600, 1440, BuildConfig.VERSION_CODE, 960, 854, 640, 540, 480};
    private float aDA;
    private int aDB;
    private int aDC;
    private int aDD;
    private float aDE;
    b aDF;
    private long aDG;
    private int aDH;
    private final d aDf;
    private final com.google.android.exoplayer2.video.e.a aDg;
    private final long aDh;
    private final int aDi = 50;
    private final boolean aDj;
    private final long[] aDk;
    private Format[] aDl;
    private a aDm;
    private boolean aDn;
    private Surface aDo;
    private int aDp;
    private boolean aDq;
    private long aDr;
    private long aDs;
    private int aDt;
    private int aDu;
    private int aDv;
    private float aDw;
    private int aDx;
    private int aDy;
    private int aDz;
    private Surface aeI;
    private int aez;
    private boolean agL;
    private final Context context;

    @TargetApi(23)
    private final class b implements OnFrameRenderedListener {
        /* synthetic */ b(c cVar, MediaCodec mediaCodec, byte b) {
            this(mediaCodec);
        }

        private b(MediaCodec mediaCodec) {
            mediaCodec.setOnFrameRenderedListener(this, new Handler());
        }

        public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
            if (this == c.this.aDF) {
                c.this.lV();
            }
        }
    }

    protected static final class a {
        public final int aDI;
        public final int height;
        public final int width;

        public a(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.aDI = i3;
        }
    }

    public c(Context context, com.google.android.exoplayer2.e.c cVar, long j, com.google.android.exoplayer2.drm.b<d> bVar, Handler handler, e eVar) {
        boolean z = false;
        super(2, cVar, bVar, false);
        this.aDh = j;
        this.context = context.getApplicationContext();
        this.aDf = new d(context);
        this.aDg = new com.google.android.exoplayer2.video.e.a(handler, eVar);
        if (t.SDK_INT <= 22 && "foster".equals(t.DEVICE) && "NVIDIA".equals(t.MANUFACTURER)) {
            z = true;
        }
        this.aDj = z;
        this.aDk = new long[10];
        this.aDG = -9223372036854775807L;
        this.aDr = -9223372036854775807L;
        this.aDx = -1;
        this.aDy = -1;
        this.aDA = -1.0f;
        this.aDw = -1.0f;
        this.aDp = 1;
        lW();
    }

    protected final int a(com.google.android.exoplayer2.e.c cVar, Format format) {
        int i = 0;
        String str = format.adV;
        if (!g.aa(str)) {
            return 0;
        }
        boolean z;
        DrmInitData drmInitData = format.adY;
        if (drmInitData != null) {
            z = false;
            for (int i2 = 0; i2 < drmInitData.ait; i2++) {
                z |= drmInitData.ais[i2].aiu;
            }
        } else {
            z = false;
        }
        com.google.android.exoplayer2.e.a b = cVar.b(str, z);
        if (b == null) {
            return 1;
        }
        boolean z2;
        String str2 = format.adS;
        if (str2 == null || b.mimeType == null) {
            z2 = true;
        } else {
            String ac = g.ac(str2);
            if (ac == null) {
                z2 = true;
            } else if (b.mimeType.equals(ac)) {
                Pair Q = com.google.android.exoplayer2.e.d.Q(str2);
                if (Q == null) {
                    z2 = true;
                } else {
                    for (CodecProfileLevel codecProfileLevel : b.jK()) {
                        if (codecProfileLevel.profile == ((Integer) Q.first).intValue() && codecProfileLevel.level >= ((Integer) Q.second).intValue()) {
                            z2 = true;
                            break;
                        }
                    }
                    b.P("codec.profileLevel, " + str2 + ", " + ac);
                    z2 = false;
                }
            } else {
                b.P("codec.mime " + str2 + ", " + ac);
                z2 = false;
            }
        }
        if (z2 && format.width > 0 && format.height > 0) {
            if (t.SDK_INT >= 21) {
                z2 = b.a(format.width, format.height, (double) format.adZ);
            } else {
                if (format.width * format.height <= com.google.android.exoplayer2.e.d.jR()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    new StringBuilder("FalseCheck [legacyFrameSize, ").append(format.width).append("x").append(format.height).append("] [").append(t.aCI).append("]");
                }
            }
        }
        int i3 = b.apn ? 16 : 8;
        if (b.agL) {
            i = 32;
        }
        return (i | i3) | (z2 ? 4 : 3);
    }

    protected final void ae(boolean z) {
        boolean z2;
        super.ae(z);
        this.aez = this.aci.aez;
        if (this.aez != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.agL = z2;
        com.google.android.exoplayer2.video.e.a aVar = this.aDg;
        com.google.android.exoplayer2.b.d dVar = this.aqa;
        if (aVar.aEa != null) {
            aVar.handler.post(new AnonymousClass1(dVar));
        }
        d dVar2 = this.aDf;
        dVar2.aDR = false;
        if (dVar2.aDL) {
            dVar2.aDK.handler.sendEmptyMessage(1);
        }
    }

    protected final void a(Format[] formatArr, long j) {
        this.aDl = formatArr;
        if (this.aDG == -9223372036854775807L) {
            this.aDG = j;
        } else {
            if (this.aDH == this.aDk.length) {
                new StringBuilder("Too many stream changes, so dropping offset: ").append(this.aDk[this.aDH - 1]);
            } else {
                this.aDH++;
            }
            this.aDk[this.aDH - 1] = j;
        }
        super.a(formatArr, j);
    }

    protected final void a(long j, boolean z) {
        super.a(j, z);
        lU();
        this.aDu = 0;
        if (this.aDH != 0) {
            this.aDG = this.aDk[this.aDH - 1];
            this.aDH = 0;
        }
        if (z) {
            lT();
        } else {
            this.aDr = -9223372036854775807L;
        }
    }

    public final boolean it() {
        if (super.it() && (this.aDq || ((this.aDo != null && this.aeI == this.aDo) || this.apB == null || this.agL))) {
            this.aDr = -9223372036854775807L;
            return true;
        } else if (this.aDr == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.aDr) {
                return true;
            }
            this.aDr = -9223372036854775807L;
            return false;
        }
    }

    protected final void hW() {
        super.hW();
        this.aDt = 0;
        this.aDs = SystemClock.elapsedRealtime();
    }

    protected final void onStopped() {
        this.aDr = -9223372036854775807L;
        lZ();
        super.onStopped();
    }

    protected final void hX() {
        this.aDx = -1;
        this.aDy = -1;
        this.aDA = -1.0f;
        this.aDw = -1.0f;
        this.aDG = -9223372036854775807L;
        this.aDH = 0;
        lW();
        lU();
        d dVar = this.aDf;
        if (dVar.aDL) {
            dVar.aDK.handler.sendEmptyMessage(2);
        }
        this.aDF = null;
        this.agL = false;
        try {
            super.hX();
        } finally {
            this.aqa.jd();
            this.aDg.e(this.aqa);
        }
    }

    public final void c(int i, Object obj) {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                if (this.aDo != null) {
                    surface = this.aDo;
                } else {
                    com.google.android.exoplayer2.e.a aVar = this.apC;
                    if (aVar != null && ar(aVar.apo)) {
                        this.aDo = DummySurface.a(this.context, aVar.apo);
                        surface = this.aDo;
                    }
                }
            }
            if (this.aeI != surface) {
                this.aeI = surface;
                int i2 = this.state;
                if (i2 == 1 || i2 == 2) {
                    MediaCodec mediaCodec = this.apB;
                    if (t.SDK_INT < 23 || mediaCodec == null || surface == null || this.aDn) {
                        jM();
                        jL();
                    } else {
                        mediaCodec.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.aDo) {
                    lW();
                    lU();
                    return;
                }
                lY();
                lU();
                if (i2 == 2) {
                    lT();
                }
            } else if (surface != null && surface != this.aDo) {
                lY();
                if (this.aDq) {
                    this.aDg.c(this.aeI);
                }
            }
        } else if (i == 4) {
            this.aDp = ((Integer) obj).intValue();
            MediaCodec mediaCodec2 = this.apB;
            if (mediaCodec2 != null) {
                mediaCodec2.setVideoScalingMode(this.aDp);
            }
        } else {
            super.c(i, obj);
        }
    }

    protected final boolean a(com.google.android.exoplayer2.e.a aVar) {
        return this.aeI != null || ar(aVar.apo);
    }

    protected final void a(com.google.android.exoplayer2.e.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        a aVar2;
        Format[] formatArr = this.aDl;
        int i = format.width;
        int i2 = format.height;
        int l = l(format);
        if (formatArr.length == 1) {
            aVar2 = new a(i, i2, l);
        } else {
            int i3 = 0;
            int length = formatArr.length;
            int i4 = 0;
            while (i4 < length) {
                int i5;
                Format format2 = formatArr[i4];
                if (b(aVar.apn, format, format2)) {
                    i5 = (format2.width == -1 || format2.height == -1) ? 1 : 0;
                    i5 |= i3;
                    i = Math.max(i, format2.width);
                    i2 = Math.max(i2, format2.height);
                    i3 = Math.max(l, l(format2));
                } else {
                    i5 = i3;
                    i3 = l;
                }
                i4++;
                i = i;
                i2 = i2;
                l = i3;
                i3 = i5;
            }
            if (i3 != 0) {
                new StringBuilder("Resolutions unknown. Codec max resolution: ").append(i).append("x").append(i2);
                Point a = a(aVar, format);
                if (a != null) {
                    i = Math.max(i, a.x);
                    i2 = Math.max(i2, a.y);
                    l = Math.max(l, a(format.adV, i, i2));
                    new StringBuilder("Codec max resolution adjusted to: ").append(i).append("x").append(i2);
                }
            }
            aVar2 = new a(i, i2, l);
        }
        this.aDm = aVar2;
        aVar2 = this.aDm;
        boolean z = this.aDj;
        l = this.aez;
        MediaFormat iq = format.iq();
        iq.setInteger("max-width", aVar2.width);
        iq.setInteger("max-height", aVar2.height);
        if (aVar2.aDI != -1) {
            iq.setInteger("max-input-size", aVar2.aDI);
        }
        if (z) {
            iq.setInteger("auto-frc", 0);
        }
        if (l != 0) {
            iq.setFeatureEnabled("tunneled-playback", true);
            iq.setInteger("audio-session-id", l);
        }
        if (this.aeI == null) {
            com.google.android.exoplayer2.i.a.ap(ar(aVar.apo));
            if (this.aDo == null) {
                this.aDo = DummySurface.a(this.context, aVar.apo);
            }
            this.aeI = this.aDo;
        }
        mediaCodec.configure(iq, this.aeI, mediaCrypto, 0);
        if (t.SDK_INT >= 23 && this.agL) {
            this.aDF = new b(this, mediaCodec, (byte) 0);
        }
    }

    protected final void jM() {
        try {
            super.jM();
        } finally {
            if (this.aDo != null) {
                if (this.aeI == this.aDo) {
                    this.aeI = null;
                }
                this.aDo.release();
                this.aDo = null;
            }
        }
    }

    protected final void b(String str, long j, long j2) {
        com.google.android.exoplayer2.video.e.a aVar = this.aDg;
        if (aVar.aEa != null) {
            aVar.handler.post(new AnonymousClass2(str, j, j2));
        }
        boolean z = (("deb".equals(t.DEVICE) || "flo".equals(t.DEVICE)) && "OMX.qcom.video.decoder.avc".equals(str)) || ("tcl_eu".equals(t.DEVICE) && "OMX.MTK.VIDEO.DECODER.AVC".equals(str));
        this.aDn = z;
    }

    protected final void e(Format format) {
        super.e(format);
        com.google.android.exoplayer2.video.e.a aVar = this.aDg;
        if (aVar.aEa != null) {
            aVar.handler.post(new AnonymousClass3(format));
        }
        this.aDw = format.aeb == -1.0f ? 1.0f : format.aeb;
        this.aDv = m(format);
    }

    protected final void jO() {
        if (t.SDK_INT < 23 && this.agL) {
            lV();
        }
    }

    protected final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        Object obj = (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) ? 1 : null;
        if (obj != null) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.aDx = integer;
        if (obj != null) {
            integer = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer = mediaFormat.getInteger("height");
        }
        this.aDy = integer;
        this.aDA = this.aDw;
        if (t.SDK_INT < 21) {
            this.aDz = this.aDv;
        } else if (this.aDv == 90 || this.aDv == 270) {
            integer = this.aDx;
            this.aDx = this.aDy;
            this.aDy = integer;
            this.aDA = 1.0f / this.aDA;
        }
        mediaCodec.setVideoScalingMode(this.aDp);
    }

    protected final boolean a(boolean z, Format format, Format format2) {
        return b(z, format, format2) && format2.width <= this.aDm.width && format2.height <= this.aDm.height && l(format2) <= this.aDm.aDI;
    }

    protected final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        while (this.aDH != 0 && j3 >= this.aDk[0]) {
            this.aDG = this.aDk[0];
            this.aDH--;
            System.arraycopy(this.aDk, 1, this.aDk, 0, this.aDH);
        }
        if (z) {
            a(mediaCodec, i);
            return true;
        }
        long j4 = j3 - j;
        if (this.aeI == this.aDo) {
            if (!U(j4)) {
                return false;
            }
            a(mediaCodec, i);
            return true;
        } else if (!this.aDq) {
            if (t.SDK_INT >= 21) {
                a(mediaCodec, i, System.nanoTime());
            } else {
                b(mediaCodec, i);
            }
            return true;
        } else if (this.state != 2) {
            return false;
        } else {
            long j5;
            long j6;
            com.google.android.exoplayer2.b.d dVar;
            j4 -= (SystemClock.elapsedRealtime() * 1000) - j2;
            long nanoTime = System.nanoTime();
            long j7 = nanoTime + (j4 * 1000);
            d dVar2 = this.aDf;
            long j8 = j3 * 1000;
            if (dVar2.aDR) {
                if (j3 != dVar2.aDO) {
                    dVar2.aDU++;
                    dVar2.aDP = dVar2.aDQ;
                }
                if (dVar2.aDU >= 6) {
                    j5 = dVar2.aDP + ((j8 - dVar2.aDT) / dVar2.aDU);
                    if (dVar2.e(j5, j7)) {
                        dVar2.aDR = false;
                        j4 = j7;
                        j5 = j8;
                    } else {
                        j4 = (dVar2.aDS + j5) - dVar2.aDT;
                    }
                    if (!dVar2.aDR) {
                        dVar2.aDT = j8;
                        dVar2.aDS = j7;
                        dVar2.aDU = 0;
                        dVar2.aDR = true;
                    }
                    dVar2.aDO = j3;
                    dVar2.aDQ = j5;
                    if (!(dVar2.aDK == null || dVar2.aDK.aDV == 0)) {
                        j7 = dVar2.aDK.aDV;
                        j5 = dVar2.aDM;
                        j7 += ((j4 - j7) / j5) * j5;
                        if (j4 > j7) {
                            j5 = j7 - j5;
                        } else {
                            j6 = j5 + j7;
                            j5 = j7;
                            j7 = j6;
                        }
                        j4 = (j7 - j4 >= j4 - j5 ? j7 : j5) - dVar2.aDN;
                    }
                    j7 = (j4 - nanoTime) / 1000;
                    if (U(j7)) {
                        if (t.SDK_INT < 21) {
                            if (j7 < 50000) {
                                a(mediaCodec, i, j4);
                                return true;
                            }
                        } else if (j7 < 30000) {
                            if (j7 > 11000) {
                                try {
                                    Thread.sleep((j7 - 10000) / 1000);
                                } catch (InterruptedException e) {
                                    Thread.currentThread().interrupt();
                                }
                            }
                            b(mediaCodec, i);
                            return true;
                        }
                        return false;
                    }
                    r.beginSection("dropVideoBuffer");
                    mediaCodec.releaseOutputBuffer(i, false);
                    r.endSection();
                    dVar = this.aqa;
                    dVar.aic++;
                    this.aDt++;
                    this.aDu++;
                    this.aqa.aid = Math.max(this.aDu, this.aqa.aid);
                    if (this.aDt == this.aDi) {
                        lZ();
                    }
                    return true;
                } else if (dVar2.e(j8, j7)) {
                    dVar2.aDR = false;
                }
            }
            j4 = j7;
            j5 = j8;
            if (dVar2.aDR) {
                dVar2.aDT = j8;
                dVar2.aDS = j7;
                dVar2.aDU = 0;
                dVar2.aDR = true;
            }
            dVar2.aDO = j3;
            dVar2.aDQ = j5;
            j7 = dVar2.aDK.aDV;
            j5 = dVar2.aDM;
            j7 += ((j4 - j7) / j5) * j5;
            if (j4 > j7) {
                j6 = j5 + j7;
                j5 = j7;
                j7 = j6;
            } else {
                j5 = j7 - j5;
            }
            if (j7 - j4 >= j4 - j5) {
            }
            j4 = (j7 - j4 >= j4 - j5 ? j7 : j5) - dVar2.aDN;
            j7 = (j4 - nanoTime) / 1000;
            if (U(j7)) {
                if (t.SDK_INT < 21) {
                    if (j7 < 30000) {
                        if (j7 > 11000) {
                            Thread.sleep((j7 - 10000) / 1000);
                        }
                        b(mediaCodec, i);
                        return true;
                    }
                } else if (j7 < 50000) {
                    a(mediaCodec, i, j4);
                    return true;
                }
                return false;
            }
            r.beginSection("dropVideoBuffer");
            mediaCodec.releaseOutputBuffer(i, false);
            r.endSection();
            dVar = this.aqa;
            dVar.aic++;
            this.aDt++;
            this.aDu++;
            this.aqa.aid = Math.max(this.aDu, this.aqa.aid);
            if (this.aDt == this.aDi) {
                lZ();
            }
            return true;
        }
    }

    private void a(MediaCodec mediaCodec, int i) {
        r.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        r.endSection();
        com.google.android.exoplayer2.b.d dVar = this.aqa;
        dVar.aib++;
    }

    private void b(MediaCodec mediaCodec, int i) {
        lX();
        r.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        r.endSection();
        com.google.android.exoplayer2.b.d dVar = this.aqa;
        dVar.aia++;
        this.aDu = 0;
        lV();
    }

    @TargetApi(21)
    private void a(MediaCodec mediaCodec, int i, long j) {
        lX();
        r.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j);
        r.endSection();
        com.google.android.exoplayer2.b.d dVar = this.aqa;
        dVar.aia++;
        this.aDu = 0;
        lV();
    }

    private boolean ar(boolean z) {
        return t.SDK_INT >= 23 && !this.agL && (!z || DummySurface.v(this.context));
    }

    private void lT() {
        this.aDr = this.aDh > 0 ? SystemClock.elapsedRealtime() + this.aDh : -9223372036854775807L;
    }

    private void lU() {
        this.aDq = false;
        if (t.SDK_INT >= 23 && this.agL) {
            MediaCodec mediaCodec = this.apB;
            if (mediaCodec != null) {
                this.aDF = new b(this, mediaCodec, (byte) 0);
            }
        }
    }

    final void lV() {
        if (!this.aDq) {
            this.aDq = true;
            this.aDg.c(this.aeI);
        }
    }

    private void lW() {
        this.aDB = -1;
        this.aDC = -1;
        this.aDE = -1.0f;
        this.aDD = -1;
    }

    private void lX() {
        if (this.aDx != -1 || this.aDy != -1) {
            if (this.aDB != this.aDx || this.aDC != this.aDy || this.aDD != this.aDz || this.aDE != this.aDA) {
                this.aDg.b(this.aDx, this.aDy, this.aDz, this.aDA);
                this.aDB = this.aDx;
                this.aDC = this.aDy;
                this.aDD = this.aDz;
                this.aDE = this.aDA;
            }
        }
    }

    private void lY() {
        if (this.aDB != -1 || this.aDC != -1) {
            this.aDg.b(this.aDB, this.aDC, this.aDD, this.aDE);
        }
    }

    private void lZ() {
        if (this.aDt > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = elapsedRealtime - this.aDs;
            com.google.android.exoplayer2.video.e.a aVar = this.aDg;
            int i = this.aDt;
            if (aVar.aEa != null) {
                aVar.handler.post(new AnonymousClass4(i, j));
            }
            this.aDt = 0;
            this.aDs = elapsedRealtime;
        }
    }

    private static boolean U(long j) {
        return j < -30000;
    }

    private static Point a(com.google.android.exoplayer2.e.a aVar, Format format) {
        Object obj = format.height > format.width ? 1 : null;
        int i = obj != null ? format.height : format.width;
        int i2 = obj != null ? format.width : format.height;
        float f = ((float) i2) / ((float) i);
        for (int i3 : aDe) {
            int i32;
            int i4 = (int) (((float) i32) * f);
            if (i32 <= i || i4 <= i2) {
                return null;
            }
            if (t.SDK_INT >= 21) {
                int i5;
                Point point;
                if (obj != null) {
                    i5 = i4;
                } else {
                    i5 = i32;
                }
                if (obj == null) {
                    i32 = i4;
                }
                if (aVar.apq == null) {
                    aVar.P("align.caps");
                    point = null;
                } else {
                    VideoCapabilities videoCapabilities = aVar.apq.getVideoCapabilities();
                    if (videoCapabilities == null) {
                        aVar.P("align.vCaps");
                        point = null;
                    } else {
                        int widthAlignment = videoCapabilities.getWidthAlignment();
                        int heightAlignment = videoCapabilities.getHeightAlignment();
                        point = new Point(t.at(i5, widthAlignment) * widthAlignment, t.at(i32, heightAlignment) * heightAlignment);
                    }
                }
                if (aVar.a(point.x, point.y, (double) format.adZ)) {
                    return point;
                }
            } else {
                i32 = t.at(i32, 16) * 16;
                i4 = t.at(i4, 16) * 16;
                if (i32 * i4 <= com.google.android.exoplayer2.e.d.jR()) {
                    return new Point(obj != null ? i4 : i32, obj != null ? i32 : i4);
                }
            }
        }
        return null;
    }

    private static int l(Format format) {
        if (format.adW == -1) {
            return a(format.adV, format.width, format.height);
        }
        int i = 0;
        for (int i2 = 0; i2 < format.adX.size(); i2++) {
            i += ((byte[]) format.adX.get(i2)).length;
        }
        return format.adW + i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(java.lang.String r6, int r7, int r8) {
        /*
        r4 = 16;
        r1 = 4;
        r0 = 2;
        r2 = -1;
        if (r7 == r2) goto L_0x0009;
    L_0x0007:
        if (r8 != r2) goto L_0x000b;
    L_0x0009:
        r0 = r2;
    L_0x000a:
        return r0;
    L_0x000b:
        r3 = r6.hashCode();
        switch(r3) {
            case -1664118616: goto L_0x0018;
            case -1662541442: goto L_0x0044;
            case 1187890754: goto L_0x0023;
            case 1331836730: goto L_0x002e;
            case 1599127256: goto L_0x0039;
            case 1599127257: goto L_0x004f;
            default: goto L_0x0012;
        };
    L_0x0012:
        r3 = r2;
    L_0x0013:
        switch(r3) {
            case 0: goto L_0x005a;
            case 1: goto L_0x005a;
            case 2: goto L_0x0063;
            case 3: goto L_0x007e;
            case 4: goto L_0x0081;
            case 5: goto L_0x0081;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
        goto L_0x000a;
    L_0x0018:
        r3 = "video/3gpp";
        r3 = r6.equals(r3);
        if (r3 == 0) goto L_0x0012;
    L_0x0021:
        r3 = 0;
        goto L_0x0013;
    L_0x0023:
        r3 = "video/mp4v-es";
        r3 = r6.equals(r3);
        if (r3 == 0) goto L_0x0012;
    L_0x002c:
        r3 = 1;
        goto L_0x0013;
    L_0x002e:
        r3 = "video/avc";
        r3 = r6.equals(r3);
        if (r3 == 0) goto L_0x0012;
    L_0x0037:
        r3 = r0;
        goto L_0x0013;
    L_0x0039:
        r3 = "video/x-vnd.on2.vp8";
        r3 = r6.equals(r3);
        if (r3 == 0) goto L_0x0012;
    L_0x0042:
        r3 = 3;
        goto L_0x0013;
    L_0x0044:
        r3 = "video/hevc";
        r3 = r6.equals(r3);
        if (r3 == 0) goto L_0x0012;
    L_0x004d:
        r3 = r1;
        goto L_0x0013;
    L_0x004f:
        r3 = "video/x-vnd.on2.vp9";
        r3 = r6.equals(r3);
        if (r3 == 0) goto L_0x0012;
    L_0x0058:
        r3 = 5;
        goto L_0x0013;
    L_0x005a:
        r1 = r7 * r8;
    L_0x005c:
        r1 = r1 * 3;
        r0 = r0 * 2;
        r0 = r1 / r0;
        goto L_0x000a;
    L_0x0063:
        r1 = "BRAVIA 4K 2015";
        r3 = com.google.android.exoplayer2.i.t.MODEL;
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x0070;
    L_0x006e:
        r0 = r2;
        goto L_0x000a;
    L_0x0070:
        r1 = com.google.android.exoplayer2.i.t.at(r7, r4);
        r2 = com.google.android.exoplayer2.i.t.at(r8, r4);
        r1 = r1 * r2;
        r1 = r1 * 16;
        r1 = r1 * 16;
        goto L_0x005c;
    L_0x007e:
        r1 = r7 * r8;
        goto L_0x005c;
    L_0x0081:
        r0 = r7 * r8;
        r5 = r1;
        r1 = r0;
        r0 = r5;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.c.a(java.lang.String, int, int):int");
    }

    private static boolean b(boolean z, Format format, Format format2) {
        return format.adV.equals(format2.adV) && m(format) == m(format2) && (z || (format.width == format2.width && format.height == format2.height));
    }

    private static int m(Format format) {
        return format.aea == -1 ? 0 : format.aea;
    }
}
