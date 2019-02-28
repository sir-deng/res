package com.tencent.mm.plugin.favorite;

import com.tencent.mm.f.a.cb;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends c<cb> {
    public b() {
        this.xmG = cb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        cb cbVar = (cb) bVar;
        x.i("MicroMsg.DelFavoriteItemListener", "do delete favitem, localId %d", Long.valueOf(cbVar.frd.frf));
        cbVar.fre.fqR = j.a(cbVar.frd.frf, null);
        return false;
    }
}
