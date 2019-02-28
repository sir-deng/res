package com.tencent.mm.plugin.appbrand.s.d;

import com.tencent.mm.plugin.appbrand.s.d.d.a;
import com.tencent.mm.plugin.appbrand.s.f.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e implements c {
    protected static byte[] jZO = new byte[0];
    protected boolean jZP;
    protected a jZQ;
    private ByteBuffer jZR;
    protected boolean jZS;

    public e(a aVar) {
        this.jZQ = aVar;
        this.jZR = ByteBuffer.wrap(jZO);
    }

    public e(d dVar) {
        this.jZP = dVar.amD();
        this.jZQ = dVar.amF();
        this.jZR = dVar.amC();
        this.jZS = dVar.amE();
    }

    public final boolean amD() {
        return this.jZP;
    }

    public final a amF() {
        return this.jZQ;
    }

    public final boolean amE() {
        return this.jZS;
    }

    public ByteBuffer amC() {
        return this.jZR;
    }

    public final void do(boolean z) {
        this.jZP = z;
    }

    public final void a(a aVar) {
        this.jZQ = aVar;
    }

    public void u(ByteBuffer byteBuffer) {
        this.jZR = byteBuffer;
    }

    public final void dp(boolean z) {
        this.jZS = z;
    }

    public final void e(d dVar) {
        ByteBuffer amC = dVar.amC();
        if (this.jZR == null) {
            this.jZR = ByteBuffer.allocate(amC.remaining());
            amC.mark();
            this.jZR.put(amC);
            amC.reset();
        } else {
            amC.mark();
            this.jZR.position(this.jZR.limit());
            this.jZR.limit(this.jZR.capacity());
            if (amC.remaining() > this.jZR.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(amC.remaining() + this.jZR.capacity());
                this.jZR.flip();
                allocate.put(this.jZR);
                allocate.put(amC);
                this.jZR = allocate;
            } else {
                this.jZR.put(amC);
            }
            this.jZR.rewind();
            amC.reset();
        }
        this.jZP = dVar.amD();
    }

    public String toString() {
        return "Framedata{ optcode:" + this.jZQ + ", fin:" + this.jZP + ", payloadlength:[pos:" + this.jZR.position() + ", len:" + this.jZR.remaining() + "], payload:" + Arrays.toString(b.vu(new String(this.jZR.array()))) + "}";
    }
}
