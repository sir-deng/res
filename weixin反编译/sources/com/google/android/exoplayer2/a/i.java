package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a.e.a.AnonymousClass1;
import com.google.android.exoplayer2.a.e.a.AnonymousClass2;
import com.google.android.exoplayer2.a.e.a.AnonymousClass3;
import com.google.android.exoplayer2.a.e.a.AnonymousClass4;
import com.google.android.exoplayer2.a.e.a.AnonymousClass6;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.e.c;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.p;
import java.util.Arrays;

@TargetApi(16)
public final class i extends b implements f {
    private int aef;
    private int aeg;
    private final com.google.android.exoplayer2.a.e.a ahl;
    private final f ahm;
    private boolean ahn;
    private boolean aho;
    private MediaFormat ahp;
    private long ahq;
    private boolean ahr;

    private final class a implements f.f {
        private a() {
        }

        /* synthetic */ a(i iVar, byte b) {
            this();
        }

        public final void bW(int i) {
            com.google.android.exoplayer2.a.e.a a = i.this.ahl;
            if (a.afB != null) {
                a.handler.post(new AnonymousClass6(i));
            }
            i.iS();
        }

        public final void is() {
            i.iT();
            i.this.ahr = true;
        }

        public final void d(int i, long j, long j2) {
            com.google.android.exoplayer2.a.e.a a = i.this.ahl;
            if (a.afB != null) {
                a.handler.post(new AnonymousClass4(i, j, j2));
            }
            i.iU();
        }
    }

