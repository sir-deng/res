package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.f.a.qr;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.k;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p.d;
import com.tencent.mm.ui.o;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.io.File;

public class ShakeItemListUI extends MMActivity {
    private com.tencent.mm.ap.a.a hEr = null;
    private int id;
    private View jRL;
    private d kHD = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            m.bsm().wr(ShakeItemListUI.this.id);
        }
    };
    private ListView oUg;
    public long qwC = 0;
    private boolean qwD = false;
    private a qwE;
    private int showType;

    class a extends o<com.tencent.mm.plugin.shake.b.d> {
        b hxF = new b(new com.tencent.mm.ui.applet.b.a() {
            public final Bitmap la(String str) {
                return com.tencent.mm.ac.b.a(str, false, -1);
            }
        });
        private b.b hxG = null;
        private int showType = 0;

        class a {
            ImageView hxJ;
            TextView hxK;
            TextView hxL;
            TextView oUC;
            TextView oUD;
            ImageView oUE;
            View qwJ;
            ImageView qwK;
            TextView qwL;
            LinearLayout qwM;
            TextView qwN;

            a() {
            }

            public final void clear() {
                if (this.hxJ != null) {
                    this.hxJ.setImageDrawable(null);
                    this.hxJ.setVisibility(8);
                }
                if (this.hxK != null) {
                    this.hxK.setText("");
                    this.hxK.setVisibility(8);
                }
                if (this.hxL != null) {
                    this.hxL.setVisibility(8);
                }
                if (this.qwK != null) {
                    this.qwK.setVisibility(8);
                }
                if (this.oUC != null) {
                    this.oUC.setText("");
                    this.oUC.setVisibility(8);
                }
                if (this.oUD != null) {
                    this.oUD.setVisibility(8);
                    this.qwJ.setVisibility(8);
                }
                if (this.oUE != null) {
                    this.oUE.setVisibility(8);
                }
                if (this.qwL != null) {
                    this.qwL.setText("");
                    this.qwL.setVisibility(8);
                }
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            com.tencent.mm.plugin.shake.b.d dVar = (com.tencent.mm.plugin.shake.b.d) obj;
            if (dVar == null) {
                dVar = new com.tencent.mm.plugin.shake.b.d();
            }
            if (cursor != null) {
                dVar.b(cursor);
            }
            return dVar;
        }

        public a(ShakeItemListUI shakeItemListUI) {
            super(shakeItemListUI, new com.tencent.mm.plugin.shake.b.d());
            XI();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (this.hxG == null) {
                this.hxG = new b.b() {
                    public final String hF(int i) {
                        if (i < 0 || i >= a.this.getCount()) {
                            x.e("MicroMsg.ShakeFriendAdapter", "pos is invalid");
                            return null;
                        }
                        com.tencent.mm.plugin.shake.b.d dVar = (com.tencent.mm.plugin.shake.b.d) a.this.getItem(i);
                        return dVar == null ? null : dVar.field_username;
                    }

                    public final int NP() {
                        return a.this.getCount();
                    }
                };
            }
            if (this.hxF != null) {
                this.hxF.a(i, this.hxG);
            }
            if (view == null) {
                aVar = new a();
                view = View.inflate(this.context, R.i.dsz, null);
                aVar.hxJ = (ImageView) view.findViewById(R.h.cyW);
                aVar.hxK = (TextView) view.findViewById(R.h.czc);
                aVar.hxL = (TextView) view.findViewById(R.h.cyZ);
                aVar.qwK = (ImageView) view.findViewById(R.h.cze);
                aVar.oUC = (TextView) view.findViewById(R.h.cyX);
                aVar.oUD = (TextView) view.findViewById(R.h.czf);
                aVar.oUE = (ImageView) view.findViewById(R.h.czh);
                aVar.qwL = (TextView) view.findViewById(R.h.cNy);
                aVar.qwJ = view.findViewById(R.h.cIm);
                aVar.qwM = (LinearLayout) view.findViewById(R.h.cMM);
                aVar.qwN = (TextView) view.findViewById(R.h.cMN);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            com.tencent.mm.plugin.shake.b.d dVar = (com.tencent.mm.plugin.shake.b.d) getItem(i);
            if (dVar != null) {
                aVar.clear();
                if (4 == dVar.field_type || (k.ww(dVar.field_type) && 6 != dVar.field_type)) {
                    if (4 != dVar.field_type) {
                        aVar.hxJ.setScaleType(ScaleType.CENTER_CROP);
                    }
                    e.a(aVar.hxJ, dVar.field_sns_bgurl, R.k.dvO, false);
                } else if (11 == dVar.field_type) {
                    ShakeItemListUI.this.hEr.a(dVar.getProvince(), aVar.hxJ);
                } else {
                    com.tencent.mm.pluginsdk.ui.a.b.a(aVar.hxJ, dVar.field_username);
                }
                aVar.hxJ.setVisibility(0);
                if (7 != dVar.field_type && 10 != dVar.field_type && 12 != dVar.field_type && 13 != dVar.field_type && (8 != dVar.field_type || !bi.oN(dVar.field_nickname) || !bi.oN(dVar.field_username))) {
                    aVar.qwN.setVisibility(8);
                    aVar.qwM.setVisibility(0);
                    if (8 == dVar.field_type && bi.oN(dVar.field_nickname)) {
                        dVar.field_nickname = dVar.field_distance;
                        dVar.field_distance = dVar.field_username;
                    }
                    aVar.hxK.setText(i.b(this.context, bi.oM(dVar.field_nickname), aVar.hxK.getTextSize()));
                    aVar.hxK.setVisibility(0);
                    int paddingBottom = view.getPaddingBottom();
                    int paddingTop = view.getPaddingTop();
                    int paddingRight = view.getPaddingRight();
                    int paddingLeft = view.getPaddingLeft();
                    if (dVar.field_insertBatch == 2) {
                        view.setBackgroundDrawable(com.tencent.mm.bu.a.b(this.context, R.g.bBx));
                    } else {
                        view.setBackgroundDrawable(com.tencent.mm.bu.a.b(this.context, R.g.bBy));
                    }
                    view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    switch (dVar.field_type) {
                        case 1:
                        case 2:
                        case 3:
                            aVar.qwL.setText(dVar.field_nickname);
                            aVar.qwL.setVisibility(0);
                            break;
                        default:
                            aVar.qwJ.setVisibility(0);
                            aVar.oUC.setText(dVar.field_distance);
                            aVar.oUC.setVisibility(0);
                            if (dVar.field_signature == null || dVar.field_signature.trim().equals("")) {
                                aVar.oUD.setVisibility(8);
                            } else {
                                aVar.oUD.setVisibility(0);
                                aVar.oUD.setText(i.b(this.context, dVar.field_signature, aVar.hxK.getTextSize()));
                            }
                            if (dVar.field_sex == 1) {
                                aVar.qwK.setVisibility(0);
                                aVar.qwK.setImageDrawable(com.tencent.mm.bu.a.b(this.context, R.k.dyY));
                                aVar.qwK.setContentDescription(this.context.getString(R.l.euP));
                            } else if (dVar.field_sex == 2) {
                                aVar.qwK.setVisibility(0);
                                aVar.qwK.setImageDrawable(com.tencent.mm.bu.a.b(this.context, R.k.dyX));
                                aVar.qwK.setContentDescription(this.context.getString(R.l.ehp));
                            } else {
                                aVar.qwK.setVisibility(8);
                            }
                            as.Hm();
                            ag Xv = c.Ff().Xv(dVar.field_username);
                            if (Xv == null || !com.tencent.mm.k.a.ga(Xv.field_type)) {
                                aVar.hxL.setVisibility(8);
                            } else {
                                aVar.hxL.setVisibility(0);
                                if (com.tencent.mm.storage.x.DG(dVar.field_reserved1)) {
                                    aVar.hxL.setText(this.context.getString(R.l.exs));
                                } else {
                                    aVar.hxL.setText(this.context.getString(R.l.exu));
                                }
                            }
                            if (6 == dVar.field_type) {
                                aVar.oUC.setText(this.context.getString(R.l.eOA));
                                aVar.hxL.setVisibility(8);
                            }
                            if (dVar.field_reserved1 == 0) {
                                aVar.oUE.setVisibility(8);
                                break;
                            }
                            aVar.oUE.setVisibility(0);
                            aVar.oUE.setImageBitmap(BackwardSupportUtil.b.b(com.tencent.mm.y.ak.a.hhx.gP(dVar.field_reserved1), 2.0f));
                            aVar.qwK.setVisibility(8);
                            break;
                            break;
                    }
                }
                if (8 == dVar.field_type) {
                    aVar.qwN.setText(dVar.field_distance);
                } else {
                    aVar.qwN.setText(dVar.field_nickname);
                }
                aVar.qwN.setVisibility(0);
                aVar.qwM.setVisibility(8);
            } else {
                aVar.clear();
            }
            return view;
        }

        protected final void XI() {
            aUU();
            XH();
        }

        public final void XH() {
            if (as.Hp()) {
                switch (this.showType) {
                    case -12:
                        e bsm = m.bsm();
                        int intExtra = ShakeItemListUI.this.getIntent().getIntExtra("_ibeacon_new_insert_size", 2);
                        setCursor(bsm.rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc limit ? ", "11", String.valueOf(intExtra)));
                        break;
                    case -6:
                        setCursor(m.bsm().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", "8", "2"));
                        break;
                    case -5:
                        setCursor(m.bsm().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", "4", "2"));
                        break;
                    case -1:
                        setCursor(m.bsm().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by reserved2 desc, shakeItemID desc ", "0", "2"));
                        break;
                    case 0:
                        setCursor(m.bsm().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", "0"));
                        break;
                    case 4:
                        setCursor(m.bsm().bsb());
                        break;
                    case 5:
                        setCursor(m.bsm().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type in (?, ?, ?, ?, ?) order by shakeItemID desc ", "7", "6", "8", "9", PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT, "12"));
                        break;
                    case 11:
                        setCursor(m.bsm().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", "11"));
                        break;
                    case 100:
                        setCursor(m.bsm().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc ", new String[0]));
                        break;
                }
                super.notifyDataSetChanged();
            }
        }

        protected final void wy(int i) {
            this.showType = i;
            XI();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        m.bsm().c(this.qwE);
        this.qwE.XI();
        x.i("MicroMsg.ShakeItemListUI", "onResume");
    }

    protected final void initView() {
        this.hEr = new com.tencent.mm.ap.a.a((Context) this);
        as.Hm();
        final int a = bi.a((Integer) c.Db().get(12290, null), 0);
        this.showType = getIntent().getIntExtra("_key_show_type_", 0);
        String stringExtra = getIntent().getStringExtra("_key_title_");
        if (!bi.oN(stringExtra)) {
            setMMTitle(stringExtra);
        }
        this.qwD = getIntent().getBooleanExtra("_key_show_from_shake_", false);
        addTextOptionMenu(0, getString(R.l.dEz), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                h.a(ShakeItemListUI.this, true, ShakeItemListUI.this.getString(R.l.eHw), "", ShakeItemListUI.this.getString(R.l.dEz), ShakeItemListUI.this.getString(R.l.dEy), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        switch (ShakeItemListUI.this.showType) {
                            case -12:
                            case 11:
                                m.bsm().ws(11);
                                break;
                            case -6:
                            case 5:
                                m.bsm().ws(7);
                                m.bsm().ws(6);
                                m.bsm().ws(8);
                                m.bsm().ws(9);
                                m.bsm().ws(10);
                                m.bsm().ws(12);
                                break;
                            case -5:
                            case 4:
                                as.Dt().F(new Runnable() {
                                    public final void run() {
                                        com.tencent.mm.a.e.g(new File(i.bsQ()));
                                    }

                                    public final String toString() {
                                        return super.toString() + "|asyncClearMusicData";
                                    }
                                });
                                m.bsm().ws(4);
                                break;
                            case -1:
                            case 0:
                                m.bsm().ws(0);
                                break;
                            case 100:
                                m.bsm().ws(0);
                                m.bsm().bsd();
                                break;
                        }
                        ShakeItemListUI.this.qwE.XH();
                        ShakeItemListUI.this.oUg.setVisibility(8);
                        TextView textView = (TextView) ShakeItemListUI.this.findViewById(R.h.czd);
                        textView.setText(ShakeItemListUI.wz(ShakeItemListUI.this.showType));
                        textView.setVisibility(0);
                        ShakeItemListUI.this.enableOptionMenu(false);
                    }
                }, null);
                return true;
            }
        });
        this.oUg = (ListView) findViewById(R.h.czb);
        this.jRL = getLayoutInflater().inflate(R.i.dsA, null);
        this.jRL.findViewById(R.h.cMK).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ShakeItemListUI.this.showType = ShakeItemListUI.this.showType ^ -1;
                ShakeItemListUI.this.wy(ShakeItemListUI.this.showType);
            }
        });
        this.oUg.addFooterView(this.jRL);
        if (this.showType == -1) {
            this.jRL.findViewById(R.h.cMK).setVisibility(0);
        } else {
            this.jRL.findViewById(R.h.cMK).setVisibility(8);
        }
        this.qwE = new a(this);
        this.qwE.wy(this.showType);
        if (this.qwE.getCount() <= 0) {
            this.oUg.setVisibility(8);
            TextView textView = (TextView) findViewById(R.h.czd);
            textView.setText(wz(this.showType));
            textView.setVisibility(0);
            enableOptionMenu(false);
        } else {
            this.oUg.setAdapter(this.qwE);
            this.oUg.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    com.tencent.mm.plugin.shake.b.d dVar = (com.tencent.mm.plugin.shake.b.d) ShakeItemListUI.this.qwE.getItem(i);
                    if (dVar != null) {
                        e bsm = m.bsm();
                        if (dVar == null) {
                            x.w("MicroMsg.NewShakeItemStorage", "setRead, but item is null");
                        } else {
                            dVar.field_insertBatch = 1;
                            dVar.fEo = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                            if (-1 != bsm.gLA.update("shakeitem1", dVar.vP(), "shakeItemID=? and insertBatch=?", new String[]{dVar.field_shakeItemID, "2"})) {
                                bsm.doNotify();
                            }
                        }
                        int i2 = dVar.field_type;
                        Intent intent;
                        if (i2 == 4) {
                            intent = new Intent();
                            if (com.tencent.mm.au.c.QG()) {
                                com.tencent.mm.au.b.b(com.tencent.mm.plugin.shake.d.a.i.d(dVar.field_lvbuffer, 0));
                            } else {
                                com.tencent.mm.au.b.Qv();
                                intent.putExtra("key_mode", 1);
                                intent.putExtra("KGlobalShakeMusic", true);
                                com.tencent.mm.au.b.c(com.tencent.mm.plugin.shake.d.a.i.d(dVar.field_lvbuffer, 0));
                            }
                            intent.putExtra("key_scene", 3);
                            com.tencent.mm.bl.d.b(ShakeItemListUI.this, "music", ".ui.MusicMainUI", intent);
                        } else if (i2 == 11) {
                            if (System.currentTimeMillis() - ShakeItemListUI.this.qwC > 2000) {
                                ShakeItemListUI.this.qwC = System.currentTimeMillis();
                                if (dVar.field_reserved3 == null || dVar.field_reserved3.split(",").length != 3 || dVar.field_reserved3.split(",")[0] == null || dVar.field_reserved3.split(",")[0].equals("")) {
                                    intent = new Intent();
                                    intent.putExtra("rawUrl", dVar.getCity());
                                    intent.putExtra("scene", 27);
                                    intent.putExtra("stastic_scene", 5);
                                    com.tencent.mm.bl.d.b(ad.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                } else {
                                    String[] split = dVar.field_reserved3.split(",");
                                    com.tencent.mm.sdk.b.b qrVar = new qr();
                                    qrVar.fJd.userName = split[0];
                                    qrVar.fJd.fJf = bi.aD(split[1], "");
                                    qrVar.fJd.fJg = Integer.parseInt(split[2]);
                                    qrVar.fJd.scene = 1077;
                                    com.tencent.mm.sdk.b.a.xmy.m(qrVar);
                                }
                                if (ShakeItemListUI.this.qwD) {
                                    com.tencent.mm.plugin.shake.d.a.h.a(dVar);
                                    com.tencent.mm.plugin.shake.d.a.h.b(dVar);
                                }
                            }
                        } else if (k.ww(i2)) {
                            k.a(dVar, ShakeItemListUI.this, true);
                        } else {
                            String str = dVar.field_username;
                            as.Hm();
                            ag Xv = c.Ff().Xv(str);
                            x.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + str + " display:" + dVar.field_nickname + " position:" + i + " contactName" + Xv.field_username);
                            x.d("MicroMsg.ShakeItemListUI", "isContact:" + com.tencent.mm.k.a.ga(Xv.field_type) + "  contact:" + Xv);
                            if (com.tencent.mm.k.a.ga(Xv.field_type)) {
                                Intent intent2 = new Intent();
                                intent2.putExtra("Contact_User", str);
                                intent2.putExtra("Contact_Scene", a == dVar.field_sex ? 23 : 24);
                                intent2.putExtra("Sns_from_Scene", 22);
                                if (str != null && str.length() > 0) {
                                    if (Xv.ciN()) {
                                        g.pWK.k(10298, dVar.field_username + "," + intent2.getIntExtra("Contact_Scene", 23));
                                        intent2.putExtra("Contact_Scene", 23);
                                    }
                                    com.tencent.mm.plugin.shake.a.ihN.d(intent2, ShakeItemListUI.this);
                                    return;
                                }
                                return;
                            }
                            x.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + str + " display:" + dVar.field_nickname + " position:" + i + " contactName" + Xv.field_username);
                            Intent intent3 = new Intent();
                            intent3.putExtra("Contact_User", dVar.field_username);
                            intent3.putExtra("Contact_Nick", dVar.field_nickname);
                            intent3.putExtra("Contact_Distance", dVar.field_distance);
                            intent3.putExtra("Contact_Signature", dVar.field_signature);
                            intent3.putExtra("Contact_Province", dVar.getProvince());
                            intent3.putExtra("Contact_City", dVar.getCity());
                            intent3.putExtra("Contact_Sex", dVar.field_sex);
                            intent3.putExtra("Contact_IsLBSFriend", true);
                            intent3.putExtra("Contact_VUser_Info", dVar.field_reserved3);
                            intent3.putExtra("Contact_VUser_Info_Flag", dVar.field_reserved1);
                            intent3.putExtra("Contact_Scene", a == dVar.field_sex ? 23 : 24);
                            intent3.putExtra("Sns_from_Scene", 22);
                            intent3.putExtra("Contact_KSnsIFlag", dVar.field_snsFlag);
                            intent3.putExtra("Contact_KSnsBgUrl", dVar.field_sns_bgurl);
                            if ((dVar.field_reserved1 & 8) > 0) {
                                g.pWK.k(10298, dVar.field_username + "," + intent3.getIntExtra("Contact_Scene", 23));
                            }
                            com.tencent.mm.plugin.shake.a.ihN.d(intent3, ShakeItemListUI.this);
                        }
                    }
                }
            });
            final l lVar = new l(this);
            this.oUg.setOnItemLongClickListener(new OnItemLongClickListener() {
                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i < ShakeItemListUI.this.oUg.getHeaderViewsCount()) {
                        x.w("MicroMsg.ShakeItemListUI", "on header view long click, ignore");
                    } else {
                        lVar.a(view, i, j, ShakeItemListUI.this, ShakeItemListUI.this.kHD);
                    }
                    return true;
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                ShakeItemListUI.this.aWY();
                ShakeItemListUI.this.finish();
                return true;
            }
        });
        AnonymousClass6 anonymousClass6 = new View.OnClickListener() {
            public final void onClick(View view) {
                BackwardSupportUtil.c.a(ShakeItemListUI.this.oUg);
            }
        };
        this.oUg.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (ShakeItemListUI.this.qwE != null) {
                    a b = ShakeItemListUI.this.qwE;
                    if (b.hxF != null) {
                        b.hxF.onTouchEvent(motionEvent);
                    }
                }
                return false;
            }
        });
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.id = ((com.tencent.mm.plugin.shake.b.d) this.qwE.getItem(adapterContextMenuInfo.position)).field_shakeItemID;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.dEH);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        this.qwE.aUU();
        a aVar = this.qwE;
        if (aVar.hxF != null) {
            aVar.hxF.detach();
            aVar.hxF = null;
        }
        m.bsm().j(this.qwE);
        x.i("MicroMsg.ShakeItemListUI", "onPause");
        if (this.hEr != null) {
            this.hEr.detach();
        }
        super.onDestroy();
    }

    protected final void wy(int i) {
        this.qwE.wy(i);
        switch (i) {
            case -12:
            case -1:
                if (this.jRL != null) {
                    this.jRL.findViewById(R.h.cMK).setVisibility(0);
                    return;
                }
                return;
            case 0:
            case 11:
                if (this.jRL != null) {
                    this.jRL.findViewById(R.h.cMK).setVisibility(8);
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.dsy;
    }

    public static int wz(int i) {
        switch (i) {
            case -12:
            case 11:
                return R.l.eOE;
            case -6:
            case 5:
                return R.l.ePn;
            case -5:
            case 4:
                return R.l.eOV;
            case -1:
            case 0:
                return R.l.eOy;
            case 100:
                return R.l.eOB;
            default:
                return R.l.eOy;
        }
    }
}
