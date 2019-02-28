package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.bf.f;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

public abstract class VoiceInputLayout extends LinearLayout {
    ag jFp = new ag() {
        public final void handleMessage(Message message) {
            if (message.what != 0) {
                if (message.what == 1) {
                    x.w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", Integer.valueOf(VoiceInputLayout.this.vsl));
                } else {
                    return;
                }
            }
            x.d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", Integer.valueOf(VoiceInputLayout.this.vsl));
            if (VoiceInputLayout.this.vsl == 3) {
                VoiceInputLayout.this.jFp.removeMessages(0);
                VoiceInputLayout.this.jFp.removeMessages(1);
                if (VoiceInputLayout.this.vsG != null) {
                    VoiceInputLayout.this.vsG.an(true);
                }
                VoiceInputLayout.this.reset(true);
            }
        }
    };
    private final al kKg = new al(new com.tencent.mm.sdk.platformtools.al.a() {
        public final boolean uG() {
            if (VoiceInputLayout.this.vsG != null) {
                f b = VoiceInputLayout.this.vsG;
                int i = b.iac;
                b.iac = 0;
                if (i > f.fmB) {
                    f.fmB = i;
                }
                int i2 = (i * 100) / f.fmB;
                if (VoiceInputLayout.this.vsl == 2) {
                    VoiceInputLayout.this.Cl(i2);
                }
            }
            return true;
        }
    }, true);
    public b vsF = null;
    private f vsG;
    protected boolean vsH = false;
    int vsI = 3000;
    int vsJ = 10000;
    public a vsK;
    private ag vsL = new ag() {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    VoiceInputLayout voiceInputLayout = VoiceInputLayout.this;
                    x.d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", Integer.valueOf(voiceInputLayout.vsl));
                    if (voiceInputLayout.vsl == 2) {
                        voiceInputLayout.vsl = 3;
                        voiceInputLayout.jFp.removeMessages(0);
                        voiceInputLayout.jFp.sendEmptyMessageDelayed(0, (long) voiceInputLayout.vsI);
                        voiceInputLayout.jFp.sendEmptyMessageDelayed(1, (long) voiceInputLayout.vsJ);
                        voiceInputLayout.cL(false);
                        return;
                    }
                    return;
                case 1:
                    Bundle data = message.getData();
                    VoiceInputLayout.this.af(data.getInt("localCode"), data.getInt("errType"), data.getInt("errCode"));
                    return;
                default:
                    return;
            }
        }
    };
    public int vsl = 1;

    public interface a {
        void cbo();
    }

    public interface b {
        void ag(int i, int i2, int i3);

        void b(String[] strArr, Set<String> set);

        void cbp();

        void cbq();

        void cbr();

        void cbs();

        void cbt();
    }

    public abstract void Cl(int i);

    public abstract void cL(boolean z);

    public abstract void le(boolean z);

    public abstract void onReset();

    public final void ld(boolean z) {
        this.vsH = z;
    }

    @TargetApi(11)
    public VoiceInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public VoiceInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void cbl() {
        if (com.tencent.mm.o.a.aW(getContext()) || com.tencent.mm.o.a.aU(getContext())) {
            x.d("MicroMsg.VoiceInputLayout", "voip is running, cann't record voice");
            onReset();
            return;
        }
        x.d("MicroMsg.VoiceInputLayout", "summerper checkPermission checkMicrophone[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.aZ(getContext(), "android.permission.RECORD_AUDIO")));
        if (com.tencent.mm.pluginsdk.g.a.aZ(getContext(), "android.permission.RECORD_AUDIO")) {
            x.d("MicroMsg.VoiceInputLayout", "doStart currentState = %s", Integer.valueOf(this.vsl));
            if (this.vsl == 1) {
                this.vsl = 2;
                if (this.vsF != null) {
                    this.vsF.cbp();
                }
                this.kKg.K(50, 50);
                le(true);
                this.vsG = new f(new com.tencent.mm.bf.f.b() {
                    public final void Va() {
                        x.d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", Integer.valueOf(VoiceInputLayout.this.vsl));
                        if (VoiceInputLayout.this.kKg != null) {
                            VoiceInputLayout.this.kKg.TN();
                        }
                        VoiceInputLayout.this.vsL.sendEmptyMessage(0);
                    }

                    public final void Ve() {
                        x.d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
                        VoiceInputLayout.this.jFp.removeMessages(0);
                        VoiceInputLayout.this.jFp.removeMessages(1);
                        VoiceInputLayout.this.vsF.cbt();
                        VoiceInputLayout.this.reset(false);
                    }

                    public final void a(String[] strArr, Set<String> set) {
                        VoiceInputLayout.this.vsF.b(strArr, set);
                        VoiceInputLayout.this.jFp.removeMessages(0);
                        VoiceInputLayout.this.jFp.sendEmptyMessageDelayed(0, (long) VoiceInputLayout.this.vsI);
                    }

                    public final void D(int i, int i2, int i3) {
                        VoiceInputLayout.this.jFp.removeMessages(0);
                        VoiceInputLayout.this.jFp.removeMessages(1);
                        Message message = new Message();
                        Bundle bundle = new Bundle();
                        bundle.putInt("localCode", i);
                        bundle.putInt("errType", i2);
                        bundle.putInt("errCode", i3);
                        message.setData(bundle);
                        message.what = 1;
                        VoiceInputLayout.this.vsL.sendMessage(message);
                    }
                });
                f fVar = this.vsG;
                x.i("MicroMsg.SceneVoiceInputAddr", "start record");
                e.b(new a(fVar, (byte) 0), "SceneVoiceInputAddr_record", 10);
            }
        } else if (getContext() instanceof Activity) {
            com.tencent.mm.pluginsdk.g.a.g((Activity) getContext(), "android.permission.RECORD_AUDIO");
        }
    }

    public final void cbm() {
        x.d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", Integer.valueOf(this.vsl));
        if (this.vsl != 1) {
            this.vsl = 1;
            if (this.vsF != null) {
                this.vsF.cbr();
            }
            if (this.vsG != null) {
                this.vsG.an(true);
            }
            onReset();
        }
    }

    public final void bc() {
        x.d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", Integer.valueOf(this.vsl));
        if (this.vsl != 1 && this.vsl == 2) {
            this.vsl = 3;
            if (this.vsF != null) {
                this.vsF.cbq();
            }
            if (this.kKg != null) {
                this.kKg.TN();
            }
            this.jFp.removeMessages(0);
            this.jFp.sendEmptyMessageDelayed(0, (long) this.vsI);
            this.jFp.sendEmptyMessageDelayed(1, (long) this.vsJ);
            cL(true);
            if (this.vsG != null) {
                this.vsG.aN(true);
            }
        }
    }

    public final void cbn() {
        af(12, -1, -1);
    }

    public final void af(int i, int i2, int i3) {
        x.d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.vsl = 1;
        onReset();
        if (this.vsF != null) {
            this.vsF.ag(i, i2, i3);
        }
    }

    public final void reset(boolean z) {
        x.d("MicroMsg.VoiceInputLayout", "reset currentState %s", Integer.valueOf(this.vsl));
        if (this.vsl != 1) {
            this.vsl = 1;
            onReset();
            if (z && this.vsF != null) {
                this.vsF.cbs();
            }
        }
    }
}
