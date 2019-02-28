package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.bl.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiDestroyInstanceAudio;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.w;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.o;
import com.tencent.mm.y.q;

public class SnsTagPartlyUI extends MMActivity implements e {
    private ListView kLX;
    private a rNi;
    private OnClickListener rNj = new OnClickListener() {
        public final void onClick(View view) {
            if (SnsTagPartlyUI.this.rNi == null) {
                x.e("MicroMsg.SnsTagPartlyUI", "The adapter is null..");
                return;
            }
            Object tag = view.getTag();
            if (tag == null) {
                x.e("MicroMsg.SnsTagPartlyUI", "The tag is null..");
            } else if (tag instanceof Integer) {
                s sVar = (s) SnsTagPartlyUI.this.rNi.getItem(((Integer) tag).intValue());
                SnsTagPartlyUI.this.tipDialog = h.a(SnsTagPartlyUI.this, null, true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                g.Dr();
                g.Dp().gRu.a(new w(sVar.field_tagId, sVar.field_tagName), 0);
            } else {
                x.e("MicroMsg.SnsTagPartlyUI", "The tag is not a instance of Integer.");
            }
        }
    };
    protected r tipDialog = null;

    class a extends o<s> {
        private Context context;
        public boolean rNm = false;

        class a {
            Button lmo;
            TextView rNn;
            TextView rNo;

            a() {
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            s sVar = (s) obj;
            if (sVar == null) {
                sVar = new s();
                x.d("MicroMsg.SnsTagPartlyUI", "new SnsInfo");
            }
            sVar.b(cursor);
            return sVar;
        }

        public a(Context context) {
            super(context, new s());
            this.context = context;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                aVar = new a();
                view = View.inflate(this.context, i.g.qMH, null);
                aVar.rNn = (TextView) view.findViewById(f.qLJ);
                aVar.rNo = (TextView) view.findViewById(f.qLx);
                aVar.lmo = (Button) view.findViewById(f.bBF);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            if (rq(i)) {
                aVar.rNn.setText(j.qSS);
                aVar.rNo.setVisibility(8);
                aVar.lmo.setVisibility(8);
            } else {
                int i2;
                s sVar = (s) getItem(i);
                aVar.rNn.setText(sVar.field_tagName);
                aVar.rNo.setVisibility(0);
                aVar.rNo.setText(" (" + sVar.field_count + ") ");
                Button button = aVar.lmo;
                if (this.rNm) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                button.setVisibility(i2);
                aVar.lmo.setOnClickListener(SnsTagPartlyUI.this.rNj);
                aVar.lmo.setTag(Integer.valueOf(i));
            }
            return view;
        }

        public final void XH() {
            setCursor(ae.bwl().getCursor());
            notifyDataSetChanged();
        }

        protected final void XI() {
            aUU();
            XH();
        }

        protected final int aSm() {
            return 1;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.Dr();
        g.Dp().gRu.a((int) JsApiSetAudioState.CTRL_INDEX, (e) this);
        g.Dr();
        g.Dp().gRu.a((int) JsApiDestroyInstanceAudio.CTRL_INDEX, (e) this);
        initView();
    }

    public void onDestroy() {
        g.Dr();
        g.Dp().gRu.b((int) JsApiSetAudioState.CTRL_INDEX, (e) this);
        g.Dr();
        g.Dp().gRu.b((int) JsApiDestroyInstanceAudio.CTRL_INDEX, (e) this);
        if (this.rNi != null) {
            this.rNi.aUU();
        }
        super.onDestroy();
    }

    public void onResume() {
        super.onResume();
        if (this.rNi != null) {
            this.rNi.a("", null);
        }
    }

    protected final void initView() {
        setMMTitle(j.qPP);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SnsTagPartlyUI.this.finish();
                return true;
            }
        });
        this.kLX = (ListView) findViewById(f.qLy);
        this.kLX.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < SnsTagPartlyUI.this.rNi.getCount() - 1) {
                    Intent intent = new Intent();
                    s sVar = (s) SnsTagPartlyUI.this.rNi.getItem(i);
                    if (sVar != null) {
                        intent.putExtra("k_sns_tag_id", sVar.field_tagId);
                        intent.setClass(SnsTagPartlyUI.this, SnsTagDetailUI.class);
                        SnsTagPartlyUI.this.startActivity(intent);
                        return;
                    }
                    return;
                }
                Intent intent2 = new Intent();
                String FY = q.FY();
                intent2.putExtra("titile", SnsTagPartlyUI.this.getString(j.qPt));
                intent2.putExtra("list_type", 1);
                intent2.putExtra("list_attr", com.tencent.mm.ui.contact.s.p(com.tencent.mm.ui.contact.s.zcz, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
                intent2.putExtra("block_contact", FY);
                d.a(SnsTagPartlyUI.this, ".ui.contact.SelectContactUI", intent2, 1);
            }
        });
        this.rNi = new a(this);
        this.kLX.addFooterView(View.inflate(this, i.g.qNY, null));
        this.kLX.setAdapter(this.rNi);
        addTextOptionMenu(0, getString(j.qSp), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean z;
                a a = SnsTagPartlyUI.this.rNi;
                if (SnsTagPartlyUI.this.rNi.rNm) {
                    z = false;
                } else {
                    z = true;
                }
                a.rNm = z;
                SnsTagPartlyUI.this.updateOptionMenuText(0, SnsTagPartlyUI.this.rNi.rNm ? SnsTagPartlyUI.this.getString(j.dFw) : SnsTagPartlyUI.this.getString(j.qSp));
                SnsTagPartlyUI.this.rNi.notifyDataSetChanged();
                return true;
            }
        });
        this.rNi.xQN = new com.tencent.mm.ui.o.a() {
            public final void XF() {
            }

            public final void XE() {
                boolean z = true;
                SnsTagPartlyUI snsTagPartlyUI = SnsTagPartlyUI.this;
                if (SnsTagPartlyUI.this.rNi.getCount() <= 1) {
                    z = false;
                }
                snsTagPartlyUI.enableOptionMenu(z);
            }
        };
    }

    protected final int getLayoutId() {
        return i.g.qNZ;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        String stringExtra = intent.getStringExtra("Select_Contact");
                        String stringExtra2 = intent.getStringExtra("Select_room_name");
                        if (stringExtra != null) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("k_sns_tag_id", 0);
                            intent2.putExtra("k_sns_tag_name", bi.aD(stringExtra2, ""));
                            intent2.putExtra("k_sns_tag_list", stringExtra);
                            intent2.setClass(this, SnsTagDetailUI.class);
                            startActivity(intent2);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SnsTagPartlyUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
            this.tipDialog = null;
        }
        if (this.rNi != null) {
            this.rNi.a("", null);
        }
    }
}
