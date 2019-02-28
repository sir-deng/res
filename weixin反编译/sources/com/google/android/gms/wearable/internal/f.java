package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.g;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class f extends com.google.android.gms.common.data.f implements com.google.android.gms.wearable.f {
    private final int beL;

    public f(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.beL = i2;
    }

    public final byte[] getData() {
        return getByteArray(SlookAirButtonFrequentContactAdapter.DATA);
    }

    public final Uri getUri() {
        return Uri.parse(getString("path"));
    }

    public final /* synthetic */ Object oz() {
        return new d(this);
    }

    public final Map<String, g> rr() {
        Map<String, g> hashMap = new HashMap(this.beL);
        for (int i = 0; i < this.beL; i++) {
            c cVar = new c(this.aMc, this.aMy + i);
            if (cVar.getString("asset_key") != null) {
                hashMap.put(cVar.getString("asset_key"), cVar);
            }
        }
        return hashMap;
    }

    public final String toString() {
        boolean isLoggable = Log.isLoggable("DataItem", 3);
        byte[] byteArray = getByteArray(SlookAirButtonFrequentContactAdapter.DATA);
        Map rr = rr();
        StringBuilder stringBuilder = new StringBuilder("DataItemInternal{ ");
        stringBuilder.append("uri=" + getUri());
        stringBuilder.append(", dataSz=" + (byteArray == null ? "null" : Integer.valueOf(byteArray.length)));
        stringBuilder.append(", numAssets=" + rr.size());
        if (isLoggable && !rr.isEmpty()) {
            stringBuilder.append(", assets=[");
            String str = "";
            Iterator it = rr.entrySet().iterator();
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
