package com.tencent.mm.storage.emotion;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.f.b.ap;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;

public class EmojiGroupInfo extends ap implements Parcelable {
    public static final Creator<EmojiGroupInfo> CREATOR = new Creator<EmojiGroupInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new EmojiGroupInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new EmojiGroupInfo[i];
        }
    };
    public static int TYPE_CUSTOM = 3;
    public static int TYPE_SYSTEM = 1;
    protected static a gKN;
    public static int xIB = 2;
    public static int xIC = 4;
    public static int xID = 256;
    public static int xIE = 17;
    public static int xIF = 18;
    public static int xIG = 81;
    public static int xIH = 65;

    static {
        a aVar = new a();
        aVar.hUM = new Field[29];
        aVar.columns = new String[30];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "productID";
        aVar.xrT.put("productID", "TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(" productID TEXT PRIMARY KEY  COLLATE NOCASE ");
        stringBuilder.append(", ");
        aVar.xrS = "productID";
        aVar.columns[1] = "packIconUrl";
        aVar.xrT.put("packIconUrl", "TEXT");
        stringBuilder.append(" packIconUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "packGrayIconUrl";
        aVar.xrT.put("packGrayIconUrl", "TEXT");
        stringBuilder.append(" packGrayIconUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "packCoverUrl";
        aVar.xrT.put("packCoverUrl", "TEXT");
        stringBuilder.append(" packCoverUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "packName";
        aVar.xrT.put("packName", "TEXT");
        stringBuilder.append(" packName TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "packDesc";
        aVar.xrT.put("packDesc", "TEXT");
        stringBuilder.append(" packDesc TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "packAuthInfo";
        aVar.xrT.put("packAuthInfo", "TEXT");
        stringBuilder.append(" packAuthInfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "packPrice";
        aVar.xrT.put("packPrice", "TEXT");
        stringBuilder.append(" packPrice TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "packType";
        aVar.xrT.put("packType", "INTEGER");
        stringBuilder.append(" packType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "packFlag";
        aVar.xrT.put("packFlag", "INTEGER");
        stringBuilder.append(" packFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "packExpire";
        aVar.xrT.put("packExpire", "LONG");
        stringBuilder.append(" packExpire LONG");
        stringBuilder.append(", ");
        aVar.columns[11] = "packTimeStamp";
        aVar.xrT.put("packTimeStamp", "LONG");
        stringBuilder.append(" packTimeStamp LONG");
        stringBuilder.append(", ");
        aVar.columns[12] = "packCopyright";
        aVar.xrT.put("packCopyright", "TEXT");
        stringBuilder.append(" packCopyright TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = Columns.TYPE;
        aVar.xrT.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[14] = DownloadInfo.STATUS;
        aVar.xrT.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[15] = "sort";
        aVar.xrT.put("sort", "INTEGER default '1' ");
        stringBuilder.append(" sort INTEGER default '1' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "lastUseTime";
        aVar.xrT.put("lastUseTime", "LONG");
        stringBuilder.append(" lastUseTime LONG");
        stringBuilder.append(", ");
        aVar.columns[17] = "packStatus";
        aVar.xrT.put("packStatus", "INTEGER default '0' ");
        stringBuilder.append(" packStatus INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "flag";
        aVar.xrT.put("flag", "INTEGER default '0' ");
        stringBuilder.append(" flag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[19] = "recommand";
        aVar.xrT.put("recommand", "INTEGER default '0' ");
        stringBuilder.append(" recommand INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[20] = "sync";
        aVar.xrT.put("sync", "INTEGER default '0' ");
        stringBuilder.append(" sync INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[21] = "idx";
        aVar.xrT.put("idx", "INTEGER default '0' ");
        stringBuilder.append(" idx INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[22] = "BigIconUrl";
        aVar.xrT.put("BigIconUrl", "TEXT");
        stringBuilder.append(" BigIconUrl TEXT");
        stringBuilder.append(", ");
        aVar.columns[23] = "MutiLanName";
        aVar.xrT.put("MutiLanName", "TEXT");
        stringBuilder.append(" MutiLanName TEXT");
        stringBuilder.append(", ");
        aVar.columns[24] = "recommandType";
        aVar.xrT.put("recommandType", "INTEGER default '-1' ");
        stringBuilder.append(" recommandType INTEGER default '-1' ");
        stringBuilder.append(", ");
        aVar.columns[25] = "lang";
        aVar.xrT.put("lang", "TEXT");
        stringBuilder.append(" lang TEXT");
        stringBuilder.append(", ");
        aVar.columns[26] = "recommandWord";
        aVar.xrT.put("recommandWord", "TEXT");
        stringBuilder.append(" recommandWord TEXT");
        stringBuilder.append(", ");
        aVar.columns[27] = "buttonType";
        aVar.xrT.put("buttonType", "INTEGER");
        stringBuilder.append(" buttonType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[28] = "count";
        aVar.xrT.put("count", "INTEGER");
        stringBuilder.append(" count INTEGER");
        aVar.columns[29] = "rowid";
        aVar.xrU = stringBuilder.toString();
        gKN = aVar;
    }

    protected final a Aj() {
        return gKN;
    }

    public final sx ckN() {
        sx sxVar = new sx();
        sxVar.vPI = this.field_productID;
        sxVar.nlA = this.field_packIconUrl;
        sxVar.whv = this.field_packName;
        sxVar.whw = this.field_packDesc;
        sxVar.whx = this.field_packAuthInfo;
        sxVar.why = this.field_packPrice;
        sxVar.whz = this.field_packType;
        sxVar.whA = this.field_packFlag;
        sxVar.whD = this.field_packCoverUrl;
        sxVar.whE = (int) this.field_packExpire;
        sxVar.whF = this.field_packCopyright;
        sxVar.wid = (int) this.field_packTimeStamp;
        sxVar.whG = this.field_packPrice;
        return sxVar;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("field_productID:").append(this.field_productID).append("\n");
        stringBuilder.append("field_packIconUrl:").append(this.field_packIconUrl).append("\n");
        stringBuilder.append("field_packGrayIconUrl:").append(this.field_packGrayIconUrl).append("\n");
        stringBuilder.append("field_packCoverUrl:").append(this.field_packCoverUrl).append("\n");
        stringBuilder.append("field_packName:").append(this.field_packName).append("\n");
        stringBuilder.append("field_packDesc:").append(this.field_packDesc).append("\n");
        stringBuilder.append("field_packAuthInfo:").append(this.field_packAuthInfo).append("\n");
        stringBuilder.append("field_packPrice:").append(this.field_packPrice).append("\n");
        stringBuilder.append("field_packType:").append(this.field_packType).append("\n");
        stringBuilder.append("field_packFlag:").append(this.field_packFlag).append("\n");
        stringBuilder.append("field_packExpire:").append(this.field_packExpire).append("\n");
        stringBuilder.append("field_packTimeStamp:").append(this.field_packTimeStamp).append("\n");
        stringBuilder.append("field_packCopyright:").append(this.field_packCopyright).append("\n");
        stringBuilder.append("field_type:").append(this.field_type).append("\n");
        stringBuilder.append("field_status:").append(this.field_status).append("\n");
        stringBuilder.append("field_sort:").append(this.field_sort).append("\n");
        stringBuilder.append("field_lastUseTime:").append(this.field_lastUseTime).append("\n");
        stringBuilder.append("field_packStatus:").append(this.field_packStatus).append("\n");
        stringBuilder.append("field_recommand:").append(this.field_recommand).append("\n");
        stringBuilder.append("field_sync:").append(this.field_sync).append("\n");
        stringBuilder.append("field_idx:").append(this.field_idx).append("\n");
        stringBuilder.append("field_BigIconUrl:").append(this.field_BigIconUrl).append("\n");
        stringBuilder.append("field_MutiLanName:").append(this.field_MutiLanName).append("\n");
        stringBuilder.append("field_count:").append(this.field_count).append("\n");
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.field_productID);
        parcel.writeString(this.field_packIconUrl);
        parcel.writeString(this.field_packGrayIconUrl);
        parcel.writeString(this.field_packCoverUrl);
        parcel.writeString(this.field_packName);
        parcel.writeString(this.field_packDesc);
        parcel.writeString(this.field_packAuthInfo);
        parcel.writeString(this.field_packPrice);
        parcel.writeInt(this.field_packType);
        parcel.writeInt(this.field_packFlag);
        parcel.writeLong(this.field_packExpire);
        parcel.writeLong(this.field_packTimeStamp);
        parcel.writeString(this.field_packCopyright);
        parcel.writeInt(this.field_type);
        parcel.writeInt(this.field_status);
        parcel.writeInt(this.field_sort);
        parcel.writeLong(this.field_lastUseTime);
        parcel.writeInt(this.field_packStatus);
        parcel.writeInt(this.field_flag);
        parcel.writeInt(this.field_recommand);
        parcel.writeInt(this.field_sync);
        parcel.writeInt(this.field_idx);
        parcel.writeString(this.field_BigIconUrl);
        parcel.writeString(this.field_MutiLanName);
        parcel.writeInt(this.field_recommandType);
        parcel.writeString(this.field_lang);
        parcel.writeString(this.field_recommandWord);
        parcel.writeInt(this.field_buttonType);
        parcel.writeInt(this.field_count);
        parcel.writeLong(this.xrR);
    }

    protected EmojiGroupInfo(Parcel parcel) {
        this.field_productID = parcel.readString();
        this.field_packIconUrl = parcel.readString();
        this.field_packGrayIconUrl = parcel.readString();
        this.field_packCoverUrl = parcel.readString();
        this.field_packName = parcel.readString();
        this.field_packDesc = parcel.readString();
        this.field_packAuthInfo = parcel.readString();
        this.field_packPrice = parcel.readString();
        this.field_packType = parcel.readInt();
        this.field_packFlag = parcel.readInt();
        this.field_packExpire = parcel.readLong();
        this.field_packTimeStamp = parcel.readLong();
        this.field_packCopyright = parcel.readString();
        this.field_type = parcel.readInt();
        this.field_status = parcel.readInt();
        this.field_sort = parcel.readInt();
        this.field_lastUseTime = parcel.readLong();
        this.field_packStatus = parcel.readInt();
        this.field_flag = parcel.readInt();
        this.field_recommand = parcel.readInt();
        this.field_sync = parcel.readInt();
        this.field_idx = parcel.readInt();
        this.field_BigIconUrl = parcel.readString();
        this.field_MutiLanName = parcel.readString();
        this.field_recommandType = parcel.readInt();
        this.field_lang = parcel.readString();
        this.field_recommandWord = parcel.readString();
        this.field_buttonType = parcel.readInt();
        this.field_count = parcel.readInt();
        this.xrR = parcel.readLong();
    }
}
