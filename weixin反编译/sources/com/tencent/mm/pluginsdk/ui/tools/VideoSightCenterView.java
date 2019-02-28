package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class VideoSightCenterView extends VideoSightView {
    private boolean fBn = false;
    private int rqg = 0;
    private volatile boolean vFi = false;
    private MediaMetadataRetriever vFj;

    public VideoSightCenterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public VideoSightCenterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void wB(int i) {
        super.wB(i);
        cdx();
    }

    public final void dx(int i, int i2) {
        super.dx(i, i2);
        cdx();
    }

    private void cdx() {
        if (getLayoutParams() instanceof LayoutParams) {
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            layoutParams.addRule(13);
            setLayoutParams(layoutParams);
        }
    }

    protected final void init() {
        if (bi.aD(q.gHP.gHg, "").equals("other")) {
            x.i("MicroMsg.VideoSightCenterView", "init::use other player");
        } else {
            if(true);
        }
        a(new e() {
            public final void d(b bVar, int i) {
                if (-1 == i) {
                    x.i("MicroMsg.VideoSightCenterView", "error stop, isCompletion: %s", Boolean.valueOf(VideoSightCenterView.this.vFi));
                    if (VideoSightCenterView.this.qAJ != null && !VideoSightCenterView.this.vFi) {
                        VideoSightCenterView.this.qAJ.onError(0, 0);
                    }
                } else if (i == 0) {
                    x.i("MicroMsg.VideoSightCenterView", "normal stop");
                    VideoSightCenterView.this.vFi = true;
                    if (VideoSightCenterView.this.qAJ != null) {
                        VideoSightCenterView.this.qAJ.vi();
                    }
                }
            }
        });
    }

    public final void ii(boolean z) {
        if (z) {
            a(new f() {
                public final void b(b bVar, long j) {
                    if (VideoSightCenterView.this.duration == 0) {
                        VideoSightCenterView.this.duration = VideoSightCenterView.this.getDuration();
                    }
                    if (VideoSightCenterView.this.qAJ != null) {
                        x.v("MicroMsg.VideoSightCenterView", "onPlayTime, currentTime: %s, duration: %s", Long.valueOf(j), Integer.valueOf(VideoSightCenterView.this.duration));
                        VideoSightCenterView.this.rqg = (int) (1000 * j);
                        VideoSightCenterView.this.qAJ.ck((int) j, VideoSightCenterView.this.duration);
                    }
                }
            });
        } else {
            a(null);
        }
    }

    public final int getDuration() {
        x.i("MicroMsg.VideoSightCenterView", "getDuration");
        if (!bi.oN(this.qzp)) {
            try {
                if (this.vFj == null) {
                    this.vFj = new MediaMetadataRetriever();
                    this.vFj.setDataSource(this.qzp);
                }
                x.i("MicroMsg.VideoSightCenterView", "getDuration: %s", Integer.valueOf(Integer.valueOf(this.vFj.extractMetadata(9)).intValue()));
                return Integer.valueOf(this.vFj.extractMetadata(9)).intValue();
            } catch (Exception e) {
                x.e("MicroMsg.VideoSightCenterView", "getDuration error: %s", e.getMessage());
            }
        }
        return super.getDuration();
    }

    public final int getCurrentPosition() {
        x.v("MicroMsg.VideoSightCenterView", "getCurrentPosition: %s", Integer.valueOf(this.rqg));
        return this.rqg;
    }

    public final boolean start() {
        x.v("MicroMsg.VideoSightCenterView", "start");
        this.fBn = true;
        return super.start();
    }

    public final void stop() {
        x.v("MicroMsg.VideoSightCenterView", "stop");
        super.stop();
        this.rqg = 0;
        this.fBn = false;
    }

    public final void pause() {
        x.v("MicroMsg.VideoSightCenterView", "pause");
        super.pause();
    }

    public final double btQ() {
        return super.btQ();
    }

    public final void q(double d) {
        x.v("MicroMsg.VideoSightCenterView", "seekTo, time: %s, isStart: %s, currentPosition: %s, getLastProgresstime: %s", Double.valueOf(d), Boolean.valueOf(this.fBn), Integer.valueOf(this.rqg), Double.valueOf(super.btQ()));
        if (this.fBn && super.btQ() > 0.0d) {
            super.q(d / 1000.0d);
        }
    }

    public final boolean isPlaying() {
        x.v("MicroMsg.VideoSightCenterView", "isPlaying, isStart: %s, currentPosition: %s", Boolean.valueOf(this.fBn), Integer.valueOf(this.rqg));
        return this.fBn;
    }
}
