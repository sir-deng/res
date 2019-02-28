package com.tencent.mm.plugin.card.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.HashMap;
import java.util.Map;

public final class e {
    public CardInfo kNX = null;
    public Map<String, Object> kOy = new HashMap();

    public e() {
        this.kOy.clear();
    }

    public final void putValue(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            this.kOy.put(str, obj);
        }
    }

    public final Object getValue(String str) {
        if (!TextUtils.isEmpty(str) && this.kOy.containsKey(str)) {
            return this.kOy.get(str);
        }
        return null;
    }
}
