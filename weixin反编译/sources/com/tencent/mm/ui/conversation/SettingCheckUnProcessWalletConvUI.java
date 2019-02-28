package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.f.b.ak;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.r;
import java.util.HashMap;
import java.util.List;

public class SettingCheckUnProcessWalletConvUI extends MMActivity {
    private ListView kLX;
    private int[] zgs = new int[2];
    private List<String> zjl;
    private a zjm;

    private class a extends BaseAdapter {
        private float yvV = -1.0f;
        protected float yvW = -1.0f;
        private float yvX = -1.0f;
        private ColorStateList[] yvY = new ColorStateList[5];
        private HashMap<String, a> yvZ;
        private final int zfU;
        private final int zfV;

        private class a {
            public int kZv;
            public CharSequence nickName;
            public boolean tYt;
            public boolean vmD;
            public boolean ywa;
            public CharSequence zgd;
            public CharSequence zge;
            public int zgf;
            public int zgg;
            public int zgh;
            public boolean zgi;
            public boolean zgj;
            public boolean zgk;
            public boolean zgl;
            public boolean zgm;
            public boolean zgn;
            public int zgo;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        private class b {
            public ImageView ikK;
            public TextView kHx;
            public NoMeasuredTextView ywd;
            public NoMeasuredTextView ywe;
            public NoMeasuredTextView ywf;
            public ImageView ywg;
            public ImageView ywh;
            public View ywi;
            public NoMeasuredTextView zgq;
            public ImageView zgr;

            private b() {
            }

            /* synthetic */ b(a aVar, byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return GM(i);
        }

        public a() {
            this.yvY[0] = com.tencent.mm.bu.a.Z(SettingCheckUnProcessWalletConvUI.this, R.e.bsO);
            this.yvY[1] = com.tencent.mm.bu.a.Z(SettingCheckUnProcessWalletConvUI.this, R.e.btl);
            this.yvY[3] = com.tencent.mm.bu.a.Z(SettingCheckUnProcessWalletConvUI.this, R.e.btv);
            this.yvY[2] = com.tencent.mm.bu.a.Z(SettingCheckUnProcessWalletConvUI.this, R.e.btj);
            this.yvY[2] = com.tencent.mm.bu.a.Z(SettingCheckUnProcessWalletConvUI.this, R.e.btj);
            this.yvY[4] = com.tencent.mm.bu.a.Z(SettingCheckUnProcessWalletConvUI.this, R.e.btb);
            if (com.tencent.mm.bu.a.ez(SettingCheckUnProcessWalletConvUI.this)) {
                this.zfV = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(R.f.buD);
                this.zfU = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(R.f.buE);
            } else {
                this.zfV = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(R.f.buC);
                this.zfU = SettingCheckUnProcessWalletConvUI.this.getResources().getDimensionPixelSize(R.f.buF);
            }
            this.yvV = (float) com.tencent.mm.bu.a.aa(SettingCheckUnProcessWalletConvUI.this, R.f.bvL);
            this.yvW = (float) com.tencent.mm.bu.a.aa(SettingCheckUnProcessWalletConvUI.this, R.f.bvt);
            this.yvX = (float) com.tencent.mm.bu.a.aa(SettingCheckUnProcessWalletConvUI.this, R.f.bvX);
            this.yvZ = new HashMap();
        }

        public final int getCount() {
            return SettingCheckUnProcessWalletConvUI.this.zjl.size();
        }

        public final ae GM(int i) {
            String str = (String) SettingCheckUnProcessWalletConvUI.this.zjl.get(i);
            as.Hm();
            return c.Fk().XF(str);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                View inflate;
                b bVar2 = new b();
                if (com.tencent.mm.bu.a.ez(SettingCheckUnProcessWalletConvUI.this)) {
                    inflate = View.inflate(SettingCheckUnProcessWalletConvUI.this, R.i.dfi, null);
                } else {
                    inflate = View.inflate(SettingCheckUnProcessWalletConvUI.this, R.i.dfh, null);
                }
                bVar2.ikK = (ImageView) inflate.findViewById(R.h.bLM);
                bVar2.ywd = (NoMeasuredTextView) inflate.findViewById(R.h.cAs);
                bVar2.zgq = (NoMeasuredTextView) inflate.findViewById(R.h.cPj);
                bVar2.ywe = (NoMeasuredTextView) inflate.findViewById(R.h.cTY);
                bVar2.ywf = (NoMeasuredTextView) inflate.findViewById(R.h.csB);
                bVar2.kHx = (TextView) inflate.findViewById(R.h.cSe);
                bVar2.kHx.setBackgroundResource(s.ge(SettingCheckUnProcessWalletConvUI.this));
                bVar2.ywg = (ImageView) inflate.findViewById(R.h.cpv);
                bVar2.ywi = inflate.findViewById(R.h.bLP);
                bVar2.ywh = (ImageView) inflate.findViewById(R.h.cQF);
                bVar2.zgr = (ImageView) inflate.findViewById(R.h.cuf);
                inflate.setTag(bVar2);
                bVar2.ywf.O(this.yvW);
                bVar2.ywe.O(this.yvX);
                bVar2.ywd.O(this.yvV);
                bVar2.zgq.O(this.yvW);
                bVar2.ywf.setTextColor(this.yvY[0]);
                bVar2.ywe.setTextColor(this.yvY[4]);
                bVar2.ywd.setTextColor(this.yvY[3]);
                bVar2.zgq.setTextColor(this.yvY[0]);
                bVar2.ywf.yoG = true;
                bVar2.ywe.yoG = false;
                bVar2.ywd.yoG = true;
                bVar2.zgq.yoG = true;
                bVar2.ywe.En();
                view = inflate;
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            ak GM = GM(i);
            if (GM != null) {
                com.tencent.mm.pluginsdk.ui.a.b.a(bVar.ikK, GM.field_username);
                bVar.ikK.getDrawable();
                String str = GM.field_username;
                a aVar = (a) this.yvZ.get(str);
                if (aVar == null) {
                    String str2;
                    int i2;
                    a aVar2 = new a();
                    aVar2.zgh = -1;
                    aVar2.zgg = -1;
                    aVar2.zgl = false;
                    aVar2.zgn = false;
                    aVar2.zgm = false;
                    aVar2.tYt = com.tencent.mm.y.s.eX(GM.field_username);
                    boolean z = aVar2.tYt && aVar2.zgm && GM.field_unReadCount > 0;
                    aVar2.zgk = z;
                    aVar2.kZv = 0;
                    if (wv(GM.field_msgType) == 34 && GM.field_isSend == 0 && !t.oN(GM.field_content)) {
                        str2 = GM.field_content;
                        if (str.equals("qmessage") || str.equals("floatbottle")) {
                            String[] split = str2.split(":");
                            if (split != null && split.length > 3) {
                                str2 = split[1] + ":" + split[2] + ":" + split[3];
                            }
                        }
                        if (!new n(str2).hXo) {
                            aVar2.kZv = 1;
                        }
                    }
                    str2 = r.gw(str);
                    if (aVar2.tYt && str2 == null) {
                        aVar2.nickName = SettingCheckUnProcessWalletConvUI.this.getString(R.l.dSY);
                    } else {
                        aVar2.nickName = i.b(SettingCheckUnProcessWalletConvUI.this, r.gw(str), bVar.ywd.gu.getTextSize());
                    }
                    aVar2.zgd = h(GM);
                    aVar2.zge = c(GM, (int) bVar.ywf.gu.getTextSize(), aVar2.zgk);
                    aVar2.zgo = GM.field_attrflag;
                    switch (GM.field_status) {
                        case 0:
                            i2 = -1;
                            break;
                        case 1:
                            i2 = R.k.dzp;
                            break;
                        case 2:
                            i2 = -1;
                            break;
                        case 5:
                            i2 = R.k.dzo;
                            break;
                        default:
                            i2 = -1;
                            break;
                    }
                    aVar2.zgf = i2;
                    aVar2.zgi = com.tencent.mm.y.s.a(GM);
                    as.Hm();
                    aVar2.ywa = c.Fk().g(GM);
                    aVar2.zgj = false;
                    aVar2.vmD = w.cfR();
                    this.yvZ.put(str, aVar2);
                    aVar = aVar2;
                }
                if (aVar.zgd == null) {
                    aVar.zgd = h(GM);
                }
                if (aVar.zgk || com.tencent.mm.y.s.hg(GM.field_parentRef)) {
                    bVar.ywf.setTextColor(this.yvY[0]);
                } else {
                    bVar.ywf.setTextColor(this.yvY[aVar.kZv]);
                }
                if (str.toLowerCase().endsWith("@t.qq.com")) {
                    bVar.ywd.Fm(R.g.bDc);
                    bVar.ywd.mB(true);
                } else {
                    bVar.ywd.mB(false);
                }
                int i3 = aVar.zgf;
                if (i3 != -1) {
                    bVar.ywf.Fl(i3);
                    bVar.ywf.mA(true);
                } else {
                    bVar.ywf.mA(false);
                }
                bVar.ywd.setText(aVar.nickName);
                bVar.zgq.setVisibility(8);
                LayoutParams layoutParams = bVar.ywe.getLayoutParams();
                if (aVar.zgd.length() > 9) {
                    if (layoutParams.width != this.zfV) {
                        layoutParams.width = this.zfV;
                        bVar.ywe.setLayoutParams(layoutParams);
                    }
                } else if (layoutParams.width != this.zfU) {
                    layoutParams.width = this.zfU;
                    bVar.ywe.setLayoutParams(layoutParams);
                }
                x.v("MicroMsg.SettingCheckUnProcessWalletConvUI", "layout update time width %d", Integer.valueOf(layoutParams.width));
                bVar.ywe.setText(aVar.zgd);
                bVar.ywf.setText(aVar.zge);
                if (aVar.tYt && aVar.zgm) {
                    bVar.ywg.setVisibility(0);
                } else if (aVar.zgj) {
                    bVar.ywg.setVisibility(0);
                } else {
                    bVar.ywg.setVisibility(8);
                }
                com.tencent.mm.pluginsdk.ui.a.b.a(bVar.ikK, str);
                if (!aVar.zgi && aVar.ywa && as.Hp()) {
                    as.Hm();
                    c.Fk().f(GM);
                }
                if (!aVar.ywa || GM.field_conversationTime == -1) {
                    view.findViewById(R.h.bYZ).setBackgroundResource(R.g.bBy);
                } else {
                    view.findViewById(R.h.bYZ).setBackgroundResource(R.g.bBx);
                }
                bVar.ywh.setVisibility(8);
            }
            return view;
        }

        private static int wv(String str) {
            int i = 1;
            if (str == null || str.length() <= 0) {
                return i;
            }
            try {
                return Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
                return i;
            }
        }

        private CharSequence h(ae aeVar) {
            if (aeVar.field_status == 1) {
                return SettingCheckUnProcessWalletConvUI.this.getString(R.l.euN);
            }
            return aeVar.field_conversationTime == Long.MAX_VALUE ? "" : com.tencent.mm.pluginsdk.h.n.c(SettingCheckUnProcessWalletConvUI.this, aeVar.field_conversationTime, true);
        }

        private CharSequence c(ae aeVar, int i, boolean z) {
            CharSequence replace;
            if (t.oN(aeVar.field_editingMsg) || (aeVar.field_atCount > 0 && aeVar.field_unReadCount > 0)) {
                CharSequence charSequence = aeVar.field_digest;
                if (charSequence != null && charSequence.startsWith("<img src=\"original_label.png\"/>  ")) {
                    return new SpannableString(i.e(SettingCheckUnProcessWalletConvUI.this, charSequence, (float) i));
                }
                int i2;
                String str;
                String str2 = aeVar.field_username;
                if (str2.equals("qqmail")) {
                    as.Hm();
                    if (t.e((Integer) c.Db().get(17, null)) == 1) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 == 0) {
                        return SettingCheckUnProcessWalletConvUI.this.getString(R.l.eMI);
                    }
                }
                if (str2.equals("tmessage")) {
                    as.Hm();
                    bc FE = c.Fn().FE("@t.qq.com");
                    if (FE == null || !FE.isEnable()) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                    }
                    if (i2 == 0) {
                        return SettingCheckUnProcessWalletConvUI.this.getString(R.l.eMI);
                    }
                }
                if (aeVar.field_msgType != null && (aeVar.field_msgType.equals("47") || aeVar.field_msgType.equals("1048625"))) {
                    str2 = ZD(aeVar.field_digest);
                    str = "";
                    if (str2 != null) {
                        return "[" + str2 + "]";
                    }
                    if (aeVar.field_digest != null && aeVar.field_digest.contains(":")) {
                        str = aeVar.field_digest.substring(0, aeVar.field_digest.indexOf(":"));
                        str2 = ZD(aeVar.field_digest.substring(aeVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                        if (str2 != null) {
                            str2 = "[" + str2 + "]";
                            return t.oN(str) ? str2 : str + ": " + str2;
                        }
                    }
                    str2 = SettingCheckUnProcessWalletConvUI.this.getString(R.l.dER);
                    aeVar.dH(t.oN(str) ? str2 : str + ": " + str2);
                }
                if (!t.oN(aeVar.field_digest)) {
                    if (t.oN(aeVar.field_digestUser)) {
                        str = aeVar.field_digest;
                    } else {
                        str = (aeVar.field_isSend == 0 && com.tencent.mm.y.s.eX(aeVar.field_username)) ? r.L(aeVar.field_digestUser, aeVar.field_username) : r.gw(aeVar.field_digestUser);
                        try {
                            str = String.format(aeVar.field_digest, new Object[]{str});
                        } catch (Exception e) {
                        }
                    }
                    replace = str.replace(10, ' ');
                    if (aeVar.field_atCount > 0 || aeVar.field_unReadCount <= 0) {
                        if (!z && aeVar.field_unReadCount > 1) {
                            replace = SettingCheckUnProcessWalletConvUI.this.getString(R.l.eut, new Object[]{Integer.valueOf(aeVar.field_unReadCount), replace});
                        } else if (aeVar.field_unReadCount > 1 && com.tencent.mm.y.s.hg(aeVar.field_parentRef)) {
                            replace = SettingCheckUnProcessWalletConvUI.this.getString(R.l.eut, new Object[]{Integer.valueOf(aeVar.field_unReadCount), replace});
                        }
                        return i.c(SettingCheckUnProcessWalletConvUI.this, replace, i);
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(R.l.euq));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                    spannableStringBuilder.append(" ").append(i.c(SettingCheckUnProcessWalletConvUI.this, replace, i));
                    return spannableStringBuilder;
                }
                str = h.a(aeVar.field_isSend, aeVar.field_username, aeVar.field_content, wv(aeVar.field_msgType), SettingCheckUnProcessWalletConvUI.this);
                replace = str.replace(10, ' ');
                if (aeVar.field_atCount > 0) {
                }
                if (!z) {
                }
                replace = SettingCheckUnProcessWalletConvUI.this.getString(R.l.eut, new Object[]{Integer.valueOf(aeVar.field_unReadCount), replace});
                return i.c(SettingCheckUnProcessWalletConvUI.this, replace, i);
            }
            replace = new SpannableStringBuilder(SettingCheckUnProcessWalletConvUI.this.getString(R.l.euu));
            replace.setSpan(new ForegroundColorSpan(-5569532), 0, replace.length(), 33);
            replace.append(" ").append(i.c(SettingCheckUnProcessWalletConvUI.this, aeVar.field_editingMsg, i));
            return replace;
        }

        private static String ZD(String str) {
            if (str == null || str.length() != 32) {
                return null;
            }
            return ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().yF(str);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setMMTitle(R.l.eWy);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingCheckUnProcessWalletConvUI.this.finish();
                return false;
            }
        });
        this.kLX = (ListView) findViewById(R.h.bYY);
        this.zjl = getIntent().getStringArrayListExtra("key_conversation_list");
        if (this.zjl != null && this.zjl.size() > 0) {
            this.zjm = new a();
            this.kLX.setAdapter(this.zjm);
            this.kLX.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            SettingCheckUnProcessWalletConvUI.this.aWY();
                            SettingCheckUnProcessWalletConvUI.this.zgs[0] = (int) motionEvent.getRawX();
                            SettingCheckUnProcessWalletConvUI.this.zgs[1] = (int) motionEvent.getRawY();
                            break;
                    }
                    return false;
                }
            });
            this.kLX.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    ak GM = SettingCheckUnProcessWalletConvUI.this.zjm.GM(i);
                    if (GM != null) {
                        Intent intent = new Intent();
                        intent.putExtra("Chat_User", GM.field_username);
                        intent.putExtra("chat_from_scene", 4);
                        d.a(SettingCheckUnProcessWalletConvUI.this, ".ui.chatting.ChattingUI", intent);
                    }
                }
            });
            this.kLX.setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    final ak GM = SettingCheckUnProcessWalletConvUI.this.zjm.GM(i - SettingCheckUnProcessWalletConvUI.this.kLX.getHeaderViewsCount());
                    if (GM == null) {
                        return true;
                    }
                    final String str = GM.field_username;
                    com.tencent.mm.ui.widget.i iVar = new com.tencent.mm.ui.widget.i(SettingCheckUnProcessWalletConvUI.this);
                    iVar.zDq = new OnCreateContextMenuListener() {
                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                            contextMenu.add(0, 1, 0, R.l.euC);
                        }
                    };
                    iVar.a(view, i, j, SettingCheckUnProcessWalletConvUI.this, new p.d() {
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                            if (menuItem.getItemId() == 1) {
                                b.a(str, SettingCheckUnProcessWalletConvUI.this, GM, new Runnable() {
                                    public final void run() {
                                        SettingCheckUnProcessWalletConvUI.this.zjl.remove(str);
                                        SettingCheckUnProcessWalletConvUI.this.zjm.notifyDataSetChanged();
                                    }
                                }, false, true);
                            }
                        }
                    }, SettingCheckUnProcessWalletConvUI.this.zgs[0], SettingCheckUnProcessWalletConvUI.this.zgs[1]);
                    return true;
                }
            });
        }
    }

    protected final int getLayoutId() {
        return R.i.dsc;
    }
}
