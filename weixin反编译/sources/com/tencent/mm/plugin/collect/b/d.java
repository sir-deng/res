package com.tencent.mm.plugin.collect.b;

import java.util.LinkedList;
import java.util.List;

public enum d {
    ;
    
    public List<a> kOg;

    public interface a {
        void b(t tVar);
    }

    private d(String str) {
        this.kOg = new LinkedList();
    }

    public final void a(t tVar) {
        for (a aVar : this.kOg) {
            if (aVar != null) {
                aVar.b(tVar);
            }
        }
    }
}
