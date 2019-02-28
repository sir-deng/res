package com.tencent.mm.plugin.appbrand.g.a;

import android.text.TextUtils;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;

abstract class b {
    private final String idX;

    protected abstract void a(f fVar, V8Object v8Object);

    b() {
        this("");
    }

    b(String str) {
        this.idX = str;
    }

    final b a(f fVar) {
        if (TextUtils.isEmpty(this.idX)) {
            a(fVar, fVar.jBI);
        } else {
            V8Value v8Object = new V8Object(fVar.jBI);
            fVar.jBI.add(this.idX, v8Object);
            a(fVar, v8Object);
        }
        return this;
    }
}
