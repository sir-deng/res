package com.tencent.mm.protocal;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n {
    public String host = "";
    public String nWa = "";
    private int port = 80;
    private int type = 0;

    public static class a {
        public final int[] vIi = null;
        public final int[] vIj;
        public final int vIk;
        public final int vIl;

        public a(int[] iArr, int i, int i2) {
            this.vIj = iArr;
            this.vIk = i;
            this.vIl = i2;
        }
    }

    public n(int i, String str, int i2, String str2) {
        this.type = i;
        this.nWa = str;
        this.port = i2;
        this.host = str2;
    }

    public final String toString() {
        return this.type + "," + this.nWa + "," + this.port + "," + this.host;
    }

    private static n TS(String str) {
        String[] split = str.split(",");
        if (split.length < 4) {
            return null;
        }
        n nVar = new n();
        try {
            nVar.type = bi.getInt(split[0], 0);
            nVar.nWa = bi.oM(split[1]);
            nVar.port = bi.getInt(split[2], 0);
            nVar.host = bi.oM(split[3]);
            return nVar;
        } catch (Throwable e) {
            x.e("MicroMsg.MMBuiltInIP", "exception:%s", bi.i(e));
            return null;
        }
    }

    public static String cA(List<n> list) {
        String str = "";
        Iterator it = list.iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            str = str2 + ((n) it.next()).toString() + "|";
        }
    }

    public static List<n> TT(String str) {
        List linkedList = new LinkedList();
        if (!bi.oN(str)) {
            try {
                for (String TS : str.split("\\|")) {
                    n TS2 = TS(TS);
                    if (TS2 != null) {
                        linkedList.add(TS2);
                    }
                }
            } catch (Throwable e) {
                x.d("MicroMsg.MMBuiltInIP", "unserialize split failed str[%s]", str);
                x.e("MicroMsg.MMBuiltInIP", "exception:%s", bi.i(e));
            }
        }
        return linkedList;
    }

    public static a fr(String str, String str2) {
        x.d("MicroMsg.MMBuiltInIP", "parsing network control params:");
        x.d("MicroMsg.MMBuiltInIP", "ports = " + str);
        x.d("MicroMsg.MMBuiltInIP", "timeouts = " + str2);
        int[] Wk = bi.Wk(str);
        int[] Wk2 = bi.Wk(str2);
        if (Wk2 == null || Wk2.length < 2) {
            Wk2 = new int[]{0, 0};
            x.e("MicroMsg.MMBuiltInIP", "invalid timeouts");
        }
        return new a(Wk, (int) (((long) Wk2[0]) * 1000), (int) (((long) Wk2[1]) * 1000));
    }
}
