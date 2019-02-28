package com.tencent.c.d.a;

import android.text.TextUtils;
import com.tencent.c.d.b.d.a;
import com.tencent.c.f.h;
import java.util.ArrayList;
import java.util.List;

public final class c implements b {
    private final List<a> AcD = new ArrayList();

    public final void a(a aVar) {
        if (aVar.uid == 0 && !TextUtils.isEmpty(aVar.AcL) && "u:r:zygote:s0".equals(aVar.AcL) && !TextUtils.isEmpty(aVar.name) && !"zygote".equals(aVar.name) && !"zygote64".equals(aVar.name)) {
            h.abG("JavaProcessAnalyzer match : " + aVar.toString());
            this.AcD.add(aVar);
        }
    }

    public final boolean cEk() {
        return this.AcD.size() > 0;
    }
}
