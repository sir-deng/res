package com.google.android.exoplayer2.e;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodec.CodecException;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.r;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class b extends com.google.android.exoplayer2.a {
    private static final byte[] apr = t.al("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private final com.google.android.exoplayer2.drm.b<d> acy;
    private Format aeo;
    private ByteBuffer[] agD;
    private com.google.android.exoplayer2.drm.a<d> apA;
    public MediaCodec apB;
    public a apC;
    private int apD;
    private boolean apE;
    private boolean apF;
    private boolean apG;
    private boolean apH;
    private boolean apI;
    private boolean apJ;
    private boolean apK;
    private boolean apL;
    private ByteBuffer[] apM;
    private long apN;
    private int apO;
    private int apP;
    private boolean apQ;
    private boolean apR;
    private int apS;
    private int apT;
    private boolean apU;
    private boolean apV;
    private boolean apW;
    private boolean apX;
    private boolean apY;
    private boolean apZ;
    private final c aps;
    private final boolean apt;
    private final e apu;
    private final e apv;
    private final k apw;
    private final List<Long> apx;
    private final BufferInfo apy;
    private com.google.android.exoplayer2.drm.a<d> apz;
    public com.google.android.exoplayer2.b.d aqa;

    public static class a extends Exception {
        public final boolean aqb;
        public final String aqc;
        public final String aqd;
        public final String mimeType;

        public a(Format format, Throwable th, boolean z, int i) {
            super("Decoder init failed: [" + i + "], " + format, th);
            this.mimeType = format.adV;
            this.aqb = z;
            this.aqc = null;
            this.aqd = "com.google.android.exoplayer.MediaCodecTrackRenderer_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }

        public a(Format format, Throwable th, boolean z, String str) {
            String str2 = null;
            super("Decoder init failed: " + str + ", " + format, th);
            this.mimeType = format.adV;
            this.aqb = z;
            this.aqc = str;
            if (t.SDK_INT >= 21 && (th instanceof CodecException)) {
                str2 = ((CodecException) th).getDiagnosticInfo();
            }
            this.aqd = str2;
        }
    }

    public abstract int a(c cVar, Format format);

    public abstract void a(a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto);

    public abstract boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z);

    public b(int i, c cVar, com.google.android.exoplayer2.drm.b<d> bVar, boolean z) {
        super(i);
        com.google.android.exoplayer2.i.a.ap(t.SDK_INT >= 16);
        this.aps = (c) com.google.android.exoplayer2.i.a.Y(cVar);
        this.acy = bVar;
        this.apt = z;
        this.apu = new e(0);
        this.apv = new e(0);
        this.apw = new k();
        this.apx = new ArrayList();
        this.apy = new BufferInfo();
        this.apS = 0;
        this.apT = 0;
    }

    public final int hV() {
        return 8;
    }

    public final int b(Format format) {
        try {
            int a = a(this.aps, format);
            if ((a & 7) <= 2) {
                return a;
            }
            com.google.android.exoplayer2.drm.b bVar = this.acy;
            boolean jq = format.adY == null ? true : bVar == null ? false : bVar.jq();
            if (jq) {
                return a;
            }
            return (a & -8) | 2;
        } catch (Exception e) {
            throw com.google.android.exoplayer2.e.a(e, this.index);
        }
    }

    public a a(c cVar, Format format, boolean z) {
        return cVar.b(format.adV, z);
    }

    public final void jL() {
        boolean z = false;
        if (this.apB == null && this.aeo != null) {
            boolean z2;
            this.apz = this.apA;
            String str = this.aeo.adV;
            MediaCrypto mediaCrypto = null;
            if (this.apz != null) {
                d dVar = (d) this.apz.jp();
                if (dVar == null) {
                    Exception jo = this.apz.jo();
                    if (jo != null) {
                        throw com.google.android.exoplayer2.e.a(jo, this.index);
                    }
                    return;
                }
                MediaCrypto mediaCrypto2 = dVar.aiv;
                boolean z3 = !dVar.aiw && dVar.aiv.requiresSecureDecoderComponent(str);
                z2 = z3;
                mediaCrypto = mediaCrypto2;
            } else {
                z2 = false;
            }
            if (this.apC == null) {
                try {
                    this.apC = a(this.aps, this.aeo, z2);
                    if (this.apC == null && z2) {
                        this.apC = a(this.aps, this.aeo, false);
                        if (this.apC != null) {
                            new StringBuilder("Drm session requires secure decoder for ").append(str).append(", but no secure decoder available. Trying to proceed with ").append(this.apC.name).append(".");
                        }
                    }
                } catch (Throwable e) {
                    a(new a(this.aeo, e, z2, -49998));
                }
                if (this.apC == null) {
                    a(new a(this.aeo, null, z2, -49999));
                }
            }
            if (a(this.apC)) {
                boolean z4;
                String str2 = this.apC.name;
                int i = (t.SDK_INT <= 24 && "OMX.Exynos.avc.dec.secure".equals(str2) && (t.MODEL.startsWith("SM-T585") || t.MODEL.startsWith("SM-A520"))) ? 2 : (t.SDK_INT >= 24 || !(("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(t.DEVICE) || "flounder_lte".equals(t.DEVICE) || "grouper".equals(t.DEVICE) || "tilapia".equals(t.DEVICE)))) ? 0 : 1;
                this.apD = i;
                Format format = this.aeo;
                if (t.SDK_INT < 21 && format.adX.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2)) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.apE = z4;
                if (t.SDK_INT < 18 || ((t.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (t.SDK_INT == 19 && t.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2))))) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.apF = z4;
                if (t.SDK_INT > 17 || !("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2))) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                this.apG = z4;
                if ((t.SDK_INT > 23 || !"OMX.google.vorbis.decoder".equals(str2)) && !(t.SDK_INT <= 19 && "hb2000".equals(t.DEVICE) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)))) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                this.apH = z4;
                if (t.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str2)) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.apI = z4;
                format = this.aeo;
                if (t.SDK_INT <= 18 && format.aef == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2)) {
                    z = true;
                }
                this.apJ = z;
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    r.beginSection("createCodec:" + str2);
                    this.apB = MediaCodec.createByCodecName(str2);
                    r.endSection();
                    r.beginSection("configureCodec");
                    a(this.apC, this.apB, this.aeo, mediaCrypto);
                    r.endSection();
                    r.beginSection("startCodec");
                    this.apB.start();
                    r.endSection();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    b(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.apM = this.apB.getInputBuffers();
                    this.agD = this.apB.getOutputBuffers();
                } catch (Throwable e2) {
                    a(new a(this.aeo, e2, z2, str2));
                }
                this.apN = this.state == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                this.apO = -1;
                this.apP = -1;
                this.apZ = true;
                com.google.android.exoplayer2.b.d dVar2 = this.aqa;
                dVar2.ahX++;
            }
        }
    }

    private void a(a aVar) {
        throw com.google.android.exoplayer2.e.a(aVar, this.index);
    }

    public boolean a(a aVar) {
        return true;
    }

    public void ae(boolean z) {
        this.aqa = new com.google.android.exoplayer2.b.d();
    }

    public void a(long j, boolean z) {
        this.apW = false;
        this.apX = false;
        if (this.apB != null) {
            this.apN = -9223372036854775807L;
            this.apO = -1;
            this.apP = -1;
            this.apZ = true;
            this.apY = false;
            this.apQ = false;
            this.apx.clear();
            this.apK = false;
            this.apL = false;
            if (this.apF || (this.apH && this.apV)) {
                jM();
                jL();
            } else if (this.apT != 0) {
                jM();
                jL();
            } else {
                this.apB.flush();
                this.apU = false;
            }
            if (this.apR && this.aeo != null) {
                this.apS = 1;
            }
        }
    }

    public void hX() {
        this.aeo = null;
        try {
            jM();
        } finally {
            this.apz = null;
            this.apA = null;
        }
    }

    public void jM() {
        this.apN = -9223372036854775807L;
        this.apO = -1;
        this.apP = -1;
        this.apY = false;
        this.apQ = false;
        this.apx.clear();
        this.apM = null;
        this.agD = null;
        this.apC = null;
        this.apR = false;
        this.apU = false;
        this.apE = false;
        this.apF = false;
        this.apD = 0;
        this.apG = false;
        this.apH = false;
        this.apJ = false;
        this.apK = false;
        this.apL = false;
        this.apV = false;
        this.apS = 0;
        this.apT = 0;
        this.apu.aif = null;
        if (this.apB != null) {
            com.google.android.exoplayer2.b.d dVar = this.aqa;
            dVar.ahY++;
            try {
                this.apB.stop();
                try {
                    this.apB.release();
                } finally {
                    this.apB = null;
                    if (!(this.apz == null || this.apA == this.apz)) {
                        this.apz = null;
                    }
                }
            } catch (Throwable th) {
                this.apB.release();
            } finally {
                this.apB = null;
                if (!(this.apz == null || this.apA == this.apz)) {
                    this.apz = null;
                }
            }
        }
    }

    public void hW() {
    }

    public void onStopped() {
    }

    public final void c(long j, long j2) {
        if (this.apX) {
            iW();
            return;
        }
        int a;
        if (this.aeo == null) {
            this.apv.clear();
            a = a(this.apw, this.apv, true);
            if (a == -5) {
                e(this.apw.aeo);
            } else if (a == -4) {
                com.google.android.exoplayer2.i.a.ap(this.apv.iZ());
                this.apW = true;
                jP();
                return;
            } else {
                return;
            }
        }
        jL();
        if (this.apB != null) {
            r.beginSection("drainAndFeed");
            do {
            } while (d(j, j2));
            do {
            } while (jN());
            r.endSection();
        } else {
            this.acj.D(j - this.ack);
            this.apv.clear();
            a = a(this.apw, this.apv, false);
            if (a == -5) {
                e(this.apw.aeo);
            } else if (a == -4) {
                com.google.android.exoplayer2.i.a.ap(this.apv.iZ());
                this.apW = true;
                jP();
            }
        }
        this.aqa.jd();
    }

    private boolean jN() {
        if (this.apB == null || this.apT == 2 || this.apW) {
            return false;
        }
        if (this.apO < 0) {
            this.apO = this.apB.dequeueInputBuffer(0);
            if (this.apO < 0) {
                return false;
            }
            this.apu.aif = this.apM[this.apO];
            this.apu.clear();
        }
        if (this.apT == 1) {
            if (!this.apG) {
                this.apV = true;
                this.apB.queueInputBuffer(this.apO, 0, 0, 0, 4);
                this.apO = -1;
            }
            this.apT = 2;
            return false;
        } else if (this.apK) {
            this.apK = false;
            this.apu.aif.put(apr);
            this.apB.queueInputBuffer(this.apO, 0, apr.length, 0, 0);
            this.apO = -1;
            this.apU = true;
            return true;
        } else {
            int i;
            int i2;
            if (this.apY) {
                i = -4;
                i2 = 0;
            } else {
                if (this.apS == 1) {
                    for (i2 = 0; i2 < this.aeo.adX.size(); i2++) {
                        this.apu.aif.put((byte[]) this.aeo.adX.get(i2));
                    }
                    this.apS = 2;
                }
                int position = this.apu.aif.position();
                i = a(this.apw, this.apu, false);
                i2 = position;
            }
            if (i == -3) {
                return false;
            }
            if (i == -5) {
                if (this.apS == 2) {
                    this.apu.clear();
                    this.apS = 1;
                }
                e(this.apw.aeo);
                return true;
            } else if (this.apu.iZ()) {
                if (this.apS == 2) {
                    this.apu.clear();
                    this.apS = 1;
                }
                this.apW = true;
                if (this.apU) {
                    try {
                        if (this.apG) {
                            return false;
                        }
                        this.apV = true;
                        this.apB.queueInputBuffer(this.apO, 0, 0, 0, 4);
                        this.apO = -1;
                        return false;
                    } catch (Exception e) {
                        throw com.google.android.exoplayer2.e.a(e, this.index);
                    }
                }
                jP();
                return false;
            } else if (!this.apZ || this.apu.ja()) {
                boolean z;
                this.apZ = false;
                boolean je = this.apu.je();
                if (this.apz == null || (!je && this.apt)) {
                    z = false;
                } else {
                    i = this.apz.getState();
                    if (i == 1) {
                        throw com.google.android.exoplayer2.e.a(this.apz.jo(), this.index);
                    }
                    z = i != 4;
                }
                this.apY = z;
                if (this.apY) {
                    return false;
                }
                if (this.apE && !je) {
                    h.d(this.apu.aif);
                    if (this.apu.aif.position() == 0) {
                        return true;
                    }
                    this.apE = false;
                }
                try {
                    long j = this.apu.aig;
                    if (this.apu.iY()) {
                        this.apx.add(Long.valueOf(j));
                    }
                    this.apu.jf();
                    jO();
                    if (je) {
                        CryptoInfo cryptoInfo = this.apu.aie.ahU;
                        if (i2 != 0) {
                            if (cryptoInfo.numBytesOfClearData == null) {
                                cryptoInfo.numBytesOfClearData = new int[1];
                            }
                            int[] iArr = cryptoInfo.numBytesOfClearData;
                            iArr[0] = i2 + iArr[0];
                        }
                        this.apB.queueSecureInputBuffer(this.apO, 0, cryptoInfo, j, 0);
                    } else {
                        this.apB.queueInputBuffer(this.apO, 0, this.apu.aif.limit(), j, 0);
                    }
                    this.apO = -1;
                    this.apU = true;
                    this.apS = 0;
                    com.google.android.exoplayer2.b.d dVar = this.aqa;
                    dVar.ahZ++;
                    return true;
                } catch (Exception e2) {
                    throw com.google.android.exoplayer2.e.a(e2, this.index);
                }
            } else {
                this.apu.clear();
                if (this.apS == 2) {
                    this.apS = 1;
                }
                return true;
            }
        }
    }

    public void b(String str, long j, long j2) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(com.google.android.exoplayer2.Format r7) {
        /*
        r6 = this;
        r1 = 0;
        r2 = 0;
        r3 = 1;
        r4 = r6.aeo;
        r6.aeo = r7;
        r0 = r6.aeo;
        r5 = r0.adY;
        if (r4 != 0) goto L_0x0030;
    L_0x000d:
        r0 = r1;
    L_0x000e:
        r0 = com.google.android.exoplayer2.i.t.h(r5, r0);
        if (r0 != 0) goto L_0x0033;
    L_0x0014:
        r0 = r3;
    L_0x0015:
        if (r0 == 0) goto L_0x004a;
    L_0x0017:
        r0 = r6.aeo;
        r0 = r0.adY;
        if (r0 == 0) goto L_0x0081;
    L_0x001d:
        r0 = r6.acy;
        if (r0 != 0) goto L_0x0035;
    L_0x0021:
        r0 = new java.lang.IllegalStateException;
        r1 = "Media requires a DrmSessionManager";
        r0.<init>(r1);
        r1 = r6.index;
        r0 = com.google.android.exoplayer2.e.a(r0, r1);
        throw r0;
    L_0x0030:
        r0 = r4.adY;
        goto L_0x000e;
    L_0x0033:
        r0 = r2;
        goto L_0x0015;
    L_0x0035:
        r0 = r6.acy;
        android.os.Looper.myLooper();
        r1 = r6.aeo;
        r1 = r1.adY;
        r0 = r0.jr();
        r6.apA = r0;
        r0 = r6.apA;
        r1 = r6.apz;
        if (r0 != r1) goto L_0x004a;
    L_0x004a:
        r0 = r6.apA;
        r1 = r6.apz;
        if (r0 != r1) goto L_0x0086;
    L_0x0050:
        r0 = r6.apB;
        if (r0 == 0) goto L_0x0086;
    L_0x0054:
        r0 = r6.apC;
        r0 = r0.apn;
        r1 = r6.aeo;
        r0 = r6.a(r0, r4, r1);
        if (r0 == 0) goto L_0x0086;
    L_0x0060:
        r6.apR = r3;
        r6.apS = r3;
        r0 = r6.apD;
        r1 = 2;
        if (r0 == r1) goto L_0x007d;
    L_0x0069:
        r0 = r6.apD;
        if (r0 != r3) goto L_0x0084;
    L_0x006d:
        r0 = r6.aeo;
        r0 = r0.width;
        r1 = r4.width;
        if (r0 != r1) goto L_0x0084;
    L_0x0075:
        r0 = r6.aeo;
        r0 = r0.height;
        r1 = r4.height;
        if (r0 != r1) goto L_0x0084;
    L_0x007d:
        r0 = r3;
    L_0x007e:
        r6.apK = r0;
    L_0x0080:
        return;
    L_0x0081:
        r6.apA = r1;
        goto L_0x004a;
    L_0x0084:
        r0 = r2;
        goto L_0x007e;
    L_0x0086:
        r0 = r6.apU;
        if (r0 == 0) goto L_0x008d;
    L_0x008a:
        r6.apT = r3;
        goto L_0x0080;
    L_0x008d:
        r6.jM();
        r6.jL();
        goto L_0x0080;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.b.e(com.google.android.exoplayer2.Format):void");
    }

    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    public void jO() {
    }

    public boolean a(boolean z, Format format, Format format2) {
        return false;
    }

    public boolean iu() {
        return this.apX;
    }

    public boolean it() {
        if (!(this.aeo == null || this.apY)) {
            if ((this.acl ? this.acm : this.acj.it()) || this.apP >= 0 || (this.apN != -9223372036854775807L && SystemClock.elapsedRealtime() < this.apN)) {
                return true;
            }
        }
        return false;
    }

    private boolean d(long j, long j2) {
        boolean z;
        if (this.apP < 0) {
            if (this.apI && this.apV) {
                try {
                    this.apP = this.apB.dequeueOutputBuffer(this.apy, 0);
                } catch (IllegalStateException e) {
                    jP();
                    if (this.apX) {
                        jM();
                    }
                    return false;
                }
            }
            this.apP = this.apB.dequeueOutputBuffer(this.apy, 0);
            if (this.apP >= 0) {
                if (this.apL) {
                    this.apL = false;
                    this.apB.releaseOutputBuffer(this.apP, false);
                    this.apP = -1;
                    return true;
                } else if ((this.apy.flags & 4) != 0) {
                    jP();
                    this.apP = -1;
                    return false;
                } else {
                    ByteBuffer byteBuffer = this.agD[this.apP];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.apy.offset);
                        byteBuffer.limit(this.apy.offset + this.apy.size);
                    }
                    long j3 = this.apy.presentationTimeUs;
                    int size = this.apx.size();
                    for (int i = 0; i < size; i++) {
                        if (((Long) this.apx.get(i)).longValue() == j3) {
                            this.apx.remove(i);
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    this.apQ = z;
                }
            } else if (this.apP == -2) {
                MediaFormat outputFormat = this.apB.getOutputFormat();
                if (this.apD != 0 && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                    this.apL = true;
                } else {
                    if (this.apJ) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    onOutputFormatChanged(this.apB, outputFormat);
                }
                return true;
            } else if (this.apP == -3) {
                this.agD = this.apB.getOutputBuffers();
                return true;
            } else {
                if (this.apG && (this.apW || this.apT == 2)) {
                    jP();
                }
                return false;
            }
        }
        if (this.apI && this.apV) {
            try {
                z = a(j, j2, this.apB, this.agD[this.apP], this.apP, this.apy.flags, this.apy.presentationTimeUs, this.apQ);
            } catch (IllegalStateException e2) {
                jP();
                if (this.apX) {
                    jM();
                }
                return false;
            }
        }
        z = a(j, j2, this.apB, this.agD[this.apP], this.apP, this.apy.flags, this.apy.presentationTimeUs, this.apQ);
        if (!z) {
            return false;
        }
        long j4 = this.apy.presentationTimeUs;
        this.apP = -1;
        return true;
    }

    public void iW() {
    }

    private void jP() {
        if (this.apT == 2) {
            jM();
            jL();
            return;
        }
        this.apX = true;
        iW();
    }
}
