package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import com.tencent.mm.v.a.m;
import java.util.HashMap;
import junit.framework.Assert;

public final class ChoicePreference extends Preference {
    private int plh;
    String value;
    private final HashMap<CharSequence, b> values;
    private RadioGroup yqC;
    private CharSequence[] yqD;
    private CharSequence[] yqE;
    public a yqF;

    public ChoicePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChoicePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.values = new HashMap();
        this.plh = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.eZP, i, 0);
        this.yqD = obtainStyledAttributes.getTextArray(m.haG);
        this.yqE = obtainStyledAttributes.getTextArray(m.haH);
        obtainStyledAttributes.recycle();
        cqZ();
    }

    public final void a(a aVar) {
        this.yqF = aVar;
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(g.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(h.gZq, viewGroup2);
        this.yqC = (RadioGroup) onCreateView.findViewById(g.atY);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.yqE.length) {
                b bVar = (b) this.values.get(this.yqE[i2]);
                if (bVar != null) {
                    RadioButton radioButton;
                    if (i2 == 0) {
                        radioButton = (RadioButton) layoutInflater.inflate(h.gZc, null);
                        bVar.a(radioButton);
                        this.yqC.addView(radioButton);
                    } else if (i2 == this.yqE.length - 1) {
                        radioButton = (RadioButton) layoutInflater.inflate(h.gZe, null);
                        bVar.a(radioButton);
                        this.yqC.addView(radioButton);
                    } else {
                        radioButton = (RadioButton) layoutInflater.inflate(h.gZd, null);
                        bVar.a(radioButton);
                        this.yqC.addView(radioButton);
                    }
                }
                i = i2 + 1;
            } else {
                this.yqC.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                        if (ChoicePreference.this.yqF != null) {
                            if (i != -1) {
                                ChoicePreference.this.value = ChoicePreference.this.yqE[i - 1048576];
                            } else {
                                ChoicePreference.this.value = null;
                            }
                            ChoicePreference.this.plh = i;
                            ChoicePreference.this.yqF.a(ChoicePreference.this, ChoicePreference.this.value);
                        }
                    }
                });
                return onCreateView;
            }
        }
    }

    private void cqZ() {
        boolean z;
        int i = 0;
        if (this.yqD == null) {
            this.yqD = new CharSequence[0];
        }
        if (this.yqE == null) {
            this.yqE = new CharSequence[0];
        }
        String str = "entries count different";
        if (this.yqD.length == this.yqE.length) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        this.values.clear();
        while (i < this.yqE.length) {
            this.values.put(this.yqE[i], new b(this.yqD[i], 1048576 + i));
            i++;
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.yqC != null) {
            this.yqC.check(this.plh);
        }
    }

    public final void setValue(String str) {
        this.value = str;
        b bVar = (b) this.values.get(str);
        if (bVar == null) {
            this.plh = -1;
        } else {
            this.plh = bVar.id;
        }
    }
}
