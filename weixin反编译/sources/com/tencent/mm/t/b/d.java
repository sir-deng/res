package com.tencent.mm.t.b;

import android.webkit.ValueCallback;

public interface d {
    boolean Cg();

    boolean Ch();

    void cleanup();

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    void pause();

    void resume();
}
