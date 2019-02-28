package com.tencent.mm.plugin.appbrand.widget.input.b;

public enum c {
    NORMAL(0),
    BOLD(1);
    
    public final int style;

    private c(int i) {
        this.style = i;
    }

    public static c vG(String str) {
        Enum h = d.h(str, c.class);
        c cVar = NORMAL;
        if (h != null) {
            Enum cVar2 = h;
        }
        return cVar2;
    }
}
