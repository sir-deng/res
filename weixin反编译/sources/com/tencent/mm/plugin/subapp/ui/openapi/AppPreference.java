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

public class AppPreference extends Preference {
    private Context context;
    int sdE;
    a sdG;
    OnItemClickListener sdH;
    OnItemClickListener sdI;
    private OnClickListener sdJ;
    private int sdK;
    private boolean sdL;
    private int sdM;

    public AppPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.sdH = null;
        this.sdI = null;
        this.sdJ = null;
        this.sdE = 0;
        this.sdL = false;
        this.sdM = 0;
        this.context = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.eZI);
        this.sdK = obtainStyledAttributes.getInt(R.n.eZJ, 8);
        this.sdL = obtainStyledAttributes.getBoolean(R.n.eZK, false);
        this.sdM = obtainStyledAttributes.getResourceId(R.n.eZL, 0);
        obtainStyledAttributes.recycle();
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        MMGridView mMGridView = (MMGridView) view.findViewById(R.h.cnY);
        this.sdG = new a(this.context, this.sdE);
        mMGridView.setAdapter(this.sdG);
        mMGridView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (AppPreference.this.sdG.rq(i)) {
                    AppPreference.this.sdG.iW(false);
                } else if (AppPreference.this.sdG.sdD) {
                    if (AppPreference.this.sdI != null) {
                        AppPreference.this.sdI.onItemClick(adapterView, view, i, j);
                    }
                } else if (AppPreference.this.sdH != null) {
                    AppPreference.this.sdH.onItemClick(adapterView, view, i, j);
                }
            }
        });
        if (this.sdL) {
            mMGridView.setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppPreference appPreference = AppPreference.this;
                    if (appPreference.sdG != null) {
                        appPreference.sdG.iW(!appPreference.sdG.sdD);
                    }
                    return true;
                }
            });
        }
        TextView textView = (TextView) view.findViewById(R.h.cev);
        if (this.sdG.getCount() == 0) {
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

    public final f yy(int i) {
        if (i < 0 || i >= this.sdG.getCount()) {
            return null;
        }
        return (f) this.sdG.getItem(i);
    }

    public final void onResume() {
        if (this.sdG != null) {
            an.biT().c(this.sdG);
        }
    }

    public final void onPause() {
        if (this.sdG != null) {
            an.biT().j(this.sdG);
        }
    }
}
