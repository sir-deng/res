package com.tencent.recovery.config;

import java.util.ArrayList;
import java.util.List;

public class Express {
    public List<List<ExpressItem>> Aaz = new ArrayList();

    public String toString() {
        return this.Aaz.toString();
    }

    public final void dJ(List<ExpressItem> list) {
        this.Aaz.add(list);
    }
}
