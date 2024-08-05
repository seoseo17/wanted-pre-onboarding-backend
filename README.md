# wanted-pre-onboarding-backend
# Stacks
- java 17
- mysql 8.0
- springboot 3.3.2
# DB 구조
<img width="722" alt="image" src="https://github.com/user-attachments/assets/3db264be-4cb1-4d63-8150-9bc5493cb649">


# API
### 채용공고 등록
`POST /api/recruitment-notice `

**requestBody**
```
{
"companyId" : 1,
"position" : "백엔드 주니어",
"compensation": 100000,
"content": "적극적인 뱍앤드 주니어를 찾고 있습니다.",
"languageUsed" : "python"
}
```
**responseBody**
```
{
    "status": "SUCCESS",
    "message": "공고가 등록되었습니다.",
    "data": 1
}

//companyId가 존재하지 않을 시
{
    "status": "ERROR",
    "message": "회사 정보가 존재하지 않습니다",
    "data": null
}
```

### 채용공고 수정
`PUT /api/recruitment-notice/2 `

**requestBody**
```
{
    "position" : "백엔드 주니어",
    "compensation": 500,
    "content": "적극적인 뱍앤드를 찾고 있습니다.",
    "languageUsed" : "python"
}
```

**responseBody**
```
{
    "status": "SUCCESS",
    "message": "공고가 수정되었습니다.",
    "data": 2
}

//noticeId가 존재하지 않을 시
{
    "status": "ERROR",
    "message": "채용공고 정보가 존재하지 않습니다",
    "data": null
}
```

### 채용공고 삭제
`DELETE /api/recruitment-notice/2 `

**responseBody**
```
{
    "status": "SUCCESS",
    "message": null,
    "data": "공고가 삭제되었습니다."
}

//noticeId가 존재하지 않을 시
{
    "status": "ERROR",
    "message": "채용공고 정보가 존재하지 않습니다",
    "data": null
}
```

### 채용공고 목록
`GET /api/recruitment-notice/all `

**responseBody**
```
{
    "status": "SUCCESS",
    "message": null,
    "data": [
        {
            "noticeId": 3,
            "companyName": "원티드랩",
            "companyNation": "한국",
            "companyRegion": "서울",
            "position": "백엔드 주니어",
            "compensation": 100000,
            "languageUsed": "python"
        },
 ...

        {
            "noticeId": 8,
            "companyName": "구글",
            "companyNation": "미국",
            "companyRegion": "샌프란시스코",
            "position": "백엔드",
            "compensation": 30000,
            "languageUsed": "python"
        }
    ]
}
```

### 채용공고 상세
`GET /api/recruitment-notice/8 `

**responseBody**
```
{
    "status": "SUCCESS",
    "message": null,
    "data": {
        "noticeId": 7,
        "companyName": "구글",
        "companyNation": "미국",
        "companyRegion": "샌프란시스코",
        "position": "백엔드",
        "compensation": 30000,
        "content": "적극적인 뱍앤드 찾고 있습니다.",
        "languageUsed": "JS",
        "noticeList": [
            9,
            10
        ]
    }
}
```
### 사용자 공고 지원
`POST /api/support-details`

**requestBody**
```
{
    "noticeId" : 9,
    "userId": 1
}
```

**responseBody**
```
{
    "status": "SUCCESS",
    "message": "지원이 완료되었습니다.",
    "data": {
        "supportId": 1,
        "companyName": "구글",
        "companyNation": "미국",
        "companyRegion": "샌프란시스코",
        "position": "백엔드",
        "compensation": 30000,
        "content": "적극적인 뱍앤드 찾고 있습니다.",
        "languageUsed": "python",
        "createdAt": "2024-08-06 00:40:40"
    }
}

//중복 지원 시
{
    "status": "ERROR",
    "message": "이미 지원한 채용공고 입니다.",
    "data": null
}
```
