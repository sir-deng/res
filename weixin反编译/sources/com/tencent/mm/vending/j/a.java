package com.tencent.mm.vending.j;

public class a {
    public Object[] zMj;

    public final <T> T get(int i) {
        if (this.zMj.length <= i) {
            return null;
        }
        return this.zMj[i];
    }

    public final int size() {
        if (this.zMj == null) {
            return 0;
        }
        return this.zMj.length;
    }

    public static <$1> b<$1> cs($1 $1) {
        a bVar = new b();
        bVar.zMj = new Object[]{$1};
        return (b) bVar;
    }

    public static <$1, $2> c<$1, $2> v($1 $1, $2 $2) {
        a cVar = new c();
        cVar.zMj = new Object[]{$1, $2};
        return (c) cVar;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (Object obj2 : this.zMj) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(",");
            }
            stringBuilder.append(obj2);
        }
        return stringBuilder.toString();
    }
}
