package com.tencent.mm.plugin.webview.fts.a;

import com.tencent.mm.f.b.ag;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e extends a<a> {
    public List<a> mUI = Collections.emptyList();

    public static class a {
        public String bgo;
        public String desc;
        public String ggL;
        public String iLo;
        public String ttN;
        public String userName;
    }

    public e(String str, int i) {
        super(str, Integer.MAX_VALUE);
    }

    public final void cm(List<j> list) {
        this.mUI = new ArrayList(list.size());
        for (j jVar : list) {
            as.Hm();
            ag Xv = c.Ff().Xv(jVar.mRd);
            a aVar = new a();
            aVar.userName = Xv.field_username;
            aVar.ttN = jVar.content;
            aVar.bgo = Xv.field_nickname;
            aVar.iLo = Xv.field_conRemark;
            aVar.ggL = Xv.vU();
            aVar.desc = Xv.fXt;
            this.mUI.add(aVar);
        }
    }
}
