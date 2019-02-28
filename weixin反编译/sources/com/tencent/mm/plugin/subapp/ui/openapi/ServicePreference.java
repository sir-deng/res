package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.base.MMGridView;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.List;

public class ServicePreference extends Preference {
    private Context context;
    List<f> qpF;
    OnItemClickListener sdH;
    private OnItemClickListener sdI;
    private OnClickListener sdJ;
    private int sdK;
    private boolean sdL;
    private int sdM;
    b seb;

    public ServicePreference(Context context) {
        this(context, null);
    }

    public ServicePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ServicePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sdH = null;
        this.sdI = null;
        this.sdJ = null;
        this.sdL = false;
        this.sdM = 0;
        this.context = context;
        setLayoutResource(R.i.daB);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.eZI);
        this.sdK = obtainStyledAttributes.getInt(R.n.eZJ, 8);
        this.sdL = obtainStyledAttributes.getBoolean(R.n.eZK, false);
        this.sdM = obtainStyledAttributes.getResourceId(R.n.eZL, 0);
        obtainStyledAttributes.recycle();
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        MMGridView mMGridView = (MMGridView) view.findViewById(R.h.cnY);
        if (mMGridView != null) {
            this.seb = new b(this.context, this.qpF);
            an.biT().j(this.seb);
            an.biT().c(this.seb);
            mMGridView.setAdapter(this.seb);
            mMGridView.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (ServicePreference.this.seb.rq(i)) {
                        ServicePreference.this.seb.iW(false);
                    } else if (ServicePreference.this.seb.sdD) {
                        if (ServicePreference.this.sdI != null) {
                            ServicePreference.this.sdI.onItemClick(adapterView, view, i, j);
                        }
                    } else if (ServicePreference.this.sdH != null) {
                        ServicePreference.this.sdH.onItemClick(adapterView, view, i, j);
                    }
                }
            });
            if (this.sdL) {
                mMGridView.setOnItemLongClickListener(new OnItemLongClickListener() {
                    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                        ServicePreference servicePreference = ServicePreference.this;
                        if (servicePreference.seb != null) {
                            servicePreference.seb.iW(!servicePreference.seb.sdD);
                        }
                        return true;
                    }
                });
            }
            TextView textView = (TextView) view.findViewById(R.h.cev);
            if (this.seb.getCount() == 0) {
                textView.setVisibility(0);
                textView.setText(this.sdM);
                mMGridView.setVisibility(8);
            } else {
                textView.setVisibility(8);
                mMGridView.setVisibility(0);
            }
            Button button = (Button) view.findViewById(R.h.bOY);
            button.setVisibility(this.sdK);
            button.setOnClickListener(this.sdJ);
        }
    }

    public final f yy(int i) {
        if (i < 0 || i >= this.seb.getCount()) {
            return null;
        }
        return (f) this.seb.getItem(i);
    }

    public final void onResume() {
        if (this.seb != null) {
            an.biT().c(this.seb);
        }
    }

    public final void onPause() {
        if (this.seb != null) {
            an.biT().j(this.seb);
        }
    }
}
