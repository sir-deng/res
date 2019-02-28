package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@TargetApi(18)
public final class p extends a {
    private a oFi;
    private a oFj;
    private int ozQ;

    public final void a(String str, String str2, VideoTransPara videoTransPara) {
        super.a(str, str2, videoTransPara);
    }

    public final int z(long j, long j2) {
        m.tn(h.bbP());
        int z = super.z(j, j2);
        if (z == -1) {
            m.to(h.bbP());
        }
        return z;
    }

    protected final int a(MediaExtractor mediaExtractor, List<a> list, List<a> list2) {
        this.oFi = (a) list2.get(0);
        if (!(list == null || list.size() == 0)) {
            this.oFj = (a) list.get(0);
        }
        if (a(mediaExtractor, this.oCS <= 0 ? 1048576 : this.oCS, this.ozQ, this.oCM) != -1) {
            return 0;
        }
        x.e("VideoClipperAPI18", "transcodeAndMux error");
        release();
        return -1;
    }

    private int a(MediaExtractor mediaExtractor, int i, int i2, String str) {
        Throwable e;
        x.i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(88) ");
        h hVar = null;
        try {
            h hVar2 = new h();
            try {
                int i3;
                hVar2.aBM = this.oCQ;
                hVar2.oCs = this.oCR;
                VideoTransPara videoTransPara = this.oCU;
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "setVideoPara: %s", videoTransPara);
                hVar2.oDs = videoTransPara;
                if (this.oCV == 90 || this.oCV == 270) {
                    hVar2.cS(videoTransPara.height, videoTransPara.width);
                } else {
                    hVar2.cS(videoTransPara.width, videoTransPara.height);
                }
                hVar2.oCr = str;
                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "setSrcVideoRotate: %s", Integer.valueOf(this.oCV));
                hVar2.fGt = i3;
                x.i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(101) ");
                try {
                    x.i("VideoClipperAPI18", "VideoClipperAPI18.transcodeAndMux(118) ");
                    mediaExtractor.selectTrack(this.oFi.index);
                    mediaExtractor.seekTo(this.oCQ * 1000, 0);
                    try {
                        VideoTransPara videoTransPara2 = this.oCU;
                        this.ozQ = MP4MuxerJNI.initDataBuf(videoTransPara2.duration > 0 ? videoTransPara2.duration : 10);
                        long Wz = bi.Wz();
                        i3 = this.oFi.index;
                        hVar2.oDJ = mediaExtractor;
                        hVar2.oDK = i3;
                        if (hVar2.e(this.oFi.oBG) < 0) {
                            try {
                                MP4MuxerJNI.releaseDataBuf(this.ozQ);
                                mediaExtractor.release();
                                j.oAr.Ez();
                            } catch (Exception e2) {
                            }
                            throw new l("init decoder error");
                        }
                        long Wz2;
                        if (!bi.oN(hVar2.oCr)) {
                            String simpleMp4Info = SightVideoJNI.getSimpleMp4Info(hVar2.oCr);
                            x.i("MicroMsg.MediaCodecFFMpegTranscoder", "src file: %s", simpleMp4Info);
                            if (!bi.oN(simpleMp4Info)) {
                                try {
                                    int i4 = (int) new JSONObject(simpleMp4Info).getDouble("videoFPS");
                                    double d = (hVar2.oDs == null || hVar2.oDs.fps <= 0) ? 30.0d : (double) hVar2.oDs.fps;
                                    hVar2.oCu = (int) Math.ceil(((double) i4) / d);
                                    x.i("MicroMsg.MediaCodecFFMpegTranscoder", "frameDropInterval: %s, videoFPS: %s, targetFPS: %s", Integer.valueOf(hVar2.oCu), Integer.valueOf(i4), Double.valueOf(d));
                                } catch (Throwable e3) {
                                    x.printErrStackTrace("MicroMsg.MediaCodecFFMpegTranscoder", e3, "calcFrameDropCount error: %s", e3.getMessage());
                                }
                            }
                        }
                        hVar2.oDL.tk(hVar2.oCu);
                        hVar2.oDL.D(new Runnable() {
                            public final void run() {
                                h hVar = h.this;
                                x.i("MicroMsg.MediaCodecFFMpegTranscoder", "waitEncoderFinish: %s %s", hVar.oDH, hVar.oCB);
                                if (hVar.oDH != null && hVar.oCB != null) {
                                    hVar.oDH.oCC = true;
                                    try {
                                        hVar.oCB.join();
                                        e.remove(hVar.oDH);
                                    } catch (Throwable e) {
                                        x.printErrStackTrace("MicroMsg.MediaCodecFFMpegTranscoder", e, "waitEncoderFinish, join error: %s", e.getMessage());
                                    }
                                }
                            }
                        });
                        Wz = bi.bB(Wz);
                        mediaExtractor.unselectTrack(this.oFi.index);
                        boolean z = false;
                        if (this.oFj != null) {
                            long Wz3 = bi.Wz();
                            z = a(mediaExtractor, i, i2);
                            x.i("VideoClipperAPI18", "process audio used %sms, compressAudio: %s", Long.valueOf(bi.bB(Wz3)), Boolean.valueOf(z));
                        }
                        long Wz4 = bi.Wz();
                        String bbC = bbC();
                        x.i("VideoClipperAPI18", "process video used %sms", Long.valueOf(Wz));
                        x.i("VideoClipperAPI18", "start muxing, tempPath: %s", bbC);
                        m.B(h.bbP(), Wz);
                        int i5 = 1;
                        int i6 = videoTransPara2.audioSampleRate;
                        int i7 = videoTransPara2.hvN;
                        if (!z) {
                            try {
                                i5 = this.oFj.oBG.getInteger("channel-count");
                                i6 = this.oFj.oBG.getInteger("sample-rate");
                                i7 = i5;
                                int i8 = i6;
                                i6 = this.oFj.oBG.getInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE);
                                i3 = i8;
                            } catch (Exception e4) {
                                x.e("VideoClipperAPI18", "get audio channel count error: %s", e4.getMessage());
                            }
                            x.e("VideoClipperAPI18", "final muxing channel count: %s, aac sample rate: %s, aacBitRate: %s", Integer.valueOf(i7), Integer.valueOf(i3), Integer.valueOf(i6));
                            if (MP4MuxerJNI.muxingForX264(i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i7, bbC, (float) videoTransPara2.fps, (int) (this.oCR - this.oCQ), null, 0) >= 0) {
                                x.e("VideoClipperAPI18", "muxingForX264 failed! %d", Integer.valueOf(MP4MuxerJNI.muxingForX264(i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i7, bbC, (float) videoTransPara2.fps, (int) (this.oCR - this.oCQ), null, 0)));
                                throw new l("muxingForX264 failed!");
                            }
                            if (this.oCV <= 0) {
                                SightVideoJNI.tagRotateVideo(bbC(), this.oCL, this.oCV);
                            } else {
                                FileOp.at(bbC(), this.oCL);
                            }
                            x.i("VideoClipperAPI18", "mux and tagRotate used %sms", Long.valueOf(bi.bB(Wz4)));
                            Wz2 = bi.Wz();
                            SightVideoJNI.tagMP4Dscp(this.oCL, CaptureMMProxy.getInstance().getWeixinMeta());
                            x.i("VideoClipperAPI18", "tagMP4Dscp used %sms", Long.valueOf(bi.bB(Wz2)));
                            try {
                                MP4MuxerJNI.releaseDataBuf(this.ozQ);
                                mediaExtractor.release();
                                j.oAr.Ez();
                            } catch (Exception e5) {
                            }
                            try {
                                hVar2.release();
                            } catch (Exception e6) {
                            }
                            return 0;
                        }
                        i3 = i6;
                        i6 = i7;
                        i7 = i5;
                        x.e("VideoClipperAPI18", "final muxing channel count: %s, aac sample rate: %s, aacBitRate: %s", Integer.valueOf(i7), Integer.valueOf(i3), Integer.valueOf(i6));
                        if (MP4MuxerJNI.muxingForX264(i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i7, bbC, (float) videoTransPara2.fps, (int) (this.oCR - this.oCQ), null, 0) >= 0) {
                            if (this.oCV <= 0) {
                                FileOp.at(bbC(), this.oCL);
                            } else {
                                SightVideoJNI.tagRotateVideo(bbC(), this.oCL, this.oCV);
                            }
                            x.i("VideoClipperAPI18", "mux and tagRotate used %sms", Long.valueOf(bi.bB(Wz4)));
                            Wz2 = bi.Wz();
                            SightVideoJNI.tagMP4Dscp(this.oCL, CaptureMMProxy.getInstance().getWeixinMeta());
                            x.i("VideoClipperAPI18", "tagMP4Dscp used %sms", Long.valueOf(bi.bB(Wz2)));
                            MP4MuxerJNI.releaseDataBuf(this.ozQ);
                            mediaExtractor.release();
                            j.oAr.Ez();
                            hVar2.release();
                            return 0;
                        }
                        x.e("VideoClipperAPI18", "muxingForX264 failed! %d", Integer.valueOf(MP4MuxerJNI.muxingForX264(i3, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2, i7, bbC, (float) videoTransPara2.fps, (int) (this.oCR - this.oCQ), null, 0)));
                        throw new l("muxingForX264 failed!");
                    } catch (Throwable e32) {
                        x.w("VideoClipperAPI18", "The source video file is malformed %s", e32.getMessage());
                        throw new RuntimeException(e32);
                    } catch (Throwable th) {
                        try {
                            MP4MuxerJNI.releaseDataBuf(this.ozQ);
                            mediaExtractor.release();
                            j.oAr.Ez();
                        } catch (Exception e7) {
                        }
                    }
                } catch (Throwable e322) {
                    try {
                        x.printErrStackTrace("VideoClipperAPI18", e322, "Transcode and mux failed %s", e322.getMessage());
                        return -1;
                    } finally {
                        try {
                            hVar2.release();
                        } catch (Exception e8) {
                        }
                    }
                }
            } catch (Exception e9) {
                e322 = e9;
                hVar = hVar2;
            }
        } catch (Exception e10) {
            e322 = e10;
            x.printErrStackTrace("VideoClipperAPI18", e322, "trascodeAndMux error", new Object[0]);
            if (hVar != null) {
                hVar.release();
            }
            return -1;
        }
    }

    private boolean a(MediaExtractor mediaExtractor, int i, int i2) {
        if (this.oFj == null) {
            return false;
        }
        mediaExtractor.selectTrack(this.oFj.index);
        mediaExtractor.seekTo(this.oCQ * 1000, 0);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
        try {
            this.oFj.oBG.getInteger("channel-count");
        } catch (Exception e) {
            x.e("VideoClipperAPI18", "get channel count error: %s", Integer.valueOf(1));
        }
        x.i("VideoClipperAPI18", "audio channel count");
        if (CaptureMMProxy.getInstance().getInt(a.USERINFO_LOCAL_SIGHT_COMPRESS_TO_SINGLE_CHANNEL_INT_SYNC, 0) == 1) {
            g gVar = new g(mediaExtractor, this.oFj.oBG, this.oCQ, this.oCR, this.oCU);
            gVar.oDt = true;
            try {
                gVar.oDo = MediaCodec.createDecoderByType(gVar.ovp);
                gVar.oDo.configure(gVar.oDq, null, null, 0);
                gVar.oDo.start();
                gVar.oDq = gVar.oDo.getOutputFormat();
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e2, "init decoder error: %s", e2.getMessage());
            }
            try {
                gVar.oDr = new MediaFormat();
                gVar.oDr.setString("mime", "audio/mp4a-latm");
                gVar.oDr.setInteger("aac-profile", 2);
                gVar.oDr.setInteger("sample-rate", gVar.oDs.audioSampleRate);
                gVar.oDr.setInteger("channel-count", 1);
                gVar.oDr.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, gVar.oDs.hvN);
                gVar.oDr.setInteger("max-input-size", 16384);
                gVar.oDp = MediaCodec.createEncoderByType(gVar.ovp);
                gVar.oDp.configure(gVar.oDr, null, null, 1);
                gVar.oDo.start();
            } catch (Exception e3) {
                x.e("MicroMsg.MediaCodecAACTranscoder", "init encoder error: %s", e3.getMessage());
                gVar.oDt = false;
                gVar.oDu = new ArrayList();
                gVar.oDp.release();
                gVar.oDp = null;
            }
            x.i("MicroMsg.MediaCodecAACTranscoder", "init finish, canEncodeDecodeBothExist: %s", Boolean.valueOf(gVar.oDt));
            gVar.bbM();
            return true;
        }
        while (true) {
            allocateDirect.clear();
            int readSampleData = mediaExtractor.readSampleData(allocateDirect, 0);
            x.d("VideoClipperAPI18", "sampleSize: %d", Integer.valueOf(readSampleData));
            if (readSampleData <= 0) {
                x.i("VideoClipperAPI18", "VideoClipperAPI18.muxAudio size = %d. Saw eos.", Integer.valueOf(readSampleData));
                break;
            } else if (mediaExtractor.getSampleTime() >= this.oCR * 1000) {
                break;
            } else if (mediaExtractor.getSampleTrackIndex() != this.oFj.index) {
                x.e("VideoClipperAPI18", "track index not match! break");
                break;
            } else {
                allocateDirect.position(0);
                MP4MuxerJNI.writeAACData(i2, allocateDirect, readSampleData);
                mediaExtractor.advance();
            }
        }
        return false;
    }

    public final int FQ(String str) {
        Throwable th;
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                String extractMetadata;
                mediaMetadataRetriever.setDataSource(str);
                if (d.fN(17)) {
                    extractMetadata = mediaMetadataRetriever.extractMetadata(24);
                } else {
                    extractMetadata = SightVideoJNI.getMp4Rotate(str);
                }
                x.d("VideoClipperAPI18", "findRotationMessage sDegree = " + extractMetadata);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(18);
                x.d("VideoClipperAPI18", "findRotationMessage sHeight = " + extractMetadata2);
                x.d("VideoClipperAPI18", "findRotationMessage sWidth = " + extractMetadata3);
                int i = bi.getInt(extractMetadata, 0);
                mediaMetadataRetriever.release();
                return i;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
    }
}
