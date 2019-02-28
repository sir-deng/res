package com.tencent.mm.bp;

import e.a.a.a.a.b;

public class a {
    protected static final int OPCODE_COMPUTESIZE = 1;
    protected static final int OPCODE_PARSEFROM = 2;
    protected static final int OPCODE_POPULATEBUILDERWITHFIELD = 3;
    protected static final int OPCODE_WRITEFIELDS = 0;
    public static b unknownTagHandler = new e.a.a.a.a.a();

    public byte[] toByteArray() {
        bkM();
        byte[] bArr = new byte[bkL()];
        e.a.a.c.a aVar = new e.a.a.c.a(bArr);
        a(aVar);
        if (aVar.hnp != null) {
            aVar.hnp.write(aVar.AEW);
            aVar.hnp.flush();
        }
        return bArr;
    }

    public static int a(e.a.a.a.a aVar) {
        int i = 0;
        e.a.a.b.a.a aVar2 = aVar.AEQ;
        if (aVar2.bfJ != aVar2.bufferSize || aVar2.on(false)) {
            aVar2.bfK = aVar2.rz();
            if (aVar2.bfK == 0) {
                throw e.a.a.b.a.b.cKB();
            }
            i = aVar2.bfK;
        } else {
            aVar2.bfK = 0;
        }
        aVar.AER = i;
        return e.a.a.b.a.eb(aVar.AER);
    }

    public a bkM() {
        return this;
    }

    public int a(int i, Object... objArr) {
        throw new Error("Cannot use this method");
    }

    public void a(e.a.a.c.a aVar) {
        a(0, aVar);
    }

    public int bkL() {
        int i = 0;
        try {
            return a(1, new Object[0]);
        } catch (Exception e) {
            return i;
        }
    }

    public a aH(byte[] bArr) {
        a(2, bArr);
        return this;
    }

    public boolean a(e.a.a.a.a aVar, a aVar2, int i) {
        return a(3, aVar, aVar2, Integer.valueOf(i)) == 0;
    }
}
