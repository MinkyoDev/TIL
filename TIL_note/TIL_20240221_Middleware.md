# TIL 20240221

24년 02월 21일 TIL(Today I Learned)

## 1. Middleware

>Spring에서는 Intercepter, Filter와 같은 중간 처리 방법이 있다면, Flask에서는 App Context 중 after_request나 before_request 등의 콜백 함수로 받아 처리하는 등의 방법을 사용한다.

FastAPI에서는 Middleware 패턴을 가지고 있다. Middleware 패턴은 API 호출 전후를 중심으로 하나의 콜백 함수가 실행되고 난 뒤, API Router로 요청을 넘기는 패턴이다.
```
+--------+
|        |       +------------+       +------------+
| Client | <---> | Middleware | <---> | API Router |
|        |       +------------+       +------------+
+--------+
```

### 1) BaseHTTPMiddleware
```python
import time
from fastapi import Request
from starlette.middleware.base import BaseHTTPMiddleware
from starlette.responses import Response


class TimeHeaderMiddleware(BaseHTTPMiddleware):
    async def dispatch(self, request: Request, call_next) -> Response:
        ...
```

- FastAPI에서 제공하는 Middleware 패턴은 `BaseHTTPMiddleware`를 상속한 클래스들로 동작한다. 이 클래스는 클라이언트로부터 요청이 오면 그 요청을 받은 뒤 `dispatch` 함수를 호출하는데, 우리는 이 dispatch 함수에서 중간 처리를 진행할 수 있다.

### 2) Middleware example
```python
from fastapi import FastAPI
from starlette.middleware.base import BaseHTTPMiddleware
from starlette.requests import Request

class CustomLoggingMiddleware(BaseHTTPMiddleware):
    async def dispatch(self, request: Request, call_next):
        # 요청 처리 전 로깅
        print(f"Request path: {request.url.path}")

        # 실제 요청 처리
        response = await call_next(request)

        # 응답 처리 전 로깅
        print(f"Response status: {response.status_code}")

        return response

app = FastAPI()

# 미들웨어 등록
app.add_middleware(CustomLoggingMiddleware)

@app.get("/")
async def main():
    return {"message": "Hello World"}
```


### 3) RequireJSON

클라이언트가 PUT, PATCH, POST 메소드를 호출했을 때 JSON 형태의 데이터만을 받도록 할 때도 미들웨어를 이용한다면 간단히 처리할 수 있다.
```python
from fastapi import Request
from fastapi.responses import PlainTextResponse, ORJSONResponse
from starlette.middleware.base import BaseHTTPMiddleware
from starlette.responses import Response


class RequireJSON(BaseHTTPMiddleware):
    async def dispatch(self, request: Request, call_next) -> Response:
        if request.method in ('POST', 'PUT', 'PATCH'):
            if request.headers.get('content-type') != 'application/json':
                return PlainTextResponse(status_code=415)
        return await call_next(request)
```

- `request`의 정보 중에서 클라이언트가 요청한 메소드를 가져와 메소드를 확인하고, `Header`의 `content-type`이 `application/json`인지 확인해준다. 만약 `application/json`이 아니라면 415 상태를 반환해주고, 맞다면 요청을 `EndPoint`에 넘겨주면 간단히 구현할 수 있다.

## 참고자료

- [[FastAPI] 10. Middleware를 이용한 전후 처리](https://blog.neonkid.xyz/271)
- [FastAPI docs - Middleware](https://fastapi.tiangolo.com/ko/tutorial/middleware/)