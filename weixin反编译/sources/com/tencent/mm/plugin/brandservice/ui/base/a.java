package com.tencent.mm.plugin.brandservice.ui.base;

import com.tencent.mm.plugin.brandservice.ui.c.b;
import java.util.List;

public abstract class a extends com.tencent.mm.ui.base.sortview.a {
    protected b kLj;
    public List<String> kMM;
    protected int kMN;
    protected int position;

    public a(int i, Object obj) {
        super(i, obj);
    }

    public final void a(b bVar) {
        this.kLj = bVar;
    }

    public final b atj() {
        return this.kLj;
    }

    public final void nR(int i) {
        this.kMN = i;
    }

    public final int atk() {
        return this.kMN;
    }

    public final void cR(int i) {
        this.position = i;
    }

    public final int getPosition() {
        return this.position;
    }
}
