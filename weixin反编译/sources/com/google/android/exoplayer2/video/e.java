package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.d;

public interface e {

    public static final class a {
        final e aEa;
        final Handler handler;

        /* renamed from: com.google.android.exoplayer2.video.e$a$2 */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ String afE;
            final /* synthetic */ long afF;
            final /* synthetic */ long afG;

            AnonymousClass2(String str, long j, long j2) {
                this.afE = str;
                this.afF = j;
                this.afG = j2;
            }

            public final void run() {
            }
        }

        /* renamed from: com.google.android.exoplayer2.video.e$a$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ d afC;

            AnonymousClass1(d dVar) {
                this.afC = dVar;
            }

            public final void run() {
                a.this.aEa.a(this.afC);
            }
        }

        /* renamed from: com.google.android.exoplayer2.video.e$a$4 */
        class AnonymousClass4 implements Runnable {
            final /* synthetic */ int aEc;
            final /* synthetic */ long aEd;

            AnonymousClass4(int i, long j) {
                this.aEc = i;
                this.aEd = j;
            }

            public final void run() {
            }
        }

        /* renamed from: com.google.android.exoplayer2.video.e$a$3 */
        class AnonymousClass3 implements Runnable {
            final /* synthetic */ Format afH;

            AnonymousClass3(Format format) {
                this.afH = format;
            }

            public final void run() {
                a.this.aEa.c(this.afH);
            }
        }

        public a(Handler handler, e eVar) {
            this.handler = eVar != null ? (Handler) com.google.android.exoplayer2.i.a.Y(handler) : null;
            this.aEa = eVar;
        }

        public final void b(int i, int i2, int i3, float f) {
            if (this.aEa != null) {
                final int i4 = i;
                final int i5 = i2;
                final int i6 = i3;
                final float f2 = f;
                this.handler.post(new Runnable() {
                    public final void run() {
                        a.this.aEa.a(i4, i5, i6, f2);
                    }
                });
            }
        }

        public final void c(final Surface surface) {
            if (this.aEa != null) {
                this.handler.post(new Runnable() {
                    public final void run() {
                        a.this.aEa.b(surface);
                    }
                });
            }
        }

        public final void e(final d dVar) {
            if (this.aEa != null) {
                this.handler.post(new Runnable() {
                    public final void run() {
                        dVar.jd();
                        a.this.aEa.b(dVar);
                    }
                });
            }
        }
    }

    void a(int i, int i2, int i3, float f);

    void a(d dVar);

    void b(Surface surface);

    void b(d dVar);

    void c(Format format);
}
