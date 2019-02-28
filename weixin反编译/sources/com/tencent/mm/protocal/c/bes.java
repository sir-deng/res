package com.tencent.mm.protocal.c;

import com.tencent.mm.bp.a;
import com.tencent.mm.bp.b;

public final class bes extends a {
    public int wRk;
    private boolean wRl;
    public b wRm;
    public boolean wRn;

    public final /* synthetic */ a aH(byte[] bArr) {
        return bm(bArr);
    }

    protected final /* synthetic */ a bkM() {
        return ceD();
    }

    private bes Do(int i) {
        this.wRk = i;
        this.wRl = true;
        return this;
    }

    public final bes bl(byte[] bArr) {
        b be = b.be(bArr);
        b(be);
        Do(be.oz.length);
        return this;
    }

    public final bes O(byte[] bArr, int i) {
        b s = b.s(bArr, 0, i);
        b(s);
        Do(s.oz.length);
        return this;
    }

    public final bes b(b bVar) {
        if (bVar == null) {
            bl(null);
        }
        this.wRm = bVar;
        this.wRn = true;
        Do(this.wRm.oz.length);
        return this;
    }

    public final String toString() {
        Object stringBuilder = new StringBuilder(String.valueOf("" + getClass().getName() + "(")).append("iLen = ").append(this.wRk).append("   ").toString();
        if (this.wRn) {
            stringBuilder = new StringBuilder(String.valueOf(stringBuilder)).append("Buffer = ").append(this.wRm).append("   ").toString();
        }
        return new StringBuilder(String.valueOf(stringBuilder)).append(")").toString();
    }

    private bes ceD() {
        if (this.wRl) {
            return this;
        }
        throw new e.a.a.b("Not all required fields were included (false = not included in message),  iLen:" + this.wRl);
    }

    public final int bkL() {
        int fU = e.a.a.a.fU(1, this.wRk) + 0;
        if (this.wRn) {
            fU += e.a.a.a.a(2, this.wRm);
        }
        return fU + 0;
    }

    public final byte[] toByteArray() {
        ceD();
        return super.toByteArray();
    }

    public final void a(e.a.a.c.a aVar) {
        aVar.fX(1, this.wRk);
        if (this.wRn) {
            aVar.b(2, this.wRm);
        }
    }

    public final boolean a(e.a.a.a.a aVar, a aVar2, int i) {
        bes bes = (bes) aVar2;
        switch (i) {
            case 1:
                bes.Do(aVar.AEQ.rz());
                return true;
            case 2:
                bes.b(aVar.cKw());
                return true;
            default:
                return false;
        }
    }

    public final bes bm(byte[] bArr) {
        e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
        for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
            if (!a(aVar, this, a)) {
                aVar.cKx();
            }
        }
        return ceD();
    }
}
