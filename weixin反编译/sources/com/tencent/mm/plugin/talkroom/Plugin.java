package com.tencent.mm.plugin.talkroom;

import com.tencent.mm.f.a.ja;
import com.tencent.mm.f.a.rj;
import com.tencent.mm.f.a.rk;
import com.tencent.mm.f.a.rm;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;

public class Plugin implements com.tencent.mm.pluginsdk.c.c {

    private class a extends com.tencent.mm.sdk.b.c<rj> {
        private a() {
            this.xmG = rj.class.getName().hashCode();
        }

        /* synthetic */ a(Plugin plugin, byte b) {
            this();
            this.xmG = rj.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            rj rjVar = (rj) bVar;
            if (!(rjVar instanceof rj)) {
                x.f("MicroMsg.TalkRoomReportMgrListener", "mismatch %s", rjVar.getClass().getName());
            } else if (rjVar.fJV.fJW) {
                com.tencent.mm.plugin.talkroom.model.b.bFp().shz = 1;
                return true;
            }
            return false;
        }
    }

    private static class b extends com.tencent.mm.sdk.b.c<rk> {
        private b() {
            this.xmG = rk.class.getName().hashCode();
        }

        /* synthetic */ b(byte b) {
            this();
            this.xmG = rk.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            rk rkVar = (rk) bVar;
            if (rkVar != null) {
                if (!(rkVar instanceof rk)) {
                    x.f("MicroMsg.TalkRoomServerListener", "mismatch %s", rkVar.getClass().getName());
                } else if (rkVar.fJX.fKa) {
                    com.tencent.mm.plugin.talkroom.model.b.bFm().aWG();
                    return true;
                } else if (!(!rkVar.fJX.fJZ || rkVar.fJY == null || com.tencent.mm.plugin.talkroom.model.b.bFm() == null)) {
                    rkVar.fJY.fKb = com.tencent.mm.plugin.talkroom.model.b.bFm().shV;
                    return true;
                }
            }
            return false;
        }
    }

    private class c extends com.tencent.mm.sdk.b.c<rm> {
        private c() {
            this.xmG = rm.class.getName().hashCode();
        }

        /* synthetic */ c(Plugin plugin, byte b) {
            this();
            this.xmG = rm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (!(((rm) bVar) instanceof rm)) {
                x.f("MicroMsg.TalkRoom.Plugin", "mismatch %s", ((rm) bVar).getClass().getName());
            }
            return false;
        }
    }

    public Plugin() {
        com.tencent.mm.sdk.b.a.xmy.b(new com.tencent.mm.sdk.b.c<ja>() {
            {
                this.xmG = ja.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                switch (((ja) bVar).fAx.status) {
                    case 0:
                        if (com.tencent.mm.plugin.talkroom.model.b.bFm() != null) {
                            com.tencent.mm.plugin.talkroom.model.b.bFm().aWG();
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        com.tencent.mm.sdk.b.a.xmy.b(new b());
        com.tencent.mm.sdk.b.a.xmy.b(new a());
        com.tencent.mm.sdk.b.a.xmy.b(new c());
    }

    public p createApplication() {
        return new a();
    }

    public com.tencent.mm.pluginsdk.c.b getContactWidgetFactory() {
        return null;
    }

    public ap createSubCore() {
        return new com.tencent.mm.plugin.talkroom.model.b();
    }
}
