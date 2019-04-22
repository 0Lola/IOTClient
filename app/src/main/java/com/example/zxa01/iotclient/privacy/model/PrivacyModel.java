package com.example.zxa01.iotclient.privacy.model;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.BaseObservable;
import android.util.Log;

import com.example.zxa01.iotclient.common.http.Api;
import com.example.zxa01.iotclient.common.pojo.device.Device;
import com.example.zxa01.iotclient.common.pojo.device.Manufacturer;
import com.example.zxa01.iotclient.common.pojo.device.Model;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyPolicy;
import com.example.zxa01.iotclient.common.pojo.privacy.PrivacyPolicyReport;
import com.example.zxa01.iotclient.common.pojo.privacy.p3p.Access;
import com.example.zxa01.iotclient.common.pojo.privacy.p3p.Collector;
import com.example.zxa01.iotclient.common.pojo.privacy.p3p.Datum;
import com.example.zxa01.iotclient.common.pojo.privacy.p3p.Dispute;
import com.example.zxa01.iotclient.common.pojo.privacy.p3p.Purpose;
import com.example.zxa01.iotclient.common.pojo.privacy.p3p.Recipient;
import com.example.zxa01.iotclient.common.pojo.privacy.p3p.Remedy;
import com.example.zxa01.iotclient.common.pojo.privacy.p3p.Retention;
import com.example.zxa01.iotclient.common.pojo.privacy.p3p.Statement;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrivacyModel extends BaseObservable {

    private MutableLiveData<PrivacyPolicyReport> privacyPolicyReport;

    // fake p3p
    private Device oxygenDevice = new Device()
            .setUDN("a1252c49-4188-4e6d-a32e-66604c664fb8")
            .setName("指尖式血氧機")
            .setType(Device.Type.Sensor)
            .setManufacturer(new Manufacturer()
                    .setName("Facelake")
                    .setSerialNumber("3176927193")
                    .setUrl("http://facelake.com"))
            .setModel(new Model()
                    .setName("指尖式血氧機")
                    .setDescription("本設備是為符合不同領域及照護應用而設計，並把這些特色融入小如指節的分析儀中，可在數秒內量測出準確可靠的血氧及心跳值。")
                    .setUrl("https://www.amazon.com/Pulse-Oximeter-Blood-Oxygen-Monitor/dp/B00HXXO332"))
            .setUPC("B00HXXO332")
            .setLocation("25.013068, 121.541651")
            .setStatus(Device.Status.Disconnected);

    private PrivacyPolicyReport oxygenPrivacyPolicyReport = new PrivacyPolicyReport()
            .setId("0cfb6be3-6f0f-4e63-85b8-e9c936707c0b")
            .setVersion("1.0")
            .setDescription("為提供您最佳的互動照護服務，本APP部分服務內容可能會請您提供心跳資訊及血氧飽和度資訊，以作為持續自動追蹤心率的技術，提供整日健康狀況的深入分析以及運動強度的資訊。")
            .setDevice(oxygenDevice)
            .addPrivacyPolicy(new PrivacyPolicy()
                    .setId("119df569-06b1-4d63-84cd-bde7c9e4ab7e")
                    .setDescription("為提供您最佳的互動照護服務，本APP部分服務內容可能會請您提供血氧飽和度資訊，以作為呼吸系統疾病、循環系統疾病、其它治療、檢查引起的損傷之遠端醫療照護分析資料。")
                    .setCollector(new Collector()
                            .setName("健康促進中心")
                            .setEmail("hcc@gmail.com.tw")
                            .setPhone("0988415875"))
                    .setAccess(Access.OTHER_IDENT)
                    .setDispute(new Dispute()
                            .setRelatedOrganization("地方法院")
                            .setType(Dispute.Type.LAW))
                    .addRemedy(new Remedy()
                            .setType(Remedy.Type.LAW))
                    .addStatement(new Statement()
                            .setConsequence("a1252c49-4188-4e6d-a32e-66604c664fb9")
                            .addPurpose(new Purpose()
                                    .setType(Purpose.Type.PSEUDO_ANALYSIS)
                                    .setDescription("本APP會使用者蒐集血氧飽和度資訊作為呼吸系統疾病、循環系統疾病、其它治療、檢查引起的損傷之遠端醫療照護分析資料。"))
                            .addDatum(new Datum()
                                    .setType(Datum.Type.HEALTH)
                                    .setDescription("血氧飽和度資訊"))
                            .addRecipient(new Recipient()
                                    .setEntity("健康促進中心")
                                    .setType(Recipient.Type.OURS))
                            .setRetention(Retention.STATED_PURPOSE)))
            .addPrivacyPolicy(new PrivacyPolicy()
                    .setId("abe5ca7b-780e-4857-87e6-014870fe0a3f")
                    .setDescription("為提供您最佳的互動照護服務，本APP會蒐集使用者心跳資訊，作為持續自動追蹤心率的技術，提供整日健康狀況的深入分析以及運動強度的資訊。")
                    .setCollector(new Collector()
                            .setName("健康促進中心")
                            .setEmail("hcc@gmail.com.tw")
                            .setPhone("0988415875"))
                    .setAccess(Access.OTHER_IDENT)
                    .setDispute(new Dispute()
                            .setRelatedOrganization("地方法院")
                            .setType(Dispute.Type.LAW))
                    .addRemedy(new Remedy()
                            .setType(Remedy.Type.CORRECT))
                    .addRemedy(new Remedy()
                            .setType(Remedy.Type.LAW))
                    .addRemedy(new Remedy()
                            .setType(Remedy.Type.MONEY))
                    .addStatement(new Statement()
                            .setConsequence("a1252c49-4188-4e6d-a32e-66604c664fba")
                            .addPurpose(new Purpose()
                                    .setType(Purpose.Type.INDIVIDUAL_ANALYSIS)
                                    .setDescription("本APP會蒐集使用者心跳資訊，作為持續自動追蹤心率的技術，提供整日健康狀況的深入分析以及運動強度的資訊。"))
                            .addDatum(new Datum()
                                    .setType(Datum.Type.HEALTH)
                                    .setDescription("心跳資訊"))
                            .addRecipient(new Recipient()
                                    .setEntity("健康促進中心")
                                    .setType(Recipient.Type.OURS))
                            .setRetention(Retention.STATED_PURPOSE)));

    public PrivacyModel() {
        privacyPolicyReport = new MutableLiveData<>();
    }

    public MutableLiveData<PrivacyPolicyReport> getPrivacyPolicyReport() {
        return privacyPolicyReport;
    }

    public void fetchPrivacyPolicyReport() {
        Callback<Object> callback = new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                // TODO transfer response
                Log.i("Test", response.message());
                privacyPolicyReport.setValue(oxygenPrivacyPolicyReport);
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                Log.e("fetchPrivacyPolicyReport - onFailure()", t.getMessage(), t);
            }
        };

        Api.getApi().getPrivacyPolicyReport().enqueue(callback);

    }


    public void updatePP(String privacyId,boolean consent) {
        // TODO update 偏好
    }

}
