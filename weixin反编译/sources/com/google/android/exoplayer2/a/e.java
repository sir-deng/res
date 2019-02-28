package com.google.android.exoplayer2.a;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.d;

public interface e {

    public static final class a {
        final e afB;
        final Handler handler;

        /* renamed from: com.google.android.exoplayer2.a.e$a$4 */
        class AnonymousClass4 implements Runnable {
            final /* synthetic */ int afI;
            final /* synthetic */ long afJ;
            final /* synthetic */ long afK;

            AnonymousClass4(int i, long j, long j2) {
                this.afI = i;
                this.afJ = j;
                this.afK = j2;
            }

            public final void run() {
                a.this.afB.c(this.afI, this.afJ, this.afK);
            }
        }

        /* renamed from: com.google.android.exoplayer2.a.e$a$6 */
        class AnonymousClass6 implements Runnable {
            final /* synthetic */ int afM;

            AnonymousClass6(int i) {
                this.afM = i;
            }

            public final void run() {
                a.this.afB.bW(this.afM);
            }
        }

        /* renamed from: com.google.android.exoplayer2.a.e$a$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ d afC;

            AnonymousClass1(d dVar) {
                this.afC = dVar;
            }

            public final void run() {
                a.this.afB.c(this.afC);
            }
        }

        /* renamed from: com.google.android.exoplayer2.a.e$a$2 */
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
                a.this.afB.a(this.afE, this.afF, this.afG);
            }
        }

        /* renamed from: com.google.android.exoplayer2.a.e$a$3 */
        class AnonymousClass3 implements Runnable {
            final /* synthetic */ Format afH;

            AnonymousClass3(Format format) {
                this.afH = format;
            }

            public final void run() {
                a.this.afB.d(this.afH);
            }
        }

        public a(Handler handler, e eVar) {
            this.handler = eVar != null ? (Handler) com.google.android.exoplayer2.i.a.Y(handler) : null;
            this.afB = eVar;
        }

        public final void e(final d dVar) {
            if (this.afB != null) {
                this.handler.post(new Runnable() {
                    public final void run() {
                        dVar.jd();
                        a.this.afB.d(dVar);
                    }
                });
            }
        }
    }

    void a(String str, long j, long j2);

    void bW(int i);

    void c(int i, long j, long j2);

    void c(d dVar);

    void d(Format format);

    void d(d dVar);
}
