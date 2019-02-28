package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.h.i;
import java.io.IOException;

public interface a {

    public static final class a {
        public final a ars;
        private final long art;
        public final Handler handler;

        /* renamed from: com.google.android.exoplayer2.source.a$a$1 */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ long arA;
            final /* synthetic */ long arB;
            final /* synthetic */ long arC;
            final /* synthetic */ i aru;
            final /* synthetic */ int arv;
            final /* synthetic */ int arw;
            final /* synthetic */ Format arx;
            final /* synthetic */ int ary;
            final /* synthetic */ Object arz;

            public AnonymousClass1(i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3) {
                this.aru = iVar;
                this.arv = i;
                this.arw = i2;
                this.arx = format;
                this.ary = i3;
                this.arz = obj;
                this.arA = j;
                this.arB = j2;
                this.arC = j3;
            }

            public final void run() {
                a.a(a.this, this.arA);
                a.a(a.this, this.arB);
            }
        }

        /* renamed from: com.google.android.exoplayer2.source.a$a$5 */
        class AnonymousClass5 implements Runnable {
            final /* synthetic */ long arI;
            final /* synthetic */ int arw;
            final /* synthetic */ Format arx;
            final /* synthetic */ int ary;
            final /* synthetic */ Object arz;

            public AnonymousClass5(int i, Format format, int i2, Object obj, long j) {
                this.arw = i;
                this.arx = format;
                this.ary = i2;
                this.arz = obj;
                this.arI = j;
            }

            public final void run() {
                a.a(a.this, this.arI);
            }
        }

        static /* synthetic */ long a(a aVar, long j) {
            long j2 = b.j(j);
            return j2 == -9223372036854775807L ? -9223372036854775807L : aVar.art + j2;
        }

        public a(Handler handler, a aVar) {
            this(handler, aVar, (byte) 0);
        }

        private a(Handler handler, a aVar, byte b) {
            this.handler = aVar != null ? (Handler) com.google.android.exoplayer2.i.a.Y(handler) : null;
            this.ars = aVar;
            this.art = 0;
        }

        public final void a(i iVar, long j, long j2, long j3) {
            a(iVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
        }

        public final void a(i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            if (this.ars != null) {
                final i iVar2 = iVar;
                final int i4 = i;
                final int i5 = i2;
                final Format format2 = format;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j6 = j;
                final long j7 = j2;
                final long j8 = j3;
                final long j9 = j4;
                final long j10 = j5;
                this.handler.post(new Runnable() {
                    public final void run() {
                        a aVar = a.this.ars;
                        a.a(a.this, j6);
                        a.a(a.this, j7);
                        aVar.jV();
                    }
                });
            }
        }

        public final void b(i iVar, long j, long j2, long j3) {
            b(iVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3);
        }

        public final void b(i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5) {
            if (this.ars != null) {
                final i iVar2 = iVar;
                final int i4 = i;
                final int i5 = i2;
                final Format format2 = format;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j6 = j;
                final long j7 = j2;
                final long j8 = j3;
                final long j9 = j4;
                final long j10 = j5;
                this.handler.post(new Runnable() {
                    public final void run() {
                        a.a(a.this, j6);
                        a.a(a.this, j7);
                    }
                });
            }
        }

        public final void a(i iVar, long j, long j2, long j3, IOException iOException, boolean z) {
            a(iVar, 4, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, j, j2, j3, iOException, z);
        }

        public final void a(i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
            if (this.ars != null) {
                final i iVar2 = iVar;
                final int i4 = i;
                final int i5 = i2;
                final Format format2 = format;
                final int i6 = i3;
                final Object obj2 = obj;
                final long j6 = j;
                final long j7 = j2;
                final long j8 = j3;
                final long j9 = j4;
                final long j10 = j5;
                final IOException iOException2 = iOException;
                final boolean z2 = z;
                this.handler.post(new Runnable() {
                    public final void run() {
                        a aVar = a.this.ars;
                        i iVar = iVar2;
                        Format format = format2;
                        a.a(a.this, j6);
                        a.a(a.this, j7);
                        aVar.a(iVar, format, iOException2);
                    }
                });
            }
        }

        public final void jX() {
            this.handler.post(new Runnable() {
                public final void run() {
                    a.this.ars.jW();
                }
            });
        }
    }

    void a(i iVar, Format format, IOException iOException);

    void jV();

    void jW();
}
