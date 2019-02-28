package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Process;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class h implements com.tencent.mm.plugin.mmsight.segment.e.a {
    private static int oDN = -1;
    long aBM = -1;
    int fGt;
    private Object lock = new byte[0];
    Thread oCB;
    String oCr;
    long oCs = -1;
    int oCu = -1;
    private int oDB;
    private int oDC;
    private int oDD;
    private int oDE;
    private int oDF;
    private int oDG;
    a oDH;
    private int oDI = 0;
    MediaExtractor oDJ;
    int oDK;
    e oDL;
    private boolean oDM = false;
    private MediaFormat oDO;
    VideoTransPara oDs;
    private int ozx;
    private int ozy;

    private class a implements Runnable {
        int oAM;
        volatile int oAZ;
        Object oBg;
        boolean oCC;

        private a() {
            this.oBg = new Object();
        }

        /* synthetic */ a(h hVar, byte b) {
            this();
        }

        public final void run() {
            if (this.oAM == -1) {
                this.oAM = Process.myTid();
                Process.setThreadPriority(Process.myTid(), -2);
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "encodeTid: %s", Integer.valueOf(this.oAM));
            }
            this.oAZ = 0;
            synchronized (this.oBg) {
                long Wz;
                while (!this.oCC) {
                    Wz = bi.Wz();
                    x.i("MicroMsg.MediaCodecFFMpegTranscoder", "try trigger encode");
                    int triggerEncodeForSegment = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.oAZ), false);
                    x.i("MicroMsg.MediaCodecFFMpegTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", Long.valueOf(bi.bB(Wz)), Integer.valueOf(this.oAZ), Integer.valueOf(triggerEncodeForSegment), Long.valueOf(Thread.currentThread().getId()));
                    if (triggerEncodeForSegment == this.oAZ) {
                        try {
                            Thread.sleep(20);
                        } catch (Exception e) {
                            x.e("MicroMsg.MediaCodecFFMpegTranscoder", "thread sleep error");
                        }
                    }
                    this.oAZ = triggerEncodeForSegment;
                }
                Wz = bi.Wz();
                this.oAZ = MP4MuxerJNI.triggerEncodeForSegment(this.oAZ, true);
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", Long.valueOf(bi.bB(Wz)), Integer.valueOf(this.oAZ), Long.valueOf(Thread.currentThread().getId()));
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int bbP() {
        /*
        r6 = 21;
        r5 = 3;
        r4 = 2;
        r3 = -1;
        r2 = 1;
        r0 = com.tencent.mm.plugin.mmsight.model.CaptureMMProxy.getInstance();
        r1 = com.tencent.mm.storage.w.a.USERINFO_LOCAL_SIGHT_FFMMPEGCUT_INT_SYNC;
        r0 = r0.getInt(r1, r3);
        if (r0 == r3) goto L_0x002a;
    L_0x0012:
        if (r0 != r2) goto L_0x0022;
    L_0x0014:
        r0 = com.tencent.mm.compatible.util.d.fN(r6);
        if (r0 == 0) goto L_0x001f;
    L_0x001a:
        oDN = r4;
    L_0x001c:
        r0 = oDN;
    L_0x001e:
        return r0;
    L_0x001f:
        oDN = r2;
        goto L_0x001c;
    L_0x0022:
        if (r0 != r4) goto L_0x0027;
    L_0x0024:
        oDN = r2;
        goto L_0x001c;
    L_0x0027:
        oDN = r5;
        goto L_0x001c;
    L_0x002a:
        r0 = oDN;
        if (r0 == r3) goto L_0x0031;
    L_0x002e:
        r0 = oDN;
        goto L_0x001e;
    L_0x0031:
        r0 = com.tencent.mm.compatible.e.q.gHM;
        r0 = r0.gHY;
        if (r0 == r3) goto L_0x0051;
    L_0x0037:
        if (r0 != r2) goto L_0x003e;
    L_0x0039:
        oDN = r2;
    L_0x003b:
        r0 = oDN;
        goto L_0x001e;
    L_0x003e:
        if (r0 != r4) goto L_0x004c;
    L_0x0040:
        r0 = com.tencent.mm.compatible.util.d.fN(r6);
        if (r0 == 0) goto L_0x0049;
    L_0x0046:
        oDN = r4;
        goto L_0x003b;
    L_0x0049:
        oDN = r2;
        goto L_0x003b;
    L_0x004c:
        if (r0 != r5) goto L_0x003b;
    L_0x004e:
        oDN = r5;
        goto L_0x003b;
    L_0x0051:
        r0 = com.tencent.mm.plugin.mmsight.model.CaptureMMProxy.getInstance();
        r1 = "SightSegCutMinApiLevel";
        r0 = r0.getDynamicConfig(r1);
        r0 = com.tencent.mm.sdk.platformtools.bi.getInt(r0, r6);
        r0 = com.tencent.mm.compatible.util.d.fN(r0);
        if (r0 == 0) goto L_0x004e;
    L_0x0066:
        oDN = r2;
        goto L_0x003b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.segment.h.bbP():int");
    }

    public final int e(MediaFormat mediaFormat) {
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "initDecoder, format: %s, filePath: %s", mediaFormat, this.oCr);
        this.oDO = mediaFormat;
        int bbP = bbP();
        if (bbP == 1) {
            this.oDL = new i(this.oDJ, mediaFormat, this.oDK);
            this.oDM = false;
        } else if (bbP == 2) {
            this.oDL = new j(this.oDJ, mediaFormat, this.oDK);
            this.oDM = false;
        } else {
            this.oDL = new b();
            this.oDM = true;
        }
        if (this.oDL == null) {
            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "use default config");
            this.oDL = new i(this.oDJ, mediaFormat, this.oDK);
            this.oDM = false;
        }
        bbP = this.oDL.r(this.oCr, this.aBM, this.oCs);
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "init decoder ret: %s", Integer.valueOf(bbP));
        if (bbP < 0 && (oDN == 1 || oDN == 2)) {
            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "init mediaCodecDecoder failed, try ffmepg");
            try {
                this.oDL.stop();
                this.oDL = null;
            } catch (Exception e) {
            }
            this.oDL = new b();
            this.oDM = true;
            oDN = 3;
            bbP = this.oDL.r(this.oCr, this.aBM, this.oCs);
        }
        this.oDL.a(this);
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "init finish, ret: %d, decoderType: %d", Integer.valueOf(bbP), Integer.valueOf(oDN));
        return bbP;
    }

    public final void cS(int i, int i2) {
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "registerDesiredSize: %s, %s", Integer.valueOf(i), Integer.valueOf(i2));
        this.oDB = i;
        this.oDC = i2;
    }

    private static Point n(int i, int i2, int i3, int i4) {
        x.d("MicroMsg.MediaCodecFFMpegTranscoder", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i3 + "], specHeight = [" + i4 + "]");
        if (i > i3 || i2 > i4) {
            int max = Math.max(i, i2);
            int min = Math.min(i, i2);
            int max2 = Math.max(i3, i4);
            int min2 = Math.min(i3, i4);
            int i5;
            if (max % 16 == 0 && Math.abs(max - max2) < 16 && min % 16 == 0 && Math.abs(min - min2) < 16) {
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, same len divide by 16, no need scale");
                return null;
            } else if (max / 2 == max2 && min / 2 == min2) {
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio");
                i5 = i / 2;
                max = i2 / 2;
                if (i5 % 2 != 0) {
                    i5++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                return new Point(i5, max);
            } else {
                i5 = max / 2;
                max = min / 2;
                if (i5 % 16 != 0 || Math.abs(i5 - max2) >= 16 || max % 16 != 0 || Math.abs(max - min2) >= 16) {
                    Point point = new Point();
                    if (i < i2) {
                        max = Math.min(i3, i4);
                        i5 = (int) (((double) i2) / ((((double) i) * 1.0d) / ((double) max)));
                    } else {
                        i5 = Math.min(i3, i4);
                        max = (int) (((double) i) / ((((double) i2) * 1.0d) / ((double) i5)));
                    }
                    if (i5 % 2 != 0) {
                        i5++;
                    }
                    if (max % 2 != 0) {
                        max++;
                    }
                    x.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, outputsize: %s %s", Integer.valueOf(max), Integer.valueOf(i5));
                    point.x = max;
                    point.y = i5;
                    return point;
                }
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio divide by 16");
                i5 = i / 2;
                max = i2 / 2;
                if (i5 % 2 != 0) {
                    i5++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                return new Point(i5, max);
            }
        }
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, small or equal to spec size");
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void release() {
        /*
        r7 = this;
        r2 = 1;
        r6 = -1;
        r5 = 0;
        r0 = "MicroMsg.MediaCodecFFMpegTranscoder";
        r1 = "release, decoderType: %d";
        r2 = new java.lang.Object[r2];
        r3 = oDN;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r5] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        r0 = r7.oDL;	 Catch:{ Exception -> 0x0025 }
        if (r0 == 0) goto L_0x001f;
    L_0x001a:
        r0 = r7.oDL;	 Catch:{ Exception -> 0x0025 }
        r0.stop();	 Catch:{ Exception -> 0x0025 }
    L_0x001f:
        com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI.releaseDataBuf(r5);
        oDN = r6;
    L_0x0024:
        return;
    L_0x0025:
        r0 = move-exception;
        r1 = "MicroMsg.MediaCodecFFMpegTranscoder";
        r2 = "release error: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x003f }
        r4 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x003f }
        r3[r4] = r0;	 Catch:{ all -> 0x003f }
        com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);	 Catch:{ all -> 0x003f }
        com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI.releaseDataBuf(r5);
        oDN = r6;
        goto L_0x0024;
    L_0x003f:
        r0 = move-exception;
        com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI.releaseDataBuf(r5);
        oDN = r6;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.segment.h.release():void");
    }

    public final void aC(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "onYuvDataImp error data is null!!");
            return;
        }
        Point n;
        Point bbB = this.oDL.bbB();
        this.ozx = bbB.x;
        this.ozy = bbB.y;
        if (this.oDG <= 0 || this.oDF <= 0) {
            n = n(this.ozx, this.ozy, this.oDB, this.oDC);
            if (n != null) {
                this.oDF = n.x;
                this.oDG = n.y;
            } else {
                this.oDF = this.ozx;
                this.oDG = this.ozy;
            }
            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", Integer.valueOf(this.oDF), Integer.valueOf(this.oDG), Integer.valueOf(this.ozx), Integer.valueOf(this.ozy));
        }
        long Wz = bi.Wz();
        int i = 0;
        int i2 = 0;
        if (this.oDO != null) {
            i = this.oDO.getInteger("width");
            i2 = this.oDO.getInteger("height");
            if (this.oDD <= 0 || this.oDE <= 0) {
                boolean z;
                n = n(i, i2, this.oDB, this.oDC);
                if (n != null) {
                    this.oDD = n.x;
                    this.oDE = n.y;
                    z = true;
                } else {
                    if (Math.abs(i2 - bbB.y) <= 0 || i != bbB.x) {
                        this.oDD = bbB.x;
                        this.oDE = bbB.y;
                    } else {
                        this.oDD = i;
                        this.oDE = i2;
                    }
                    z = false;
                }
                if (z) {
                    this.oDF = this.oDD;
                    this.oDG = this.oDE;
                }
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", Integer.valueOf(this.oDD), Integer.valueOf(this.oDE), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
            }
        }
        this.oDI = this.oDL.bbE();
        int writeYuvDataForSegment = MP4MuxerJNI.writeYuvDataForSegment(bArr, bbB.x, bbB.y, this.oDF, this.oDG, this.oDI, i, i2);
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment used %sms", Long.valueOf(bi.bB(Wz)));
        if (writeYuvDataForSegment < 0) {
            x.e("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment error: %s", Integer.valueOf(writeYuvDataForSegment));
        }
        if (this.oDH == null) {
            MP4MuxerJNI.initH264Encoder(this.oDD, this.oDE, (float) this.oDs.fps, this.oDs.videoBitrate, this.oDs.hvQ, 8, this.oDs.hvP, 23.0f);
            this.oDH = new a();
            this.oCB = e.b(this.oDH, "MediaCodecFFMpegTranscoder_Encoder");
            this.oCB.start();
            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "initAndStartEncoder");
        }
    }
}
