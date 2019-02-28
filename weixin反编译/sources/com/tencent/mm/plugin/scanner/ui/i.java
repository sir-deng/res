package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public abstract class i {
    protected ProgressDialog inI = null;
    protected TextView jIt;
    GestureDetector mbL;
    protected Point mmK;
    protected long qde;
    protected Rect qdf;
    protected com.tencent.mm.plugin.scanner.util.b qdg;
    protected Point qdh;
    protected int qdi;
    protected int qdj;
    protected int qdk = 40;
    protected int qdl = 20;
    protected b qdm;
    protected int qdn;
    protected boolean qdo;
    protected ag qdp = new ag() {
        public final void handleMessage(Message message) {
            if (message != null && message.what == 1 && i.this.jIt != null) {
                i.this.jIt.setVisibility(0);
            }
        }
    };

    public interface a {
        void b(Activity activity, int i, int i2, Intent intent);
    }

    public interface b {
        void W(int i, int i2, int i3);

        void a(a aVar);

        void a(String str, int i, int i2, int i3, com.tencent.mm.plugin.scanner.util.e.a aVar);

        void b(int i, OnClickListener onClickListener);

        void bpC();

        void bpH();

        boolean bpI();

        void bpJ();

        void bpK();

        void bpM();

        void eh(long j);

        void ei(long j);

        View findViewById(int i);

        Activity getContext();

        void hL(boolean z);
    }

    protected abstract void bpt();

    protected abstract com.tencent.mm.plugin.scanner.util.b bpu();

    protected abstract int bpv();

    protected abstract int bpw();

    protected abstract void bpx();

    protected abstract boolean bpy();

    protected abstract boolean bpz();

    protected abstract void h(Rect rect);

    protected abstract void onDestroy();

    protected abstract void onResume();

    public final b bpV() {
        return this.qdm;
    }

    protected final void hN(boolean z) {
        if (this.jIt != null) {
            if (z) {
                this.jIt.setVisibility(4);
                this.qdp.sendEmptyMessageDelayed(1, 210);
                return;
            }
            this.qdp.removeMessages(1);
            this.jIt.setVisibility(4);
        }
    }

    public i(b bVar, Point point) {
        this.qdm = bVar;
        this.qdh = point;
    }

    public i(b bVar, Point point, byte b) {
        this.qdm = bVar;
        this.qdh = point;
        this.qdk = 50;
    }

    protected void onPause() {
        if (this.inI != null && this.inI.isShowing()) {
            this.inI.dismiss();
        }
    }

    public final void e(Point point) {
        this.qdh = point;
    }

    protected void cr(View view) {
    }

    protected final double dp(int i, int i2) {
        Context context = this.qdm.getContext();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        double d = ((double) displayMetrics.densityDpi) / 160.0d;
        x.d("MicroMsg.scanner.ScanMode", "dpiLevel [%s]", Double.valueOf(d));
        if (d > 1.2d) {
            if (this.qdh.x + this.qdh.y <= 3000 || d >= 2.4d) {
                this.qdi = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qdm.getContext(), (float) i);
                this.qdj = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qdm.getContext(), (float) i2);
            } else {
                this.qdi = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qdm.getContext(), ((float) i) * 1.6f);
                this.qdj = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qdm.getContext(), ((float) i2) * 1.6f);
                if (this instanceof j) {
                    int i3 = (int) (((double) this.qdh.y) * 0.8d);
                    int i4 = (int) (((double) this.qdh.x) * 0.8d);
                    if (this.qdi > i3 && this.qdj > i4) {
                        float f = 1.5f;
                        while (this.qdi > i3 && this.qdj > i4) {
                            this.qdi = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qdm.getContext(), ((float) i) * f);
                            this.qdj = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qdm.getContext(), ((float) i2) * f);
                            f -= 0.1f;
                        }
                        x.i("MicroMsg.scanner.ScanMode", "final adjust ratio: %s", Float.valueOf(f));
                    }
                }
            }
        } else if (this.qdh != null && this.qdh.x + this.qdh.y > 1560) {
            this.qdi = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qdm.getContext(), ((float) i) * 1.7f);
            this.qdj = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qdm.getContext(), ((float) i2) * 1.7f);
        } else if (this.qdh == null || this.qdh.x + this.qdh.y <= 1460) {
            this.qdi = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qdm.getContext(), ((float) i) / 1.1f);
            this.qdj = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qdm.getContext(), ((float) i2) / 1.1f);
        } else {
            this.qdi = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qdm.getContext(), ((float) i) * 1.1f);
            this.qdj = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qdm.getContext(), ((float) i2) * 1.1f);
        }
        if (this.qdi % 2 == 1) {
            this.qdi++;
        }
        if (this.qdj % 2 == 1) {
            this.qdj++;
        }
        x.d("MicroMsg.scanner.ScanMode", "frame, width:%d, height:%d, visDisplayFrameRes:%s", Integer.valueOf(this.qdi), Integer.valueOf(this.qdj), this.qdh);
        return d;
    }

    protected final Rect y(boolean z, boolean z2) {
        if (this.qdf == null || z) {
            int i;
            int i2;
            int i3;
            int i4 = this.qdh.x;
            int i5 = this.qdh.y;
            int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qdm.getContext(), (float) this.qdk);
            if (this.qdm.bpI()) {
                i = b;
            } else {
                i = 0;
            }
            if (!z2) {
                i2 = (i4 / 2) - (this.qdi / 2);
                i3 = (this.qdi / 2) + (i4 / 2);
                b = (i5 / 2) - (this.qdj / 2);
                if (b - i > 0) {
                    b -= i;
                }
                i = b;
                b = this.qdj + b;
            } else if (i4 < i5) {
                i2 = (i5 / 2) - (this.qdi / 2);
                i3 = (i5 / 2) + (this.qdi / 2);
                i = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qdm.getContext(), (float) this.qdl);
                b = this.qdj + i;
            } else {
                i2 = (i4 / 2) - (this.qdi / 2);
                i3 = (i4 / 2) + (this.qdi / 2);
                i = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(this.qdm.getContext(), (float) this.qdl);
                b = this.qdj + i;
            }
            x.d("MicroMsg.scanner.ScanMode", "framingRect: width = %s, height = %s; left = %s, right = %s, top = %s, bottom = %s", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(b));
            this.qdf = new Rect(i2, i, i3, b);
        }
        return this.qdf;
    }

    protected Rect hO(boolean z) {
        return y(true, z);
    }

    protected void f(Point point) {
        this.mmK = point;
    }

    public final void hP(boolean z) {
        if (this.jIt != null) {
            this.jIt.setVisibility(z ? 0 : 4);
        }
    }

    protected void a(byte[] bArr, Point point, int i, Rect rect) {
        x.i("MicroMsg.scanner.ScanMode", "decode count:" + l.pYQ.pYT);
        if (bpu() != null) {
            bpu().a(bArr, point, i, rect);
            if (l.pYQ.pYT == 30) {
                this.qdm.bpM();
            }
        }
    }
}
