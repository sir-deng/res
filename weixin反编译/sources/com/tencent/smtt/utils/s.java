package com.tencent.smtt.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class s {
    public b AkD = null;
    public b AkE = null;

    class b {
        public Map<String, a> iHS = new HashMap();

        public b(File file) {
            this.iHS.clear();
            W(file);
        }

        private void W(File file) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File W : listFiles) {
                    W(W);
                }
            } else if (file.isFile()) {
                String name = file.getName();
                long length = file.length();
                long lastModified = file.lastModified();
                if (name != null && name.length() > 0 && length > 0 && lastModified > 0) {
                    a aVar = new a(name, length, lastModified);
                    if (!this.iHS.containsKey(name)) {
                        this.iHS.put(name, aVar);
                    }
                }
            }
        }
    }

    class a {
        long AkF;
        long lyh;
        private String mName;

        a(String str, long j, long j2) {
            this.mName = str;
            this.lyh = j;
            this.AkF = j2;
        }
    }

    public static boolean a(b bVar, b bVar2) {
        if (bVar == null || bVar.iHS == null || bVar2 == null || bVar2.iHS == null) {
            return false;
        }
        Map map = bVar.iHS;
        Map map2 = bVar2.iHS;
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            a aVar = (a) entry.getValue();
            if (!map2.containsKey(str)) {
                return false;
            }
            a aVar2 = (a) map2.get(str);
            if (aVar.lyh == aVar2.lyh) {
                if (aVar.AkF != aVar2.AkF) {
                }
            }
            return false;
        }
        return true;
    }
}
