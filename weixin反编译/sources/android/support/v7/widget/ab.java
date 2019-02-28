package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;

public abstract class ab {
    protected final h TG;
    int TH;

    /* renamed from: android.support.v7.widget.ab$1 */
    static class AnonymousClass1 extends ab {
        AnonymousClass1(h hVar) {
            super(hVar, (byte) 0);
        }

        public final int fk() {
            return this.TG.mWidth - this.TG.getPaddingRight();
        }

        public final int getEnd() {
            return this.TG.mWidth;
        }

        public final void bh(int i) {
            this.TG.bn(i);
        }

        public final int fj() {
            return this.TG.getPaddingLeft();
        }

        public final int aW(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.rightMargin + (h.bf(view) + layoutParams.leftMargin);
        }

        public final int aX(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.bottomMargin + (h.bg(view) + layoutParams.topMargin);
        }

        public final int aV(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.rightMargin + h.bj(view);
        }

        public final int aU(View view) {
            return h.bh(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
        }

        public final int fl() {
            return (this.TG.mWidth - this.TG.getPaddingLeft()) - this.TG.getPaddingRight();
        }

        public final int getEndPadding() {
            return this.TG.getPaddingRight();
        }

        public final int getMode() {
            return this.TG.Vf;
        }

        public final int fm() {
            return this.TG.Vg;
        }
    }

    /* renamed from: android.support.v7.widget.ab$2 */
    static class AnonymousClass2 extends ab {
        AnonymousClass2(h hVar) {
            super(hVar, (byte) 0);
        }

        public final int fk() {
            return this.TG.mHeight - this.TG.getPaddingBottom();
        }

        public final int getEnd() {
            return this.TG.mHeight;
        }

        public final void bh(int i) {
            this.TG.bo(i);
        }

        public final int fj() {
            return this.TG.getPaddingTop();
        }

        public final int aW(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.bottomMargin + (h.bg(view) + layoutParams.topMargin);
        }

        public final int aX(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.rightMargin + (h.bf(view) + layoutParams.leftMargin);
        }

        public final int aV(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.bottomMargin + h.bk(view);
        }

        public final int aU(View view) {
            return h.bi(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
        }

        public final int fl() {
            return (this.TG.mHeight - this.TG.getPaddingTop()) - this.TG.getPaddingBottom();
        }

        public final int getEndPadding() {
            return this.TG.getPaddingBottom();
        }

        public final int getMode() {
            return this.TG.Vg;
        }

        public final int fm() {
            return this.TG.Vf;
        }
    }

    public abstract int aU(View view);

    public abstract int aV(View view);

    public abstract int aW(View view);

    public abstract int aX(View view);

    public abstract void bh(int i);

    public abstract int fj();

    public abstract int fk();

    public abstract int fl();

    public abstract int fm();

    public abstract int getEnd();

    public abstract int getEndPadding();

    public abstract int getMode();

    /* synthetic */ ab(h hVar, byte b) {
        this(hVar);
    }

    private ab(h hVar) {
        this.TH = Integer.MIN_VALUE;
        this.TG = hVar;
    }

    public final int fi() {
        return Integer.MIN_VALUE == this.TH ? 0 : fl() - this.TH;
    }
}
