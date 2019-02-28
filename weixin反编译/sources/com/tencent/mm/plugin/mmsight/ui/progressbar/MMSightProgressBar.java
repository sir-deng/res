package com.tencent.mm.plugin.mmsight.ui.progressbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Shader.TileMode;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.support.Log;
import java.util.ArrayList;
import java.util.List;

public class MMSightProgressBar extends View {
    public static final int mdI = com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), 3);
    public static final int oJj = com.tencent.mm.bu.a.fromDPToPix(ad.getContext(), 5);
    private static final int[] oJk = new int[]{-1, -1, Color.parseColor("#F5B3B2"), Color.parseColor("#EB6866"), Color.parseColor("#E64340")};
    private int centerX = 0;
    private int centerY = 0;
    private boolean fBn = false;
    private ag handler = null;
    private Paint jbA;
    private List<a> oJl = new ArrayList(5);
    private int oJm = 0;
    private b oJn;
    private boolean oJo = false;
    private a oJp;

    public interface a {
    }

    public MMSightProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMSightProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.jbA = new Paint();
        this.jbA.setColor(-65536);
        this.jbA.setAntiAlias(true);
        this.handler = new ag(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                if (message.what == 233 && MMSightProgressBar.this.fBn && MMSightProgressBar.this.oJl.size() > 0 && MMSightProgressBar.this.oJl.size() < 5) {
                    MMSightProgressBar.this.oJn = new b((a) MMSightProgressBar.this.oJl.get(MMSightProgressBar.this.oJl.size() - 1), new a(MMSightProgressBar.this.oJl.size(), MMSightProgressBar.this.centerX, MMSightProgressBar.this.centerY, MMSightProgressBar.oJk[MMSightProgressBar.this.oJl.size()]), new com.tencent.mm.plugin.mmsight.ui.progressbar.b.a() {
                        public final void a(a aVar) {
                            MMSightProgressBar.this.oJl.add(aVar);
                            MMSightProgressBar.this.oJn = null;
                            if (MMSightProgressBar.this.oJl.size() >= 5) {
                                Log.i("MicroMsg.MMSightProgressBar", "progress finish!");
                                if (MMSightProgressBar.this.oJp != null) {
                                    MMSightProgressBar.this.oJp;
                                }
                            } else if (MMSightProgressBar.this.fBn) {
                                MMSightProgressBar.this.handler.sendEmptyMessage(233);
                            }
                            MMSightProgressBar.this.invalidate();
                        }

                        public final void bcq() {
                            MMSightProgressBar.this.invalidate();
                        }
                    });
                    b g = MMSightProgressBar.this.oJn;
                    g.kco = ValueAnimator.ofFloat(new float[]{0.0f, 100.0f});
                    g.kco.addUpdateListener(new AnimatorUpdateListener() {
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            b.this.oJw = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            b bVar = b.this;
                            float f = b.this.oJw;
                            bVar.oJK = (float) ((int) (((float) Math.round((float) (MMSightProgressBar.oJj + (MMSightProgressBar.mdI * 2)))) * (f / 100.0f)));
                            bVar.oJH = bVar.oJI - ((f / 100.0f) * (bVar.oJI - bVar.oJJ));
                            bVar.oJB = new PointF((float) MMSightProgressBar.mdI, 0.0f);
                            bVar.oJC = new PointF(((float) MMSightProgressBar.mdI) + (bVar.oJK / 2.0f), ((float) MMSightProgressBar.mdI) - (bVar.oJH / 2.0f));
                            bVar.oJD = new PointF(((float) MMSightProgressBar.mdI) + bVar.oJK, 0.0f);
                            bVar.oJE = new PointF((float) MMSightProgressBar.mdI, (float) (MMSightProgressBar.mdI * 2));
                            bVar.oJF = new PointF(((float) MMSightProgressBar.mdI) + (bVar.oJK / 2.0f), ((float) MMSightProgressBar.mdI) + (bVar.oJH / 2.0f));
                            bVar.oJG = new PointF(((float) MMSightProgressBar.mdI) + bVar.oJK, ((float) MMSightProgressBar.mdI) * 2.0f);
                            x.d("MicroMsg.MMSightProgressPointSplitter", "calPoints, currentPointDistance: %s, curveCenterDistance: %s", Float.valueOf(bVar.oJK), Float.valueOf(bVar.oJH));
                            x.d("MicroMsg.MMSightProgressPointSplitter", "calPoints, point1: %s, point2: %s, point3: %s, point4: %s, point5: %s, point6: %s", bVar.oJB, bVar.oJC, bVar.oJD, bVar.oJE, bVar.oJF, bVar.oJG);
                            if (b.this.oJA != null) {
                                b.this.oJA.bcq();
                            }
                        }
                    });
                    g.kco.addListener(new AnimatorListenerAdapter() {
                        public final void onAnimationStart(Animator animator) {
                            b.this.oJz = true;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            b.this.oJz = true;
                            if (b.this.oJA != null) {
                                b.this.oJA.a(b.this.oJy);
                            }
                        }
                    });
                    g.kco.setInterpolator(new AccelerateDecelerateInterpolator());
                    g.kco.setDuration(2000);
                    g.kco.start();
                }
            }
        };
        Log.i("MicroMsg.MMSightProgressBar", "init, pointRadius: %s, pointDistance: %s", Integer.valueOf(mdI), Integer.valueOf(oJj));
    }

    protected void onDraw(Canvas canvas) {
        int right;
        float f;
        a aVar;
        super.onDraw(canvas);
        if (this.fBn && (this.centerX <= 0 || this.centerY <= 0)) {
            int left = getLeft();
            right = getRight();
            int top = getTop();
            int bottom = getBottom();
            this.centerX = (right - left) / 2;
            this.centerY = (bottom - top) / 2;
            Log.i("MicroMsg.MMSightProgressBar", "left: %s, right: %s, top: %s, bottom: %s, centerX: %s, centerY: %s", Integer.valueOf(left), Integer.valueOf(right), Integer.valueOf(top), Integer.valueOf(bottom), Integer.valueOf(this.centerX), Integer.valueOf(this.centerY));
            Log.i("MicroMsg.MMSightProgressBar", "add init point");
            this.oJl.add(new a(0, this.centerX, this.centerY, -1));
        }
        int save = canvas.save();
        this.oJm = this.oJl.size();
        if (this.oJm % 2 == 0) {
            f = -(((((float) oJj) / 2.0f) + ((float) (((this.oJm / 2) - 1) * oJj))) + ((float) ((this.oJm / 2) * mdI)));
        } else {
            f = -(((((float) mdI) / 2.0f) + ((float) ((this.oJm / 2) * oJj))) + ((float) ((this.oJm / 2) * mdI)));
        }
        if (this.oJn != null && this.oJn.oJz) {
            float f2;
            right = this.oJm + 1;
            if (right % 2 == 0) {
                f2 = -(((float) ((right / 2) * mdI)) + ((((float) oJj) / 2.0f) + ((float) (((right / 2) - 1) * oJj))));
            } else {
                f2 = -(((float) ((right / 2) * mdI)) + ((((float) mdI) / 2.0f) + ((float) ((right / 2) * oJj))));
            }
            Log.d("MicroMsg.MMSightProgressBar", "add translateX for splitting, dstTranslateX: %s, progress: %s", Float.valueOf(f2), Float.valueOf(this.oJn.oJw));
            f -= (Math.abs(f2) - Math.abs(f)) * (this.oJn.oJw / 100.0f);
        }
        Log.d("MicroMsg.MMSightProgressBar", "draw, translateX: %s, currentPointCount: %s", Float.valueOf(f), Integer.valueOf(this.oJm));
        canvas.translate(f, 0.0f);
        if (this.oJn != null && this.oJn.oJz) {
            b bVar = this.oJn;
            Paint paint = this.jbA;
            x.d("MicroMsg.MMSightProgressPointSplitter", "drawForSplitProgress, progress: %s, rightPointXOffset: %s", Float.valueOf(bVar.oJw), Float.valueOf(((float) (oJj + (mdI * 2))) * (bVar.oJw / 100.0f)));
            if (bVar.oJH > bVar.oJJ) {
                float f3 = bVar.oJx.oJs - ((float) mdI);
                f = bVar.oJx.oJt - ((float) mdI);
                paint.setColor(bVar.oJy.color);
                bVar.oJL.reset();
                bVar.oJL.moveTo(bVar.oJB.x + f3, bVar.oJB.y + f);
                bVar.oJL.quadTo(bVar.oJC.x + f3, bVar.oJC.y + f, bVar.oJD.x + f3, bVar.oJD.y + f);
                bVar.oJL.lineTo(bVar.oJG.x + f3, bVar.oJG.y + f);
                bVar.oJL.quadTo(bVar.oJF.x + f3, bVar.oJF.y + f, bVar.oJE.x + f3, f + bVar.oJE.y);
                if (bVar.oJy.color != bVar.oJx.color) {
                    paint.setShader(new LinearGradient(bVar.oJB.x + f3, bVar.oJx.oJt - ((float) mdI), f3 + bVar.oJD.x, bVar.oJx.oJt - ((float) mdI), new int[]{bVar.oJx.color, bVar.oJy.color}, null, TileMode.REPEAT));
                }
                canvas.drawPath(bVar.oJL, paint);
                paint.setShader(null);
            }
            aVar = bVar.oJy;
            paint.setColor(aVar.color);
            aVar.oJt = (float) aVar.oJv;
            aVar.oJs = ((float) (aVar.oJu + ((aVar.index - 1) * (oJj + (mdI * 2))))) + r11;
            Log.d("MicroMsg.MMSightProgressPoint", "drawWithOffset, index: %s, offset: %s, pointX: %s", Integer.valueOf(aVar.index), Float.valueOf(r11), Float.valueOf(aVar.oJs));
            canvas.drawCircle(aVar.oJs, aVar.oJt, (float) mdI, paint);
            paint.setShader(null);
        }
        for (a aVar2 : this.oJl) {
            Paint paint2 = this.jbA;
            paint2.setColor(aVar2.color);
            aVar2.oJs = (float) (aVar2.oJu + (aVar2.index * (oJj + (mdI * 2))));
            aVar2.oJt = (float) aVar2.oJv;
            Log.d("MicroMsg.MMSightProgressPoint", "draw, index: %s, pointX: %s", Integer.valueOf(aVar2.index), Float.valueOf(aVar2.oJs));
            canvas.drawCircle(aVar2.oJs, aVar2.oJt, (float) mdI, paint2);
            paint2.setShader(null);
        }
        canvas.restoreToCount(save);
        if (this.fBn && !this.oJo && this.oJl.size() > 0) {
            Log.i("MicroMsg.MMSightProgressBar", "start handler loop");
            this.oJo = true;
            this.handler.sendEmptyMessage(233);
        }
    }
}
