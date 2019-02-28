package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.widget.BaseAdapter;
import java.util.HashMap;
import java.util.List;

public abstract class a extends BaseAdapter implements d {
    private int rWk = 0;
    HashMap<Object, Integer> rWl = new HashMap();

    public final boolean hasStableIds() {
        return true;
    }

    protected final void bN(Object obj) {
        HashMap hashMap = this.rWl;
        int i = this.rWk;
        this.rWk = i + 1;
        hashMap.put(obj, Integer.valueOf(i));
    }

    protected final void ca(List<?> list) {
        for (Object bN : list) {
            bN(bN);
        }
    }

    public final long getItemId(int i) {
        if (i < 0 || i >= this.rWl.size()) {
            return -1;
        }
        return (long) ((Integer) this.rWl.get(getItem(i))).intValue();
    }
}
