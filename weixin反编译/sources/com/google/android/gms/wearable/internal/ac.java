package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.g;
import com.google.android.gms.wearable.m;
import com.google.android.gms.wearable.n;
import java.util.ArrayList;
import java.util.List;

public final class ac implements n {

    public static class a implements com.google.android.gms.wearable.n.a {
        private final Status bcR;
        private final List<m> beS;

        public a(Status status, List<m> list) {
            this.bcR = status;
            this.beS = list;
        }

        public final Status oh() {
            return this.bcR;
        }

        public final List<m> rt() {
            return this.beS;
        }
    }

    public final e<com.google.android.gms.wearable.n.a> b(c cVar) {
        return cVar.a(new aw<com.google.android.gms.wearable.n.a>(cVar) {
            protected final /* synthetic */ g b(Status status) {
                return new a(status, new ArrayList());
            }

            protected final /* synthetic */ void b(b bVar) {
                ((x) ((ao) bVar).oL()).d(new c(this));
            }
        });
    }
}
