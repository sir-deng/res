package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.j.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import java.util.Map;

public final class l {
    private static i ziY = null;

    public static void fT(Context context) {
        if (bi.chp()) {
            String value = g.Af().getValue("NewShowRating");
            if (!bi.oN(value)) {
                Map y = bj.y(value, "ShowRatingNode");
                value = (y == null || y.get(".ShowRatingNode.MinVer") == null) ? "0" : (String) y.get(".ShowRatingNode.MinVer");
                int intValue = Integer.decode(value).intValue();
                value = (y == null || y.get(".ShowRatingNode.MaxVer") == null) ? "0" : (String) y.get(".ShowRatingNode.MaxVer");
                int intValue2 = Integer.decode(value).intValue();
                if (y == null || y.get(".ShowRatingNode.WaitDays") == null) {
                    value = "0";
                } else {
                    value = (String) y.get(".ShowRatingNode.WaitDays");
                }
                int intValue3 = Integer.decode(value).intValue();
                if (intValue <= d.vHl && d.vHl <= intValue2) {
                    Object obj;
                    final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
                    int i = sharedPreferences.getInt("show_rating_flag", 0);
                    int i2 = sharedPreferences.getInt("show_rating_version", 0);
                    long j = sharedPreferences.getLong("show_rating_timestamp", 0);
                    boolean z = sharedPreferences.getBoolean("show_rating_again", false);
                    long j2 = ((long) (intValue3 == 0 ? 7 : intValue3)) * 86400000;
                    if (i2 == 0 || intValue > i2 || i2 > intValue2) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        sharedPreferences.edit().putInt("show_rating_version", d.vHl).commit();
                        sharedPreferences.edit().putInt("show_rating_flag", 0).commit();
                        i = 0;
                        j = System.currentTimeMillis();
                        sharedPreferences.edit().putLong("show_rating_timestamp", j).commit();
                        sharedPreferences.edit().putBoolean("show_rating_again", false).commit();
                        sharedPreferences.edit().putInt("show_rating_wait_days", intValue3).commit();
                        sharedPreferences.edit().putInt("show_rating_first_second_time", (int) (System.currentTimeMillis() / 1000)).commit();
                        x.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]current clientVersion=%s,has rating clientVersion=%s,dynamic config showRatting min version=%s,max version:%s,waitDaysMillis:%s", Integer.valueOf(d.vHl), Integer.valueOf(i2), Integer.valueOf(intValue), Integer.valueOf(intValue2), Long.valueOf(j2));
                    }
                    if (intValue <= d.vHl && d.vHl <= intValue2 && i == 0 && j != 0 && System.currentTimeMillis() >= j + j2) {
                        x.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show enjoy app dialog.");
                        Context context2 = context;
                        String string = context.getString(R.l.ePJ);
                        String string2 = context.getString(R.l.ePI);
                        context2 = context;
                        OnClickListener anonymousClass1 = new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                sharedPreferences.edit().putInt("show_rating_flag", 1).commit();
                                if (dialogInterface != null) {
                                    dialogInterface.dismiss();
                                }
                                l.ziY = null;
                                l.n(context2, true);
                                x.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog from enjoy app dialog.");
                            }
                        };
                        context2 = context;
                        ziY = h.a(context, false, context2.getString(R.l.ePQ), "", string, string2, anonymousClass1, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                sharedPreferences.edit().putInt("show_rating_flag", 2).commit();
                                if (dialogInterface != null) {
                                    dialogInterface.dismiss();
                                }
                                l.ziY = null;
                                l.fU(context2);
                                x.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show feedback dialog.");
                            }
                        });
                    } else if (z && j != 0 && System.currentTimeMillis() >= (j + j2) + 345600000) {
                        x.i("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]show rating dialog again.");
                        n(context, false);
                        sharedPreferences.edit().putInt("show_rating_flag", 3).commit();
                    } else if (i == 1) {
                        n(context, true);
                    } else if (i == 2) {
                        fU(context);
                    } else if (i == 3) {
                        n(context, false);
                    }
                }
            }
        }
    }

    private static void n(Context context, boolean z) {
        String string;
        String str;
        String str2;
        final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
        final boolean z2 = sharedPreferences.getBoolean("show_rating_again", false);
        final int i = sharedPreferences.getInt("show_rating_wait_days", 0);
        final int i2 = sharedPreferences.getInt("show_rating_first_second_time", 0);
        String string2;
        String string3;
        if (z) {
            string2 = context.getString(R.l.ePP);
            string3 = context.getString(R.l.ePO);
            string = context.getString(R.l.ePN);
            str = string3;
            str2 = string2;
        } else {
            string2 = context.getString(R.l.ePM);
            string3 = context.getString(R.l.ePL);
            string = context.getString(R.l.ePK);
            str = string3;
            str2 = string2;
        }
        final Context context2 = context;
        ziY = h.a(context, false, str2, "", str, string, (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                String str = "market://details?id=" + ad.getPackageName();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                context2.startActivity(intent);
                x.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]start market intent");
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                sharedPreferences.edit().putBoolean("show_rating_again", false).commit();
                l.ziY = null;
                if (z2) {
                    com.tencent.mm.plugin.report.service.g.pWK.h(11216, Integer.valueOf(5), Integer.valueOf(i2), Integer.valueOf(i));
                    return;
                }
                com.tencent.mm.plugin.report.service.g.pWK.h(11216, Integer.valueOf(4), Integer.valueOf(i2), Integer.valueOf(i));
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (z2) {
                    sharedPreferences.edit().putBoolean("show_rating_again", false).commit();
                    com.tencent.mm.plugin.report.service.g.pWK.h(11216, Integer.valueOf(3), Integer.valueOf(i2), Integer.valueOf(i));
                } else {
                    x.d("MicroMsg.MainUI.RatingDialogHelper", "[oneliang]need to show rating dialog again.");
                    sharedPreferences.edit().putBoolean("show_rating_again", true).commit();
                    com.tencent.mm.plugin.report.service.g.pWK.h(11216, Integer.valueOf(6), Integer.valueOf(i2), Integer.valueOf(i));
                }
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                l.ziY = null;
            }
        });
    }

    private static void fU(final Context context) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences("show_rating_preferences", 0);
        final int i = sharedPreferences.getInt("show_rating_wait_days", 0);
        final int i2 = sharedPreferences.getInt("show_rating_first_second_time", 0);
        String string = context.getString(R.l.ePS);
        String string2 = context.getString(R.l.ePR);
        OnClickListener anonymousClass5 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                com.tencent.mm.pluginsdk.d.a(context, (int) System.currentTimeMillis(), new byte[0], "weixin://dl/feedback");
                l.ziY = null;
                com.tencent.mm.plugin.report.service.g.pWK.h(11216, Integer.valueOf(2), Integer.valueOf(i2), Integer.valueOf(i));
            }
        };
        OnClickListener anonymousClass6 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                sharedPreferences.edit().putInt("show_rating_flag", 4).commit();
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                l.ziY = null;
                com.tencent.mm.plugin.report.service.g.pWK.h(11216, Integer.valueOf(1), Integer.valueOf(i2), Integer.valueOf(i));
            }
        };
        ziY = h.a(context, false, context.getString(R.l.ePT), "", string, string2, anonymousClass5, anonymousClass6);
    }

    public static void cxF() {
        if (ziY != null) {
            ziY.dismiss();
            ziY = null;
        }
    }
}
