package com.tencent.mm.ui.video;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
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
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public class VideoView extends SurfaceView {
    public OnCompletionListener hYO;
    public OnErrorListener hYP;
    private Context mContext;
    private int mDuration;
    private int mVideoHeight;
    private int mVideoWidth;
    public MediaPlayer qDR;
    private SurfaceHolder sfU;
    public String vFp;
    public boolean vFq;
    public boolean vFr;
    OnVideoSizeChangedListener vFs;
    OnPreparedListener vFt;
    private OnCompletionListener vFu;
    private OnErrorListener vFv;
    Callback vFw;
    private int zzp;
    private int zzq;
    public OnPreparedListener zzr;
    private int zzs;
    public int zzt;
    private OnBufferingUpdateListener zzu;

    public final void czp() {
        if (this.mVideoHeight != 0 && this.mVideoWidth != 0) {
            int i;
            int i2 = this.mVideoWidth;
            int i3 = this.mVideoHeight;
            x.v("MicroMsg.VideoView", "video size before:" + i2 + "   " + i3);
            x.v("MicroMsg.VideoView", "layout size before:" + getWidth() + "   " + getHeight());
            int width = getWidth();
            int height = getHeight();
            if (width <= 0) {
                i = i2;
            } else {
                i = width;
            }
            if (height <= 0) {
                width = i3;
            } else {
                width = height;
            }
            float f = (((float) i) * 1.0f) / ((float) i2);
            float f2 = (((float) width) * 1.0f) / ((float) i3);
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            if (f > f2) {
                layoutParams.width = (int) (((float) i2) * f2);
                layoutParams.height = width;
            } else {
                layoutParams.width = i;
                layoutParams.height = (int) (((float) i3) * f);
            }
            layoutParams.addRule(13);
            setLayoutParams(layoutParams);
            invalidate();
            x.v("MicroMsg.VideoView", "video size after:" + this.qDR.getVideoWidth() + "   " + this.qDR.getVideoHeight());
            x.v("MicroMsg.VideoView", "layout size after:" + layoutParams.width + "   " + layoutParams.height);
        }
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.mContext = context;
        czq();
    }

    public VideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sfU = null;
        this.qDR = null;
        this.vFs = new OnVideoSizeChangedListener() {
            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                VideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                VideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                x.v("MicroMsg.VideoView", "on size change size:( " + VideoView.this.mVideoWidth + " , " + VideoView.this.mVideoHeight + " )");
                VideoView.this.czp();
            }
        };
        this.vFt = new OnPreparedListener() {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onPrepared(android.media.MediaPlayer r3) {
                /*
                r2 = this;
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0.vFq = true;
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0 = r0.zzr;
                if (r0 == 0) goto L_0x001c;
            L_0x000d:
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0 = r0.zzr;
                r1 = com.tencent.mm.ui.video.VideoView.this;
                r1 = r1.qDR;
                r0.onPrepared(r1);
            L_0x001c:
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r1 = r3.getVideoWidth();
                r0.mVideoWidth = r1;
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r1 = r3.getVideoHeight();
                r0.mVideoHeight = r1;
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0.czp();
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0 = r0.mVideoWidth;
                if (r0 == 0) goto L_0x00c7;
            L_0x003b:
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0 = r0.mVideoHeight;
                if (r0 == 0) goto L_0x00c7;
            L_0x0043:
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0 = r0.vFr;
                if (r0 == 0) goto L_0x0059;
            L_0x004b:
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0 = r0.qDR;
                r0.start();
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0.vFr = false;
            L_0x0059:
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0 = r0.zzp;
                r1 = com.tencent.mm.ui.video.VideoView.this;
                r1 = r1.mVideoWidth;
                if (r0 != r1) goto L_0x00bb;
            L_0x0067:
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0 = r0.zzq;
                r1 = com.tencent.mm.ui.video.VideoView.this;
                r1 = r1.mVideoHeight;
                if (r0 != r1) goto L_0x00bb;
            L_0x0075:
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0 = r0.zzt;
                if (r0 == 0) goto L_0x0091;
            L_0x007d:
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0 = r0.qDR;
                r1 = com.tencent.mm.ui.video.VideoView.this;
                r1 = r1.zzt;
                r0.seekTo(r1);
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0.zzt = 0;
            L_0x0091:
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0 = r0.vFr;
                if (r0 != 0) goto L_0x00bb;
            L_0x0099:
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0 = r0.isPlaying();
                if (r0 != 0) goto L_0x00bb;
            L_0x00a1:
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0 = r0.zzt;
                if (r0 != 0) goto L_0x00bb;
            L_0x00a9:
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r1 = r0.qDR;
                if (r1 == 0) goto L_0x00c5;
            L_0x00af:
                r1 = r0.vFq;
                if (r1 == 0) goto L_0x00c5;
            L_0x00b3:
                r0 = r0.qDR;
                r0 = r0.getCurrentPosition();
            L_0x00b9:
                if (r0 <= 0) goto L_0x00bb;
            L_0x00bb:
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0 = r0.qDR;
                r0.isPlaying();
                return;
            L_0x00c5:
                r0 = 0;
                goto L_0x00b9;
            L_0x00c7:
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0 = r0.zzt;
                if (r0 == 0) goto L_0x00e3;
            L_0x00cf:
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0 = r0.qDR;
                r1 = com.tencent.mm.ui.video.VideoView.this;
                r1 = r1.zzt;
                r0.seekTo(r1);
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0.zzt = 0;
            L_0x00e3:
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0 = r0.vFr;
                if (r0 == 0) goto L_0x00bb;
            L_0x00eb:
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0 = r0.qDR;
                r0.start();
                r0 = com.tencent.mm.ui.video.VideoView.this;
                r0.vFr = false;
                goto L_0x00bb;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.video.VideoView.2.onPrepared(android.media.MediaPlayer):void");
            }
        };
        this.vFu = new OnCompletionListener() {
            public final void onCompletion(MediaPlayer mediaPlayer) {
                if (VideoView.this.hYO != null) {
                    VideoView.this.hYO.onCompletion(VideoView.this.qDR);
                }
            }
        };
        this.vFv = new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                x.d("MicroMsg.VideoView", "Error: " + i + "," + i2);
                if (VideoView.this.hYP == null || !VideoView.this.hYP.onError(VideoView.this.qDR, i, i2)) {
                    VideoView.this.getWindowToken();
                }
                return true;
            }
        };
        this.zzu = new OnBufferingUpdateListener() {
            public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                VideoView.this.zzs = i;
            }
        };
        this.vFw = new Callback() {
            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                VideoView.this.zzp = i2;
                VideoView.this.zzq = i3;
                if (VideoView.this.qDR != null && VideoView.this.vFq && VideoView.this.mVideoWidth == i2 && VideoView.this.mVideoHeight == i3) {
                    if (VideoView.this.zzt != 0) {
                        VideoView.this.qDR.seekTo(VideoView.this.zzt);
                        VideoView.this.zzt = 0;
                    }
                    VideoView.this.qDR.start();
                }
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoView.this.sfU = surfaceHolder;
                VideoView.this.aKo();
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoView.this.sfU = null;
                if (VideoView.this.qDR != null) {
                    VideoView.this.qDR.reset();
                    VideoView.this.qDR.release();
                    VideoView.this.qDR = null;
                }
            }
        };
        this.mContext = context;
        czq();
    }

    private void czq() {
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.vFw);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
    }

    public final void stopPlayback() {
        if (this.qDR != null) {
            this.qDR.stop();
            this.qDR.release();
            this.qDR = null;
        }
    }

    public final void aKo() {
        if (this.vFp != null && this.sfU != null) {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            this.mContext.sendBroadcast(intent);
            if (this.qDR != null) {
                this.qDR.reset();
                this.qDR.release();
                this.qDR = null;
            }
            try {
                this.qDR = new j();
                this.qDR.setOnPreparedListener(this.vFt);
                this.qDR.setOnVideoSizeChangedListener(this.vFs);
                this.vFq = false;
                x.v("MicroMsg.VideoView", "reset duration to -1 in openVideo");
                this.mDuration = -1;
                this.qDR.setOnCompletionListener(this.vFu);
                this.qDR.setOnErrorListener(this.vFv);
                this.qDR.setOnBufferingUpdateListener(this.zzu);
                this.zzs = 0;
                this.qDR.setDataSource(this.vFp);
                this.qDR.setDisplay(this.sfU);
                this.qDR.setAudioStreamType(3);
                this.qDR.setScreenOnWhilePlaying(true);
                this.qDR.prepareAsync();
                this.mVideoHeight = this.qDR.getVideoHeight();
                this.mVideoWidth = this.qDR.getVideoWidth();
            } catch (IOException e) {
            } catch (IllegalArgumentException e2) {
            }
        }
    }

    public final boolean isPlaying() {
        if (this.qDR == null || !this.vFq) {
            return false;
        }
        return this.qDR.isPlaying();
    }
}
