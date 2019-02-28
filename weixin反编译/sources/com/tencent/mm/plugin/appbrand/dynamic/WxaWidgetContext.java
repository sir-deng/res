package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Parcelable;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.DebuggerInfo;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetRuntimeConfig;
import com.tencent.mm.plugin.appbrand.dynamic.launching.WidgetSysConfig;

public interface WxaWidgetContext extends Parcelable {
    WxaPkgWrappingInfo acY();

    WxaPkgWrappingInfo acZ();

    int ada();

    int adb();

    byte[] adc();

    int ade();

    DebuggerInfo adf();

    WidgetSysConfig adg();

    WidgetRuntimeConfig adh();

    String getAppId();

    String getId();
}
