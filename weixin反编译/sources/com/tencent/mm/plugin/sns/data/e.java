package com.tencent.mm.plugin.sns.data;

import com.tencent.mm.protocal.c.are;
import java.util.LinkedList;
import java.util.List;

public final class e {
    public String hMN;
    public List<are> list = new LinkedList();
    public int qWU;

    public e(are are) {
        this.list.add(are);
    }

    public e(List<are> list) {
        this.list = list;
    }
}
