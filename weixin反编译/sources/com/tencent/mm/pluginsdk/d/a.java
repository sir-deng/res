package com.tencent.mm.pluginsdk.d;

import com.tencent.mm.f.a.je;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import java.util.ArrayList;

public abstract class a extends c<je> {
    protected ArrayList<String> vjw;

    public abstract void j(b bVar);

    public a() {
        this.vjw = new ArrayList(3);
        this.xmG = je.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        je jeVar = (je) bVar;
        if ((jeVar instanceof je) && jeVar.fAC.fAD != null && this.vjw.contains(jeVar.fAC.fAD.getClass().getName())) {
            j(jeVar.fAC.fAD);
        }
        return false;
    }

    public static void a(String str, a aVar) {
        if (!aVar.vjw.contains(str)) {
            aVar.vjw.add(str);
        }
        com.tencent.mm.sdk.b.a.xmy.b(aVar);
        e.RR(str);
    }

    public static void b(String str, a aVar) {
        e.RS(str);
        com.tencent.mm.sdk.b.a.xmy.c(aVar);
        if (aVar.vjw.contains(str)) {
            aVar.vjw.remove(str);
        }
    }
}
