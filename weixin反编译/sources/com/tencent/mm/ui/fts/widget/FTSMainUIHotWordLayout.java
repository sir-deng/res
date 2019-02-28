package com.tencent.mm.ui.fts.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class FTSMainUIHotWordLayout extends LinearLayout {
    private TextView ikL = null;
    protected OnClickListener qjg;
    protected List<LinearLayout> zni = null;
    protected int zns = 2;
    protected boolean znt = true;
    public b znu = null;

    public static class a {
        public int fGi;
        public String jumpUrl;
        public String znv;
        public int znw;
    }

    private static class b {
        public String iVa;
    }

    public FTSMainUIHotWordLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public FTSMainUIHotWordLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    private void initView() {
        setOrientation(1);
        this.zni = new ArrayList();
    }

    public final void p(OnClickListener onClickListener) {
        this.qjg = onClickListener;
    }

    public final String cya() {
        if (this.znu == null || this.znu.iVa == null) {
            return "";
        }
        return this.znu.iVa;
    }

    public void setVisibility(int i) {
        if ((this.zni.size() > 0 ? 1 : null) == null) {
            i = 8;
        }
        super.setVisibility(i);
    }
}
