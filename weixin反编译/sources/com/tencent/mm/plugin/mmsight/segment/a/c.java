package com.tencent.mm.plugin.mmsight.segment.a;

import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.segment.a.a.b;
import com.tencent.mm.plugin.mmsight.segment.a.a.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements a {
    private al hJi;
    public a oFA;
    int oFQ;
    int oFR;
    private a oFX;
    private HandlerThread oFY = e.dc("check auto job", 10);
    com.tencent.mm.plugin.mmsight.segment.a.a.c oFZ = null;
    private com.tencent.mm.plugin.mmsight.segment.a.a.c oGa = new com.tencent.mm.plugin.mmsight.segment.a.a.c() {
        public final void bA(Object obj) {
            if (c.this.oFZ != null) {
                c.this.oFZ.bA(obj);
            }
        }
    };
    private com.tencent.mm.sdk.platformtools.al.a oGb = new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            if (c.this.released) {
                return false;
            }
            try {
                if (!c.this.isPlaying()) {
                    return true;
                }
                int currentPosition = c.this.getCurrentPosition();
                if (c.this.oFA != null) {
                    c.this.oFA.tp(currentPosition);
                }
                x.d("MicroMsg.SectionRepeatMediaPlayer", "position[%d] repeat[%d, %d] duration[%d]", Integer.valueOf(currentPosition), Integer.valueOf(c.this.oFQ), Integer.valueOf(c.this.oFR), Integer.valueOf(c.this.getDuration()));
                if (currentPosition < c.this.oFR) {
                    return true;
                }
                x.i("MicroMsg.SectionRepeatMediaPlayer", "reach repeat end time, seek to %s", Integer.valueOf(c.this.oFR));
                c.this.seekTo(c.this.oFQ);
                return false;
            } catch (IllegalStateException e) {
                x.e("MicroMsg.SectionRepeatMediaPlayer", "MediaPlayer may be released. %s", e.getMessage());
                if (c.this.released) {
                    return false;
                }
                return true;
            }
        }
    };
    boolean released;

    public interface a {
        void tp(int i);
    }

    public c() {
        int i = CaptureMMProxy.getInstance().getInt(com.tencent.mm.storage.w.a.USERINFO_LOCAL_SIGHT_CLIP_PREVIEW_MEDIA_PLAYER_INT_SYNC, -1);
        if (i == 1) {
            x.i("MicroMsg.SectionRepeatMediaPlayer", "used system media player");
            this.oFX = new d();
        } else if (i == 2) {
            x.i("MicroMsg.SectionRepeatMediaPlayer", "used mm video player");
            this.oFX = new b();
        } else if (CaptureMMProxy.getInstance().checkUseMMVideoPlayer()) {
            x.i("MicroMsg.SectionRepeatMediaPlayer", "default used mm video player");
            this.oFX = new b();
        } else {
            x.i("MicroMsg.SectionRepeatMediaPlayer", "default used system media player");
            this.oFX = new d();
        }
        this.oFY.start();
        this.hJi = new al(this.oFY.getLooper(), this.oGb, true);
    }

    public final void setLoop(int i, int i2) {
        this.oFQ = i;
        this.oFR = i2;
        if (this.oFX != null) {
            this.oFX.setLoop(this.oFQ, this.oFR);
        }
    }

    public final void setDataSource(String str) {
        this.oFX.setDataSource(str);
    }

    public final void release() {
        this.released = true;
        this.oFX.release();
        if (this.hJi != null) {
            this.hJi.TN();
        }
        if (this.oFY != null) {
            this.oFY.quit();
        }
    }

    public final void start() {
        this.oFX.start();
        this.hJi.K(30, 30);
    }

    public final void pause() {
        this.oFX.pause();
        this.hJi.TN();
    }

    public final void stop() {
        this.oFX.stop();
        this.hJi.TN();
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.a.a.c cVar) {
        this.oFX.a(cVar);
    }

    public final void setAudioStreamType(int i) {
        this.oFX.setAudioStreamType(i);
    }

    public final int getCurrentPosition() {
        return this.oFX.getCurrentPosition();
    }

    public final int getDuration() {
        if (this.oFX != null) {
            return this.oFX.getDuration();
        }
        return 0;
    }

    public final void setSurface(Surface surface) {
        this.oFX.setSurface(surface);
    }

    public final boolean isPlaying() {
        return this.oFX.isPlaying();
    }

    public final void seekTo(int i) {
        this.oFX.seekTo(i);
    }

    public final void prepareAsync() {
        this.oFX.prepareAsync();
    }

    public final void setLooping(boolean z) {
        this.oFX.setLooping(z);
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.a.a.a aVar) {
        this.oFX.a(aVar);
    }

    public final void a(d dVar) {
        this.oFX.a(dVar);
    }

    public final void a(b bVar) {
        this.oFX.a(bVar);
    }
}
