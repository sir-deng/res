package com.tencent.mm.plugin.mmsight.model.b;

import android.graphics.Point;
import com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    private long aBM;
    private int frameCount = 0;
    private boolean hwv = false;
    a oCq;
    private String oCr;
    private long oCs;
    private byte[] oCt = null;
    private int oCu = 0;
    double oCv;
    private int videoFps;

    public interface a {
        void a(byte[] bArr, boolean z, long j);
    }

    public final int c(String str, long j, long j2, int i) {
        x.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s, videoFps: %s", str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i));
        this.oCr = str;
        this.aBM = j;
        this.oCs = j2;
        this.videoFps = i;
        this.oCv = 1000.0d / ((double) i);
        if (bi.oN(str)) {
            return -1;
        }
        long Wz = bi.Wz();
        int ffmpegOpenAndSeekFile = MP4MuxerJNI.ffmpegOpenAndSeekFile(str, ((double) j) * 1000.0d, ((double) j2) * 1000.0d);
        x.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", Long.valueOf(bi.bB(Wz)));
        return ffmpegOpenAndSeekFile;
    }

    public final void bbA() {
        x.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
        this.hwv = true;
        this.frameCount = 0;
        while (this.hwv) {
            long Wz = bi.Wz();
            this.oCt = MP4MuxerJNI.ffmpegGetNextVideoFrameData(this.oCt);
            x.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", Long.valueOf(bi.bB(Wz)));
            boolean ffmpegCheckIfReachEndTimestamp = MP4MuxerJNI.ffmpegCheckIfReachEndTimestamp();
            this.frameCount++;
            if (this.oCu <= 1 || this.frameCount % this.oCu != 0) {
                if (this.oCq != null) {
                    a aVar = this.oCq;
                    byte[] bArr = this.oCt;
                    boolean z = this.oCt == null || ffmpegCheckIfReachEndTimestamp;
                    aVar.a(bArr, z, (long) ((((double) this.frameCount) * this.oCv) * 1000.0d));
                }
                if (this.oCt == null || ffmpegCheckIfReachEndTimestamp) {
                    x.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", Boolean.valueOf(ffmpegCheckIfReachEndTimestamp));
                    x.i("MicroMsg.FFMpegTranscodeDecoder", "decode finish, frame count: %s", Integer.valueOf(this.frameCount));
                    this.hwv = false;
                    return;
                }
            }
        }
    }

    public static Point bbB() {
        return new Point(MP4MuxerJNI.ffmpegGetVideoWidth(), MP4MuxerJNI.ffmpegGetVideoHeight());
    }
}
