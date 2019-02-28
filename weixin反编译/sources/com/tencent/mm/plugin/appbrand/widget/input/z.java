package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.appbrand.page.p;

public interface z {

    public interface a {
        void anO();
    }

    public interface b {
        void anu();
    }

    void a(OnFocusChangeListener onFocusChangeListener);

    void a(a aVar);

    void a(b bVar);

    void addTextChangedListener(TextWatcher textWatcher);

    com.tencent.mm.plugin.appbrand.widget.input.autofill.b anH();

    void anJ();

    void anK();

    void anL();

    boolean anr();

    boolean ans();

    boolean anv();

    void b(OnFocusChangeListener onFocusChangeListener);

    void dC(boolean z);

    void destroy();

    Context getContext();

    int getInputId();

    View getInputPanel();

    CharSequence getText();

    View getView();

    void mu(int i);

    int mw(int i);

    void r(float f, float f2);

    void r(p pVar);

    void s(p pVar);
}
