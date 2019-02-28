package com.tencent.mm.bb;

import com.tencent.mm.f.a.by;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.y.q;

public final class j {
    private static final j hMP = new j();
    public long hMO;

    public j() {
        if (g.Do().CF()) {
            this.hMO = q.Gd();
        } else {
            a.xmy.a(new c<by>() {
                {
                    this.xmG = by.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(b bVar) {
                    if (g.Do().CF()) {
                        j.this.hMO = q.Gd();
                    }
                    return true;
                }
            });
        }
    }

    public static j Rj() {
        return hMP;
    }

    public final boolean Rk() {
        return (this.hMO & HardCoderJNI.ACTION_NET_RX) == HardCoderJNI.ACTION_NET_RX;
    }
}
