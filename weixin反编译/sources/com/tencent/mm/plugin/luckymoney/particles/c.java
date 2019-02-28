package com.tencent.mm.plugin.luckymoney.particles;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.mm.plugin.luckymoney.particles.a.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public final class c {
    private long hMW;
    ValueAnimator kco;
    private final d ojA;
    final ViewGroup ojB;
    final ConfettiView ojC;
    final Queue<b> ojD;
    final List<b> ojE;
    long ojF;
    int ojG;
    long ojH;
    float ojI;
    float ojJ;
    public Interpolator ojK;
    private Rect ojL;
    private float ojM;
    private float ojN;
    private float ojO;
    private float ojP;
    private float ojQ;
    private float ojR;
    private float ojS;
    private float ojT;
    private Float ojU;
    private Float ojV;
    private Float ojW;
    private Float ojX;
    private int ojY;
    private int ojZ;
    private final b ojz;
    private float oka;
    private float okb;
    private float okc;
    private float okd;
    private Float oke;
    private Float okf;
    public float okg;
    public float okh;
    final Random random;

    public c(Context context, b bVar, d dVar, ViewGroup viewGroup) {
        this(bVar, dVar, viewGroup, ConfettiView.db(context));
    }

    private c(b bVar, d dVar, ViewGroup viewGroup, ConfettiView confettiView) {
        this.random = new Random();
        this.ojD = new LinkedList();
        this.ojE = new ArrayList(300);
        this.ojz = bVar;
        this.ojA = dVar;
        this.ojB = viewGroup;
        this.ojC = confettiView;
        this.ojC.ojE = this.ojE;
        this.ojC.addOnAttachStateChangeListener(new OnAttachStateChangeListener() {
            public final void onViewAttachedToWindow(View view) {
            }

            public final void onViewDetachedFromWindow(View view) {
                c.this.aXT();
            }
        });
        this.hMW = -1;
        this.ojL = new Rect(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
    }

    public final c y(float f, float f2) {
        this.ojM = f / 1000.0f;
        this.ojN = f2 / 1000.0f;
        return this;
    }

    public final c z(float f, float f2) {
        this.ojO = f / 1000.0f;
        this.ojP = f2 / 1000.0f;
        return this;
    }

    public final c aj(float f) {
        this.ojQ = f / 1000000.0f;
        this.ojR = 0.0f;
        return this;
    }

    public final c ak(float f) {
        this.ojS = f / 1000000.0f;
        this.ojT = 0.0f;
        return this;
    }

    public final c aXQ() {
        this.ojY = 180;
        this.ojZ = 180;
        return this;
    }

    public final c aXR() {
        this.okc = 3.6E-4f;
        this.okd = 1.8E-4f;
        return this;
    }

    public final c aXS() {
        this.oke = Float.valueOf(0.36f);
        this.okf = Float.valueOf(0.0f);
        return this;
    }

    public final void aXT() {
        if (this.kco != null) {
            this.kco.cancel();
        }
        this.ojC.aXT();
    }

    final void z(int i, long j) {
        for (int i2 = 0; i2 < i; i2++) {
            b bVar = (b) this.ojD.poll();
            if (bVar == null) {
                bVar = this.ojz.b(this.random);
            }
            d dVar = this.ojA;
            Random random = this.random;
            bVar.okv = 0;
            bVar.okx = 0.0f;
            bVar.okw = 0.0f;
            bVar.okz = 0.0f;
            bVar.oky = 0.0f;
            bVar.ojS = 0.0f;
            bVar.ojQ = 0.0f;
            bVar.ojW = null;
            bVar.ojU = null;
            bVar.okB = null;
            bVar.okA = null;
            bVar.okC = 0.0f;
            bVar.okD = 0.0f;
            bVar.okc = 0.0f;
            bVar.oke = null;
            bVar.okE = null;
            bVar.hMW = 0;
            bVar.okF = 0.0f;
            bVar.okG = 0.0f;
            bVar.ojK = null;
            bVar.okI = 0.0f;
            bVar.okH = 0.0f;
            bVar.okJ = 0.0f;
            bVar.alpha = 255;
            bVar.okK = false;
            bVar.terminated = false;
            bVar.okv = j;
            bVar.okw = (random.nextFloat() * ((float) (dVar.okl - dVar.okj))) + ((float) dVar.okj);
            bVar.okx = (((float) (dVar.okm - dVar.okk)) * random.nextFloat()) + ((float) dVar.okk);
            bVar.oky = a(this.ojM, this.ojN, random);
            bVar.okz = a(this.ojO, this.ojP, random);
            bVar.ojQ = a(this.ojQ, this.ojR, random);
            bVar.ojS = a(this.ojS, this.ojT, random);
            bVar.ojU = this.ojU == null ? null : Float.valueOf(a(this.ojU.floatValue(), this.ojV.floatValue(), random));
            bVar.ojW = this.ojW == null ? null : Float.valueOf(a(this.ojW.floatValue(), this.ojX.floatValue(), random));
            bVar.okC = a((float) this.ojY, (float) this.ojZ, random);
            bVar.okD = a(this.oka, this.okb, random);
            bVar.okc = a(this.okc, this.okd, random);
            bVar.oke = this.oke == null ? null : Float.valueOf(a(this.oke.floatValue(), this.okf.floatValue(), random));
            bVar.hMW = this.hMW;
            bVar.ojK = this.ojK;
            bVar.okF = a(this.okg, this.okh, random);
            bVar.g(this.ojL);
            this.ojE.add(bVar);
        }
    }

    private static float a(float f, float f2, Random random) {
        return (((random.nextFloat() * 2.0f) - 1.0f) * f2) + f;
    }
}
