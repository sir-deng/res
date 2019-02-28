package com.tencent.mm.pluginsdk.ui.chat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnDragListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.R;
import com.tencent.mm.ap.l;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.f.a.nb;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.as;
import com.tencent.mm.y.s;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ChatFooter extends LinearLayout implements OnGlobalLayoutListener, com.tencent.mm.pluginsdk.ui.chat.h.a {
    private static int count = 0;
    private static final int[] kJJ = new int[]{0, 15, 30, 45, 60, 75, 90, 100};
    private static final int[] kJK = new int[]{R.g.byD, R.g.byE, R.g.byF, R.g.byG, R.g.byH, R.g.byI, R.g.byJ};
    private Activity activity;
    private Context context;
    public String fAJ;
    private ImageView kJS;
    private boolean kKa;
    private final ag kKj;
    public View mEs;
    public View mEt;
    public View mEu;
    public View mEv;
    public final ag mHandler;
    public View mcj;
    public MMEditText oqa;
    public Button oqb;
    public ChatFooterPanel oqc;
    public q sit;
    private TextView siu;
    private ImageView siv;
    public View siw;
    public String toUser;
    public f vqk;
    private int vql;
    public n vso;
    public boolean vsr;
    private String vwC;
    public AppPanel vwD;
    public TextView vwE;
    private Button vwF;
    public ImageButton vwG;
    public ChatFooterBottom vwH;
    private TextView vwI;
    public ImageButton vwJ;
    public ImageButton vwK;
    public View vwL;
    private i vwM;
    private i vwN;
    public m vwO;
    public b vwP;
    private d vwQ;
    public final a vwR;
    public boolean vwS;
    public boolean vwT;
    private TextView vwU;
    private InputMethodManager vwV;
    public int vwW;
    private boolean vwX;
    private boolean vwY;
    public boolean vwZ;
    private boolean vxA;
    private final int vxB;
    private final int vxC;
    private volatile boolean vxD;
    private ag vxE;
    private int vxF;
    private int vxG;
    private int vxH;
    private View vxI;
    public boolean vxJ;
    private int vxK;
    public b vxa;
    public c vxb;
    private com.tencent.mm.pluginsdk.ui.chat.m.a vxc;
    private boolean vxd;
    public u vxe;
    private boolean vxf;
    private Animation vxg;
    private Animation vxh;
    private com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a vxi;
    private com.tencent.mm.pluginsdk.ui.chat.AppPanel.b vxj;
    public e vxk;
    private int vxl;
    public boolean vxm;
    private int vxn;
    private final int vxo;
    private final int vxp;
    private final int vxq;
    private final int vxr;
    private final int vxs;
    private final int vxt;
    private final int vxu;
    private final int vxv;
    private int vxw;
    private int vxx;
    private int vxy;
    private int vxz;

    private static class a {
        public String vxP;
        public String vxQ;
        public int vxR;
        public HashMap<String, LinkedList<HashMap<String, String>>> vxS;

        private a() {
            this.vxS = new HashMap();
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public interface d {
        boolean lu(boolean z);
    }

    public class e implements TextWatcher {
        TextWatcher vxT;
        private boolean vxU = false;
        private boolean vxV = f.fO(11);

        public e(TextWatcher textWatcher) {
            this.vxT = textWatcher;
        }

        public final void afterTextChanged(Editable editable) {
            boolean z = true;
            if (ChatFooter.this.vwY && this.vxU && editable.length() > 0) {
                this.vxU = false;
                ChatFooter.this.oqa.setText(editable.subSequence(0, editable.length() - 1));
                if (ChatFooter.this.oqa.length() > 0) {
                    ChatFooter.this.oqb.performClick();
                }
                x.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
                return;
            }
            this.vxT.afterTextChanged(editable);
            if (ChatFooter.this.vwE != null) {
                if (ChatFooter.this.oqa.getLineCount() > 1) {
                    ChatFooter.this.vwE.setVisibility(0);
                    ChatFooter.this.vwE.setText(editable.length() + "/140");
                } else {
                    ChatFooter.this.vwE.setVisibility(8);
                }
            }
            if (editable.length() <= 0 || editable.toString().trim().length() <= 0) {
                z = false;
            }
            ChatFooter.this.gz(z);
            if (ChatFooter.this.oqc != null) {
                ChatFooter.this.oqc.aG(z);
            }
            x.d("VOICEDEBUG", "Last Text Time = " + System.currentTimeMillis());
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.vxT.beforeTextChanged(charSequence, i, i2, i3);
            x.d("VOICEDEBUG", "First Text Time = " + System.currentTimeMillis());
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (ChatFooter.this.vwY && i2 == 0 && i == charSequence.length() - 1 && i3 == 1 && charSequence.charAt(charSequence.length() - 1) == 10) {
                this.vxU = true;
            } else {
                this.vxT.onTextChanged(charSequence, i, i2, i3);
            }
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.ChatFooter$20 */
    class AnonymousClass20 implements Runnable {
        final /* synthetic */ boolean vxM = false;

        AnonymousClass20(boolean z) {
        }

        public final void run() {
            ChatFooter.this.lt(this.vxM);
        }
    }

    public interface b {
        void a(Boolean bool, Boolean bool2);

        void b(Boolean bool, Boolean bool2);
    }

    public interface c {
        void g(Boolean bool);
    }

    static /* synthetic */ void A(ChatFooter chatFooter) {
        if (com.tencent.mm.o.a.aW(chatFooter.context) || com.tencent.mm.o.a.aU(chatFooter.context)) {
            x.d("MicroMsg.ChatFooter", "voip is running, cann't record voice");
            return;
        }
        chatFooter.findViewById(R.h.bTX).setVisibility(8);
        chatFooter.vwW = 1;
        chatFooter.oqa.setVisibility(8);
        chatFooter.vwF.setVisibility(8);
        chatFooter.Cz(R.g.bBq);
        if (chatFooter.oqc != null) {
            chatFooter.oqc.setVisibility(8);
        }
        chatFooter.CE(8);
        chatFooter.vwH.setVisibility(0);
        chatFooter.lo(false);
        if (chatFooter.vso == null) {
            chatFooter.vso = new n(chatFooter.getContext(), false, null);
            chatFooter.vwH.addView(chatFooter.vso, new LayoutParams(-1, -1));
            chatFooter.vso.vyE = new com.tencent.mm.pluginsdk.ui.chat.n.a() {
                public final void bUM() {
                    ChatFooter.this.cbj();
                }

                public final void Qb(String str) {
                    if (ChatFooter.this.vwP != null) {
                        ChatFooter.this.vwP.EM(str);
                    } else {
                        x.e("MicroMsg.ChatFooter", "onSendMsg listener is null !!!");
                    }
                    ChatFooter.this.vso.reset();
                }

                public final void kF(boolean z) {
                    if (z) {
                        if (ChatFooter.this.vxb != null) {
                            x.d("MicroMsg.ChatFooter", "onVoiceStart start");
                            ChatFooter.this.vxb.g(Boolean.valueOf(true));
                        }
                    } else if (ChatFooter.this.vxb != null) {
                        x.d("MicroMsg.ChatFooter", "onVoiceStart end");
                        ChatFooter.this.vxb.g(Boolean.valueOf(false));
                    }
                }
            };
            if (chatFooter.vwD.getHeight() > 0) {
                chatFooter.vso.CJ(chatFooter.vwD.getHeight());
            } else {
                chatFooter.vso.CJ(j.aQ(chatFooter.context));
            }
        }
        n nVar = chatFooter.vso;
        String str = chatFooter.toUser;
        if (bi.oN(str)) {
            x.e("MicroMsg.VoiceInputPanel", "setToUser toUser is isNullOrNil");
        } else {
            nVar.flQ = str;
        }
        chatFooter.vso.ccP();
        chatFooter.vso.cbV();
        chatFooter.vso.setVisibility(0);
        chatFooter.vsr = true;
    }

    static /* synthetic */ void J(ChatFooter chatFooter) {
        chatFooter.vxE.removeMessages(4097);
        chatFooter.vxE.sendEmptyMessageDelayed(4097, 1);
    }

    static /* synthetic */ void a(ChatFooter chatFooter, int i, String str) {
        if (bi.oN(chatFooter.vwC)) {
            x.e("MicroMsg.ChatFooter", "doSendImage : talker is null");
        } else if (str == null || str.equals("") || !com.tencent.mm.a.e.bO(str)) {
            x.e("MicroMsg.ChatFooter", " doSendImage : filePath is null or empty");
        } else {
            as.CN().a(new l(4, com.tencent.mm.y.q.FY(), chatFooter.vwC, str, i, null, 0, "", "", true, R.g.bAI), 0);
        }
    }

    static /* synthetic */ int ccL() {
        int i = count;
        count = i + 1;
        return i;
    }

    static /* synthetic */ void q(ChatFooter chatFooter) {
        if (chatFooter.vwW == 1) {
            x.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(chatFooter.activity, "android.permission.RECORD_AUDIO", 80, "", "")), bi.chl(), chatFooter.activity);
            if (com.tencent.mm.pluginsdk.g.a.a(chatFooter.activity, "android.permission.RECORD_AUDIO", 80, "", "")) {
                chatFooter.ab(2, true);
                return;
            }
            return;
        }
        chatFooter.ab(1, true);
    }

    public ChatFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChatFooter(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mcj = null;
        this.oqa = null;
        this.oqb = null;
        this.vwE = null;
        this.vwQ = null;
        this.vwR = new a();
        this.vwS = false;
        this.vwT = false;
        this.kKa = false;
        this.vwX = false;
        this.vwY = false;
        this.vwZ = false;
        this.vsr = false;
        this.vxc = new com.tencent.mm.pluginsdk.ui.chat.m.a() {
            public final void clear() {
                ChatFooter chatFooter = ChatFooter.this;
                if (chatFooter.oqa != null) {
                    chatFooter.oqa.setText("");
                }
            }
        };
        this.mHandler = new ag() {
            @SuppressLint({"NewApi"})
            @TargetApi(11)
            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 1002:
                        if (ChatFooter.this.oqa != null && message.obj != null) {
                            boolean booleanValue = ((Boolean) message.obj).booleanValue();
                            if (booleanValue) {
                                ChatFooter.this.oqa.setAlpha(1.0f);
                            } else {
                                ChatFooter.this.oqa.setAlpha(0.5f);
                            }
                            ChatFooter.this.lo(booleanValue);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.vxd = false;
        this.vxf = false;
        this.vxi = new com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a() {
            public final void aYA() {
                ChatFooter.this.vwW = 1;
                ChatFooter.this.vwL.setVisibility(0);
                ChatFooter.this.vwF.setVisibility(8);
                ChatFooter.this.lo(true);
                ChatFooter.this.Cz(R.g.bBq);
                if (ChatFooter.this.oqb != null) {
                    ChatFooter.this.oqb.performClick();
                }
            }

            public final void gA(boolean z) {
                ChatFooter.this.vwW = 1;
                ChatFooter.this.vwL.setVisibility(0);
                ChatFooter.this.vwF.setVisibility(8);
                ChatFooter.this.Cz(R.g.bBq);
                if (ChatFooter.this.oqa != null) {
                    ChatFooter.this.ls(z);
                }
            }

            public final void anG() {
                ChatFooter.this.vwW = 1;
                ChatFooter.this.vwL.setVisibility(0);
                ChatFooter.this.vwF.setVisibility(8);
                ChatFooter.this.lo(true);
                ChatFooter.this.Cz(R.g.bBq);
                ChatFooter.this.oqa.zCS.sendKeyEvent(new KeyEvent(0, 67));
                ChatFooter.this.oqa.zCS.sendKeyEvent(new KeyEvent(1, 67));
            }

            public final void append(String str) {
                ChatFooter.this.vwW = 1;
                ChatFooter.this.vwL.setVisibility(0);
                ChatFooter.this.vwF.setVisibility(8);
                ChatFooter.this.lo(true);
                ChatFooter.this.Cz(R.g.bBq);
                try {
                    ChatFooter.this.oqa.aaU(str);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ChatFooter", e, "", new Object[0]);
                }
            }
        };
        this.vxj = new com.tencent.mm.pluginsdk.ui.chat.AppPanel.b() {
            public final void cbY() {
                x.i("MicroMsg.ChatFooter", "summerper checkPermission checkmicrophone[%s], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(ChatFooter.this.activity, "android.permission.RECORD_AUDIO", 80, "", "")), bi.chl(), ChatFooter.this.activity);
                if (com.tencent.mm.pluginsdk.g.a.a(ChatFooter.this.activity, "android.permission.RECORD_AUDIO", 80, "", "")) {
                    int Ks = as.CN().Ks();
                    if (Ks == 4 || Ks == 6) {
                        ChatFooter.A(ChatFooter.this);
                    } else if (ChatFooter.this.vwM == null || !ChatFooter.this.vwM.isShowing()) {
                        ChatFooter.this.vwM = h.h(ChatFooter.this.getContext(), R.l.eVP, R.l.dGZ);
                    }
                }
            }
        };
        this.kKj = new ag() {
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (ChatFooter.this.sit != null) {
                    ChatFooter.this.sit.dismiss();
                    ChatFooter.this.vwF.setBackgroundDrawable(com.tencent.mm.bu.a.b(ChatFooter.this.getContext(), R.g.bFh));
                    ChatFooter.this.vwF.setEnabled(true);
                }
            }
        };
        this.vxl = 0;
        this.vxm = false;
        this.vxn = 0;
        this.vxo = 0;
        this.vxp = 1;
        this.vxq = 2;
        this.vxr = 3;
        this.vxs = 20;
        this.vxt = 21;
        this.vxu = 22;
        this.vxv = 23;
        this.vxw = 0;
        this.vxx = 0;
        this.vxy = -1;
        this.vxz = -1;
        this.vxA = false;
        this.vxB = 4097;
        this.vxC = 4098;
        this.vxE = new ag() {
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                switch (message.what) {
                    case 4097:
                        ChatFooter.this.vxD = true;
                        ViewGroup.LayoutParams layoutParams = ChatFooter.this.vwH.getLayoutParams();
                        int bottom = ChatFooter.this.vwH.getBottom() - ChatFooter.this.vwH.getTop();
                        if (ChatFooter.this.ccA()) {
                            if (ChatFooter.this.oqc != null) {
                                ChatFooter.this.oqc.setVisibility(8);
                            }
                            ChatFooter.this.CE(8);
                            ChatFooter.this.vwH.setVisibility(4);
                        }
                        if (bottom <= 3) {
                            ChatFooter.this.vxD = false;
                            ChatFooter.this.vwH.setVisibility(8);
                            ChatFooter.this.CG(ChatFooter.this.ccE());
                            return;
                        }
                        layoutParams.height = Math.max(bottom - 60, 1);
                        ChatFooter.this.vwH.setLayoutParams(layoutParams);
                        ChatFooter.J(ChatFooter.this);
                        return;
                    default:
                        return;
                }
            }
        };
        this.vxF = -1;
        this.vxG = -1;
        this.vxH = -1;
        this.vxI = null;
        this.vxJ = true;
        this.vxK = 0;
        long currentTimeMillis = System.currentTimeMillis();
        this.vwV = (InputMethodManager) context.getSystemService("input_method");
        this.mcj = inflate(context, R.i.dde, this);
        this.oqa = (MMEditText) this.mcj.findViewById(R.h.bTI);
        com.tencent.mm.ui.tools.a.c.d(this.oqa).Hg(com.tencent.mm.j.b.zG()).a(null);
        this.oqa.getInputExtras(true).putBoolean("IS_CHAT_EDITOR", true);
        this.oqa.setOnFocusChangeListener(new OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    ChatFooter.this.vwL.setBackground(ChatFooter.this.getResources().getDrawable(R.g.bDg));
                } else {
                    ChatFooter.this.vwL.setBackground(ChatFooter.this.getResources().getDrawable(R.g.bDh));
                }
            }
        });
        com.tencent.mm.sdk.b.b nbVar = new nb();
        nbVar.fFQ.fFS = this.oqa;
        nbVar.fFQ.fFR = new com.tencent.mm.pluginsdk.ui.a.a() {
            public final void SO(final String str) {
                x.e("MicroMsg.ChatFooter", "hakon onImageReceived, %s", str);
                if (bi.oN(ChatFooter.this.vwC) || bi.oN(str)) {
                    x.e("MicroMsg.ChatFooter", "onImageReceived, error args");
                } else {
                    h.a(ChatFooter.this.getContext(), ChatFooter.this.getContext().getString(R.l.eej), "", new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            int i2 = 1;
                            boolean a = com.tencent.mm.y.q.a(str, ChatFooter.this.vwC, true);
                            ChatFooter chatFooter = ChatFooter.this;
                            if (!a) {
                                i2 = 0;
                            }
                            ChatFooter.a(chatFooter, i2, str);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
            }
        };
        com.tencent.mm.sdk.b.a.xmy.m(nbVar);
        this.vwL = this.mcj.findViewById(R.h.cQI);
        this.vwH = (ChatFooterBottom) findViewById(R.h.bTD);
        this.vwJ = (ImageButton) this.mcj.findViewById(R.h.bTv);
        this.oqb = (Button) this.mcj.findViewById(R.h.bUY);
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.oqb.setTextSize(0, ((float) com.tencent.mm.bu.a.ab(context, R.f.bvt)) * com.tencent.mm.bu.a.ex(context));
        this.vwF = (Button) this.mcj.findViewById(R.h.cXa);
        this.vwG = (ImageButton) findViewById(R.h.bUG);
        gz(false);
        ccI();
        this.vwN = new i(getContext(), getRootView(), this, new com.tencent.mm.pluginsdk.ui.chat.i.a() {
            public final void Tg(String str) {
                Intent intent = new Intent();
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(str);
                if (ChatFooter.this.fAJ != null) {
                    intent.putExtra("GalleryUI_FromUser", ChatFooter.this.fAJ);
                }
                if (ChatFooter.this.toUser != null) {
                    intent.putExtra("GalleryUI_ToUser", ChatFooter.this.toUser);
                }
                intent.putExtra("query_source_type", 3);
                intent.putExtra("preview_image", true);
                intent.putStringArrayListExtra("preview_image_list", arrayList);
                intent.putExtra("max_select_count", 1);
                intent.addFlags(67108864);
                if (ChatFooter.this.vxe != null) {
                    com.tencent.mm.bl.d.a(ChatFooter.this.vxe, "gallery", ".ui.GalleryEntryUI", intent, (int) com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX);
                } else {
                    com.tencent.mm.bl.d.b(context, "gallery", ".ui.GalleryEntryUI", intent, com.tencent.mm.plugin.appbrand.jsapi.media.e.CTRL_INDEX);
                }
            }
        });
        this.vwN.vyh = this;
        Context context2 = getContext();
        getRootView();
        this.vwO = new m(context2);
        this.vwO.vxc = this.vxc;
        x.d("MicroMsg.ChatFooter", "send edittext ime option %s", Integer.valueOf(this.oqa.getImeOptions()));
        this.oqa.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != 4 && (i != 0 || !ChatFooter.this.vwY)) {
                    return false;
                }
                ChatFooter.this.oqb.performClick();
                return true;
            }
        });
        this.oqa.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                ChatFooter.this.ls(true);
                ChatFooter.this.p(3, -1, true);
                ChatFooter.this.vwP.aZr();
                ChatFooter.this.postDelayed(new AnonymousClass20(false), 10);
                return false;
            }
        });
        this.oqa.setOnLongClickListener(new OnLongClickListener() {
            public final boolean onLongClick(View view) {
                return false;
            }
        });
        this.oqb.setOnClickListener(new View.OnClickListener() {
            public final synchronized void onClick(View view) {
                String obj = ChatFooter.this.oqa.getText().toString();
                x.d("MicroMsg.ChatFooter", "send msg onClick");
                if (obj.trim().length() == 0 && obj.length() != 0) {
                    x.d("MicroMsg.ChatFooter", "empty message cant be sent");
                    if (ChatFooter.this.vwM == null || !ChatFooter.this.vwM.isShowing()) {
                        ChatFooter.this.vwM = h.h(ChatFooter.this.getContext(), R.l.dQY, R.l.dGZ);
                    }
                } else if (ChatFooter.this.vwP.EM(obj)) {
                    ChatFooter.this.oqa.clearComposingText();
                    ChatFooter.this.oqa.setText("");
                }
            }
        });
        this.vwF.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (view == ChatFooter.this.vwF) {
                    x.v("RcdBtnEvent", "event.getAction():" + motionEvent.getAction());
                    switch (motionEvent.getAction()) {
                        case 0:
                            x.i("RcdBtnEvent", "on MotionEvent.ACTION_DOWN:[%d]", Integer.valueOf(ChatFooter.count));
                            if (ChatFooter.this.context instanceof Activity) {
                                ((Activity) ChatFooter.this.context).getWindow().addFlags(FileUtils.S_IWUSR);
                            }
                            if (!(ChatFooter.this.kKa || ChatFooter.this.vwX)) {
                                ChatFooter.this.kKa = true;
                                ChatFooter.this.vwF.setBackgroundDrawable(com.tencent.mm.bu.a.b(ChatFooter.this.getContext(), R.g.bFi));
                                ChatFooter.this.vwF.setText(R.l.dQF);
                                ChatFooter.this.vwP.aZo();
                                ChatFooter.this.vwF.setContentDescription(ChatFooter.this.getContext().getString(R.l.dQj));
                                break;
                            }
                        case 1:
                        case 3:
                            if (ChatFooter.this.context instanceof Activity) {
                                ((Activity) ChatFooter.this.context).getWindow().clearFlags(FileUtils.S_IWUSR);
                            }
                            x.i("RcdBtnEvent", "enter on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", Integer.valueOf(ChatFooter.count));
                            ChatFooter.this.ccG();
                            x.i("RcdBtnEvent", "outer on MotionEvent.ACTION_UP/ACTION_CANCEL:[%d]", Integer.valueOf(ChatFooter.ccL()));
                            break;
                        case 2:
                            if (ChatFooter.this.mEu == null || ChatFooter.this.mEv == null) {
                                x.e("MicroMsg.ChatFooter", "[arthurdan.initRcdBtn] Notice!!! rcdAnimArea is %s, rcdCancelArea is %s", ChatFooter.this.mEu, ChatFooter.this.mEv);
                            }
                            if (motionEvent.getX() > 0.0f && motionEvent.getY() > ((float) ((-ChatFooter.this.vxl) / 2)) && motionEvent.getX() < ((float) ChatFooter.this.vwF.getWidth())) {
                                if (ChatFooter.this.mEu != null) {
                                    ChatFooter.this.mEu.setVisibility(0);
                                }
                                if (ChatFooter.this.mEv != null) {
                                    ChatFooter.this.vwF.setText(R.l.dQF);
                                    ChatFooter.this.mEv.setVisibility(8);
                                    break;
                                }
                            }
                            x.i("MicroMsg.ChatFooter", "show cancel Tips, ACTION_MOVE (x:%f y:%f) rcdHintPopUpMarginTop:%d voiceRcdBtn.getWidth():%d voiceRcdBtn.getHeight():%d", Float.valueOf(motionEvent.getX()), Float.valueOf(motionEvent.getY()), Integer.valueOf(ChatFooter.this.vxl), Integer.valueOf(ChatFooter.this.vwF.getWidth()), Integer.valueOf(ChatFooter.this.vwF.getHeight()));
                            if (ChatFooter.this.mEu != null) {
                                ChatFooter.this.mEu.setVisibility(8);
                            }
                            if (ChatFooter.this.mEv != null) {
                                ChatFooter.this.vwF.setText(R.l.dQp);
                                ChatFooter.this.mEv.setVisibility(0);
                                break;
                            }
                            break;
                    }
                }
                return false;
            }
        });
        this.vwF.setOnKeyListener(new OnKeyListener() {
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                switch (keyEvent.getAction()) {
                    case 0:
                        if (!((i != 23 && i != 66) || ChatFooter.this.vwX || ChatFooter.this.kKa)) {
                            ChatFooter.this.vwX = true;
                            ChatFooter.this.vwF.setBackgroundDrawable(com.tencent.mm.bu.a.b(ChatFooter.this.getContext(), R.g.bFi));
                            ChatFooter.this.vwF.setText(R.l.dQF);
                            ChatFooter.this.vwP.aZo();
                            ChatFooter.this.vwF.setContentDescription(ChatFooter.this.getContext().getString(R.l.dQj));
                            break;
                        }
                    case 1:
                        if (i == 23 || i == 66) {
                            ChatFooter.this.vwF.setBackgroundDrawable(com.tencent.mm.bu.a.b(ChatFooter.this.getContext(), R.g.bFh));
                            ChatFooter.this.vwF.setText(R.l.dQE);
                            ChatFooter.this.vwP.aZl();
                            ChatFooter.this.vwX = false;
                            break;
                        }
                }
                return false;
            }
        });
        this.vwG.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ChatFooter.q(ChatFooter.this);
            }
        });
        ccc();
        this.vwJ.setVisibility(0);
        this.vwJ.setContentDescription(getContext().getString(R.l.dQg));
        this.vwJ.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ChatFooter.this.cca();
                if (com.tencent.mm.y.q.GG().booleanValue() && ChatFooter.this.vxa != null) {
                    ChatFooter.this.vxa.a(Boolean.valueOf(true), Boolean.valueOf(true));
                }
            }
        });
        CG(-1);
        findViewById(R.h.bTX).setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        x.d("MicroMsg.ChatFooter", "init time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public final void a(Context context, Activity activity) {
        this.activity = activity;
        ccI();
        if (this.oqc != null) {
            this.oqc.onResume();
        }
        if (!this.vxd && this.vwY) {
            x.i("MicroMsg.ChatFooter", "jacks chatting footer disable enter button send");
            this.vwY = false;
            this.oqa.setImeOptions(0);
            this.oqa.setInputType(this.oqa.getInputType() | 64);
        } else if (this.vxd && !this.vwY) {
            ccy();
        }
        if (this.vwD != null) {
            this.vwD.context = context;
        }
        this.context = context;
        this.vwN.vyg = false;
        if (!this.vsr) {
            this.mcj.findViewById(R.h.bVa).setVisibility(0);
            this.oqa.setVisibility(0);
        }
        ccu();
        post(new Runnable() {
            public final void run() {
                j.h(ChatFooter.this.activity);
            }
        });
    }

    public final void onPause() {
        this.vxf = true;
        if (this.oqc != null) {
            this.oqc.onPause();
        }
        if (this.vsr && this.vso != null) {
            this.vso.pause();
        }
        this.vwP.onPause();
        this.vxJ = false;
    }

    public final void destroy() {
        if (this.oqc != null) {
            x.i("MicroMsg.ChatFooter", "jacks chat footer desctory smiley panel");
            this.oqc.tj();
            this.oqc.destroy();
            this.oqc = null;
        }
        if (this.vso != null) {
            this.vso.destroy();
            this.vso = null;
            this.vsr = false;
        }
        if (this.vwP != null) {
            this.vwP.release();
        }
        if (this.vwO != null) {
            this.vwO.vxc = null;
            this.vwO.vyr = null;
            this.vwO.hide();
        }
        x.d("MicroMsg.ChatFooter", "jacks destory");
    }

    public final void cbZ() {
        if (this.vwD != null) {
            this.vwD.cbP();
        }
    }

    private void gz(boolean z) {
        if (this.vxg == null) {
            this.vxg = AnimationUtils.loadAnimation(getContext(), R.a.bqk);
            this.vxg.setDuration(150);
        }
        if (this.vxh == null) {
            this.vxh = AnimationUtils.loadAnimation(getContext(), R.a.bql);
            this.vxh.setDuration(150);
        }
        if (this.oqb != null && this.vwJ != null) {
            if (this.vxd) {
                if (this.vwJ.getVisibility() != 0) {
                    this.vwJ.setVisibility(0);
                }
            } else if (this.oqb.getVisibility() != 0 || !z) {
                if (this.vwJ.getVisibility() != 0 || z) {
                    if (z) {
                        this.oqb.startAnimation(this.vxg);
                        this.oqb.setVisibility(0);
                        this.vwJ.startAnimation(this.vxh);
                        this.vwJ.setVisibility(8);
                    } else {
                        this.vwJ.startAnimation(this.vxg);
                        if (!this.vwT) {
                            this.vwJ.setVisibility(0);
                        }
                        this.oqb.startAnimation(this.vxh);
                        this.oqb.setVisibility(8);
                    }
                    x.i("MicroMsg.ChatFooter", "jacks canSend:%B", Boolean.valueOf(z));
                    this.oqb.getParent().requestLayout();
                }
            }
        }
    }

    public final void cca() {
        this.vwP.aZq();
        if (this.vwD.getVisibility() != 0 || this.vwH.fKg) {
            p(2, 22, true);
            if (this.vso != null && this.vso.getVisibility() == 0 && this.vsr) {
                x.d("MicroMsg.ChatFooter", "voiceInputPanel is VISIBLE, set appPanel VISIBLE");
                this.vso.setVisibility(8);
                this.vsr = false;
                this.vso.reset();
            }
            ao bZI = ao.bZI();
            Context context = ad.getContext();
            if (g.Do().CF() && context != null) {
                try {
                    String value = com.tencent.mm.j.g.Af().getValue("ShowAPPSuggestion");
                    if (bi.oN(value) || Integer.valueOf(value).intValue() != 1) {
                        x.w("MicroMsg.SuggestionAppListLogic", "cfgShowAppSuggestion %s, return", value);
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.SuggestionAppListLogic", "exception in getSuggestionAppList, %s", e.getMessage());
                }
                if (bZI.vmc) {
                    x.w("MicroMsg.SuggestionAppListLogic", "SuggestionApp is Loading");
                } else {
                    x.i("MicroMsg.SuggestionAppListLogic", "getSuggestionAppList");
                    bZI.vmc = true;
                    if (System.currentTimeMillis() - bZI.vmf < 43200000) {
                        x.d("MicroMsg.SuggestionAppListLogic", "not now");
                        bZI.vmc = false;
                    } else {
                        g.Dr();
                        bZI.vmf = g.Dq().Db().DF(352275);
                        if (System.currentTimeMillis() - bZI.vmf < 43200000) {
                            x.w("MicroMsg.SuggestionAppListLogic", "not now sp");
                            bZI.vmc = false;
                        } else {
                            if (bZI.lang == null) {
                                bZI.lang = w.d(context.getSharedPreferences(ad.cgf(), 0));
                            }
                            com.tencent.mm.pluginsdk.model.app.w agVar = new com.tencent.mm.pluginsdk.model.app.ag(bZI.lang, new LinkedList());
                            com.tencent.mm.plugin.y.a.aRP();
                            com.tencent.mm.pluginsdk.model.app.d.a(4, agVar);
                        }
                    }
                }
            }
            ao bZI2 = ao.bZI();
            Context context2 = ad.getContext();
            if (g.Do().CF() && context2 != null) {
                if (bZI2.vmd) {
                    x.d("MicroMsg.SuggestionAppListLogic", "ServiceAppInfo is loading, return");
                    return;
                }
                bZI2.vmd = true;
                if (System.currentTimeMillis() - bZI2.vmi < 43200000) {
                    x.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now");
                    bZI2.vmd = false;
                    return;
                }
                g.Dr();
                bZI2.vmi = g.Dq().Db().DF(352276);
                if (System.currentTimeMillis() - bZI2.vmi < 43200000) {
                    x.d("MicroMsg.SuggestionAppListLogic", "getServiceAppInfo not now pp");
                    bZI2.vmd = false;
                    return;
                }
                if (bZI2.lang == null) {
                    bZI2.lang = w.d(context2.getSharedPreferences(ad.cgf(), 0));
                }
                ao.cV(bZI2.lang, bZI2.vmh);
            }
        } else if (this.vwW == 1) {
            showVKB();
        } else {
            p(0, -1, false);
        }
    }

    public final void lo(boolean z) {
        if (this.oqa != null) {
            if (z) {
                this.oqa.requestFocus();
            } else {
                this.oqa.clearFocus();
            }
        }
    }

    public final void ccb() {
        boolean z = true;
        if (this.context == null) {
            String str = "MicroMsg.ChatFooter";
            String str2 = "[initSmiley] activity = null? %s";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.activity == null);
            x.e(str, str2, objArr);
            if (this.activity != null) {
                this.context = this.activity.getBaseContext();
            } else {
                this.context = getContext();
            }
        }
        if (e.vxZ != null && this.context != null) {
            if (this.oqc != null) {
                this.oqc.destroy();
            }
            this.oqc = e.vxZ.cw(this.context);
            if (this.oqc != null) {
                this.oqc.ej(ChatFooterPanel.vqn);
                if (this.oqc != null) {
                    this.oqc.setVisibility(8);
                }
                if (this.oqc != null) {
                    this.oqc.Ci(this.vql);
                }
                if (this.vwH != null) {
                    this.vwH.addView(this.oqc, -1, -2);
                }
                if (this.oqc != null) {
                    this.oqc.vqj = this.vxi;
                }
                if (this.oqc != null) {
                    ChatFooterPanel chatFooterPanel = this.oqc;
                    if (this.oqa.getText().length() <= 0) {
                        z = false;
                    }
                    chatFooterPanel.aG(z);
                }
                if (this.oqc != null) {
                    this.oqc.ce(this.vwC);
                    this.oqc.ei(ccE());
                    if (!bi.oN(this.oqa.getText().toString())) {
                        this.oqc.tm();
                    }
                }
                if (this.vwZ) {
                    tk();
                }
                b(this.vqk);
            }
        } else if (this.context == null) {
            x.e("MicroMsg.ChatFooter", "[initSmiley] context always is null! %s", bi.chl());
            this.oqc = new d(ad.getContext());
        } else {
            this.oqc = new d(this.context);
        }
    }

    public final void tk() {
        this.vwZ = true;
        if (this.oqc != null) {
            this.oqc.tk();
        }
    }

    public final void b(f fVar) {
        this.vqk = fVar;
        if (this.oqc != null) {
            this.oqc.a(fVar);
        }
    }

    public final void a(j jVar) {
        this.vwO.vyr = jVar;
    }

    private void Cz(int i) {
        if (this.vwG != null) {
            int i2;
            if (i == R.g.bBq) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (this.vwG != null) {
                if (i2 != 0) {
                    this.vwG.setContentDescription(getContext().getString(R.l.dQi));
                } else {
                    this.vwG.setContentDescription(getContext().getString(R.l.dQh));
                }
            }
            this.vwG.setImageResource(i);
            this.vwG.setPadding(0, 0, 0, 0);
        }
    }

    private void ccc() {
        this.vwD = (AppPanel) findViewById(R.h.bSP);
        this.vwD.vvD = this.vxj;
        this.vwD.Cy(ccE());
        if (s.hq(this.vwC) || s.hj(this.vwC)) {
            this.vwD.init(0);
        } else if (s.gI(this.vwC)) {
            this.vwD.init(4);
        } else if (s.eX(this.vwC)) {
            this.vwD.init(2);
        } else {
            this.vwD.init(1);
        }
        this.vwI = (TextView) findViewById(R.h.bSQ);
    }

    public final void B(CharSequence charSequence) {
        if (this.vwI != null && this.vwD != null) {
            this.vwI.setText(charSequence);
        }
    }

    public final void ccd() {
        this.vwW = 1;
        this.vwL.setVisibility(0);
        this.vwF.setVisibility(8);
        Cz(R.g.bBq);
        if (this.vso != null) {
            this.vso.setVisibility(8);
            this.vsr = false;
            this.vso.reset();
        }
        p(2, 21, true);
    }

    public final void cbj() {
        if (this.vsr) {
            View findViewById = findViewById(R.h.bTX);
            this.vsr = false;
            if (this.vso != null) {
                this.vso.destroy();
                this.vso.setVisibility(8);
            }
            findViewById.setVisibility(0);
            this.oqa.setVisibility(0);
            this.oqa.setText("");
            lo(true);
            ccu();
            p(0, -1, false);
        }
    }

    public final void Tb(String str) {
        this.vwR.vxQ = str;
    }

    public final void Tc(String str) {
        this.vwR.vxP = str;
    }

    public final void ae(String str, String str2, String str3) {
        LinkedList linkedList;
        if (this.vwR.vxS.containsKey(str)) {
            linkedList = (LinkedList) this.vwR.vxS.get(str);
        } else {
            linkedList = new LinkedList();
            this.vwR.vxS.put(str, linkedList);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(str3, str2);
        linkedList.add(hashMap);
    }

    public final void CA(int i) {
        this.vwR.vxR = i;
    }

    public final HashMap<String, String> fl(String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (bi.oN(str2)) {
            if (this.vwR.vxS.containsKey(str)) {
                this.vwR.vxS.remove(str);
            }
            return null;
        } else if (!this.vwR.vxS.containsKey(str) || ((LinkedList) this.vwR.vxS.get(str)).size() <= 0) {
            return null;
        } else {
            List<String> linkedList = new LinkedList();
            int i = 0;
            while (i < str2.length()) {
                i = str2.indexOf("@", i);
                if (i == -1) {
                    break;
                }
                int indexOf = str2.indexOf(8197, i);
                if (indexOf == -1 || indexOf - i > 40) {
                    break;
                }
                linkedList.add(str2.substring(i + 1, indexOf));
                i = indexOf + 1;
            }
            x.i("MicroMsg.ChatFooter", "after split @ :%s", linkedList);
            if (linkedList.size() <= 0) {
                ((LinkedList) this.vwR.vxS.get(str)).clear();
                return null;
            }
            LinkedList linkedList2 = (LinkedList) this.vwR.vxS.get(str);
            if (linkedList2 == null || linkedList2.size() <= 0) {
                x.w("MicroMsg.ChatFooter", "list is null or size 0");
                return null;
            }
            x.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] size:%s", Integer.valueOf(linkedList2.size()));
            List linkedList3 = new LinkedList();
            for (String str3 : linkedList) {
                Iterator it = linkedList2.iterator();
                while (it.hasNext()) {
                    HashMap hashMap = (HashMap) it.next();
                    if (hashMap.containsKey(str3)) {
                        linkedList3.add(hashMap.get(str3));
                        break;
                    }
                }
            }
            HashMap<String, String> hashMap2 = new HashMap(1);
            x.i("MicroMsg.ChatFooter", "[getAtSomebodyUsernames]  atList size:%s", Integer.valueOf(linkedList3.size()));
            hashMap2.put("atuserlist", "<![CDATA[" + bi.d(linkedList3, ",") + "]]>");
            linkedList2.clear();
            x.d("MicroMsg.ChatFooter", "[getAtSomebodyUsernames] cost:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return hashMap2;
        }
    }

    public final void Td(String str) {
        p(str, -1, true);
    }

    public final void p(String str, int i, boolean z) {
        if (z && (str == null || str.length() == 0 || this.oqa == null)) {
            this.oqa.setText("");
            return;
        }
        this.vwS = true;
        this.oqa.setText(com.tencent.mm.pluginsdk.ui.d.i.b(getContext(), str, this.oqa.getTextSize()));
        this.vwS = false;
        if (i < 0 || i > this.oqa.getText().length()) {
            this.oqa.setSelection(this.oqa.getText().length());
        } else {
            this.oqa.setSelection(i);
        }
    }

    public final void cce() {
        this.vwF.setEnabled(false);
        this.vwF.setBackgroundDrawable(com.tencent.mm.bu.a.b(getContext(), R.g.bFg));
        if (this.sit != null) {
            this.mEt.setVisibility(0);
            this.mEs.setVisibility(8);
            this.siw.setVisibility(8);
            this.sit.update();
        }
        this.kKj.sendEmptyMessageDelayed(0, 500);
    }

    public final String ccf() {
        return this.oqa == null ? "" : this.oqa.getText().toString();
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        this.vxk = new e(textWatcher);
        this.oqa.addTextChangedListener(this.vxk);
    }

    public final void CB(int i) {
        this.vxl = 0;
        int fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(getContext(), 180);
        int b = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.b(getContext(), 50.0f);
        if (i + b < fromDPToPix) {
            this.vxl = -1;
        } else {
            this.vxl = ((i - fromDPToPix) / 2) + b;
        }
        if (this.sit == null) {
            this.sit = new q(View.inflate(getContext(), R.i.dtQ, null), -1, -2);
            this.kJS = (ImageView) this.sit.getContentView().findViewById(R.h.cWP);
            this.mEu = this.sit.getContentView().findViewById(R.h.cWQ);
            this.mEv = this.sit.getContentView().findViewById(R.h.cWS);
            this.siu = (TextView) this.sit.getContentView().findViewById(R.h.cWU);
            this.siv = (ImageView) this.sit.getContentView().findViewById(R.h.cWT);
            this.siw = this.sit.getContentView().findViewById(R.h.cWV);
            this.mEs = this.sit.getContentView().findViewById(R.h.cWW);
            this.mEt = this.sit.getContentView().findViewById(R.h.cWX);
            this.vwU = (TextView) this.sit.getContentView().findViewById(R.h.cWZ);
        }
        if (this.vxl != -1) {
            this.mEt.setVisibility(8);
            this.mEs.setVisibility(8);
            this.siw.setVisibility(0);
            this.sit.showAtLocation(this, 49, 0, this.vxl);
        }
    }

    public final void Te(String str) {
        if (str != null && this.vwU != null) {
            this.vwU.setText(str);
        }
    }

    public final void ccg() {
        this.siw.setVisibility(8);
        this.mEs.setVisibility(0);
    }

    public final void aKv() {
        post(new Runnable() {
            public final void run() {
                if (ChatFooter.this.sit != null) {
                    ChatFooter.this.sit.dismiss();
                    ChatFooter.this.mEs.setVisibility(0);
                    ChatFooter.this.siw.setVisibility(8);
                    ChatFooter.this.mEt.setVisibility(8);
                    ChatFooter.this.mEv.setVisibility(8);
                    ChatFooter.this.mEu.setVisibility(0);
                }
                ChatFooter.this.vwF.setBackgroundDrawable(com.tencent.mm.bu.a.b(ChatFooter.this.getContext(), R.g.bFh));
                ChatFooter.this.vwF.setText(R.l.dQE);
                ChatFooter.this.vwX = false;
                ChatFooter.this.kKa = false;
            }
        });
    }

    public final void CC(int i) {
        int i2 = 0;
        while (i2 < kJK.length) {
            if (i >= kJJ[i2] && i < kJJ[i2 + 1]) {
                this.kJS.setBackgroundDrawable(com.tencent.mm.bu.a.b(getContext(), kJK[i2]));
                break;
            }
            i2++;
        }
        if (i == -1 && this.sit != null) {
            this.sit.dismiss();
            this.siw.setVisibility(0);
            this.mEs.setVisibility(8);
            this.mEt.setVisibility(8);
        }
    }

    private void CD(int i) {
        this.vwW = i;
        switch (i) {
            case 1:
                this.vwL.setVisibility(0);
                this.vwF.setVisibility(8);
                Cz(R.g.bBq);
                return;
            case 2:
                this.vwL.setVisibility(8);
                this.vwF.setVisibility(0);
                Cz(R.g.bBp);
                if (com.tencent.mm.y.q.GG().booleanValue() && this.vxa != null) {
                    this.vxa.b(Boolean.valueOf(true), Boolean.valueOf(true));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void ab(int i, boolean z) {
        boolean z2 = true;
        CD(i);
        switch (i) {
            case 1:
                lo(true);
                ccF();
                if (z) {
                    showVKB();
                    if (this.oqa.length() <= 0) {
                        z2 = false;
                    }
                    gz(z2);
                    return;
                }
                if (this.oqa.length() <= 0) {
                    z2 = false;
                }
                gz(z2);
                return;
            case 2:
                p(0, -1, false);
                gz(false);
                return;
            default:
                setVisibility(0);
                return;
        }
    }

    public final void lp(boolean z) {
        if (this.oqc != null) {
            this.oqc.g(z, false);
        }
    }

    public final void cch() {
        this.vwL.setVisibility(0);
        this.vwG.setVisibility(8);
        this.vwF.setVisibility(8);
    }

    public final void cci() {
        AppPanel appPanel = this.vwD;
        appPanel.vvH.vwc.value = false;
        appPanel.cbR();
    }

    public final void ccj() {
        AppPanel appPanel = this.vwD;
        appPanel.vvH.vwu.value = false;
        appPanel.cbR();
    }

    public final void cck() {
        AppPanel appPanel = this.vwD;
        appPanel.vvH.vwd.value = false;
        appPanel.cbR();
    }

    public final void ccl() {
        AppPanel appPanel = this.vwD;
        appPanel.vvH.vwf.value = false;
        appPanel.cbR();
    }

    public final void ccm() {
        AppPanel appPanel = this.vwD;
        appPanel.vvH.vwg.value = false;
        appPanel.cbR();
    }

    public final void ccn() {
        AppPanel appPanel = this.vwD;
        appPanel.vvH.vwt.value = false;
        appPanel.cbR();
    }

    public final void cco() {
        AppPanel appPanel = this.vwD;
        appPanel.vvH.vwh.value = false;
        appPanel.cbR();
        x.d("MicroMsg.AppPanel", "enable false" + " isVoipPluginEnable " + appPanel.vvH.vwi.value);
        this.vwD.lj(true);
    }

    public final void lq(boolean z) {
        AppPanel appPanel = this.vwD;
        boolean z2 = !z;
        appPanel.vvH.vww.value = z2;
        appPanel.cbR();
        x.d("MicroMsg.AppPanel", "enable " + appPanel.vvH.vww.value + " isMultiTalkEnable " + z2);
    }

    public final void lr(boolean z) {
        AppPanel appPanel = this.vwD;
        appPanel.vvH.vwp.value = !z;
        appPanel.cbR();
    }

    public final void ccp() {
        AppPanel appPanel = this.vwD;
        appPanel.vvP = true;
        appPanel.vvH.lm(false);
        appPanel.cbR();
    }

    public final void ccq() {
        AppPanel appPanel = this.vwD;
        appPanel.vvQ = true;
        appPanel.vvH.ll(false);
        appPanel.cbR();
    }

    public final void ccr() {
        AppPanel appPanel = this.vwD;
        appPanel.vvH.vwm.value = false;
        appPanel.cbR();
        x.d("MicroMsg.AppPanel", new StringBuilder("disableTalkroom enable false").toString());
    }

    public final void ccs() {
        AppPanel appPanel = this.vwD;
        appPanel.vvH.vwr.value = false;
        appPanel.cbR();
    }

    public final void cct() {
        AppPanel appPanel = this.vwD;
        appPanel.vvH.vwl.value = false;
        appPanel.cbR();
    }

    public final void ccu() {
        this.vwK = (ImageButton) this.mcj.findViewById(R.h.bVc);
        this.vwK.setVisibility(0);
        this.vwK.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ChatFooter.this.vwP.aZp();
                if (ChatFooter.this.vwH.fKg || ChatFooter.this.oqc == null || ChatFooter.this.oqc.getVisibility() != 0) {
                    if (ChatFooter.this.vwT) {
                        ChatFooter.this.tk();
                    }
                    ChatFooter.this.ccd();
                    return;
                }
                ChatFooter.this.showVKB();
            }
        });
        if (this.vwO != null) {
            this.vwO.vyq = this.vwK;
        }
    }

    public final void ccv() {
        if (this.vwK != null) {
            this.vwK.setVisibility(8);
        }
    }

    public final void ccw() {
        AppPanel appPanel = this.vwD;
        appPanel.vvR = true;
        appPanel.vvH.ln(false);
        appPanel.cbR();
    }

    public final void ccx() {
        AppPanel appPanel = this.vwD;
        appPanel.vvH.vwz.value = false;
        appPanel.cbR();
    }

    public final void ccy() {
        x.i("MicroMsg.ChatFooter", "jacks chatting footer enable enter button send");
        this.vwY = true;
        this.oqa.setImeOptions(4);
        this.oqa.setInputType(this.oqa.getInputType() & -65);
    }

    public final void ccz() {
        if (this.oqc != null) {
            this.oqc.refresh();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void CE(int r6) {
        /*
        r5 = this;
        r2 = 0;
        r0 = r5.vwD;
        if (r0 == 0) goto L_0x000a;
    L_0x0005:
        r0 = r5.vwD;
        r0.setVisibility(r6);
    L_0x000a:
        if (r6 != 0) goto L_0x0013;
    L_0x000c:
        r0 = 1;
        r1 = r0;
    L_0x000e:
        r0 = r5.vwI;
        if (r0 != 0) goto L_0x0015;
    L_0x0012:
        return;
    L_0x0013:
        r1 = r2;
        goto L_0x000e;
    L_0x0015:
        r0 = r5.vwI;
        r0 = r0.getText();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0029;
    L_0x0021:
        r0 = r5.vwI;
    L_0x0023:
        r2 = 8;
    L_0x0025:
        r0.setVisibility(r2);
        goto L_0x0012;
    L_0x0029:
        if (r1 == 0) goto L_0x0047;
    L_0x002b:
        r0 = r5.vwI;
        r0 = r0.getContext();
        r3 = 32;
        r3 = com.tencent.mm.bu.a.fromDPToPix(r0, r3);
        r0 = r5.vwI;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x0047;
    L_0x003f:
        r4 = r0 instanceof android.view.ViewGroup.MarginLayoutParams;
        if (r4 == 0) goto L_0x0047;
    L_0x0043:
        r0 = (android.view.ViewGroup.MarginLayoutParams) r0;
        r0.bottomMargin = r3;
    L_0x0047:
        r0 = r5.vwI;
        if (r1 == 0) goto L_0x0023;
    L_0x004b:
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.chat.ChatFooter.CE(int):void");
    }

    public final boolean ccA() {
        return this.vwH.getVisibility() == 0;
    }

    @TargetApi(11)
    public final void a(OnDragListener onDragListener) {
        this.oqa.setOnDragListener(onDragListener);
    }

    public final void a(com.tencent.mm.pluginsdk.ui.chat.AppPanel.a aVar) {
        this.vwD.vvC = aVar;
    }

    public static void ccB() {
    }

    public final void a(d dVar) {
        this.vwQ = dVar;
        if (dVar != null) {
            View findViewById = findViewById(R.h.bUH);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (ChatFooter.this.vwQ != null) {
                        ChatFooter.this.vwQ.lu(false);
                    }
                }
            });
        }
    }

    public final void CF(int i) {
        if (i != this.vxn) {
            this.vxn = i;
            ImageView imageView = (ImageView) findViewById(R.h.cPX);
            ImageView imageView2 = (ImageView) findViewById(R.h.cBP);
            if (this.vxn == 1) {
                imageView.setVisibility(8);
                imageView2.setVisibility(0);
                return;
            }
            imageView.setVisibility(0);
            imageView2.setVisibility(8);
        }
    }

    @TargetApi(11)
    public final void ls(final boolean z) {
        if (f.fN(11)) {
            com.tencent.mm.compatible.a.a.a(11, new com.tencent.mm.compatible.a.a.a() {
                public final void run() {
                    Message message = new Message();
                    message.what = 1002;
                    message.obj = Boolean.valueOf(z);
                    ChatFooter.this.mHandler.sendMessage(message);
                }
            });
        } else if (z) {
            this.oqa.setTextColor(getResources().getColor(R.e.btg));
        } else {
            this.oqa.setTextColor(getResources().getColor(R.e.bsK));
            lo(false);
        }
    }

    public final void ccC() {
        p(2, 20, false);
    }

    public final void showVKB() {
        post(new Runnable() {
            public final void run() {
                ChatFooter.this.p(1, -1, true);
            }
        });
    }

    public final void p(int i, int i2, boolean z) {
        boolean z2 = true;
        if (!z) {
            this.vwJ.setContentDescription(getContext().getString(R.l.dQg));
            switch (i) {
                case 0:
                    bi.hideVKB(this);
                    lo(false);
                    if (!this.vsr) {
                        ccF();
                        break;
                    }
                    break;
                case 1:
                    bi.hideVKB(this);
                    break;
                case 2:
                    if (i2 != 20) {
                        if (i2 != 22) {
                            if (i2 != 21) {
                                if (i2 == 23) {
                                    cbj();
                                    ccF();
                                    break;
                                }
                            } else if (this.oqc != null) {
                                this.oqc.setVisibility(8);
                                break;
                            }
                        }
                        CE(8);
                        break;
                    } else if (!this.vsr) {
                        ccF();
                        break;
                    } else {
                        bi.hideVKB(this);
                        break;
                    }
                    break;
            }
        }
        if (com.tencent.mm.y.q.GG().booleanValue() && this.vxa != null) {
            this.vxa.a(Boolean.valueOf(true), Boolean.valueOf(false));
            this.vxa.b(Boolean.valueOf(true), Boolean.valueOf(false));
        }
        this.vwJ.setContentDescription(getContext().getString(R.l.dQf));
        switch (i) {
            case 1:
                this.vwH.fKg = true;
                lo(true);
                ls(true);
                this.vwV.showSoftInput(this.oqa, 0);
                break;
            case 2:
                if (i2 == 22) {
                    if (this.vwD == null) {
                        ccc();
                    }
                    this.vwD.cbV();
                    if (this.oqc != null) {
                        this.oqc.setVisibility(8);
                    }
                    CE(0);
                    i iVar = this.vwN;
                    as.Dt().F(new com.tencent.mm.pluginsdk.ui.chat.i.AnonymousClass3(new com.tencent.mm.pluginsdk.ui.chat.i.AnonymousClass2(iVar.context.getMainLooper())));
                    lo(false);
                    if (this.vwW == 2) {
                        CD(1);
                    }
                } else if (i2 == 21) {
                    if (this.vwD != null) {
                        CE(8);
                    }
                    if (this.oqc == null) {
                        ccb();
                    }
                    if (this.oqc != null) {
                        if (com.tencent.mm.storage.x.Xg(this.vwC)) {
                            this.oqc.tk();
                        }
                        this.oqc.setVisibility(0);
                    }
                    lt(true);
                    lo(true);
                }
                this.vwH.setVisibility(0);
                if (!(ccD() && j.aS(getContext()))) {
                    ViewGroup.LayoutParams layoutParams = this.vwH.getLayoutParams();
                    if (layoutParams != null && layoutParams.height == 0) {
                        layoutParams.height = j.aQ(getContext());
                        this.vwH.setLayoutParams(layoutParams);
                    }
                }
                bi.hideVKB(this);
                break;
            case 3:
                this.vwH.fKg = true;
                lo(true);
                ls(true);
                break;
            default:
                z = false;
                break;
        }
        if (!((!z || i2 == 21 || this.vwK == null) && (this.vwK == null || z || (i2 != 21 && i2 != 20)))) {
            lt(false);
        }
        if (i == 0 && !z) {
            lt(false);
        } else if (z && i2 != 22) {
            if (this.oqa.length() <= 0) {
                z2 = false;
            }
            gz(z2);
        }
    }

    public final boolean ccD() {
        return this.vxy > 0 && this.vxy < this.vxz;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        x.d("MicroMsg.ChatFooter", "keybord:ChatFooter onLayout change: %B, l:%d, t:%d, r:%d, b:%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        super.onLayout(z, i, i2, i3, i4);
        if (getTop() != 0) {
            if (getTop() > this.vxx) {
                this.vxx = getTop();
            }
            if (this.vxx - getTop() > 50) {
                if (this.vwP != null) {
                    this.vwP.gB(true);
                }
            } else if (this.vwP != null) {
                this.vwP.gB(false);
            }
        }
        if (z && this.vwO != null) {
            m mVar = this.vwO;
            if (mVar.vyp.isShowing()) {
                mVar.vyp.dismiss();
                mVar.ccO();
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        x.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  provide height:%d, height:%d", Integer.valueOf(MeasureSpec.getSize(i2)), Integer.valueOf(getMeasuredHeight()));
        super.onMeasure(i, i2);
        x.d("MicroMsg.ChatFooter", "keybord:ChatFooter onMeasure  height:%d", Integer.valueOf(getMeasuredHeight()));
    }

    public final int ccE() {
        return j.c(getContext(), true);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        x.d("MicroMsg.ChatFooter", "keybord:ChatFooter onSizeChanged  w:%d, h:%d, oldw:%d, oldh:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
    }

    private void lt(boolean z) {
        if (this.vwK != null) {
            if (!this.vxA || !z) {
                if (this.vxA || z) {
                    this.vxA = z;
                    if (z) {
                        this.vwK.setImageDrawable(getContext().getResources().getDrawable(R.g.bBp));
                    } else {
                        this.vwK.setImageDrawable(getContext().getResources().getDrawable(R.g.bBo));
                    }
                }
            }
        }
    }

    public final void ccF() {
        this.vwH.setVisibility(8);
        CE(8);
        if (this.oqc != null) {
            this.oqc.setVisibility(8);
        }
        lt(false);
    }

    public final void CG(int i) {
        j.zr();
        int q = j.q(this.context, i);
        this.vxw = q;
        if (q > 0 && this.vwH != null) {
            x.d("MicroMsg.ChatFooter", "set bottom panel height: %d", Integer.valueOf(q));
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, 0);
            layoutParams.height = q;
            this.vwH.setLayoutParams(layoutParams);
        }
        if (this.vwD != null) {
            this.vwD.Cy(q);
            AppPanel appPanel = this.vwD;
            appPanel.cbV();
            appPanel.ti();
        }
        if (this.vso != null) {
            this.vso.CJ(q);
            this.vso.cbV();
        }
        if (this.oqc != null) {
            if (!ccD()) {
                ccz();
            }
            this.oqc.ei(q);
            this.oqc.tn();
        }
    }

    public final void ccG() {
        this.kKa = false;
        this.vwF.setBackgroundDrawable(com.tencent.mm.bu.a.b(getContext(), R.g.bFh));
        this.vwF.setText(R.l.dQE);
        if (this.vwP == null) {
            return;
        }
        if (this.mEv == null || this.mEv.getVisibility() != 0) {
            this.vwP.aZl();
        } else {
            this.vwP.aZn();
        }
    }

    public final boolean ccH() {
        return this.vxx - getTop() > 50;
    }

    public final void Tf(String str) {
        this.vwC = str;
        if (this.oqc != null) {
            this.oqc.ce(this.vwC);
        }
        if (this.vwD == null) {
            return;
        }
        if (s.hq(this.vwC) || s.hj(this.vwC)) {
            this.vwD.vvK = 0;
        } else if (s.gI(this.vwC)) {
            this.vwD.vvK = 4;
        } else if (s.eX(this.vwC)) {
            this.vwD.vvK = 2;
        } else {
            this.vwD.vvK = 1;
        }
    }

    public final void ccI() {
        as.Hm();
        this.vxd = ((Boolean) com.tencent.mm.y.c.Db().get(66832, Boolean.valueOf(false))).booleanValue();
    }

    public final void CH(int i) {
        this.vxI = null;
        this.vxH = i;
    }

    public void onGlobalLayout() {
        if (this.activity != null && this.activity.getWindow() != null && this.activity.getWindow().getDecorView() != null) {
            if (this.vxH == -1) {
                x.w("MicroMsg.ChatFooter", "chattingui layout id == -1!");
                return;
            }
            if (this.vxI == null) {
                this.vxI = this.activity.getWindow().getDecorView().findViewById(this.vxH);
            }
            if (this.vxI == null) {
                x.e("MicroMsg.ChatFooter", "can't get chattinguilayout by chattinguilayoutid: %d", Integer.valueOf(this.vxH));
                return;
            }
            int height = this.vxI.getHeight();
            int width = this.vxI.getWidth();
            x.d("MicroMsg.ChatFooter", "ashutest::keybord:ChatFooter measure height: %d, height: %d", Integer.valueOf(this.vxI.getMeasuredHeight()), Integer.valueOf(height));
            if (this.vxz < height) {
                this.vxz = height;
            }
            this.vxy = height;
            if (this.vxF <= 0) {
                this.vxF = height;
            } else if (this.vxG <= 0) {
                this.vxG = width;
            } else if (this.vxF != height || this.vxG != width) {
                if (ccD() && this.vxf) {
                    this.vxf = false;
                    x.d("MicroMsg.ChatFooter", "keybord:Chatfooter Show keybord & hide diy panel by onGlobalLayout");
                    postDelayed(new Runnable() {
                        public final void run() {
                            ChatFooter.this.ccC();
                        }
                    }, 10);
                }
                x.d("MicroMsg.ChatFooter", "keybord:Chatfooter keybord old: %d, new: %d", Integer.valueOf(this.vxF), Integer.valueOf(height));
                int abs = Math.abs(this.vxF - height);
                this.vxF = height;
                height = Math.abs(this.vxG - width);
                this.vxG = width;
                x.d("MicroMsg.ChatFooter", "alvinluo widthDiff: %d", Integer.valueOf(height));
                if (this.vxJ) {
                    if (abs == 0) {
                        if (this.vwD != null) {
                            this.vwD.vvY = true;
                            this.vwD.ti();
                        }
                        if (this.oqc != null) {
                            this.oqc.ei(j.aQ(this.context));
                            ccz();
                            this.oqc.tn();
                        }
                    } else if (j.aS(this.context)) {
                        x.d("MicroMsg.ChatFooter", "alvinluo keyboard current height: %d", Integer.valueOf(this.vxw));
                        if (this.vxw != abs || abs == -1) {
                            height = j.aQ(this.context);
                            x.d("MicroMsg.ChatFooter", "alvinluo valid panel height: %d", Integer.valueOf(height));
                            if (abs >= j.aP(this.context) && abs <= j.aO(this.context)) {
                                height = abs;
                            }
                            if (this.vxm) {
                                this.vxm = false;
                                if (height < this.vxw) {
                                    height = this.vxw;
                                }
                                this.vxw = height;
                                CG(height);
                            } else {
                                this.vxw = height;
                                x.i("MicroMsg.ChatFooter", "jacks calc keyBord dialog height:%d", Integer.valueOf(this.vxw));
                                j.p(getContext(), height);
                                CG(height);
                            }
                        }
                    } else {
                        return;
                    }
                }
                x.d("MicroMsg.ChatFooter", "keybord:Chatfooter Keyboard Size: " + abs);
            }
        }
    }

    public final int ccJ() {
        int aQ = j.aQ(getContext());
        int height = getHeight();
        return height < aQ ? height + aQ : height;
    }
}
