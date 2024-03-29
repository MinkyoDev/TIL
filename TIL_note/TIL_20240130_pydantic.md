# TIL 20240130

24년 01월 30일 TIL(Today I Learned)

## 1. Python pydantic


### Python pydantic이란?

pydantic 공식 document에는 다음과 같이 설명되어 있다.

" Data validation and settings management using Python type annotations.
pydantic enforces type hints at runtime, and provides user friendly errors when data is invalid.
Define how data should be in pure, canonical Python; validate it with pydandic. "

pydantic은 기본적으로 유효성 검사를 위해 사용되지만, 정확하게 따지자면 parsing 라이브러리이다. 출력 모델의 자료형이나 제약 조건을 보장하기 위한 수단으로 입력 데이터의 유효성을 검사한다고 볼 수 있다. 결론적으로, 주로 사용되는 API의 I/O뿐 아니라 다양한 함수를 안정적으로 사용하기 위한 도구로 볼 수 있다.

### 1) 기본 사용 방법 (using BaseModel)

```python
from typing import List, Optional, Union
from datetime import datetime

from pydantic import BaseModel

class Movie(BaseModel):
    mid: int
    genre: str
    rate: Union[int, float]  # int와 float 둘 다 가능
    tag: Optional[str] = None  # tag는 str이고 기본 값은 None
    date: Optional[datetime] = None
    some_variable_list: List[int]  # 리스트 값을 가지고 그 값들은 int여야 함
  
tmp_data = {
    "mid": "1",
    "genre": "action",
    "rate": 1.5,
    "tag": None,
    "date": "2024-01-30 16:37:42",
    "some_variable_list": [1, 2]
}

tmp_movie = Movie(**tmp_data)
print(tmp_movie)
```

```
mid=1 genre='action' rate=1.5 tag=None date=datetime.datetime(2024, 1, 30, 16, 37, 42) some_variable_list=[1, 2]
```


### 2) 데이터 범위 설정하기 (using Field)

```python
from typing import List, Optional, Union
from datetime import datetime

from pydantic import BaseModel, Field

class Movie(BaseModel):
    mid: int
    genre: str
    rate: Union[int, float]  # int와 float 둘 다 가능
    tag: Optional[str] = None  # tag는 str이고 기본 값은 None
    date: Optional[datetime] = None
    some_variable_list: List[int] = []  # 리스트 값을 가지고 그 값들은 int여야 함

class User(BaseModel):
    """
    gt : 설정된 값보다 큰
    ge : 설정된 값보다 크거나 같은
    lt : 설정된 값보다 작은
    le : 설정된 값보다 작거나 같은

    min_length : 최소 길이
    max_length : 최대 길이
    """
    uid: int
    name: str = Field(min_length=2, max_length=7)
    age: int = Field(gt=1, le=130)

tmp_movie_data = {
    "mid": "1",
    "genre": "action",
    "rate": 1.5,
    "tag": None,
    "date": "2024-01-30 16:37:42",
} 

tmp_user_data = {
    "uid": "100",
    "name": "isakin",
    "age": "27"
}

tmp_movie = Movie(**tmp_data)
tmp_user = User(**tmp_user_data)
print(tmp_movie.model_dump_json())
print(tmp_user.model_dump_json())
```

### 3) BaseSettings

BaseSettings에는 setting과 관련된 것들을 정의할 수 있다.

```
!pip install pydantic-settings
```

```python
from pydantic import Field
from pydantic_settings import BaseSettings

class DBConfig(BaseSettings):
    db_host: str = Field('127.0.0.1')
    db_port: int = Field(3306)
  
    class Config:
        env_file = ".env_ex"

print(DBConfig().model_dump())
```

**env_ex**
```
db_host=123.123.123.123
db_port=3306123
```

여기서 참고자료랑 바뀐 부분이 있었다.

```python
from pydantic import Field
from pydantic_settings import BaseSettings

class DBConfig(BaseSettings):
    host: str = Field('127.0.0.1', env='db_host')  # env는 이제 작동하지 않는다.
    port: int = Field(3306, alias='db_port')  # db_port의 값을 port에 매칭하기 위해서 alias 사용
  
    class Config:
        env_file = ".env_ex"
  
print(DBConfig().model_dump())
```

### 4) Validator

field_validator를 붙여서 annotation을 붙에서 값을 체크할 수 있다. validator는 pydantic V2에서 부터는 사용되지 않는다.
```python
from pydantic import Field, field_validator
from pydantic_settings import BaseSettings
  
class DBConfig(BaseSettings):
    host: str = Field('127.0.0.1', alias='db_host')
    port: int = Field(3306, alias='db_port')
  
    class Config:
        env_file = ".env_ex"
  
    @field_validator('port')
    def check_port(cls, port_input):
        if port_input not in [3306, 8080]:
            raise ValueError("port error")
        return port_input

print(DBConfig().model_dump())
```

```python
from typing import List, Optional    
from pydantic import BaseModel, validator, ValidationError       

class Person(BaseModel):
    name: str
    age: int

    @validator('name')
    def name_must_english(cls, v):
        assert v.encode().isalpha(), ValueError('Must be english')
        return v

    @validator('age')
    def adult_check(cls, v):
        if v <= 19:
            raise ValueError('This Class is rated R')
        return v

data = {
    'name': '박성진',
    'age': 12,
}
try:
    Person(**data)
except ValidationError as e:
    print(e)
#> 2 validation errors for Person
#> name
#>   Must be english (type=assertion_error)
#> age
#>   This Class is rated R (type=value_error)
```


## 참고자료
---
- [pydantic을 사용하여, 안정성 높이기](https://re-code-cord.tistory.com/entry/pydantic%EC%9D%84-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EB%B0%B1%EC%95%A4%EB%93%9C-%EA%B0%9C%EB%B0%9C%EC%9E%90-%EA%B4%B4%EB%A1%AD%ED%9E%88%EA%B8%B0)
- [Python pydantic이란? Python에서 데이터 검증과 설정을 관리해보자(Feat. FastAPI)](https://lsjsj92.tistory.com/650)
- https://docs.pydantic.dev/latest/concepts/pydantic_settings/