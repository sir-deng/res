package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import com.tencent.mm.f.a.ag;
import com.tencent.mm.plugin.brandservice.a.h;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;

public class Plugin implements c {
    public p createApplication() {
        a.xmy.b(new com.tencent.mm.sdk.b.c<ag>() {
            {
                this.xmG = ag.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                ag agVar = (ag) bVar;
                if (agVar == null || !(agVar instanceof ag)) {
                    return false;
                }
                ag agVar2 = agVar;
                switch (agVar2.foU.action) {
                    case 1:
                        Context context = agVar2.foU.context;
                        String str = agVar2.foU.foW;
                        String str2 = agVar2.foU.title;
                        int i = agVar2.foU.fromScene;
                        long j = agVar2.foU.foX;
                        int i2 = agVar2.foU.offset;
                        boolean z = agVar2.foU.foY;
                        if (context == null || bi.oN(str)) {
                            x.e("MicroMsg.BrandService.BrandServiceLogic", "context(%s) or keyword(%s) is null or nil.", context, str);
                            return false;
                        }
                        as.CN().a(1071, new a(context, str, j, i2, i, str2, z, agVar2));
                        as.CN().a(new h(str, j, i2, i, ""), 0);
                        return true;
                    default:
                        x.d("MicroMsg.BrandService.BrandServiceLogic", "Do not support the action(%d).", Integer.valueOf(agVar2.foU.action));
                        return false;
                }
            }
        });
        return new a();
    }

    public com.tencent.mm.pluginsdk.c.b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return new b();
    }
}
