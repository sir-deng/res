package com.tencent.mm.bn;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Looper;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.BuildConfig;
import com.tencent.mm.api.d;
import com.tencent.mm.api.e;
import com.tencent.mm.api.j;
import com.tencent.mm.api.l;
import com.tencent.mm.bi.a.h;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.a;
import com.tencent.mm.d.c;
import com.tencent.mm.d.c.AnonymousClass8;
import com.tencent.mm.d.f;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.view.footer.SelectColorBar;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class a implements b {
    com.tencent.mm.api.m.a fdS;
    com.tencent.mm.view.a vGI;
    HashMap<d, com.tencent.mm.d.b> vGJ;
    LinkedList<com.tencent.mm.d.b> vGK;
    private e vGL;
    Bitmap vGM;
    private boolean vGN = true;
    d vGO = d.DEFAULT;
    d vGP = d.DEFAULT;
    com.tencent.mm.d.b vGQ = null;

    class a implements com.tencent.mm.w.a {
        View vGU = a.this.vGI.cBa();
        TextView vGV = ((TextView) this.vGU.findViewById(com.tencent.mm.bi.a.e.vij));
        ImageView vGW = ((ImageView) this.vGU.findViewById(com.tencent.mm.bi.a.e.vii));

        a() {
        }

        public final void Q(float f) {
            x.i("MicroMsg.DrawingPresenter", "[onReach] distance:%s", Float.valueOf(f));
            this.vGV.setText(a.this.vGI.getContext().getString(h.viI));
            this.vGW.setImageResource(com.tencent.mm.bi.a.d.vig);
        }

        public final void Ew() {
            x.i("MicroMsg.DrawingPresenter", "[onUnReach]");
            this.vGW.setImageResource(com.tencent.mm.bi.a.d.vif);
            this.vGV.setText(a.this.vGI.getContext().getString(h.viJ));
        }

        public final void onShow() {
            a.a(a.this, true);
        }

        public final void onHide() {
            a.a(a.this, false);
        }

        public final void a(com.tencent.mm.s.e eVar) {
            EditText editText = (EditText) a.this.vGI.cAZ().findViewById(com.tencent.mm.bi.a.e.gYg);
            editText.setText(eVar.gPP);
            editText.setTextColor(eVar.su);
            editText.setTag(eVar);
            a.this.ly(true);
        }
    }

    class b implements Runnable {
        j vGX;
        boolean vGY;

        b(j jVar, boolean z) {
            this.vGX = jVar;
            this.vGY = z;
        }

        public final void run() {
            Iterator it;
            Iterator it2;
            try {
                Bitmap bitmap;
                if (Looper.myLooper() == null) {
                    Looper.prepare();
                }
                it = a.this.vGK.iterator();
                while (it.hasNext()) {
                    ((com.tencent.mm.d.b) it.next()).uM();
                }
                Bitmap bitmap2 = null;
                if (a.this.vGI.cAW().cBk()) {
                    bitmap = a.this.vGM;
                } else {
                    int width = a.this.vGI.cAW().cBl().width();
                    int height = a.this.vGI.cAW().cBl().height();
                    if (width > 0 && height > 0) {
                        bitmap2 = Bitmap.createBitmap(width, height, Config.ARGB_8888);
                    }
                    bitmap = bitmap2;
                }
                if (bitmap == null) {
                    this.vGX.b(new NullPointerException("bitmap is null!"));
                    try {
                        it2 = a.this.vGK.iterator();
                        while (it2.hasNext()) {
                            ((com.tencent.mm.d.b) it2.next()).onFinish();
                        }
                        a.this.onDestroy();
                        return;
                    } catch (Exception e) {
                        return;
                    }
                }
                Canvas canvas = new Canvas(bitmap);
                Iterator it3 = a.this.vGK.iterator();
                while (it3.hasNext()) {
                    ((com.tencent.mm.d.b) it3.next()).uJ().c(canvas);
                }
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(a.this.fdS.path, options);
                float height2 = (((float) options.outHeight) * 1.0f) / ((float) bitmap.getHeight());
                float width2 = (((float) options.outWidth) * 1.0f) / ((float) bitmap.getWidth());
                if (height2 <= width2) {
                    height2 = width2;
                }
                if (height2 == 0.0f) {
                    height2 = 1.0f;
                }
                float a = a.this.vGI.cAW().a(a.this.vGI.cAW().uS());
                Matrix matrix = new Matrix();
                matrix.postScale(height2, height2, 0.0f, 0.0f);
                matrix.postRotate(-a);
                Rect rect = new Rect(a.this.vGI.cAW().cBl());
                x.i("MicroMsg.DrawingPresenter", "[saveEditPhoto] clipRectF:%s w:%s h:%s", rect, Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()));
                if (rect.left < 0) {
                    rect.left = 0;
                }
                if (rect.top < 0) {
                    rect.top = 0;
                }
                if (rect.bottom < 0) {
                    rect.bottom = 0;
                }
                if (rect.right < 0) {
                    rect.right = 0;
                }
                if (rect.bottom > bitmap.getHeight()) {
                    rect.bottom = bitmap.getHeight();
                }
                if (rect.right > bitmap.getWidth()) {
                    rect.right = bitmap.getWidth();
                }
                this.vGX.a(a(bitmap, rect, a, options, matrix), this.vGY);
                try {
                    it2 = a.this.vGK.iterator();
                    while (it2.hasNext()) {
                        ((com.tencent.mm.d.b) it2.next()).onFinish();
                    }
                    a.this.onDestroy();
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                this.vGX.b(e3);
                try {
                    it2 = a.this.vGK.iterator();
                    while (it2.hasNext()) {
                        ((com.tencent.mm.d.b) it2.next()).onFinish();
                    }
                    a.this.onDestroy();
                } catch (Exception e4) {
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                try {
                    it = a.this.vGK.iterator();
                    while (it.hasNext()) {
                        ((com.tencent.mm.d.b) it.next()).onFinish();
                    }
                    a.this.onDestroy();
                } catch (Exception e5) {
                }
            }
        }

        private static Bitmap a(Bitmap bitmap, Rect rect, float f, Options options, Matrix matrix) {
            try {
                if (bitmap.getWidth() - rect.width() > 9 || bitmap.getHeight() - rect.height() > 9) {
                    return Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), matrix, true);
                }
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.DrawingPresenter", e, "", new Object[0]);
                float f2 = 1920.0f / ((float) options.outHeight);
                float f3 = 1920.0f / ((float) options.outWidth);
                if (f2 <= f3) {
                    f2 = f3;
                }
                matrix.reset();
                matrix.postScale(f2, f2, 0.0f, 0.0f);
                matrix.postRotate(-f);
                if (bitmap.getWidth() - rect.width() > 9 || bitmap.getHeight() - rect.height() > 9) {
                    return Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), matrix, true);
                }
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            }
        }
    }

    static /* synthetic */ void a(a aVar, boolean z) {
        Animation loadAnimation;
        if (z) {
            loadAnimation = AnimationUtils.loadAnimation(aVar.vGI.getContext(), com.tencent.mm.bi.a.a.bqo);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    a.this.vGI.cBa().setVisibility(0);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            aVar.vGI.cBa().startAnimation(loadAnimation);
            return;
        }
        aVar.vGI.cBa().setAlpha(0.82f);
        loadAnimation = AnimationUtils.loadAnimation(aVar.vGI.getContext(), com.tencent.mm.bi.a.a.bqm);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                a.this.vGI.cBa().setVisibility(8);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        aVar.vGI.cBa().startAnimation(loadAnimation);
    }

    public final void a(com.tencent.mm.view.a aVar) {
        this.vGI = aVar;
    }

    public final void a(com.tencent.mm.api.m.a aVar) {
        boolean z;
        this.fdS = aVar;
        this.vGJ = new HashMap();
        this.vGK = new LinkedList();
        String str = aVar.path;
        if (bi.oN(str) || !new File(str).exists()) {
            x.w("MicroMsg.DrawingPresenter", "[checkImage] path:%s", str);
            z = false;
        } else {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            if (options.outWidth <= 0 || options.outHeight <= 0) {
                x.e("MicroMsg.DrawingPresenter", "[checkImage] image err! w:%s h:%s path:%s", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), str);
                z = false;
            } else {
                z = true;
            }
        }
        if (z) {
            this.vGM = com.tencent.mm.sdk.platformtools.d.a(bi.aD(aVar.path, ""), (int) BuildConfig.VERSION_CODE, BuildConfig.VERSION_CODE, true, false, 0);
        }
        ceb();
    }

    public final d[] cdR() {
        return this.vGI.cdR();
    }

    public final l cdS() {
        return new l() {
            public final void a(d dVar) {
                x.i("MicroMsg.DrawingPresenter", "[onSelectedFeature] features:%s", dVar);
                if (a.this.vGI.fdI != null) {
                    a.this.vGI.fdI.a(dVar);
                }
                if (dVar == d.CROP_VIDEO) {
                    a.this.vGI.cAX().setVisibility(8);
                }
                com.tencent.mm.d.b bVar = (com.tencent.mm.d.b) a.this.vGJ.get(dVar);
                if (bVar != null) {
                    if (bVar.fis && !bVar.isAlive()) {
                        bVar.uK();
                    }
                    if (bVar.uH() != com.tencent.mm.d.a.DEFAULT) {
                        bVar.aL(false);
                    }
                    bVar.uL();
                    a.this.vGQ = bVar;
                    switch (AnonymousClass7.vGT[dVar.ordinal()]) {
                        case 1:
                            ((EditText) a.this.vGI.cAZ().findViewById(com.tencent.mm.bi.a.e.gYg)).setTextColor(com.tencent.mm.view.footer.a.zOu[0]);
                            a.this.ly(true);
                            a.this.vGI.aD(false);
                            break;
                        case 2:
                            a.this.vGI.aE(false);
                            a.this.vGI.aD(false);
                            a.this.vGI.nP(false);
                            break;
                        case 3:
                            a.this.vGO = a.this.vGP;
                            return;
                    }
                    a.this.vGP = dVar;
                }
            }

            public final void a(d dVar, int i) {
                x.i("MicroMsg.DrawingPresenter", "[onSelectedDetailFeature] features:%s index:%s", dVar, Integer.valueOf(i));
                if (a.this.vGI.fdI != null) {
                    a.this.vGI.fdI.a(dVar, i);
                }
                a.this.vGQ = (com.tencent.mm.d.b) a.this.vGJ.get(dVar);
                if (a.this.cdW().uH() != com.tencent.mm.d.a.DEFAULT) {
                    if (a.this.vGI.cAX().getVisibility() == 8) {
                        a.this.vGI.cAX().setVisibility(0);
                    }
                    switch (AnonymousClass7.vGT[dVar.ordinal()]) {
                        case 3:
                            c cVar = (c) a.this.cdW();
                            float width;
                            if (i == 0) {
                                cVar.fjc++;
                                cVar.fiM.cancel();
                                if (cVar.fja != null) {
                                    cVar.fja.cancel();
                                }
                                Matrix matrix = new Matrix();
                                matrix.postRotate(-90.0f, (float) cVar.fdj.centerX(), (float) cVar.fdj.centerY());
                                if (cVar.fjb.isEmpty()) {
                                    cVar.fjb.set(cVar.fdj);
                                }
                                RectF rectF = new RectF(cVar.fjb);
                                matrix.mapRect(rectF);
                                width = (1.0f * ((float) cVar.fiI.width())) / rectF.width();
                                float height = (1.0f * ((float) cVar.fiI.height())) / rectF.height();
                                if (width >= height) {
                                    width = height;
                                }
                                matrix.postScale(width, width, (float) cVar.fdj.centerX(), (float) cVar.fdj.centerY());
                                rectF.set(cVar.fjb);
                                matrix.mapRect(rectF);
                                cVar.fjb.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                                height = (float) cVar.fdj.centerX();
                                float centerY = (float) cVar.fdj.centerY();
                                PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("rotation", new int[]{0, -90});
                                PropertyValuesHolder ofInt2 = PropertyValuesHolder.ofInt("deltaX", new int[]{0, cVar.fiI.centerX() - ((int) height)});
                                PropertyValuesHolder ofInt3 = PropertyValuesHolder.ofInt("deltaY", new int[]{0, cVar.fiI.centerY() - ((int) centerY)});
                                ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt, ofInt2, ofInt3});
                                ofPropertyValuesHolder.addUpdateListener(new AnonymousClass8(height, centerY, width));
                                ofPropertyValuesHolder.addListener(new AnimatorListener() {
                                    public final void onAnimationStart(Animator animator) {
                                        c.this.fiK = false;
                                        c.this.fiS = true;
                                        c.this.fiL = true;
                                    }

                                    public final void onAnimationEnd(Animator animator) {
                                        x.i("MicroMsg.CropArtist", "onAnimationEnd");
                                        c.this.fjc = c.this.fjc - 1;
                                        if (c.this.fjc == 0) {
                                            c.this.fiL = false;
                                            RectF rectF = new RectF();
                                            rectF.set(c.this.fdj);
                                            c.this.fiD.mapRect(rectF);
                                            c.this.fiD.reset();
                                            c.this.fdj.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                                            c.this.uW();
                                        }
                                        c.a(c.this, 200, false, true);
                                    }

                                    public final void onAnimationCancel(Animator animator) {
                                    }

                                    public final void onAnimationRepeat(Animator animator) {
                                    }
                                });
                                ofPropertyValuesHolder.setDuration(200);
                                ofPropertyValuesHolder.start();
                                return;
                            } else if (1 == i) {
                                x.i("MicroMsg.CropArtist", "[cancel]");
                                cVar.fiM.cancel();
                                if (cVar.fja != null) {
                                    cVar.fja.cancel();
                                }
                                cVar.fio.cdU().cAW().zNL = cVar.fio.cdU().cAW().zNM;
                                com.tencent.mm.s.a xD = ((com.tencent.mm.cache.a) cVar.uJ()).xD();
                                width = 0.0f;
                                if (xD != null) {
                                    width = cVar.getRotation() - cVar.a(xD.mMatrix);
                                }
                                if (!(xD == null || xD.gPl.isEmpty())) {
                                    cVar.fio.cdU().cAW().l(xD.gPl);
                                }
                                cVar.fio.cdU().cAW().a(null, width, true);
                                cVar.fio.cdU().cAY().setVisibility(0);
                                a.this.vGQ = (com.tencent.mm.d.b) a.this.vGJ.get(a.this.vGO);
                                a.this.vGI.cAV().c(a.this.vGO);
                                return;
                            } else if (2 == i) {
                                x.i("MicroMsg.CropArtist", "[doCrop]");
                                if (cVar.fja != null) {
                                    cVar.fja.cancel();
                                }
                                if (cVar.fiM.fdr) {
                                    cVar.fiM.fdn = null;
                                    cVar.uY();
                                } else {
                                    if (!cVar.fiM.fds) {
                                        cVar.fiM.cancel();
                                        cVar.fiM.play();
                                    }
                                    cVar.fiM.fdn = new AnimatorListener() {
                                        public final void onAnimationStart(Animator animator) {
                                        }

                                        public final void onAnimationEnd(Animator animator) {
                                            c.this.fiM.fdn = null;
                                            c.this.uY();
                                        }

                                        public final void onAnimationCancel(Animator animator) {
                                            c.this.fiM.fdn = null;
                                        }

                                        public final void onAnimationRepeat(Animator animator) {
                                        }
                                    };
                                }
                                a.this.vGQ = (com.tencent.mm.d.b) a.this.vGJ.get(a.this.vGO);
                                a.this.vGI.cAV().c(a.this.vGO);
                                return;
                            } else if (3 == i) {
                                x.i("MicroMsg.CropArtist", "[reset]");
                                cVar.fjd = true;
                                cVar.fiM.cancel();
                                if (cVar.fja != null) {
                                    cVar.fja.cancel();
                                }
                                cVar.fjb.setEmpty();
                                cVar.uX();
                                cVar.fiS = false;
                                cVar.fio.cdU().cAW().zNL = cVar.fdj;
                                cVar.fio.cdU().cAW().a(new com.tencent.mm.view.b.a.b() {
                                    public final void uZ() {
                                        c.this.uS().set(((a) c.this.uJ()).gDe);
                                        c.this.uU();
                                        c.a(c.this, 300, false, false);
                                    }

                                    public final void onStart() {
                                        c.this.fiK = false;
                                    }
                                }, cVar.getRotation(), true);
                                return;
                            } else {
                                return;
                            }
                        case 4:
                            com.tencent.mm.d.d dVar2 = (com.tencent.mm.d.d) a.this.cdW();
                            if (i != -1) {
                                a.this.vGI.cAV();
                                dVar2.su = com.tencent.mm.view.footer.a.getColor(i);
                                return;
                            }
                            dVar2.uQ();
                            return;
                        case 5:
                            f fVar = (f) a.this.cdW();
                            if (i == 0) {
                                fVar.fjH = com.tencent.mm.s.d.a.gPI;
                                return;
                            } else if (1 == i) {
                                fVar.fjH = com.tencent.mm.s.d.a.gPJ;
                                return;
                            } else {
                                fVar.uQ();
                                return;
                            }
                        default:
                            return;
                    }
                }
            }

            public final void aF(boolean z) {
            }
        };
    }

    public final void a(e eVar) {
        this.vGL = eVar;
    }

    public final void aC(boolean z) {
        this.vGN = z;
    }

    public final void sX() {
        if (this.vGL != null) {
            this.vGL.sX();
        }
    }

    public final boolean sT() {
        if (this.vGI.cAZ().getVisibility() == 0) {
            ly(false);
            this.vGI.aD(true);
            return true;
        } else if (this.vGI.cBb() == null || this.vGI.cBb().getVisibility() != 0) {
            return false;
        } else {
            this.vGI.nP(true);
            this.vGI.aD(true);
            return true;
        }
    }

    public final void onFinish() {
        if (this.vGL != null) {
            this.vGL.onFinish();
        }
    }

    public final void a(Editable editable, int i) {
        ly(false);
        this.vGI.aD(true);
        com.tencent.mm.d.b cdW = cdW();
        if (cdW.uH() == com.tencent.mm.d.a.EMOJI_AND_TEXT) {
            com.tencent.mm.d.e eVar = (com.tencent.mm.d.e) cdW;
            EditText editText = (EditText) this.vGI.cAZ().findViewById(com.tencent.mm.bi.a.e.gYg);
            if (editText.getTag() == null || !(editText.getTag() instanceof com.tencent.mm.s.e)) {
                eVar.a(i.a(this.vGI.getContext(), (CharSequence) editable), i);
            } else {
                eVar.a((com.tencent.mm.s.e) editText.getTag(), i.a(this.vGI.getContext(), (CharSequence) editable), i);
            }
            editText.setTag(null);
        }
    }

    public final void cdT() {
        this.vGI.aD(true);
        ly(false);
    }

    public final com.tencent.mm.view.a cdU() {
        return this.vGI;
    }

    public final Context getContext() {
        return this.vGI.getContext();
    }

    public final com.tencent.mm.api.m.a cdV() {
        return this.fdS;
    }

    public final <T extends com.tencent.mm.d.b> T cdW() {
        if (this.vGQ != null) {
            return this.vGQ;
        }
        x.e("MicroMsg.DrawingPresenter", "[getCurArtist] is null!");
        return com.tencent.mm.d.b.fiu;
    }

    public final float cdX() {
        com.tencent.mm.view.b.a cAW = this.vGI.cAW();
        return cAW.cBk() ? cAW.gPs : 1.0f;
    }

    public final float cdY() {
        return this.vGI.cAW().cdY();
    }

    public final void a(j jVar, boolean z) {
        com.tencent.mm.sdk.f.e.post(new b(jVar, z), "onFinalGenerate");
    }

    public final void onDestroy() {
        Iterator it = this.vGK.iterator();
        while (it.hasNext()) {
            ((com.tencent.mm.d.b) it.next()).onDestroy();
        }
        this.vGK.clear();
        this.vGJ.clear();
    }

    public final void onAttachedToWindow() {
        x.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow]");
        Iterator it = this.vGK.iterator();
        while (it.hasNext()) {
            boolean z;
            com.tencent.mm.d.b bVar = (com.tencent.mm.d.b) it.next();
            ArtistCacheManager xB = ArtistCacheManager.xB();
            com.tencent.mm.d.a uH = bVar.uH();
            if (ArtistCacheManager.gCW.containsKey(xB.gCY) && ((a) ArtistCacheManager.gCW.get(xB.gCY)).gDb.containsKey(uH)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                bVar.uK();
                bVar.aK(true);
                x.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", bVar.uH());
            }
        }
        if (this.vGI.cAW().cBk()) {
            this.vGI.cAW().cBm();
            this.vGI.cAW().invalidate();
        }
    }

    public final Bitmap cdZ() {
        return this.vGM;
    }

    public final boolean cea() {
        return cdW().uH() != com.tencent.mm.d.a.CROP_PHOTO && this.vGN;
    }

    public final <T extends com.tencent.mm.d.b> T b(d dVar) {
        return (com.tencent.mm.d.b) this.vGJ.get(dVar);
    }

    public final void c(com.tencent.mm.api.i iVar) {
        ((com.tencent.mm.d.e) b(d.EMOJI)).b(iVar);
    }

    public final boolean H(MotionEvent motionEvent) {
        com.tencent.mm.d.b bVar;
        boolean z = false;
        if (!(cdW().uH() == com.tencent.mm.d.a.CROP_PHOTO || cdW().uH() == com.tencent.mm.d.a.CROP_VIDEO)) {
            bVar = null;
            if (this.vGJ.containsKey(d.TEXT)) {
                bVar = (com.tencent.mm.d.b) this.vGJ.get(d.TEXT);
            } else if (this.vGJ.containsKey(d.EMOJI)) {
                bVar = (com.tencent.mm.d.b) this.vGJ.get(d.EMOJI);
            }
            if (bVar != null) {
                z = bVar.q(motionEvent);
            }
            if (z) {
                this.vGQ = bVar;
            }
        }
        if (!z) {
            this.vGQ = (com.tencent.mm.d.b) this.vGJ.get(this.vGI.cAV().cBy());
            Iterator it = this.vGK.iterator();
            while (it.hasNext()) {
                bVar = (com.tencent.mm.d.b) it.next();
                if (bVar.uH() != com.tencent.mm.d.a.EMOJI_AND_TEXT && bVar.q(motionEvent)) {
                    return true;
                }
            }
        }
        return z;
    }

    public final void onDraw(Canvas canvas) {
        Iterator it = this.vGK.iterator();
        while (it.hasNext()) {
            com.tencent.mm.d.b bVar = (com.tencent.mm.d.b) it.next();
            if (bVar.isAlive()) {
                if (cdW().uH() == bVar.uH()) {
                    bVar.onDraw(canvas);
                } else {
                    canvas.save();
                    canvas.clipRect(this.vGI.cAW().cBl());
                    bVar.b(canvas);
                    canvas.restore();
                }
            }
        }
    }

    public final com.tencent.mm.cache.d a(com.tencent.mm.d.a aVar) {
        return ArtistCacheManager.xB().a(aVar);
    }

    private void ceb() {
        this.vGK.clear();
        this.vGJ.clear();
        this.vGJ.put(d.DEFAULT, com.tencent.mm.d.b.fiu);
        for (d dVar : this.vGI.cdR()) {
            com.tencent.mm.d.b bVar = null;
            switch (dVar) {
                case TEXT:
                case EMOJI:
                    int i;
                    Iterator it = this.vGK.iterator();
                    while (it.hasNext()) {
                        com.tencent.mm.d.b bVar2 = (com.tencent.mm.d.b) it.next();
                        if (bVar2.uH() == com.tencent.mm.d.a.EMOJI_AND_TEXT) {
                            bVar = bVar2;
                            i = 1;
                            if (i == 0) {
                                bVar = new com.tencent.mm.d.e();
                                ((com.tencent.mm.d.e) bVar).fjA = new a();
                                break;
                            }
                        }
                    }
                    i = 0;
                    if (i == 0) {
                        bVar = new com.tencent.mm.d.e();
                        ((com.tencent.mm.d.e) bVar).fjA = new a();
                    }
                    break;
                case CROP_PHOTO:
                    bVar = new c();
                    break;
                case DOODLE:
                    bVar = new com.tencent.mm.d.d();
                    break;
                case MOSAIC:
                    bVar = new f();
                    break;
            }
            if (bVar != null) {
                if (!this.vGJ.containsKey(dVar)) {
                    this.vGJ.put(dVar, bVar);
                }
                if (!this.vGK.contains(bVar)) {
                    this.vGK.add(bVar);
                    bVar.a(this, this.vGI.cAW().uS(), this.vGI.cAW().cBl());
                }
            }
        }
        Collections.sort(this.vGK, new Comparator<com.tencent.mm.d.b>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                return ((com.tencent.mm.d.b) obj).uH().value - ((com.tencent.mm.d.b) obj2).uH().value;
            }
        });
        x.i("MicroMsg.DrawingPresenter", "[addArtists] count:%s", Integer.valueOf(this.vGJ.size() - 1));
    }

    final void ly(boolean z) {
        Animation loadAnimation;
        if (z) {
            loadAnimation = AnimationUtils.loadAnimation(this.vGI.getContext(), com.tencent.mm.bi.a.a.bqo);
            loadAnimation.setAnimationListener(new AnimationListener() {
                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    a.this.vGI.cAZ().setVisibility(0);
                    EditText editText = (EditText) a.this.vGI.cAZ().findViewById(com.tencent.mm.bi.a.e.gYg);
                    editText.requestFocus();
                    editText.setSelection(editText.length());
                    a.this.vGI.fdI.aF(true);
                    ((SelectColorBar) a.this.vGI.findViewById(com.tencent.mm.bi.a.e.vik)).HN(editText.getCurrentTextColor());
                    a.this.vGI.cAY().post(new Runnable() {
                        public final void run() {
                            a.this.vGI.cAY().setVisibility(0);
                        }
                    });
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            this.vGI.cAZ().startAnimation(loadAnimation);
            return;
        }
        loadAnimation = AnimationUtils.loadAnimation(this.vGI.getContext(), com.tencent.mm.bi.a.a.bqm);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
                a.this.vGI.fdI.aF(false);
            }

            public final void onAnimationEnd(Animation animation) {
                ((EditText) a.this.vGI.cAZ().findViewById(com.tencent.mm.bi.a.e.gYg)).setText("");
                a.this.vGI.cAZ().setVisibility(8);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.vGI.cAZ().startAnimation(loadAnimation);
    }
}
