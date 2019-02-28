package com.tencent.mm.pluginsdk.ui.websearch;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.f.a.sl;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.wcdb.FileUtils;
import java.util.HashSet;
import java.util.Set;

public final class a extends LinearLayout {
    private String flQ = "";
    AudioManager gDM;
    private Context mContext;
    private TelephonyManager nHI;
    PhoneStateListener nHJ = new PhoneStateListener() {
        public final void onCallStateChanged(int i, String str) {
            super.onCallStateChanged(i, str);
            int i2 = -1;
            if (a.this.vyB != null) {
                i2 = a.this.vyB.vsl;
            }
            x.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", Integer.valueOf(i), Integer.valueOf(i2));
            if (i2 == 2) {
                a.this.pause();
            }
        }
    };
    private Button oqb;
    public a vGg;
    private com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a vsK = new com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a() {
        public final void cbo() {
            a.a(a.this, R.l.eTM);
        }
    };
    private boolean vsP = false;
    private MMEditText vsV;
    public int vvZ = com.tencent.mm.bu.a.fromDPToPix(getContext(), 280);
    private VoiceInputLayout vyB;
    private ImageButton vyC;
    private Button vyD;
    private VoiceInputScrollView vyG;
    private TextView vyH;
    private long vyI = 0;
    private float vyK = 0.0f;
    private float vyL = 0.0f;
    private boolean vyM = false;
    private boolean vyN = false;
    private boolean vyO = false;
    private int vyP = 300;
    private boolean vyR = false;
    private boolean vyS = false;
    private long vyT = 0;
    private long vyU = 0;
    private long vyV = 0;
    private boolean vyW = false;
    private boolean vyX = false;
    private final int vyY = 2;
    private boolean vyZ = false;
    private Toast vzb;
    private Set<String> vzc = new HashSet();
    private c<sl> vze;
    private b vzg = new b() {
        public final void cbp() {
            a.this.vyT = System.currentTimeMillis();
            x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", Long.valueOf(a.this.vyT));
            x.d("VOICEDEBUG", "Start Record Time = %s", Long.valueOf(a.this.vyT));
            a.this.vyR = false;
            a.this.vyS = true;
            a.this.vyZ = true;
            a.this.vyU = 0;
            a.this.vyV = 0;
            a.this.ccR();
            a.this.vyH.setVisibility(8);
            a.this.vyS = false;
            a aVar = a.this;
            if (aVar.gDM != null) {
                aVar.gDM.setStreamMute(3, true);
            }
            if (a.this.mContext instanceof Activity) {
                ((Activity) a.this.mContext).getWindow().addFlags(FileUtils.S_IWUSR);
            }
            a.this.oqb.setVisibility(4);
            a.this.vyC.setVisibility(4);
            a.this.vyD.setVisibility(8);
            a.this.vsV.setHint(a.this.getResources().getString(R.l.eTK));
            a.this.vGg.kF(true);
        }

        public final void cbq() {
            a.this.vGg.kF(false);
            a.this.vsV.setHint(null);
        }

        public final void cbr() {
            x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
            a.this.ccR();
            if (a.this.mContext instanceof Activity) {
                ((Activity) a.this.mContext).getWindow().clearFlags(FileUtils.S_IWUSR);
            }
            a.this.vGg.kF(false);
            a.this.vsV.setHint(null);
            a.b(a.this, 2);
        }

        public final void cbs() {
            x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", Long.valueOf(System.currentTimeMillis()));
            a.this.ccR();
            if (a.this.mContext instanceof Activity) {
                ((Activity) a.this.mContext).getWindow().clearFlags(FileUtils.S_IWUSR);
            }
            a.this.vGg.kF(false);
            a.this.vsV.setHint(null);
        }

        public final void cbt() {
            x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", Long.valueOf(System.currentTimeMillis()));
            a.this.ccR();
            if (a.this.mContext instanceof Activity) {
                ((Activity) a.this.mContext).getWindow().clearFlags(FileUtils.S_IWUSR);
            }
            a.this.vGg.kF(false);
            a.this.vsV.setHint(null);
            a.b(a.this, 2);
        }

        public final void b(String[] strArr, Set<String> set) {
            if (strArr != null && strArr.length > 0 && strArr[0].length() > 0) {
                if (a.this.vyZ) {
                    a.this.vyZ = false;
                }
                x.i("MicroMsg.VoiceInputPanel", "onDetected %s", strArr[0]);
                a.this.vsV.setText(strArr[0]);
                if (!(a.this.vyR || strArr[0].length() == 0)) {
                    a.this.vyR = true;
                    a.this.vyU = System.currentTimeMillis();
                    x.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", Long.valueOf(System.currentTimeMillis()), Long.valueOf(a.this.vyU - a.this.vyT));
                }
                a.this.vzc.addAll(set);
            }
        }

        public final void ag(int i, int i2, int i3) {
            x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
            a.this.ccR();
            if (a.this.mContext instanceof Activity) {
                ((Activity) a.this.mContext).getWindow().clearFlags(FileUtils.S_IWUSR);
            }
            if (i == 12) {
                a.a(a.this, R.l.eTL);
            } else {
                a.a(a.this, R.l.dFa);
            }
            a.this.vGg.kF(false);
            a.this.vsV.setHint(null);
        }
    };
    public boolean vzh = true;

