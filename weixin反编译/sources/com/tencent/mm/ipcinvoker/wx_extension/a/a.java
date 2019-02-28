package com.tencent.mm.ipcinvoker.wx_extension.a;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

public final class a {

    private static final class b {
        public static a gOV = new a();
    }

    private static class a implements j<IPCString, Bundle> {
        private a() {
        }

        public final /* synthetic */ Object at(Object obj) {
            IPCString iPCString = (IPCString) obj;
            if (g.Dr().gSp.gSI && g.Do().gRj) {
                c fp = com.tencent.mm.y.c.c.IL().fp(iPCString.value);
                Object bundle = new Bundle();
                bundle.putString("layerId", fp.field_layerId);
                bundle.putString("business", fp.field_business);
                bundle.putString("expId", fp.field_expId);
                bundle.putString("rawXML", fp.field_rawXML);
                bundle.putLong("startTime", fp.field_startTime);
                bundle.putLong("endTime", fp.field_endTime);
                bundle.putLong("sequence", fp.field_sequence);
                bundle.putInt("prioritylevel", fp.field_prioritylevel);
                bundle.putBoolean("needReport", fp.field_needReport);
                return bundle;
            }
            x.i("MicroMsg.IPCInvokeTask_GetABTestItem", "kernel or account not ready.");
            return null;
        }
    }

    public static c fp(String str) {
        if (str.length() == 0) {
            x.i("MicroMsg.IPCNewABTest", "get ABTestItem by layerId failed, id is null.", str);
            return null;
        } else if (ad.cgj()) {
            return com.tencent.mm.y.c.c.IL().fp(str);
        } else {
            Bundle bundle = (Bundle) f.a("com.tencent.mm", new IPCString(str), a.class);
            if (bundle == null) {
                return null;
            }
            c cVar = new c();
            cVar.field_layerId = bundle.getString("layerId");
            cVar.field_business = bundle.getString("business");
            cVar.field_expId = bundle.getString("expId");
            cVar.field_rawXML = bundle.getString("rawXML");
            cVar.field_startTime = bundle.getLong("startTime");
            cVar.field_endTime = bundle.getLong("endTime");
            cVar.field_sequence = bundle.getLong("sequence");
            cVar.field_prioritylevel = bundle.getInt("prioritylevel");
            cVar.field_needReport = bundle.getBoolean("needReport");
            return cVar;
        }
    }
}
