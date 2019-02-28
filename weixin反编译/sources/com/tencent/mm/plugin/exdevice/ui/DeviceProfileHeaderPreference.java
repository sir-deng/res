package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.a.a.c.a;
import com.tencent.mm.ap.o;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class DeviceProfileHeaderPreference extends Preference {
    protected MMActivity isO;
    private String kGh;
    private ImageView lXc;
    private TextView lXd;
    private TextView lXe;
    private TextView lXf;
    private View lXg;
    TextView lXh;
    private boolean[] lXi;
    private OnClickListener[] lXj;
    String lXk;
    private String lXl;
    private boolean lXm;
    private CharSequence vA;

    public DeviceProfileHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lXi = new boolean[6];
        this.lXj = new OnClickListener[6];
        this.lXm = false;
        this.isO = (MMActivity) context;
        this.lXm = false;
    }

    public DeviceProfileHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lXi = new boolean[6];
        this.lXj = new OnClickListener[6];
        this.lXm = false;
        this.isO = (MMActivity) context;
        this.lXm = false;
    }

    public final void onBindView(View view) {
        x.d("MicroMsg.DeviceProfileHeaderPreference", "onBindView");
        this.lXc = (ImageView) view.findViewById(R.h.bLE);
        this.lXd = (TextView) view.findViewById(R.h.cyF);
        this.lXe = (TextView) view.findViewById(R.h.cdf);
        this.lXf = (TextView) view.findViewById(R.h.cbw);
        this.lXg = view.findViewById(R.h.cdg);
        this.lXh = (TextView) view.findViewById(R.h.cbv);
        w(this.lXc, 0);
        w(this.lXd, 2);
        w(this.lXe, 1);
        w(this.lXf, 3);
        w(this.lXg, 4);
        w(this.lXh, 5);
        this.lXm = true;
        if (this.lXm) {
            this.lXd.setText(this.vA);
            this.lXf.setText(this.kGh);
            this.lXh.setText(this.lXk);
            dL(this.lXl);
        } else {
            x.w("MicroMsg.DeviceProfileHeaderPreference", "initView : bindView = " + this.lXm);
        }
        super.onBindView(view);
    }

    private void w(View view, int i) {
        view.setVisibility(this.lXi[i] ? 8 : 0);
        view.setOnClickListener(this.lXj[i]);
    }

    public final void C(int i, boolean z) {
        View view;
        boolean z2;
        int i2 = 0;
        switch (i) {
            case 0:
                view = this.lXc;
                break;
            case 1:
                view = this.lXe;
                break;
            case 2:
                view = this.lXd;
                break;
            case 3:
                view = this.lXf;
                break;
            case 4:
                view = this.lXg;
                break;
            case 5:
                view = this.lXh;
                break;
            default:
                return;
        }
        boolean[] zArr = this.lXi;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        zArr[i] = z2;
        if (view != null) {
            if (!z) {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
    }

    public final void a(int i, OnClickListener onClickListener) {
        View view;
        switch (i) {
            case 0:
                view = this.lXc;
                break;
            case 1:
                view = this.lXe;
                break;
            case 2:
                view = this.lXd;
                break;
            case 3:
                view = this.lXf;
                break;
            case 4:
                view = this.lXg;
                break;
            case 5:
                view = this.lXh;
                break;
            default:
                return;
        }
        this.lXj[i] = onClickListener;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public final void setName(CharSequence charSequence) {
        this.vA = charSequence;
        if (this.lXd != null) {
            this.lXd.setText(charSequence);
        }
    }

    public final void zP(String str) {
        this.kGh = str;
        if (this.lXf != null) {
            this.lXf.setText(str);
        }
    }

    public final void dL(String str) {
        this.lXl = str;
        if (this.lXc != null) {
            a aVar = new a();
            Bitmap Ds = d.Ds(R.g.bCa);
            if (!(Ds == null || Ds.isRecycled())) {
                Ds = d.a(Ds, true, 0.5f * ((float) Ds.getWidth()));
                if (!(Ds == null || Ds.isRecycled())) {
                    aVar.hFB = new BitmapDrawable(Ds);
                }
            }
            if (Ds == null || Ds.isRecycled()) {
                aVar.hFA = R.g.bCa;
            }
            aVar.hFJ = true;
            o.PG().a(this.lXl, this.lXc, aVar.PQ());
        }
    }
}
