package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.f.a;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.nio.ByteBuffer;

@TargetApi(16)
public class r implements f {
    private ByteBuffer[] agD;
    private ByteBuffer[] apM;
    private int bitrate = 0;
    boolean fBn = false;
    boolean fkw = false;
    int frameCount;
    private long gLZ = 0;
    private int iqY;
    private int iqZ;
    int mBg;
    int nZY;
    private o oAd;
    int oBB = -1;
    int oBC = -1;
    int oBD = -1;
    int oBE = -1;
    a oBF = new a(this.oBN);
    protected MediaFormat oBG;
    private int oBH = -1;
    private BufferInfo oBI;
    private boolean oBJ = false;
    private int oBK;
    private int oBL;
    a oBM;
    private a.a oBN = new a.a() {
        public final void output(byte[] bArr) {
            long Wz = bi.Wz();
            boolean baW = r.this.oBF.baW();
            r rVar = r.this;
            boolean z = baW && r.this.fkw;
            rVar.d(bArr, z);
            j.oAr.D(bArr);
            x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "markStop: %s isEnd %s costTime %d", Boolean.valueOf(r.this.fkw), Boolean.valueOf(baW), Long.valueOf(bi.bB(Wz)));
            if (baW && r.this.fkw) {
                r.this.bbz();
            }
        }
    };
    boolean oyN = false;
    protected MediaCodec ozR;
    private int ozZ = -1;
    int ozz;
    long startTime = 0;

    public r(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        this.iqY = i;
        this.iqZ = i2;
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "create MMSightYUVMediaCodecRecorder, init targetWidth: %d, targetHeight: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "create MMSightYUVMediaCodecRecorder, after align 16, targetWidth: %d, targetHeight: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.nZY = i3;
        this.mBg = i4;
        this.oBL = i7;
        this.oBK = i6;
        this.oAd = null;
        this.oBI = new BufferInfo();
        this.bitrate = i5;
        this.oyN = z;
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "create BigSightMediaCodecYUVRecorder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s, needRotateEachFrame: %s, muxer: %s", Integer.valueOf(this.iqY), Integer.valueOf(this.iqZ), Integer.valueOf(this.nZY), Integer.valueOf(this.mBg), Integer.valueOf(i5), Boolean.valueOf(z), null);
    }

    public int cR(int i, int i2) {
        int i3 = -1;
        try {
            this.oBB = i2;
            return bbx();
        } catch (Exception e) {
            x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "init error: %s, try to re-init again", e.getMessage());
            try {
                if (CaptureMMProxy.getInstance() != null) {
                    CaptureMMProxy.getInstance().set(w.a.USERINFO_MMSIGHT_MEDIACODEC_COLORFORMAT_INT, Integer.valueOf(-1));
                }
                return bbx();
            } catch (Exception e2) {
                x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "re-init again error: %s", e2.getMessage());
                k.baO();
                return i3;
            }
        }
    }

    private int bbx() {
        int i;
        int i2;
        MediaCodecInfo mediaCodecInfo;
        long Wz = bi.Wz();
        String str = "video/avc";
        int codecCount = MediaCodecList.getCodecCount();
        loop0:
        for (i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        mediaCodecInfo = codecInfoAt;
                        break loop0;
                    }
                }
                continue;
            }
        }
        mediaCodecInfo = null;
        if (mediaCodecInfo == null) {
            x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "Unable to find an appropriate codec for video/avc");
            k.baO();
            return -1;
        }
        long Wz2;
        int i3;
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "found codec: %s, used %sms", mediaCodecInfo.getName(), Long.valueOf(bi.bB(Wz)));
        Wz = bi.Wz();
        if (CaptureMMProxy.getInstance() != null) {
            i2 = CaptureMMProxy.getInstance().getInt(w.a.USERINFO_MMSIGHT_MEDIACODEC_COLORFORMAT_INT, -1);
        } else {
            i2 = -1;
        }
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "saveColorFormat: %s", Integer.valueOf(i2));
        if (i2 <= 0) {
            Wz2 = bi.Wz();
            CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
            x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "getCapabilitiesForType used %sms", Long.valueOf(bi.bB(Wz2)));
            x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "color format length: %s", Integer.valueOf(capabilitiesForType.colorFormats.length));
            i2 = 0;
            for (int i4 : capabilitiesForType.colorFormats) {
                x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "capabilities colorFormat: %s", Integer.valueOf(i4));
                switch (i4) {
                    case 19:
                    case 21:
                    case 2130706688:
                        i = 1;
                        break;
                    default:
                        i = 0;
                        break;
                }
                if (i != 0 && (i4 > i2 || i4 == 21)) {
                    i2 = i4;
                }
            }
            x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i2));
        }
        this.ozz = i2;
        Wz2 = bi.bB(Wz);
        if (this.ozz > 0 && Wz2 > 200 && CaptureMMProxy.getInstance() != null) {
            CaptureMMProxy.getInstance().set(w.a.USERINFO_MMSIGHT_MEDIACODEC_COLORFORMAT_INT, Integer.valueOf(this.ozz));
        }
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "found colorFormat: %s, used %sms", Integer.valueOf(this.ozz), Long.valueOf(Wz2));
        Wz = bi.Wz();
        String str2;
        if (this.oyN) {
            str2 = "video/avc";
            i2 = (this.oBB == 180 || this.oBB == 0) ? this.nZY : this.mBg;
            i3 = (this.oBB == 180 || this.oBB == 0) ? this.mBg : this.nZY;
            this.oBG = MediaFormat.createVideoFormat(str2, i2, i3);
        } else {
            str2 = "video/avc";
            i2 = (this.oBB == 180 || this.oBB == 0) ? this.mBg : this.nZY;
            i3 = (this.oBB == 180 || this.oBB == 0) ? this.nZY : this.mBg;
            this.oBG = MediaFormat.createVideoFormat(str2, i2, i3);
        }
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "createVideoFormat used %sms", Long.valueOf(bi.bB(Wz)));
        if (mediaCodecInfo != null) {
            if (d.fN(23)) {
                try {
                    CodecCapabilities capabilitiesForType2 = mediaCodecInfo.getCapabilitiesForType("video/avc");
                    if (capabilitiesForType2 != null) {
                        CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType2.profileLevels;
                        if (codecProfileLevelArr != null) {
                            CodecProfileLevel codecProfileLevel = new CodecProfileLevel();
                            codecProfileLevel.level = 0;
                            codecProfileLevel.profile = 0;
                            for (CodecProfileLevel codecProfileLevel2 : codecProfileLevelArr) {
                                int i5 = codecProfileLevel2.profile;
                                int i6 = codecProfileLevel2.level;
                                x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "profile: %s, level: %s", Integer.valueOf(i5), Integer.valueOf(i6));
                                switch (i5) {
                                    case 1:
                                    case 2:
                                    case 8:
                                        i3 = 1;
                                        break;
                                    default:
                                        i3 = 0;
                                        break;
                                }
                                if (i3 != 0 && i5 >= codecProfileLevel.profile && i6 >= codecProfileLevel.level) {
                                    codecProfileLevel.profile = i5;
                                    codecProfileLevel.level = i6;
                                }
                            }
                            x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "best profile: %s, level: %s", Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level));
                            if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                                this.oBG.setInteger("profile", codecProfileLevel.profile);
                                this.oBG.setInteger("level", 256);
                            }
                        }
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "trySetProfile error: %s", e.getMessage());
                }
            }
            try {
                if (d.fN(21)) {
                    this.oBG.setInteger("bitrate-mode", 1);
                }
            } catch (Exception e2) {
                x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "trySetBitRateMode error: %s", e2.getMessage());
            }
        }
        this.oBG.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.bitrate);
        this.oBG.setInteger("frame-rate", this.oBL);
        this.oBG.setInteger("color-format", this.ozz);
        this.oBG.setInteger("i-frame-interval", this.oBK);
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "mediaFormat: %s", this.oBG);
        this.ozR = MediaCodec.createByCodecName(mediaCodecInfo.getName());
        this.ozR.configure(this.oBG, null, null, 1);
        this.ozR.start();
        return 0;
    }

    public final void d(byte[] bArr, boolean z) {
        try {
            if (!this.fBn) {
                x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData, not start!");
            } else if (this.ozR == null) {
                x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder is null");
            } else {
                if (this.oAd != null && this.oAd.oBz <= 0) {
                    this.oAd.oBz = System.nanoTime();
                }
                long Wz = bi.Wz();
                this.apM = this.ozR.getInputBuffers();
                this.agD = this.ozR.getOutputBuffers();
                int dequeueInputBuffer = this.ozR.dequeueInputBuffer(100);
                this.oBH = dequeueInputBuffer;
                if (dequeueInputBuffer < 0) {
                    x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "video no input available, drain first");
                    bby();
                }
                if (this.ozR == null) {
                    x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder is null");
                    return;
                }
                x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "inputBufferIndex: %s", Integer.valueOf(this.oBH));
                long Wz2 = bi.Wz();
                if (this.oBH >= 0) {
                    long nanoTime = ((System.nanoTime() - ((long) ((bArr.length / 1600000) / 1000000000))) - (this.oAd != null ? this.oAd.oBz : this.startTime)) / 1000;
                    x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "presentationTime: " + nanoTime);
                    ByteBuffer byteBuffer = this.apM[this.oBH];
                    byteBuffer.clear();
                    byteBuffer.put(bArr);
                    byteBuffer.position(0);
                    if (!this.fBn || z) {
                        x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "end of stream");
                        this.oBJ = true;
                        this.ozR.queueInputBuffer(this.oBH, 0, bArr.length, nanoTime, 4);
                    } else {
                        this.ozR.queueInputBuffer(this.oBH, 0, bArr.length, nanoTime, 0);
                    }
                } else {
                    x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "input buffer not available");
                }
                bby();
                x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder used %sms %sms", Long.valueOf(bi.bB(Wz)), Long.valueOf(bi.bB(Wz2)));
            }
        } catch (Throwable e) {
            k.baP();
            x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData error: %s", e.getMessage());
            x.printErrStackTrace("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", e, "", new Object[0]);
        }
    }

    private void bby() {
        this.ozZ = this.ozR.dequeueOutputBuffer(this.oBI, 100);
        x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "outputBufferIndex-->" + this.ozZ);
        while (true) {
            if (this.ozZ == -1) {
                x.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "no output from encoder available, break encoderEndStream %s", Boolean.valueOf(this.oBJ));
                if (!this.oBJ) {
                    return;
                }
            } else if (this.ozZ == -3) {
                this.agD = this.ozR.getOutputBuffers();
                x.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder output buffers changed");
            } else if (this.ozZ == -2) {
                MediaFormat outputFormat = this.ozR.getOutputFormat();
                x.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder output format changed: " + outputFormat);
                if (this.oAd != null) {
                    this.oAd.c(outputFormat);
                }
            } else if (this.ozZ < 0) {
                x.w("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + this.ozZ);
            } else {
                x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "perform encoding");
                ByteBuffer byteBuffer = this.agD[this.ozZ];
                if (byteBuffer == null) {
                    throw new RuntimeException("encoderOutputBuffer " + this.ozZ + " was null");
                }
                this.frameCount++;
                if ((this.oBI.flags & 2) != 0) {
                    x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", Integer.valueOf(this.oBI.size), Boolean.valueOf(false));
                }
                if (this.oBI.size != 0) {
                    if (!(this.oAd == null || this.oAd.fBn)) {
                        this.oAd.c(this.ozR.getOutputFormat());
                    }
                    byteBuffer.position(this.oBI.offset);
                    byteBuffer.limit(this.oBI.offset + this.oBI.size);
                    e(byteBuffer, this.oBI);
                }
                this.ozR.releaseOutputBuffer(this.ozZ, false);
                if ((this.oBI.flags & 4) != 0) {
                    if (this.fkw) {
                        x.w("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "do stop encoder");
                        try {
                            this.ozR.stop();
                            this.ozR.release();
                            this.oBF.stop();
                            this.ozR = null;
                            this.fBn = false;
                            if (this.oBM != null) {
                                this.oBM.bbo();
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "do stop encoder error: %s", e.getMessage());
                            return;
                        }
                    }
                    x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "reached end of stream unexpectedly");
                    return;
                }
            }
            this.ozZ = this.ozR.dequeueOutputBuffer(this.oBI, 100);
            if (this.ozZ <= 0) {
                x.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "get outputBufferIndex %d", Integer.valueOf(this.ozZ));
            }
            if (this.ozZ < 0 && !this.oBJ) {
                return;
            }
        }
    }

    protected void e(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.oAd != null && (bufferInfo.flags & 4) == 0) {
            this.oAd.g(byteBuffer, bufferInfo);
        }
    }

    public final void a(a aVar) {
        this.oBM = aVar;
        this.fkw = true;
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "!!!stop, isStart!!: %s %s isEnd %s", Boolean.valueOf(this.fBn), this.oBM, Boolean.valueOf(this.oBF.baW()));
        if (this.oBF.baW()) {
            bbz();
        }
    }

    final void bbz() {
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "stopImp %s", bi.chl().toString());
        try {
            if (this.fBn) {
                ah.h(new Runnable() {
                    public final void run() {
                        try {
                            if (r.this.ozR != null) {
                                x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "delay to stop encoder");
                                r.this.oBF.stop();
                                r.this.ozR.stop();
                                r.this.ozR.release();
                                r.this.ozR = null;
                                r.this.fBn = false;
                                if (r.this.oBM != null) {
                                    r.this.oBM.bbo();
                                }
                            }
                        } catch (Exception e) {
                            x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "delay to stop encoder error: %s", e.getMessage());
                        }
                    }
                }, 500);
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "stop error: %s", e.getMessage());
        }
    }

    public final long bbw() {
        return System.currentTimeMillis() - this.startTime;
    }

    public void clear() {
        x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "clear");
        try {
            if (this.ozR != null) {
                x.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "stop encoder");
                this.oBF.stop();
                this.ozR.stop();
                this.ozR.release();
                this.ozR = null;
                this.fBn = false;
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "clear error: %s", e.getMessage());
        }
    }
}
