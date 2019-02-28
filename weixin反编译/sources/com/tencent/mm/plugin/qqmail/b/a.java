package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import e.a.a.b;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bp.a {
    String ptG;
    private boolean ptH;
    LinkedList<i> ptI = new LinkedList();
    private boolean ptJ;

    public final /* synthetic */ com.tencent.mm.bp.a aH(byte[] bArr) {
        return aG(bArr);
    }

    protected final /* synthetic */ com.tencent.mm.bp.a bkM() {
        return bkK();
    }

    public final a Ij(String str) {
        this.ptG = str;
        this.ptH = true;
        return this;
    }

    public final a vq(int i) {
        boolean z = false;
        if (i >= 0 && i < this.ptI.size()) {
            if (i >= 10) {
                this.ptI.remove(i);
            } else {
                this.ptI.remove(i);
                Iterator it = this.ptI.iterator();
                int i2 = -1;
                int i3 = Integer.MIN_VALUE;
                int i4 = 0;
                while (it.hasNext()) {
                    i iVar = (i) it.next();
                    int i5 = i4 + 1;
                    if (i4 >= 10) {
                        int i6;
                        if (i3 < iVar.puk) {
                            i2 = iVar.puk;
                            i6 = i5;
                        } else {
                            i6 = i2;
                            i2 = i3;
                        }
                        i3 = i2;
                        i4 = i5;
                        i2 = i6;
                    } else {
                        i4 = i5;
                    }
                }
                if (i2 != -1 && i2 < this.ptI.size()) {
                    try {
                        a((i) this.ptI.remove(i2));
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.AddrBook", e, "size:%d, idx:%d", Integer.valueOf(this.ptI.size()), Integer.valueOf(i2));
                    }
                }
            }
            if (this.ptI.size() > 0) {
                z = true;
            }
            this.ptJ = z;
        }
        return this;
    }

    public final a a(i iVar) {
        i iVar2;
        int i = 0;
        if (!this.ptJ) {
            this.ptJ = true;
        }
        Iterator it = this.ptI.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iVar2 = (i) it.next();
            if (i2 >= 10) {
                if (a(iVar, iVar2)) {
                    break;
                }
            } else if (iVar.puk > iVar2.puk) {
                break;
            }
            i2++;
        }
        if (i2 >= this.ptI.size()) {
            this.ptI.add(iVar);
        } else {
            this.ptI.add(i2, iVar);
            if (i2 < 10 && this.ptI.size() > 10) {
                iVar2 = (i) this.ptI.remove(10);
                it = this.ptI.iterator();
                while (it.hasNext()) {
                    i iVar3 = (i) it.next();
                    if (i >= 10 && a(iVar2, iVar3)) {
                        break;
                    }
                    i++;
                }
                if (i >= this.ptI.size()) {
                    this.ptI.add(iVar2);
                } else {
                    this.ptI.add(i, iVar2);
                }
            }
        }
        return this;
    }

    private static boolean a(i iVar, i iVar2) {
        if (iVar == null || iVar2 == null) {
            return false;
        }
        int compareTo = b(iVar).compareTo(b(iVar2));
        if (compareTo == 0) {
            if (iVar.nWa.compareTo(iVar2.nWa) > 0) {
                return false;
            }
            return true;
        } else if (compareTo >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static String b(i iVar) {
        String str = iVar.pul;
        if (str == null || "".equals(str)) {
            str = Ik(c.oD(iVar.name.trim()).toLowerCase());
        } else {
            str = Ik(str);
        }
        iVar.pul = str;
        return str;
    }

    public static String Ik(String str) {
        if (str == null || str.length() <= 0) {
            x.d("MicroMsg.getAdjustFullSpell", "%s", "srcName is null or empty, adjust full spell = ~");
            return "~";
        }
        char[] toCharArray = str.toCharArray();
        int i = 0;
        while (i < toCharArray.length) {
            char c = toCharArray[i];
            if (c >= '0' && c <= '9') {
                return String.format("{%c%s", new Object[]{Character.valueOf(c), str});
            } else if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                if (c == '{' && i == 0 && toCharArray.length > 1 && toCharArray[i + 1] >= '0' && toCharArray[i + 1] <= '9') {
                    return str;
                }
                i++;
            } else if (i == 0) {
                return str;
            } else {
                return String.format("%c%s", new Object[]{Character.valueOf(c), str});
            }
        }
        x.d("MicroMsg.getAdjustFullSpell", "%s is not ok, return '~'", str);
        return "~";
    }

    public final String toString() {
        return ((("" + getClass().getName() + "(") + "syncInfo = " + this.ptG + "   ") + "addrs = " + this.ptI + "   ") + ")";
    }

    private a bkK() {
        if (this.ptH) {
            return this;
        }
        throw new b("Not all required fields were included (false = not included in message),  syncInfo:" + this.ptH);
    }

    public final int bkL() {
        return (e.a.a.b.b.a.h(1, this.ptG) + 0) + (e.a.a.a.c(2, 8, this.ptI) + 0);
    }

    public final byte[] toByteArray() {
        bkK();
        return super.toByteArray();
    }

    public final void a(e.a.a.c.a aVar) {
        aVar.g(1, this.ptG);
        aVar.d(2, 8, this.ptI);
    }

    public final a aG(byte[] bArr) {
        e.a.a.a.a aVar = new e.a.a.a.a(bArr, unknownTagHandler);
        for (int a = com.tencent.mm.bp.a.a(aVar); a > 0; a = com.tencent.mm.bp.a.a(aVar)) {
            boolean z;
            switch (a) {
                case 1:
                    Ij(aVar.AEQ.readString());
                    z = true;
                    break;
                case 2:
                    int i;
                    LinkedList JD = aVar.JD(2);
                    for (i = 0; i < JD.size(); i++) {
                        byte[] bArr2 = (byte[]) JD.get(i);
                        com.tencent.mm.bp.a iVar = new i();
                        e.a.a.a.a aVar2 = new e.a.a.a.a(bArr2, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar2, iVar, com.tencent.mm.bp.a.a(aVar2))) {
                        }
                        if (!this.ptJ) {
                            this.ptJ = true;
                        }
                        this.ptI.add(iVar);
                    }
                    i[] iVarArr = (i[]) this.ptI.toArray(new i[1]);
                    Arrays.sort(iVarArr, new Comparator<i>() {
                        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                            return ((i) obj2).puk - ((i) obj).puk;
                        }
                    });
                    if (10 <= iVarArr.length) {
                        Arrays.sort(iVarArr, 10, iVarArr.length, new Comparator<i>() {
                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                i iVar = (i) obj;
                                i iVar2 = (i) obj2;
                                int compareTo = a.b(iVar).compareTo(a.b(iVar2));
                                return compareTo == 0 ? iVar.nWa.compareTo(iVar2.nWa) : compareTo;
                            }
                        });
                    }
                    this.ptI.clear();
                    for (Object add : iVarArr) {
                        this.ptI.add(add);
                    }
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (!z) {
                aVar.cKx();
            }
        }
        return bkK();
    }
}
