package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.protocal.c.vf;
import com.tencent.mm.protocal.c.vq;
import java.util.List;

public interface r extends d {
    void checkFavItem(vq vqVar);

    void checkFavItem(List<vf> list);

    j getFavCdnStorage();

    k getFavConfigStorage();

    l getFavEditInfoStorage();

    o getFavItemInfoStorage();

    p getFavSearchStorage();
}
