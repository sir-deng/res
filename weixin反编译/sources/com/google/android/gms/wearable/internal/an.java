package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.FutureTask;

final class an {

    static final class e extends a<com.google.android.gms.wearable.c.d> {
        public e(com.google.android.gms.common.api.k.b<com.google.android.gms.wearable.c.d> bVar) {
            super(bVar);
        }

        public final void a(GetFdForAssetResponse getFdForAssetResponse) {
            ap(new com.google.android.gms.wearable.internal.bg.c(ak.dN(getFdForAssetResponse.statusCode), getFdForAssetResponse.beE));
        }
    }

    static final class g extends a<com.google.android.gms.wearable.c.a> {
        private final List<FutureTask<Boolean>> beU;

        g(com.google.android.gms.common.api.k.b<com.google.android.gms.wearable.c.a> bVar, List<FutureTask<Boolean>> list) {
            super(bVar);
            this.beU = list;
        }

        public final void a(PutDataResponse putDataResponse) {
            ap(new com.google.android.gms.wearable.internal.bg.a(ak.dN(putDataResponse.statusCode), putDataResponse.beD));
            if (putDataResponse.statusCode != 0) {
                for (FutureTask cancel : this.beU) {
                    cancel.cancel(true);
                }
            }
        }
    }

    static final class h extends a<com.google.android.gms.wearable.k.b> {
        public h(com.google.android.gms.common.api.k.b<com.google.android.gms.wearable.k.b> bVar) {
            super(bVar);
        }

        public final void a(SendMessageResponse sendMessageResponse) {
            ap(new com.google.android.gms.wearable.internal.z.a(ak.dN(sendMessageResponse.statusCode), sendMessageResponse.aRm));
        }
    }

    static final class d extends a<com.google.android.gms.wearable.h> {
        public d(com.google.android.gms.common.api.k.b<com.google.android.gms.wearable.h> bVar) {
            super(bVar);
        }

        public final void b(DataHolder dataHolder) {
            ap(new com.google.android.gms.wearable.h(dataHolder));
        }
    }

    static final class f extends a {
        f() {
        }

        public final void f(Status status) {
        }
    }

    static final class b extends a<com.google.android.gms.wearable.c.c> {
        public b(com.google.android.gms.common.api.k.b<com.google.android.gms.wearable.c.c> bVar) {
            super(bVar);
        }

        public final void a(DeleteDataItemsResponse deleteDataItemsResponse) {
            ap(new com.google.android.gms.wearable.internal.bg.b(ak.dN(deleteDataItemsResponse.statusCode), deleteDataItemsResponse.bet));
        }
    }

    static final class i extends a<Status> {
        public i(com.google.android.gms.common.api.k.b<Status> bVar) {
            super(bVar);
        }

        public final void a(ChannelReceiveFileResponse channelReceiveFileResponse) {
            ap(new Status(channelReceiveFileResponse.statusCode));
        }
    }

    static abstract class a<T> extends a {
        private com.google.android.gms.common.api.k.b<T> beT;

        public a(com.google.android.gms.common.api.k.b<T> bVar) {
            this.beT = bVar;
        }

        public final void ap(T t) {
            com.google.android.gms.common.api.k.b bVar = this.beT;
            if (bVar != null) {
                bVar.ac(t);
                this.beT = null;
            }
        }
    }

    static final class c extends a<com.google.android.gms.wearable.n.a> {
        public c(com.google.android.gms.common.api.k.b<com.google.android.gms.wearable.n.a> bVar) {
            super(bVar);
        }

        public final void a(GetConnectedNodesResponse getConnectedNodesResponse) {
            List arrayList = new ArrayList();
            arrayList.addAll(getConnectedNodesResponse.beC);
            ap(new com.google.android.gms.wearable.internal.ac.a(ak.dN(getConnectedNodesResponse.statusCode), arrayList));
        }
    }
}
