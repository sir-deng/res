package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.b;
import com.tencent.mm.bu.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONArray;
import org.json.JSONObject;

public class FTSMainUIEducationLayoutWithAll extends FTSMainUIEducationLayout {
    public FTSMainUIEducationLayoutWithAll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FTSMainUIEducationLayoutWithAll(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void cxZ() {
        du(getContext().getResources().getString(R.l.eJj), b.a(null, getContext().getString(R.l.eJj), getContext()));
    }

    private void du(String str, int i) {
        LinearLayout linearLayout = (LinearLayout) inflate(getContext(), R.i.djj, null);
        linearLayout.findViewById(R.h.cQQ).setOnClickListener(this.qjg);
        ((TextView) linearLayout.findViewById(R.h.cQQ)).setText(str);
        this.zni.add(linearLayout);
        this.znj.put(Integer.valueOf(i), (TextView) linearLayout.findViewById(R.h.cQQ));
        addView(linearLayout);
    }

    protected final boolean aj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray == null) {
            return false;
        }
        int aa;
        if (w.eM(ad.getContext()).equalsIgnoreCase("en")) {
            aa = a.aa(getContext(), R.f.buu);
        } else {
            aa = a.aa(getContext(), R.f.bvL);
        }
        int i = 0;
        Object obj = null;
        JSONObject jSONObject2 = null;
        String str = null;
        String str2 = null;
        while (i < optJSONArray.length()) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (i % 3 == 0) {
                str2 = optJSONObject.optString("hotword");
            } else if (i % 3 == 1) {
                str = optJSONObject.optString("hotword");
                JSONObject obj2 = optJSONObject;
                optJSONObject = jSONObject2;
            } else {
                a(str2, jSONObject2, str, obj2, optJSONObject.optString("hotword"), optJSONObject, aa);
                obj2 = null;
                optJSONObject = null;
                str = null;
                str2 = null;
            }
            i++;
            jSONObject2 = optJSONObject;
        }
        if (!(str2 == null || jSONObject2 == null)) {
            a(str2, jSONObject2, str, obj2, null, null, aa);
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("all");
        if (optJSONArray2 == null || optJSONArray2.length() == 0) {
            cxZ();
        } else {
            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(0);
            du(optJSONObject2.optString("hotword"), optJSONObject2.optInt("businessType"));
        }
        return true;
    }
}
