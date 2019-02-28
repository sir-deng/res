package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.game.GameGLSurfaceView.j;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends GameGLSurfaceView {
    e iuk;
    public b jaJ;
    private a jaK;
    private n jaL;
    private d jaM = new d();

    public interface a {
        void aem();
    }

    public interface b {
        void aec();
    }

    private static class d extends com.tencent.mm.plugin.appbrand.game.e.e<c> {
        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        protected final /* synthetic */ com.tencent.mm.plugin.appbrand.game.e.c aeo() {
            return aen();
        }

        protected final /* synthetic */ Object aep() {
            return aen();
        }

        private static c aen() {
            return new c();
        }
    }

    private static class c extends com.tencent.mm.plugin.appbrand.game.e.c {
        String jaO;
        com.tencent.mm.plugin.appbrand.g.b jaP;

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        protected final void execute() {
            this.jaP.evaluateJavascript(this.jaO, null);
        }
    }

    public k(Context context, e eVar, b bVar, a aVar) {
        super(context);
        x.i("MicroMsg.WAGameView", "new GameView");
        this.iuk = eVar;
        super.adL();
        this.iZC = 2;
        EGLConfigChooser bVar2 = new b(8, 8, 8, 8, 16, 8);
        super.adL();
        this.iZw = bVar2;
        this.iZD = true;
        this.jaJ = new b(this);
        this.jaJ.jal = bVar;
        this.jaK = aVar;
        j jVar = this.jaJ;
        super.adL();
        if (this.iZw == null) {
            this.iZw = new k();
        }
        if (this.iZx == null) {
            this.iZx = new c(this, (byte) 0);
        }
        if (this.iZy == null) {
            this.iZy = new d();
        }
        this.iZv = jVar;
        this.iZu = new g(this.iZt);
        this.iZu.start();
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                k.this.x(motionEvent);
                return true;
            }
        });
        if (h.rc(this.iuk.mAppId)) {
            postDelayed(new Runnable() {
                public final void run() {
                    if (k.this.jaJ != null && !k.this.jaJ.jai) {
                        k.this.jaJ.jai = true;
                        k.this.aem();
                    }
                }
            }, 30000);
        }
        this.jaL = new n(context.getResources().getDisplayMetrics().density) {
            public final StringBuilder e(StringBuilder stringBuilder) {
                return stringBuilder.append("__WxNativeHandler__.__triggerTouchEvent__(");
            }

            public final StringBuilder f(StringBuilder stringBuilder) {
                return stringBuilder.append(");");
            }
        };
    }

    final void aem() {
        x.i("MicroMsg.WAGameView", "hy: first rendered: %s ", this.iuk.mAppId);
        if (this.jaK != null) {
            this.jaK.aem();
            this.jaK = null;
        }
    }

    private boolean x(MotionEvent motionEvent) {
        StringBuilder stringBuilder = null;
        if (this.jaL == null || motionEvent == null || !this.jaJ.gUI) {
            return false;
        }
        n nVar = this.jaL;
        if (motionEvent != null) {
            int i;
            switch (motionEvent.getActionMasked()) {
                case 0:
                case 5:
                    i = 0;
                    break;
                case 1:
                case 6:
                    i = 2;
                    break;
                case 2:
                    i = 1;
                    break;
                case 3:
                    i = 3;
                    break;
                default:
                    i = -1;
                    break;
            }
            if (i != -1) {
                int i2;
                nVar.jfD.setLength(0);
                nVar.jfD = nVar.e(nVar.jfD);
                nVar.jfD.append("[[");
                int pointerCount = motionEvent.getPointerCount();
                for (i2 = 0; i2 < pointerCount; i2++) {
                    nVar.jfD.append(motionEvent.getPointerId(i2)).append(",").append(motionEvent.getX(i2) / nVar.jfC).append(",").append(motionEvent.getY(i2) / nVar.jfC).append(",").append(motionEvent.getPressure(i2));
                    if (i2 != pointerCount - 1) {
                        nVar.jfD.append(",");
                    }
                }
                nVar.jfD.append("],[");
                if (i == 1) {
                    for (i2 = 0; i2 < pointerCount; i2++) {
                        nVar.jfD.append(i2);
                        if (i2 != pointerCount - 1) {
                            nVar.jfD.append(",");
                        }
                    }
                } else {
                    nVar.jfD.append(motionEvent.getActionIndex());
                }
                nVar.jfD.append("],");
                nVar.jfD.append(motionEvent.getEventTime()).append(",");
                nVar.jfD.append(i).append("]");
                nVar.jfD = nVar.f(nVar.jfD);
                stringBuilder = nVar.jfD;
            }
        }
        if (stringBuilder == null || stringBuilder.length() == 0) {
            return false;
        }
        c cVar = (c) this.jaM.afk();
        cVar.jaO = stringBuilder.toString();
        cVar.jaP = this.iuk.isW.ium;
        queueEvent(cVar);
        return true;
    }
}
