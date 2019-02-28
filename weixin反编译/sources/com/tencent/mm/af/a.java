package com.tencent.mm.af;

import android.graphics.Bitmap;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.n;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.protocal.c.hn;
import com.tencent.mm.protocal.c.ho;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    static boolean b(d dVar) {
        if (dVar == null) {
            x.i("MicroMsg.BizAttrRenovator", "BizInfo is null.");
            return false;
        } else if (!Lb()) {
            return false;
        } else {
            int i = ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getInt("MMBizAttrSyncFreq", -1);
            if (i == -1) {
                x.i("MicroMsg.BizAttrRenovator", "MMBizAttrSyncFreq is null.");
                i = 3600;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = dVar.field_incrementUpdateTime;
            String str = dVar.field_attrSyncVersion;
            x.i("MicroMsg.BizAttrRenovator", "currentMS(%d), lastUpdateTime(%d), freq(%d), version(%s).", Long.valueOf(currentTimeMillis), Long.valueOf(j), Integer.valueOf(i), str);
            return currentTimeMillis - j >= ((long) i) * 1000;
        }
    }

    public static boolean Lb() {
        int i;
        Object obj = g.Dq().Db().get(com.tencent.mm.storage.w.a.USERINFO_BIZ_ATTR_SYNC_OPEN_FLAG_INT, null);
        if (obj == null || !(obj instanceof Integer)) {
            x.i("MicroMsg.BizAttrRenovator", "openFlag is null.");
            i = 1;
        } else {
            i = ((Integer) obj).intValue();
        }
        x.i("MicroMsg.BizAttrRenovator", "openFlag is %d.", Integer.valueOf(i));
        if (i == 1) {
            return true;
        }
        return false;
    }

    public final boolean jz(final String str) {
        if (bi.oN(str)) {
            x.i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is null or nil.");
            return false;
        }
        x.d("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes");
        d jN = y.Ml().jN(str);
        if (b(jN)) {
            final WeakReference weakReference = new WeakReference(null);
            g.Dp().gRu.a(new p(str, jN.field_attrSyncVersion, new com.tencent.mm.af.p.a<p>() {
                public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
                    p pVar = (p) kVar;
                    x.i("MicroMsg.BizAttrRenovator", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
                    if (weakReference != null) {
                        weakReference.get();
                    }
                    if (pVar == null) {
                        x.e("MicroMsg.BizAttrRenovator", "scene == null");
                    } else if (i == 0 && i2 == 0) {
                        hn hnVar = (pVar.gLB == null || pVar.gLB.hnR.hnY == null) ? null : (hn) pVar.gLB.hnR.hnY;
                        if (hnVar == null) {
                            x.e("MicroMsg.BizAttrRenovator", "resp is null.");
                            return;
                        }
                        String str2 = "MicroMsg.BizAttrRenovator";
                        String str3 = "[BizAttr] biz(%s) Attribute LastAttrVersion = %s, UpdateInfoList.size = %s";
                        Object[] objArr = new Object[3];
                        objArr[0] = str;
                        objArr[1] = hnVar.vTY == null ? null : new String(hnVar.vTY.oz);
                        objArr[2] = Integer.valueOf(hnVar.vTZ == null ? 0 : hnVar.vTZ.size());
                        x.i(str2, str3, objArr);
                        if (hnVar.vTZ == null) {
                            x.e("MicroMsg.BizAttrRenovator", "[BizAttr] resp.UpdateInfoList null");
                            return;
                        }
                        boolean z;
                        String str4 = str;
                        List list = hnVar.vTZ;
                        if (bi.oN(str4)) {
                            x.e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, username is null.");
                            z = false;
                        } else {
                            d jN = y.Ml().jN(str4);
                            if (a.b(jN)) {
                                ag Xv = ((h) g.h(h.class)).Ff().Xv(str4);
                                if (Xv == null || ((int) Xv.gKO) == 0 || !Xv.ciN()) {
                                    x.w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact do not exist.(username : %s)", str4);
                                    z = false;
                                } else {
                                    if (bi.oN(Xv.field_username)) {
                                        Xv.setUsername(str4);
                                    }
                                    z = a.a(Xv, jN, list);
                                }
                            } else {
                                x.i("MicroMsg.BizAttrRenovator", "Do not need to update bizAttrs now.(username : %s)", str4);
                                z = false;
                            }
                        }
                        if (!z) {
                            x.i("MicroMsg.BizAttrRenovator", "notifyDataSetChanged, after updateBizAttributes.");
                        } else if (hnVar.vTY != null) {
                            z = (bi.oN(str) || bi.oN(bi.bA(hnVar.vTY.oz))) ? false : y.Ml().fD("BizInfo", String.format("update %s set %s='%s', %s=%d where %s='%s'", new Object[]{"BizInfo", "attrSyncVersion", bi.bA(hnVar.vTY.oz), "incrementUpdateTime", Long.valueOf(System.currentTimeMillis()), "username", str}));
                            x.i("MicroMsg.BizAttrRenovator", "Update attrSyncVersion of bizInfo succ = %b.", Boolean.valueOf(z));
                        }
                    } else {
                        x.e("MicroMsg.BizAttrRenovator", "scene.getType() = %s", Integer.valueOf(pVar.getType()));
                    }
                }
            }), 0);
            return true;
        }
        x.i("MicroMsg.BizAttrRenovator", "do not need to update biz attrs now.");
        return false;
    }

    public static boolean a(com.tencent.mm.storage.x xVar, d dVar, List<ho> list) {
        if (xVar == null || list == null || list.size() == 0) {
            x.e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed.");
            return false;
        }
        String str = xVar.field_username;
        if (xVar.ciN()) {
            if (dVar == null) {
                dVar = y.Ml().jN(str);
            }
            if (dVar == null) {
                x.i("MicroMsg.BizAttrRenovator", "BizInfo is null.(username : %s)", str);
                return false;
            }
            JSONObject jSONObject;
            com.tencent.mm.ac.h jp = n.JW().jp(str);
            try {
                if (bi.oN(dVar.field_extInfo)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(dVar.field_extInfo);
                }
            } catch (Exception e) {
                x.e("MicroMsg.BizAttrRenovator", "create Json object from extInfo error. %s.", e);
                jSONObject = new JSONObject();
            }
            long j = -1;
            long j2 = (long) xVar.field_type;
            int i = 0;
            Object obj = null;
            for (ho hoVar : list) {
                if (hoVar == null) {
                    x.w("MicroMsg.BizAttrRenovator", "keyValue is null.");
                } else {
                    Object obj2;
                    int i2;
                    String str2 = hoVar.vUa;
                    x.i("MicroMsg.BizAttrRenovator", "[BizAttr] UpdateInfoList key = %s, value = %s", str2, hoVar.pWq);
                    String str3 = hoVar.pWq;
                    if (!"UserName".equals(str2)) {
                        if ("NickName".equals(str2)) {
                            xVar.dc(str3);
                        } else if ("Alias".equals(str2)) {
                            xVar.cZ(str3);
                        } else if ("PYInitial".equals(str2)) {
                            xVar.dd(str3);
                        } else if ("QuanPin".equals(str2)) {
                            xVar.de(str3);
                        } else if ("VerifyFlag".equals(str2)) {
                            xVar.ez(bi.getInt(str3, xVar.field_verifyFlag));
                        } else if ("VerifyInfo".equals(str2)) {
                            xVar.du(str3);
                        } else if ("Signature".equals(str2)) {
                            xVar.dp(str3);
                        } else {
                            obj2 = null;
                            if (obj2 == null && !b(jSONObject, str2, hoVar.pWq)) {
                                str3 = hoVar.pWq;
                                if ("BrandInfo".equals(str2)) {
                                    dVar.field_brandInfo = str3;
                                } else if ("BrandIconURL".equals(str2)) {
                                    dVar.field_brandIconURL = str3;
                                } else if ("BrandFlag".equals(str2)) {
                                    if ("Appid".equals(str2)) {
                                        obj2 = null;
                                    } else if (str3.equals(dVar.field_appId)) {
                                        dVar.field_appId = str3;
                                    } else {
                                        obj2 = null;
                                    }
                                    if (obj2 == null) {
                                        str3 = hoVar.pWq;
                                        if ("BigHeadImgUrl".equals(str2)) {
                                            if (!"SmallHeadImgUrl".equals(str2)) {
                                                obj2 = null;
                                                if (obj2 == null) {
                                                    i++;
                                                    obj = 1;
                                                } else if ("BitMask".equals(str2)) {
                                                    if ("BitVal".equals(str2)) {
                                                        i2 = i;
                                                    } else {
                                                        j2 = bi.getLong(hoVar.pWq, j2);
                                                        i2 = i + 1;
                                                    }
                                                    i = i2;
                                                } else {
                                                    j = bi.getLong(hoVar.pWq, j);
                                                    i++;
                                                }
                                            } else if (jp != null) {
                                                jp.hnh = str3;
                                            }
                                        } else if (jp != null) {
                                            jp.hni = str3;
                                        }
                                        obj2 = 1;
                                        if (obj2 == null) {
                                            i++;
                                            obj = 1;
                                        } else if ("BitMask".equals(str2)) {
                                            if ("BitVal".equals(str2)) {
                                                i2 = i;
                                            } else {
                                                j2 = bi.getLong(hoVar.pWq, j2);
                                                i2 = i + 1;
                                            }
                                            i = i2;
                                        } else {
                                            j = bi.getLong(hoVar.pWq, j);
                                            i++;
                                        }
                                    }
                                } else {
                                    dVar.field_brandFlag = bi.getInt(str3, dVar.field_brandFlag);
                                }
                                obj2 = 1;
                                if (obj2 == null) {
                                    str3 = hoVar.pWq;
                                    if ("BigHeadImgUrl".equals(str2)) {
                                        if (!"SmallHeadImgUrl".equals(str2)) {
                                            obj2 = null;
                                            if (obj2 == null) {
                                                i++;
                                                obj = 1;
                                            } else if ("BitMask".equals(str2)) {
                                                j = bi.getLong(hoVar.pWq, j);
                                                i++;
                                            } else {
                                                if ("BitVal".equals(str2)) {
                                                    j2 = bi.getLong(hoVar.pWq, j2);
                                                    i2 = i + 1;
                                                } else {
                                                    i2 = i;
                                                }
                                                i = i2;
                                            }
                                        } else if (jp != null) {
                                            jp.hnh = str3;
                                        }
                                    } else if (jp != null) {
                                        jp.hni = str3;
                                    }
                                    obj2 = 1;
                                    if (obj2 == null) {
                                        i++;
                                        obj = 1;
                                    } else if ("BitMask".equals(str2)) {
                                        if ("BitVal".equals(str2)) {
                                            i2 = i;
                                        } else {
                                            j2 = bi.getLong(hoVar.pWq, j2);
                                            i2 = i + 1;
                                        }
                                        i = i2;
                                    } else {
                                        j = bi.getLong(hoVar.pWq, j);
                                        i++;
                                    }
                                }
                            }
                            i++;
                        }
                    }
                    obj2 = 1;
                    str3 = hoVar.pWq;
                    if ("BrandInfo".equals(str2)) {
                        dVar.field_brandInfo = str3;
                    } else if ("BrandIconURL".equals(str2)) {
                        dVar.field_brandIconURL = str3;
                    } else if ("BrandFlag".equals(str2)) {
                        if ("Appid".equals(str2)) {
                            obj2 = null;
                        } else if (str3.equals(dVar.field_appId)) {
                            dVar.field_appId = str3;
                        } else {
                            obj2 = null;
                        }
                        if (obj2 == null) {
                            str3 = hoVar.pWq;
                            if ("BigHeadImgUrl".equals(str2)) {
                                if (jp != null) {
                                    jp.hni = str3;
                                }
                            } else if (!"SmallHeadImgUrl".equals(str2)) {
                                obj2 = null;
                                if (obj2 == null) {
                                    i++;
                                    obj = 1;
                                } else if ("BitMask".equals(str2)) {
                                    j = bi.getLong(hoVar.pWq, j);
                                    i++;
                                } else {
                                    if ("BitVal".equals(str2)) {
                                        j2 = bi.getLong(hoVar.pWq, j2);
                                        i2 = i + 1;
                                    } else {
                                        i2 = i;
                                    }
                                    i = i2;
                                }
                            } else if (jp != null) {
                                jp.hnh = str3;
                            }
                            obj2 = 1;
                            if (obj2 == null) {
                                i++;
                                obj = 1;
                            } else if ("BitMask".equals(str2)) {
                                if ("BitVal".equals(str2)) {
                                    i2 = i;
                                } else {
                                    j2 = bi.getLong(hoVar.pWq, j2);
                                    i2 = i + 1;
                                }
                                i = i2;
                            } else {
                                j = bi.getLong(hoVar.pWq, j);
                                i++;
                            }
                        }
                        i++;
                    } else {
                        dVar.field_brandFlag = bi.getInt(str3, dVar.field_brandFlag);
                    }
                    obj2 = 1;
                    if (obj2 == null) {
                        str3 = hoVar.pWq;
                        if ("BigHeadImgUrl".equals(str2)) {
                            if (!"SmallHeadImgUrl".equals(str2)) {
                                obj2 = null;
                                if (obj2 == null) {
                                    i++;
                                    obj = 1;
                                } else if ("BitMask".equals(str2)) {
                                    j = bi.getLong(hoVar.pWq, j);
                                    i++;
                                } else {
                                    if ("BitVal".equals(str2)) {
                                        j2 = bi.getLong(hoVar.pWq, j2);
                                        i2 = i + 1;
                                    } else {
                                        i2 = i;
                                    }
                                    i = i2;
                                }
                            } else if (jp != null) {
                                jp.hnh = str3;
                            }
                        } else if (jp != null) {
                            jp.hni = str3;
                        }
                        obj2 = 1;
                        if (obj2 == null) {
                            i++;
                            obj = 1;
                        } else if ("BitMask".equals(str2)) {
                            if ("BitVal".equals(str2)) {
                                i2 = i;
                            } else {
                                j2 = bi.getLong(hoVar.pWq, j2);
                                i2 = i + 1;
                            }
                            i = i2;
                        } else {
                            j = bi.getLong(hoVar.pWq, j);
                            i++;
                        }
                    }
                    i++;
                }
            }
            if (i == 0) {
                x.i("MicroMsg.BizAttrRenovator", "None attribute has been updated.");
                return false;
            }
            dVar.field_extInfo = jSONObject.toString();
            if (!(jp == null || obj == null)) {
                n.JW().a(jp);
                n.JF();
                d.y(str, false);
                n.JF();
                d.y(str, true);
                n.JY().jb(str);
                com.tencent.mm.af.m.a Mt = y.Mt();
                if (!bi.oN(str)) {
                    x.d("MicroMsg.BrandLogic", "remove cache by brandKey : %s", str);
                    WeakReference weakReference = (WeakReference) Mt.hrL.remove(str);
                    if (weakReference != null) {
                        Bitmap bitmap = (Bitmap) weakReference.get();
                        if (bitmap != null) {
                            bitmap.isRecycled();
                        }
                    }
                }
            }
            xVar.setType(xVar.field_type | ((int) (j & j2)));
            ((h) g.h(h.class)).Ff().a(str, xVar);
            y.Ml().e(dVar);
            x.i("MicroMsg.BizAttrRenovator", "Update bizInfo attributes successfully.");
            return true;
        }
        x.w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact is not a biz contact.(username : %s)", str);
        return false;
    }

    private static boolean b(JSONObject jSONObject, String str, String str2) {
        try {
            if ("IsShowHeadImgInMsg".equals(str)) {
                jSONObject.put(str, str2);
            } else if ("IsHideInputToolbarInMsg".equals(str)) {
                jSONObject.put(str, str2);
            } else if (!"IsAgreeProtocol".equals(str)) {
                if ("InteractiveMode".equals(str)) {
                    jSONObject.put(str, bi.getInt(str2, jSONObject.optInt(str)));
                } else if ("CanReceiveSpeexVoice".equals(str)) {
                    jSONObject.put(str, str2);
                } else if ("ConnectorMsgType".equals(str)) {
                    jSONObject.put(str, bi.getInt(str2, jSONObject.optInt(str)));
                } else if ("ReportLocationType".equals(str)) {
                    jSONObject.put(str, bi.getInt(str2, jSONObject.optInt(str)));
                } else if ("AudioPlayType".equals(str)) {
                    jSONObject.put(str, bi.getInt(str2, jSONObject.optInt(str)));
                } else if ("IsShowMember".equals(str)) {
                    jSONObject.put(str, str2);
                } else if ("ConferenceContactExpireTime".equals(str)) {
                    jSONObject.put(str, str2);
                } else if (!"VerifyMsg2Remark".equals(str)) {
                    if ("VerifyContactPromptTitle".equals(str)) {
                        jSONObject.put(str, str2);
                    } else if (!"IsSubscribeStat".equals(str)) {
                        if ("ScanQRCodeType".equals(str)) {
                            jSONObject.put(str, bi.getInt(str2, jSONObject.optInt(str)));
                        } else if ("ServiceType".equals(str)) {
                            jSONObject.put(str, bi.getInt(str2, jSONObject.optInt(str)));
                        } else if (!"NeedShowUserAddrObtaining".equals(str)) {
                            if ("SupportEmoticonLinkPrefix".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("FunctionFlag".equals(str)) {
                                jSONObject.put(str, bi.getInt(str2, jSONObject.optInt(str)));
                            } else if ("NotifyManage".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("ServicePhone".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("IsTrademarkProtection".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if (!"CanReceiveLongVideo".equals(str)) {
                                if ("TrademarkUrl".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("TrademarkName".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("MMBizMenu".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("VerifySource".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if (!"MMBizTabbar".equals(str)) {
                                    if ("PayShowInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if ("HardwareBizInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if ("EnterpriseBizInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if (!"MainPage".equals(str)) {
                                        if ("RegisterSource".equals(str)) {
                                            jSONObject.put(str, str2);
                                        } else if (!"IBeaconBizInfo".equals(str)) {
                                            if ("WxaAppInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("WxaAppVersionInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("WXAppType".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("BindWxaInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if (!"AcctTransferInfo".equals(str)) {
                                                return false;
                                            } else {
                                                jSONObject.put(str, str2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
            x.e("MicroMsg.BizAttrRenovator", "updateExtInfoAttrs failed, key(%s) value(%s), exception : %s.", str, str2, e);
        }
        return true;
    }
}