    public i(c cVar, com.google.android.exoplayer2.drm.b<d> bVar, Handler handler, e eVar, c cVar2, d... dVarArr) {
        super(1, cVar, bVar, true);
        this.ahm = new f(cVar2, dVarArr, new a());
        this.ahl = new com.google.android.exoplayer2.a.e.a(handler, eVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final int a(com.google.android.exoplayer2.e.c r11, com.google.android.exoplayer2.Format r12) {
        /*
        r10 = this;
        r6 = 21;
        r7 = -1;
        r3 = 1;
        r1 = 0;
        r2 = r12.adV;
        r0 = com.google.android.exoplayer2.i.g.Z(r2);
        if (r0 != 0) goto L_0x000e;
    L_0x000d:
        return r1;
    L_0x000e:
        r0 = com.google.android.exoplayer2.i.t.SDK_INT;
        if (r0 < r6) goto L_0x0025;
    L_0x0012:
        r0 = 32;
    L_0x0014:
        r4 = r10.N(r2);
        if (r4 == 0) goto L_0x0027;
    L_0x001a:
        r4 = r11.jQ();
        if (r4 == 0) goto L_0x0027;
    L_0x0020:
        r0 = r0 | 8;
        r1 = r0 | 4;
        goto L_0x000d;
    L_0x0025:
        r0 = r1;
        goto L_0x0014;
    L_0x0027:
        r5 = r11.b(r2, r1);
        if (r5 != 0) goto L_0x002f;
    L_0x002d:
        r1 = r3;
        goto L_0x000d;
    L_0x002f:
        r2 = com.google.android.exoplayer2.i.t.SDK_INT;
        if (r2 < r6) goto L_0x0059;
    L_0x0033:
        r2 = r12.sampleRate;
        if (r2 == r7) goto L_0x0046;
    L_0x0037:
        r2 = r12.sampleRate;
        r4 = r5.apq;
        if (r4 != 0) goto L_0x0061;
    L_0x003d:
        r2 = "sampleRate.caps";
        r5.P(r2);
        r2 = r1;
    L_0x0044:
        if (r2 == 0) goto L_0x005a;
    L_0x0046:
        r2 = r12.aef;
        if (r2 == r7) goto L_0x0059;
    L_0x004a:
        r6 = r12.aef;
        r2 = r5.apq;
        if (r2 != 0) goto L_0x008e;
    L_0x0050:
        r2 = "channelCount.caps";
        r5.P(r2);
        r2 = r1;
    L_0x0057:
        if (r2 == 0) goto L_0x005a;
    L_0x0059:
        r1 = r3;
    L_0x005a:
        if (r1 == 0) goto L_0x0173;
    L_0x005c:
        r1 = 4;
    L_0x005d:
        r0 = r0 | 8;
        r1 = r1 | r0;
        goto L_0x000d;
    L_0x0061:
        r4 = r5.apq;
        r4 = r4.getAudioCapabilities();
        if (r4 != 0) goto L_0x0071;
    L_0x0069:
        r2 = "sampleRate.aCaps";
        r5.P(r2);
        r2 = r1;
        goto L_0x0044;
    L_0x0071:
        r4 = r4.isSampleRateSupported(r2);
        if (r4 != 0) goto L_0x008c;
    L_0x0077:
        r4 = new java.lang.StringBuilder;
        r6 = "sampleRate.support, ";
        r4.<init>(r6);
        r2 = r4.append(r2);
        r2 = r2.toString();
        r5.P(r2);
        r2 = r1;
        goto L_0x0044;
    L_0x008c:
        r2 = r3;
        goto L_0x0044;
    L_0x008e:
        r2 = r5.apq;
        r2 = r2.getAudioCapabilities();
        if (r2 != 0) goto L_0x009e;
    L_0x0096:
        r2 = "channelCount.aCaps";
        r5.P(r2);
        r2 = r1;
        goto L_0x0057;
    L_0x009e:
        r7 = r5.name;
        r8 = r5.mimeType;
        r4 = r2.getMaxInputChannelCount();
        if (r4 > r3) goto L_0x00b0;
    L_0x00a8:
        r2 = com.google.android.exoplayer2.i.t.SDK_INT;
        r9 = 26;
        if (r2 < r9) goto L_0x00c8;
    L_0x00ae:
        if (r4 <= 0) goto L_0x00c8;
    L_0x00b0:
        r2 = r4;
    L_0x00b1:
        if (r2 >= r6) goto L_0x0170;
    L_0x00b3:
        r2 = new java.lang.StringBuilder;
        r4 = "channelCount.support, ";
        r2.<init>(r4);
        r2 = r2.append(r6);
        r2 = r2.toString();
        r5.P(r2);
        r2 = r1;
        goto L_0x0057;
    L_0x00c8:
        r2 = "audio/mpeg";
        r2 = r2.equals(r8);
        if (r2 != 0) goto L_0x012b;
    L_0x00d1:
        r2 = "audio/3gpp";
        r2 = r2.equals(r8);
        if (r2 != 0) goto L_0x012b;
    L_0x00da:
        r2 = "audio/amr-wb";
        r2 = r2.equals(r8);
        if (r2 != 0) goto L_0x012b;
    L_0x00e3:
        r2 = "audio/mp4a-latm";
        r2 = r2.equals(r8);
        if (r2 != 0) goto L_0x012b;
    L_0x00ec:
        r2 = "audio/vorbis";
        r2 = r2.equals(r8);
        if (r2 != 0) goto L_0x012b;
    L_0x00f5:
        r2 = "audio/opus";
        r2 = r2.equals(r8);
        if (r2 != 0) goto L_0x012b;
    L_0x00fe:
        r2 = "audio/raw";
        r2 = r2.equals(r8);
        if (r2 != 0) goto L_0x012b;
    L_0x0107:
        r2 = "audio/flac";
        r2 = r2.equals(r8);
        if (r2 != 0) goto L_0x012b;
    L_0x0110:
        r2 = "audio/g711-alaw";
        r2 = r2.equals(r8);
        if (r2 != 0) goto L_0x012b;
    L_0x0119:
        r2 = "audio/g711-mlaw";
        r2 = r2.equals(r8);
        if (r2 != 0) goto L_0x012b;
    L_0x0122:
        r2 = "audio/gsm";
        r2 = r2.equals(r8);
        if (r2 == 0) goto L_0x012d;
    L_0x012b:
        r2 = r4;
        goto L_0x00b1;
    L_0x012d:
        r2 = "audio/ac3";
        r2 = r2.equals(r8);
        if (r2 == 0) goto L_0x0161;
    L_0x0136:
        r2 = 6;
    L_0x0137:
        r8 = new java.lang.StringBuilder;
        r9 = "AssumedMaxChannelAdjustment: ";
        r8.<init>(r9);
        r7 = r8.append(r7);
        r8 = ", [";
        r7 = r7.append(r8);
        r4 = r7.append(r4);
        r7 = " to ";
        r4 = r4.append(r7);
        r4 = r4.append(r2);
        r7 = "]";
        r4.append(r7);
        goto L_0x00b1;
    L_0x0161:
        r2 = "audio/eac3";
        r2 = r2.equals(r8);
        if (r2 == 0) goto L_0x016d;
    L_0x016a:
        r2 = 16;
        goto L_0x0137;
    L_0x016d:
        r2 = 30;
        goto L_0x0137;
    L_0x0170:
        r2 = r3;
        goto L_0x0057;
    L_0x0173:
        r1 = 3;
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.i.a(com.google.android.exoplayer2.e.c, com.google.android.exoplayer2.Format):int");
    }

    protected final com.google.android.exoplayer2.e.a a(c cVar, Format format, boolean z) {
        if (N(format.adV)) {
            com.google.android.exoplayer2.e.a jQ = cVar.jQ();
            if (jQ != null) {
                this.ahn = true;
                return jQ;
            }
        }
        this.ahn = false;
        return super.a(cVar, format, z);
    }

    private boolean N(String str) {
        f fVar = this.ahm;
        if (fVar.afP != null) {
            if (Arrays.binarySearch(fVar.afP.afy, f.M(str)) >= 0) {
                return true;
            }
        }
        return false;
    }

    protected final void a(com.google.android.exoplayer2.e.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        boolean z = t.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(aVar.name) && "samsung".equals(t.MANUFACTURER) && (t.DEVICE.startsWith("zeroflte") || t.DEVICE.startsWith("herolte") || t.DEVICE.startsWith("heroqlte"));
        this.aho = z;
        if (this.ahn) {
            this.ahp = format.iq();
            this.ahp.setString("mime", "audio/raw");
            mediaCodec.configure(this.ahp, null, mediaCrypto, 0);
            this.ahp.setString("mime", format.adV);
            return;
        }
        mediaCodec.configure(format.iq(), null, mediaCrypto, 0);
        this.ahp = null;
    }

    public final f hP() {
        return this;
    }

    protected final void b(String str, long j, long j2) {
        com.google.android.exoplayer2.a.e.a aVar = this.ahl;
        if (aVar.afB != null) {
            aVar.handler.post(new AnonymousClass2(str, j, j2));
        }
    }

    protected final void e(Format format) {
        super.e(format);
        com.google.android.exoplayer2.a.e.a aVar = this.ahl;
        if (aVar.afB != null) {
            aVar.handler.post(new AnonymousClass3(format));
        }
        this.aeg = "audio/raw".equals(format.adV) ? format.aeg : 2;
        this.aef = format.aef;
    }

    protected final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int[] iArr;
        Object obj = this.ahp != null ? 1 : null;
        String string = obj != null ? this.ahp.getString("mime") : "audio/raw";
        if (obj != null) {
            mediaFormat = this.ahp;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.aho && integer == 6 && this.aef < 6) {
            int[] iArr2 = new int[this.aef];
            for (i = 0; i < this.aef; i++) {
                iArr2[i] = i;
            }
            iArr = iArr2;
        } else {
            iArr = null;
        }
        try {
            f fVar = this.ahm;
            int i2 = this.aeg;
            boolean z = !"audio/raw".equals(string);
            int M = z ? f.M(string) : i2;
            if (z) {
                i2 = integer;
                i = M;
                M = 0;
            } else {
                fVar.agq = t.au(i2, integer);
                fVar.afQ.ahe = iArr;
                d[] dVarArr = fVar.afS;
                int length = dVarArr.length;
                i2 = 0;
                i = integer;
                integer = M;
                M = 0;
                while (i2 < length) {
                    d dVar = dVarArr[i2];
                    int r = dVar.r(integer2, i, integer) | M;
                    if (dVar.isActive()) {
                        i = dVar.iz();
                        integer = dVar.iA();
                    }
                    i2++;
                    M = r;
                }
                if (M != 0) {
                    fVar.iD();
                }
                i2 = i;
                i = integer;
            }
            switch (i2) {
                case 1:
                    integer = 4;
                    break;
                case 2:
                    integer = 12;
                    break;
                case 3:
                    integer = 28;
                    break;
                case 4:
                    integer = com.tencent.mm.plugin.appbrand.jsapi.a.d.CTRL_INDEX;
                    break;
                case 5:
                    integer = 220;
                    break;
                case 6:
                    integer = 252;
                    break;
                case 7:
                    integer = 1276;
                    break;
                case 8:
                    integer = com.google.android.exoplayer2.b.CHANNEL_OUT_7POINT1_SURROUND;
                    break;
                default:
                    throw new f.c("Unsupported channel count: " + i2);
            }
            if (t.SDK_INT <= 23 && "foster".equals(t.DEVICE) && "NVIDIA".equals(t.MANUFACTURER)) {
                switch (i2) {
                    case 3:
                    case 5:
                        integer = 252;
                        break;
                    case 7:
                        integer = com.google.android.exoplayer2.b.CHANNEL_OUT_7POINT1_SURROUND;
                        break;
                }
            }
            if (t.SDK_INT <= 25 && "fugu".equals(t.DEVICE) && z && i2 == 1) {
                integer = 12;
            }
            if (M != 0 || !fVar.isInitialized() || fVar.encoding != i || fVar.sampleRate != integer2 || fVar.aga != integer) {
                f fVar2;
                fVar.reset();
                fVar.encoding = i;
                fVar.agc = z;
                fVar.sampleRate = integer2;
                fVar.aga = integer;
                if (!z) {
                    i = 2;
                }
                fVar.agb = i;
                fVar.agt = t.au(2, i2);
                if (!z) {
                    integer = AudioTrack.getMinBufferSize(integer2, integer, fVar.agb);
                    com.google.android.exoplayer2.i.a.ap(integer != -2);
                    M = integer * 4;
                    i = ((int) fVar.w(250000)) * fVar.agt;
                    integer = (int) Math.max((long) integer, fVar.w(750000) * ((long) fVar.agt));
                    if (M < i) {
                        fVar2 = fVar;
                    } else if (M > integer) {
                        i = integer;
                        fVar2 = fVar;
                    } else {
                        i = M;
                        fVar2 = fVar;
                    }
                } else if (fVar.agb == 5 || fVar.agb == 6) {
                    i = 20480;
                    fVar2 = fVar;
                } else {
                    i = 49152;
                    fVar2 = fVar;
                }
                fVar2.bufferSize = i;
                fVar.agd = z ? -9223372036854775807L : fVar.v((long) (fVar.bufferSize / fVar.agt));
                fVar.b(fVar.acX);
            }
        } catch (Throwable e) {
            throw new f.c(e);
        } catch (Exception e2) {
            throw e.a(e2, this.index);
        }
    }

    protected static void iS() {
    }

    protected static void iT() {
    }

    protected static void iU() {
    }

    protected final void ae(boolean z) {
        boolean z2 = false;
        super.ae(z);
        com.google.android.exoplayer2.a.e.a aVar = this.ahl;
        com.google.android.exoplayer2.b.d dVar = this.aqa;
        if (aVar.afB != null) {
            aVar.handler.post(new AnonymousClass1(dVar));
        }
        int i = this.aci.aez;
        if (i != 0) {
            f fVar = this.ahm;
            if (t.SDK_INT >= 21) {
                z2 = true;
            }
            com.google.android.exoplayer2.i.a.ap(z2);
            if (!fVar.agL || fVar.aeR != i) {
                fVar.agL = true;
                fVar.aeR = i;
                fVar.reset();
                return;
            }
            return;
        }
        f fVar2 = this.ahm;
        if (fVar2.agL) {
            fVar2.agL = false;
            fVar2.aeR = 0;
            fVar2.reset();
        }
    }

    protected final void a(long j, boolean z) {
        super.a(j, z);
        this.ahm.reset();
        this.ahq = j;
        this.ahr = true;
    }

    protected final void hW() {
        super.hW();
        this.ahm.play();
    }

    protected final void onStopped() {
        f fVar = this.ahm;
        fVar.agK = false;
        if (fVar.isInitialized()) {
            fVar.iK();
            fVar.afW.pause();
        }
        super.onStopped();
    }

    protected final void hX() {
        try {
            f fVar = this.ahm;
            fVar.reset();
            fVar.iH();
            for (d reset : fVar.afS) {
                reset.reset();
            }
            fVar.aeR = 0;
            fVar.agK = false;
            try {
                super.hX();
            } finally {
                this.aqa.jd();
                this.ahl.e(this.aqa);
            }
        } catch (Throwable th) {
            super.hX();
        } finally {
            this.aqa.jd();
            this.ahl.e(this.aqa);
        }
    }

    public final boolean iu() {
        if (super.iu()) {
            f fVar = this.ahm;
            boolean z = !fVar.isInitialized() || (fVar.agJ && !fVar.iF());
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean it() {
        return this.ahm.iF() || super.it();
    }

    public final long iO() {
        long aj = this.ahm.aj(iu());
        if (aj != Long.MIN_VALUE) {
            if (!this.ahr) {
                aj = Math.max(this.ahq, aj);
            }
            this.ahq = aj;
            this.ahr = false;
        }
        return this.ahq;
    }

    public final p b(p pVar) {
        return this.ahm.b(pVar);
    }

    public final p iV() {
        return this.ahm.acX;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean a(long r12, long r14, android.media.MediaCodec r16, java.nio.ByteBuffer r17, int r18, int r19, long r20, boolean r22) {
        /*
        r11 = this;
        r2 = r11.ahn;
        if (r2 == 0) goto L_0x0012;
    L_0x0004:
        r2 = r19 & 2;
        if (r2 == 0) goto L_0x0012;
    L_0x0008:
        r2 = 0;
        r0 = r16;
        r1 = r18;
        r0.releaseOutputBuffer(r1, r2);
        r2 = 1;
    L_0x0011:
        return r2;
    L_0x0012:
        if (r22 == 0) goto L_0x0030;
    L_0x0014:
        r2 = 0;
        r0 = r16;
        r1 = r18;
        r0.releaseOutputBuffer(r1, r2);
        r2 = r11.aqa;
        r3 = r2.aib;
        r3 = r3 + 1;
        r2.aib = r3;
        r2 = r11.ahm;
        r3 = r2.agx;
        r4 = 1;
        if (r3 != r4) goto L_0x002e;
    L_0x002b:
        r3 = 2;
        r2.agx = r3;
    L_0x002e:
        r2 = 1;
        goto L_0x0011;
    L_0x0030:
        r10 = r11.ahm;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = r10.agE;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r2 == 0) goto L_0x003c;
    L_0x0036:
        r2 = r10.agE;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r0 = r17;
        if (r0 != r2) goto L_0x00cd;
    L_0x003c:
        r2 = 1;
    L_0x003d:
        com.google.android.exoplayer2.i.a.ao(r2);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = r10.isInitialized();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r2 != 0) goto L_0x00a5;
    L_0x0046:
        r2 = r10.afU;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2.block();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = r10.iM();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r10.afZ = r2;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = r10.afZ;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r9 = r2.getAudioSessionId();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = com.google.android.exoplayer2.a.f.afN;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r2 == 0) goto L_0x0082;
    L_0x005b:
        r2 = com.google.android.exoplayer2.i.t.SDK_INT;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r3 = 21;
        if (r2 >= r3) goto L_0x0082;
    L_0x0061:
        r2 = r10.afY;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r2 == 0) goto L_0x0070;
    L_0x0065:
        r2 = r10.afY;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = r2.getAudioSessionId();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r9 == r2) goto L_0x0070;
    L_0x006d:
        r10.iH();	 Catch:{ d -> 0x01c1, h -> 0x021e }
    L_0x0070:
        r2 = r10.afY;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r2 != 0) goto L_0x0082;
    L_0x0074:
        r2 = new android.media.AudioTrack;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r3 = 3;
        r4 = 4000; // 0xfa0 float:5.605E-42 double:1.9763E-320;
        r5 = 4;
        r6 = 2;
        r7 = 2;
        r8 = 0;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r10.afY = r2;	 Catch:{ d -> 0x01c1, h -> 0x021e }
    L_0x0082:
        r2 = r10.aeR;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r2 == r9) goto L_0x008d;
    L_0x0086:
        r10.aeR = r9;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = r10.afT;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2.bW(r9);	 Catch:{ d -> 0x01c1, h -> 0x021e }
    L_0x008d:
        r2 = r10.afW;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r3 = r10.afZ;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r4 = r10.iL();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2.a(r3, r4);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r10.iG();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = 0;
        r10.agM = r2;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = r10.agK;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r2 == 0) goto L_0x00a5;
    L_0x00a2:
        r10.play();	 Catch:{ d -> 0x01c1, h -> 0x021e }
    L_0x00a5:
        r2 = r10.iL();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r2 == 0) goto L_0x00e5;
    L_0x00ab:
        r2 = r10.afZ;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = r2.getPlayState();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r3 = 2;
        if (r2 != r3) goto L_0x00d0;
    L_0x00b4:
        r2 = 0;
        r10.agM = r2;	 Catch:{ d -> 0x01c1, h -> 0x021e }
    L_0x00b7:
        r2 = 0;
    L_0x00b8:
        if (r2 == 0) goto L_0x0233;
    L_0x00ba:
        r2 = 0;
        r0 = r16;
        r1 = r18;
        r0.releaseOutputBuffer(r1, r2);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = r11.aqa;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r3 = r2.aia;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r3 = r3 + 1;
        r2.aia = r3;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = 1;
        goto L_0x0011;
    L_0x00cd:
        r2 = 0;
        goto L_0x003d;
    L_0x00d0:
        r2 = r10.afZ;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = r2.getPlayState();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r3 = 1;
        if (r2 != r3) goto L_0x00e5;
    L_0x00d9:
        r2 = r10.afW;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = r2.iN();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x00b7;
    L_0x00e5:
        r2 = r10.agM;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r3 = r10.iF();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r10.agM = r3;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r2 == 0) goto L_0x0111;
    L_0x00ef:
        r2 = r10.agM;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r2 != 0) goto L_0x0111;
    L_0x00f3:
        r2 = r10.afZ;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = r2.getPlayState();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r3 = 1;
        if (r2 == r3) goto L_0x0111;
    L_0x00fc:
        r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r4 = r10.agN;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r6 = r2 - r4;
        r2 = r10.afT;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r3 = r10.bufferSize;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r4 = r10.agd;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r4 = com.google.android.exoplayer2.b.j(r4);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2.d(r3, r4, r6);	 Catch:{ d -> 0x01c1, h -> 0x021e }
    L_0x0111:
        r2 = r10.agE;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r2 != 0) goto L_0x0182;
    L_0x0115:
        r2 = r17.hasRemaining();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r2 != 0) goto L_0x011d;
    L_0x011b:
        r2 = 1;
        goto L_0x00b8;
    L_0x011d:
        r2 = r10.agc;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r2 == 0) goto L_0x0134;
    L_0x0121:
        r2 = r10.agw;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r2 != 0) goto L_0x0134;
    L_0x0125:
        r2 = r10.agb;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r3 = 7;
        if (r2 == r3) goto L_0x012e;
    L_0x012a:
        r3 = 8;
        if (r2 != r3) goto L_0x019b;
    L_0x012e:
        r2 = com.google.android.exoplayer2.a.h.c(r17);	 Catch:{ d -> 0x01c1, h -> 0x021e }
    L_0x0132:
        r10.agw = r2;	 Catch:{ d -> 0x01c1, h -> 0x021e }
    L_0x0134:
        r2 = r10.age;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r2 == 0) goto L_0x0161;
    L_0x0138:
        r2 = r10.iE();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r2 == 0) goto L_0x00b7;
    L_0x013e:
        r9 = r10.afX;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = new com.google.android.exoplayer2.a.f$g;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r3 = r10.age;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r4 = 0;
        r0 = r20;
        r4 = java.lang.Math.max(r4, r0);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r6 = r10.iJ();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r6 = r10.v(r6);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r8 = 0;
        r2.<init>(r3, r4, r6, r8);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r9.add(r2);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = 0;
        r10.age = r2;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r10.iD();	 Catch:{ d -> 0x01c1, h -> 0x021e }
    L_0x0161:
        r2 = r10.agx;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r2 != 0) goto L_0x01c9;
    L_0x0165:
        r2 = 0;
        r0 = r20;
        r2 = java.lang.Math.max(r2, r0);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r10.agy = r2;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = 1;
        r10.agx = r2;	 Catch:{ d -> 0x01c1, h -> 0x021e }
    L_0x0172:
        r2 = r10.agc;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r2 == 0) goto L_0x0220;
    L_0x0176:
        r2 = r10.ags;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r4 = r10.agw;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r4 = (long) r4;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = r2 + r4;
        r10.ags = r2;	 Catch:{ d -> 0x01c1, h -> 0x021e }
    L_0x017e:
        r0 = r17;
        r10.agE = r0;	 Catch:{ d -> 0x01c1, h -> 0x021e }
    L_0x0182:
        r2 = r10.agc;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r2 == 0) goto L_0x022c;
    L_0x0186:
        r2 = r10.agE;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r0 = r20;
        r10.a(r2, r0);	 Catch:{ d -> 0x01c1, h -> 0x021e }
    L_0x018d:
        r2 = r10.agE;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = r2.hasRemaining();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        if (r2 != 0) goto L_0x00b7;
    L_0x0195:
        r2 = 0;
        r10.agE = r2;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = 1;
        goto L_0x00b8;
    L_0x019b:
        r3 = 5;
        if (r2 != r3) goto L_0x01a3;
    L_0x019e:
        r2 = com.google.android.exoplayer2.a.a.iy();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        goto L_0x0132;
    L_0x01a3:
        r3 = 6;
        if (r2 != r3) goto L_0x01ab;
    L_0x01a6:
        r2 = com.google.android.exoplayer2.a.a.a(r17);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        goto L_0x0132;
    L_0x01ab:
        r3 = new java.lang.IllegalStateException;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r4 = new java.lang.StringBuilder;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r5 = "Unexpected audio encoding: ";
        r4.<init>(r5);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = r4.append(r2);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = r2.toString();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r3.<init>(r2);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        throw r3;	 Catch:{ d -> 0x01c1, h -> 0x021e }
    L_0x01c1:
        r2 = move-exception;
    L_0x01c2:
        r3 = r11.index;
        r2 = com.google.android.exoplayer2.e.a(r2, r3);
        throw r2;
    L_0x01c9:
        r2 = r10.agy;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r4 = r10.iI();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r4 = r10.v(r4);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = r2 + r4;
        r4 = r10.agx;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r5 = 1;
        if (r4 != r5) goto L_0x0208;
    L_0x01d9:
        r4 = r2 - r20;
        r4 = java.lang.Math.abs(r4);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r6 = 200000; // 0x30d40 float:2.8026E-40 double:9.8813E-319;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x0208;
    L_0x01e6:
        r4 = new java.lang.StringBuilder;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r5 = "Discontinuity detected [expected ";
        r4.<init>(r5);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r4 = r4.append(r2);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r5 = ", got ";
        r4 = r4.append(r5);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r0 = r20;
        r4 = r4.append(r0);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r5 = "]";
        r4.append(r5);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r4 = 2;
        r10.agx = r4;	 Catch:{ d -> 0x01c1, h -> 0x021e }
    L_0x0208:
        r4 = r10.agx;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r5 = 2;
        if (r4 != r5) goto L_0x0172;
    L_0x020d:
        r4 = r10.agy;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = r20 - r2;
        r2 = r2 + r4;
        r10.agy = r2;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = 1;
        r10.agx = r2;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = r10.afT;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2.is();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        goto L_0x0172;
    L_0x021e:
        r2 = move-exception;
        goto L_0x01c2;
    L_0x0220:
        r2 = r10.agr;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r4 = r17.remaining();	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r4 = (long) r4;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        r2 = r2 + r4;
        r10.agr = r2;	 Catch:{ d -> 0x01c1, h -> 0x021e }
        goto L_0x017e;
    L_0x022c:
        r0 = r20;
        r10.t(r0);	 Catch:{ d -> 0x01c1, h -> 0x021e }
        goto L_0x018d;
    L_0x0233:
        r2 = 0;
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.i.a(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, long, boolean):boolean");
    }

    protected final void iW() {
        try {
            f fVar = this.ahm;
            if (!fVar.agJ && fVar.isInitialized() && fVar.iE()) {
                fVar.afW.x(fVar.iJ());
                fVar.agi = 0;
                fVar.agJ = true;
            }
        } catch (Exception e) {
            throw e.a(e, this.index);
        }
    }

    public final void c(int i, Object obj) {
        f fVar;
        switch (i) {
            case 2:
                fVar = this.ahm;
                float floatValue = ((Float) obj).floatValue();
                if (fVar.agB != floatValue) {
                    fVar.agB = floatValue;
                    fVar.iG();
                    return;
                }
                return;
            case 3:
                b bVar = (b) obj;
                fVar = this.ahm;
                if (!fVar.aeS.equals(bVar)) {
                    fVar.aeS = bVar;
                    if (!fVar.agL) {
                        fVar.reset();
                        fVar.aeR = 0;
                        return;
                    }
                    return;
                }
                return;
            default:
                super.c(i, obj);
                return;
        }
    }
}
