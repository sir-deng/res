package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.pluginsdk.k.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class WalletScratchShakeView extends FrameLayout {
    b ted;
    boolean tee;
    boolean tef;
    a teg;

    public interface a {
        void bNO();

        void ka(boolean z);
    }

    private class b extends View {
        private int jrd = 0;
        long kIG;
        int nsl;
        c oTo;
        private Bitmap rrL;
        private boolean tdS = false;
        private Canvas teh;
        Paint tei;
        Drawable tej;
        Paint tek;
        Paint tel;
        Path tem;
        Path ten;
        private float teo;
        private float tep;
        private int[] teq;
        private int ter = -1;
        boolean tes;
        boolean tet;
        float teu;
        float tev;
        int tew;
        private boolean tex;
        boolean tey;
        private float tez = 0.9f;

        static /* synthetic */ void d(b bVar) {
            if (bVar.tey) {
                x.i("MicroMsg.WalletScratchShakeView", "onStartShakeOrClick, already finish clear mask");
            } else if (!bVar.bNP()) {
                if (bVar.tex) {
                    bVar.tev += (float) (bVar.getHeight() / 6);
                    bVar.bNQ();
                } else {
                    bVar.teu += (float) (bVar.getHeight() / 6);
                    bVar.bNQ();
                }
                bVar.tex = !bVar.tex;
                if (!bVar.tes) {
                    ah.h(new Runnable() {
                        public final void run() {
                            if (WalletScratchShakeView.this.teg != null) {
                                WalletScratchShakeView.this.teg.ka(false);
                            }
                        }
                    }, 50);
                    bVar.tes = true;
                }
                bVar.bNP();
            }
        }

        static /* synthetic */ void e(b bVar) {
            int width = bVar.getWidth();
            int height = bVar.getHeight();
            bVar.rrL.getPixels(bVar.teq, 0, width, 0, 0, width, height);
            float f = (float) (width * height);
            float f2 = 0.0f;
            for (int i = 0; ((float) i) < f; i++) {
                if (bVar.teq[i] == 0) {
                    f2 += 1.0f;
                }
            }
            f2 = (f2 < 0.0f || f <= 0.0f) ? 0.0f : f2 / f;
            x.i("MicroMsg.WalletScratchShakeView", "erasePercent: %s", Float.valueOf(f2));
            x.i("MicroMsg.WalletScratchShakeView", "");
            if (f2 >= bVar.tez) {
                bVar.tey = true;
                if (!bVar.tet) {
                    ah.y(new Runnable() {
                        public final void run() {
                            b.this.animate().alpha(0.0f).setDuration(100);
                            if (WalletScratchShakeView.this.teg != null) {
                                WalletScratchShakeView.this.teg.bNO();
                            }
                        }
                    });
                    bVar.tet = true;
                }
            }
        }

        public b(Context context) {
            super(context);
        }

        static byte[] K(Bitmap bitmap) {
            int i = 0;
            int[] iArr = new int[]{30, bitmap.getWidth() / 3, bitmap.getWidth() - (bitmap.getWidth() / 3), bitmap.getWidth() - 30};
            int[] iArr2 = new int[]{0, bitmap.getHeight()};
            ByteBuffer order = ByteBuffer.allocate(92).order(ByteOrder.nativeOrder());
            order.put((byte) 1);
            order.put((byte) 4);
            order.put((byte) 2);
            order.put((byte) 9);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(0);
            order.putInt(iArr[0]);
            order.putInt(iArr[1]);
            order.putInt(iArr[2]);
            order.putInt(iArr[3]);
            order.putInt(iArr2[0]);
            order.putInt(iArr2[1]);
            while (i < 9) {
                order.putInt(1);
                i++;
            }
            return order.array();
        }

        private boolean bNP() {
            if (this.tev < ((float) getHeight())) {
                return false;
            }
            this.tey = true;
            if (!this.tet) {
                if (WalletScratchShakeView.this.teg != null) {
                    WalletScratchShakeView.this.teg.bNO();
                }
                this.tet = true;
            }
            if (this.teh != null) {
                this.ten.reset();
                this.ten.moveTo(0.0f, 0.0f);
                this.ten.lineTo((float) getWidth(), 0.0f);
                this.ten.lineTo((float) getWidth(), (float) getHeight());
                this.ten.lineTo(0.0f, (float) getHeight());
                this.teh.drawPath(this.ten, this.tel);
            }
            invalidate();
            return true;
        }

        private void bNQ() {
            if (this.teh != null) {
                this.ten.reset();
                this.ten.moveTo(0.0f, this.tev);
                this.ten.cubicTo((float) (getWidth() / 2), (float) getHeight(), (float) (getWidth() / 2), 0.0f, (float) getWidth(), this.teu);
                this.ten.lineTo((float) getWidth(), 0.0f);
                this.ten.lineTo(0.0f, 0.0f);
                this.teh.drawPath(this.ten, this.tel);
            }
            invalidate();
        }

        protected final void onDraw(Canvas canvas) {
            canvas.save();
            if (this.rrL == null) {
                int width = getWidth();
                int height = getHeight();
                x.i("MicroMsg.WalletScratchShakeView", "createMasker width: %s, height: %s, waterMark: %s", Integer.valueOf(width), Integer.valueOf(height), this.tej);
                this.rrL = Bitmap.createBitmap(width, height, Config.ARGB_8888);
                this.teh = new Canvas(this.rrL);
                if (this.tej != null) {
                    this.tej.setBounds(new Rect(0, 0, width, height));
                    this.tej.draw(this.teh);
                }
                this.teq = new int[(width * height)];
            }
            canvas.drawBitmap(this.rrL, 0.0f, 0.0f, this.tei);
            canvas.restore();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onTouchEvent(android.view.MotionEvent r8) {
            /*
            r7 = this;
            r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
            r3 = 0;
            r1 = 1;
            r0 = com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.this;
            r0 = r0.tef;
            if (r0 != 0) goto L_0x0011;
        L_0x000c:
            r1 = super.onTouchEvent(r8);
        L_0x0010:
            return r1;
        L_0x0011:
            r2 = r8.getAction();
            r0 = 0;
            switch(r2) {
                case 0: goto L_0x002a;
                case 1: goto L_0x00a9;
                case 2: goto L_0x0055;
                case 3: goto L_0x00a9;
                default: goto L_0x0019;
            };
        L_0x0019:
            r2 = r7.tey;
            if (r2 != 0) goto L_0x0025;
        L_0x001d:
            r2 = r7.E(r8);
            if (r2 != 0) goto L_0x0025;
        L_0x0023:
            if (r0 != 0) goto L_0x0010;
        L_0x0025:
            r1 = super.onTouchEvent(r8);
            goto L_0x0010;
        L_0x002a:
            r0 = r8.getX();
            r2 = r8.getY();
            r3 = r7.tem;
            r3.reset();
            r3 = r7.tem;
            r3.moveTo(r0, r2);
            r7.teo = r0;
            r7.tep = r2;
            r7.invalidate();
            r0 = r7.tes;
            if (r0 != 0) goto L_0x00c0;
        L_0x0047:
            r0 = new com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView$b$3;
            r0.<init>();
            r2 = 50;
            com.tencent.mm.sdk.platformtools.ah.h(r0, r2);
            r7.tes = r1;
            r0 = r1;
            goto L_0x0019;
        L_0x0055:
            r0 = r8.getX();
            r2 = r8.getY();
            r3 = r7.teh;
            if (r3 == 0) goto L_0x00a3;
        L_0x0061:
            r3 = r7.teo;
            r3 = r0 - r3;
            r3 = java.lang.Math.abs(r3);
            r3 = (int) r3;
            r4 = r7.tep;
            r4 = r2 - r4;
            r4 = java.lang.Math.abs(r4);
            r4 = (int) r4;
            r5 = r7.nsl;
            if (r3 >= r5) goto L_0x007b;
        L_0x0077:
            r3 = r7.nsl;
            if (r4 < r3) goto L_0x00a3;
        L_0x007b:
            r7.teo = r0;
            r7.tep = r2;
            r3 = r7.tem;
            r4 = r7.teo;
            r4 = r4 + r0;
            r4 = r4 / r6;
            r5 = r7.tep;
            r5 = r5 + r2;
            r5 = r5 / r6;
            r3.quadTo(r4, r5, r0, r2);
            r0 = r7.teh;
            r2 = r7.tem;
            r3 = r7.tek;
            r0.drawPath(r2, r3);
            r0 = r7.tem;
            r0.reset();
            r0 = r7.tem;
            r2 = r7.teo;
            r3 = r7.tep;
            r0.moveTo(r2, r3);
        L_0x00a3:
            r7.invalidate();
            r0 = r1;
            goto L_0x0019;
        L_0x00a9:
            r7.teo = r3;
            r7.tep = r3;
            r0 = r7.tem;
            r0.reset();
            r0 = new com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView$b$4;
            r0.<init>();
            r2 = "ScratchShakeView_calcErasePercentAndCallEnd";
            com.tencent.mm.sdk.f.e.post(r0, r2);
            r7.invalidate();
        L_0x00c0:
            r0 = r1;
            goto L_0x0019;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.b.onTouchEvent(android.view.MotionEvent):boolean");
        }

        public final boolean E(MotionEvent motionEvent) {
            if (this.rrL != null && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 0)) {
                int width = getWidth();
                int height = getHeight();
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                int width2 = getWidth() * getHeight();
                x.d("MicroMsg.WalletScratchShakeView", "checkIsTouchEraseArea, x: %s, y: %s, width: %s, height: %s, index: %s, len: %s", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf((y * width) + x), Integer.valueOf(width2));
                if ((y * width) + x > 0 && x > 0 && y > 0 && x < getWidth() && y < getHeight()) {
                    if (this.rrL.getPixel(x, y) == 0) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        }
    }

    public WalletScratchShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletScratchShakeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void onDestroy() {
        if (this.ted != null) {
            b bVar = this.ted;
            x.i("MicroMsg.WalletScratchShakeView", "onDestroy");
            if (bVar.oTo != null) {
                bVar.oTo.aQC();
            }
        }
    }
}
