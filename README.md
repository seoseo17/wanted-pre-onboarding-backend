# wanted-pre-onboarding-backend
# Stacks
- java 17
- mysql 8.0
- springboot 3.3.2
# DB 구조
<img width="722" alt="image" src="https://github.com/user-attachments/assets/3db264be-4cb1-4d63-8150-9bc5493cb649">


# API
## 채용공고 등록
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
