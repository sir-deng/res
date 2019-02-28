package com.tencent.mm.ui.tools;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.ActionBarSearchView.b;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.v;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import java.util.ArrayList;

public class SearchViewNotRealTimeHelper extends LinearLayout implements f {
    public EditText yqL;
    public View zpo;
    private ImageButton zpq;
    private com.tencent.mm.ui.tools.ActionBarSearchView.a zpv;
    public Button zvI;
    public a zvJ;

    public interface a {
        void ati();

        boolean pc(String str);

        void wx(String str);
    }

    public SearchViewNotRealTimeHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SearchViewNotRealTimeHelper(Context context) {
        super(context);
        init();
    }

    private void init() {
        v.fw(getContext()).inflate(h.gYI, this, true);
        this.yqL = (EditText) findViewById(g.cdl);
        this.zpq = (ImageButton) findViewById(g.cPs);
        this.zpo = findViewById(g.bIc);
        this.zvI = (Button) findViewById(g.button);
        this.zvI.setEnabled(false);
        this.yqL.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable == null || editable.length() <= 0) {
                    SearchViewNotRealTimeHelper.this.zpq.setVisibility(8);
                    SearchViewNotRealTimeHelper.this.zvI.setEnabled(false);
                    return;
                }
                SearchViewNotRealTimeHelper.this.zpq.setVisibility(0);
                SearchViewNotRealTimeHelper.this.zvI.setEnabled(true);
            }
        });
        this.yqL.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (3 != i || SearchViewNotRealTimeHelper.this.zvJ == null) {
                    return false;
                }
                return SearchViewNotRealTimeHelper.this.zvJ.pc(SearchViewNotRealTimeHelper.this.bVF());
            }
        });
        c.d(this.yqL).Hg(100).a(null);
        this.zpq.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SearchViewNotRealTimeHelper.this.yqL.setText("");
                if (SearchViewNotRealTimeHelper.this.zvJ != null) {
                    SearchViewNotRealTimeHelper.this.zvJ.ati();
                }
            }
        });
        this.zpo.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.v("MicroMsg.SearchViewNotRealTimeHelper", "home btn click");
                if (SearchViewNotRealTimeHelper.this.zpv != null) {
                    SearchViewNotRealTimeHelper.this.zpv.aXg();
                }
            }
        });
        this.zvI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (SearchViewNotRealTimeHelper.this.zvJ != null) {
                    SearchViewNotRealTimeHelper.this.zvJ.wx(SearchViewNotRealTimeHelper.this.bVF());
                }
            }
        });
    }

    public final void V(CharSequence charSequence) {
        this.yqL.setHint(charSequence);
    }

    public final void nz(boolean z) {
        this.yqL.setText("");
    }

    public final void cyo() {
        this.yqL.clearFocus();
    }

    public final String bVF() {
        Editable editableText = this.yqL.getEditableText();
        return editableText == null ? "" : editableText.toString();
    }

    public final void aay(String str) {
        this.yqL.setText("");
        this.yqL.append(str);
    }

    public final void setHint(CharSequence charSequence) {
        V(charSequence);
    }

    public final void a(b bVar) {
    }

    public final void nw(boolean z) {
    }

    public final void nx(boolean z) {
    }

    public final void ny(boolean z) {
    }

    public final void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
    }

    public final void a(a aVar) {
        this.zvJ = aVar;
    }

    public boolean hasFocus() {
        return false;
    }

    public final boolean cyq() {
        return false;
    }

    public final boolean cyp() {
        return false;
    }

    public final void a(com.tencent.mm.ui.tools.ActionBarSearchView.a aVar) {
        this.zpv = aVar;
    }

    public final void ak(ArrayList<String> arrayList) {
    }

    public final void nA(boolean z) {
    }

    public final void Hc(int i) {
    }

    public final void aaz(String str) {
    }
}
