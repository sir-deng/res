package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.preference.Preference;

public class RoomContributePreference extends Preference {
    private ImageView ikl;
    private MaskLayout lhB;
    private String lhC;

    public RoomContributePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public RoomContributePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(R.i.dnz);
        setWidgetLayoutResource(R.i.dob);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        this.lhB = (MaskLayout) onCreateView.findViewById(R.h.cpt);
        this.ikl = (ImageView) onCreateView.findViewById(R.h.image);
        return onCreateView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.ikl != null && !bi.oN(this.lhC)) {
            b.a(this.ikl, this.lhC);
        }
    }
}
