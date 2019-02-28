package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.EditText;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.v.a.e;
import com.tencent.mm.v.a.k;

public class EditPreference extends Preference {
    private i pDT;
    String value;
    private com.tencent.mm.ui.base.preference.Preference.a yqF;
    a yqK;
    private EditText yqL;

    public interface a {
        void cra();
    }

    public EditPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(com.tencent.mm.ui.base.preference.Preference.a aVar) {
        this.yqF = aVar;
    }

    public final void showDialog() {
        View view;
        if (this.yqL != null) {
            view = this.yqL;
        } else {
            view = new EditText(this.mContext);
            view.setLayoutParams(new LayoutParams(-1, -2));
            view.setSingleLine(true);
            view.setText(this.value);
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(e.bvw);
            marginLayoutParams.leftMargin = dimensionPixelSize;
            marginLayoutParams.rightMargin = dimensionPixelSize;
            marginLayoutParams.topMargin = dimensionPixelSize;
            marginLayoutParams.bottomMargin = dimensionPixelSize;
        }
        if (view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        this.pDT = h.a(this.mContext, getTitle().toString(), view, com.tencent.mm.bu.a.ac(this.mContext, k.dGf), com.tencent.mm.bu.a.ac(this.mContext, k.dEy), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (EditPreference.this.pDT != null) {
                    EditPreference.this.pDT.dismiss();
                }
                EditPreference.this.value = view.getText().toString();
                if (EditPreference.this.yqK != null) {
                    EditPreference.this.yqK.cra();
                }
                if (EditPreference.this.yqF != null) {
                    EditPreference.this.yqF.a(EditPreference.this, EditPreference.this.value);
                }
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (EditPreference.this.pDT != null) {
                    EditPreference.this.pDT.dismiss();
                }
            }
        });
    }
}
