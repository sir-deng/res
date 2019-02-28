package d.a.a;

import com.tencent.mm.bp.a;
import java.util.LinkedList;

public final class b extends a {
    public f AEr;
    public String AEs;
    public String AEt;
    public String AEu;
    public String AEv;
    public String url;
    public int wZw;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.AEr != null) {
                aVar.fZ(1, this.AEr.bkL());
                this.AEr.a(aVar);
            }
            if (this.url != null) {
                aVar.g(2, this.url);
            }
            if (this.AEs != null) {
                aVar.g(3, this.AEs);
            }
            if (this.AEt != null) {
                aVar.g(4, this.AEt);
            }
            aVar.fX(5, this.wZw);
            if (this.AEu != null) {
                aVar.g(6, this.AEu);
            }
            if (this.AEv == null) {
                return 0;
            }
            aVar.g(7, this.AEv);
            return 0;
        } else if (i == 1) {
            if (this.AEr != null) {
                fW = e.a.a.a.fW(1, this.AEr.bkL()) + 0;
            } else {
                fW = 0;
            }
            if (this.url != null) {
                fW += e.a.a.b.b.a.h(2, this.url);
            }
            if (this.AEs != null) {
                fW += e.a.a.b.b.a.h(3, this.AEs);
            }
            if (this.AEt != null) {
                fW += e.a.a.b.b.a.h(4, this.AEt);
            }
            fW += e.a.a.a.fU(5, this.wZw);
            if (this.AEu != null) {
                fW += e.a.a.b.b.a.h(6, this.AEu);
            }
            if (this.AEv != null) {
                fW += e.a.a.b.b.a.h(7, this.AEv);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a fVar = new f();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = fVar.a(aVar4, fVar, a.a(aVar4))) {
                        }
                        bVar.AEr = fVar;
                    }
                    return 0;
                case 2:
                    bVar.url = aVar3.AEQ.readString();
                    return 0;
                case 3:
                    bVar.AEs = aVar3.AEQ.readString();
                    return 0;
                case 4:
                    bVar.AEt = aVar3.AEQ.readString();
                    return 0;
                case 5:
                    bVar.wZw = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    bVar.AEu = aVar3.AEQ.readString();
                    return 0;
                case 7:
                    bVar.AEv = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