    public interface a {
        void Qb(String str);

        void bUM();

        void kF(boolean z);
    }

    static /* synthetic */ void a(a aVar) {
        x.d("MicroMsg.VoiceInputPanel", "closePanel");
        if (aVar.vGg != null) {
            aVar.vyW = true;
            x.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
            VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
            if (aVar.vsV == null || aVar.vsV.getText() == null || aVar.vsV.getText().length() <= 0) {
                if (aVar.vyW) {
                    voiceInputBehavior.cancel = 2;
                } else {
                    voiceInputBehavior.cancel = 15;
                }
            } else if (aVar.vyW) {
                voiceInputBehavior.cancel = 14;
            } else {
                voiceInputBehavior.cancel = 16;
            }
            if (aVar.vyI != 0) {
                voiceInputBehavior.voiceInputTime = bi.bB(aVar.vyI);
                aVar.vyI = 0;
            }
            aVar.vGg.bUM();
        }
    }

    static /* synthetic */ void a(a aVar, int i) {
        if (aVar.vzb != null) {
            aVar.vzb.cancel();
        }
        aVar.vzb = Toast.makeText(aVar.mContext, aVar.mContext.getResources().getString(i), 0);
        aVar.vzb.setGravity(17, 0, 0);
        aVar.vzb.show();
    }

    static /* synthetic */ void b(a aVar, int i) {
        x.d("MicroMsg.VoiceInputPanel", "sendMsg");
        if (aVar.vsV != null && aVar.vsV.getText() != null) {
            String obj = aVar.vsV.getText().toString();
            if ((obj.trim().length() != 0 || obj.length() != 0) && aVar.vGg != null) {
                VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                voiceInputBehavior.send = 1;
                if (aVar.vyX) {
                    voiceInputBehavior.send = 2;
                }
                if (i != 1 && i == 4) {
                    voiceInputBehavior.send = 4;
                }
                x.i("MicroMsg.VoiceInputPanel", "sendMsg onSendMsg");
                aVar.vGg.Qb(obj);
            }
        }
    }

