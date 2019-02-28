package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.ui.base.preference.Preference;

public class GameRegionPreference extends Preference {
    a nAh;

    public static class a {
        public String fXq;
        public boolean isDefault;
        public String nAi;
        public String nAj;
        public String nAk;
        public boolean nAl;
    }

    public GameRegionPreference(Context context) {
        this(context, null);
    }

    public GameRegionPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GameRegionPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.dnz);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.i.dlk, viewGroup2);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.h.cHD);
        CheckBox checkBox = (CheckBox) view.findViewById(R.h.cPq);
        if (textView != null && checkBox != null && this.nAh != null) {
            textView.setText(g.a(this.nAh));
            checkBox.setChecked(this.nAh.nAl);
        }
    }
}
