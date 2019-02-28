package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public class MusicPreference extends Preference {
    private boolean loa;
    private View mView;
    private OnClickListener pMx;
    public String pYr;
    public String pYs;
    public String pYt;
    private ImageButton qbs;
    a qbt;

    public interface a {
        void d(MusicPreference musicPreference);
    }

    public MusicPreference(Context context) {
        this(context, null);
    }

    public MusicPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MusicPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mView = null;
        this.qbs = null;
        this.pYr = "";
        this.pYs = "";
        this.pYt = "";
        setLayoutResource(R.i.doe);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    public final void hM(boolean z) {
        this.loa = z;
        if (this.qbs == null) {
            return;
        }
        if (z) {
            this.qbs.setImageResource(R.g.bEM);
        } else {
            this.qbs.setImageResource(R.g.bEL);
        }
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.pMx == null) {
            this.pMx = new OnClickListener() {
                public final void onClick(View view) {
                    if (MusicPreference.this.qbt != null && view.getId() == R.h.cDs) {
                        if (MusicPreference.this.loa) {
                            MusicPreference.this.loa = false;
                            MusicPreference.this.qbs.setImageResource(R.g.bEL);
                        } else {
                            MusicPreference.this.loa = true;
                            MusicPreference.this.qbs.setImageResource(R.g.bEM);
                        }
                        MusicPreference.this.qbt.d(MusicPreference.this);
                    }
                }
            };
        }
        this.qbs = (ImageButton) view.findViewById(R.h.cDs);
        this.qbs.setOnClickListener(this.pMx);
        if (this.loa) {
            this.qbs.setImageResource(R.g.bEM);
        } else {
            this.qbs.setImageResource(R.g.bEL);
        }
    }
}
