package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.b;
import com.tencent.mm.pluginsdk.ui.tools.f.c;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.x;

public class VideoSurfaceView extends SurfaceView implements f {
    private boolean kYN;
    private int mDuration;
    private int mVideoHeight;
    private int mVideoWidth;
    private a qAJ;
    private MediaPlayer qDR;
    private SurfaceHolder sfU;
    private String vFp;
    private boolean vFq;
    private boolean vFr;
    OnVideoSizeChangedListener vFs;
    OnPreparedListener vFt;
    private OnCompletionListener vFu;
    private OnErrorListener vFv;
    Callback vFw;

    static /* synthetic */ void c(VideoSurfaceView videoSurfaceView) {
        if (videoSurfaceView.mVideoHeight != 0 && videoSurfaceView.mVideoWidth != 0) {
            int i = videoSurfaceView.mVideoWidth;
            int i2 = videoSurfaceView.mVideoHeight;
            x.v("MicroMsg.VideoSurfaceView", "video size before:" + i + "   " + i2);
            x.v("MicroMsg.VideoSurfaceView", "layout size before:" + videoSurfaceView.getWidth() + "   " + videoSurfaceView.getHeight());
            int width = videoSurfaceView.getWidth();
            int height = videoSurfaceView.getHeight();
            int i3 = width <= 0 ? i : width;
            width = height <= 0 ? i2 : height;
            float f = (((float) i3) * 1.0f) / ((float) i);
            float f2 = (((float) width) * 1.0f) / ((float) i2);
            LayoutParams layoutParams = (LayoutParams) videoSurfaceView.getLayoutParams();
            if (f > f2) {
                layoutParams.width = (int) (((float) i) * f2);
                layoutParams.height = width;
            } else {
                layoutParams.width = i3;
                layoutParams.height = (int) (((float) i2) * f);
            }
            layoutParams.addRule(13);
            videoSurfaceView.setLayoutParams(layoutParams);
            x.v("MicroMsg.VideoSurfaceView", "video size after:" + videoSurfaceView.qDR.getVideoWidth() + "   " + videoSurfaceView.qDR.getVideoHeight());
            x.v("MicroMsg.VideoSurfaceView", "layout size after:" + layoutParams.width + "   " + layoutParams.height);
        }
    }

