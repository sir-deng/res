package com.tencent.mm.plugin.messenger.a;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Map;

public interface e extends com.tencent.mm.kernel.c.a {

    public interface a {
        String g(Map<String, String> map, String str);
    }

    public interface b {
        CharSequence a(Map<String, String> map, String str, Bundle bundle, WeakReference<Context> weakReference);
    }

    void EU(String str);

    void EV(String str);

    CharSequence EW(String str);

    CharSequence a(String str, Bundle bundle, WeakReference<Context> weakReference, WeakReference<TextView> weakReference2);

    void a(String str, a aVar);

    void a(String str, b bVar);
}
