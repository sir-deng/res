package com.tencent.mm.pluginsdk.ui.chat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.f.a.sl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.VoiceInputScrollView;
import com.tencent.mm.pluginsdk.ui.VoiceInputUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.as;
import com.tencent.wcdb.FileUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class n extends LinearLayout {
    String flQ = "";
    private Context mContext;
    private TelephonyManager nHI;
    PhoneStateListener nHJ;
    private Button oqb;
    private com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a vsK = new com.tencent.mm.pluginsdk.ui.VoiceInputLayout.a() {
        public final void cbo() {
            n.b(n.this, R.l.eTM);
        }
    };
    private boolean vsP = false;
    private MMEditText vsV;
    private int vvZ = com.tencent.mm.bu.a.fromDPToPix(getContext(), com.tencent.mm.plugin.appbrand.game.d.a.CTRL_INDEX);
    private i vwM;
    private VoiceInputLayout vyB;
    private ImageButton vyC;
    private Button vyD;
    public a vyE;
    private MMEditText vyF = null;
    private VoiceInputScrollView vyG;
    private TextView vyH;
    private long vyI = 0;
    private boolean vyJ = false;
    private float vyK = 0.0f;
    private float vyL = 0.0f;
    private boolean vyM = false;
    private boolean vyN = false;
    private boolean vyO = false;
    private int vyP = 300;
    private final String vyQ = "voiceinput_downdistance_content";
    private boolean vyR = false;
    private boolean vyS = false;
    private long vyT = 0;
    private long vyU = 0;
    private long vyV = 0;
    private boolean vyW = false;
    private boolean vyX = false;
    private final int vyY = 2;
    private boolean vyZ = false;
    public String vza = "";
    private Toast vzb;
    private Set<String> vzc = new HashSet();
    private com.tencent.mm.pluginsdk.ui.n vzd;
    private c<sl> vze;
    private com.tencent.mm.bf.b.b vzf;
    private com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b vzg = new com.tencent.mm.pluginsdk.ui.VoiceInputLayout.b() {
        public final void cbp() {
            n.this.vyT = System.currentTimeMillis();
            x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectStart time %s", Long.valueOf(n.this.vyT));
            x.d("VOICEDEBUG", "Start Record Time = %s", Long.valueOf(n.this.vyT));
            n.this.vyR = false;
            n.this.vyS = true;
            n.this.vyZ = true;
            n.this.vyU = 0;
            n.this.vyV = 0;
            n.this.ccR();
            n.this.vyH.setVisibility(8);
            n.this.vyS = false;
            n.this.vzd.vsE = 3;
            n.this.vzd.b(n.this.vsV);
            n.ccS();
            if (n.this.vsV != null) {
                if (n.this.vsV.getText() != null && n.this.vsV.getText().length() > 0) {
                    n.this.vsV.setCursorVisible(true);
                }
                n.this.vsV.requestFocus();
                bi.hideVKB(n.this.vyB);
            }
            if (n.this.mContext instanceof Activity) {
                ((Activity) n.this.mContext).getWindow().addFlags(FileUtils.S_IWUSR);
            }
            n.this.oqb.setVisibility(4);
            n.this.vyC.setVisibility(4);
            n.this.vyD.setVisibility(8);
            n.this.vsV.setHint(n.this.getResources().getString(R.l.eTK));
            n.this.vyE.kF(true);
        }

        public final void cbq() {
            n.this.vyE.kF(false);
            n.this.vsV.setHint(null);
        }

        public final void cbr() {
            x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectCancel time " + System.currentTimeMillis());
            n.s(n.this);
            n.this.vzd.a(n.this.vsV);
            n.this.ccR();
            if (n.this.mContext instanceof Activity) {
                ((Activity) n.this.mContext).getWindow().clearFlags(FileUtils.S_IWUSR);
            }
            n.CK(2);
            n.this.vyE.kF(false);
            n.this.vsV.setHint(null);
        }

        public final void cbs() {
            x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onStateReset time %s", Long.valueOf(System.currentTimeMillis()));
            n.this.vzd.a(n.this.vsV);
            n.this.ccR();
            if (n.this.mContext instanceof Activity) {
                ((Activity) n.this.mContext).getWindow().clearFlags(FileUtils.S_IWUSR);
            }
            n.CK(3);
            n.this.vyE.kF(false);
            n.this.vsV.setHint(null);
        }

        public final void cbt() {
            x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectFinish  time %s", Long.valueOf(System.currentTimeMillis()));
            n.s(n.this);
            n.this.vzd.a(n.this.vsV);
            n.this.ccR();
            if (n.this.mContext instanceof Activity) {
                ((Activity) n.this.mContext).getWindow().clearFlags(FileUtils.S_IWUSR);
            }
            n.c(n.this, 1);
            n.this.vyE.kF(false);
            n.this.vsV.setHint(null);
        }

        public final void b(String[] strArr, Set<String> set) {
            if (strArr != null && strArr.length > 0 && strArr[0].length() > 0) {
                if (n.this.vyZ) {
                    n.this.vyZ = false;
                    n.u(n.this);
                }
                n.this.vzd.a(n.this.vsV, strArr[0], true);
                if (n.this.vsV.getText().length() != 0) {
                    n.this.vsV.setCursorVisible(true);
                    n.this.vsV.requestFocus();
                    bi.hideVKB(n.this.vyB);
                }
                if (!(n.this.vyR || strArr[0].length() == 0)) {
                    n.this.vyR = true;
                    n.this.vyU = System.currentTimeMillis();
                    x.d("VOICEDEBUG", "First Text Time = %s Corss Time = %s", Long.valueOf(System.currentTimeMillis()), Long.valueOf(n.this.vyU - n.this.vyT));
                }
                n.this.vzc.addAll(set);
            }
        }

        public final void ag(int i, int i2, int i3) {
            x.i("MicroMsg.VoiceInputPanel", "VoiceDetectListener onDetectError localerrorType = %s errorType = %s errCode = %s time %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis()));
            n.s(n.this);
            n.this.vzd.a(n.this.vsV);
            n.this.ccR();
            if (n.this.mContext instanceof Activity) {
                ((Activity) n.this.mContext).getWindow().clearFlags(FileUtils.S_IWUSR);
            }
            n.c(n.this, i);
            if (i == 12) {
                n.b(n.this, R.l.eTL);
            } else {
                n.b(n.this, R.l.dFa);
            }
            n.this.vyE.kF(false);
            n.this.vsV.setHint(null);
        }
    };
    private boolean vzh = true;

    public interface a {
        void Qb(String str);

        void bUM();

        void kF(boolean z);
    }

    private class b extends PhoneStateListener {
        private b() {
        }

        /* synthetic */ b(n nVar, byte b) {
            this();
        }

        public final void onCallStateChanged(int i, String str) {
            super.onCallStateChanged(i, str);
            int i2 = -1;
            if (n.this.vyB != null) {
                i2 = n.this.vyB.vsl;
            }
            x.d("MicroMsg.VoiceInputPanel", "onCallStateChanged :%s, currentState: %s", Integer.valueOf(i), Integer.valueOf(i2));
            if (i2 == 2) {
                n.this.pause();
            }
        }
    }

    static /* synthetic */ void a(n nVar, int i) {
        x.d("MicroMsg.VoiceInputPanel", "sendMsg");
        if (nVar.vsV != null && nVar.vsV.getText() != null) {
            String obj = nVar.vsV.getText().toString();
            if (obj.trim().length() == 0 && obj.length() == 0) {
                if (nVar.vwM == null || !nVar.vwM.isShowing()) {
                    nVar.vwM = h.h(nVar.getContext(), R.l.dQY, R.l.dGZ);
                }
            } else if (nVar.vyE != null) {
                if (!nVar.vyJ) {
                    VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                    voiceInputBehavior.send = 1;
                    if (nVar.vyX) {
                        voiceInputBehavior.send = 2;
                    }
                    if (i != 1) {
                        if (i == 4) {
                            voiceInputBehavior.send = 4;
                        }
                        a(voiceInputBehavior);
                        x.i("MicroMsg.VoiceInputPanel", "cgiReport size = %s", Integer.valueOf(nVar.vzc.size()));
                        if (nVar.vzf == null) {
                            nVar.vzf = new com.tencent.mm.bf.b.b();
                        }
                        com.tencent.mm.storage.c fp = com.tencent.mm.y.c.c.IL().fp("100235");
                        x.i("MicroMsg.VoiceInputPanel", "cgiReport: abTestFlag = [%s]", Integer.valueOf(fp.isValid() ? bi.getInt((String) fp.civ().get("MMVoipVadOn"), 0) : 0));
                        com.tencent.mm.bf.b.b bVar = nVar.vzf;
                        Collection collection = nVar.vzc;
                        String valueOf = String.valueOf(r0);
                        Set hashSet = new HashSet();
                        hashSet.addAll(collection);
                        g.Dt().F(new com.tencent.mm.bf.b.b.AnonymousClass1(hashSet, obj, valueOf));
                        nVar.vzc.clear();
                    }
                }
                x.i("MicroMsg.VoiceInputPanel", "sendMsg onSendMsg");
                nVar.vyE.Qb(obj);
            }
        } else if (nVar.vwM == null || !nVar.vwM.isShowing()) {
            nVar.vwM = h.h(nVar.getContext(), R.l.dQY, R.l.dGZ);
        }
    }

    static /* synthetic */ boolean a(n nVar, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (nVar.vyG.getScrollY() <= 0) {
                nVar.vyN = true;
                nVar.vyK = motionEvent.getRawY();
            }
            nVar.vyO = true;
        } else if (motionEvent.getAction() == 2) {
            nVar.vyM = true;
        } else if (motionEvent.getAction() == 1) {
            float f;
            if (nVar.vyM && nVar.vyN) {
                nVar.vyL = motionEvent.getRawY();
                f = nVar.vyL - nVar.vyK;
            } else {
                f = 0.0f;
            }
            nVar.vyO = false;
            nVar.vyM = false;
            nVar.vyN = false;
            nVar.vyL = 0.0f;
            nVar.vyK = 0.0f;
            if (f > ((float) nVar.vyP)) {
                if (!(nVar.vsV == null || nVar.vsV.getText() == null || nVar.vsV.getText().length() <= 0)) {
                    SharedPreferences cgg = ad.cgg();
                    if (cgg != null) {
                        cgg.edit().putString("voiceinput_downdistance_content", nVar.vsV.getText().toString()).apply();
                        x.d("MicroMsg.VoiceInputPanel", "onDownDistance save memory content");
                    }
                }
                nVar.ccQ();
            } else if (nVar.vsP) {
                nVar.vsP = false;
            } else if ((view instanceof MMEditText) && nVar.vsV != null && nVar.vsV.getText() != null && nVar.vsV.getText().length() > 0) {
                Spannable newSpannable = Factory.getInstance().newSpannable(((MMEditText) view).getText());
                MMEditText mMEditText = (MMEditText) view;
                motionEvent.getAction();
                int x = (((int) motionEvent.getX()) - mMEditText.getTotalPaddingLeft()) + mMEditText.getScrollX();
                int y = (((int) motionEvent.getY()) - mMEditText.getTotalPaddingTop()) + mMEditText.getScrollY();
                Layout layout = mMEditText.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) newSpannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    clickableSpanArr[0].onClick(view);
                } else {
                    x.i("MicroMsg.VoiceInputPanel", "startVoiceInputUIActivity offset = %s", Integer.valueOf(((MMEditText) view).getOffsetForPosition(motionEvent.getX(), motionEvent.getY())));
                    if (nVar.vyB != null) {
                        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                        voiceInputBehavior.textClick = nVar.vyB.vsl;
                        a(voiceInputBehavior);
                    }
                    Intent intent = new Intent();
                    intent.setClass(nVar.getContext(), VoiceInputUI.class);
                    intent.putExtra("offset", offsetForHorizontal);
                    intent.putExtra("userCode", nVar.flQ);
                    if (!(nVar.vsV == null || nVar.vsV.getText() == null)) {
                        intent.putExtra("text", nVar.vsV.getText().toString());
                        if (nVar.vzd != null) {
                            nVar.vzd.b(nVar.vsV);
                        }
                    }
                    if (nVar.vza.equalsIgnoreCase("。") || nVar.vza.equalsIgnoreCase(".")) {
                        intent.putExtra("punctuation", nVar.vza);
                    }
                    nVar.getContext().startActivity(intent);
                    if (nVar.vyB != null) {
                        bi.hideVKB(nVar.vyB);
                        nVar.vyB.cbm();
                    }
                }
            }
            return view instanceof MMEditText;
        }
        return view instanceof MMEditText;
    }

    static /* synthetic */ void b(n nVar, int i) {
        if (nVar.vzb != null) {
            nVar.vzb.cancel();
        }
        nVar.vzb = Toast.makeText(nVar.mContext, nVar.mContext.getResources().getString(i), 0);
        nVar.vzb.setGravity(17, 0, 0);
        nVar.vzb.show();
    }

    static /* synthetic */ void c(n nVar, int i) {
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        voiceInputBehavior.fail = i;
        a(voiceInputBehavior);
        CK(i);
    }

    static /* synthetic */ void ccS() {
        x.i("MicroMsg.VoiceInputPanel", "pauseMusic");
        as.Hn().xZ();
    }

    static /* synthetic */ void s(n nVar) {
        if (nVar.vsV != null && nVar.vsV.getText() != null) {
            String obj = nVar.vsV.getText().toString();
            if (obj.length() <= 0) {
                return;
            }
            if (!nVar.vyJ || nVar.vsV.getSelectionStart() >= obj.length()) {
                nVar.vza = obj.substring(obj.length() - 1, obj.length());
                x.i("MicroMsg.VoiceInputPanel", "delPunctuation msg = %s ,msg.length() = %s, punctuation = %s", bi.Wz(obj), Integer.valueOf(obj.length()), nVar.vza);
                if (nVar.vza.equalsIgnoreCase("。") || nVar.vza.equalsIgnoreCase(".")) {
                    nVar.vsV.setText(obj.substring(0, obj.length() - 1));
                }
            }
        }
    }

    static /* synthetic */ void u(n nVar) {
        if (nVar.vsV != null && nVar.vsV.getText() != null && nVar.vsV.getText().length() > 0) {
            if (nVar.vza.equalsIgnoreCase("。") || nVar.vza.equalsIgnoreCase(".")) {
                if (!nVar.vyJ || nVar.vsV.getSelectionStart() >= nVar.vsV.getText().length()) {
                    nVar.vzd.a(nVar.vsV, nVar.vza, true);
                    nVar.vzd.b(nVar.vsV);
                }
                nVar.vza = "";
            }
            String obj = nVar.vsV.getText().toString();
            x.i("MicroMsg.VoiceInputPanel", "addPunctuation msg = %s,msg.length() = %s", bi.Wz(obj), Integer.valueOf(obj.length()));
        }
    }

    public n(Context context, boolean z, MMEditText mMEditText) {
        super(context);
        this.mContext = context;
        this.vyJ = z;
        this.vyF = mMEditText;
        init();
        this.vzd = new com.tencent.mm.pluginsdk.ui.n(this.mContext);
        this.flQ = String.valueOf(System.nanoTime());
        x.i("MicroMsg.VoiceInputPanel", "mToUser %s", this.flQ);
        ccP();
    }

    @TargetApi(16)
    private void init() {
        x.d("MicroMsg.VoiceInputPanel", "init");
        View.inflate(getContext(), R.i.dtJ, this);
        this.vyC = (ImageButton) findViewById(R.h.cWy);
        this.vyD = (Button) findViewById(R.h.cWx);
        this.oqb = (Button) findViewById(R.h.cWB);
        this.vyH = (TextView) findViewById(R.h.cPz);
        if (this.vyJ) {
            this.vyC.setVisibility(4);
        } else {
            this.vyC.setVisibility(0);
        }
        this.oqb.setVisibility(4);
        this.vyD.setVisibility(8);
        if (!this.vyJ || this.vyF == null) {
            this.vsV = (MMEditText) findViewById(R.h.cWC);
            this.vsV.setHintTextColor(getResources().getColor(R.e.bts));
            this.vsV.setClickable(true);
            this.vsV.setOnLongClickListener(new OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    if (n.this.vyO) {
                        n.this.vsP = true;
                    }
                    return true;
                }
            });
            this.vsV.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return n.a(n.this, view, motionEvent);
                }
            });
        } else {
            this.vsV = this.vyF;
        }
        this.vyG = (VoiceInputScrollView) findViewById(R.h.cWA);
        this.vyC.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                n.this.ccQ();
            }
        });
        this.oqb.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                n.a(n.this, 2);
            }
        });
        this.vyD.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                n.this.reset();
                VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                voiceInputBehavior.clear = 1;
                n.a(voiceInputBehavior);
            }
        });
        this.vyG.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return n.a(n.this, view, motionEvent);
            }
        });
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
                    } else if (n.this.vyJ) {
                        x.i("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent fromFullScreen true");
                        return false;
                    } else if (slVar.fKX.fKZ.equalsIgnoreCase(n.this.flQ)) {
                        x.i("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent action = %s, textChange: %b", Integer.valueOf(slVar.fKX.action), Integer.valueOf(slVar.fKX.fKY));
                        if (slVar.fKX.action == 2) {
                            if (slVar.fKX.fKY == 1) {
                                n.this.vyX = true;
                            } else {
                                n.this.vyX = false;
                            }
                            n.this.vzd.a(n.this.vsV, slVar.fKX.result, false);
                            n.this.vzd.a(n.this.vsV);
                            n.this.vzd.b(n.this.vsV);
                            n.this.ccR();
                            n.this.vyG.fullScroll(130);
                        } else if (slVar.fKX.action == 3) {
                            if (n.this.vyE != null) {
                                n.this.vyE.bUM();
                            }
                        } else if (slVar.fKX.action == 1 || slVar.fKX.action == 4) {
                            if (slVar.fKX.fKY == 1) {
                                n.this.vyX = true;
                            } else {
                                n.this.vyX = false;
                            }
                            n.this.vzd.a(n.this.vsV, slVar.fKX.result, false);
                            n.this.vzd.a(n.this.vsV);
                            n.this.vzd.b(n.this.vsV);
                            n.this.ccR();
                            n.this.vyG.fullScroll(130);
                            n.a(n.this, slVar.fKX.action);
                        } else {
                            n.this.reset();
                        }
                        return true;
                    } else {
                        x.e("MicroMsg.VoiceInputPanel", "VoiceInputResultEvent userCode not equals!");
                        n.this.destroy();
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
            this.vyB.ld(this.vyJ);
        }
        this.vyH.setVisibility(0);
        if (this.vzf == null) {
            this.vzf = new com.tencent.mm.bf.b.b();
        }
        SharedPreferences cgg = ad.cgg();
        if (cgg != null) {
            String string = cgg.getString("voiceinput_downdistance_content", "");
            if (!string.equalsIgnoreCase("")) {
                x.d("MicroMsg.VoiceInputPanel", "init memoryContent length=%s", Integer.valueOf(string.length()));
                this.vzd.b(this.vsV);
                this.vzd.a(this.vsV, string, false);
                this.vzd.a(this.vsV);
                this.vzd.b(this.vsV);
                ccR();
                this.vyG.fullScroll(130);
                cgg.edit().remove("voiceinput_downdistance_content").apply();
            }
        }
        this.nHI = (TelephonyManager) ad.getContext().getSystemService("phone");
        if (this.nHI != null) {
            if (this.nHJ == null) {
                this.nHJ = new b();
            }
            this.nHI.listen(this.nHJ, 32);
        }
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
            if (this.vzd != null) {
                this.vzd.b(this.vsV);
                this.vzd.a(this.vsV, "", false);
                this.vzd.a(this.vsV);
                this.vzd.b(this.vsV);
            }
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
        if (this.vzf != null) {
            this.vzf = null;
        }
        if (!(this.nHI == null || this.nHJ == null)) {
            this.nHI.listen(this.nHJ, 0);
            this.nHJ = null;
        }
        this.nHI = null;
        this.vyF = null;
    }

    private void ccQ() {
        x.d("MicroMsg.VoiceInputPanel", "closePanel");
        if (this.vyE != null) {
            this.vyW = true;
            x.i("MicroMsg.VoiceInputPanel", "closePanel onClearBtnDown");
            VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
            if (this.vsV == null || this.vsV.getText() == null || this.vsV.getText().length() <= 0) {
                if (this.vyW) {
                    voiceInputBehavior.cancel = 2;
                } else {
                    voiceInputBehavior.cancel = 15;
                }
            } else if (this.vyW) {
                voiceInputBehavior.cancel = 14;
            } else {
                voiceInputBehavior.cancel = 16;
            }
            if (this.vyI != 0) {
                voiceInputBehavior.voiceInputTime = bi.bB(this.vyI);
                this.vyI = 0;
            }
            a(voiceInputBehavior);
            this.vyE.bUM();
        }
    }

    public final void CJ(int i) {
        x.d("MicroMsg.VoiceInputPanel", "setPortHeightPX DISPLAY_HEIGHT_PORT_IN_PX %s,value %s", Integer.valueOf(this.vvZ), Integer.valueOf(i));
        if (this.vvZ != i) {
            this.vvZ = i;
            this.vzh = true;
        }
    }

    public final void cbV() {
        x.d("MicroMsg.VoiceInputPanel", "refreshHeight DISPLAY_HEIGHT_PORT_IN_PX %s,needRefreshProtHeight %s", Integer.valueOf(this.vvZ), Boolean.valueOf(this.vzh));
        if (this.vzh) {
            this.vzh = false;
            View findViewById = findViewById(R.h.cWz);
            LayoutParams layoutParams = findViewById.getLayoutParams();
            int i = this.vvZ;
            if (layoutParams == null) {
                layoutParams = new LinearLayout.LayoutParams(-1, i);
            }
            layoutParams.height = i;
            findViewById.setLayoutParams(layoutParams);
            init();
            ccR();
            requestLayout();
        }
    }

    public final void ccR() {
        x.d("MicroMsg.VoiceInputPanel", "setTextHintAndColor");
        if (this.vsV == null || this.vsV.getText() == null || this.vsV.getText().length() != 0) {
            if (this.vsV != null) {
                this.vsV.setCursorVisible(true);
            }
            this.oqb.setVisibility(0);
            if (!this.vyJ) {
                this.vyC.setVisibility(8);
                this.vyD.setVisibility(0);
            }
            this.vyH.setVisibility(8);
        } else {
            this.vsV.setSelection(0);
            this.vsV.setCursorVisible(false);
            this.oqb.setVisibility(4);
            if (!this.vyJ) {
                this.vyC.setVisibility(0);
            }
            this.vyD.setVisibility(8);
            this.vyH.setVisibility(0);
        }
        if (this.vyJ) {
            if (this.vyF == null || this.vyF.getText() == null || this.vyF.getText().length() != 0) {
                this.oqb.setVisibility(0);
            } else {
                this.oqb.setVisibility(4);
            }
        }
        if (this.vsV != null) {
            this.vsV.clearFocus();
        }
        x.i("MicroMsg.VoiceInputPanel", "resumeMusic");
        as.Hn().ya();
        if (!this.vyS) {
            this.vyS = true;
            this.vyV = System.currentTimeMillis();
            x.d("VOICEDEBUG", "Last Text Time = %s Corss Time = %s", Long.valueOf(this.vyV), Long.valueOf(this.vyV - this.vyU));
        }
    }

    private static void a(VoiceInputBehavior voiceInputBehavior) {
        x.i("MicroMsg.VoiceInputPanel", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
        com.tencent.mm.bp.a log_13905 = new log_13905();
        log_13905.viOp_ = voiceInputBehavior;
        com.tencent.mm.plugin.report.service.g.pWK.c(13905, log_13905);
    }

    private static void CK(int i) {
        x.i("MicroMsg.VoiceInputPanel", "idkReport type = %s", Integer.valueOf(i));
        com.tencent.mm.plugin.report.service.g.pWK.a(455, (long) i, 1, false);
    }
}
