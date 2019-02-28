package com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b;

import com.tencent.mm.audio.voicejoint.model.VoiceJointResult;
import com.tencent.mm.audio.voicejoint.model.VoiceSplitResult;
import com.tencent.mm.audio.voicejoint.model.c;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

public enum e {
    ;
    
    private ah jzr;
    private int mTaskId;

    private abstract class a implements Runnable {
        private String jzA;
        private int taskId;

        public a(String str, int i) {
            this.jzA = str;
            this.taskId = i;
        }

        public void execute() {
        }

        public void run() {
            x.i("MicroMsg.VoiceSplitJointHelper", "alvinluo task: %s, id: %d start run", this.jzA, Integer.valueOf(this.taskId));
            execute();
            x.i("MicroMsg.VoiceSplitJointHelper", "alvinluo task: %s, id: %d end", this.jzA, Integer.valueOf(this.taskId));
        }
    }

    private e(String str) {
        this.jzr = new ah("VoiceSplitJointHandlerThread");
        this.mTaskId = 1;
    }

    public final synchronized void a(c cVar, VoiceSplitResult voiceSplitResult, com.tencent.mm.plugin.appbrand.jsapi.voicejoint.c cVar2) {
        if (this.jzr != null) {
            int i = this.mTaskId;
            this.mTaskId = i + 1;
            x.i("MicroMsg.VoiceSplitJointHelper", "alvinluo VoiceSplitJointHelper add task task id : %d", Integer.valueOf(i));
            final com.tencent.mm.plugin.appbrand.jsapi.voicejoint.c cVar3 = cVar2;
            final c cVar4 = cVar;
            final VoiceSplitResult voiceSplitResult2 = voiceSplitResult;
            this.jzr.F(new a("splitJointVoice", i) {
                public final void execute() {
                    x.i("MicroMsg.VoiceSplitJointHelper", "alvinluo splitJointVoice initSplitModel result: %d", Integer.valueOf(b.M(100, com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.lc(100))));
                    if (b.M(100, com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.lc(100)) == 0) {
                        if (cVar3 != null) {
                            cVar3.ahQ();
                        }
                        VoiceJointResult a = b.a(cVar4, voiceSplitResult2);
                        if (cVar3 != null) {
                            cVar3.a(a);
                        }
                        b.kO(100);
                        if (cVar3 != null) {
                            cVar3.onRelease();
                        }
                    } else if (cVar3 != null) {
                        cVar3.tm("init failed");
                    }
                }
            });
        }
    }

    public final synchronized void a(int i, String str, com.tencent.mm.plugin.appbrand.jsapi.voicejoint.c cVar) {
        if (this.jzr != null) {
            int i2 = this.mTaskId;
            this.mTaskId = i2 + 1;
            x.i("MicroMsg.VoiceSplitJointHelper", "alvinluo VoiceSplitJointHelper add task task id : %d", Integer.valueOf(i2));
            final int i3 = i;
            final String str2 = str;
            final com.tencent.mm.plugin.appbrand.jsapi.voicejoint.c cVar2 = cVar;
            this.jzr.F(new a("checkInitModel", i2) {
                public final void execute() {
                    if (b.N(i3, str2) != 0) {
                        x.e("MicroMsg.VoiceSplitJointHelper", "alvinluo initSplitModel failed");
                        if (cVar2 != null) {
                            cVar2.tm("init failed");
                        }
                    } else if (cVar2 != null) {
                        cVar2.ahQ();
                    }
                }
            });
        }
    }

    public final synchronized void tp(final String str) {
        if (this.jzr != null) {
            int i = this.mTaskId;
            this.mTaskId = i + 1;
            x.i("MicroMsg.VoiceSplitJointHelper", "alvinluo VoiceSplitJointHelper add task task id : %d", Integer.valueOf(i));
            this.jzr.F(new a("checkVoiceBlack", i) {
                public final void execute() {
                    c cVar = c.jzg;
                    String str = str;
                    x.i("MicroMsg.VoiceBlackCheckMAnager", "alvinluo checkVoiceBlack userKey: %s", str);
                    if (cVar.jzh == null) {
                        x.e("MicroMsg.VoiceBlackCheckMAnager", "alvinluo VoiceCheckBlackImpl not init");
                    } else if (cVar.jzh.ahS()) {
                        cVar.jzh.a(str, cVar.jzh.to(str));
                    } else {
                        x.e("MicroMsg.VoiceBlackCheckMAnager", "alvinluo onBeforeCheck failed");
                    }
                }
            });
        }
    }
}
