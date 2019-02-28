package com.tencent.mm.view.b;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.b.d;
import com.tencent.mm.b.d.AnonymousClass1;
import com.tencent.mm.d.a;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends a {
    private d zNY = new d(this);
    private PointF zNZ = new PointF();
    private float zOa = 0.0f;
    private float zOb = 0.0f;
    private boolean zOc = false;
    public boolean zOd = false;

    public b(Context context, com.tencent.mm.bn.b bVar) {
        super(context, bVar);
    }

    public final boolean cBk() {
        return true;
    }

    protected final void onDraw(Canvas canvas) {
        canvas.drawColor(0, Mode.CLEAR);
        canvas.setMatrix(uS());
        canvas.save();
        canvas.clipRect(cBl());
        Bitmap cdZ = this.fio.cdZ();
        if (!(cdZ == null || cdZ.isRecycled())) {
            canvas.drawBitmap(cdZ, 0.0f, 0.0f, null);
        }
        canvas.restore();
        this.fio.onDraw(canvas);
    }

    protected final void R(MotionEvent motionEvent) {
        float x = motionEvent.getX(motionEvent.getPointerCount() - 1);
        float y = motionEvent.getY(motionEvent.getPointerCount() - 1);
        float centerX;
        float cBo;
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.zNZ.set(x, y);
                this.zOa = 0.0f;
                this.zOb = cdY();
                d dVar = this.zNY;
                x.d("MicroMsg.StickRoundAnim", "[cancel]");
                if (dVar.fde != null && (dVar.fde.isRunning() || dVar.fde.isStarted())) {
                    dVar.fde.cancel();
                }
                this.zOd = false;
                break;
            case 1:
                this.zOa = 0.0f;
                if (this.zOd) {
                    com.tencent.mm.b.b bVar = this.zNY;
                    if (bVar.fdr) {
                        x.d("MicroMsg.StickRoundAnim", "[play] start");
                        RectF cBn = bVar.fdz.cBn();
                        Rect rect = bVar.fdz.zNL;
                        bVar.fdA = cBn.centerX();
                        bVar.fdB = cBn.centerY();
                        float centerY = ((float) rect.centerY()) - cBn.centerY();
                        centerX = ((float) rect.centerX()) - cBn.centerX();
                        float cdY = bVar.fdz.cdY();
                        float cBp = bVar.fdz.cBp();
                        cBo = bVar.fdz.cBo();
                        if (cdY > cBp) {
                            bVar.gr = cBp;
                            bVar.fdC = true;
                        } else if (cdY < cBo) {
                            bVar.gr = cBo;
                            bVar.fdC = true;
                        } else {
                            bVar.fdC = false;
                        }
                        Object obj = ((float) rect.height()) < cBn.height() ? 1 : null;
                        Object obj2 = ((float) rect.width()) < cBn.width() ? 1 : null;
                        if (obj != null) {
                            centerY = 0.0f;
                        }
                        if (obj2 != null) {
                            centerX = 0.0f;
                        }
                        cBo = (cBn.top <= ((float) rect.top) || obj == null) ? (cBn.bottom >= ((float) rect.bottom) || obj == null) ? centerY : ((float) rect.bottom) - cBn.bottom : ((float) rect.top) - cBn.top;
                        if (cBn.left > ((float) rect.left) && obj2 != null) {
                            centerX = ((float) rect.left) - cBn.left;
                        } else if (cBn.right < ((float) rect.right) && obj2 != null) {
                            centerX = ((float) rect.right) - cBn.right;
                        }
                        x.d("MicroMsg.StickRoundAnim", "%s %s ", Float.valueOf(centerX), Float.valueOf(cBo));
                        if (cdY > cBp) {
                            bVar.fdD = true;
                        } else {
                            bVar.fdD = false;
                        }
                        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("deltaY", new float[]{0.0f, cBo});
                        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("deltaX", new float[]{0.0f, centerX});
                        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("scale", new float[]{0.0f, 80.0f});
                        bVar.fde = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3});
                        bVar.fde.addUpdateListener(new AnonymousClass1(cdY));
                        bVar.fde.addListener(new AnimatorListener() {
                            public final void onAnimationStart(Animator animator) {
                                d.this.fdr = false;
                            }

                            public final void onAnimationEnd(Animator animator) {
                                d.this.fdr = true;
                            }

                            public final void onAnimationCancel(Animator animator) {
                                d.this.fdr = true;
                            }

                            public final void onAnimationRepeat(Animator animator) {
                            }
                        });
                        bVar.fde.setInterpolator(new LinearInterpolator());
                        bVar.fde.setDuration(80);
                        bVar.fde.start();
                        break;
                    }
                }
                break;
            case 2:
                if (!this.zOc) {
                    if (motionEvent.getPointerCount() != 2) {
                        if (motionEvent.getPointerCount() == 1 && cBj()) {
                            this.zOd = true;
                            this.zNY.fdr = true;
                            translate(x, y);
                            postInvalidate();
                            break;
                        }
                    }
                    this.zOd = true;
                    cBo = motionEvent.getX(0) - motionEvent.getX(1);
                    centerX = motionEvent.getY(0) - motionEvent.getY(1);
                    cBo = (float) Math.sqrt((double) ((cBo * cBo) + (centerX * centerX)));
                    if (this.zOa != 0.0f) {
                        cBo = (cBo / this.zOa) * this.zOb;
                        if (this.zNP * 0.5f <= cBo) {
                            if (cBo > this.zNO) {
                                cBo = ((cBo - this.zNO) * 0.2f) + this.zNO;
                            }
                            uS().postScale(cBo / cdY(), cBo / cdY(), x, y);
                        }
                        this.zNY.fdr = true;
                        translate(x, y);
                        postInvalidate();
                        break;
                    }
                    this.zOa = cBo;
                    break;
                }
                this.zOc = false;
                return;
            case 5:
                this.zOa = 0.0f;
                this.zOb = cdY();
                break;
            case 6:
                this.zOa = 0.0f;
                this.zOc = true;
                break;
        }
        this.zNZ.x = x;
        this.zNZ.y = y;
    }

    private void translate(float f, float f2) {
        RectF cBn = cBn();
        float f3 = f - this.zNZ.x;
        float f4 = f2 - this.zNZ.y;
        if (f3 > 0.0f) {
            if (((float) this.zNL.left) <= cBn.left) {
                f3 *= 0.5f;
            } else if (Math.abs(f3) > Math.abs(cBn.left - ((float) this.zNL.left))) {
                f3 = ((float) this.zNL.left) - cBn.left;
            }
        } else if (((float) this.zNL.right) >= cBn.right) {
            f3 *= 0.5f;
        } else if (Math.abs(f3) > Math.abs(((float) this.zNL.right) - cBn.right)) {
            f3 = ((float) this.zNL.right) - cBn.right;
        }
        if (f4 > 0.0f) {
            if (((float) this.zNL.top) <= cBn.top) {
                f4 *= 0.5f;
            } else if (Math.abs(f4) > Math.abs(cBn.top - ((float) this.zNL.top))) {
                f4 = ((float) this.zNL.top) - cBn.top;
            }
        } else if (((float) this.zNL.bottom) >= cBn.bottom) {
            f4 *= 0.5f;
        } else if (Math.abs(f4) > Math.abs(((float) this.zNL.bottom) - cBn.bottom)) {
            f4 = ((float) this.zNL.bottom) - cBn.bottom;
        }
        uS().postTranslate(f3, f4);
    }

    public final float cBo() {
        if (this.fio.cdW().uH() != a.CROP_PHOTO) {
            return super.cBo();
        }
        float width = ((float) this.zNL.width()) / cBn().width();
        float height = ((float) this.zNL.height()) / cBn().height();
        if (width <= height) {
            width = height;
        }
        return width * cdY();
    }
}
