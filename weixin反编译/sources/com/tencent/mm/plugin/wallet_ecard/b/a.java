package com.tencent.mm.plugin.wallet_ecard.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.ad.k;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.wallet.balance.a.a.q;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardCheckOtherCardUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenECardProxyUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenLqbProxyUI;
import com.tencent.mm.protocal.c.avv;
import com.tencent.mm.protocal.c.fc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class a extends com.tencent.mm.wallet_core.c {

    private class a extends com.tencent.mm.wallet_core.d.g {
        public a(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        public final boolean k(Object... objArr) {
            String str = (String) objArr[0];
            String str2 = (String) objArr[1];
            a.this.mym.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tfK, str);
            a.this.mym.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tfL, str2);
            this.zRf.a(new t("", str, null), true);
            return true;
        }

        public final boolean d(int i, int i2, String str, k kVar) {
            Bundle bundle;
            if (kVar instanceof t) {
                t tVar = (t) kVar;
                if (i == 0 && i2 == 0) {
                    bundle = new Bundle();
                    if (tVar.sOS == null || !tVar.sOS.sSG) {
                        bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tfQ, true);
                        a.this.a(this.zRe, 0, bundle);
                        return false;
                    }
                    String string = a.this.mym.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tfK);
                    String string2 = a.this.mym.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tfL);
                    String str2 = tVar.sOS.pff;
                    a.this.mym.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tfM, str2);
                    this.zRf.jl(Exif.PARSE_EXIF_ERROR_CORRUPT);
                    this.zRf.a(new com.tencent.mm.plugin.wallet_ecard.a.d(a.b(a.this), a.this.bNY(), string, string2, str2, a.this.bNZ(), false), true);
                    return false;
                }
                x.w("MicroMsg.OpenECardProcess", "net error: %s", tVar);
                h.b(this.zRe, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.zRe, str), "", false);
                return false;
            } else if (!(kVar instanceof com.tencent.mm.plugin.wallet_ecard.a.d)) {
                return false;
            } else {
                this.zRf.jm(Exif.PARSE_EXIF_ERROR_CORRUPT);
                k kVar2 = (com.tencent.mm.plugin.wallet_ecard.a.d) kVar;
                if (i != 0 || i2 != 0) {
                    x.w("MicroMsg.OpenECardProcess", "net error: %s", kVar2);
                    h.b(this.zRe, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.zRe, str), "", false);
                } else if (kVar2.tfZ.kRz == 0) {
                    bundle = new Bundle();
                    bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tfQ, false);
                    if (kVar2.tfZ.vSD == null || bi.oN(kVar2.tfZ.vSD.title)) {
                        x.i("MicroMsg.OpenECardProcess", "need verfiy sms");
                        bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tfP, true);
                        bundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tfN, kVar2.tfZ.vSB);
                        bundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tfO, kVar2.tfZ.wJS);
                    } else {
                        x.i("MicroMsg.OpenECardProcess", "no need verify sms");
                        bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tfP, false);
                        a.this.mym.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tfS, kVar2.tfZ.vSD.title);
                    }
                    a.this.a(this.zRe, 0, bundle);
                } else if (!(com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.zRe, kVar2.tfZ.vSC) || com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.zRe, kVar2, kVar2.lot, kVar2.lou, kVar2.tfZ.kRz, kVar2.tfZ.kRA))) {
                    h.b(this.zRe, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.zRe, kVar2.tfZ.kRA, kVar2.lou, str), "", false);
                }
                return true;
            }
        }
    }

    private class d extends com.tencent.mm.wallet_core.d.g {
        public d(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        public final boolean k(Object... objArr) {
            fc fcVar = (fc) objArr[0];
            String string = a.this.mym.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tfC, "");
            if (fcVar == null) {
                x.w("MicroMsg.OpenECardProcess", "empty bank item");
                return false;
            }
            this.zRf.jl(Exif.PARSE_EXIF_ERROR_CORRUPT);
            this.zRf.a(new com.tencent.mm.plugin.wallet_ecard.a.d(a.b(a.this), string, fcVar.vRA, fcVar.sOP, fcVar.pff, a.this.bNZ(), true), true);
            return true;
        }

        public final boolean d(int i, int i2, String str, k kVar) {
            if (!(kVar instanceof com.tencent.mm.plugin.wallet_ecard.a.d)) {
                return false;
            }
            this.zRf.jm(Exif.PARSE_EXIF_ERROR_CORRUPT);
            k kVar2 = (com.tencent.mm.plugin.wallet_ecard.a.d) kVar;
            if (i != 0 || i2 != 0) {
                x.w("MicroMsg.OpenECardProcess", "net error: %s", kVar2);
                h.b(this.zRe, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.zRe, str), "", false);
            } else if (kVar2.tfZ.kRz == 0) {
                a.this.mym.putInt(com.tencent.mm.plugin.wallet_ecard.a.a.tfE, com.tencent.mm.plugin.wallet_ecard.a.a.tfT);
                a.this.mym.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tfH, kVar2.tga);
                a.this.mym.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tfI, kVar2.tgb);
                a.this.mym.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tfJ, kVar2.tgc);
                Bundle bundle = new Bundle();
                if (kVar2.tfZ.vSD == null || bi.oN(kVar2.tfZ.vSD.title)) {
                    x.i("MicroMsg.OpenECardProcess", "need verfiy sms");
                    bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tfP, true);
                    bundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tfN, kVar2.tfZ.vSB);
                    bundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tfO, kVar2.tfZ.wJS);
                } else {
                    x.i("MicroMsg.OpenECardProcess", "no need verify sms");
                    bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tfP, false);
                    a.this.mym.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tfS, kVar2.tfZ.vSD.title);
                }
                a.this.a(this.zRe, 0, bundle);
            } else if (!(com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.zRe, kVar2.tfZ.vSC) || com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.zRe, kVar2, kVar2.lot, kVar2.lou, kVar2.tfZ.kRz, kVar2.tfZ.kRA))) {
                h.b(this.zRe, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.zRe, kVar2.tfZ.kRA, kVar2.lou, str), "", false);
            }
            return true;
        }
    }

    private class e extends com.tencent.mm.wallet_core.d.g {
        public e(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        public final boolean k(Object... objArr) {
            String str = ((ElementQuery) objArr[0]).pff;
            String string = a.this.mym.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tfK);
            String string2 = a.this.mym.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tfL);
            this.zRf.jl(Exif.PARSE_EXIF_ERROR_CORRUPT);
            this.zRf.a(new com.tencent.mm.plugin.wallet_ecard.a.d(a.b(a.this), a.this.bNY(), string, string2, str, a.this.bNZ(), false), true);
            return true;
        }

        public final boolean d(int i, int i2, String str, k kVar) {
            if (!(kVar instanceof com.tencent.mm.plugin.wallet_ecard.a.d)) {
                return false;
            }
            this.zRf.jm(Exif.PARSE_EXIF_ERROR_CORRUPT);
            k kVar2 = (com.tencent.mm.plugin.wallet_ecard.a.d) kVar;
            if (i != 0 || i2 != 0) {
                x.w("MicroMsg.OpenECardProcess", "net error: %s", kVar2);
                h.b(this.zRe, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.zRe, str), "", false);
            } else if (kVar2.tfZ.kRz == 0) {
                Bundle bundle = new Bundle();
                if (kVar2.tfZ.vSD == null || bi.oN(kVar2.tfZ.vSD.title)) {
                    x.i("MicroMsg.OpenECardProcess", "need verfiy sms");
                    bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tfP, true);
                    bundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tfN, kVar2.tfZ.vSB);
                    bundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tfO, kVar2.tfZ.wJS);
                } else {
                    x.i("MicroMsg.OpenECardProcess", "no need verify sms");
                    bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tfP, false);
                    a.this.mym.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tfS, kVar2.tfZ.vSD.title);
                }
                a.this.a(this.zRe, 0, bundle);
            } else if (!(com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.zRe, kVar2.tfZ.vSC) || com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.zRe, kVar2, kVar2.lot, kVar2.lou, kVar2.tfZ.kRz, kVar2.tfZ.kRA))) {
                h.b(this.zRe, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.zRe, kVar2.tfZ.kRA, kVar2.lou, str), "", false);
            }
            return true;
        }
    }

    private class f extends com.tencent.mm.wallet_core.d.g {
        public f(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        public final boolean k(Object... objArr) {
            ((Integer) objArr[0]).intValue();
            String str = (String) objArr[1];
            this.zRf.jl(2996);
            this.zRf.a(new q(a.b(a.this), str), true);
            return false;
        }

        public final boolean d(int i, int i2, String str, k kVar) {
            if (!(kVar instanceof q)) {
                return false;
            }
            x.i("MicroMsg.OpenECardProcess", "openLqbAccount scene end, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
            q qVar = (q) kVar;
            if (i == 0 && i2 == 0) {
                avv avv = qVar.sFj;
                if (avv.kRz == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("key_account_type", 2);
                    com.tencent.mm.bl.d.b(this.zRe, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", intent);
                } else {
                    Toast.makeText(this.zRe, avv.kRA, 1).show();
                }
            } else {
                x.w("MicroMsg.OpenECardProcess", "net error: %s", kVar);
                h.b(this.zRe, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.zRe, str), "", false);
            }
            this.zRe.finish();
            a.this.b(this.zRe, new Bundle());
            return true;
        }
    }

    private class c extends com.tencent.mm.wallet_core.d.g {
        public c(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        public final boolean k(Object... objArr) {
            int intValue = ((Integer) objArr[0]).intValue();
            String str = (String) objArr[1];
            this.zRf.jl(1958);
            this.zRf.a(new com.tencent.mm.plugin.wallet_ecard.a.e(a.b(a.this), null, intValue, str), true);
            return true;
        }

        public final boolean d(int i, int i2, String str, k kVar) {
            if (!(kVar instanceof com.tencent.mm.plugin.wallet_ecard.a.e)) {
                return false;
            }
            this.zRf.jm(1958);
            k kVar2 = (com.tencent.mm.plugin.wallet_ecard.a.e) kVar;
            if (i != 0 || i2 != 0) {
                x.w("MicroMsg.OpenECardProcess", "net error: %s", kVar2);
                h.a(this.zRe, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.zRe, str), "", false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        a.this.b(c.this.zRe, null);
                    }
                });
            } else if (kVar2.tgd.kRz == 0) {
                Bundle bundle = new Bundle();
                x.i("MicroMsg.OpenECardProcess", "req_serial: %s", kVar2.tgd.vSA);
                a.this.mym.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tfC, kVar2.tgd.vSA);
                x.i("MicroMsg.OpenECardProcess", "authScene.token: %s, is_token_invalid: %s", kVar2.token, Boolean.valueOf(kVar2.tgd.wJO));
                if (!bi.oN(kVar2.token)) {
                    bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tfD, kVar2.tgd.wJO);
                }
                a.this.a(this.zRe, 0, bundle);
            } else if (!(com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.zRe, kVar2.tgd.vSC) || com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.zRe, kVar2, kVar2.lot, kVar2.lou, kVar2.tgd.kRz, kVar2.tgd.kRA))) {
                h.a(this.zRe, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.zRe, kVar2.tgd.kRA, kVar2.lou, str), "", false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        a.this.b(c.this.zRe, null);
                    }
                });
            }
            this.zRe.finish();
            return true;
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            x.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
            Bundle bundle = new Bundle();
            bundle.putInt("key_process_result_code", 0);
            a.this.b(this.zRe, bundle);
        }
    }

    private class b extends com.tencent.mm.wallet_core.d.g {
        public b(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        public final boolean k(Object... objArr) {
            String str = (String) objArr[0];
            int i = a.this.mym.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.tfA);
            this.zRf.jl(1958);
            this.zRf.a(new com.tencent.mm.plugin.wallet_ecard.a.e(a.b(a.this), str, i, null), true);
            a.this.mym.putString("key_pwd1", str);
            return true;
        }

        public final boolean d(int i, int i2, String str, k kVar) {
            if (!(kVar instanceof com.tencent.mm.plugin.wallet_ecard.a.e)) {
                return false;
            }
            this.zRf.jm(1958);
            k kVar2 = (com.tencent.mm.plugin.wallet_ecard.a.e) kVar;
            if (i != 0 || i2 != 0) {
                x.w("MicroMsg.OpenECardProcess", "net error: %s", kVar2);
                h.a(this.zRe, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.zRe, str), "", false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        a.this.b(b.this.zRe, null);
                    }
                });
            } else if (kVar2.tgd.kRz == 0) {
                Bundle bundle = new Bundle();
                x.i("MicroMsg.OpenECardProcess", "req_serial: %s", kVar2.tgd.vSA);
                a.this.mym.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tfC, kVar2.tgd.vSA);
                a.this.a(this.zRe, 0, bundle);
            } else if (!(com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.zRe, kVar2.tgd.vSC) || com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.zRe, kVar2, kVar2.lot, kVar2.lou, kVar2.tgd.kRz, kVar2.tgd.kRA))) {
                h.a(this.zRe, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.zRe, kVar2.tgd.kRA, kVar2.lou, str), "", false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        a.this.b(b.this.zRe, null);
                    }
                });
            }
            return true;
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            x.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
            Bundle bundle = new Bundle();
            bundle.putInt("key_process_result_code", 0);
            a.this.b(this.zRe, bundle);
        }
    }

    private class g extends com.tencent.mm.wallet_core.d.g {
        public g(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        public final CharSequence uE(int i) {
            return this.zRe.getIntent().getStringExtra(com.tencent.mm.plugin.wallet_ecard.a.a.tfO);
        }

        public final boolean q(Object... objArr) {
            k dVar;
            int i = a.this.mym.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.tfE);
            String n = a.this.bNY();
            x.i("MicroMsg.OpenECardProcess", "bind action: %s", Integer.valueOf(i));
            if (i == com.tencent.mm.plugin.wallet_ecard.a.a.tfT) {
                dVar = new com.tencent.mm.plugin.wallet_ecard.a.d(a.b(a.this), n, a.this.mym.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tfH), a.this.mym.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tfI), a.this.mym.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tfJ), a.this.bNZ(), true, true);
            } else {
                dVar = new com.tencent.mm.plugin.wallet_ecard.a.d(a.b(a.this), n, a.this.mym.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tfK), a.this.mym.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tfL), a.this.mym.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tfM), a.this.bNZ(), false, true);
            }
            this.zRf.jl(Exif.PARSE_EXIF_ERROR_CORRUPT);
            this.zRf.a(dVar, true);
            return true;
        }

        public final boolean k(Object... objArr) {
            a.this.mym.getString("key_pwd1");
            String string = a.this.mym.getString("key_verify_code");
            String n = a.this.bNY();
            int i = a.this.mym.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.tfA);
            k cVar = new com.tencent.mm.plugin.wallet_ecard.a.c(a.b(a.this), n, string, this.zRe.getIntent().getStringExtra(com.tencent.mm.plugin.wallet_ecard.a.a.tfN), i);
            this.zRf.jl(1986);
            this.zRf.a(cVar, true, 3);
            return true;
        }

        public final boolean d(int i, int i2, String str, k kVar) {
            if (kVar instanceof com.tencent.mm.plugin.wallet_ecard.a.c) {
                this.zRf.jm(1986);
                com.tencent.mm.plugin.wallet_ecard.a.c cVar = (com.tencent.mm.plugin.wallet_ecard.a.c) kVar;
                if (i == 0 && i2 == 0) {
                    if (cVar.tfY.kRz == 0) {
                        Bundle bundle = new Bundle();
                        if (!(cVar.tfY.vSD == null || bi.oN(cVar.tfY.vSD.title))) {
                            x.i("MicroMsg.OpenECardProcess", "succ title: %s", cVar.tfY.vSD.title);
                            a.this.mym.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tfS, cVar.tfY.vSD.title);
                        }
                        a.this.a(this.zRe, 0, bundle);
                    } else if (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.zRe, cVar.tfY.vSC)) {
                        h.b(this.zRe, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.zRe, cVar.tfY.kRA, str), "", false);
                    }
                }
                return true;
            } else if (!(kVar instanceof com.tencent.mm.plugin.wallet_ecard.a.d)) {
                return false;
            } else {
                this.zRf.jm(Exif.PARSE_EXIF_ERROR_CORRUPT);
                k kVar2 = (com.tencent.mm.plugin.wallet_ecard.a.d) kVar;
                if (i != 0 || i2 != 0) {
                    x.w("MicroMsg.OpenECardProcess", "net error: %s", kVar2);
                    h.b(this.zRe, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.zRe, str), "", false);
                } else if (kVar2.tfZ.kRz == 0) {
                    this.zRe.getIntent().putExtra(com.tencent.mm.plugin.wallet_ecard.a.a.tfN, kVar2.tfZ.vSB);
                } else if (!(com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.zRe, kVar2.tfZ.vSC) || com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.zRe, kVar2, kVar2.lot, kVar2.lou, kVar2.tfZ.kRz, kVar2.tfZ.kRA))) {
                    h.b(this.zRe, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.zRe, kVar2.tfZ.kRA, kVar2.lou, str), "", false);
                }
                return true;
            }
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            x.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
            a.this.b(this.zRe, new Bundle());
            super.onActivityResult(i, i2, intent);
        }
    }

    static /* synthetic */ String b(a aVar) {
        String string = aVar.mym.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tfF);
        return bi.oN(string) ? "WEB_DEBIT" : string;
    }

    public final com.tencent.mm.wallet_core.c a(Activity activity, Bundle bundle) {
        c(activity, WalletOpenECardProxyUI.class, bundle);
        x.i("MicroMsg.OpenECardProcess", "start open ecard: %s", Integer.valueOf(bNZ()));
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            c(activity, WalletECardBindCardListUI.class, null);
        } else if (activity instanceof WalletECardBindCardListUI) {
            if (this.mym.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.tfE, com.tencent.mm.plugin.wallet_ecard.a.a.tfT) != com.tencent.mm.plugin.wallet_ecard.a.a.tfT) {
                c(activity, WalletECardCheckOtherCardUI.class, null);
            } else if (bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tfP)) {
                bundle.putBoolean("key_need_confirm_finish", true);
                b(activity, WalletVerifyCodeUI.class, bundle);
            } else {
                g(activity, bundle);
            }
        } else if (activity instanceof WalletVerifyCodeUI) {
            g(activity, bundle);
        } else if (activity instanceof WalletECardCheckOtherCardUI) {
            x.i("MicroMsg.OpenECardProcess", "input card elem: %s, verify sms: %s", Boolean.valueOf(bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tfQ, false)), Boolean.valueOf(bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tfP)));
            if (bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tfQ, false)) {
                c(activity, WalletECardElementInputUI.class, null);
            } else if (r1) {
                bundle.putBoolean("key_need_confirm_finish", true);
                b(activity, WalletVerifyCodeUI.class, bundle);
            } else {
                g(activity, bundle);
            }
        } else if (activity instanceof WalletECardElementInputUI) {
            if (bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tfP)) {
                bundle.putBoolean("key_need_confirm_finish", true);
                b(activity, WalletVerifyCodeUI.class, bundle);
                return;
            }
            g(activity, bundle);
        } else if (activity instanceof WalletOpenECardProxyUI) {
            boolean z = bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tfD, false);
            this.mym.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tfD, z);
            String string = this.mym.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tfB);
            x.i("MicroMsg.OpenECardProcess", "forward openScene: %s, token==null: %s, isTokenInvalid: %s", Integer.valueOf(bNZ()), Boolean.valueOf(bi.oN(string)), Boolean.valueOf(z));
            if (bi.oN(string)) {
                a(activity, WalletCheckPwdUI.class, bundle, 1);
            } else if (z) {
                c(activity, WalletCheckPwdUI.class, bundle);
            } else if (r2 == 3) {
                c(activity, WalletECardBindCardListUI.class, null);
            }
        }
    }

    private void g(Activity activity, Bundle bundle) {
        x.k("MicroMsg.OpenECardProcess", "gotoFinishUI, openScene: %s", Integer.valueOf(bNZ()));
        if (bNZ() == 3) {
            bundle.putInt(com.tencent.mm.plugin.wallet_ecard.a.a.tfA, 3);
            bundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tfG, this.mym.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tfG, ""));
            c(activity, WalletOpenLqbProxyUI.class, bundle);
            return;
        }
        c(activity, WalletECardFinishUI.class, null);
    }

    public final void d(Activity activity, int i) {
        if (i == 100) {
            x.i("MicroMsg.OpenECardProcess", "back to card list");
            int bNZ = bNZ();
            String bNY = bNY();
            String str = (String) this.mym.get("key_pwd1");
            this.mym.clear();
            this.mym.putInt(com.tencent.mm.plugin.wallet_ecard.a.a.tfA, bNZ);
            this.mym.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tfC, bNY);
            this.mym.putString("key_pwd1", str);
            a(activity, WalletECardBindCardListUI.class, 0);
        } else if (!(activity instanceof WalletVerifyCodeUI)) {
        } else {
            if (this.mym.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.tfE) == com.tencent.mm.plugin.wallet_ecard.a.a.tfT) {
                a(activity, WalletECardBindCardListUI.class, 0);
            } else {
                a(activity, WalletECardCheckOtherCardUI.class, 0);
            }
        }
    }

    public final void b(Activity activity, Bundle bundle) {
        x.i("MicroMsg.OpenECardProcess", "end process: %s", activity);
        if (bundle == null) {
            bundle = new Bundle();
        }
        Intent intent = new Intent(activity, WalletOpenECardProxyUI.class);
        intent.putExtras(bundle);
        Activity activity2 = activity;
        a(activity2, WalletOpenECardProxyUI.class, bundle.getInt("key_process_result_code", -1), intent, true);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String aLn() {
        return "OpenECardProcess";
    }

    public final int b(MMActivity mMActivity, int i) {
        return com.tencent.mm.plugin.wxpay.a.i.uPH;
    }

    public final boolean h(Activity activity, Bundle bundle) {
        x.d("MicroMsg.OpenECardProcess", "intercept");
        bundle.putInt("key_process_result_code", 0);
        return super.h(activity, bundle);
    }

    private String bNY() {
        return this.mym.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tfC);
    }

    private int bNZ() {
        return this.mym.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.tfA);
    }

    public final com.tencent.mm.wallet_core.d.g a(MMActivity mMActivity, i iVar) {
        if (mMActivity instanceof WalletCheckPwdUI) {
            return new b(mMActivity, iVar);
        }
        if (mMActivity instanceof WalletVerifyCodeUI) {
            return new g(mMActivity, iVar);
        }
        if (mMActivity instanceof WalletECardBindCardListUI) {
            return new d(mMActivity, iVar);
        }
        if (mMActivity instanceof WalletECardCheckOtherCardUI) {
            return new a(mMActivity, iVar);
        }
        if (mMActivity instanceof WalletECardElementInputUI) {
            return new e(mMActivity, iVar);
        }
        if (mMActivity instanceof WalletOpenECardProxyUI) {
            return new c(mMActivity, iVar);
        }
        if (mMActivity instanceof WalletOpenLqbProxyUI) {
            return new f(mMActivity, iVar);
        }
        return super.a(mMActivity, iVar);
    }
}
