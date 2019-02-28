package d.a.a;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class d extends a {
    public String AEo;
    public String AEp;
    public int AEq;
    public f AEr;
    public String url;
    public String wtj;

    protected final int a(int i, Object... objArr) {
        int h;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.AEo != null) {
                aVar.g(1, this.AEo);
            }
            if (this.AEp != null) {
                aVar.g(2, this.AEp);
            }
            aVar.fX(3, this.AEq);
            if (this.wtj != null) {
                aVar.g(4, this.wtj);
            }
            if (this.url != null) {
                aVar.g(5, this.url);
            }
            if (this.AEr == null) {
                return 0;
            }
            aVar.fZ(6, this.AEr.bkL());
            this.AEr.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.AEo != null) {
                h = e.a.a.b.b.a.h(1, this.AEo) + 0;
            } else {
                h = 0;
            }
            if (this.AEp != null) {
                h += e.a.a.b.b.a.h(2, this.AEp);
            }
            h += e.a.a.a.fU(3, this.AEq);
            if (this.wtj != null) {
                h += e.a.a.b.b.a.h(4, this.wtj);
            }
            if (this.url != null) {
                h += e.a.a.b.b.a.h(5, this.url);
            }
            if (this.AEr != null) {
                h += e.a.a.a.fW(6, this.AEr.bkL());
            }
            return h;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (h = a.a(aVar2); h > 0; h = a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dVar.AEo = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    dVar.AEp = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    dVar.AEq = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    dVar.wtj = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    dVar.url = aVar3.AEQ.readString();
                    return 0;
                case 6:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a fVar = new f();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fVar.a(aVar4, fVar, a.a(aVar4))) {
                        }
                        dVar.AEr = fVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
