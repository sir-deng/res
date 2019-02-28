package com.tencent.mm.plugin.s;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.view.Surface;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

public final class k extends h {
    public Surface aeI;
    boolean ovR = false;
    private boolean ovS = false;
    boolean ovT = false;
    private long ovU = 0;
    long ovV = -1;
    private int videoHeight;
    private int videoWidth;

    public k(g gVar, ag agVar) {
        super(gVar, agVar);
    }

    final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, BufferInfo bufferInfo) {
        x.d("MicroMsg.VideoTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d", atw(), Integer.valueOf(this.state), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i));
        if (d.sS(this.state)) {
            x.i("MicroMsg.VideoTrackDataSource", "%s video track flush surface", atw());
            mediaCodec.releaseOutputBuffer(i, true);
            setState(4);
            return true;
        } else if (d.sR(this.state)) {
            x.d("MicroMsg.VideoTrackDataSource", "%s start to handle precision seek[%d, %d] diff[%d]", atw(), Long.valueOf(bufferInfo.presentationTimeUs / 1000), Long.valueOf(j), Long.valueOf(j - (bufferInfo.presentationTimeUs / 1000)));
            if ((j - (bufferInfo.presentationTimeUs / 1000) <= 30 ? 1 : null) != null) {
                x.i("MicroMsg.VideoTrackDataSource", "%s precision seek done to surface", atw());
                mediaCodec.releaseOutputBuffer(i, true);
                if (this.ovS) {
                    setState(7);
                    this.ovS = false;
                }
                this.ovS = true;
            } else {
                mediaCodec.releaseOutputBuffer(i, false);
            }
            return true;
        } else if (d.sT(this.state)) {
            long j3 = bufferInfo.presentationTimeUs / 1000;
            long elapsedRealtime = (j3 - j) - (SystemClock.elapsedRealtime() - j2);
            x.d("MicroMsg.VideoTrackDataSource", "%s earlyMs[%d] time[%d, %d, %d] sample[%d %d]", atw(), Long.valueOf(elapsedRealtime), Long.valueOf(SystemClock.elapsedRealtime() - j2), Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(j2), Long.valueOf(j), Long.valueOf(j3));
            if (elapsedRealtime < -30) {
                x.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too late to show video frame. throw now", atw());
                mediaCodec.releaseOutputBuffer(i, false);
                this.ovj.ovc = 0;
                return true;
            } else if (elapsedRealtime < 30) {
                this.ovj.ouZ = bufferInfo.presentationTimeUs;
                if (elapsedRealtime > 11) {
                    try {
                        Thread.sleep(elapsedRealtime - 10);
                    } catch (Exception e) {
                    }
                }
                if (d.sT(this.state)) {
                    if (Math.abs(j3 - this.ovU) > 1000) {
                        x.i("MicroMsg.VideoTrackDataSource", "%s finish to process index[%d] time[%d] to surface", atw(), Integer.valueOf(i), Long.valueOf(j3));
                        this.ovU = j3;
                    }
                    mediaCodec.releaseOutputBuffer(i, true);
                    return true;
                }
                x.i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", atw(), Integer.valueOf(this.state));
                return false;
            } else {
                x.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too early now do nothing.", atw());
                return false;
            }
        } else {
            x.i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", atw(), Integer.valueOf(this.state));
            return false;
        }
    }

    final String bae() {
        return SlookAirButtonRecentMediaAdapter.VIDEO_TYPE;
    }

    final boolean a(MediaCodec mediaCodec) {
        if (mediaCodec != null) {
            MediaFormat mediaFormat;
            if (this.aeI == null) {
                x.w("MicroMsg.VideoTrackDataSource", "%s decoder configure surface but surface is null.", atw());
                this.ovR = false;
            } else {
                this.ovR = true;
            }
            x.i("MicroMsg.VideoTrackDataSource", "%s handleDecoderBeforeStart", atw());
            if (this.ovr == null) {
                mediaFormat = this.ovo;
            } else {
                mediaFormat = this.ovr.getTrackFormat(this.ovq);
            }
            mediaCodec.configure(mediaFormat, this.aeI, null, 0);
        }
        return false;
    }

    protected final void b(MediaCodec mediaCodec) {
        x.i("MicroMsg.VideoTrackDataSource", "%s output format changed", atw());
        mediaCodec.setVideoScalingMode(1);
    }

    @TargetApi(23)
    public final void bat() {
        try {
            if (this.ovt != null) {
                this.ovt.setOutputSurface(this.aeI);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoTrackDataSource", e, "%s change surface23 error [%s]", atw(), e.toString());
            bau();
        }
    }

    public final void bau() {
        x.i("MicroMsg.VideoTrackDataSource", "%s change surface below 23", atw());
        if (this.ovt != null) {
            kM();
            y(this.ovj.ouZ, -1);
            bao();
        }
    }

    protected final void b(MediaFormat mediaFormat, String str, int i) {
        int integer;
        int i2;
        super.b(mediaFormat, str, i);
        this.videoHeight = mediaFormat.getInteger("height");
        this.videoWidth = mediaFormat.getInteger("width");
        if (mediaFormat.containsKey("rotation-degrees")) {
            integer = mediaFormat.getInteger("rotation-degrees");
            i2 = 1;
        } else {
            integer = SightVideoJNI.getMp4Rotate(this.path);
            x.w("MicroMsg.VideoTrackDataSource", "%s it don't contains rotation key. degrees [%d]", atw(), Integer.valueOf(integer));
            i2 = 0;
        }
        if (Math.abs(integer) == 90 || Math.abs(integer) == 270) {
            int i3 = this.videoWidth;
            this.videoWidth = this.videoHeight;
            this.videoHeight = i3;
        }
        if (i2 != 0) {
            integer = 0;
        }
        this.ovk.obtainMessage(4, this.videoWidth, this.videoHeight, Integer.valueOf(integer)).sendToTarget();
        x.i("MicroMsg.VideoTrackDataSource", "%s video size[%d, %d] degrees[%d]", atw(), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(integer));
    }

    protected final boolean A(int i, long j) {
        x.d("MicroMsg.VideoTrackDataSource", "%s reset extractor flag[%d] needReset[%b]", atw(), Integer.valueOf(i), Boolean.valueOf(this.ovj.ove));
        if (!this.ovj.ove || i != 1 || this.ovV == j) {
            return false;
        }
        boolean y = y(j, -1);
        this.ovV = j;
        return y;
    }
}
