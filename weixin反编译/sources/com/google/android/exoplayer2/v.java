package com.google.android.exoplayer2;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.exoplayer2.a.b;
import com.google.android.exoplayer2.a.e;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.f.c;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.f;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

@TargetApi(16)
public final class v implements f {
    protected final r[] acF;
    private final f adh;
    private final a aeA = new a();
    final CopyOnWriteArraySet<Object> aeB = new CopyOnWriteArraySet();
    final CopyOnWriteArraySet<com.google.android.exoplayer2.f.j.a> aeC = new CopyOnWriteArraySet();
    public final CopyOnWriteArraySet<com.google.android.exoplayer2.metadata.e.a> aeD = new CopyOnWriteArraySet();
    private final int aeE;
    private final int aeF;
    Format aeG;
    Format aeH;
    Surface aeI;
    private boolean aeJ;
    private int aeK;
    private SurfaceHolder aeL;
    private TextureView aeM;
    public e aeN;
    com.google.android.exoplayer2.video.e aeO;
    d aeP;
    d aeQ;
    int aeR;
    private b aeS;
    private float aeT;

    private final class a implements Callback, SurfaceTextureListener, e, com.google.android.exoplayer2.f.j.a, com.google.android.exoplayer2.metadata.e.a, com.google.android.exoplayer2.video.e {
        private a() {
        }

        /* synthetic */ a(v vVar, byte b) {
            this();
        }

        public final void a(d dVar) {
            v.this.aeP = dVar;
            if (v.this.aeO != null) {
                v.this.aeO.a(dVar);
            }
        }

        public final void c(Format format) {
            v.this.aeG = format;
            if (v.this.aeO != null) {
                v.this.aeO.c(format);
            }
        }

        public final void a(int i, int i2, int i3, float f) {
            Iterator it = v.this.aeB.iterator();
            while (it.hasNext()) {
                it.next();
            }
            if (v.this.aeO != null) {
                v.this.aeO.a(i, i2, i3, f);
            }
        }

        public final void b(Surface surface) {
            if (v.this.aeI == surface) {
                Iterator it = v.this.aeB.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
            if (v.this.aeO != null) {
                v.this.aeO.b(surface);
            }
        }

        public final void b(d dVar) {
            if (v.this.aeO != null) {
                v.this.aeO.b(dVar);
            }
            v.this.aeG = null;
            v.this.aeP = null;
        }

        public final void c(d dVar) {
            v.this.aeQ = dVar;
            if (v.this.aeN != null) {
                v.this.aeN.c(dVar);
            }
        }

        public final void bW(int i) {
            v.this.aeR = i;
            if (v.this.aeN != null) {
                v.this.aeN.bW(i);
            }
        }

        public final void a(String str, long j, long j2) {
            if (v.this.aeN != null) {
                v.this.aeN.a(str, j, j2);
            }
        }

        public final void d(Format format) {
            v.this.aeH = format;
            if (v.this.aeN != null) {
                v.this.aeN.d(format);
            }
        }

        public final void c(int i, long j, long j2) {
            if (v.this.aeN != null) {
                v.this.aeN.c(i, j, j2);
            }
        }

        public final void d(d dVar) {
            if (v.this.aeN != null) {
                v.this.aeN.d(dVar);
            }
            v.this.aeH = null;
            v.this.aeQ = null;
            v.this.aeR = 0;
        }

        public final void i(List<com.google.android.exoplayer2.f.a> list) {
            Iterator it = v.this.aeC.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.f.j.a) it.next()).i(list);
            }
        }

        public final void a(Metadata metadata) {
            Iterator it = v.this.aeD.iterator();
            while (it.hasNext()) {
                ((com.google.android.exoplayer2.metadata.e.a) it.next()).a(metadata);
            }
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            v.a(v.this, surfaceHolder.getSurface(), false);
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            v.a(v.this, null, false);
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            v.a(v.this, new Surface(surfaceTexture), true);
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            v.a(v.this, null, true);
            return true;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    static /* synthetic */ void a(v vVar, Surface surface, boolean z) {
        c[] cVarArr = new c[vVar.aeE];
        r[] rVarArr = vVar.acF;
        int length = rVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            f.b bVar = rVarArr[i];
            if (bVar.getTrackType() == 2) {
                i3 = i2 + 1;
                cVarArr[i2] = new c(bVar, surface);
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (vVar.aeI == null || vVar.aeI == surface) {
            vVar.adh.a(cVarArr);
        } else {
            vVar.adh.b(cVarArr);
            if (vVar.aeJ) {
                vVar.aeI.release();
            }
        }
        vVar.aeI = surface;
        vVar.aeJ = z;
    }

    protected v(u uVar, g gVar, m mVar) {
        this.acF = uVar.a(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), this.aeA, this.aeA, this.aeA, this.aeA);
        int i = 0;
        int i2 = 0;
        for (r trackType : this.acF) {
            switch (trackType.getTrackType()) {
                case 1:
                    i++;
                    break;
                case 2:
                    i2++;
                    break;
                default:
                    break;
            }
        }
        this.aeE = i2;
        this.aeF = i;
        this.aeT = 1.0f;
        this.aeR = 0;
        this.aeS = b.aft;
        this.aeK = 1;
        this.adh = new h(this.acF, gVar, mVar);
    }

    public final void a(com.google.android.exoplayer2.q.a aVar) {
        this.adh.a(aVar);
    }

    public final void b(com.google.android.exoplayer2.q.a aVar) {
        this.adh.b(aVar);
    }

    public final int ib() {
        return this.adh.ib();
    }

    public final void a(f fVar) {
        this.adh.a(fVar);
    }

    public final void af(boolean z) {
        this.adh.af(z);
    }

    public final boolean ic() {
        return this.adh.ic();
    }

    public final boolean id() {
        return this.adh.id();
    }

    public final void seekTo(long j) {
        this.adh.seekTo(j);
    }

    public final void stop() {
        this.adh.stop();
    }

    public final void release() {
        this.adh.release();
        if (this.aeM != null) {
            if (this.aeM.getSurfaceTextureListener() == this.aeA) {
                this.aeM.setSurfaceTextureListener(null);
            }
            this.aeM = null;
        }
        if (this.aeL != null) {
            this.aeL.removeCallback(this.aeA);
            this.aeL = null;
        }
        if (this.aeI != null) {
            if (this.aeJ) {
                this.aeI.release();
            }
            this.aeI = null;
        }
    }

    public final void a(c... cVarArr) {
        this.adh.a(cVarArr);
    }

    public final void b(c... cVarArr) {
        this.adh.b(cVarArr);
    }

    public final long getDuration() {
        return this.adh.getDuration();
    }

    public final long getCurrentPosition() {
        return this.adh.getCurrentPosition();
    }

    public final long getBufferedPosition() {
        return this.adh.getBufferedPosition();
    }

    public final int getBufferedPercentage() {
        return this.adh.getBufferedPercentage();
    }
}
