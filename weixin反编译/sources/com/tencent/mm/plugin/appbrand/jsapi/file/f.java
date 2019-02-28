package com.tencent.mm.plugin.appbrand.jsapi.file;

import java.util.HashMap;
import java.util.Map;

public interface f {

    public static final class a {
        public final String foE;
        public final Map<String, Object> values = new HashMap();

        public a(String str, Object... objArr) {
            this.foE = String.format(str, objArr);
        }

        public final a s(String str, Object obj) {
            this.values.put(str, obj);
            return this;
        }

        public final a w(Map<String, Object> map) {
            if (map != null) {
                this.values.putAll(map);
            }
            return this;
        }
    }
}
