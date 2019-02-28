package e.a.a;

import com.tencent.mm.bp.b;
import java.util.LinkedList;

public final class a {
    public static int fU(int i, int i2) {
        return i2 >= 0 ? e.a.a.b.b.a.dX(i) + e.a.a.b.b.a.dZ(i2) : e.a.a.b.b.a.dX(i) + 10;
    }

    public static int fV(int i, int i2) {
        return fU(i, i2);
    }

    public static int h(int i, String str) {
        return e.a.a.b.b.a.h(i, str);
    }

    public static int JC(int i) {
        return e.a.a.b.b.a.dX(i) + 1;
    }

    public static int R(int i, long j) {
        int dX = e.a.a.b.b.a.dX(i);
        int i2 = (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
        return i2 + dX;
    }

    public static int a(int i, b bVar) {
        return bVar == null ? 0 : (e.a.a.b.b.a.dX(i) + e.a.a.b.b.a.dZ(bVar.oz.length)) + bVar.oz.length;
    }

    public static int fW(int i, int i2) {
        return (e.a.a.b.b.a.dX(i) + e.a.a.b.b.a.dZ(i2)) + i2;
    }

    public static int c(int i, int i2, LinkedList<?> linkedList) {
        int i3 = 0;
        if (linkedList == null) {
            return 0;
        }
        int i4;
        int i5;
        switch (i2) {
            case 1:
                i4 = 0;
                while (true) {
                    i5 = i3;
                    if (i5 >= linkedList.size()) {
                        return i4;
                    }
                    i3 = e.a.a.b.b.a.h(i, (String) linkedList.get(i5)) + i4;
                    i4 = i5 + 1;
                    i5 = i4;
                }
            case 2:
                i4 = 0;
                while (true) {
                    i5 = i3;
                    if (i5 >= linkedList.size()) {
                        return i4;
                    }
                    i3 = fU(i, ((Integer) linkedList.get(i5)).intValue()) + i4;
                    i4 = i5 + 1;
                    i5 = i4;
                }
            case 3:
                i4 = 0;
                while (true) {
                    i5 = i3;
                    if (i5 >= linkedList.size()) {
                        return i4;
                    }
                    i3 = R(i, ((Long) linkedList.get(i5)).longValue()) + i4;
                    i4 = i5 + 1;
                    i5 = i4;
                }
            case 4:
                i4 = 0;
                while (true) {
                    i5 = i3;
                    if (i5 >= linkedList.size()) {
                        return i4;
                    }
                    ((Double) linkedList.get(i5)).doubleValue();
                    i3 = (e.a.a.b.b.a.dX(i) + 8) + i4;
                    i4 = i5 + 1;
                    i5 = i4;
                }
            case 5:
                i4 = 0;
                while (true) {
                    i5 = i3;
                    if (i5 >= linkedList.size()) {
                        return i4;
                    }
                    ((Float) linkedList.get(i5)).floatValue();
                    i3 = (e.a.a.b.b.a.dX(i) + 4) + i4;
                    i4 = i5 + 1;
                    i5 = i4;
                }
            case 6:
                i4 = 0;
                while (true) {
                    i5 = i3;
                    if (i5 >= linkedList.size()) {
                        return i4;
                    }
                    i3 = a(i, (b) linkedList.get(i5)) + i4;
                    i4 = i5 + 1;
                    i5 = i4;
                }
            case 7:
                i4 = 0;
                while (true) {
                    i5 = i3;
                    if (i5 >= linkedList.size()) {
                        return i4;
                    }
                    ((Boolean) linkedList.get(i5)).booleanValue();
                    i3 = (e.a.a.b.b.a.dX(i) + 1) + i4;
                    i4 = i5 + 1;
                    i5 = i4;
                }
            case 8:
                i4 = 0;
                while (true) {
                    i5 = i3;
                    if (i5 >= linkedList.size()) {
                        return i4;
                    }
                    i3 = fW(i, ((com.tencent.mm.bp.a) linkedList.get(i5)).bkL()) + i4;
                    i4 = i5 + 1;
                    i5 = i4;
                }
            default:
                throw new IllegalArgumentException("The data type was not found, the id used was " + i2);
        }
    }

    public static int b(int i, LinkedList<?> linkedList) {
        int i2 = 0;
        if (linkedList == null || linkedList.size() <= 0) {
            return 0;
        }
        int i3 = 0;
        while (true) {
            int i4 = i2;
            if (i3 >= linkedList.size()) {
                return (e.a.a.b.b.a.dZ(i4) + i4) + e.a.a.b.b.a.dX(i);
            }
            i4 += e.a.a.b.b.a.dZ(((Integer) linkedList.get(i3)).intValue());
            i2 = i3 + 1;
        }
    }
}
