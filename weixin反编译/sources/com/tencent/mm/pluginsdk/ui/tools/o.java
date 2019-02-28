package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.platformtools.x;

public final class o {
    d jwx = d.DEFAULT;
    int kJB;
    int kJC;
    boolean vEW;
    int vFG;
    int vFH;
    int videoHeight;
    int videoWidth;

    final void reset() {
        this.kJC = 0;
        this.kJB = 0;
        this.videoHeight = 0;
        this.videoWidth = 0;
        this.vFH = 0;
        this.vFG = 0;
    }

    public final void a(d dVar) {
        x.i("MicroMsg.ViewSizeCache", "set scale type old[%s] new[%s]", this.jwx, dVar);
        this.jwx = dVar;
        reset();
    }

    final boolean u(int i, int i2, int i3, int i4) {
        if (this.kJB == i && this.kJC == i2 && this.videoWidth == i3 && this.videoHeight == i4) {
            return true;
        }
        this.kJB = i;
        this.kJC = i2;
        this.videoWidth = i3;
        this.videoHeight = i4;
        float f = (((float) this.videoWidth) * 1.0f) / ((float) this.videoHeight);
        float f2 = (((float) this.kJB) * 1.0f) / ((float) this.kJC);
        if (this.jwx != d.DEFAULT) {
            if (this.jwx == d.CONTAIN) {
                if (this.kJB < this.kJC) {
                    this.vFH = (int) (((float) this.kJB) / f);
                    this.vFG = this.kJB;
                    if (this.vFH > this.kJC) {
                        this.vFG = (int) (((float) this.kJC) * f);
                        this.vFH = this.kJC;
                    }
                } else {
                    this.vFG = (int) (((float) this.kJC) * f);
                    this.vFH = this.kJC;
                    if (this.vFG > this.kJB) {
                        this.vFH = (int) (((float) this.kJB) / f);
                        this.vFG = this.kJB;
                    }
                }
            } else if (this.jwx == d.FILL) {
                this.vFH = this.kJC;
                this.vFG = this.kJB;
            } else if (this.jwx == d.COVER) {
                if (this.kJB > this.kJC) {
                    this.vFH = (int) (((float) this.kJB) / f);
                    this.vFG = this.kJB;
                    if (this.vFH < this.kJC) {
                        this.vFG = (int) (((float) this.kJC) * f);
                        this.vFH = this.kJC;
                    }
                } else {
                    this.vFG = (int) (((float) this.kJC) * f);
                    this.vFH = this.kJC;
                    if (this.vFG < this.kJB) {
                        this.vFH = (int) (((float) this.kJB) / f);
                        this.vFG = this.kJB;
                    }
                }
            }
            x.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", Integer.valueOf(this.kJB), Integer.valueOf(this.kJC), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.vFG), Integer.valueOf(this.vFH), Float.valueOf(f2), Float.valueOf(f));
            return false;
        }
        if (this.vEW) {
            if (((double) Math.abs(f - f2)) > 0.05d) {
                if (this.kJB < this.kJC) {
                    this.vFH = (int) (((float) this.kJB) / f);
                    this.vFG = this.kJB;
                } else {
                    this.vFG = (int) (((float) this.kJC) * f);
                    this.vFH = this.kJC;
                }
            } else if (this.kJB > this.kJC) {
                this.vFH = (int) (((float) this.kJB) / f);
                this.vFG = this.kJB;
            } else {
                this.vFG = (int) (((float) this.kJC) * f);
                this.vFH = this.kJC;
            }
        } else if (this.kJB < this.kJC) {
            this.vFH = (int) (((float) this.kJB) / f);
            this.vFG = this.kJB;
        } else {
            this.vFG = (int) (((float) this.kJC) * f);
            this.vFH = this.kJC;
        }
        x.d("MicroMsg.ViewSizeCache", "screen[%d, %d], video[%d, %d], measure[%d, %d] scale[%f, %f]", Integer.valueOf(this.kJB), Integer.valueOf(this.kJC), Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight), Integer.valueOf(this.vFG), Integer.valueOf(this.vFH), Float.valueOf(f2), Float.valueOf(f));
        return false;
    }
}
