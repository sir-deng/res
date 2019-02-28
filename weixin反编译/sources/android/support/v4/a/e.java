package android.support.v4.a;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

final class e implements c {

    private static class a implements g {
        List<b> eM = new ArrayList();
        long mDuration = 200;
        long mStartTime;
        List<d> oL = new ArrayList();
        View oM;
        float oN = 0.0f;
        private boolean oO = false;
        private boolean oP = false;
        Runnable oQ = new Runnable() {
            public final void run() {
                float drawingTime = (((float) (a.this.oM.getDrawingTime() - a.this.mStartTime)) * 1.0f) / ((float) a.this.mDuration);
                if (drawingTime > 1.0f || a.this.oM.getParent() == null) {
                    drawingTime = 1.0f;
                }
                a.this.oN = drawingTime;
                g gVar = a.this;
                for (int size = gVar.oL.size() - 1; size >= 0; size--) {
                    ((d) gVar.oL.get(size)).b(gVar);
                }
                if (a.this.oN >= 1.0f) {
                    a.this.aO();
                } else {
                    a.this.oM.postDelayed(a.this.oQ, 16);
                }
            }
        };

        public final void w(View view) {
            this.oM = view;
        }

        public final void a(b bVar) {
            this.eM.add(bVar);
        }

        public final void setDuration(long j) {
            if (!this.oO) {
                this.mDuration = j;
            }
        }

        public final void start() {
            if (!this.oO) {
                this.oO = true;
                for (int size = this.eM.size() - 1; size >= 0; size--) {
                    this.eM.get(size);
                }
                this.oN = 0.0f;
                this.mStartTime = this.oM.getDrawingTime();
                this.oM.postDelayed(this.oQ, 16);
            }
        }

        final void aO() {
            for (int size = this.eM.size() - 1; size >= 0; size--) {
                ((b) this.eM.get(size)).a(this);
            }
        }

        public final void cancel() {
            if (!this.oP) {
                this.oP = true;
                if (this.oO) {
                    for (int size = this.eM.size() - 1; size >= 0; size--) {
                        ((b) this.eM.get(size)).aN();
                    }
                }
                aO();
            }
        }

        public final void a(d dVar) {
            this.oL.add(dVar);
        }

        public final float getAnimatedFraction() {
            return this.oN;
        }
    }

    e() {
    }

    public final g aM() {
        return new a();
    }

    public final void v(View view) {
    }
}
