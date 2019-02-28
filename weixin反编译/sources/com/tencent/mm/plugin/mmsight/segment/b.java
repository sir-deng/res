package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import com.tencent.mm.plugin.mmsight.segment.e.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements e {
    private long aBM;
    private int frameCount = 0;
    private boolean hwv = false;
    private a oCX;
    private String oCr;
    private long oCs;
    private byte[] oCt = null;
    private int oCu;

    public final int r(String str, long j, long j2) {
        x.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s", str, Long.valueOf(j), Long.valueOf(j2));
        this.oCr = str;
        this.aBM = j;
        this.oCs = j2;
        if (bi.oN(str)) {
            return -1;
        }
        long Wz = bi.Wz();
        int ffmpegOpenAndSeekFile = MP4MuxerJNI.ffmpegOpenAndSeekFile(str, ((double) j) * 1000.0d, ((double) j2) * 1000.0d);
        x.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", Long.valueOf(bi.bB(Wz)));
        return ffmpegOpenAndSeekFile;
    }

    public final void D(Runnable runnable) {
        x.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
        this.hwv = true;
        this.frameCount = 0;
        while (this.hwv) {
            long Wz = bi.Wz();
            this.oCt = MP4MuxerJNI.ffmpegGetNextVideoFrameData(this.oCt);
            x.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", Long.valueOf(bi.bB(Wz)));
            boolean ffmpegCheckIfReachEndTimestamp = MP4MuxerJNI.ffmpegCheckIfReachEndTimestamp();
            if (this.oCt == null || ffmpegCheckIfReachEndTimestamp) {
                x.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", Boolean.valueOf(ffmpegCheckIfReachEndTimestamp));
                this.hwv = false;
                runnable.run();
                return;
            }
            this.frameCount++;
            if ((this.oCu <= 1 || this.frameCount % this.oCu != 0) && this.oCX != null) {
                this.oCX.aC(this.oCt);
            }
        }
    }

    public final void a(a aVar) {
        this.oCX = aVar;
    }

    public final Point bbB() {
        return new Point(MP4MuxerJNI.ffmpegGetVideoWidth(), MP4MuxerJNI.ffmpegGetVideoHeight());
    }

    public final void stop() {
        x.i("MicroMsg.FFMpegTranscodeDecoder", "stop, start: %s", Boolean.valueOf(this.hwv));
        this.hwv = false;
    }

    public final int bbE() {
        return 2;
    }

    public final void tk(int i) {
        x.i("MicroMsg.FFMpegTranscodeDecoder", "setFrameDropInterval: %s", Integer.valueOf(i));
        this.oCu = i;
    }
}
