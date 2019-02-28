package com.tencent.mm.plugin.appbrand.compat.a;

import android.content.Intent;
import com.tencent.mm.kernel.c.a;
import java.io.File;
import java.util.Map;
import java.util.Properties;

public interface f extends a {
    Intent QT();

    String Ro();

    int Rp();

    boolean aX(String str, String str2);

    Map<String, String> aca();

    Properties o(File file);

    String r(Map<String, String> map);
}
