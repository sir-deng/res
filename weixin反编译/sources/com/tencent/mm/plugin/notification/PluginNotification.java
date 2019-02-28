package com.tencent.mm.plugin.notification;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.y.aj;

public class PluginNotification extends f implements a {
    private aj oZC;

    public void execute(g gVar) {
    }

    public void setNotification(aj ajVar) {
        this.oZC = ajVar;
        b.oZq = ajVar;
    }

    public aj getNotification() {
        return this.oZC;
    }
}
