package com.tencent.mm.plugin.ae;

import android.util.SparseArray;

public enum c {
    ;
    
    public final SparseArray<b> qyV;

    private c(String str) {
        this.qyV = new SparseArray();
    }

    public final boolean a(b bVar) {
        this.qyV.put(bVar.getType(), bVar);
        return true;
    }
}
