package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.media.PlaybackParams;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.b;
import com.tencent.mm.pluginsdk.ui.tools.f.c;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class VideoTextureView extends MMTextureView implements f {
    private float aew;
    private int kJB;
    private int kJC;
    private boolean kYN;
    private int mDuration;
    private Surface mSurface;
    private int mVideoHeight;
    private int mVideoWidth;
    private boolean nJb;
    private a qAJ;
    private MediaPlayer qDR;
    private long startTime;
    private long vEV;
    private boolean vEW;
    private e vEY;
    private c vEZ;
    public int vFA;
    private OnSeekCompleteListener vFB;
    private OnBufferingUpdateListener vFC;
    private OnInfoListener vFD;
    private boolean vFE;
    private d vFa;
    private boolean vFc;
    private boolean vFd;
    SurfaceTextureListener vFf;
    public o vFg;
    private String vFp;
    private boolean vFq;
    private boolean vFr;
    OnVideoSizeChangedListener vFs;
    OnPreparedListener vFt;
    private OnCompletionListener vFu;
    private OnErrorListener vFv;
    private b vFy;
    private long vFz;

    static /* synthetic */ void e(VideoTextureView videoTextureView) {
        LayoutParams layoutParams = (LayoutParams) videoTextureView.getLayoutParams();
        layoutParams.addRule(13);
        videoTextureView.setLayoutParams(layoutParams);
    }

    public VideoTextureView(Context context) {
        this(context, null);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSurface = null;
        this.qDR = null;
        this.startTime = 0;
        this.vFz = 0;
        this.kJB = 0;
        this.kJC = 0;
        this.vFA = 0;
        this.nJb = false;
        this.vEW = false;
        this.vFs = new OnVideoSizeChangedListener() {
            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                try {
                    if (mediaPlayer != VideoTextureView.this.qDR) {
                        x.w("MicroMsg.VideoTextureView", "another player on video size changed, return now.[%s, %s]", mediaPlayer, VideoTextureView.this.qDR);
                        return;
                    }
                    VideoTextureView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                    VideoTextureView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                    x.i("MicroMsg.VideoTextureView", "on size change size:( " + VideoTextureView.this.mVideoWidth + " , " + VideoTextureView.this.mVideoHeight + " )");
                    if (VideoTextureView.this.qAJ != null) {
                        VideoTextureView.this.qAJ.cl(VideoTextureView.this.mVideoWidth, VideoTextureView.this.mVideoHeight);
                    }
                    VideoTextureView.e(VideoTextureView.this);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.VideoTextureView", e, "on video size changed error[%d, %d]", Integer.valueOf(i), Integer.valueOf(i2));
                }
            }
        };
        this.vFt = new OnPreparedListener() {
            public final void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer == VideoTextureView.this.qDR || mediaPlayer == null) {
                    int videoHeight;
                    VideoTextureView.this.vFq = true;
                    VideoTextureView.this.mVideoWidth = mediaPlayer != null ? mediaPlayer.getVideoWidth() : 0;
                    VideoTextureView videoTextureView = VideoTextureView.this;
                    if (mediaPlayer != null) {
                        videoHeight = mediaPlayer.getVideoHeight();
                    } else {
                        videoHeight = 0;
                    }
                    videoTextureView.mVideoHeight = videoHeight;
                    x.i("MicroMsg.VideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", Integer.valueOf(VideoTextureView.this.mVideoWidth), Integer.valueOf(VideoTextureView.this.mVideoHeight), Boolean.valueOf(VideoTextureView.this.vFr));
                    VideoTextureView.e(VideoTextureView.this);
                    if (VideoTextureView.this.mVideoWidth == 0 || VideoTextureView.this.mVideoHeight == 0) {
                        if (VideoTextureView.this.vFr) {
                            VideoTextureView.this.qDR.start();
                            VideoTextureView.this.vFr = false;
                            VideoTextureView.this.qDR.setLooping(VideoTextureView.this.nJb);
                        }
                    } else if (VideoTextureView.this.vFr) {
                        VideoTextureView.this.qDR.start();
                        VideoTextureView.this.qDR.setLooping(VideoTextureView.this.nJb);
                        VideoTextureView.this.vFr = false;
                    }
                    if (VideoTextureView.this.qAJ != null) {
                        VideoTextureView.this.qAJ.hY();
                        return;
                    }
                    return;
                }
                x.w("MicroMsg.VideoTextureView", "another player callback, release now.[%s, %s]", mediaPlayer, VideoTextureView.this.qDR);
                new Thread(mediaPlayer) {
                    public final void run() {
                        try {
                            if (r2 != null) {
                                x.i("MicroMsg.VideoTextureView", "%d another thread to release player[%s]", Integer.valueOf(VideoTextureView.this.hashCode()), r2);
                                r2.stop();
                                r2.release();
                            }
                        } catch (Exception e) {
                        }
                    }
                }.start();
            }
        };
        this.vFB = new OnSeekCompleteListener() {
            public final void onSeekComplete(MediaPlayer mediaPlayer) {
                int currentPosition = mediaPlayer != null ? mediaPlayer.getCurrentPosition() : -1;
                x.i("MicroMsg.VideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", Integer.valueOf(currentPosition), Boolean.valueOf(VideoTextureView.this.vFr), Boolean.valueOf(VideoTextureView.this.vFd));
                if (!VideoTextureView.this.vFr) {
                    VideoTextureView.this.pause();
                } else if (!VideoTextureView.this.vFd) {
                    VideoTextureView.this.start();
                } else {
                    return;
                }
                if (VideoTextureView.this.vEZ != null) {
                    VideoTextureView.this.vEZ.bY(VideoTextureView.this.vFr);
                }
                VideoTextureView.this.vEV = 0;
            }
        };
        this.vFC = new OnBufferingUpdateListener() {
            public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                x.d("MicroMsg.VideoTextureView", "onBufferingUpdate percent[%d]", Integer.valueOf(i));
                VideoTextureView.this.vFA = i;
            }
        };
        this.vFD = new OnInfoListener() {
            public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                x.d("MicroMsg.VideoTextureView", "onInfo [%d %d]", Integer.valueOf(i), Integer.valueOf(i2));
                if (VideoTextureView.this.vFy != null) {
                    VideoTextureView.this.vFy.eC(i, i2);
                }
                return false;
            }
        };
        this.vFu = new OnCompletionListener() {
            public final void onCompletion(MediaPlayer mediaPlayer) {
                x.i("MicroMsg.VideoTextureView", "video on completion");
                VideoTextureView.this.vFz = bi.Wx();
                if (VideoTextureView.this.qAJ != null) {
                    VideoTextureView.this.qAJ.vi();
                }
            }
        };
        this.vFv = new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                x.w("MicroMsg.VideoTextureView", "Error: " + i + "," + i2);
                if (VideoTextureView.this.qAJ != null) {
                    VideoTextureView.this.qAJ.onError(i, i2);
                }
                return true;
            }
        };
        this.vEV = 0;
        this.vFc = false;
        this.vFd = false;
        this.vFE = false;
        this.vFf = new SurfaceTextureListener() {
            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                if (VideoTextureView.this.vFd) {
                    if (VideoTextureView.this.qDR != null) {
                        VideoTextureView.this.qDR.pause();
                        if (VideoTextureView.this.kYN) {
                            VideoTextureView.this.qDR.setVolume(0.0f, 0.0f);
                        } else {
                            VideoTextureView.this.qDR.setVolume(1.0f, 1.0f);
                        }
                    }
                    VideoTextureView.this.vFd = false;
                }
                if (VideoTextureView.this.vEV > 0 && VideoTextureView.this.vEY != null) {
                    VideoTextureView.this.vEY.bcn();
                    VideoTextureView.this.vEY = null;
                }
                VideoTextureView.this.vEV = System.currentTimeMillis();
                if (VideoTextureView.this.vFE) {
                    x.i("MicroMsg.VideoTextureView", "%d flush surface pause now time[%d]", Integer.valueOf(VideoTextureView.this.hashCode()), Integer.valueOf(VideoTextureView.this.getCurrentPosition()));
                    if (VideoTextureView.this.qDR != null) {
                        VideoTextureView.this.qDR.pause();
                        VideoTextureView.this.setMute(VideoTextureView.this.kYN);
                    }
                    VideoTextureView.this.vFE = false;
                }
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                x.i("MicroMsg.VideoTextureView", "on texture size changed width : " + i + " height : " + i2);
                if (VideoTextureView.this.qDR != null && VideoTextureView.this.vFq && VideoTextureView.this.mVideoWidth == i && VideoTextureView.this.mVideoHeight == i2) {
                    VideoTextureView.this.qDR.start();
                }
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                x.i("MicroMsg.VideoTextureView", "%d on texture destroyed mIsPrepared[%b]", Integer.valueOf(VideoTextureView.this.hashCode()), Boolean.valueOf(VideoTextureView.this.vFq));
                VideoTextureView.this.mSurface = null;
                if (VideoTextureView.this.qDR == null || !VideoTextureView.this.vFq) {
                    VideoTextureView.this.cdy();
                    VideoTextureView.this.vFc = false;
                } else if (VideoTextureView.this.isPlaying()) {
                    VideoTextureView.this.vFc = true;
                    VideoTextureView.this.qDR.pause();
                }
                return false;
            }

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                VideoTextureView.this.kJB = i;
                VideoTextureView.this.kJC = i2;
                VideoTextureView.this.cqy();
                VideoTextureView.this.mSurface = new Surface(surfaceTexture);
                x.i("MicroMsg.VideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", Integer.valueOf(VideoTextureView.this.hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(VideoTextureView.this.vFq), Integer.valueOf(VideoTextureView.this.mSurface.hashCode()));
                if (VideoTextureView.this.qDR == null || !VideoTextureView.this.vFq) {
                    VideoTextureView.this.aKo();
                } else {
                    VideoTextureView.this.qDR.setSurface(VideoTextureView.this.mSurface);
                    if (VideoTextureView.this.vFc) {
                        VideoTextureView.this.qDR.start();
                    } else {
                        VideoTextureView.this.vFd = true;
                        VideoTextureView.this.qDR.setVolume(0.0f, 0.0f);
                        VideoTextureView.this.qDR.start();
                    }
                    VideoTextureView.this.vFc = false;
                }
                if (VideoTextureView.this.vFa != null) {
                    VideoTextureView.this.vFa.TP();
                }
            }
        };
        this.kYN = false;
        this.vFg = new o();
        this.aew = -1.0f;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        setSurfaceTextureListener(this.vFf);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public final void a(e eVar) {
        this.vEY = eVar;
    }

    public final void a(c cVar) {
        this.vEZ = cVar;
    }

    public final void a(b bVar) {
        this.vFy = bVar;
    }

    public final void a(d dVar) {
        this.vFa = dVar;
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
        long j;
        long j2 = this.vFz > 0 ? this.vFz - this.startTime : 2147483647L;
        long Wx = bi.Wx() - this.startTime;
        if (j2 > Wx) {
            j = Wx;
        } else {
            j = j2;
        }
        int i = ((int) j) * 1000;
        if (i > getDuration()) {
            i = getDuration();
        }
        x.i("MicroMsg.VideoTextureView", "stop : dur:%d stop:%d comp:%d", Integer.valueOf(getDuration()), Long.valueOf(Wx), Long.valueOf(j2));
        if (this.qAJ != null) {
            this.qAJ.ck(i, getDuration());
        }
        cdy();
        this.vFg.reset();
        try {
            if (this.mSurface != null && this.vFq) {
                SurfaceTexture surfaceTexture = getSurfaceTexture();
                if (surfaceTexture != null) {
                    x.i("MicroMsg.VideoTextureView", "%d releaseSurface", Integer.valueOf(hashCode()));
                    EGL10 egl10 = (EGL10) EGLContext.getEGL();
                    EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                    egl10.eglInitialize(eglGetDisplay, null);
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344}, eGLConfigArr, 1, new int[1]);
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                    EGLSurface eglCreateWindowSurface = egl10.eglCreateWindowSurface(eglGetDisplay, eGLConfig, surfaceTexture, new int[]{12344});
                    egl10.eglMakeCurrent(eglGetDisplay, eglCreateWindowSurface, eglCreateWindowSurface, eglCreateContext);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    GLES20.glClear(16384);
                    egl10.eglSwapBuffers(eglGetDisplay, eglCreateWindowSurface);
                    egl10.eglDestroySurface(eglGetDisplay, eglCreateWindowSurface);
                    egl10.eglMakeCurrent(eglGetDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                    egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
                    egl10.eglTerminate(eglGetDisplay);
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoTextureView", e, "release surface", new Object[0]);
        }
        this.vFp = "";
        this.vFA = 0;
        this.vFq = false;
        this.vFr = false;
        this.vEV = 0;
    }

    private void cdy() {
        boolean z = true;
        String str = "MicroMsg.VideoTextureView";
        String str2 = "%d release media player isPrepared[%b] player is null[%b] ";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Boolean.valueOf(this.vFq);
        if (this.qDR != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (this.qDR != null) {
            this.qDR.setOnErrorListener(null);
            this.qDR.setOnVideoSizeChangedListener(null);
            try {
                this.qDR.stop();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VideoTextureView", e, "stop media player error", new Object[0]);
            }
            try {
                this.qDR.reset();
                this.qDR.release();
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.VideoTextureView", e2, "reset media player error", new Object[0]);
            }
        }
        this.qDR = null;
    }

    private void aKo() {
        if (!bi.oN(this.vFp) && this.mSurface != null) {
            cdy();
            x.i("MicroMsg.VideoTextureView", "%d open video %s", Integer.valueOf(hashCode()), this.vFp);
            try {
                this.qDR = new j();
                this.qDR.setOnPreparedListener(this.vFt);
                this.qDR.setOnVideoSizeChangedListener(this.vFs);
                this.vFq = false;
                x.v("MicroMsg.VideoTextureView", "reset duration to -1 in openVideo");
                this.mDuration = -1;
                this.vFA = 0;
                this.qDR.setOnCompletionListener(this.vFu);
                this.qDR.setOnErrorListener(this.vFv);
                this.qDR.setOnSeekCompleteListener(this.vFB);
                this.qDR.setOnBufferingUpdateListener(this.vFC);
                this.qDR.setOnInfoListener(this.vFD);
                this.qDR.setDataSource(this.vFp);
                this.qDR.setSurface(this.mSurface);
                this.qDR.setAudioStreamType(3);
                this.qDR.setScreenOnWhilePlaying(true);
                this.qDR.prepareAsync();
                this.mVideoHeight = this.qDR.getVideoHeight();
                this.mVideoWidth = this.qDR.getVideoWidth();
                setMute(this.kYN);
                aa(this.aew);
                x.i("MicroMsg.VideoTextureView", "%d open video success player[%s] ", Integer.valueOf(hashCode()), Integer.valueOf(this.qDR.hashCode()));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VideoTextureView", e, "prepare async error path", new Object[0]);
                if (this.qAJ != null) {
                    this.qAJ.onError(-1, -1);
                }
            }
        }
    }

    public final void bas() {
        if (this.qDR != null && this.vFq && this.mSurface != null && this.mSurface.isValid()) {
            x.i("MicroMsg.VideoTextureView", "%d flush surface start time[%d] ", Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()));
            this.vFE = true;
            this.qDR.setVolume(0.0f, 0.0f);
            this.qDR.start();
        }
    }

    public final void pause() {
        if (this.qDR != null && this.vFq && this.qDR.isPlaying()) {
            x.d("MicroMsg.VideoTextureView", "pause video.");
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
        if (this.qDR != null && this.vFq) {
            return this.qDR.getCurrentPosition();
        }
        if (this.qDR == null) {
            return -1;
        }
        return 0;
    }

    public final boolean isPlaying() {
        boolean z;
        if (this.qDR == null || !this.vFq || this.vFd) {
            z = false;
        } else {
            z = this.qDR.isPlaying();
        }
        x.d("MicroMsg.VideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", Integer.valueOf(hashCode()), Boolean.valueOf(z), Boolean.valueOf(this.vFd), Boolean.valueOf(this.vFq));
        return z;
    }

    public final void cR(boolean z) {
        if (this.qDR != null) {
            this.qDR.setLooping(z);
        }
        this.nJb = true;
    }

    public final void a(a aVar) {
        this.qAJ = aVar;
    }

    public final void onDetach() {
    }

    public final boolean start() {
        if (this.mSurface == null) {
            x.w("MicroMsg.VideoTextureView", "%d it surface not ready, do not start", Integer.valueOf(hashCode()));
            this.vFc = true;
            this.vFr = true;
            return false;
        }
        this.startTime = this.startTime == 0 ? bi.Wx() : this.startTime;
        x.i("MicroMsg.VideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b", Long.valueOf(this.startTime), Boolean.valueOf(this.vFq), Boolean.valueOf(this.vFd));
        if (this.qDR != null && this.vFq) {
            if (this.vFd) {
                this.vFd = false;
                setMute(this.kYN);
            }
            this.qDR.start();
            this.vFr = true;
            return true;
        } else if (this.qDR == null && this.vFq) {
            this.vFr = true;
            aKo();
            requestLayout();
            return true;
        } else {
            this.vFr = true;
            return false;
        }
    }

    public final boolean k(Context context, boolean z) {
        return start();
    }

    public final double btQ() {
        return 0.0d;
    }

    public final void q(double d) {
        if (this.qDR != null) {
            this.qDR.seekTo((int) d);
            this.vFr = true;
            x.d("MicroMsg.VideoTextureView", "seek to time: " + d + " curr pos : " + this.qDR.getCurrentPosition());
        }
    }

    public final void c(double d, boolean z) {
        q(d);
        this.vFr = z;
    }

    public final void ii(boolean z) {
    }

    public final long btR() {
        return this.vEV;
    }

    public final void setMute(boolean z) {
        x.i("MicroMsg.VideoTextureView", "%d set mute %b", Integer.valueOf(hashCode()), Boolean.valueOf(z));
        this.kYN = z;
        if (this.qDR == null) {
            return;
        }
        if (this.kYN) {
            this.qDR.setVolume(0.0f, 0.0f);
        } else {
            this.qDR.setVolume(1.0f, 1.0f);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.mVideoWidth == 0 || this.mVideoHeight == 0) {
            setMeasuredDimension(1, 1);
            return;
        }
        this.vFg.u(getDefaultSize(1, i), getDefaultSize(1, i2), this.mVideoWidth, this.mVideoHeight);
        setMeasuredDimension(this.vFg.vFG, this.vFg.vFH);
    }

    public final boolean aa(float f) {
        if (f <= 0.0f) {
            return false;
        }
        this.aew = f;
        if (com.tencent.mm.compatible.util.d.fN(23)) {
            return aB(this.aew);
        }
        return false;
    }

    private boolean aB(float f) {
        if (VERSION.SDK_INT >= 23) {
            try {
                if (this.qDR != null && com.tencent.mm.compatible.util.d.fN(23)) {
                    PlaybackParams playbackParams = this.qDR.getPlaybackParams();
                    if (playbackParams == null) {
                        playbackParams = new PlaybackParams();
                    }
                    this.qDR.setPlaybackParams(playbackParams.setSpeed(f));
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VideoTextureView", e, "%s handle play rate error", Integer.valueOf(hashCode()));
                return false;
            }
        }
        return true;
    }
}
