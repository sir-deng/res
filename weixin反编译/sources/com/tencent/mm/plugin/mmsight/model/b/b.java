package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.api.a;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public final class b extends a {
    private int aef;
    private String filePath;
    private int mDe = -1;
    private c oBU;
    private String oBW;
    private int oBX;
    private int oBY;
    private int oBZ;
    private int oCa;
    private int oCb;
    private int oCc;
    private long oCd = -1;
    private long oCe = -1;
    private int oCf = -1;
    private int oCg;
    private Point oCh = null;
    private Bitmap oCk;
    private byte[] oCl = null;
    private byte[] oCm = null;
    private e oCo;
    private MediaExtractor ovr;
    private int ozQ;
    private int videoFps;

    public b(String str, String str2, int i, int i2, int i3, int i4) {
        if (bi.oN(str) || bi.oN(str2) || i <= 0 || i2 <= 0) {
            x.e("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4));
            return;
        }
        this.filePath = str;
        this.oBW = str2;
        this.oBZ = i;
        this.oCa = i2;
        this.oCb = i3;
        this.oCf = i4;
        this.oCc = SightVideoJNI.getMp4Rotate(str);
        com.tencent.mm.plugin.sight.base.a JX = d.JX(str);
        if (JX != null) {
            this.oBX = JX.width;
            this.oBY = JX.height;
            this.mDe = JX.mDe;
            this.videoFps = JX.oBL;
        }
        this.oCd = 0;
        this.oCe = (long) this.mDe;
        x.i("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegX264Remuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s", str, str2, Integer.valueOf(this.oBX), Integer.valueOf(this.oBY), Integer.valueOf(this.oCc), Integer.valueOf(i), Integer.valueOf(i2));
    }

    public b(String str, String str2, int i, int i2, int i3, int i4, long j, long j2) {
        if (bi.oN(str) || bi.oN(str2) || i <= 0 || i2 <= 0) {
            x.e("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegMediaCodecRemuxer error, filePath: %s, outputFilePath: %s, outputWidth: %s, outputHeight: %s, outputFps: %s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4));
            return;
        }
        this.filePath = str;
        this.oBW = str2;
        this.oBZ = i;
        this.oCa = i2;
        this.oCb = i3;
        this.oCf = i4;
        this.oCc = SightVideoJNI.getMp4Rotate(str);
        com.tencent.mm.plugin.sight.base.a JX = d.JX(str);
        if (JX != null) {
            this.oBX = JX.width;
            this.oBY = JX.height;
            this.videoFps = JX.oBL;
        }
        this.oCd = j;
        this.oCe = j2;
        x.i("MicroMsg.MMSightFFMpegX264Remuxer", "create MMSightFFMpegX264Remuxer, filePath: %s, outputFilePath: %s, inputWidth: %s, inputHeight: %s, videoRotate: %s, outputWidth: %s, outputHeight: %s, startTimeMs: %s, endTimeMs: %s", str, str2, Integer.valueOf(this.oBX), Integer.valueOf(this.oBY), Integer.valueOf(this.oCc), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
    }

    public final void z(Bitmap bitmap) {
        if (bitmap != null) {
            this.oCk = bitmap;
        }
    }

    public final int baw() {
        int round = Math.round(((float) this.mDe) / 1000.0f);
        if (this.oCd >= 0 && this.oCe >= 0) {
            round = Math.round(((float) (this.oCe - this.oCd)) / 1000.0f) + 1;
        }
        this.ozQ = MP4MuxerJNI.initDataBuf(round);
        this.oBU = new c();
        if (this.mDe > 0) {
            round = this.oBU.c(this.filePath, 0, (long) this.mDe, this.videoFps);
        } else if (this.oCd < 0 || this.oCe < 0) {
            x.e("MicroMsg.MMSightFFMpegX264Remuxer", "remux time error, videoDuration: %s, remuxStartTime: %s, remuxEndTime: %s", Integer.valueOf(this.mDe), Long.valueOf(this.oCd), Long.valueOf(this.oCe));
            MP4MuxerJNI.releaseDataBuf(this.ozQ);
            return -1;
        } else {
            round = this.oBU.c(this.filePath, this.oCd, this.oCe, this.videoFps);
        }
        x.i("MicroMsg.MMSightFFMpegX264Remuxer", "decoder init ret: %s", Integer.valueOf(round));
        if (round < 0) {
            MP4MuxerJNI.releaseDataBuf(this.ozQ);
            return -1;
        }
        if (this.oCf > 0 && this.oCf < this.videoFps) {
            this.oBU.oCv = (double) ((int) Math.ceil((double) (((float) this.videoFps) / ((float) this.oCf))));
        }
        int min = this.oCf > 0 ? Math.min(this.oCf, this.videoFps) : this.videoFps;
        this.oBU.oCq = new c.a() {
            public final void a(byte[] bArr, boolean z, long j) {
                if (b.this.oCh == null) {
                    b.this.oCh = c.bbB();
                }
                if (b.this.oCk != null) {
                    if (b.this.oCm == null) {
                        if (b.this.oCc == 90 || b.this.oCc == 270) {
                            b.this.oCk = com.tencent.mm.sdk.platformtools.d.b(b.this.oCk, (float) (360 - b.this.oCc));
                        }
                        b.this.oCk = Bitmap.createScaledBitmap(b.this.oCk, b.this.oCh.x, b.this.oCh.y, true);
                        Buffer allocateDirect = ByteBuffer.allocateDirect(b.this.oCk.getRowBytes() * b.this.oCk.getHeight());
                        allocateDirect.position(0);
                        b.this.oCk.copyPixelsToBuffer(allocateDirect);
                        b.this.oCm = allocateDirect.array();
                    }
                    SightVideoJNI.blendYuvFrame(bArr, b.this.oCm, b.this.oCh.x, b.this.oCh.y);
                }
                if (b.this.oCo != null) {
                    e e = b.this.oCo;
                    int i = b.this.oCh.x;
                    int i2 = b.this.oCh.y;
                    if (bArr != null) {
                        boolean z2 = (i == e.nZY && i2 == e.mBg) ? false : true;
                        x.d("MicroMsg.MMSightRemuxX264Encoder", "writeData, needScale: %s, srcSize: [%s, %s], targetSize: [%s, %s], pts: %s", Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(e.nZY), Integer.valueOf(e.mBg), Long.valueOf(j));
                        MP4MuxerJNI.writeYuvDataForSegment(bArr, i, i2, e.nZY, e.mBg, 2, e.iqY, e.iqZ);
                        e.frameCount++;
                    }
                }
                j.oAr.D(bArr);
                if (z && b.this.oCo != null) {
                    e e2 = b.this.oCo;
                    if (e2.oCA != null) {
                        e2.oCA.oCC = true;
                    }
                }
            }
        };
        this.oCo = new e(this.oBX, this.oBY, this.oBZ, this.oCa, this.oCb, min, com.tencent.mm.plugin.sight.base.b.qza);
        e eVar = this.oCo;
        eVar.frameCount = 0;
        MP4MuxerJNI.initH264Encoder(eVar.nZY, eVar.mBg, (float) eVar.oBL, eVar.bitrate, eVar.hvQ, 8, eVar.hvP, 23.0f);
        eVar.oCA = new a(eVar, (byte) 0);
        eVar.oCB = e.b(eVar.oCA, "MediaCodecFFMpegTranscoder_Encoder");
        eVar.oCB.start();
        eVar.fBn = false;
        x.i("MicroMsg.MMSightRemuxX264Encoder", "initAndStartEncoder");
        this.oBU.bbA();
        e eVar2 = this.oCo;
        if (!(eVar2.oCA == null || eVar2.oCB == null)) {
            eVar2.oCA.oCC = true;
            try {
                eVar2.oCB.join();
                e.remove(eVar2.oCA);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMSightRemuxX264Encoder", e, "waitEncoderFinish, join error: %s", e.getMessage());
            }
        }
        try {
            long j;
            this.ovr = new MediaExtractor();
            try {
                MediaFormat trackFormat;
                String str;
                int i;
                this.ovr.setDataSource(this.filePath);
                String str2 = null;
                int i2 = 0;
                while (i2 < this.ovr.getTrackCount()) {
                    trackFormat = this.ovr.getTrackFormat(i2);
                    String string = trackFormat.getString("mime");
                    if (string.startsWith("audio/")) {
                        str = string;
                        i = i2;
                        break;
                    }
                    i2++;
                    str2 = string;
                }
                i = -1;
                String str3 = str2;
                trackFormat = null;
                str = str3;
                if (i >= 0 && trackFormat != null && !bi.oN(str)) {
                    this.aef = trackFormat.getInteger("channel-count");
                    this.oCg = trackFormat.getInteger("sample-rate");
                    this.ovr.selectTrack(i);
                    if (this.oCd > 0) {
                        this.ovr.seekTo(this.oCd * 1000, 0);
                    }
                    ByteBuffer allocateDirect = ByteBuffer.allocateDirect(trackFormat.getInteger("max-input-size"));
                    while (true) {
                        allocateDirect.clear();
                        int readSampleData = this.ovr.readSampleData(allocateDirect, 0);
                        x.d("MicroMsg.MMSightFFMpegX264Remuxer", "sampleSize: %d", Integer.valueOf(readSampleData));
                        if (readSampleData <= 0) {
                            x.i("MicroMsg.MMSightFFMpegX264Remuxer", "muxAudio size = %d. Saw eos.", Integer.valueOf(readSampleData));
                            break;
                        } else if (this.ovr.getSampleTime() >= this.oCe * 1000) {
                            break;
                        } else if (this.ovr.getSampleTrackIndex() != i) {
                            x.e("MicroMsg.MMSightFFMpegX264Remuxer", "track index not match! break");
                            break;
                        } else {
                            allocateDirect.position(0);
                            MP4MuxerJNI.writeAACData(this.ozQ, allocateDirect, readSampleData);
                            this.ovr.advance();
                        }
                    }
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MMSightFFMpegX264Remuxer", e2, "muxAudio create extractor failed: %s", e2.getMessage());
            }
            String str4 = this.oBW;
            if (this.oCc > 0) {
                str4 = str4 + "tempRotate.mp4";
            }
            long j2 = (long) this.mDe;
            if (j2 <= 0) {
                j = this.oCe - this.oCd;
            } else {
                j = j2;
            }
            x.i("MicroMsg.MMSightFFMpegX264Remuxer", "muxing ret: %s", Integer.valueOf(MP4MuxerJNI.muxingForX264(this.oCg, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, this.aef, str4, (((float) this.oCo.frameCount) * 1000.0f) / ((float) j), (int) j, null, 0)));
            if (this.oCc > 0) {
                SightVideoJNI.tagRotateVideo(str4, this.oBW, this.oCc);
                FileOp.deleteFile(str4);
            }
            MP4MuxerJNI.releaseDataBuf(this.ozQ);
            j.oAr.Ez();
            return round;
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.MMSightFFMpegX264Remuxer", e22, "decode error: %s", e22.getMessage());
            return -1;
        }
    }

    public final int getType() {
        return 3;
    }
}
