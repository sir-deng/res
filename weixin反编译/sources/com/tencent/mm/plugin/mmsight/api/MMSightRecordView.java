package com.tencent.mm.plugin.mmsight.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class MMSightRecordView extends FrameLayout {
    public static b owE;
    public d owD;

    public interface a {
    }

    public interface b {
        d Yj();
    }

    public static abstract class d {
        public abstract void R(float f);

        public abstract String Yk();

        public abstract void Yl();

        public abstract Point Yn();

        public abstract Point Yo();

        public abstract int Ys();

        public abstract void Yt();

        public abstract void Yu();

        public abstract Bitmap Yv();

        public abstract void a(a aVar);

        public abstract void a(c cVar);

        public abstract void a(e eVar, boolean z);

        public abstract void a(f fVar);

        public abstract void b(Context context, ViewGroup viewGroup);

        public abstract void cm(boolean z);

        public abstract void cn(boolean z);

        public abstract void co(boolean z);

        public abstract void h(int i, int i2, int i3, int i4, int i5);

        public abstract void js(int i);

        public abstract void jt(int i);

        public abstract void ph(String str);

        public abstract void release();

        public abstract void startPreview();

        public abstract void switchCamera();

        public abstract boolean vs();
    }

    public interface f {
        void cL(boolean z);
    }

    public interface c {
        void agx();
    }

    public interface e {
        void agw();

        void r(Bitmap bitmap);
    }

    public MMSightRecordView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public MMSightRecordView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public MMSightRecordView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.owD = owE.Yj();
        this.owD.b(context, this);
    }

    public final void R(float f) {
        this.owD.R(f);
    }

    public final void js(int i) {
        this.owD.js(i);
    }

    public final void tc(int i) {
        this.owD.h(i, 4800000, 30, 64000, 44100);
    }

    public final void ph(String str) {
        this.owD.ph(str);
    }

    public final void a(f fVar) {
        this.owD.a(fVar);
    }

    public final void a(e eVar, boolean z) {
        this.owD.a(eVar, z);
    }

    public final void a(a aVar) {
        this.owD.a(aVar);
    }

    public final void bax() {
        this.owD.cn(true);
    }

    public final void bay() {
        this.owD.co(true);
    }

    public final void jt(int i) {
        this.owD.jt(i);
    }
}
