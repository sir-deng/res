package com.tencent.mm.plugin.luckymoney.particles;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mm.plugin.luckymoney.particles.a.b;
import com.tencent.mm.plugin.wxpay.a.d;
import java.util.Iterator;

public final class a {
    private static int ojs;
    private static int ojt;
    private static int oju;
    private static int ojv;
    private static int ojw;
    private static int ojx;
    public c ojy;

    public a(ViewGroup viewGroup) {
        if (ojs == 0) {
            Resources resources = viewGroup.getResources();
            ojs = resources.getDimensionPixelSize(d.uir);
            ojt = resources.getDimensionPixelOffset(d.uiv);
            oju = resources.getDimensionPixelOffset(d.uiu);
            ojv = resources.getDimensionPixelOffset(d.uit);
            ojw = resources.getDimensionPixelOffset(d.uiw);
            ojx = resources.getDimensionPixelOffset(d.uis);
        }
    }

    public static a a(ViewGroup viewGroup, b bVar) {
        a aVar = new a(viewGroup);
        c ak = new c(viewGroup.getContext(), bVar, new d(viewGroup.getWidth() / 2, viewGroup.getHeight() + 400), viewGroup).y(0.0f, 800.0f).z(-2000.0f, 1250.0f).ak(2000.0f);
        ak.okg = 3000.0f;
        ak.okh = 500.0f;
        ak = ak.aXQ();
        ak.ojK = e.aXU();
        aVar.ojy = ak.aXR().aXS();
        return aVar;
    }

    public final c y(int i, long j) {
        c cVar = this.ojy;
        cVar.ojG = 0;
        cVar.ojH = j;
        cVar.ojI = ((float) i) / 1000.0f;
        cVar.ojJ = 1.0f / cVar.ojI;
        if (cVar.kco != null) {
            cVar.kco.cancel();
        }
        cVar.ojF = 0;
        Iterator it = cVar.ojE.iterator();
        while (it.hasNext()) {
            cVar.ojD.add(it.next());
            it.remove();
        }
        ViewParent parent = cVar.ojC.getParent();
        if (parent != null) {
            if (parent != cVar.ojB) {
                ((ViewGroup) parent).removeView(cVar.ojC);
            }
            cVar.ojC.terminated = false;
            cVar.z(cVar.ojG, 0);
            cVar.kco = ValueAnimator.ofInt(new int[]{0}).setDuration(Long.MAX_VALUE);
            cVar.kco.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    long currentPlayTime = valueAnimator.getCurrentPlayTime();
                    c cVar = c.this;
                    if (currentPlayTime < cVar.ojH) {
                        if (cVar.ojF == 0) {
                            cVar.ojF = currentPlayTime;
                        } else {
                            int nextFloat = (int) ((cVar.random.nextFloat() * cVar.ojI) * ((float) (currentPlayTime - cVar.ojF)));
                            if (nextFloat > 0) {
                                cVar.ojF = (long) (((float) cVar.ojF) + (cVar.ojJ * ((float) nextFloat)));
                                cVar.z(nextFloat, currentPlayTime);
                            }
                        }
                    }
                    c cVar2 = c.this;
                    Iterator it = cVar2.ojE.iterator();
                    while (it.hasNext()) {
                        b bVar = (b) it.next();
                        if (bVar.okv == -1) {
                            bVar.okv = currentPlayTime;
                        }
                        long j = currentPlayTime - bVar.okv;
                        bVar.okK = j >= 0;
                        if (bVar.okK && !bVar.terminated) {
                            bVar.okH = b.a(j, bVar.okw, bVar.oky, bVar.ojQ, bVar.okA, bVar.ojU);
                            bVar.okI = b.a(j, bVar.okx, bVar.okz, bVar.ojS, bVar.okB, bVar.ojW);
                            bVar.okJ = b.a(j, bVar.okC, bVar.okD, bVar.okc, bVar.okE, bVar.oke);
                            if (bVar.ojK != null) {
                                bVar.alpha = (int) (bVar.ojK.getInterpolation(((float) j) / bVar.okF) * 255.0f);
                            } else {
                                bVar.alpha = 255;
                            }
                            boolean z = !bVar.okL && ((float) j) >= bVar.okF;
                            bVar.terminated = z;
                            bVar.okG = Math.min(1.0f, ((float) j) / bVar.okF);
                        }
                        if ((!bVar.terminated ? 1 : null) == null) {
                            it.remove();
                            cVar2.ojD.add(bVar);
                        }
                    }
                    if (c.this.ojE.size() != 0 || currentPlayTime < c.this.ojH) {
                        c.this.ojC.invalidate();
                    } else {
                        c.this.aXT();
                    }
                }
            });
            cVar.kco.start();
            return cVar;
        }
        cVar.ojB.addView(cVar.ojC);
        cVar.ojC.terminated = false;
        cVar.z(cVar.ojG, 0);
        cVar.kco = ValueAnimator.ofInt(new int[]{0}).setDuration(Long.MAX_VALUE);
        cVar.kco.addUpdateListener(/* anonymous class already generated */);
        cVar.kco.start();
        return cVar;
    }
}
