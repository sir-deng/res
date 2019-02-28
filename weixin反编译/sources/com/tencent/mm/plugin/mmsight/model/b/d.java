package com.tencent.mm.plugin.mmsight.model.b;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

public final class d {
    private ByteBuffer[] agD;
    private ByteBuffer[] apM;
    private int bitrate = 0;
    boolean fBn = false;
    private boolean fkw = false;
    int frameCount;
    private int iqY;
    private int iqZ;
    int mBg;
    int nZY;
    protected MediaFormat oBG;
    private int oBH = -1;
    private BufferInfo oBI;
    private boolean oBJ = false;
    private int oBK;
    private int oBL;
    a oCw;
    int oCx;
    byte[] oCy;
    int oCz;
    protected int ozQ = -1;
    protected MediaCodec ozR;
    private int ozZ = -1;
    int ozz;

    public interface a {
        void a(int i, ByteBuffer byteBuffer, int i2);
    }

    public d(int i, int i2, int i3, int i4, int i5, int i6) {
        this.iqY = i;
        this.iqZ = i2;
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, init targetWidth: %d, targetHeight: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.nZY = i3;
        this.mBg = i4;
        this.oBL = i6;
        this.oBK = 1;
        this.oBI = new BufferInfo();
        this.bitrate = i5;
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "create MMSightRemuxMediaCodecEncoder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s", Integer.valueOf(this.iqY), Integer.valueOf(this.iqZ), Integer.valueOf(this.nZY), Integer.valueOf(this.mBg), Integer.valueOf(i5));
    }

    public final int tj(int i) {
        try {
            this.ozQ = i;
            return bbx();
        } catch (Exception e) {
            x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "init error: %s, try to re-init again", e.getMessage());
            try {
                return bbx();
            } catch (Exception e2) {
                x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "re-init again error: %s", e2.getMessage());
                k.baO();
                return -1;
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
            x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "Unable to find an appropriate codec for video/avc");
            k.baO();
            return -1;
        }
        long bB;
        CodecCapabilities capabilitiesForType;
        CodecProfileLevel[] codecProfileLevelArr;
        CodecProfileLevel codecProfileLevel;
        int i3;
        int i4;
        Object obj;
        EncoderCapabilities encoderCapabilities;
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found codec: %s, used %sms", mediaCodecInfo.getName(), Long.valueOf(bi.bB(Wz)));
        Wz = bi.Wz();
        i2 = 0;
        long Wz2 = bi.Wz();
        CodecCapabilities capabilitiesForType2 = mediaCodecInfo.getCapabilitiesForType("video/avc");
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "getCapabilitiesForType used %sms", Long.valueOf(bi.bB(Wz2)));
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "color format length: %s", Integer.valueOf(capabilitiesForType2.colorFormats.length));
        for (int i5 : capabilitiesForType2.colorFormats) {
            Object obj2;
            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "capabilities colorFormat: %s", Integer.valueOf(i5));
            switch (i5) {
                case 19:
                case 21:
                case 2130706688:
                    obj2 = 1;
                    break;
                default:
                    obj2 = null;
                    break;
            }
            if (obj2 != null && i5 > i2) {
                if (i5 != 19) {
                    i2 = i5;
                } else {
                    x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i5));
                    this.ozz = i5;
                    bB = bi.bB(Wz);
                    x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found colorFormat: %s, used %sms", Integer.valueOf(this.ozz), Long.valueOf(bB));
                    if (this.ozz != 19) {
                        this.oCz = 2;
                    } else {
                        this.oCz = 1;
                    }
                    bB = bi.Wz();
                    this.oBG = MediaFormat.createVideoFormat("video/avc", this.nZY, this.mBg);
                    x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "createVideoFormat used %sms", Long.valueOf(bi.bB(bB)));
                    if (mediaCodecInfo != null) {
                        if (com.tencent.mm.compatible.util.d.fN(23)) {
                            try {
                                capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
                                if (capabilitiesForType != null) {
                                    codecProfileLevelArr = capabilitiesForType.profileLevels;
                                    if (codecProfileLevelArr != null) {
                                        codecProfileLevel = new CodecProfileLevel();
                                        codecProfileLevel.level = 0;
                                        codecProfileLevel.profile = 0;
                                        for (CodecProfileLevel codecProfileLevel2 : codecProfileLevelArr) {
                                            i3 = codecProfileLevel2.profile;
                                            i4 = codecProfileLevel2.level;
                                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "profile: %s, level: %s", Integer.valueOf(i3), Integer.valueOf(i4));
                                            switch (i3) {
                                                case 1:
                                                case 2:
                                                case 8:
                                                    obj = 1;
                                                    break;
                                                default:
                                                    obj = null;
                                                    break;
                                            }
                                            if (obj != null && i3 >= codecProfileLevel.profile && i4 >= codecProfileLevel.level) {
                                                codecProfileLevel.profile = i3;
                                                codecProfileLevel.level = i4;
                                            }
                                        }
                                        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "best profile: %s, level: %s", Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level));
                                        if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                                            this.oBG.setInteger("profile", codecProfileLevel.profile);
                                            this.oBG.setInteger("level", 256);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetProfile error: %s", e.getMessage());
                            }
                        }
                        try {
                            if (com.tencent.mm.compatible.util.d.fN(21)) {
                                capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
                                if (capabilitiesForType != null) {
                                    encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
                                    if (encoderCapabilities != null) {
                                        if (encoderCapabilities.isBitrateModeSupported(2)) {
                                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cbr bitrate mode");
                                            this.oBG.setInteger("bitrate-mode", 2);
                                        } else if (encoderCapabilities.isBitrateModeSupported(0)) {
                                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "both cbr and cq bitrate mode not support!");
                                        } else {
                                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cq bitrate mode");
                                            this.oBG.setInteger("bitrate-mode", 0);
                                        }
                                    }
                                }
                            }
                        } catch (Exception e2) {
                            x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "trySetBitRateMode error: %s", e2.getMessage());
                        }
                    }
                    this.oBG.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.bitrate);
                    this.oBG.setInteger("frame-rate", this.oBL);
                    this.oBG.setInteger("color-format", this.ozz);
                    this.oBG.setInteger("i-frame-interval", this.oBK);
                    x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "mediaFormat: %s", this.oBG);
                    this.ozR = MediaCodec.createByCodecName(mediaCodecInfo.getName());
                    this.ozR.configure(this.oBG, null, null, 1);
                    this.ozR.start();
                    return 0;
                }
            }
        }
        i5 = i2;
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "codec: %s, colorFormat: %s", mediaCodecInfo.getName(), Integer.valueOf(i5));
        this.ozz = i5;
        bB = bi.bB(Wz);
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "found colorFormat: %s, used %sms", Integer.valueOf(this.ozz), Long.valueOf(bB));
        if (this.ozz != 19) {
            this.oCz = 1;
        } else {
            this.oCz = 2;
        }
        bB = bi.Wz();
        this.oBG = MediaFormat.createVideoFormat("video/avc", this.nZY, this.mBg);
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "createVideoFormat used %sms", Long.valueOf(bi.bB(bB)));
        if (mediaCodecInfo != null) {
            if (com.tencent.mm.compatible.util.d.fN(23)) {
                capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
                if (capabilitiesForType != null) {
                    codecProfileLevelArr = capabilitiesForType.profileLevels;
                    if (codecProfileLevelArr != null) {
                        codecProfileLevel = new CodecProfileLevel();
                        codecProfileLevel.level = 0;
                        codecProfileLevel.profile = 0;
                        for (CodecProfileLevel codecProfileLevel22 : codecProfileLevelArr) {
                            i3 = codecProfileLevel22.profile;
                            i4 = codecProfileLevel22.level;
                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "profile: %s, level: %s", Integer.valueOf(i3), Integer.valueOf(i4));
                            switch (i3) {
                                case 1:
                                case 2:
                                case 8:
                                    obj = 1;
                                    break;
                                default:
                                    obj = null;
                                    break;
                            }
                            codecProfileLevel.profile = i3;
                            codecProfileLevel.level = i4;
                        }
                        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "best profile: %s, level: %s", Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level));
                        this.oBG.setInteger("profile", codecProfileLevel.profile);
                        this.oBG.setInteger("level", 256);
                    }
                }
            }
            if (com.tencent.mm.compatible.util.d.fN(21)) {
                capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
                if (capabilitiesForType != null) {
                    encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
                    if (encoderCapabilities != null) {
                        if (encoderCapabilities.isBitrateModeSupported(2)) {
                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cbr bitrate mode");
                            this.oBG.setInteger("bitrate-mode", 2);
                        } else if (encoderCapabilities.isBitrateModeSupported(0)) {
                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "both cbr and cq bitrate mode not support!");
                        } else {
                            x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "support cq bitrate mode");
                            this.oBG.setInteger("bitrate-mode", 0);
                        }
                    }
                }
            }
        }
        this.oBG.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.bitrate);
        this.oBG.setInteger("frame-rate", this.oBL);
        this.oBG.setInteger("color-format", this.ozz);
        this.oBG.setInteger("i-frame-interval", this.oBK);
        x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "mediaFormat: %s", this.oBG);
        this.ozR = MediaCodec.createByCodecName(mediaCodecInfo.getName());
        this.ozR.configure(this.oBG, null, null, 1);
        this.ozR.start();
        return 0;
    }

    public final void b(byte[] bArr, boolean z, long j) {
        try {
            if (!this.fBn) {
                x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData, not start!");
            } else if (this.ozR == null) {
                x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
            } else {
                long Wz = bi.Wz();
                this.apM = this.ozR.getInputBuffers();
                this.agD = this.ozR.getOutputBuffers();
                int i = 0;
                while (this.ozR != null) {
                    int dequeueInputBuffer = this.ozR.dequeueInputBuffer(600);
                    this.oBH = dequeueInputBuffer;
                    if (dequeueInputBuffer >= 0 || i >= 10) {
                        break;
                    }
                    x.i("MicroMsg.MMSightRemuxMediaCodecEncoder", "video no input available, drain first");
                    bby();
                    i++;
                }
                if (this.ozR == null) {
                    x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder is null");
                    return;
                }
                x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "inputBufferIndex: %s", Integer.valueOf(this.oBH));
                long Wz2 = bi.Wz();
                if (this.oBH < 0) {
                    x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "input buffer not available");
                } else if (!this.fBn || z || bArr == null) {
                    x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "end of stream");
                    this.oBJ = true;
                    this.ozR.queueInputBuffer(this.oBH, 0, 0, j, 4);
                    this.fkw = true;
                } else {
                    x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "presentationTime: " + j);
                    ByteBuffer byteBuffer = this.apM[this.oBH];
                    byteBuffer.clear();
                    byteBuffer.put(bArr);
                    byteBuffer.position(0);
                    this.ozR.queueInputBuffer(this.oBH, 0, bArr.length, j, 0);
                }
                bby();
                x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder used %sms %sms", Long.valueOf(bi.bB(Wz)), Long.valueOf(bi.bB(Wz2)));
            }
        } catch (Throwable e) {
            k.baP();
            x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "writeData error: %s", e.getMessage());
            x.printErrStackTrace("MicroMsg.MMSightRemuxMediaCodecEncoder", e, "", new Object[0]);
        }
    }

    private void bby() {
        this.ozZ = this.ozR.dequeueOutputBuffer(this.oBI, 600);
        x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "outputBufferIndex-->" + this.ozZ);
        while (true) {
            if (this.ozZ == -1) {
                x.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "no output from encoder available, break encoderEndStream %s", Boolean.valueOf(this.oBJ));
                if (!this.oBJ) {
                    return;
                }
            } else if (this.ozZ == -3) {
                this.agD = this.ozR.getOutputBuffers();
                x.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output buffers changed");
            } else if (this.ozZ == -2) {
                x.d("MicroMsg.MMSightRemuxMediaCodecEncoder", "encoder output format changed: " + this.ozR.getOutputFormat());
            } else if (this.ozZ < 0) {
                x.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "unexpected result from encoder.dequeueOutputBuffer: " + this.ozZ);
            } else {
                x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "perform encoding");
                ByteBuffer byteBuffer = this.agD[this.ozZ];
                if (byteBuffer == null) {
                    throw new RuntimeException("encoderOutputBuffer " + this.ozZ + " was null");
                }
                this.frameCount++;
                if ((this.oBI.flags & 2) != 0) {
                    x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", Integer.valueOf(this.oBI.size), Boolean.valueOf(false));
                }
                if (this.oBI.size != 0) {
                    byteBuffer.position(this.oBI.offset);
                    byteBuffer.limit(this.oBI.offset + this.oBI.size);
                    BufferInfo bufferInfo = this.oBI;
                    if (!(byteBuffer == null || bufferInfo == null || this.oCw == null)) {
                        this.oCw.a(this.ozQ, byteBuffer, bufferInfo.size);
                    }
                }
                this.ozR.releaseOutputBuffer(this.ozZ, false);
                if ((this.oBI.flags & 4) != 0) {
                    if (this.fkw) {
                        x.w("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder, frameCount: %s, writeFrameCount: %s", Integer.valueOf(this.frameCount), Integer.valueOf(this.oCx));
                        try {
                            this.ozR.stop();
                            this.ozR.release();
                            this.ozR = null;
                            this.fBn = false;
                            return;
                        } catch (Exception e) {
                            x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "do stop encoder error: %s", e.getMessage());
                            return;
                        }
                    }
                    x.e("MicroMsg.MMSightRemuxMediaCodecEncoder", "reached end of stream unexpectedly");
                    return;
                }
            }
            this.ozZ = this.ozR.dequeueOutputBuffer(this.oBI, 600);
            if (this.ozZ <= 0) {
                x.v("MicroMsg.MMSightRemuxMediaCodecEncoder", "get outputBufferIndex %d", Integer.valueOf(this.ozZ));
            }
            if (this.ozZ < 0 && !this.oBJ) {
                return;
            }
        }
    }
}
