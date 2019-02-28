package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.f;
import com.google.android.gms.wearable.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class d implements f {
    private Uri aMK;
    private byte[] bdg;
    private Map<String, g> bes;

    public d(f fVar) {
        this.aMK = fVar.getUri();
        this.bdg = fVar.getData();
        Map hashMap = new HashMap();
        for (Entry entry : fVar.rr().entrySet()) {
            if (entry.getKey() != null) {
                hashMap.put(entry.getKey(), ((g) entry.getValue()).oz());
            }
        }
        this.bes = Collections.unmodifiableMap(hashMap);
    }

    public final byte[] getData() {
        return this.bdg;
    }

    public final Uri getUri() {
        return this.aMK;
    }

    public final /* synthetic */ Object oz() {
        return this;
    }

    public final Map<String, g> rr() {
        return this.bes;
    }

    public final String toString() {
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        StringBuilder stringBuilder = new StringBuilder("DataItemEntity{ ");
        stringBuilder.append("uri=" + this.aMK);
        stringBuilder.append(", dataSz=" + (this.bdg == null ? "null" : Integer.valueOf(this.bdg.length)));
        stringBuilder.append(", numAssets=" + this.bes.size());
        if (isLoggable && !this.bes.isEmpty()) {
            stringBuilder.append(", assets=[");
            String str = "";
            Iterator it = this.bes.entrySet().iterator();
            while (true) {
                String str2 = str;
                if (!it.hasNext()) {
                    break;
                }
                Entry entry = (Entry) it.next();
                stringBuilder.append(str2 + ((String) entry.getKey()) + ": " + ((g) entry.getValue()).getId());
                str = ", ";
            }
            stringBuilder.append("]");
        }
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}
