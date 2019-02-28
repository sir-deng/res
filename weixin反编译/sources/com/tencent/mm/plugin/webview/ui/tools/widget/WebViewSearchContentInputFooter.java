package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public class WebViewSearchContentInputFooter extends LinearLayout {
    private View tRi;
    private EditText tRj;
    private View tRk;
    private View tRl;
    private View tRm;
    private TextView tRn;
    public a tRo;

    public interface a {
        void a(WebViewSearchContentInputFooter webViewSearchContentInputFooter);

        void aQb();

        void aQc();

        void aQd();

        void b(WebViewSearchContentInputFooter webViewSearchContentInputFooter);

        boolean c(int i, KeyEvent keyEvent);

        void onShow();
    }

    public WebViewSearchContentInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public WebViewSearchContentInputFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        View inflate = inflate(getContext(), R.i.dup, this);
        this.tRj = (EditText) inflate.findViewById(R.h.cdl);
        this.tRk = inflate.findViewById(R.h.bWm);
        this.tRl = inflate.findViewById(R.h.cDr);
        this.tRm = inflate.findViewById(R.h.cAm);
        this.tRn = (TextView) inflate.findViewById(R.h.cpM);
        this.tRi = inflate.findViewById(R.h.cpU);
        this.tRk.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WebViewSearchContentInputFooter.this.hide();
            }
        });
        this.tRl.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (WebViewSearchContentInputFooter.this.tRo != null) {
                    WebViewSearchContentInputFooter.this.tRo.aQc();
                }
            }
        });
        this.tRm.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (WebViewSearchContentInputFooter.this.tRo != null) {
                    WebViewSearchContentInputFooter.this.tRo.aQd();
                }
            }
        });
        this.tRj.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (WebViewSearchContentInputFooter.this.tRo != null) {
                    WebViewSearchContentInputFooter.this.tRo.c(i, keyEvent);
                }
                if (i != 66 || WebViewSearchContentInputFooter.this.tRo == null) {
                    return false;
                }
                Context context = view.getContext();
                if (context instanceof MMActivity) {
                    ((MMActivity) context).df(WebViewSearchContentInputFooter.this.tRj);
                }
                WebViewSearchContentInputFooter.this.tRo.b(WebViewSearchContentInputFooter.this);
                return true;
            }
        });
        this.tRj.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (!(z || WebViewSearchContentInputFooter.this.tRo == null)) {
                    Context context = view.getContext();
                    if (context instanceof MMActivity) {
                        ((MMActivity) context).df(WebViewSearchContentInputFooter.this.tRj);
                    }
                }
                WebViewSearchContentInputFooter.this.tRi.setSelected(z);
            }
        });
        this.tRj.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (WebViewSearchContentInputFooter.this.tRo != null) {
                    a c = WebViewSearchContentInputFooter.this.tRo;
                    WebViewSearchContentInputFooter webViewSearchContentInputFooter = WebViewSearchContentInputFooter.this;
                    if (charSequence != null) {
                        charSequence.toString();
                    }
                    c.a(webViewSearchContentInputFooter);
                }
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.tRj.setSelectAllOnFocus(true);
        reset();
    }

    public final void reset() {
        this.tRn.setText("");
        this.tRl.setEnabled(false);
        this.tRm.setEnabled(false);
    }

    public final void bVE() {
        this.tRj.setText("");
    }

    public boolean isShown() {
        return getVisibility() == 0;
    }

    public final void show() {
        setVisibility(0);
        if (this.tRo != null) {
            this.tRo.onShow();
        }
        this.tRj.requestFocus();
        postDelayed(new Runnable() {
            public final void run() {
                MMActivity.showVKB((Activity) WebViewSearchContentInputFooter.this.getContext());
            }
        }, 100);
    }

    public final void hide() {
        Context context = this.tRj.getContext();
        if (context instanceof MMActivity) {
            ((MMActivity) context).df(this.tRj);
        }
        this.tRj.clearFocus();
        setVisibility(8);
        if (this.tRo != null) {
            this.tRo.aQb();
        }
    }

    public final void o(int i, int i2, boolean z) {
        boolean z2 = true;
        if (z) {
            boolean z3;
            TextView textView = this.tRn;
            String str = "%d/%d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i2 == 0 ? 0 : i + 1);
            objArr[1] = Integer.valueOf(i2);
            textView.setText(String.format(str, objArr));
            View view = this.tRm;
            if (i2 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            view.setEnabled(z3);
            View view2 = this.tRl;
            if (i2 <= 0) {
                z2 = false;
            }
            view2.setEnabled(z2);
        }
    }

    public final String bVF() {
        return this.tRj.getText().toString();
    }
}