    public VideoSurfaceView(Context context) {
        this(context, null);
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sfU = null;
        this.qDR = null;
        this.vFs = new OnVideoSizeChangedListener() {
            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                VideoSurfaceView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                VideoSurfaceView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                x.v("MicroMsg.VideoSurfaceView", "on size change size:( " + VideoSurfaceView.this.mVideoWidth + " , " + VideoSurfaceView.this.mVideoHeight + " )");
                VideoSurfaceView.c(VideoSurfaceView.this);
            }
        };
        this.vFt = new OnPreparedListener() {
            public final void onPrepared(MediaPlayer mediaPlayer) {
                VideoSurfaceView.this.vFq = true;
                if (VideoSurfaceView.this.qAJ != null) {
                    VideoSurfaceView.this.qAJ.hY();
                }
                VideoSurfaceView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                VideoSurfaceView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                VideoSurfaceView.c(VideoSurfaceView.this);
                if (VideoSurfaceView.this.mVideoWidth == 0 || VideoSurfaceView.this.mVideoHeight == 0) {
                    if (VideoSurfaceView.this.vFr) {
                        VideoSurfaceView.this.qDR.start();
                        VideoSurfaceView.this.vFr = false;
                    }
                } else if (VideoSurfaceView.this.vFr) {
                    VideoSurfaceView.this.qDR.start();
                    VideoSurfaceView.this.vFr = false;
                }
            }
        };
        this.vFu = new OnCompletionListener() {
            public final void onCompletion(MediaPlayer mediaPlayer) {
                if (VideoSurfaceView.this.qAJ != null) {
                    VideoSurfaceView.this.qAJ.ck(VideoSurfaceView.this.qDR.getCurrentPosition(), VideoSurfaceView.this.qDR.getDuration());
                    VideoSurfaceView.this.qAJ.vi();
                }
            }
        };
        this.vFv = new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                x.d("MicroMsg.VideoSurfaceView", "Error: " + i + "," + i2);
                if (VideoSurfaceView.this.qAJ != null) {
                    VideoSurfaceView.this.qAJ.onError(i, i2);
                }
                return true;
            }
        };
        this.vFw = new Callback() {
            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                x.i("MicroMsg.VideoSurfaceView", "on surface changed %d*%d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (VideoSurfaceView.this.qDR != null && VideoSurfaceView.this.vFq && VideoSurfaceView.this.mVideoWidth == i2 && VideoSurfaceView.this.mVideoHeight == i3) {
                    VideoSurfaceView.this.qDR.start();
                }
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                x.i("MicroMsg.VideoSurfaceView", "on surface created");
                VideoSurfaceView.this.sfU = surfaceHolder;
                VideoSurfaceView.this.aKo();
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                x.i("MicroMsg.VideoSurfaceView", "on surface destroyed");
                VideoSurfaceView.this.sfU = null;
                if (VideoSurfaceView.this.qDR != null) {
                    VideoSurfaceView.this.qAJ.ck(VideoSurfaceView.this.qDR.getCurrentPosition(), VideoSurfaceView.this.qDR.getDuration());
                    VideoSurfaceView.this.qDR.reset();
                    VideoSurfaceView.this.qDR.release();
                    VideoSurfaceView.this.qDR = null;
                }
            }
        };
        this.kYN = false;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.vFw);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
    }

    public final void setVideoPath(String str) {
        this.vFp = str;
        this.vFr = false;
        aKo();
        requestLayout();
    }

    public final String Uy() {
        return this.vFp;
    }

    public final void stop() {
        if (this.qDR != null) {
            this.qDR.stop();
            this.qDR.release();
            this.qDR = null;
        }
    }

    private void aKo() {
        if (this.vFp != null && this.sfU != null) {
            if (this.qDR != null) {
                this.qDR.stop();
                this.qDR.release();
                this.qDR = null;
            }
            try {
                this.qDR = new j();
                this.qDR.setOnPreparedListener(this.vFt);
                this.qDR.setOnVideoSizeChangedListener(this.vFs);
                this.vFq = false;
                x.v("MicroMsg.VideoSurfaceView", "reset duration to -1 in openVideo");
                this.mDuration = -1;
                this.qDR.setOnCompletionListener(this.vFu);
                this.qDR.setOnErrorListener(this.vFv);
                this.qDR.setDataSource(this.vFp);
                this.qDR.setDisplay(this.sfU);
                this.qDR.setAudioStreamType(3);
                this.qDR.setScreenOnWhilePlaying(true);
                this.qDR.prepareAsync();
                this.mVideoHeight = this.qDR.getVideoHeight();
                this.mVideoWidth = this.qDR.getVideoWidth();
                setMute(this.kYN);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VideoSurfaceView", e, "prepare async error %s", e.getMessage());
                if (this.qAJ != null) {
                    this.qAJ.onError(-1, -1);
                }
            }
        }
    }

    public final void pause() {
        if (this.qDR != null && this.vFq && this.qDR.isPlaying()) {
            this.qDR.pause();
        }
        this.vFr = false;
    }

    public final int getDuration() {
        if (this.qDR == null || !this.vFq) {
            this.mDuration = -1;
            return this.mDuration;
        } else if (this.mDuration > 0) {
            return this.mDuration;
        } else {
            this.mDuration = this.qDR.getDuration();
            return this.mDuration;
        }
    }

    public final int getCurrentPosition() {
        if (this.qDR == null || !this.vFq) {
            return 0;
        }
        return this.qDR.getCurrentPosition();
    }

    public final boolean isPlaying() {
        if (this.qDR == null || !this.vFq) {
            return false;
        }
        return this.qDR.isPlaying();
    }

    public final void cR(boolean z) {
        if (this.qDR != null) {
            this.qDR.setLooping(z);
        }
    }

    public final void a(a aVar) {
        this.qAJ = aVar;
    }

    public final void onDetach() {
    }

    public final boolean start() {
        if (this.qDR == null || !this.vFq) {
            this.vFr = true;
        } else {
            this.qDR.start();
            this.vFr = false;
        }
        return true;
    }

    public final boolean k(Context context, boolean z) {
        return start();
    }

    public final double btQ() {
        return 0.0d;
    }

    public final void q(double d) {
        if (this.qDR != null) {
            x.d("MicroMsg.VideoSurfaceView", "seek to time: " + d);
            this.qDR.seekTo((int) d);
            start();
        }
    }

    public final void ii(boolean z) {
    }

    public final long btR() {
        return 0;
    }

    public final void setMute(boolean z) {
        this.kYN = z;
        if (this.qDR == null) {
            return;
        }
        if (this.kYN) {
            this.qDR.setVolume(0.0f, 0.0f);
        } else {
            this.qDR.setVolume(0.5f, 0.5f);
        }
    }

    public final void c(double d, boolean z) {
        q(d);
    }

    public final void a(e eVar) {
    }

    public final void a(c cVar) {
    }

    public final void a(b bVar) {
    }

    public final void a(d dVar) {
    }
}
