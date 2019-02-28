package com.tencent.mm.plugin.nfc.c;

import android.nfc.Tag;

public abstract class b {
    public Tag oXx;
    public byte[] oXy = null;

    public boolean a(Tag tag) {
        this.oXx = tag;
        if (tag != null) {
            this.oXy = tag.getId();
        }
        return true;
    }
}
