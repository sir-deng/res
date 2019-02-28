package com.google.android.exoplayer2;

import android.content.Context;
import com.google.android.exoplayer2.drm.b;

public final class d implements u {
    private final long acA;
    private final b<com.google.android.exoplayer2.drm.d> acy;
    private final int acz;
    private final Context context;

    public d(Context context) {
        this(context, (byte) 0);
    }

    private d(Context context, byte b) {
        this(context, null);
    }

    private d(Context context, b<com.google.android.exoplayer2.drm.d> bVar) {
        this(context, null, 0);
    }

    private d(Context context, b<com.google.android.exoplayer2.drm.d> bVar, int i) {
        this.context = context;
        this.acy = bVar;
        this.acz = 0;
        this.acA = 5000;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.exoplayer2.r[] a(android.os.Handler r14, com.google.android.exoplayer2.video.e r15, com.google.android.exoplayer2.a.e r16, com.google.android.exoplayer2.f.j.a r17, com.google.android.exoplayer2.metadata.e.a r18) {
        /*
        r13 = this;
        r11 = new java.util.ArrayList;
        r11.<init>();
        r4 = r13.context;
        r8 = r13.acy;
        r6 = r13.acA;
        r12 = r13.acz;
        r3 = new com.google.android.exoplayer2.video.c;
        r5 = com.google.android.exoplayer2.e.c.aqe;
        r9 = r14;
        r10 = r15;
        r3.<init>(r4, r5, r6, r8, r9, r10);
        r11.add(r3);
        if (r12 == 0) goto L_0x0076;
    L_0x001b:
        r2 = r11.size();
        r3 = 2;
        if (r12 != r3) goto L_0x018f;
    L_0x0022:
        r2 = r2 + -1;
        r3 = r2;
    L_0x0025:
        r2 = "com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer";
        r2 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r4 = 5;
        r4 = new java.lang.Class[r4];	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r5 = 0;
        r8 = java.lang.Boolean.TYPE;	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r4[r5] = r8;	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r5 = 1;
        r8 = java.lang.Long.TYPE;	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r4[r5] = r8;	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r5 = 2;
        r8 = android.os.Handler.class;
        r4[r5] = r8;	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r5 = 3;
        r8 = com.google.android.exoplayer2.video.e.class;
        r4[r5] = r8;	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r5 = 4;
        r8 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r4[r5] = r8;	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r2 = r2.getConstructor(r4);	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r4 = 5;
        r4 = new java.lang.Object[r4];	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r5 = 0;
        r8 = 1;
        r8 = java.lang.Boolean.valueOf(r8);	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r4[r5] = r8;	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r5 = 1;
        r6 = java.lang.Long.valueOf(r6);	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r4[r5] = r6;	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r5 = 2;
        r4[r5] = r14;	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r5 = 3;
        r4[r5] = r15;	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r5 = 4;
        r6 = 50;
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r4[r5] = r6;	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r2 = r2.newInstance(r4);	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r2 = (com.google.android.exoplayer2.r) r2;	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
        r11.add(r3, r2);	 Catch:{ ClassNotFoundException -> 0x018c, Exception -> 0x015f }
    L_0x0076:
        r5 = r13.context;
        r4 = r13.acy;
        r2 = 0;
        r8 = new com.google.android.exoplayer2.a.d[r2];
        r9 = r13.acz;
        r2 = new com.google.android.exoplayer2.a.i;
        r3 = com.google.android.exoplayer2.e.c.aqe;
        r7 = com.google.android.exoplayer2.a.c.u(r5);
        r5 = r14;
        r6 = r16;
        r2.<init>(r3, r4, r5, r6, r7, r8);
        r11.add(r2);
        if (r9 == 0) goto L_0x0136;
    L_0x0092:
        r4 = r11.size();
        r2 = 2;
        if (r9 != r2) goto L_0x009b;
    L_0x0099:
        r4 = r4 + -1;
    L_0x009b:
        r2 = "com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer";
        r2 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0166, Exception -> 0x016b }
        r3 = 3;
        r3 = new java.lang.Class[r3];	 Catch:{ ClassNotFoundException -> 0x0166, Exception -> 0x016b }
        r5 = 0;
        r6 = android.os.Handler.class;
        r3[r5] = r6;	 Catch:{ ClassNotFoundException -> 0x0166, Exception -> 0x016b }
        r5 = 1;
        r6 = com.google.android.exoplayer2.a.e.class;
        r3[r5] = r6;	 Catch:{ ClassNotFoundException -> 0x0166, Exception -> 0x016b }
        r5 = 2;
        r6 = com.google.android.exoplayer2.a.d[].class;
        r3[r5] = r6;	 Catch:{ ClassNotFoundException -> 0x0166, Exception -> 0x016b }
        r2 = r2.getConstructor(r3);	 Catch:{ ClassNotFoundException -> 0x0166, Exception -> 0x016b }
        r3 = 3;
        r3 = new java.lang.Object[r3];	 Catch:{ ClassNotFoundException -> 0x0166, Exception -> 0x016b }
        r5 = 0;
        r3[r5] = r14;	 Catch:{ ClassNotFoundException -> 0x0166, Exception -> 0x016b }
        r5 = 1;
        r3[r5] = r16;	 Catch:{ ClassNotFoundException -> 0x0166, Exception -> 0x016b }
        r5 = 2;
        r3[r5] = r8;	 Catch:{ ClassNotFoundException -> 0x0166, Exception -> 0x016b }
        r2 = r2.newInstance(r3);	 Catch:{ ClassNotFoundException -> 0x0166, Exception -> 0x016b }
        r2 = (com.google.android.exoplayer2.r) r2;	 Catch:{ ClassNotFoundException -> 0x0166, Exception -> 0x016b }
        r3 = r4 + 1;
        r11.add(r4, r2);	 Catch:{ ClassNotFoundException -> 0x0189, Exception -> 0x016b }
        r4 = r3;
    L_0x00d0:
        r2 = "com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer";
        r2 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0172, Exception -> 0x0176 }
        r3 = 3;
        r3 = new java.lang.Class[r3];	 Catch:{ ClassNotFoundException -> 0x0172, Exception -> 0x0176 }
        r5 = 0;
        r6 = android.os.Handler.class;
        r3[r5] = r6;	 Catch:{ ClassNotFoundException -> 0x0172, Exception -> 0x0176 }
        r5 = 1;
        r6 = com.google.android.exoplayer2.a.e.class;
        r3[r5] = r6;	 Catch:{ ClassNotFoundException -> 0x0172, Exception -> 0x0176 }
        r5 = 2;
        r6 = com.google.android.exoplayer2.a.d[].class;
        r3[r5] = r6;	 Catch:{ ClassNotFoundException -> 0x0172, Exception -> 0x0176 }
        r2 = r2.getConstructor(r3);	 Catch:{ ClassNotFoundException -> 0x0172, Exception -> 0x0176 }
        r3 = 3;
        r3 = new java.lang.Object[r3];	 Catch:{ ClassNotFoundException -> 0x0172, Exception -> 0x0176 }
        r5 = 0;
        r3[r5] = r14;	 Catch:{ ClassNotFoundException -> 0x0172, Exception -> 0x0176 }
        r5 = 1;
        r3[r5] = r16;	 Catch:{ ClassNotFoundException -> 0x0172, Exception -> 0x0176 }
        r5 = 2;
        r3[r5] = r8;	 Catch:{ ClassNotFoundException -> 0x0172, Exception -> 0x0176 }
        r2 = r2.newInstance(r3);	 Catch:{ ClassNotFoundException -> 0x0172, Exception -> 0x0176 }
        r2 = (com.google.android.exoplayer2.r) r2;	 Catch:{ ClassNotFoundException -> 0x0172, Exception -> 0x0176 }
        r3 = r4 + 1;
        r11.add(r4, r2);	 Catch:{ ClassNotFoundException -> 0x0186, Exception -> 0x0176 }
    L_0x0104:
        r2 = "com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer";
        r2 = java.lang.Class.forName(r2);	 Catch:{ ClassNotFoundException -> 0x0184, Exception -> 0x017d }
        r4 = 3;
        r4 = new java.lang.Class[r4];	 Catch:{ ClassNotFoundException -> 0x0184, Exception -> 0x017d }
        r5 = 0;
        r6 = android.os.Handler.class;
        r4[r5] = r6;	 Catch:{ ClassNotFoundException -> 0x0184, Exception -> 0x017d }
        r5 = 1;
        r6 = com.google.android.exoplayer2.a.e.class;
        r4[r5] = r6;	 Catch:{ ClassNotFoundException -> 0x0184, Exception -> 0x017d }
        r5 = 2;
        r6 = com.google.android.exoplayer2.a.d[].class;
        r4[r5] = r6;	 Catch:{ ClassNotFoundException -> 0x0184, Exception -> 0x017d }
        r2 = r2.getConstructor(r4);	 Catch:{ ClassNotFoundException -> 0x0184, Exception -> 0x017d }
        r4 = 3;
        r4 = new java.lang.Object[r4];	 Catch:{ ClassNotFoundException -> 0x0184, Exception -> 0x017d }
        r5 = 0;
        r4[r5] = r14;	 Catch:{ ClassNotFoundException -> 0x0184, Exception -> 0x017d }
        r5 = 1;
        r4[r5] = r16;	 Catch:{ ClassNotFoundException -> 0x0184, Exception -> 0x017d }
        r5 = 2;
        r4[r5] = r8;	 Catch:{ ClassNotFoundException -> 0x0184, Exception -> 0x017d }
        r2 = r2.newInstance(r4);	 Catch:{ ClassNotFoundException -> 0x0184, Exception -> 0x017d }
        r2 = (com.google.android.exoplayer2.r) r2;	 Catch:{ ClassNotFoundException -> 0x0184, Exception -> 0x017d }
        r11.add(r3, r2);	 Catch:{ ClassNotFoundException -> 0x0184, Exception -> 0x017d }
    L_0x0136:
        r2 = r14.getLooper();
        r3 = new com.google.android.exoplayer2.f.j;
        r0 = r17;
        r3.<init>(r0, r2);
        r11.add(r3);
        r2 = r14.getLooper();
        r3 = new com.google.android.exoplayer2.metadata.e;
        r0 = r18;
        r3.<init>(r0, r2);
        r11.add(r3);
        r2 = r11.size();
        r2 = new com.google.android.exoplayer2.r[r2];
        r2 = r11.toArray(r2);
        r2 = (com.google.android.exoplayer2.r[]) r2;
        return r2;
    L_0x015f:
        r2 = move-exception;
        r3 = new java.lang.RuntimeException;
        r3.<init>(r2);
        throw r3;
    L_0x0166:
        r2 = move-exception;
        r2 = r4;
    L_0x0168:
        r4 = r2;
        goto L_0x00d0;
    L_0x016b:
        r2 = move-exception;
        r3 = new java.lang.RuntimeException;
        r3.<init>(r2);
        throw r3;
    L_0x0172:
        r2 = move-exception;
        r2 = r4;
    L_0x0174:
        r3 = r2;
        goto L_0x0104;
    L_0x0176:
        r2 = move-exception;
        r3 = new java.lang.RuntimeException;
        r3.<init>(r2);
        throw r3;
    L_0x017d:
        r2 = move-exception;
        r3 = new java.lang.RuntimeException;
        r3.<init>(r2);
        throw r3;
    L_0x0184:
        r2 = move-exception;
        goto L_0x0136;
    L_0x0186:
        r2 = move-exception;
        r2 = r3;
        goto L_0x0174;
    L_0x0189:
        r2 = move-exception;
        r2 = r3;
        goto L_0x0168;
    L_0x018c:
        r2 = move-exception;
        goto L_0x0076;
    L_0x018f:
        r3 = r2;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.d.a(android.os.Handler, com.google.android.exoplayer2.video.e, com.google.android.exoplayer2.a.e, com.google.android.exoplayer2.f.j$a, com.google.android.exoplayer2.metadata.e$a):com.google.android.exoplayer2.r[]");
    }
}
