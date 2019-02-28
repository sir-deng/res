package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.preference.Preference;

public final class PluginEmptyTextPreference extends Preference {
    private Context context;
    private TextView lhD;
    private String text;

    public PluginEmptyTextPreference(Context context, int i) {
        this(context, null, 0);
        this.text = context.getString(i);
    }

    public PluginEmptyTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lhD = null;
        this.context = context;
        setLayoutResource(R.i.dpt);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        View.inflate(this.context, R.i.dpt, null);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.lhD = (TextView) view.findViewById(R.h.cev);
        this.lhD.setText(this.text);
    }
}
