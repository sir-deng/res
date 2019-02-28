package com.tencent.mm.plugin.music.model.g;

import com.tencent.mm.au.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

public abstract class b {
    protected a fBv;
    protected i oRL;
    protected j oRM = new j();

    public abstract void Ha(String str);

    public abstract boolean bfe();

    public abstract int bff();

    public abstract String bfg();

    public abstract int getDuration();

    public abstract boolean isPlaying();

    public abstract void pause();

    public abstract void play();

    public abstract void seek(long j);

    public abstract void stop();

    public final void a(i iVar) {
        this.oRL = iVar;
    }

    public final void m(a aVar) {
        this.fBv = aVar;
    }

    protected void ha(final boolean z) {
        if (this.oRL != null) {
            ah.y(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.Music.BasePlayer", "onError, needRetry:%b", Boolean.valueOf(z));
                    b.this.oRL.f(b.this.fBv, z);
                }
            });
        }
    }

    protected final void onStart() {
        if (this.oRL != null) {
            ah.y(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.Music.BasePlayer", "onStart %b", Boolean.valueOf(b.this.isPlaying()));
                    b.this.oRL.n(b.this.fBv);
                }
            });
        }
    }

    protected final void tX(final int i) {
        if (this.oRL != null) {
            ah.y(new Runnable() {
                public final void run() {
                    if (b.this.bfe()) {
                        b.this.oRL.o(b.this.fBv);
                    }
                }
            });
        }
    }

    protected void hb(final boolean z) {
        if (this.oRL != null) {
            ah.y(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.Music.BasePlayer", "onStop, isComplete:%b", Boolean.valueOf(z));
                    b.this.oRL.e(b.this.fBv, z);
                }
            });
        }
    }
}
