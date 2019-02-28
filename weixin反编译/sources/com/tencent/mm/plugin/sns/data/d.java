package com.tencent.mm.plugin.sns.data;

import com.tencent.mm.protocal.c.bku;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    public ConcurrentHashMap<String, CharSequence> qWT = new ConcurrentHashMap();

    public final void a(bku bku, CharSequence charSequence) {
        this.qWT.put(bku.wUn + "-" + bku.wUq + "-" + bku.noL, charSequence);
    }
}
