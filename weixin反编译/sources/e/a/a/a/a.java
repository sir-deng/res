package e.a.a.a;

import e.a.a.a.a.b;
import java.util.LinkedList;

public final class a {
    public final e.a.a.b.a.a AEQ;
    public int AER = 0;
    private final b unknownTagHandler;

    public a(byte[] bArr, b bVar) {
        this.AEQ = new e.a.a.b.a.a(bArr, bArr.length);
        this.unknownTagHandler = bVar;
    }

    public final int cKs() {
        return this.AEQ.rz();
    }

    public final LinkedList<Integer> cKt() {
        e.a.a.b.a.a aVar = this.AEQ;
        LinkedList<Integer> linkedList = new LinkedList();
        while (aVar.bfJ < aVar.bufferSize) {
            linkedList.add(Integer.valueOf(aVar.rz()));
        }
        return linkedList;
    }

    public final String cKu() {
        return this.AEQ.readString();
    }

    public final boolean cKv() {
        return this.AEQ.rz() != 0;
    }

    public final com.tencent.mm.bp.b cKw() {
        e.a.a.b.a.a aVar = this.AEQ;
        int rz = aVar.rz();
        if (rz >= aVar.bufferSize - aVar.bfJ || rz <= 0) {
            return com.tencent.mm.bp.b.be(aVar.dT(rz));
        }
        com.tencent.mm.bp.b s = com.tencent.mm.bp.b.s(aVar.buffer, aVar.bfJ, rz);
        aVar.bfJ = rz + aVar.bfJ;
        return s;
    }

    public final void cKx() {
        int ea = e.a.a.b.a.ea(this.AER);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FieldNumber: ").append(e.a.a.b.a.eb(this.AER)).append(" - ");
        switch (ea) {
            case 0:
                stringBuffer.append("varint (long, int or boolean) value: ").append(this.AEQ.rA());
                return;
            case 1:
                stringBuffer.append("double value: ").append(Double.toString(this.AEQ.readDouble()));
                return;
            case 2:
                stringBuffer.append("Length delimited (String or ByteString) value: ").append(this.AEQ.readString());
                return;
            case 5:
                stringBuffer.append("float value: ").append(Float.toString(this.AEQ.readFloat()));
                return;
            default:
                return;
        }
    }

    public final LinkedList<byte[]> JD(int i) {
        return this.AEQ.JD(i);
    }
}
