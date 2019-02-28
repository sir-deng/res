package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.f.a.rv;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a {
    private static HashMap<String, WeakReference<Bitmap>> qzM = new HashMap();
    private static Map<String, Integer> qzQ = new ConcurrentHashMap();
    private boolean hNJ;
    private ag lKV;
    private Surface mSurface;
    boolean nJb;
    private int position;
    private Animation qzA;
    private Animation qzB;
    boolean qzK;
    public boolean qzL;
    public boolean qzN;
    double qzO;
    boolean qzP;
    double qzR;
    private boolean qzS;
    boolean qzT;
    private int qzn;
    private int qzo;
    String qzp;
    String qzq;
    int qzr;
    protected int qzs;
    private Bitmap qzt;
    private Bitmap qzu;
    private Bitmap qzv;
    private WeakReference<View> qzw;
    private WeakReference<TextView> qzx;
    private long qzy;
    private WeakReference<View> qzz;
    volatile h rsd;
    private volatile b rse;
    volatile i rsf;
    private volatile c rsg;
    private k rsh;
    private j rsi;
    private d rsj;
    private a rsk;
    e rsl;
    f rsm;
    private g rsn;

    /* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ double qzZ;

        AnonymousClass2(double d) {
            this.qzZ = d;
        }

        public final void run() {
            x.i("MicroMsg.SightPlayController", "SeekToFrame   %f  %s", Double.valueOf(this.qzZ), bi.chl().toString());
            a.this.qzR = this.qzZ;
        }
    }

    private class c implements Runnable {
        volatile boolean ozn = false;
        int qAf;
        b rsr;

        public c() {
            x.i("MicroMsg.SightPlayController", "make sure drawJob alive");
        }

        public final void run() {
            if (this.ozn) {
                x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", Integer.valueOf(a.this.hashCode()), Integer.valueOf(hashCode()));
                return;
            }
            a.this.D(a.this.qzt);
            if (a.this.qzy == 0) {
                o.c(this.rsr, 0);
                return;
            }
            long currentTimeMillis = ((long) a.this.qzs) - (System.currentTimeMillis() - a.this.qzy);
            if (currentTimeMillis > 0) {
                o.c(this.rsr, currentTimeMillis);
            } else {
                o.c(this.rsr, 0);
            }
        }
    }

    private class d implements Runnable {
        private d() {
        }

        /* synthetic */ d(a aVar, byte b) {
            this();
        }

        public final void run() {
            if (a.this.qzz.get() != null) {
                ((View) a.this.qzz.get()).startAnimation(a.this.qzA);
            }
        }
    }

    public interface e {
        void xt(int i);
    }

    public interface f {
        void eK(long j);
    }

    private class h implements Runnable {
        volatile boolean ozn;

        private h() {
            this.ozn = false;
        }

        /* synthetic */ h(a aVar, byte b) {
            this();
        }

        public final void run() {
            if (a.this.btv()) {
                x.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
                return;
            }
            a.this.qzr = SightVideoJNI.openFile(a.this.qzp, 1 == a.this.qzo ? 0 : 1, 1, false);
            if (a.this.qzr < 0) {
                x.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", Integer.valueOf(hashCode()), Integer.valueOf(a.this.hashCode()), Integer.valueOf(a.this.qzr), a.this.qzp);
                a.this.byh();
                if (a.this.rsl != null) {
                    a.this.rsl.xt(-1);
                    return;
                }
                return;
            }
            if (((Boolean) AdLandingPagesProxy.getInstance().getCfg(344065, Boolean.valueOf(false))).booleanValue()) {
                if (a.this.rsi == null) {
                    a.this.rsi = new j(a.this, (byte) 0);
                }
                a.this.lKV.removeCallbacks(a.this.rsi);
                a.this.lKV.post(a.this.rsi);
            }
            int max = Math.max(1, SightVideoJNI.getVideoWidth(a.this.qzr));
            int max2 = Math.max(1, SightVideoJNI.getVideoHeight(a.this.qzr));
            if (a.this.qzo == 0) {
                if (max * max2 >= 1048576 || max <= 0 || max2 <= 0) {
                    x.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", Integer.valueOf(max), Integer.valueOf(max2));
                    return;
                }
                a.a(a.this, max, max2);
            }
            a.this.btw();
            if (Float.compare(((float) max) / ((float) max2), 5.0f) > 0 || Float.compare(((float) max2) / ((float) max), 5.0f) > 0) {
                x.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", Integer.valueOf(max), Integer.valueOf(max2));
                if (!bi.oN(a.this.qzp)) {
                    a.qzQ.put(a.this.qzp, Integer.valueOf(2));
                }
                a.this.qzy = 0;
                a.this.wC(a.this.qzr);
                a.this.qzr = -1;
                a.this.qzp = "";
                a.this.qzq = "ERROR#PATH";
                a.this.qzv = null;
                this.ozn = true;
                if (a.this.rsl != null) {
                    a.this.rsl.xt(-1);
                    return;
                }
                return;
            }
            a.this.cl(max, max2);
            if (1 == a.this.qzo) {
                a.this.rse = new b(a.this, (byte) 0);
                a.this.rsg = null;
                if (!this.ozn) {
                    o.c(a.this.rse, 0);
                }
            } else {
                a.this.rse = new b(a.this, (byte) 0);
                a.this.rsg = new c();
                a.this.rse.rsp = a.this.rsg;
                a.this.rsg.rsr = a.this.rse;
                if (!this.ozn) {
                    o.c(a.this.rse, 0);
                }
            }
            if (this.ozn) {
                x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", Integer.valueOf(a.this.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.ozn));
            }
        }
    }

    private static class a extends com.tencent.mm.sdk.b.c<rv> {
        int mxY = 0;
        int qAa = 0;
        int qAb = 0;
        WeakReference<a> qAc;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b r9) {
            /*
            r8 = this;
            r7 = 2;
            r6 = 1;
            r5 = 0;
            r9 = (com.tencent.mm.f.a.rv) r9;
            r0 = r8.qAc;
            r0 = r0.get();
            if (r0 == 0) goto L_0x0082;
        L_0x000d:
            r1 = "MicroMsg.SightPlayController";
            r2 = "#0x%x on chatting status callback, type %d, selfPos %d, visiblePos[%d, %d], headerCount %d recording %B";
            r0 = 7;
            r3 = new java.lang.Object[r0];
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.hashCode();
            r0 = java.lang.Integer.valueOf(r0);
            r3[r5] = r0;
            r0 = r9.fKt;
            r0 = r0.type;
            r0 = java.lang.Integer.valueOf(r0);
            r3[r6] = r0;
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.position;
            r0 = java.lang.Integer.valueOf(r0);
            r3[r7] = r0;
            r0 = 3;
            r4 = r9.fKt;
            r4 = r4.fKu;
            r4 = java.lang.Integer.valueOf(r4);
            r3[r0] = r4;
            r0 = 4;
            r4 = r9.fKt;
            r4 = r4.fKv;
            r4 = java.lang.Integer.valueOf(r4);
            r3[r0] = r4;
            r0 = 5;
            r4 = r9.fKt;
            r4 = r4.fKw;
            r4 = java.lang.Integer.valueOf(r4);
            r3[r0] = r4;
            r4 = 6;
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.qzT;
            r0 = java.lang.Boolean.valueOf(r0);
            r3[r4] = r0;
            com.tencent.mm.sdk.platformtools.x.d(r1, r2, r3);
            r0 = r9.fKt;
            r0 = r0.type;
            switch(r0) {
                case 0: goto L_0x00bf;
                case 1: goto L_0x009a;
                case 2: goto L_0x0082;
                case 3: goto L_0x0083;
                case 4: goto L_0x0082;
                case 5: goto L_0x00e2;
                case 6: goto L_0x008f;
                case 7: goto L_0x00a6;
                default: goto L_0x0082;
            };
        L_0x0082:
            return r5;
        L_0x0083:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0.clear();
            goto L_0x0082;
        L_0x008f:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0.qzT = r6;
        L_0x009a:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0.ie(r5);
            goto L_0x0082;
        L_0x00a6:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.qzT;
            if (r0 == 0) goto L_0x0082;
        L_0x00b4:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0.qzT = r5;
        L_0x00bf:
            r8.a(r9);
            r0 = r8.btA();
            if (r0 == 0) goto L_0x0082;
        L_0x00c8:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.qzT;
            if (r0 != 0) goto L_0x0082;
        L_0x00d6:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0.restart();
            goto L_0x0082;
        L_0x00e2:
            r8.a(r9);
            r0 = r8.btA();
            if (r0 == 0) goto L_0x01a4;
        L_0x00eb:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.qzT;
            if (r0 != 0) goto L_0x01a4;
        L_0x00f9:
            r1 = "ERROR#PATH";
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.qzq;
            r0 = r1.equals(r0);
            if (r0 != 0) goto L_0x0189;
        L_0x010e:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r1 = r0.qzp;
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.qzq;
            r0 = r1.equals(r0);
            if (r0 != 0) goto L_0x0189;
        L_0x012c:
            r1 = "MicroMsg.SightPlayController";
            r2 = "match diff path, change %s to %s";
            r3 = new java.lang.Object[r7];
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.qzp;
            r3[r5] = r0;
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.qzq;
            r3[r6] = r0;
            com.tencent.mm.sdk.platformtools.x.d(r1, r2, r3);
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.qzq;
            if (r0 != 0) goto L_0x0196;
        L_0x0161:
            r0 = "";
            r1 = r0;
        L_0x0165:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0.clear();
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0.qzp = r1;
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r1 = "ERROR#PATH";
            r0.qzq = r1;
        L_0x0189:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0.restart();
            goto L_0x0082;
        L_0x0196:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0 = r0.qzq;
            r1 = r0;
            goto L_0x0165;
        L_0x01a4:
            r0 = r8.qAc;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a) r0;
            r0.clear();
            goto L_0x0082;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.a.a(com.tencent.mm.sdk.b.b):boolean");
        }

        public a(a aVar) {
            super(0);
            this.qAc = new WeakReference(aVar);
            this.xmG = rv.class.getName().hashCode();
        }

        private void a(rv rvVar) {
            this.qAa = rvVar.fKt.fKw;
            this.qAb = rvVar.fKt.fKu;
            this.mxY = rvVar.fKt.fKv;
        }

        private boolean btA() {
            if (this.qAc.get() == null) {
                return false;
            }
            int D = ((a) this.qAc.get()).position + this.qAa;
            if (D < this.qAb || D > this.mxY) {
                return false;
            }
            return true;
        }
    }

    private class j implements Runnable {
        private j() {
        }

        /* synthetic */ j(a aVar, byte b) {
            this();
        }

        public final void run() {
            if (a.this.qzr >= 0 && a.this.qzx != null && a.this.qzx.get() != null) {
                ((TextView) a.this.qzx.get()).setText(SightVideoJNI.getVideoInfo(a.this.qzr));
            }
        }
    }

    public interface g {
        int btB();

        View btC();

        int btD();
    }

    private class b implements Runnable {
        volatile boolean ozn;
        c rsp;

        private b() {
            this.ozn = false;
        }

        /* synthetic */ b(a aVar, byte b) {
            this();
        }

        public final void run() {
            if (!(a.this.rsn == null || a.this.rsn.btC() == null || a.this.rsn.btC().getVisibility() != 0)) {
                a.this.lKV.post(new Runnable() {
                    public final void run() {
                        a.this.rsn.btC().setVisibility(8);
                    }
                });
            }
            if (a.this.qzr < 0) {
                x.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", Integer.valueOf(a.this.hashCode()), Integer.valueOf(hashCode()), a.this.qzp);
            } else if (this.ozn) {
                x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", Integer.valueOf(a.this.hashCode()), Integer.valueOf(hashCode()));
            } else {
                float f;
                double btE;
                if (a.this.qzy == 0) {
                    if (a.this.rsf != null) {
                        a.this.rsf.type = 1;
                        a.this.rsf.run();
                    }
                    a.this.qzy = System.currentTimeMillis();
                }
                Object obj = null;
                if (a.this.qzR != -1.0d) {
                    if (a.this.qzL) {
                        if (a.this.rsf != null) {
                            a.this.rsf.type = 4;
                            a.this.rsf.qzR = a.this.qzR;
                            a.this.rsf.run();
                            a.this.lKV.postDelayed(new Runnable() {
                                public final void run() {
                                    a.this.qzS = true;
                                }
                            }, 100);
                        } else if (SightVideoJNI.seekStream(a.this.qzR, a.this.qzr) > 0) {
                            if (a.this.rsf == null) {
                                a.this.rsf = new i(a.this, (byte) 0);
                            }
                            a.this.rsf.type = 4;
                            a.this.rsf.qzR = a.this.qzR;
                            a.this.rsf.run();
                            obj = 1;
                        }
                    } else if (SightVideoJNI.seekStream(a.this.qzR, a.this.qzr) > 0) {
                        if (a.this.rsf == null) {
                            a.this.rsf = new i(a.this, (byte) 0);
                        }
                        a.this.rsf.type = 4;
                        a.this.rsf.qzR = a.this.qzR;
                        a.this.rsf.run();
                        obj = 1;
                    }
                }
                float currentTimeMillis = (float) (System.currentTimeMillis() - a.this.qzy);
                if (obj != null) {
                    f = 0.0f;
                } else {
                    f = (currentTimeMillis / ((float) a.this.qzs)) + 0.5f;
                }
                if (a.this.qzL && a.this.qzS) {
                    a.this.qzS = false;
                    if (a.this.rsf != null) {
                        btE = a.this.rsf.btE() / 1000.0d;
                        if (SightVideoJNI.seekStream(btE, a.this.qzr) > 0) {
                            f = 0.0f;
                            x.i("MicroMsg.SightPlayController", "seek to " + btE + " modify time : 0.0");
                        }
                    }
                }
                float f2 = f;
                if (a.this.hNJ) {
                    x.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", Integer.valueOf(a.this.hashCode()), Integer.valueOf(a.this.qzr), Float.valueOf(currentTimeMillis), Float.valueOf(f2));
                }
                a.this.qzy = System.currentTimeMillis();
                if (f2 >= 2.0f) {
                    a.this.qzn = a.this.qzn + 1;
                } else {
                    a.this.qzn = Math.max(0, a.this.qzn - 1);
                }
                if (a.this.btv()) {
                    x.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", Integer.valueOf(a.this.qzn));
                    a.this.clear();
                    return;
                }
                int i;
                Object obj2 = null;
                int i2 = 0;
                if (1 == a.this.qzo) {
                    Object obj3;
                    if (a.this.mSurface == null || a.this.mSurface.isValid()) {
                        i2 = SightVideoJNI.drawSurfaceFrame(a.this.qzr, a.this.mSurface, (int) f2, a.this.qzu, a.this.nJb);
                        if (a.this.rsm != null) {
                            btE = SightVideoJNI.getVideoPlayTime(a.this.qzr);
                            i = (int) btE;
                            if (i != ((int) a.this.qzO)) {
                                a.this.rsm.eK((long) i);
                            }
                            a.this.qzO = btE;
                        }
                        if (i2 == 0) {
                            a.this.qzR = -1.0d;
                            obj3 = null;
                        } else if (1 == i2) {
                            a.this.qzR = -1.0d;
                            obj3 = 1;
                            a.this.qzy = 0;
                            a.A(a.this);
                        } else if (-7 == i2) {
                            x.w("MicroMsg.SightPlayController", "surface is null, continue");
                            obj3 = null;
                        } else {
                            x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", Integer.valueOf(a.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                            this.ozn = true;
                            if (this.rsp != null) {
                                this.rsp.ozn = true;
                            }
                            a.this.byh();
                            if (a.this.rsl != null) {
                                a.this.rsl.xt(-1);
                            }
                            obj3 = null;
                        }
                    } else {
                        x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", Integer.valueOf(a.this.hashCode()), Integer.valueOf(hashCode()));
                        this.ozn = true;
                        if (this.rsp != null) {
                            this.rsp.ozn = true;
                            obj3 = null;
                        }
                        obj3 = null;
                    }
                    if (a.this.rsf != null) {
                        x.d("MicroMsg.SightPlayController", "voice time is" + (a.this.rsf.btE() / 1000.0d));
                        obj2 = obj3;
                    } else {
                        obj2 = obj3;
                    }
                } else {
                    i2 = SightVideoJNI.drawFrame(a.this.qzr, a.this.qzt, (int) f2, null, false, a.this.nJb);
                    if (a.this.rsm != null) {
                        btE = SightVideoJNI.getVideoPlayTime(a.this.qzr);
                        i = (int) btE;
                        if (i != ((int) a.this.qzO)) {
                            a.this.rsm.eK((long) i);
                        }
                        a.this.qzO = btE;
                        if (a.this.hNJ) {
                            x.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", Integer.valueOf(a.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(btE));
                        }
                    } else if (a.this.hNJ) {
                        btE = SightVideoJNI.getVideoPlayTime(a.this.qzr);
                        if (a.this.hNJ) {
                            x.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", Integer.valueOf(a.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(btE));
                        }
                    } else if (a.this.hNJ) {
                        x.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", Integer.valueOf(a.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                    }
                    if (i2 == 0) {
                        a.this.qzR = -1.0d;
                    } else if (1 == i2) {
                        a.this.qzR = -1.0d;
                        obj2 = 1;
                        a.this.qzy = 0;
                        a.A(a.this);
                    } else {
                        a.this.qzR = -1.0d;
                        x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", Integer.valueOf(a.this.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                        this.ozn = true;
                        if (this.rsp != null) {
                            this.rsp.ozn = true;
                        }
                        a.this.lKV.post(new Runnable() {
                            public final void run() {
                                a.this.D(null);
                            }
                        });
                        if (a.this.rsl != null) {
                            a.this.rsl.xt(-1);
                        }
                    }
                }
                if (1 == i2) {
                    a.this.lKV.post(new Runnable() {
                        public final void run() {
                            if (a.this.rsl != null) {
                                a.this.rsl.xt(0);
                            }
                        }
                    });
                }
                if (this.ozn) {
                    x.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", Integer.valueOf(a.this.hashCode()), Integer.valueOf(hashCode()));
                    if (a.this.rsf != null) {
                        a.this.rsf.type = 0;
                        a.this.rsf.run();
                        return;
                    }
                    return;
                }
                if (1 == a.this.qzo) {
                    long currentTimeMillis2 = ((long) a.this.qzs) - (System.currentTimeMillis() - a.this.qzy);
                    if (a.this.qzy == 0) {
                        o.c(this, (long) (a.this.qzs * 5));
                    } else if (currentTimeMillis2 > 0) {
                        o.c(this, currentTimeMillis2);
                    } else {
                        o.c(this, 0);
                    }
                } else if (obj2 == null || a.this.rsn == null) {
                    this.rsp.qAf = i2;
                    a.this.lKV.post(this.rsp);
                } else {
                    i = a.this.rsn.btB();
                    a.this.lKV.post(new Runnable() {
                        public final void run() {
                            if (a.this.rsn != null) {
                                View btC = a.this.rsn.btC();
                                if (btC != null) {
                                    if (!(a.this.qzB != null || a.this.rsn.btD() == -1 || a.this.qzz.get() == null)) {
                                        a.this.qzB = AnimationUtils.loadAnimation(((View) a.this.qzz.get()).getContext(), a.this.rsn.btD());
                                    }
                                    if (a.this.qzB != null) {
                                        btC.startAnimation(a.this.qzB);
                                    }
                                    btC.setVisibility(0);
                                }
                            }
                        }
                    });
                    this.rsp.qAf = i2;
                    a.this.lKV.postDelayed(this.rsp, (long) i);
                }
                if (a.this.rsf != null) {
                    x.d("MicroMsg.SightPlayController", "voice time is" + (a.this.rsf.btE() / 1000.0d));
                }
            }
        }
    }

    private class i implements Runnable {
        MediaPlayer qAh;
        double qzR;
        int type;

        private i() {
            this.qzR = -1.0d;
        }

        /* synthetic */ i(a aVar, byte b) {
            this();
        }

        private void bdS() {
            x.i("MicroMsg.SightPlayController", "stopPlayer");
            try {
                if (this.qAh != null) {
                    this.qAh.stop();
                    this.qAh.release();
                    this.qAh = null;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SightPlayController", e, "stop play sound error: %s", e.getMessage());
                this.qAh = null;
            }
        }

        public final double btE() {
            if (this.qAh == null) {
                return 0.0d;
            }
            return (double) this.qAh.getCurrentPosition();
        }

        public final void run() {
            String str;
            String str2 = "MicroMsg.SightPlayController";
            String str3 = "do play sound, operation %s";
            Object[] objArr = new Object[1];
            switch (this.type) {
                case 0:
                    str = "stop";
                    break;
                case 1:
                    str = "start";
                    break;
                case 2:
                    str = "pause";
                    break;
                case 3:
                    str = "resume";
                    break;
                case 4:
                    str = "seek";
                    break;
                default:
                    str = "unknown";
                    break;
            }
            objArr[0] = str;
            x.i(str2, str3, objArr);
            switch (this.type) {
                case 0:
                    bdS();
                    return;
                case 1:
                    bdS();
                    if (!bi.oN(a.this.qzp)) {
                        try {
                            this.qAh = new com.tencent.mm.compatible.b.j();
                            this.qAh.setDisplay(null);
                            this.qAh.reset();
                            this.qAh.setDataSource(a.this.qzp);
                            this.qAh.setAudioStreamType(3);
                            this.qAh.setOnErrorListener(new OnErrorListener() {
                                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                    x.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", a.this.qzp, Integer.valueOf(i), Integer.valueOf(i2));
                                    a.this.clear();
                                    if (a.this.rsl != null) {
                                        a.this.rsl.xt(-1);
                                    }
                                    return true;
                                }
                            });
                            this.qAh.prepare();
                            this.qAh.start();
                            return;
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.SightPlayController", e, "play sound error: %s", e.getMessage());
                            x.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", a.this.qzp);
                            a.this.clear();
                            if (a.this.rsl != null) {
                                a.this.rsl.xt(-1);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                case 2:
                    try {
                        if (this.qAh != null && this.qAh.isPlaying()) {
                            this.qAh.pause();
                            return;
                        }
                        return;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.SightPlayController", e2, "pause sound error: %s", e2.getMessage());
                        bdS();
                        return;
                    }
                case 3:
                    try {
                        if (this.qAh != null) {
                            this.qAh.start();
                            return;
                        }
                        return;
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.SightPlayController", e22, "pause sound error: %s", e22.getMessage());
                        bdS();
                        return;
                    }
                case 4:
                    try {
                        x.i("MicroMsg.SightPlayController", "soundplayer seek %f", Double.valueOf(this.qzR));
                        this.qAh.seekTo((int) (this.qzR * 1000.0d));
                        return;
                    } catch (Throwable e222) {
                        x.printErrStackTrace("MicroMsg.SightPlayController", e222, "seek sound error: %s", e222.getMessage());
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private class k implements Runnable {
        WeakReference<Bitmap> qAj;

        private k() {
            this.qAj = new WeakReference(null);
        }

        /* synthetic */ k(a aVar, byte b) {
            this();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r10 = this;
            r1 = 0;
            r2 = 1;
            r3 = 0;
            r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.mSurface;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x0017;
        L_0x000b:
            r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.mSurface;	 Catch:{ Exception -> 0x00df }
            r0 = r0.isValid();	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x020a;
        L_0x0017:
            r4 = "MicroMsg.SightPlayController";
            r5 = "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B";
            r0 = 6;
            r6 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00df }
            r0 = 0;
            r7 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r7 = r7.hashCode();	 Catch:{ Exception -> 0x00df }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x00df }
            r6[r0] = r7;	 Catch:{ Exception -> 0x00df }
            r0 = 1;
            r7 = r10.hashCode();	 Catch:{ Exception -> 0x00df }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x00df }
            r6[r0] = r7;	 Catch:{ Exception -> 0x00df }
            r7 = 2;
            r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.mSurface;	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x00c9;
        L_0x0041:
            r0 = r2;
        L_0x0042:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00df }
            r7 = 3;
            r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzw;	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x00cc;
        L_0x0051:
            r0 = r2;
        L_0x0052:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00df }
            r7 = 4;
            r0 = r10.qAj;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x00ce;
        L_0x0061:
            r0 = r2;
        L_0x0062:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00df }
            r7 = 5;
            r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzu;	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x00d0;
        L_0x0071:
            r0 = r2;
        L_0x0072:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.x.w(r4, r5, r6);	 Catch:{ Exception -> 0x00df }
            r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzu;	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x00ec;
        L_0x0083:
            r0 = r10.qAj;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00df }
            r4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r4 = r4.qzw;	 Catch:{ Exception -> 0x00df }
            if (r4 == 0) goto L_0x009f;
        L_0x0093:
            r1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r1 = r1.qzw;	 Catch:{ Exception -> 0x00df }
            r1 = r1.get();	 Catch:{ Exception -> 0x00df }
            r1 = (android.view.View) r1;	 Catch:{ Exception -> 0x00df }
        L_0x009f:
            if (r1 == 0) goto L_0x00a9;
        L_0x00a1:
            if (r0 == 0) goto L_0x00a9;
        L_0x00a3:
            r4 = r0.isRecycled();	 Catch:{ Exception -> 0x00df }
            if (r4 == 0) goto L_0x00d6;
        L_0x00a9:
            r4 = "MicroMsg.SightPlayController";
            r5 = "bgView:%B, thumb:%B";
            r6 = 2;
            r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00df }
            r7 = 0;
            if (r1 != 0) goto L_0x00d2;
        L_0x00b5:
            r1 = r2;
        L_0x00b6:
            r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r1;	 Catch:{ Exception -> 0x00df }
            r1 = 1;
            if (r0 != 0) goto L_0x00d4;
        L_0x00bf:
            r0 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x00df }
            r6[r1] = r0;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.x.e(r4, r5, r6);	 Catch:{ Exception -> 0x00df }
        L_0x00c8:
            return;
        L_0x00c9:
            r0 = r3;
            goto L_0x0042;
        L_0x00cc:
            r0 = r3;
            goto L_0x0052;
        L_0x00ce:
            r0 = r3;
            goto L_0x0062;
        L_0x00d0:
            r0 = r3;
            goto L_0x0072;
        L_0x00d2:
            r1 = r3;
            goto L_0x00b6;
        L_0x00d4:
            r2 = r3;
            goto L_0x00bf;
        L_0x00d6:
            r2 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a$k$1;	 Catch:{ Exception -> 0x00df }
            r2.<init>(r1, r0);	 Catch:{ Exception -> 0x00df }
            r1.post(r2);	 Catch:{ Exception -> 0x00df }
            goto L_0x00c8;
        L_0x00df:
            r0 = move-exception;
            r1 = "MicroMsg.SightPlayController";
            r2 = "";
            r3 = new java.lang.Object[r3];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);
            goto L_0x00c8;
        L_0x00ec:
            r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzv;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x0120;
        L_0x00f4:
            r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzv;	 Catch:{ Exception -> 0x00df }
            r0 = r0.getWidth();	 Catch:{ Exception -> 0x00df }
            r4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r4 = r4.qzu;	 Catch:{ Exception -> 0x00df }
            r4 = r4.getWidth();	 Catch:{ Exception -> 0x00df }
            if (r0 != r4) goto L_0x0120;
        L_0x010a:
            r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzv;	 Catch:{ Exception -> 0x00df }
            r0 = r0.getHeight();	 Catch:{ Exception -> 0x00df }
            r4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r4 = r4.qzu;	 Catch:{ Exception -> 0x00df }
            r4 = r4.getHeight();	 Catch:{ Exception -> 0x00df }
            if (r0 == r4) goto L_0x013f;
        L_0x0120:
            r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x018a }
            r4 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x018a }
            r4 = r4.qzu;	 Catch:{ Exception -> 0x018a }
            r4 = r4.getWidth();	 Catch:{ Exception -> 0x018a }
            r5 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x018a }
            r5 = r5.qzu;	 Catch:{ Exception -> 0x018a }
            r5 = r5.getHeight();	 Catch:{ Exception -> 0x018a }
            r6 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ Exception -> 0x018a }
            r4 = android.graphics.Bitmap.createBitmap(r4, r5, r6);	 Catch:{ Exception -> 0x018a }
            r0.qzv = r4;	 Catch:{ Exception -> 0x018a }
        L_0x013f:
            r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzv;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x015d;
        L_0x0147:
            r0 = r10.qAj;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x015d;
        L_0x014f:
            r0 = r10.qAj;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00df }
            r0 = r0.isRecycled();	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x01a9;
        L_0x015d:
            r1 = "MicroMsg.SightPlayController";
            r4 = "mThubmBgBmp:%B, thumbRef:%B";
            r0 = 2;
            r5 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00df }
            r6 = 0;
            r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzv;	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x01a5;
        L_0x016f:
            r0 = r2;
        L_0x0170:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r5[r6] = r0;	 Catch:{ Exception -> 0x00df }
            r0 = 1;
            r6 = r10.qAj;	 Catch:{ Exception -> 0x00df }
            r6 = r6.get();	 Catch:{ Exception -> 0x00df }
            if (r6 != 0) goto L_0x01a7;
        L_0x017f:
            r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x00df }
            r5[r0] = r2;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.x.e(r1, r4, r5);	 Catch:{ Exception -> 0x00df }
            goto L_0x00c8;
        L_0x018a:
            r0 = move-exception;
            r4 = "MicroMsg.SightPlayController";
            r5 = "try to create thumb bmp error:%s";
            r6 = 1;
            r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00df }
            r7 = 0;
            r8 = r0.getMessage();	 Catch:{ Exception -> 0x00df }
            r6[r7] = r8;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r0, r5, r6);	 Catch:{ Exception -> 0x00df }
            r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r4 = 0;
            r0.qzv = r4;	 Catch:{ Exception -> 0x00df }
            goto L_0x013f;
        L_0x01a5:
            r0 = r3;
            goto L_0x0170;
        L_0x01a7:
            r2 = r3;
            goto L_0x017f;
        L_0x01a9:
            r4 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x00df }
            r0 = r10.qAj;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00df }
            r2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r2 = r2.qzv;	 Catch:{ Exception -> 0x00df }
            r6 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r6 = r6.qzu;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.plugin.sight.base.SightVideoJNI.handleThumb(r0, r2, r6);	 Catch:{ Exception -> 0x00df }
            r0 = "MicroMsg.SightPlayController";
            r2 = "handle thumb use %d us";
            r6 = 1;
            r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00df }
            r7 = 0;
            r8 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x00df }
            r4 = r8 - r4;
            r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r4 = r4 / r8;
            r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r4;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.x.i(r0, r2, r6);	 Catch:{ Exception -> 0x00df }
            r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r2 = r0.qzv;	 Catch:{ Exception -> 0x00df }
            r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzw;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x0208;
        L_0x01ee:
            r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzw;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.view.View) r0;	 Catch:{ Exception -> 0x00df }
        L_0x01fa:
            if (r0 == 0) goto L_0x00c8;
        L_0x01fc:
            if (r2 == 0) goto L_0x00c8;
        L_0x01fe:
            r1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a$k$2;	 Catch:{ Exception -> 0x00df }
            r1.<init>(r0, r2);	 Catch:{ Exception -> 0x00df }
            r0.post(r1);	 Catch:{ Exception -> 0x00df }
            goto L_0x00c8;
        L_0x0208:
            r0 = r1;
            goto L_0x01fa;
        L_0x020a:
            r1 = "MicroMsg.SightPlayController";
            r4 = "#0x%x-#0x%x draw thumb, thumb empty ? %B";
            r0 = 3;
            r5 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00df }
            r0 = 0;
            r6 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r6 = r6.hashCode();	 Catch:{ Exception -> 0x00df }
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00df }
            r5[r0] = r6;	 Catch:{ Exception -> 0x00df }
            r0 = 1;
            r6 = r10.hashCode();	 Catch:{ Exception -> 0x00df }
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00df }
            r5[r0] = r6;	 Catch:{ Exception -> 0x00df }
            r6 = 2;
            r0 = r10.qAj;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x0270;
        L_0x0234:
            r0 = r2;
        L_0x0235:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r5[r6] = r0;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.x.d(r1, r4, r5);	 Catch:{ Exception -> 0x00df }
            r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzw;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x025c;
        L_0x0246:
            r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.qzw;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.view.View) r0;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x025c;
        L_0x0254:
            r1 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a$k$3;	 Catch:{ Exception -> 0x00df }
            r1.<init>(r0);	 Catch:{ Exception -> 0x00df }
            r0.post(r1);	 Catch:{ Exception -> 0x00df }
        L_0x025c:
            r0 = r10.qAj;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x0272;
        L_0x0264:
            r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.mSurface;	 Catch:{ Exception -> 0x00df }
            r1 = 0;
            com.tencent.mm.plugin.sight.base.SightVideoJNI.drawSurfaceColor(r0, r1);	 Catch:{ Exception -> 0x00df }
            goto L_0x00c8;
        L_0x0270:
            r0 = r3;
            goto L_0x0235;
        L_0x0272:
            r0 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r1 = r0.mSurface;	 Catch:{ Exception -> 0x00df }
            r0 = r10.qAj;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00df }
            r2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.this;	 Catch:{ Exception -> 0x00df }
            r2 = r2.qzu;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.plugin.sight.base.SightVideoJNI.drawSurfaceThumb(r1, r0, r2);	 Catch:{ Exception -> 0x00df }
            goto L_0x00c8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.a.k.run():void");
        }
    }

    public abstract void D(Bitmap bitmap);

    public abstract void cl(int i, int i2);

    static /* synthetic */ void A(a aVar) {
        if (aVar.qzz != null && -1 != aVar.btt()) {
            if (aVar.qzA == null && aVar.qzz.get() != null) {
                aVar.qzA = AnimationUtils.loadAnimation(((View) aVar.qzz.get()).getContext(), aVar.btt());
            }
            if (aVar.rsj == null) {
                aVar.rsj = new d(aVar, (byte) 0);
            }
            aVar.lKV.post(aVar.rsj);
        }
    }

    static /* synthetic */ void a(a aVar, int i, int i2) {
        x.d("MicroMsg.SightPlayController", "#0x%x check bmp, video width %d, height %d", Integer.valueOf(aVar.hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        if (aVar.qzt == null) {
            aVar.qzt = com.tencent.mm.memory.o.hbY.a(new com.tencent.mm.memory.o.b(i, i2));
            x.j("MicroMsg.SightPlayController", "checkBmp, create new one, videoPath: %s", aVar.qzp);
        } else if (aVar.qzt.getWidth() != i || aVar.qzt.getHeight() != i2) {
            int i3;
            x.w("MicroMsg.SightPlayController", "reset bmp, old value " + aVar.qzt.getWidth() + "*" + aVar.qzt.getHeight());
            if (!com.tencent.mm.compatible.util.d.fN(19) || aVar.qzt.getAllocationByteCount() < (i2 * i) * 4) {
                i3 = 0;
            } else {
                try {
                    x.w("MicroMsg.SightPlayController", "reset bmp, try directly reconfigure");
                    aVar.qzt.reconfigure(i, i2, Config.ARGB_8888);
                    i3 = 1;
                } catch (Exception e) {
                    x.e("MicroMsg.SightPlayController", "reconfigure failed: %s" + e.getMessage());
                    i3 = 0;
                }
            }
            if (i3 == 0) {
                com.tencent.mm.memory.o.hbY.g(aVar.qzt);
                aVar.qzt = com.tencent.mm.memory.o.hbY.a(new com.tencent.mm.memory.o.b(i, i2));
            }
            x.j("MicroMsg.SightPlayController", "checkBmp, the origin bmp size not match, create new one, videoPath: %s", aVar.qzp);
        }
    }

    public a(int i, View view) {
        this.hNJ = false;
        this.qzn = 0;
        this.qzo = 0;
        this.qzp = "";
        this.qzq = "";
        this.qzr = -1;
        this.qzs = 41;
        this.qzK = true;
        this.qzL = false;
        this.qzN = false;
        this.nJb = true;
        this.qzO = -1.0d;
        this.qzP = false;
        this.qzR = -1.0d;
        this.qzS = false;
        this.qzT = false;
        this.qzo = 0;
        this.lKV = new ag(Looper.getMainLooper());
        this.qzz = new WeakReference(view);
        x.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", Integer.valueOf(0));
    }

    protected int btt() {
        return -1;
    }

    public final void ie(boolean z) {
        if (this.rsd != null) {
            o.k(this.rsd);
            this.rsd.ozn = true;
        }
        if (this.rsg != null) {
            this.lKV.removeCallbacks(this.rsg);
            this.rsg.ozn = true;
        }
        if (this.rse != null) {
            o.k(this.rse);
            this.rse.ozn = true;
        }
        if (this.rsf != null) {
            this.rsf.type = z ? 0 : 2;
            o.c(this.rsf, 0);
        }
    }

    public final boolean btu() {
        if (1 == this.qzo) {
            if (this.rse == null || this.rse.ozn) {
                return false;
            }
            return true;
        } else if (this.rsg == null || this.rsg.ozn || this.rse == null || this.rse.ozn) {
            return false;
        } else {
            return true;
        }
    }

    public final void restart() {
        x.i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", Integer.valueOf(hashCode()), Boolean.valueOf(this.qzK), this.qzp, Integer.valueOf(this.qzr));
        if (!this.qzK) {
            clear();
        } else if (btu()) {
            x.w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", Integer.valueOf(hashCode()), this.qzp);
        } else {
            boolean z;
            if (this.qzr < 0) {
                z = true;
            } else {
                z = false;
            }
            ie(z);
            this.qzy = 0;
            if (btv()) {
                x.e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", Integer.valueOf(hashCode()));
            } else if (this.qzr < 0) {
                x.w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", Integer.valueOf(hashCode()), this.qzp);
                if (!bi.oN(this.qzp)) {
                    if (JY(this.qzp)) {
                        this.rsd = new h();
                        o.c(this.rsd, 0);
                        return;
                    }
                    x.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                    clear();
                }
            } else if (1 == this.qzo) {
                this.rse = new b();
                this.rsg = null;
                o.c(this.rse, 0);
            } else {
                this.rse = new b();
                this.rsg = new c();
                this.rse.rsp = this.rsg;
                this.rsg.rsr = this.rse;
                o.c(this.rse, 0);
            }
        }
    }

    public final void clear() {
        x.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", Integer.valueOf(hashCode()), Integer.valueOf(this.qzr), Boolean.valueOf(btu()));
        ie(true);
        this.qzy = 0;
        wC(this.qzr);
        this.qzr = -1;
        this.qzp = "";
        this.qzq = "ERROR#PATH";
        this.qzv = null;
        this.qzO = 0.0d;
        this.qzP = false;
        com.tencent.mm.memory.o.hbY.g(this.qzt);
        this.qzt = null;
    }

    private void wC(final int i) {
        o.c(new Runnable() {
            public final void run() {
                long currentTimeMillis = System.currentTimeMillis();
                SightVideoJNI.freeObj(i);
                x.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", Integer.valueOf(a.this.hashCode()), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        }, 0);
    }

    public static boolean JY(String str) {
        if (bi.oN(str)) {
            return false;
        }
        Integer num = (Integer) qzQ.get(str);
        if (num == null || 2 != num.intValue()) {
            return true;
        }
        return false;
    }

    final boolean btv() {
        if (this.qzN) {
            return false;
        }
        if (VERSION.SDK_INT >= 11) {
            if (this.qzn < 3) {
                return false;
            }
            x.v("MicroMsg.SightPlayController", "match not check bad fps, but now is bad fps");
            this.qzn = 0;
            return false;
        } else if (this.qzn >= 3) {
            return true;
        } else {
            return false;
        }
    }

    protected final void btw() {
        this.qzs = 1000 / Math.max(1, (int) SightVideoJNI.getVideoRate(this.qzr));
        x.d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", Integer.valueOf(hashCode()), Integer.valueOf(r0), Integer.valueOf(this.qzs));
    }

    public final void byh() {
        x.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", Boolean.valueOf(true));
        o.k(this.rsh);
        if (this.rsh == null) {
            this.rsh = new k();
        }
        this.rsh.qAj = new WeakReference(null);
        o.c(this.rsh, 0);
    }

    public final com.tencent.mm.sdk.b.c btx() {
        if (this.rsk == null) {
            this.rsk = new a(this);
        }
        return this.rsk;
    }
}
