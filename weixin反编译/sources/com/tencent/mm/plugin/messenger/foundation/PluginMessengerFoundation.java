package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.ax.j;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.bucket.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.plugin.chatroom.b;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bg;
import com.tencent.mm.y.ag;
import com.tencent.mm.y.bt;
import com.tencent.mm.y.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;

public class PluginMessengerFoundation extends f implements a, c, d, n, ag {
    private e hhI = new e();
    private d oui;
    private e ouj;
    private bt ouk = new bt();
    private b oul = new b();
    private ag oum;

    public void installed() {
        alias(n.class);
    }

    public void dependency() {
        dependsOn(PluginZero.class);
    }

    public void configure(g gVar) {
        x.i("MicroMsg.TAG", "init thread pool[%s] current tid[%d] priority[%d] process[%s]", com.tencent.mm.sdk.f.e.chE(), Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(Thread.currentThread().getPriority()), ((h) com.tencent.mm.kernel.g.Dn().CU()).gQd);
        com.tencent.mm.plugin.zero.c.vhy = new com.tencent.mm.cc.c<com.tencent.mm.plugin.zero.a.f>() {
            public final /* synthetic */ Object get() {
                return new f();
            }
        };
        p aVar = new a();
        p.a.a(2, aVar);
        p.a.a(17, aVar);
        p.a.a(4, aVar);
        p.a.a(7, new b());
        aVar = new c();
        p.a.a(5, aVar);
        p.a.a(8, aVar);
        p.a.a(9, aVar);
        p.a.a(1, new g());
        com.tencent.mm.kernel.g.Dm().a(o.class, new com.tencent.mm.kernel.c.d(new com.tencent.mm.modelmulti.o()));
        com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.zero.a.d.class);
        if (gVar.DZ()) {
            new com.tencent.mm.plugin.zero.tasks.b().before(this);
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.messenger.foundation.a.c.class, new com.tencent.mm.plugin.messenger.foundation.a.c() {
                public final void a(asc asc, String str, byte[] bArr, boolean z, boolean z2) {
                    a.a(asc, str, null, true, false);
                }

                public final com.tencent.mm.vending.b.b a(com.tencent.mm.plugin.messenger.foundation.a.b bVar) {
                    return a.a(bVar);
                }
            });
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.messenger.foundation.a.g.class, new com.tencent.mm.plugin.messenger.foundation.a.g() {
                public final void a(com.tencent.mm.ad.d.a aVar, r rVar) {
                    c.a(aVar, rVar);
                }
            });
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.chatroom.b.b.class, this.oul);
        }
    }

    public void execute(g gVar) {
        if (gVar.DZ()) {
            this.oui = new d();
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.messenger.foundation.a.h.class, new com.tencent.mm.kernel.c.d(this.oui));
            this.ouj = new e();
            com.tencent.mm.kernel.g.a(i.class, new com.tencent.mm.kernel.c.d(this.ouj));
        }
    }

    public String toString() {
        return "plugin-messenger-foundation";
    }

    public HashMap<Integer, com.tencent.mm.bx.h.d> collectDatabaseFactory() {
        HashMap<Integer, com.tencent.mm.bx.h.d> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("MESSAGE_TABLE".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return av.gLy;
            }
        });
        hashMap.put(Integer.valueOf("CONTACT_TABLE".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return ad.gLy;
            }
        });
        hashMap.put(Integer.valueOf("OPLOG_TABLE".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return j.gLy;
            }
        });
        hashMap.put(Integer.valueOf("CONVERSATION_TABLE".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return af.gLy;
            }
        });
        hashMap.put(Integer.valueOf("ROLEINFO_TABLE".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return bd.gLy;
            }
        });
        hashMap.put(Integer.valueOf("STRANGER_TABLE".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return bg.gLy;
            }
        });
        hashMap.put(Integer.valueOf("DeletedConversationInfo".hashCode()), new com.tencent.mm.bx.h.d() {
            public final String[] wn() {
                return ai.gLy;
            }
        });
        return hashMap;
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        com.tencent.mm.ad.d.c.a(Integer.valueOf(10000), this.hhI);
        com.tencent.mm.ad.d.c.a(Integer.valueOf(1), this.hhI);
        com.tencent.mm.ad.d.c.a(Integer.valueOf(10001), this.ouk);
        com.tencent.mm.ad.d.c.a(Integer.valueOf(10002), this.ouk);
    }

    public void onAccountRelease() {
        com.tencent.mm.ad.d.c.b(Integer.valueOf(10000), this.hhI);
        com.tencent.mm.ad.d.c.b(Integer.valueOf(1), this.hhI);
        com.tencent.mm.ad.d.c.b(Integer.valueOf(10001), this.ouk);
        com.tencent.mm.ad.d.c.b(Integer.valueOf(10002), this.ouk);
    }

    public void onDataBaseOpened(com.tencent.mm.bx.h hVar, com.tencent.mm.bx.h hVar2) {
        com.tencent.mm.y.p.FW();
        d dVar = this.oui;
        com.tencent.mm.bx.h hVar3 = com.tencent.mm.kernel.g.Dq().gRU;
        com.tencent.mm.bx.h hVar4 = com.tencent.mm.kernel.g.Dq().gRV;
        dVar.ouf = new com.tencent.mm.ax.r(new j(hVar3));
        dVar.oub = new ad(hVar3);
        dVar.ouc = new bg(hVar3);
        dVar.oue = new af(hVar3);
        dVar.oud = new av(hVar3, dVar.oub, dVar.oue);
        dVar.oug = new bd(hVar3);
        dVar.ouh = new ai(hVar3);
    }

    public void onDataBaseClosed(com.tencent.mm.bx.h hVar, com.tencent.mm.bx.h hVar2) {
    }

    public bt getSysCmdMsgExtension() {
        return this.ouk;
    }

    public void setIDataTransferFactoryDelegate(ag agVar) {
        this.oum = agVar;
    }

    public List<com.tencent.mm.y.af> getDataTransferList() {
        if (this.oum == null) {
            return new ArrayList();
        }
        List<com.tencent.mm.y.af> dataTransferList = this.oum.getDataTransferList();
        if (dataTransferList.size() <= 7) {
            return dataTransferList;
        }
        Assert.assertTrue("Do not add more IDataTransfer from mIDataTransferFactoryDelegate!!!!!!!!!!!", false);
        return dataTransferList;
    }
}
