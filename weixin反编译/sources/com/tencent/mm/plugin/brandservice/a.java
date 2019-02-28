package com.tencent.mm.plugin.brandservice;

import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;

public final class a implements p {
    public static n ihN;
    public static m ihO;

    public final void a(n nVar) {
        ihN = nVar;
    }

    public final void a(m mVar) {
        ihO = mVar;
    }

    public static void f(int i, Object obj) {
        String str = "MicroMsg.BrandService.BrandServiceApplication";
        String str2 = "set config, key[%d], value[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = obj == null ? "null" : obj.toString();
        x.i(str, str2, objArr);
        as.Hm();
        c.Db().set(i, obj);
    }
}
