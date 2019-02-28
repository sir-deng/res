package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.ca.a.e;
import com.tencent.mm.ca.a.f;
import java.util.ArrayList;

public final class b implements OnGlobalLayoutListener {
    private Button kxK;
    private Button kxL;
    private View lHV = View.inflate(this.mContext, f.zIJ, null);
    private Context mContext;
    private c yQT = new c(this.mContext);
    private int yQU;
    private BottomSheetBehavior yQV;
    private String[] zHf;
    private int zHg;
    private OptionPicker zHh = ((OptionPicker) this.lHV.findViewById(e.zIw));
    public a zHi;

    public interface a<T> {
        void f(boolean z, T t);
    }

    static /* synthetic */ void a(b bVar, boolean z, Object obj) {
        if (bVar.zHi != null) {
            bVar.zHi.f(z, obj);
        }
    }

    public b(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        this.zHf = (String[]) arrayList.toArray(new String[arrayList.size()]);
        this.zHh.j(this.zHf);
        this.zHg = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 288);
        this.kxK = (Button) this.lHV.findViewById(e.cBI);
        this.kxK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Object obj;
                b bVar = b.this;
                if (b.this.zHh == null) {
                    obj = null;
                } else {
                    OptionPicker a = b.this.zHh;
                    obj = (a.kiV == null || a.kiV.length <= 0) ? "" : a.kiV[a.getValue()];
                }
                b.a(bVar, true, obj);
            }
        });
        this.kxL = (Button) this.lHV.findViewById(e.bPp);
        this.kxL.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                b.a(b.this, false, null);
            }
        });
        this.yQT.setContentView(this.lHV);
        this.yQU = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 350);
        this.yQV = BottomSheetBehavior.i((View) this.lHV.getParent());
        if (this.yQV != null) {
            this.yQV.q(this.yQU);
            this.yQV.fj = false;
        }
        this.yQT.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                b.this.yQT = null;
            }
        });
    }

    public final void onGlobalLayout() {
    }

    public final void HD(int i) {
        if (i != 0) {
            this.zHg = i;
        }
        LayoutParams layoutParams = (LayoutParams) this.lHV.getLayoutParams();
        layoutParams.height = this.zHg;
        this.lHV.setLayoutParams(layoutParams);
        this.lHV.invalidate();
    }

    public final void show() {
        if (this.yQT != null) {
            this.yQT.show();
        }
    }

    public final void hide() {
        if (this.yQT != null) {
            this.yQT.dismiss();
        }
    }

    public final void HE(int i) {
        if (this.zHh != null) {
            this.zHh.setValue(i);
        }
    }

    public final int cAm() {
        if (this.zHh != null) {
            return this.zHh.getValue();
        }
        return 0;
    }
}
