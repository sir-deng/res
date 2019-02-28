package com.tencent.mm.plugin.sns;

import com.tencent.mm.ax.i;
import com.tencent.mm.f.a.lw;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class g extends c<lw> {
    public g() {
        this.xmG = lw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!(((lw) bVar) instanceof lw)) {
            x.f("MicroMsg.PostSnsAsyncTaskListener", "mismatched event");
            return false;
        } else if (ae.bvO()) {
            return false;
        } else {
            int i;
            List linkedList;
            int a;
            x.d("MicroMsg.PostSnsAsyncTask", "check PostTaskSnsPost ");
            if (ae.bwb() != null) {
                ae.bwb().buT();
            }
            x.d("MicroMsg.PostSnsAsyncTask", "check AsyncQueue");
            if (ae.bvV() != null) {
                ae.bwe().bvG();
            }
            com.tencent.mm.kernel.g.Dr();
            if (com.tencent.mm.kernel.g.Do().CF()) {
                com.tencent.mm.kernel.g.Dr();
                com.tencent.mm.kernel.g.Do();
                if (!a.Cz()) {
                    i = 1;
                    if (i != 0) {
                        com.tencent.mm.kernel.g.Dr();
                        if ((bi.bz(bi.a((Long) com.tencent.mm.kernel.g.Dq().Db().get(68390, null), 0)) * 1000 <= 3600000 ? 1 : 0) != 0) {
                            linkedList = new LinkedList();
                            com.tencent.mm.kernel.g.Dr();
                            a = bi.a((Integer) com.tencent.mm.kernel.g.Dq().Db().get(68388, null), 0);
                            com.tencent.mm.kernel.g.Dr();
                            i = bi.a((Integer) com.tencent.mm.kernel.g.Dq().Db().get(68389, null), 0);
                            if (a > 0 || i > 0) {
                                linkedList.add(new i.a(10077, a + "," + i));
                                com.tencent.mm.kernel.g.Dr();
                                com.tencent.mm.kernel.g.Dq().Db().set(68388, Integer.valueOf(0));
                                com.tencent.mm.kernel.g.Dr();
                                com.tencent.mm.kernel.g.Dq().Db().set(68389, Integer.valueOf(0));
                            }
                            com.tencent.mm.kernel.g.Dr();
                            i = bi.a((Integer) com.tencent.mm.kernel.g.Dq().Db().get(68391, null), 0);
                            if (i > 0) {
                                linkedList.add(new i.a(28, String.valueOf(i)));
                                com.tencent.mm.kernel.g.Dr();
                                com.tencent.mm.kernel.g.Dq().Db().set(68391, Integer.valueOf(0));
                            }
                            com.tencent.mm.kernel.g.Dr();
                            a = bi.a((Integer) com.tencent.mm.kernel.g.Dq().Db().get(68392, null), 0);
                            com.tencent.mm.kernel.g.Dr();
                            i = bi.a((Integer) com.tencent.mm.kernel.g.Dq().Db().get(68393, null), 0);
                            if (a > 0 || i > 0) {
                                linkedList.add(new i.a(10072, a + "," + i));
                                com.tencent.mm.kernel.g.Dr();
                                com.tencent.mm.kernel.g.Dq().Db().set(68392, Integer.valueOf(0));
                                com.tencent.mm.kernel.g.Dr();
                                com.tencent.mm.kernel.g.Dq().Db().set(68393, Integer.valueOf(0));
                            }
                            if (!linkedList.isEmpty()) {
                                com.tencent.mm.kernel.g.Dr();
                                ((h) com.tencent.mm.kernel.g.h(h.class)).Fe().b(new i(linkedList));
                                com.tencent.mm.kernel.g.Dr();
                                com.tencent.mm.kernel.g.Dq().Db().set(68390, Long.valueOf(bi.Wx()));
                            }
                        }
                    }
                    return true;
                }
            }
            i = 0;
            if (i != 0) {
                com.tencent.mm.kernel.g.Dr();
                if (bi.bz(bi.a((Long) com.tencent.mm.kernel.g.Dq().Db().get(68390, null), 0)) * 1000 <= 3600000) {
                }
                if ((bi.bz(bi.a((Long) com.tencent.mm.kernel.g.Dq().Db().get(68390, null), 0)) * 1000 <= 3600000 ? 1 : 0) != 0) {
                    linkedList = new LinkedList();
                    com.tencent.mm.kernel.g.Dr();
                    a = bi.a((Integer) com.tencent.mm.kernel.g.Dq().Db().get(68388, null), 0);
                    com.tencent.mm.kernel.g.Dr();
                    i = bi.a((Integer) com.tencent.mm.kernel.g.Dq().Db().get(68389, null), 0);
                    linkedList.add(new i.a(10077, a + "," + i));
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dq().Db().set(68388, Integer.valueOf(0));
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dq().Db().set(68389, Integer.valueOf(0));
                    com.tencent.mm.kernel.g.Dr();
                    i = bi.a((Integer) com.tencent.mm.kernel.g.Dq().Db().get(68391, null), 0);
                    if (i > 0) {
                        linkedList.add(new i.a(28, String.valueOf(i)));
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dq().Db().set(68391, Integer.valueOf(0));
                    }
                    com.tencent.mm.kernel.g.Dr();
                    a = bi.a((Integer) com.tencent.mm.kernel.g.Dq().Db().get(68392, null), 0);
                    com.tencent.mm.kernel.g.Dr();
                    i = bi.a((Integer) com.tencent.mm.kernel.g.Dq().Db().get(68393, null), 0);
                    linkedList.add(new i.a(10072, a + "," + i));
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dq().Db().set(68392, Integer.valueOf(0));
                    com.tencent.mm.kernel.g.Dr();
                    com.tencent.mm.kernel.g.Dq().Db().set(68393, Integer.valueOf(0));
                    if (linkedList.isEmpty()) {
                        com.tencent.mm.kernel.g.Dr();
                        ((h) com.tencent.mm.kernel.g.h(h.class)).Fe().b(new i(linkedList));
                        com.tencent.mm.kernel.g.Dr();
                        com.tencent.mm.kernel.g.Dq().Db().set(68390, Long.valueOf(bi.Wx()));
                    }
                }
            }
            return true;
        }
    }
}
