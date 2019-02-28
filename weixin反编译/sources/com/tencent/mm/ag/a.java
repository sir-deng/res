package com.tencent.mm.ag;

import com.tencent.mm.a.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.q;
import java.util.Map;

public final class a {
    private static int hth = 0;
    private static int hti = 0;

    public static class a {
        private static final f<Integer, a> hfz = new f(100);
        public String fAJ;
        public String htj;
        public String htk;
        public String htl;
        public String htm;
        public String htn;
        public String hto;
        public String htp;
        public String htq;
        public String htr;
        public String toUser;

        public static final a kB(String str) {
            if (bi.oN(str)) {
                x.e("MicroMsg.BrandQALogic", "empty xml to parse");
                return null;
            }
            int indexOf = str.indexOf("<qamsg");
            if (indexOf > 0) {
                str = str.substring(indexOf);
            }
            int hashCode = str.hashCode();
            a aVar = (a) hfz.get(Integer.valueOf(hashCode));
            if (aVar != null) {
                return aVar;
            }
            Map y = bj.y(str, "qamsg");
            if (y == null) {
                x.e("MicroMsg.BrandQALogic", "parse msg failed");
                return null;
            }
            try {
                a aVar2 = new a();
                aVar2.fAJ = (String) y.get(".qamsg.$fromUser");
                aVar2.htj = (String) y.get(".qamsg.$fromNickname");
                aVar2.toUser = (String) y.get(".qamsg.$title");
                aVar2.htk = (String) y.get(".qamsg.question.$id");
                aVar2.htl = (String) y.get(".qamsg.question.$fromUser");
                aVar2.htm = (String) y.get(".qamsg.question.content");
                aVar2.htn = (String) y.get(".qamsg.answer.$id");
                aVar2.hto = (String) y.get(".qamsg.answer.$fromUser");
                aVar2.htp = (String) y.get(".qamsg.answer.content");
                aVar2.htn = (String) y.get(".qamsg.answer1.$id");
                aVar2.htq = (String) y.get(".qamsg.answer1.$fromUser");
                aVar2.htr = (String) y.get(".qamsg.answer1.content");
                hfz.l(Integer.valueOf(hashCode), aVar2);
                return aVar2;
            } catch (Throwable e) {
                x.e("MicroMsg.BrandQALogic", "parse qamessage xml failed");
                x.printErrStackTrace("MicroMsg.BrandQALogic", e, "", new Object[0]);
                return null;
            }
        }
    }

    public static String a(a aVar) {
        if (aVar == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(bi.oM(aVar.htr));
        stringBuilder.append("\n-------------------\n");
        stringBuilder.append(bi.oM(aVar.htp));
        stringBuilder.append("\n-------------------\n");
        stringBuilder.append(bi.oM(aVar.htm));
        return stringBuilder.toString();
    }

    public static String b(a aVar) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (!q.gt(aVar.fAJ)) {
            stringBuilder.append(aVar.htj);
            stringBuilder.append(": ");
        }
        String str = bi.oN(aVar.htr) ? bi.oN(aVar.htp) ? aVar.htm : aVar.htp : aVar.htr;
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
