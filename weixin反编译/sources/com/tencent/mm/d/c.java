package com.tencent.mm.d;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.view.MotionEvent;
import com.tencent.mm.bn.b;
import com.tencent.mm.cache.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends b<a> {
    public Rect fdj;
    private int fiA = ((int) ad.getResources().getDimension(com.tencent.mm.bi.a.c.vhF));
    private int fiB = ((int) ad.getResources().getDimension(com.tencent.mm.bi.a.c.vhS));
    private int fiC = ((int) ad.getResources().getDimension(com.tencent.mm.bi.a.c.vhK));
    private Matrix fiD = new Matrix();
    private RectF fiE;
    private RectF fiF;
    private RectF fiG;
    private RectF fiH;
    public final Rect fiI = new Rect();
    public com.tencent.mm.s.a fiJ;
    private boolean fiK = false;
    private boolean fiL = false;
    public com.tencent.mm.b.a fiM;
    boolean fiN = false;
    boolean fiO = false;
    boolean fiP = false;
    boolean fiQ = false;
    boolean fiR = false;
    public boolean fiS = true;
    boolean fiT = false;
    float fiU;
    float fiV;
    float fiW;
    float fiX;
    float fiY;
    float fiZ;
    public ValueAnimator fja;
    public Rect fjb = new Rect();
    public int fjc = 0;
    public boolean fjd = false;

    /* renamed from: com.tencent.mm.d.c$8 */
    class AnonymousClass8 implements AnimatorUpdateListener {
        int fdE = 0;
        float fdF = ((float) Math.pow((double) this.fjp, 0.0833333358168602d));
        int fjg = 0;
        float fjh;
        float fji = 0.0f;
        float fjj;
        float fjk = 0.0f;
        float fjl = this.fjn;
        float fjm = this.fjo;
        final /* synthetic */ float fjn;
        final /* synthetic */ float fjo;
        final /* synthetic */ float fjp;

        public AnonymousClass8(float f, float f2, float f3) {
            this.fjn = f;
            this.fjo = f2;
            this.fjp = f3;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (this.fdE < 12) {
                c.this.uS().postScale(this.fdF, this.fdF, ((float) c.this.fdj.centerX()) + this.fji, ((float) c.this.fdj.centerY()) + this.fjk);
                c.this.fiD.postScale(this.fdF, this.fdF, ((float) c.this.fdj.centerX()) + this.fji, ((float) c.this.fdj.centerY()) + this.fjk);
                this.fdE++;
            }
            int intValue = ((Integer) valueAnimator.getAnimatedValue("rotation")).intValue();
            int intValue2 = ((Integer) valueAnimator.getAnimatedValue("deltaX")).intValue();
            int intValue3 = ((Integer) valueAnimator.getAnimatedValue("deltaY")).intValue();
            c.this.uS().postRotate((float) (intValue - this.fjg), this.fjn + this.fji, this.fjo + this.fjk);
            c.this.fiD.postRotate((float) (intValue - this.fjg), this.fjn + this.fji, this.fjo + this.fjk);
            RectF rectF = new RectF();
            rectF.set(c.this.fdj);
            c.this.fiD.mapRect(rectF);
            this.fjl += ((float) intValue2) - this.fjh;
            this.fjm += ((float) intValue3) - this.fjj;
            this.fji = this.fjl - rectF.centerX();
            this.fjk = this.fjm - rectF.centerY();
            c.this.uS().postTranslate(this.fji, this.fjk);
            c.this.fiD.postTranslate(this.fji, this.fjk);
            c.this.uT();
            this.fjg = intValue;
            this.fjh = (float) intValue2;
            this.fjj = (float) intValue3;
        }
    }

    static /* synthetic */ void a(c cVar, long j, boolean z, boolean z2) {
        if (cVar.fja != null) {
            cVar.fja.cancel();
        }
        PropertyValuesHolder ofInt = PropertyValuesHolder.ofInt("alpha", new int[]{0, 255});
        PropertyValuesHolder ofInt2 = z ? PropertyValuesHolder.ofInt("bg_alpha", new int[]{282, 255}) : z2 ? PropertyValuesHolder.ofInt("bg_alpha", new int[]{255, 255}) : PropertyValuesHolder.ofInt("bg_alpha", new int[]{0, 255});
        cVar.fja = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt, ofInt2});
        cVar.fja.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue("bg_alpha")).intValue();
                int intValue2 = ((Integer) valueAnimator.getAnimatedValue("alpha")).intValue();
                c.this.fiJ;
                com.tencent.mm.s.a.gm(intValue2);
                c.this.fiJ;
                com.tencent.mm.s.a.gn(intValue);
                c.this.uT();
            }
        });
        cVar.fja.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
                c.this.fiS = true;
                c.this.fiK = true;
            }

            public final void onAnimationEnd(Animator animator) {
                c.this.fiK = true;
            }

            public final void onAnimationCancel(Animator animator) {
                c.this.fiK = false;
                animator.removeAllListeners();
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        cVar.fja.setStartDelay(j);
        cVar.fja.setDuration(300);
        cVar.fja.start();
    }

    public final a uH() {
        return a.CROP_PHOTO;
    }

    public final void a(b bVar, Matrix matrix, Rect rect) {
        super.a(bVar, matrix, rect);
        this.fdj = new Rect();
        this.fiF = new RectF();
        this.fiE = new RectF();
        this.fiG = new RectF();
        this.fiH = new RectF();
        this.fiJ = new com.tencent.mm.s.a(this.fdj);
        this.fiM = new com.tencent.mm.b.a(this);
    }

    public final void uK() {
        super.uK();
        if (this.fiI.isEmpty()) {
            this.fiI.set(this.fiA, this.fiA * 2, uR().width() - this.fiA, ((uR().height() - this.fiB) - this.fiC) - (this.fiA * 2));
        }
        x.i("MicroMsg.CropArtist", "[onAlive] CROP_MAX_RECT:%s", this.fiI);
        com.tencent.mm.s.a xE = ((a) uJ()).xE();
        if (xE != null && !xE.gPl.isEmpty()) {
            this.fio.cdU().cAW().l(xE.gPl);
            x.i("MicroMsg.CropArtist", "[onAlive] rotation:%s", Float.valueOf(a(xE.mMatrix)));
            uS().postRotate(-r1, (float) xE.gPl.centerX(), (float) xE.gPl.centerY());
        }
    }

    public final void uL() {
        super.uL();
        this.fio.cdU().cAY().setVisibility(8);
        this.fjb.setEmpty();
        com.tencent.mm.s.a aVar;
        if (((a) uJ()).bb(true) <= 0) {
            aVar = new com.tencent.mm.s.a();
            aVar.mMatrix.set(uS());
            ((a) uJ()).a(aVar);
            uX();
            this.fio.cdU().cAW().zNL = this.fdj;
            this.fio.cdU().cAW().a(new com.tencent.mm.view.b.a.b() {
                public final void uZ() {
                    if (((a) c.this.uJ()).gDe.isIdentity()) {
                        a aVar = (a) c.this.uJ();
                        aVar.gDe.set(c.this.uS());
                    }
                    Rect rect = new Rect();
                    if (c.this.fio.cdZ() == null) {
                        rect.set(0, 0, c.this.fio.cdU().cAW().zNL.width(), c.this.fio.cdU().cAW().zNL.height());
                    } else {
                        rect.set(0, 0, c.this.fio.cdZ().getWidth(), c.this.fio.cdZ().getHeight());
                    }
                    c.this.fio.cdU().cAW().l(rect);
                    c.a(c.this, 200, true, false);
                    c.this.uU();
                }

                public final void onStart() {
                    c.this.fiK = false;
                    c.this.fiS = false;
                }
            }, 0.0f, false);
        } else {
            aVar = ((a) uJ()).xE();
            if (aVar == null) {
                x.e("MicroMsg.CropArtist", "item is null!!!");
                return;
            }
            this.fdj.set(new Rect(aVar.fdj));
            this.fio.cdU().cAW().zNL = aVar.fdj;
            try {
                ((a) uJ()).a((com.tencent.mm.s.a) aVar.clone());
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.CropArtist", e, "", new Object[0]);
            }
            this.fio.cdU().cAW().a(new com.tencent.mm.view.b.a.b() {
                public final void uZ() {
                    c.this.fiS = true;
                    c.this.fio.cdU().cAW().l(new Rect(0, 0, c.this.fio.cdZ().getWidth(), c.this.fio.cdZ().getHeight()));
                    c.a(c.this, 200, true, false);
                }

                public final void onStart() {
                    c.this.fiK = false;
                    c.this.fiS = false;
                    c.this.fiJ;
                    com.tencent.mm.s.a.gn(282);
                }
            }, 0.0f, false);
        }
        aL(true);
    }

    public final boolean uN() {
        return !((a) uJ()).gDe.equals(uS());
    }

    public final void uI() {
    }

    public final void onDraw(Canvas canvas) {
        if (this.fiL) {
            canvas.setMatrix(this.fiD);
        } else {
            canvas.setMatrix(null);
        }
        com.tencent.mm.s.a aVar = this.fiJ;
        boolean z = this.fiS;
        boolean z2 = this.fiK;
        if (aVar.fdj == null) {
            x.e("MicroMsg.CropItem", "[draw] mBoxRect is null!");
            return;
        }
        if (z) {
            canvas.save();
            canvas.clipRect(aVar.fdj, Op.DIFFERENCE);
            canvas.drawPaint(com.tencent.mm.s.a.gPh);
            canvas.restore();
        }
        if (z2) {
            if (!com.tencent.mm.s.a.gO.equals(aVar.fdj)) {
                com.tencent.mm.s.a.gPe.reset();
                com.tencent.mm.s.a.gPe.moveTo((float) aVar.fdj.left, (float) aVar.fdj.top);
                com.tencent.mm.s.a.gPe.lineTo((float) aVar.fdj.right, (float) aVar.fdj.top);
                com.tencent.mm.s.a.gPe.lineTo((float) aVar.fdj.right, (float) aVar.fdj.bottom);
                com.tencent.mm.s.a.gPe.lineTo((float) aVar.fdj.left, (float) aVar.fdj.bottom);
                com.tencent.mm.s.a.gPe.close();
                com.tencent.mm.s.a.gPd.reset();
                for (int i = 1; i < 3; i++) {
                    com.tencent.mm.s.a.gPd.moveTo((float) (aVar.fdj.left + ((aVar.fdj.width() / 3) * i)), (float) aVar.fdj.top);
                    com.tencent.mm.s.a.gPd.lineTo((float) (aVar.fdj.left + ((aVar.fdj.width() / 3) * i)), (float) aVar.fdj.bottom);
                    com.tencent.mm.s.a.gPd.moveTo((float) aVar.fdj.left, (float) (aVar.fdj.top + ((aVar.fdj.height() / 3) * i)));
                    com.tencent.mm.s.a.gPd.lineTo((float) aVar.fdj.right, (float) (aVar.fdj.top + ((aVar.fdj.height() / 3) * i)));
                }
            }
            canvas.drawRect((float) aVar.fdj.left, (float) aVar.fdj.top, (float) aVar.fdj.right, (float) aVar.fdj.bottom, com.tencent.mm.s.a.gPg);
            canvas.drawPath(com.tencent.mm.s.a.gPd, com.tencent.mm.s.a.gPi);
            canvas.drawPath(com.tencent.mm.s.a.gPe, com.tencent.mm.s.a.gPf);
            Canvas canvas2 = canvas;
            canvas2.drawLine(((float) aVar.fdj.left) - com.tencent.mm.s.a.gPb, ((float) aVar.fdj.top) - (com.tencent.mm.s.a.gPb / 2.0f), com.tencent.mm.s.a.gPc + ((float) aVar.fdj.left), ((float) aVar.fdj.top) - (com.tencent.mm.s.a.gPb / 2.0f), com.tencent.mm.s.a.gPj);
            canvas2 = canvas;
            canvas2.drawLine((com.tencent.mm.s.a.gPb / 2.0f) + (((float) aVar.fdj.right) - com.tencent.mm.s.a.gPc), ((float) aVar.fdj.top) - (com.tencent.mm.s.a.gPb / 2.0f), com.tencent.mm.s.a.gPb + ((float) aVar.fdj.right), ((float) aVar.fdj.top) - (com.tencent.mm.s.a.gPb / 2.0f), com.tencent.mm.s.a.gPj);
            canvas2 = canvas;
            canvas2.drawLine(((float) aVar.fdj.left) - (com.tencent.mm.s.a.gPb / 2.0f), ((float) aVar.fdj.top) - (com.tencent.mm.s.a.gPb / 2.0f), ((float) aVar.fdj.left) - (com.tencent.mm.s.a.gPb / 2.0f), com.tencent.mm.s.a.gPc + ((float) aVar.fdj.top), com.tencent.mm.s.a.gPj);
            canvas2 = canvas;
            canvas2.drawLine(((float) aVar.fdj.left) - (com.tencent.mm.s.a.gPb / 2.0f), (com.tencent.mm.s.a.gPb / 2.0f) + (((float) aVar.fdj.bottom) - com.tencent.mm.s.a.gPc), ((float) aVar.fdj.left) - (com.tencent.mm.s.a.gPb / 2.0f), (com.tencent.mm.s.a.gPb / 2.0f) + ((float) aVar.fdj.bottom), com.tencent.mm.s.a.gPj);
            canvas2 = canvas;
            canvas2.drawLine((com.tencent.mm.s.a.gPb / 2.0f) + ((float) aVar.fdj.right), (float) aVar.fdj.top, (com.tencent.mm.s.a.gPb / 2.0f) + ((float) aVar.fdj.right), com.tencent.mm.s.a.gPc + ((float) aVar.fdj.top), com.tencent.mm.s.a.gPj);
            canvas2 = canvas;
            canvas2.drawLine((com.tencent.mm.s.a.gPb / 2.0f) + ((float) aVar.fdj.right), (com.tencent.mm.s.a.gPb / 2.0f) + (((float) aVar.fdj.bottom) - com.tencent.mm.s.a.gPc), (com.tencent.mm.s.a.gPb / 2.0f) + ((float) aVar.fdj.right), (com.tencent.mm.s.a.gPb / 2.0f) + ((float) aVar.fdj.bottom), com.tencent.mm.s.a.gPj);
            canvas2 = canvas;
            canvas2.drawLine(((float) aVar.fdj.left) - com.tencent.mm.s.a.gPb, (com.tencent.mm.s.a.gPb / 2.0f) + ((float) aVar.fdj.bottom), com.tencent.mm.s.a.gPc + ((float) aVar.fdj.left), (com.tencent.mm.s.a.gPb / 2.0f) + ((float) aVar.fdj.bottom), com.tencent.mm.s.a.gPj);
            canvas2 = canvas;
            canvas2.drawLine(((float) aVar.fdj.right) - com.tencent.mm.s.a.gPc, (com.tencent.mm.s.a.gPb / 2.0f) + ((float) aVar.fdj.bottom), com.tencent.mm.s.a.gPb + ((float) aVar.fdj.right), (com.tencent.mm.s.a.gPb / 2.0f) + ((float) aVar.fdj.bottom), com.tencent.mm.s.a.gPj);
            if (!com.tencent.mm.s.a.gO.equals(aVar.fdj)) {
                com.tencent.mm.s.a.gO.set(aVar.fdj);
            }
        }
    }

    public final boolean q(MotionEvent motionEvent) {
        if (!uP()) {
            return false;
        }
        RectF cBn = this.fio.cdU().cAW().cBn();
        this.fiW = cBn.top - (cBn.bottom - ((float) this.fdj.bottom));
        this.fiX = cBn.bottom + (((float) this.fdj.top) - cBn.top);
        this.fiY = cBn.left - (cBn.right - ((float) this.fdj.right));
        this.fiZ = cBn.right + (((float) this.fdj.left) - cBn.left);
        if (this.fiZ > ((float) this.fiI.right)) {
            this.fiZ = (float) this.fiI.right;
        }
        if (this.fiY < ((float) this.fiA)) {
            this.fiY = (float) this.fiA;
        }
        if (this.fiX > ((float) this.fiI.bottom)) {
            this.fiX = (float) this.fiI.bottom;
        }
        if (this.fiW < ((float) this.fiA)) {
            this.fiW = (float) this.fiA;
        }
        float width;
        float height;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.fiT = false;
                if (this.fiM != null) {
                    this.fiM.cancel();
                }
                if (this.fiF.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.fiQ = true;
                }
                if (this.fiE.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.fiP = true;
                }
                if (this.fiG.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.fiO = true;
                }
                if (this.fiH.contains(motionEvent.getX(), motionEvent.getY())) {
                    this.fiR = true;
                }
                this.fiS = false;
                if (uV()) {
                    if (this.fiQ && this.fiO) {
                        this.fiQ = true;
                        this.fiO = true;
                        this.fiP = false;
                        this.fiR = false;
                    } else if (this.fiQ && this.fiR) {
                        this.fiQ = true;
                        this.fiO = false;
                        this.fiP = false;
                        this.fiR = true;
                    } else if (this.fiP && this.fiR) {
                        this.fiQ = false;
                        this.fiO = false;
                        this.fiP = true;
                        this.fiR = true;
                    } else if (this.fiP && this.fiR) {
                        this.fiQ = false;
                        this.fiO = false;
                        this.fiP = true;
                        this.fiR = true;
                    }
                    this.fiU = motionEvent.getX();
                    this.fiV = motionEvent.getY();
                    break;
                }
                break;
            case 1:
                width = (((float) this.fiI.width()) * 1.0f) / ((float) this.fdj.width());
                height = (((float) this.fiI.height()) * 1.0f) / ((float) this.fdj.height());
                if (width >= height) {
                    width = height;
                }
                height = ((float) this.fiI.centerX()) - ((float) this.fdj.centerX());
                float centerY = ((float) this.fiI.centerY()) - ((float) this.fdj.centerY());
                if (this.fiT) {
                    this.fiM.fdm = 1000;
                    com.tencent.mm.b.a aVar = this.fiM;
                    Rect rect = this.fdj;
                    aVar.fdh = height;
                    aVar.fdi = centerY;
                    aVar.fdj = rect;
                    aVar.fdk.set(aVar.fdj);
                    aVar.fdg = width;
                    this.fiM.play();
                }
                if (uV()) {
                    this.fiN = true;
                } else {
                    this.fiN = false;
                }
                this.fiQ = false;
                this.fiO = false;
                this.fiP = false;
                this.fiR = false;
                uU();
                break;
            case 2:
                this.fiT = true;
                if (motionEvent.getPointerCount() == 1 && uV()) {
                    Rect rect2;
                    if (this.fiR && this.fdj.right >= this.fdj.left) {
                        if (this.fdj.right <= this.fiI.right) {
                            if (motionEvent.getX() - this.fiU > ((float) (this.fiI.right - this.fdj.right))) {
                                this.fdj.right = this.fiI.right;
                            } else {
                                rect2 = this.fdj;
                                rect2.right = (int) (((float) rect2.right) + (motionEvent.getX() - this.fiU));
                            }
                        }
                        if (this.fdj.right < this.fdj.left + (this.fiA * 2)) {
                            this.fdj.right = this.fdj.left + (this.fiA * 2);
                        }
                        if (this.fdj.right > this.fiI.right) {
                            this.fdj.right = this.fiI.right;
                        }
                        if (((int) cBn.right) <= ((int) this.fiZ) && ((int) cBn.right) <= this.fdj.right) {
                            if (motionEvent.getX() - this.fiU > this.fiZ - cBn.right) {
                                uS().postTranslate(this.fiZ - cBn.right, 0.0f);
                            } else {
                                uS().postTranslate(motionEvent.getX() - this.fiU, 0.0f);
                            }
                        }
                        if (((float) this.fdj.width()) > cBn.width() && this.fdj.right < this.fiI.right) {
                            height = ((float) this.fdj.width()) / cBn.width();
                            uS().postScale(height, height, (float) this.fdj.left, (float) this.fdj.centerY());
                        }
                    }
                    if (this.fiO && this.fdj.right >= this.fdj.left) {
                        if (this.fdj.left >= this.fiI.left) {
                            if (this.fiU - motionEvent.getX() > ((float) (this.fdj.left - this.fiI.left))) {
                                this.fdj.left = this.fiI.left;
                            } else {
                                rect2 = this.fdj;
                                rect2.left = (int) (((float) rect2.left) - (this.fiU - motionEvent.getX()));
                            }
                        }
                        if (this.fdj.left > this.fdj.right - (this.fiA * 2)) {
                            this.fdj.left = this.fdj.right - (this.fiA * 2);
                        }
                        if (this.fdj.left < this.fiI.left) {
                            this.fdj.left = this.fiI.left;
                        }
                        if (((int) cBn.left) >= ((int) this.fiY) && ((int) cBn.left) >= this.fdj.left) {
                            if (this.fiU - motionEvent.getX() > cBn.left - this.fiY) {
                                uS().postTranslate(this.fiY - cBn.left, 0.0f);
                            } else {
                                uS().postTranslate(motionEvent.getX() - this.fiU, 0.0f);
                            }
                        }
                        if (((float) this.fdj.width()) > cBn.width() && this.fdj.left > this.fiI.left) {
                            height = ((float) this.fdj.width()) / cBn.width();
                            uS().postScale(height, height, (float) this.fdj.right, (float) this.fdj.centerY());
                        }
                    }
                    if (this.fiP && this.fdj.bottom >= this.fdj.top) {
                        if (this.fdj.top >= this.fiI.top) {
                            if (this.fiV - motionEvent.getY() > ((float) (this.fdj.top - this.fiI.top))) {
                                this.fdj.top = this.fiI.top;
                            } else {
                                rect2 = this.fdj;
                                rect2.top = (int) (((float) rect2.top) - (this.fiV - motionEvent.getY()));
                            }
                        }
                        if (this.fdj.top > this.fdj.bottom - (this.fiA * 2)) {
                            this.fdj.top = this.fdj.bottom - (this.fiA * 2);
                        }
                        if (this.fdj.top < this.fiI.top) {
                            this.fdj.top = this.fiI.top;
                        }
                        if (((int) cBn.top) >= ((int) this.fiW) && ((int) cBn.top) >= this.fdj.top) {
                            if (this.fiV - motionEvent.getY() > cBn.top - this.fiW) {
                                uS().postTranslate(0.0f, this.fiW - cBn.top);
                            } else {
                                uS().postTranslate(0.0f, motionEvent.getY() - this.fiV);
                            }
                        }
                        if (((float) this.fdj.height()) > cBn.height() && this.fdj.top > this.fiI.top) {
                            height = ((float) this.fdj.height()) / cBn.height();
                            uS().postScale(height, height, (float) this.fdj.centerX(), (float) this.fdj.bottom);
                        }
                    }
                    if (this.fiQ && this.fdj.bottom >= this.fdj.top) {
                        if (this.fdj.bottom <= this.fiI.bottom) {
                            if (motionEvent.getY() - this.fiV > ((float) (this.fiI.bottom - this.fdj.bottom))) {
                                this.fdj.bottom = this.fiI.bottom;
                            } else {
                                rect2 = this.fdj;
                                rect2.bottom = (int) (((float) rect2.bottom) + (motionEvent.getY() - this.fiV));
                            }
                        }
                        if (this.fdj.bottom < this.fdj.top + (this.fiA * 2)) {
                            this.fdj.bottom = this.fdj.top + (this.fiA * 2);
                        }
                        if (this.fdj.bottom > this.fiI.bottom) {
                            this.fdj.bottom = this.fiI.bottom;
                        }
                        if (((int) cBn.bottom) <= ((int) this.fiX) && ((int) cBn.bottom) <= this.fdj.bottom) {
                            if (motionEvent.getY() - this.fiV > this.fiX - cBn.bottom) {
                                uS().postTranslate(0.0f, this.fiX - cBn.bottom);
                            } else {
                                uS().postTranslate(0.0f, motionEvent.getY() - this.fiV);
                            }
                        }
                        if (((float) this.fdj.height()) > cBn.height() && this.fdj.bottom < this.fiI.bottom) {
                            width = ((float) this.fdj.height()) / cBn.height();
                            uS().postScale(width, width, (float) this.fdj.centerX(), (float) this.fdj.top);
                        }
                    }
                    uW();
                    this.fiN = true;
                    uT();
                    this.fiU = motionEvent.getX();
                    this.fiV = motionEvent.getY();
                } else {
                    this.fiN = false;
                }
                t(motionEvent);
                break;
            case 5:
                this.fiQ = false;
                this.fiO = false;
                this.fiP = false;
                this.fiR = false;
                this.fiN = false;
                break;
        }
        return this.fiN;
    }

    private boolean uV() {
        return this.fiQ || this.fiO || this.fiP || this.fiR;
    }

    public final void uW() {
        this.fiF.set((float) (this.fdj.left - this.fiA), (float) (this.fdj.bottom - this.fiA), (float) (this.fdj.right + this.fiA), (float) (this.fdj.bottom + this.fiA));
        this.fiE.set((float) (this.fdj.left - this.fiA), (float) (this.fdj.top - this.fiA), (float) (this.fdj.right + this.fiA), (float) (this.fdj.top + this.fiA));
        this.fiG.set((float) (this.fdj.left - this.fiA), (float) (this.fdj.top - this.fiA), (float) (this.fdj.left + this.fiA), (float) (this.fdj.bottom + this.fiA));
        this.fiH.set((float) (this.fdj.right - this.fiA), (float) (this.fdj.top - this.fiA), (float) (this.fdj.right + this.fiA), (float) (this.fdj.bottom + this.fiA));
    }

    public final void uX() {
        float width = (((float) this.fio.cdZ().getWidth()) * 1.0f) / ((float) this.fio.cdZ().getHeight());
        int width2;
        if (width < (((float) this.fiI.width()) * 1.0f) / ((float) this.fiI.height())) {
            width2 = (int) ((((float) this.fiI.width()) - (width * ((float) this.fiI.height()))) / 2.0f);
            this.fdj.set(this.fiI.left + width2, this.fiI.top, this.fiI.right - width2, this.fiI.bottom);
        } else {
            width2 = (int) ((((float) this.fiI.height()) - (((float) this.fiI.width()) / width)) / 2.0f);
            this.fdj.set(this.fiI.left, this.fiI.top + width2, this.fiI.right, this.fiI.bottom - width2);
        }
        uW();
    }

    public final void uY() {
        this.fio.cdU().cAW().zNL = this.fio.cdU().cAW().zNM;
        RectF rectF = new RectF(this.fdj);
        Matrix matrix = new Matrix();
        uS().invert(matrix);
        matrix.mapRect(rectF);
        Rect rect = new Rect();
        rectF.round(rect);
        this.fio.cdU().cAW().l(rect);
        final com.tencent.mm.s.a aVar = new com.tencent.mm.s.a();
        aVar.fdj = new Rect(this.fdj);
        aVar.gPl.set(rect);
        this.fio.cdU().cAW().a(new com.tencent.mm.view.b.a.b() {
            public final void uZ() {
                com.tencent.mm.s.a aVar = aVar;
                aVar.mMatrix.set(c.this.uS());
                a aVar2 = (a) c.this.uJ();
                if (aVar2.gDc != null) {
                    aVar2.gDc.clear();
                }
                ((a) c.this.uJ()).a(aVar);
            }

            public final void onStart() {
            }
        }, 0.0f, true);
        this.fio.cdU().cAY().setVisibility(0);
    }
}
