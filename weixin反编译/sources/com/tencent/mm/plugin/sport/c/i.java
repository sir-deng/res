package com.tencent.mm.plugin.sport.c;

import android.os.RemoteException;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.b.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class i {
    public static h bEf() {
        if (ad.cgj()) {
            return new h(a.rZG);
        }
        if (ad.cgm()) {
            return new h(a.rZF);
        }
        return null;
    }

    public static long K(int i, long j) {
        if (ad.cgj()) {
            return ((PluginSport) g.k(PluginSport.class)).getSportFileStorage().getLong(i, j);
        }
        return new h(a.rZG).getLong(i, j);
    }

    public static void L(int i, long j) {
        if (ad.cgj()) {
            ((PluginSport) g.k(PluginSport.class)).getSportFileStorage().setLong(i, j);
        } else {
            throw new RuntimeException(String.format("not support set value in %s process", new Object[]{ad.By()}));
        }
    }

    public static long yv(int i) {
        if (ad.cgm()) {
            return ((PluginSport) g.k(PluginSport.class)).getSportFileStorage().getLong(i, 0);
        }
        if (ad.cgj()) {
            com.tencent.mm.plugin.sport.a.a aVar = ((PluginSport) g.k(PluginSport.class)).getDeviceStepManager().rZL;
            if (aVar != null) {
                try {
                    return aVar.getLong(i, 0);
                } catch (RemoteException e) {
                }
            }
        }
        return new h(a.rZF).getLong(i, 0);
    }

    public static void M(int i, long j) {
        if (ad.cgm()) {
            ((PluginSport) g.k(PluginSport.class)).getSportFileStorage().setLong(i, j);
        } else if (ad.cgj()) {
            com.tencent.mm.plugin.sport.a.a aVar = ((PluginSport) g.k(PluginSport.class)).getDeviceStepManager().rZL;
            if (aVar != null) {
                try {
                    aVar.J(i, j);
                } catch (RemoteException e) {
                }
            }
        }
    }
}
