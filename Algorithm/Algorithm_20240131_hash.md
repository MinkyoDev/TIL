# Algorithm 20240131

24년 01월 31일 Algorithm review

## 1. Hash

>임의의 크기를 가진 데이터(Key)를 고정된 크기의 데이터(Value)로 변화시켜 저장하는 것
>
>키에 대한 해시값을 사용하여 값을 저장하고 키-값 쌍의 갯수에 따라 동적으로 크기가 증가하는 associate array 이다.
>
>키에 대한 해시값을 구하는 과정을 hashing(해싱)이라고 하며 이때 사용하는 함수(알고리즘)를 해시함수 라고 한다.
>
>해시값 자체를 index로 사용하기 때문에 평군 시간복잡도가 O(1) 로 매우 빠르다


**파이썬에서는 Dictionary 라는 자료형을 톻해 해쉬를 제공한다.**

### 1) 딕셔너리와 리스트의 시간 복잡도 차이

| Operation | Dictionary | List |
|:---:|:---:|:---:|
| **Get Item** | O(1) | O(1) |
| **Insert Item** | O(1) | O(1)~O(N) |
| **Update Item** | O(1) | O(1) |
| **Delete Item** | O(1) | O(1)~O(N) |
| **Search Item** | O(1) | O(1) |
List에 비해 Dictionary가 시간 복잡도가 훨씬 낮다.
원소를 넣거나 삭제, 찾는 일이 많을 때는 딕셔너리를 사용하는 것이 유리하다.

### 2) Init

```python
my_dict1 = {} # {} 
my_dict2 = dict() # {}
```

### 3) Get

```python
my_dict = {'하이': 300, '헬로': 180, 3: 5}

# [] 기호 사용해 원소 가져오기
my_dict['헬로'] # 180

# get 메소드를 아용해 원소 가져오기
# 딕셔너리에 해당 key가 없을때 Key Error 를 내는 대신, 특정한 값을 가져온다.
my_dict.get('헬로', 0) # 180
my_dict.get('동동', 0) # 0
```

### 4) Set

```python
my_dict = {'김철수': 300, 'Anna': 180} 

# 값 집어넣기 
my_dict['홍길동'] = 100 
my_dict # {'Anna': 180, '김철수': 300, '홍길동': 100}

# 값 수정하기
my_dict['김철수'] = 500 
my_dict # {'Anna': 180, '김철수': 500, '홍길동': 100}

my_dict['김철수'] += 500 
my_dict # {'Anna': 180, '김철수': 800, '홍길동': 100}
```


### 5) Delete

```python
my_dict = {'김철수': 300, 'Anna': 180} 

# del 이용하기
del my_dict['김철수'] 
dict # {'Anna': 180}

del my_dict['홍길동'] 
'''
keyError 발생!
'''

# pop 이용하기
# 키가 없는 경우 대응하는 default 리턴
my_dict.pop('김철수', 180) # 300
my_dict.pop('홍길동', 180) # 180 
```

### 6) Iterate

```python
# key로만 순회 
dict = {'김철수': 300, 'Anna': 180} 
for key in dict: 
	print(key) 
	
'''
김철수
Anna
'''

# key-value 동시 순회 
dict = {'김철수': 300, 'Anna': 180} 
for key, value in dict.items(): 
	print(key, value)

'''
김철수 300
Anna 180
'''
```

### 7) etc

**#1 특정 key가 딕셔너리에 있는지 없는지 조회할 때 - in 사용하기**
```python
dict = {'김철수': 300, 'Anna': 180} 
print("김철수" in dict) #True 
print("김철수" not in dict) # False
```

**#2 key 또는 value만 뽑아내는 방법**
```python
# key를 extract - keys 사용
my_dict = {'김철수': 300, 'Anna': 180} 
my_dict.keys() # dict_keys(['김철수', 'Anna'])

# value를 extract - values 사용
my_dict = {'김철수': 300, 'Anna': 180}
my_dict.values() # dict_values([300, 180])

# key, value 쌍을 extract - items 사용
my_dict = {'김철수': 300, 'Anna': 180} 
my_dict.items() # dict_items([('김철수', 300), ('Anna', 180)])
```



## 2. \[level 1] 완주하지 못한 선수

- **[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42576)**
- **[github 풀이](https://github.com/MinkyoJeong1/Programers/tree/main/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4/1/42576.%E2%80%85%EC%99%84%EC%A3%BC%ED%95%98%EC%A7%80%E2%80%85%EB%AA%BB%ED%95%9C%E2%80%85%EC%84%A0%EC%88%98)**

### Comment

### #1

리스트를 딕셔너리로 만들 때
```python
def make_dict(my_list):
    my_dict = {}
    for my_ in my_list:
        if my_ in my_dict.keys():
            my_dict[my_] += 1
        else:
            my_dict[my_] = 1
    return my_dict
```

collections 모듈의 Counter함수를 사용하면 간편하다.
```python
from collections import Counter

def make_dict(my_list):
    return Counter(my_list)
```

### #2

딕셔너리는 더하거나 빼지 못한다.
```python
a = {"a": 1, "b": 2}
b = {"a": 3, "b": 4}
a + b

#> unsupported operand type(s) for +: 'dict' and 'dict'
```

하지만 Counter객체는 더하거나 뺄 수 있다.
```python
from collections import Counter

a = Counter(a)
b = Counter(b)
a + b

#> Counter({'b': 8, 'a': 6})
```

이런 기능으로 코드를 다음과 같이 변경할 수 있다.
```python
import collections

def solution(participant, completion):
    answer = collections.Counter(participant) - collections.Counter(completion)
    return list(answer.keys())[0]
```


## 참고자료

- [[Python 자료구조] Hash(해시)](https://yunaaaas.tistory.com/46)
- [[자료구조/알고리즘] 해시(Hash) 란?](https://power-overwhelming.tistory.com/42)