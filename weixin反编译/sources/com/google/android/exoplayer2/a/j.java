package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.d.a;
import java.nio.ByteBuffer;

final class j implements d {
    private int aef = -1;
    private ByteBuffer agF = afA;
    private int ahd = -1;
    private boolean ahh;
    private ByteBuffer buffer = afA;
    private int encoding = 0;

    public final boolean r(int i, int i2, int i3) {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new a(i, i2, i3);
        } else if (this.ahd == i && this.aef == i2 && this.encoding == i3) {
            return false;
        } else {
            this.ahd = i;
            this.aef = i2;
            this.encoding = i3;
            if (i3 == 2) {
                this.buffer = afA;
            }
            return true;
        }
    }

    public final boolean isActive() {
        return (this.encoding == 0 || this.encoding == 2) ? false : true;
    }

    public final int iz() {
        return this.aef;
    }

    public final int iA() {
        return 2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.nio.ByteBuffer r5) {
        /*
        r4 = this;
        r1 = r5.position();
        r2 = r5.limit();
        r0 = r2 - r1;
        r3 = r4.encoding;
        switch(r3) {
            case -2147483648: goto L_0x0038;
            case 3: goto L_0x0015;
            case 1073741824: goto L_0x003d;
            default: goto L_0x000f;
        };
    L_0x000f:
        r0 = new java.lang.IllegalStateException;
        r0.<init>();
        throw r0;
    L_0x0015:
        r0 = r0 * 2;
    L_0x0017:
        r3 = r4.buffer;
        r3 = r3.capacity();
        if (r3 >= r0) goto L_0x0040;
    L_0x001f:
        r0 = java.nio.ByteBuffer.allocateDirect(r0);
        r3 = java.nio.ByteOrder.nativeOrder();
        r0 = r0.order(r3);
        r4.buffer = r0;
    L_0x002d:
        r0 = r4.encoding;
        switch(r0) {
            case -2147483648: goto L_0x005f;
            case 3: goto L_0x0046;
            case 1073741824: goto L_0x00a6;
            default: goto L_0x0032;
        };
    L_0x0032:
        r0 = new java.lang.IllegalStateException;
        r0.<init>();
        throw r0;
    L_0x0038:
        r0 = r0 / 3;
        r0 = r0 * 2;
        goto L_0x0017;
    L_0x003d:
        r0 = r0 / 2;
        goto L_0x0017;
    L_0x0040:
        r0 = r4.buffer;
        r0.clear();
        goto L_0x002d;
    L_0x0046:
        if (r1 >= r2) goto L_0x0095;
    L_0x0048:
        r0 = r4.buffer;
        r3 = 0;
        r0.put(r3);
        r0 = r4.buffer;
        r3 = r5.get(r1);
        r3 = r3 & 255;
        r3 = r3 + -128;
        r3 = (byte) r3;
        r0.put(r3);
        r1 = r1 + 1;
        goto L_0x0046;
    L_0x005f:
        if (r1 >= r2) goto L_0x0095;
    L_0x0061:
        r0 = r4.buffer;
        r3 = r1 + 1;
        r3 = r5.get(r3);
        r0.put(r3);
        r0 = r4.buffer;
        r3 = r1 + 2;
        r3 = r5.get(r3);
        r0.put(r3);
        r1 = r1 + 3;
        goto L_0x005f;
    L_0x007a:
        if (r0 >= r2) goto L_0x0095;
    L_0x007c:
        r1 = r4.buffer;
        r3 = r0 + 2;
        r3 = r5.get(r3);
        r1.put(r3);
        r1 = r4.buffer;
        r3 = r0 + 3;
        r3 = r5.get(r3);
        r1.put(r3);
        r0 = r0 + 4;
        goto L_0x007a;
    L_0x0095:
        r0 = r5.limit();
        r5.position(r0);
        r0 = r4.buffer;
        r0.flip();
        r0 = r4.buffer;
        r4.agF = r0;
        return;
    L_0x00a6:
        r0 = r1;
        goto L_0x007a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.j.b(java.nio.ByteBuffer):void");
    }

    public final void iB() {
        this.ahh = true;
    }

    public final ByteBuffer iC() {
        ByteBuffer byteBuffer = this.agF;
        this.agF = afA;
        return byteBuffer;
    }

    public final boolean iu() {
        return this.ahh && this.agF == afA;
    }

    public final void flush() {
        this.agF = afA;
        this.ahh = false;
    }

    public final void reset() {
        flush();
        this.buffer = afA;
        this.ahd = -1;
        this.aef = -1;
        this.encoding = 0;
    }
}
