package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;

public final class bet extends a {
    public String wRo;
    public boolean wRp;

    public final /* synthetic */ a aH(byte[] bArr) {
        e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
        for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
            if (!a(aVar, this, a)) {
                aVar.cKx();
            }
        }
        return this;
    }

    protected final /* bridge */ /* synthetic */ a bkM() {
        return this;
    }

    public final bet Vf(String str) {
        this.wRo = str;
        this.wRp = true;
        return this;
    }

    public final String toString() {
        return this.wRo;
    }

    public final int bkL() {
        int i = 0;
        if (this.wRp) {
            i = e.a.a.b.b.a.h(1, this.wRo) + 0;
        }
        return i + 0;
    }

    public final byte[] toByteArray() {
        return super.toByteArray();
    }

    public final void a(e.a.a.c.a aVar) {
        if (this.wRp) {
            aVar.g(1, this.wRo);
        }
    }

    public final boolean a(e.a.a.a.a aVar, a aVar2, int i) {
        bet bet = (bet) aVar2;
        switch (i) {
            case 1:
                bet.Vf(aVar.AEQ.readString());
                return true;
            default:
                return false;
        }
    }
}
