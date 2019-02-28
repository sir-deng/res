package com.tencent.mm.storage.emotion;

import com.tencent.mm.bx.g;
import com.tencent.mm.bx.g.a;
import com.tencent.mm.bx.h;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;

public final class f extends i<e> implements a {
    public static final String[] gLy = new String[]{i.a(e.gKN, "EmojiSuggestDescInfo")};
    private e gLA;

    public f(e eVar) {
        this(eVar, e.gKN, "EmojiSuggestDescInfo");
    }

    private f(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gLA = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gLA = gVar;
        }
        return 0;
    }

    public final boolean ag(ArrayList<ArrayList<String>> arrayList) {
        if (arrayList.isEmpty()) {
            x.i("MicroMsg.emoji.EmojiDescMapStorage", "group list is null.");
        } else {
            long dA;
            h hVar;
            if (this.gLA instanceof h) {
                h hVar2 = (h) this.gLA;
                dA = hVar2.dA(Thread.currentThread().getId());
                hVar = hVar2;
            } else {
                dA = -1;
                hVar = null;
            }
            this.gLA.delete("EmojiSuggestDescInfo", "", null);
            Iterator it = arrayList.iterator();
            int i = 0;
            while (it.hasNext()) {
                ArrayList arrayList2 = (ArrayList) it.next();
                if (!(arrayList2 == null || arrayList2.isEmpty())) {
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        String str = (String) it2.next();
                        if (!bi.oN(str)) {
                            x.d("MicroMsg.emoji.EmojiDescMapStorage", "insert groupID%s, word:%s", String.valueOf(i), str);
                            b(new e(String.valueOf(i), str));
                        }
                    }
                    i++;
                }
                i = i;
            }
            if (hVar != null) {
                hVar.fT(dA);
            }
        }
        return false;
    }
}
