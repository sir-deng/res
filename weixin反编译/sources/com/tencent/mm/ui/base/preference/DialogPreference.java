package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.v.a.h;
import com.tencent.mm.v.a.m;

public final class DialogPreference extends Preference {
    private i pDT;
    public com.tencent.mm.ui.base.preference.Preference.a yqF;
    private final d yqH;
    a yqI;

    public interface a {
        void cra();
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.yqH = new d(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.eZP, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(m.haG, -1);
        if (resourceId != -1) {
            this.yqH.yqD = context.getResources().getStringArray(resourceId);
        }
        this.yqH.yqE = obtainStyledAttributes.getTextArray(m.haH);
        obtainStyledAttributes.recycle();
        this.yqH.cqZ();
    }

    public final void a(com.tencent.mm.ui.base.preference.Preference.a aVar) {
        this.yqF = aVar;
    }

    public final String getValue() {
        return this.yqH.value;
    }

    public final void setValue(String str) {
        this.yqH.value = str;
        c cVar = (c) this.yqH.values.get(str);
        if (cVar == null) {
            this.yqH.plh = -1;
            return;
        }
        this.yqH.plh = cVar.id;
    }

    public final void onBindView(View view) {
        c cVar = (c) this.yqH.values.get(this.yqH.value);
        if (cVar != null) {
            setSummary(cVar.text);
        }
        super.onBindView(view);
    }

    protected final void showDialog() {
        ListViewInScrollView listViewInScrollView = (ListViewInScrollView) View.inflate(this.mContext, h.gZk, null);
        listViewInScrollView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (DialogPreference.this.pDT != null) {
                    DialogPreference.this.pDT.dismiss();
                }
                DialogPreference.this.setValue((String) DialogPreference.this.yqH.yqE[i]);
                if (DialogPreference.this.yqI != null) {
                    DialogPreference.this.yqI.cra();
                }
                if (DialogPreference.this.yqF != null) {
                    DialogPreference.this.yqF.a(DialogPreference.this, DialogPreference.this.getValue());
                }
            }
        });
        listViewInScrollView.setAdapter(this.yqH);
        com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(this.mContext);
        aVar.Zm(getTitle().toString());
        aVar.dk(listViewInScrollView);
        this.pDT = aVar.ale();
        this.pDT.show();
        com.tencent.mm.ui.base.h.a(this.mContext, this.pDT);
    }
}
