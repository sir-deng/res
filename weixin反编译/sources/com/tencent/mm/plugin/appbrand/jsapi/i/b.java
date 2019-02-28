package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.appbrand.q.g;
import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 107;
    private static final String NAME = "showActionSheet";

    private static final class a extends BaseAdapter {
        private final ArrayList<String> jtl;
        private final int jtm;

        private static final class a {
            TextView jtn;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return kF(i);
        }

        public a(ArrayList<String> arrayList, int i) {
            this.jtl = arrayList;
            this.jtm = i;
        }

        public final int getCount() {
            return this.jtl.size();
        }

        private String kF(int i) {
            return (String) this.jtl.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = View.inflate(viewGroup.getContext(), h.izH, null);
                a aVar2 = new a();
                aVar2.jtn = (TextView) view.findViewById(g.title);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.jtn.setText(kF(i));
            aVar.jtn.setTextColor(this.jtm);
            return view;
        }
    }

    public final void a(j jVar, JSONObject jSONObject, int i) {
        p b = e.b(jVar);
        if (b == null) {
            x.w("MicroMsg.JsApiShowActionSheet", "invoke JsApi JsApiShowActionSheet failed, current page view is null.");
            jVar.E(i, e("fail", null));
            return;
        }
        m.o(b);
        String optString = jSONObject.optString("itemList");
        final ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(optString);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < jSONArray.length()) {
                    arrayList.add((String) jSONArray.get(i3));
                    i2 = i3 + 1;
                } else {
                    final j jVar2 = jVar;
                    final JSONObject jSONObject2 = jSONObject;
                    final int i4 = i;
                    ah.y(new Runnable() {
                        public final void run() {
                            if (jVar2.Vx) {
                                Context a = b.this.a(jVar2);
                                final com.tencent.mm.plugin.appbrand.widget.c.h bVar = new com.tencent.mm.plugin.appbrand.widget.c.b(a);
                                int aR = f.aR(jSONObject2.optString("itemColor", ""), Color.parseColor("#000000"));
                                View view = (ViewGroup) View.inflate(a, h.gZl, null);
                                bVar.setContentView(view);
                                ListView listView = (ListView) view.findViewById(g.list);
                                listView.setAdapter(new a(arrayList, aR));
                                listView.setOnItemClickListener(new OnItemClickListener() {
                                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                                        Map hashMap = new HashMap();
                                        hashMap.put("tapIndex", Integer.valueOf(i));
                                        jVar2.E(i4, b.this.e("ok", hashMap));
                                        bVar.dismiss();
                                    }
                                });
                                bVar.setOnCancelListener(new OnCancelListener() {
                                    public final void onCancel(DialogInterface dialogInterface) {
                                        jVar2.E(i4, b.this.e("cancel", null));
                                    }
                                });
                                jVar2.iuk.a(bVar);
                            }
                        }
                    });
                    return;
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.JsApiShowActionSheet", e.getMessage());
            jVar.E(i, e("fail", null));
        }
    }
}
