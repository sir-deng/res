package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.EditText;
import android.widget.ListAdapter;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.e.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.b.a.a;
import com.tencent.mm.plugin.appbrand.widget.input.z;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class d {
    public static <Input extends EditText & z> void a(p pVar, Input input, a aVar) {
        if (((z) input).ans()) {
            final WeakReference weakReference = new WeakReference(pVar);
            final WeakReference weakReference2 = new WeakReference(input);
            h anonymousClass1 = new h() {
                public final void a(String str, h.a aVar) {
                    EditText editText = (EditText) weakReference2.get();
                    p pVar = (p) weakReference.get();
                    if (editText != null && pVar != null) {
                        int inputId = ((z) editText).getInputId();
                        f.a aVar2 = new f.a();
                        Map hashMap = new HashMap();
                        hashMap.put(SlookAirButtonFrequentContactAdapter.ID, str);
                        hashMap.put(Columns.TYPE, aVar.name().toLowerCase());
                        hashMap.put("inputId", Integer.valueOf(inputId));
                        aVar2.aA(pVar.mAppId, pVar.hashCode()).v(hashMap).f(new int[]{pVar.hashCode()});
                    }
                }
            };
            b anH = ((z) input).anH();
            anH.kfT = new a(anH.kfN.getContext(), aVar.khd);
            anH.kfT.kfG = anH.kfR;
            AutoFillListPopupWindowBase autoFillListPopupWindowBase = anH.kfO;
            ListAdapter listAdapter = anH.kfT;
            if (autoFillListPopupWindowBase.mObserver == null) {
                autoFillListPopupWindowBase.mObserver = new c(autoFillListPopupWindowBase, (byte) 0);
            } else if (autoFillListPopupWindowBase.FP != null) {
                autoFillListPopupWindowBase.FP.unregisterDataSetObserver(autoFillListPopupWindowBase.mObserver);
            }
            autoFillListPopupWindowBase.FP = listAdapter;
            if (autoFillListPopupWindowBase.FP != null) {
                listAdapter.registerDataSetObserver(autoFillListPopupWindowBase.mObserver);
            }
            if (autoFillListPopupWindowBase.kgh != null) {
                autoFillListPopupWindowBase.kgh.setAdapter(autoFillListPopupWindowBase.FP);
            }
            anH.kfR.kfZ = anonymousClass1;
            int i = "screen".equalsIgnoreCase(aVar.khc) ? f.kgo : f.kgp;
            if (i != 0) {
                anH.kfS = i;
            }
            anH.anV();
        }
    }
}
