package com.tencent.mm.plugin.favorite;

import com.tencent.mm.f.a.ft;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.b.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends c<ft> {
    private aa<Long, f> muL;
    private h muM;

    public e() {
        this.muL = new aa(10);
        this.xmG = ft.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        f fVar;
        ft ftVar = (ft) bVar;
        if (ftVar.fvX.frf == 0) {
            fVar = null;
        } else if (ftVar.fvX.fwe) {
            fVar = h.getFavItemInfoStorage().dc(ftVar.fvX.frf);
            if (fVar != null) {
                this.muL.put(Long.valueOf(ftVar.fvX.frf), fVar);
            }
        } else {
            f fVar2 = (f) this.muL.get(Long.valueOf(ftVar.fvX.frf));
            String str = "MicroMsg.FavImageServiceListener";
            String str2 = "get item from cache itemInfo is null? %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(fVar2 == null);
            x.d(str, str2, objArr);
            if (fVar2 == null) {
                fVar = h.getFavItemInfoStorage().dc(ftVar.fvX.frf);
                if (fVar != null) {
                    this.muL.put(Long.valueOf(ftVar.fvX.frf), fVar);
                }
            } else {
                fVar = fVar2;
            }
        }
        x.d("MicroMsg.FavImageServiceListener", "image serivce callback type %d, localId %d", Integer.valueOf(ftVar.fvX.opType), Long.valueOf(ftVar.fvX.frf));
        if (fVar != null || ftVar.fvX.opType == 3 || ftVar.fvX.opType == 4) {
            switch (ftVar.fvX.opType) {
                case 0:
                    ftVar.fvY.fwf = h.a(ftVar.fvX.fvZ, fVar);
                    break;
                case 1:
                    if (this.muM != null) {
                        this.muM.b(ftVar.fvX.fwa, ftVar.fvX.fvZ, fVar, ftVar.fvX.fwb, ftVar.fvX.width, ftVar.fvX.height);
                        break;
                    }
                    x.w("MicroMsg.FavImageServiceListener", "imageServer is null");
                    break;
                case 2:
                    x.d("MicroMsg.FavImageServiceListener", "get img from Cache %s", Boolean.valueOf(ftVar.fvX.fwc));
                    if (!ftVar.fvX.fwc) {
                        ftVar.fvY.fwf = h.b(ftVar.fvX.fvZ, fVar, ftVar.fvX.maxWidth);
                        break;
                    }
                    ftVar.fvY.fwf = h.j(ftVar.fvX.fvZ);
                    break;
                case 3:
                    x.d("MicroMsg.FavImageServiceListener", "create image server");
                    if (this.muM != null) {
                        this.muM.destory();
                    }
                    this.muM = new h(ftVar.fvX.context, 16);
                    break;
                case 4:
                    x.d("MicroMsg.FavImageServiceListener", "destroy image server");
                    if (this.muM != null) {
                        this.muM.destory();
                        this.muM = null;
                        break;
                    }
                    break;
            }
        }
        return false;
    }
}
