package com.tencent.mm.plugin.bbom;

import android.app.Service;
import android.content.IntentFilter;
import com.tencent.mm.booter.TrafficStatsReceiver;
import com.tencent.mm.modelfriend.AddrBookObserver;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.plugin.zero.a.a;

public final class f implements a {
    private AddrBookObserver kBk;
    private WatchDogPushReceiver kBl;
    private TrafficStatsReceiver kBm;

    public final void a(Service service) {
        this.kBk = new AddrBookObserver(service);
        service.getContentResolver().registerContentObserver(com.tencent.mm.pluginsdk.a.bYJ(), true, this.kBk);
        this.kBl = new WatchDogPushReceiver();
        service.registerReceiver(this.kBl, new IntentFilter("com.tencent.mm.WatchDogPushReceiver"));
        this.kBm = new TrafficStatsReceiver();
        service.registerReceiver(this.kBm, new IntentFilter("com.tencent.mm.TrafficStatsReceiver"));
        TrafficStatsReceiver.aF(service);
    }

    public final void b(Service service) {
        service.getContentResolver().unregisterContentObserver(this.kBk);
        service.unregisterReceiver(this.kBl);
        service.unregisterReceiver(this.kBm);
        TrafficStatsReceiver.aG(service);
    }
}
