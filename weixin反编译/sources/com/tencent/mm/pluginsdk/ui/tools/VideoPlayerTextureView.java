package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.s.b;
import com.tencent.mm.plugin.s.i;
import com.tencent.mm.plugin.s.k;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.c;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;

public class VideoPlayerTextureView extends MMTextureView implements f {
    public boolean HE;
    private boolean kYN;
    public Surface mSurface;
    private int mVideoHeight;
    private int mVideoWidth;
    public boolean ove;
    public boolean ovf;
    public b ovm;
    public String path;
    public a qAJ;
    public i vES;
    private int vET;
    private boolean vEU;
    private long vEV;
    private boolean vEW;
    public boolean vEX;
    public e vEY;
    private c vEZ;
    private d vFa;
    public boolean vFb;
    protected boolean vFc;
    protected boolean vFd;
    public com.tencent.mm.plugin.s.c vFe;
    private SurfaceTextureListener vFf;
    public o vFg;

    static /* synthetic */ void f(VideoPlayerTextureView videoPlayerTextureView) {
        LayoutParams layoutParams = (LayoutParams) videoPlayerTextureView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.addRule(13);
            videoPlayerTextureView.setLayoutParams(layoutParams);
        }
    }

    public VideoPlayerTextureView(Context context) {
        this(context, null);
    }

    public VideoPlayerTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayerTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.vET = 0;
        this.HE = false;
        this.vEU = true;
        this.vEV = 0;
        this.vEW = false;
        this.vEX = false;
        this.ove = false;
        this.ovf = false;
        this.vFb = false;
        this.vFc = false;
        this.vFd = false;
        this.vFe = new com.tencent.mm.plugin.s.c() {
            public final void hY() {
                VideoPlayerTextureView.this.HE = true;
                VideoPlayerTextureView.this.setMute(VideoPlayerTextureView.this.kYN);
                if (VideoPlayerTextureView.this.qAJ != null) {
                    VideoPlayerTextureView.this.qAJ.hY();
                }
                VideoPlayerTextureView.this.requestLayout();
            }

            public final void vi() {
                if (VideoPlayerTextureView.this.qAJ != null) {
                    VideoPlayerTextureView.this.qAJ.vi();
                }
            }

            public final void onError(int i, int i2) {
                if (VideoPlayerTextureView.this.qAJ != null) {
                    VideoPlayerTextureView.this.qAJ.onError(i, i2);
                }
            }

            public final void bag() {
                if (VideoPlayerTextureView.this.vEZ != null) {
                    VideoPlayerTextureView.this.vEZ.bY(VideoPlayerTextureView.this.vEU);
                }
                if (!VideoPlayerTextureView.this.vEU) {
                    x.d("MicroMsg.VideoPlayerTextureView", "player seek done, but don't play now.");
                    VideoPlayerTextureView.this.vEU = true;
                } else if (VideoPlayerTextureView.this.vES != null) {
                    x.d("MicroMsg.VideoPlayerTextureView", "%s player seek done", VideoPlayerTextureView.this.vES.atw());
                    VideoPlayerTextureView.this.vES.start();
                }
            }

            public final void O(int i, int i2, int i3) {
                x.i("MicroMsg.VideoPlayerTextureView", "video size changed size[%d, %d] degrees[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                VideoPlayerTextureView.this.vFg.reset();
                VideoPlayerTextureView.this.vET = i3;
                VideoPlayerTextureView.this.mVideoWidth = i;
                VideoPlayerTextureView.this.mVideoHeight = i2;
                VideoPlayerTextureView.f(VideoPlayerTextureView.this);
                if (VideoPlayerTextureView.this.qAJ != null) {
                    VideoPlayerTextureView.this.qAJ.cl(VideoPlayerTextureView.this.mVideoWidth, VideoPlayerTextureView.this.mVideoHeight);
                }
            }
        };
        this.vFf = new SurfaceTextureListener() {
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                x.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(surfaceTexture.hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(VideoPlayerTextureView.this.vFc));
                try {
                    VideoPlayerTextureView.this.cqy();
                    VideoPlayerTextureView.this.mSurface = new Surface(surfaceTexture);
                    if (VideoPlayerTextureView.this.vES == null || !VideoPlayerTextureView.this.HE) {
                        VideoPlayerTextureView.this.aKo();
                    } else {
                        i iVar = VideoPlayerTextureView.this.vES;
                        Surface surface = VideoPlayerTextureView.this.mSurface;
                        if (surface != null) {
                            x.i("MicroMsg.VideoPlayerImpl", "%s change surface[%d] ", iVar.ovB.ovj.atw(), Integer.valueOf(surface.hashCode()));
                            k kVar = r0.ovK;
                            x.i("MicroMsg.VideoTrackDataSource", "%s set out put surface", kVar.atw());
                            kVar.aeI = surface;
                            if (com.tencent.mm.compatible.util.d.fN(23)) {
                                kVar.bat();
                            } else {
                                kVar.bau();
                            }
                        }
                        if (VideoPlayerTextureView.this.vFc) {
                            VideoPlayerTextureView.this.vES.start();
                        } else {
                            VideoPlayerTextureView.this.vFd = true;
                            VideoPlayerTextureView.this.vEV = 0;
                            VideoPlayerTextureView.this.vES.setMute(true);
                            VideoPlayerTextureView.this.vES.start();
                        }
                        VideoPlayerTextureView.this.vFc = false;
                    }
                    VideoPlayerTextureView.f(VideoPlayerTextureView.this);
                    if (VideoPlayerTextureView.this.vFa != null) {
                        VideoPlayerTextureView.this.vFa.TP();
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.VideoPlayerTextureView", e, "onSurfaceTextureAvailable failed", new Object[0]);
                }
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                x.d("MicroMsg.VideoPlayerTextureView", "surface[%d] size changed [%d, %d]", Integer.valueOf(surfaceTexture.hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
                VideoPlayerTextureView.f(VideoPlayerTextureView.this);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                x.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] destroyed", Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(surfaceTexture.hashCode()));
                VideoPlayerTextureView.this.mSurface = null;
                VideoPlayerTextureView.this.vFc = false;
                VideoPlayerTextureView.this.vFd = false;
                if (VideoPlayerTextureView.this.vES == null) {
                    VideoPlayerTextureView.this.vFc = false;
                } else if (VideoPlayerTextureView.this.isPlaying()) {
                    VideoPlayerTextureView.this.vFc = true;
                    VideoPlayerTextureView.this.vES.pause();
                }
                return false;
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                if (VideoPlayerTextureView.this.vFd && VideoPlayerTextureView.this.vEV > 0) {
                    VideoPlayerTextureView.this.vES.pause();
                    VideoPlayerTextureView.this.vES.setMute(VideoPlayerTextureView.this.kYN);
                    VideoPlayerTextureView.this.vFd = false;
                }
                if (VideoPlayerTextureView.this.vEV > 0 && VideoPlayerTextureView.this.vEY != null) {
                    x.i("MicroMsg.VideoPlayerTextureView", "%d notify surface update", Integer.valueOf(VideoPlayerTextureView.this.hashCode()));
                    VideoPlayerTextureView.this.vEY.bcn();
                    VideoPlayerTextureView.this.vEY = null;
                }
                VideoPlayerTextureView.this.vEV = System.currentTimeMillis();
            }
        };
        this.vFg = new o();
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

    public final void a(f.b bVar) {
    }

    public final void a(d dVar) {
        this.vFa = dVar;
    }

    public final void gD(boolean z) {
        this.ove = z;
        if (this.vES != null) {
            this.vES.gD(z);
        }
    }

    public final void gE(boolean z) {
        this.ovf = z;
        if (this.vES != null) {
            this.vES.gE(z);
        }
    }

    public final boolean isPlaying() {
        if (this.vES != null) {
            return this.vES.isPlaying();
        }
        return false;
    }

    public final boolean cdv() {
        if (this.mSurface == null || this.vFd) {
            return false;
        }
        return true;
    }

    public void setVideoPath(String str) {
        x.i("MicroMsg.VideoPlayerTextureView", "%d set video path [%s]", Integer.valueOf(hashCode()), str);
        this.path = str;
        aKo();
        requestLayout();
    }

    public final String Uy() {
        return this.path;
    }

    public boolean start() {
        String str;
        String str2;
        Object[] objArr;
        if (this.vES == null || !this.HE) {
            boolean z;
            str = "MicroMsg.VideoPlayerTextureView";
            str2 = "%d player is null[%b] or it prepared [%b]";
            objArr = new Object[3];
            objArr[0] = Integer.valueOf(hashCode());
            if (this.vES == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Boolean.valueOf(this.HE);
            x.w(str, str2, objArr);
            return false;
        }
        str = "MicroMsg.VideoPlayerTextureView";
        str2 = "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]";
        objArr = new Object[4];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Boolean.valueOf(this.vFd);
        objArr[2] = Boolean.valueOf(this.vFc);
        objArr[3] = Boolean.valueOf(this.mSurface != null);
        x.i(str, str2, objArr);
        if (this.mSurface == null) {
            this.vFc = true;
            return true;
        } else if (this.vFd) {
            this.vFc = true;
            this.vFd = false;
            setMute(this.kYN);
            return true;
        } else {
            this.vES.start();
            return true;
        }
    }

    public final boolean k(Context context, boolean z) {
        return start();
    }

    public void stop() {
        x.i("MicroMsg.VideoPlayerTextureView", "%d player stop [%s]", Integer.valueOf(hashCode()), bi.chl());
        if (this.vES != null) {
            this.vES.ovC = null;
            this.vES.ovB.stop();
            this.vES.release();
            this.vES = null;
        }
        this.vET = 0;
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.vFg.reset();
        this.HE = false;
        this.path = null;
        this.vEV = 0;
    }

    public void pause() {
        if (this.vES != null && this.vES.isPlaying()) {
            this.vES.pause();
        }
        this.vFc = false;
    }

    public final void onDetach() {
    }

    public final void cR(boolean z) {
    }

    public final void a(a aVar) {
        this.qAJ = aVar;
    }

    public final int getCurrentPosition() {
        if (this.vES != null) {
            return this.vES.baq();
        }
        return 0;
    }

    public final int getDuration() {
        if (this.vES != null) {
            return (int) this.vES.ovB.aqA;
        }
        return 0;
    }

    public final double btQ() {
        return 0.0d;
    }

    public void q(double d) {
        if (this.vES != null) {
            this.vES.sV((int) d);
        }
    }

    public final void c(double d, boolean z) {
        this.vEU = z;
        q(d);
    }

    public final void ii(boolean z) {
    }

    public final long btR() {
        return this.vEV;
    }

    public final void cdw() {
        this.vEW = true;
        this.vFg.vEW = this.vEW;
    }

    public void setMute(boolean z) {
        this.kYN = z;
        if (this.vES != null) {
            x.i("MicroMsg.VideoPlayerTextureView", "%d set mute [%b]", Integer.valueOf(hashCode()), Boolean.valueOf(z));
            this.vES.setMute(z);
        }
    }

    public void aKo() {
        x.i("MicroMsg.VideoPlayerTextureView", "%d open video [%s]", Integer.valueOf(hashCode()), this.path);
        if (this.vES != null) {
            this.vES.ovC = null;
            this.vES.ovB.stop();
            this.vES.release();
            this.vES = null;
        }
        if (bi.oN(this.path) || this.mSurface == null) {
            x.w("MicroMsg.VideoPlayerTextureView", "%d open video but path is null or mSurface is null", Integer.valueOf(hashCode()));
            return;
        }
        try {
            this.HE = false;
            this.vES = new i(Looper.getMainLooper());
            this.vES.setPath(this.path);
            this.vES.a(this.ovm);
            this.vES.gD(this.ove);
            this.vES.gE(this.ovf);
            this.vES.ovC = this.vFe;
            this.vES.setSurface(this.mSurface);
            this.vES.gC(this.vFb);
            if (this.mSurface != null) {
                this.vES.bap();
            } else if (this.vEX) {
                this.vES.bap();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoPlayerTextureView", e, "prepare async error %s", e.getMessage());
            if (this.qAJ != null) {
                this.qAJ.onError(-1, -1);
            }
        }
    }

    public final void bas() {
        if (this.vES != null && this.HE && this.mSurface != null) {
            x.i("MicroMsg.VideoPlayerTextureView", "%d flush surface start ", Integer.valueOf(hashCode()));
            i iVar = this.vES;
            if (iVar.ovB != null) {
                iVar.ovB.bas();
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.mVideoWidth == 0 || this.mVideoHeight == 0) {
            setMeasuredDimension(1, 1);
            return;
        }
        this.vFg.u(getDefaultSize(1, i), getDefaultSize(1, i2), this.mVideoWidth, this.mVideoHeight);
        int i3 = this.vFg.vFG;
        int i4 = this.vFg.vFH;
        if (this.vET == 90 || this.vET == 270) {
            Matrix matrix = new Matrix();
            matrix.set(getMatrix());
            float f = ((float) i3) / 2.0f;
            float f2 = ((float) i4) / 2.0f;
            float f3 = ((float) i4) / ((float) i3);
            if (!(getScaleX() == 1.0f && getScaleY() == 1.0f)) {
                matrix.setScale(getScaleX(), getScaleY(), f, f2);
            }
            matrix.postRotate((float) this.vET, f, f2);
            matrix.postScale(1.0f / f3, f3, f, f2);
            setTransform(matrix);
        }
        setMeasuredDimension(i3, i4);
    }
}