    public a(Context context) {
        super(context);
        this.mContext = context;
        x.d("MicroMsg.VoiceInputPanel", "init");
        View.inflate(getContext(), R.i.duk, this);
        this.vyC = (ImageButton) findViewById(R.h.cWy);
        this.vyD = (Button) findViewById(R.h.cWx);
        this.oqb = (Button) findViewById(R.h.cWB);
        this.vyH = (TextView) findViewById(R.h.cPz);
        this.vyC.setVisibility(0);
        this.oqb.setVisibility(4);
        this.vyD.setVisibility(8);
        this.vsV = (MMEditText) findViewById(R.h.cWC);
        this.vsV.setHintTextColor(getResources().getColor(R.e.bts));
        this.vsV.setClickable(false);
        this.vyG = (VoiceInputScrollView) findViewById(R.h.cWA);
        this.vyC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                a.a(a.this);
            }
        });
        this.vsV.clearFocus();
        this.vsV.setFocusable(false);
        this.vsV.setClickable(false);
        this.vsV.setLongClickable(false);
        this.gDM = (AudioManager) getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
        this.flQ = String.valueOf(System.nanoTime());
        x.i("MicroMsg.VoiceInputPanel", "mToUser %s", this.flQ);
        ccP();
    }

    public final void ccP() {
        this.vyI = bi.Wz();
        if (this.vze == null) {
            x.i("MicroMsg.VoiceInputPanel", " initVoiceResultListener");
            this.vze = new c<sl>() {
                {
                    this.xmG = sl.class.getName().hashCode();
                }

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    sl slVar = (sl) bVar;
                    if (!(slVar instanceof sl)) {
                        x.d("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent mismatched event");
                        return false;
                    } else if (slVar == null || slVar.fKX == null) {
                        x.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent event data is null");
                        return false;
                    } else if (slVar.fKX.fKZ.equalsIgnoreCase(a.this.flQ)) {
                        x.i("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent action = %s, textChange: %b", Integer.valueOf(slVar.fKX.action), Integer.valueOf(slVar.fKX.fKY));
                        if (slVar.fKX.action == 2) {
                            if (slVar.fKX.fKY == 1) {
                                a.this.vyX = true;
                            } else {
                                a.this.vyX = false;
                            }
                            a.this.vsV.setText(slVar.fKX.result);
                            a.this.ccR();
                        } else if (slVar.fKX.action == 3) {
                            if (a.this.vGg != null) {
                                a.this.vGg.bUM();
                            }
                        } else if (slVar.fKX.action == 1 || slVar.fKX.action == 4) {
                            if (slVar.fKX.fKY == 1) {
                                a.this.vyX = true;
                            } else {
                                a.this.vyX = false;
                            }
                            a.this.vsV.setText(slVar.fKX.result);
                            a.this.ccR();
                            a.b(a.this, slVar.fKX.action);
                        } else {
                            a.this.reset();
                        }
                        return true;
                    } else {
                        x.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent userCode not equals!");
                        a.this.destroy();
                        return false;
                    }
                }
            };
            com.tencent.mm.sdk.b.a.xmy.b(this.vze);
        }
        if (this.vyB == null) {
            this.vyB = (VoiceInputLayout) findViewById(R.h.cWD);
            this.vyB.vsF = this.vzg;
            this.vyB.vsK = this.vsK;
        }
        this.vyH.setVisibility(0);
        this.nHI = (TelephonyManager) ad.getContext().getSystemService("phone");
        this.nHI.listen(this.nHJ, 32);
    }

    public final void pause() {
        x.i("MicroMsg.VoiceInputPanel", "pause");
        if (this.vyB != null) {
            this.vyB.cbm();
        }
        this.vyK = 0.0f;
        this.vyL = 0.0f;
        this.vyM = false;
        this.vyN = false;
        this.vsP = false;
        this.vyO = false;
        this.vyW = false;
        this.vzh = true;
    }

    public final void reset() {
        x.i("MicroMsg.VoiceInputPanel", "VoiceInputPanel reset");
        pause();
        this.vyX = false;
        this.vzc.clear();
        if (this.vsV != null) {
            this.vsV.setText("");
            ccR();
        }
    }

    public final void destroy() {
        x.i("MicroMsg.VoiceInputPanel", "destroy");
        reset();
        if (this.vze != null) {
            com.tencent.mm.sdk.b.a.xmy.c(this.vze);
            this.vze = null;
        }
        if (this.vyB != null) {
            this.vyB.vsF = null;
            this.vyB = null;
        }
        if (!(this.nHI == null || this.nHJ == null)) {
            this.nHI.listen(this.nHJ, 0);
            this.nHJ = null;
        }
        this.nHI = null;
    }

    public final void ccR() {
        x.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
        if (this.vsV == null || this.vsV.getText() == null || this.vsV.getText().length() != 0) {
            this.vyC.setVisibility(4);
            this.vyH.setVisibility(8);
        } else {
            this.oqb.setVisibility(4);
            this.vyC.setVisibility(0);
            this.vyD.setVisibility(8);
            this.vyH.setVisibility(0);
        }
        if (this.gDM != null) {
            this.gDM.setStreamMute(3, false);
        }
        if (!this.vyS) {
            this.vyS = true;
            this.vyV = System.currentTimeMillis();
            x.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", Long.valueOf(this.vyV), Long.valueOf(this.vyV - this.vyU));
        }
    }
}
