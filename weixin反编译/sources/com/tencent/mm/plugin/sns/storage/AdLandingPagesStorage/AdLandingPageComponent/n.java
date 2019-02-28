package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class n extends s {
    public int rmA = 0;
    public boolean rmB = true;
    public LinkedList<m> rmy = new LinkedList();

    protected final List<s> bxw() {
        List<s> arrayList = new ArrayList(super.bxw());
        if (this.rmy != null) {
            Iterator it = this.rmy.iterator();
            while (it.hasNext()) {
                m mVar = (m) it.next();
                if (mVar.rmy != null) {
                    arrayList.addAll(mVar.rmy);
                }
            }
        }
        return arrayList;
    }
}
