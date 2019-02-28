package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

final class s {
    final b QB;
    final a QC = new a();
    final List<View> QD = new ArrayList();

    static class a {
        long QE = 0;
        a QF;

        a() {
        }

        final void set(int i) {
            while (i >= 64) {
                eH();
                this = this.QF;
                i -= 64;
            }
            this.QE |= 1 << i;
        }

        private void eH() {
            if (this.QF == null) {
                this.QF = new a();
            }
        }

        final void clear(int i) {
            while (i >= 64) {
                if (this.QF != null) {
                    this = this.QF;
                    i -= 64;
                } else {
                    return;
                }
            }
            this.QE &= (1 << i) ^ -1;
        }

        final boolean get(int i) {
            while (i >= 64) {
                eH();
                this = this.QF;
                i -= 64;
            }
            return (this.QE & (1 << i)) != 0;
        }

        final void g(int i, boolean z) {
            while (true) {
                if (i >= 64) {
                    eH();
                    this = this.QF;
                    i -= 64;
                } else {
                    boolean z2 = (this.QE & Long.MIN_VALUE) != 0;
                    long j = (1 << i) - 1;
                    this.QE = (((j ^ -1) & this.QE) << 1) | (this.QE & j);
                    if (z) {
                        set(i);
                    } else {
                        clear(i);
                    }
                    if (z2 || this.QF != null) {
                        eH();
                        this = this.QF;
                        i = 0;
                        z = z2;
                    } else {
                        return;
                    }
                }
            }
        }

        final boolean aV(int i) {
            while (i >= 64) {
                eH();
                this = this.QF;
                i -= 64;
            }
            long j = 1 << i;
            boolean z = (this.QE & j) != 0;
            this.QE &= j ^ -1;
            j--;
            this.QE = Long.rotateRight((j ^ -1) & this.QE, 1) | (this.QE & j);
            if (this.QF != null) {
                if (this.QF.get(0)) {
                    set(63);
                }
                this.QF.aV(0);
            }
            return z;
        }

        final int aW(int i) {
            if (this.QF == null) {
                if (i >= 64) {
                    return Long.bitCount(this.QE);
                }
                return Long.bitCount(this.QE & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.QE & ((1 << i) - 1));
            } else {
                return this.QF.aW(i - 64) + Long.bitCount(this.QE);
            }
        }

        public final String toString() {
            return this.QF == null ? Long.toBinaryString(this.QE) : this.QF.toString() + "xx" + Long.toBinaryString(this.QE);
        }
    }

    interface b {
        t aP(View view);

        void aQ(View view);

        void aR(View view);

        void addView(View view, int i);

        void attachViewToParent(View view, int i, LayoutParams layoutParams);

        void detachViewFromParent(int i);

        View getChildAt(int i);

        int getChildCount();

        int indexOfChild(View view);

        void removeAllViews();

        void removeViewAt(int i);
    }

    s(b bVar) {
        this.QB = bVar;
    }

    final void aM(View view) {
        this.QD.add(view);
        this.QB.aQ(view);
    }

    final boolean aN(View view) {
        if (!this.QD.remove(view)) {
            return false;
        }
        this.QB.aR(view);
        return true;
    }

    final void a(View view, int i, boolean z) {
        int childCount;
        if (i < 0) {
            childCount = this.QB.getChildCount();
        } else {
            childCount = aT(i);
        }
        this.QC.g(childCount, z);
        if (z) {
            aM(view);
        }
        this.QB.addView(view, childCount);
    }

    final int aT(int i) {
        if (i < 0) {
            return -1;
        }
        int childCount = this.QB.getChildCount();
        int i2 = i;
        while (i2 < childCount) {
            int aW = i - (i2 - this.QC.aW(i2));
            if (aW == 0) {
                while (this.QC.get(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += aW;
        }
        return -1;
    }

    final View getChildAt(int i) {
        return this.QB.getChildAt(aT(i));
    }

    final void a(View view, int i, LayoutParams layoutParams, boolean z) {
        int childCount;
        if (i < 0) {
            childCount = this.QB.getChildCount();
        } else {
            childCount = aT(i);
        }
        this.QC.g(childCount, z);
        if (z) {
            aM(view);
        }
        this.QB.attachViewToParent(view, childCount, layoutParams);
    }

    final int getChildCount() {
        return this.QB.getChildCount() - this.QD.size();
    }

    final int eG() {
        return this.QB.getChildCount();
    }

    final View aU(int i) {
        return this.QB.getChildAt(i);
    }

    final void detachViewFromParent(int i) {
        int aT = aT(i);
        this.QC.aV(aT);
        this.QB.detachViewFromParent(aT);
    }

    final int indexOfChild(View view) {
        int indexOfChild = this.QB.indexOfChild(view);
        if (indexOfChild == -1 || this.QC.get(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.QC.aW(indexOfChild);
    }

    final boolean aO(View view) {
        return this.QD.contains(view);
    }

    public final String toString() {
        return this.QC.toString() + ", hidden list:" + this.QD.size();
    }
}
