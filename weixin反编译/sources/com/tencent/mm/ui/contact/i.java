package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.af.e;
import com.tencent.mm.af.e.a.b;
import com.tencent.mm.af.y;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i extends LinearLayout implements com.tencent.mm.af.e.a {
    private Context context;
    private LinearLayout mAt = null;
    private List<String> zbm;
    private Map<String, View> zbn;
    private a zbo;

    public interface a {
        void GE(int i);
    }

    public i(Context context, a aVar) {
        super(context);
        this.context = context;
        this.zbo = aVar;
        init();
    }

    public final int cwJ() {
        if (this.zbm == null) {
            return 0;
        }
        return this.zbm.size();
    }

    private void init() {
        int i = 0;
        e Ml = y.Ml();
        List arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        e.a(stringBuilder);
        e.c(stringBuilder);
        stringBuilder.append(" and bizinfo.type").append(" = 2 ");
        stringBuilder.append(" order by ");
        stringBuilder.append(e.LO());
        x.i("MicroMsg.BizInfoStorage", "getEnterpriseFatherBizLst sql %s", stringBuilder.toString());
        Cursor rawQuery = Ml.rawQuery(r3, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    arrayList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        this.zbm = arrayList;
        if (this.zbm == null || this.zbm.size() <= 0) {
            x.e("MicroMsg.EnterpriseBizView", "bizList is null");
            return;
        }
        x.i("MicroMsg.EnterpriseBizView", "biz list size = %s", Integer.valueOf(this.zbm.size()));
        this.zbn = new HashMap();
        if (this.mAt == null) {
            View.inflate(getContext(), R.i.dgq, this);
            this.mAt = (LinearLayout) findViewById(R.h.bYH);
        }
        while (i < this.zbm.size()) {
            String str = (String) this.zbm.get(i);
            View jVar = new j(getContext(), str);
            this.mAt.addView(jVar);
            this.zbn.put(str, jVar);
            if (i == this.zbm.size() - 1) {
                jVar.findViewById(R.h.ceD).setBackgroundResource(R.g.bDK);
            }
            i++;
        }
    }

    public final void a(final b bVar) {
        if (bVar.hro != null) {
            if (bVar.hro.Lk()) {
                ah.y(new Runnable() {
                    public final void run() {
                        as.Hm();
                        ag Xv = c.Ff().Xv(bVar.hpQ);
                        if (i.this.zbm == null || i.this.zbm.size() <= 0 || !i.this.zbm.contains(bVar.hpQ)) {
                            if (Xv != null && ((int) Xv.gKO) > 0 && com.tencent.mm.k.a.ga(Xv.field_type)) {
                                if (i.this.zbm != null) {
                                    i.this.zbm.clear();
                                }
                                if (i.this.zbn != null) {
                                    i.this.zbn.clear();
                                }
                                if (i.this.mAt != null) {
                                    i.this.mAt.removeAllViews();
                                }
                                i.this.init();
                                if (i.this.zbo != null) {
                                    i.this.zbo.GE(i.this.zbm.size());
                                }
                            }
                        } else if (Xv == null || ((int) Xv.gKO) <= 0 || !com.tencent.mm.k.a.ga(Xv.field_type)) {
                            x.i("MicroMsg.EnterpriseBizView", "remove enterprise biz view item, %s", bVar.hpQ);
                            i.this.zbm.remove(bVar.hpQ);
                            if (i.this.zbm.size() > 0) {
                                View view = (View) i.this.zbn.get(bVar.hpQ);
                                if (view != null && i.this.mAt != null) {
                                    i.this.mAt.removeView(view);
                                    i.this.zbn.remove(view);
                                }
                            } else if (i.this.zbo != null) {
                                if (i.this.zbn != null) {
                                    i.this.zbn.clear();
                                }
                                if (i.this.mAt != null) {
                                    i.this.mAt.removeAllViews();
                                }
                                i.this.zbo.GE(i.this.zbm.size());
                            }
                        }
                    }
                });
            } else {
                x.i("MicroMsg.EnterpriseBizView", "onEvent, not enterprise father");
            }
        }
    }
}
