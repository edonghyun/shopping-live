package com.example.demo.crawler.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.json.simple.JSONArray;

// "broadcastTitle": "헬렌스타인 21'FW 구스이불 최초 공개",
// "benefits": [
//     {
//         "id": 143465,
//         "detailMessage": "★(오늘 하루만) 구스 컴포터 세트 구매시 다운필 낮은베개+알러지케어 패드 증정★",
//         "message": "구스이불 구매시 베개 및 패드 증정",
//         "type": "ONAIR"
//     },
//     {
//         "id": 151418,
//         "detailMessage": "★(오늘 하루만) 프리엔 구스베개 구매시 80수 베개커버(화이트) 증정★",
//         "message": "구스베개 구매시 베개커버 증정",
//         "type": "ONAIR"
//     },
//     {
//         "id": 151419,
//         "detailMessage": "★리버티 더블 레이어 구스 컴포터 세트 374,000원~★",
//         "message": "★오늘 런칭!",
//         "type": "ONAIR"
//     },
//     {
//         "id": 151421,
//         "detailMessage": "★프리엔 삼중 구스베개 900g    98,000원~★\n★프리엔 삼중 구스베개 1100g 107,000원~★\n★프리엔 경추 구스베개 80,000원~★",
//         "message": "★21 FW 신상! ",
//         "type": "ONAIR"
//     }
// ],
// "channelNo": 500007517,
// "broadcastStandByImage": "https:\/\/g-selected.pstatic.net\/MjAyMTA5MzBfMjU2\/MDAxNjMyOTkyMTg5MTg3.SfdqV7xWzfgdk8MSR2e9Slh3TAacnssAhET7UFR9GlMg.sFOH_RE7v44zC5Q3vpWTxxxdxKSkRYR1Wp-G1tNpvpAg.JPEG\/live_up1.jpg",
// "profileImage": "http:\/\/shop1.phinf.naver.net\/20210113_7\/1610524076478YP8MB_JPEG\/11659975180390275_490565484.jpg",
// "broadcastType": "PLANNING",
// "streamSeq": 12327792,
// "vid": "7533CBE93BF48BCE24380C6D1B1808F8CCED",
// "broadcastReplayEndUrl": "https:\/\/view.shoppinglive.naver.com\/replays\/269876",
// "bridgeId": 49649,
// "broadcastId": 269876,
// "displayProduct": {
//     "isNpaySaving": true,
//     "image": "http:\/\/shop1.phinf.naver.net\/20211007_82\/1633590395483U7X7D_JPEG\/34726223115151415_714851239.jpg",
//     "mallName": "헬렌스타인",
//     "discountRate": 25,
//     "brandName": "헬렌스타인",
//     "link": "https:\/\/shoppinglive.naver.com\/bridge\/live\/product\/5892902176?tr=lim5&isDetail=false&channelNo=500007517&trx=269876_0&wholeCategoryId=50000004%3E50000110%3E50001129%3E50003492&ntSource=nshoplive&ntMedium=269876&ntDetail=replay&ntKeyword=nshoplive",
//     "productStatus": "SALE",
//     "broadcastProductStatus": "SALE",
//     "price": 374000,
//     "rangePrice": false,
//     "name": "[헬렌스타인] 리버티 더블 레이어 구스 컴포터 세트 S\/Q\/K",
//     "detailLink": "https:\/\/shoppinglive.naver.com\/bridge\/live\/product\/5892902176?tr=lim5&isDetail=true&channelNo=500007517&trx=269876_0&wholeCategoryId=50000004%3E50000110%3E50001129%3E50003492&ntSource=nshoplive&ntMedium=269876&ntDetail=replay&ntKeyword=nshoplive",
//     "specialPrice": 373000,
//     "key": "5892902176",
//     "productType": "SHOPPING",
//     "represent": true
// },
// "nickname": "헬렌스타인",
// "broadcastBridgeMobileImage": "https:\/\/g-selected.pstatic.net\/MjAyMTA5MzBfMTY1\/MDAxNjMyOTkyMzA4NDk5.u1ogRfHLCuZOeUsZR9Od6R9dBu0PI38Lwma2MFY1Sd4g.PRRvbS42bek0cznq-Hcbug6gOaOkebl2Pj9tLIs8QpMg.JPEG\/image.jpg",
// "serviceId": "STOREFARM",
// "memberId": null,
// "bridgeEndUrl": "https:\/\/shoppinglive.naver.com\/livebridge\/269876",
// "expectedStartDate": "2021-10-11T11:00:11.977",
// "broadcastBridgeTitle": "헬렌스타인 21'FW 구스이불 최초 공개",
// "nicknameDescription": null,
// "broadcasterEndUrl": "https:\/\/shoppinglive.naver.com\/channels\/9855",
// "serviceName": "스토어팜",
// "displayType": null,
// "broadcastEndUrl": "https:\/\/view.shoppinglive.naver.com\/lives\/269876",
// "channelExposureText": null,
// "broadcastBridgePcImage": "https:\/\/g-selected.pstatic.net\/MjAyMTA5MzBfMzUg\/MDAxNjMyOTkyMzE2OTc0.EhAuWvQ-ldpwkxI6TGADeFieJtegLQsAhBxe5LDnXacg.fRmVirpoIy-ISDYtZ-lltXU3egLun6nRLSdqAdvtgqwg.JPEG\/image.jpg",
// "showHostName": null,
// "broadcastBanner": null,
// "startDate": "2021-10-11T11:00:08.999",
// "status": "BLOCK"

@Getter
@Setter
@NoArgsConstructor
public class NaverShoppingBroadcastDto {
    private List benefits;
    private Object displayProduct;

    private Long channelNo;
    private Long bridgeId;
    private Long broadcastId;
    private String broadcastTitle;

    private String broadcastStandByImage;
    private String profileImage;
    private String broadcastType;
    private String vid;
    private String broadcastReplayEndUrl;

    private String nickname;
    private String broadcastBridgeMobileImage;
    private String serviceId;
    private String memberId;
    private String bridgeEndUrl;
    private String broadcastBridgeTitle;
    private String nicknameDescription;
    private String broadcasterEndUrl;
    private String serviceName;
    private String displayType;
    private String broadcastEndUrl;
    private String channelExposureText;
    private String broadcastBridgePcImage;
    private String showHostName;
    private String broadcastBanner;
    private String status;

    private LocalDateTime startDate;
    private LocalDateTime expectedStartDate;
} 