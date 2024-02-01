# Algorithm 20240201 (Ceil)

24년 02월 01일 Algorithm review

## 1. Ceil

파이썬에서 올림은 기본 함수에 들어있지 않다. 따라서 필요에 따라 다른 모듈을 불러오거나 직접 만들 필요가 있다. 

### 1) math.ceil

math 모델을 사용하면 간단하게 올림을 할 수 있다.

```python
import math  
math.ceil(1.0) # 1  
math.ceil(1.1) # 2  
math.ceil(1.5) # 2  
math.ceil(2.1) # 3  
math.ceil(-3.2) # -3
```

### 2) custom_ceil

math 모델을 사용하지 않고 올림 기능을 구현하려면 다음과 같은 함수를 만들면 된다.

```python
def custom_ceil(number):
    integer_part = int(number)
    if number > 0 and number != integer_part:
        return integer_part + 1
    return integer_part

# 예시 사용
print(custom_ceil(3.2))  # 4
print(custom_ceil(-2.3)) # -2
```

### 2) negate_ceil

연산자 `//`은 항상 결과를 내림하여 반환한다. 따라서 입력 숫자를 음수로 바꾸고 `//` 연산자를 사용하면 올림을 할 수 있다.

```python
-(-8//3)
#> 3
```

```python
def negate_ceil(number): 
	integer_part = -(-number // 1) 
	return integer_part 
	
# 예시 사용 
print(negate_ceil(3.2)) # 4 
print(negate_ceil(-2.3)) # -2
```

## 2. \[level 2] 기능개발

- **[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42586)**
- **[github 풀이](https://github.com/MinkyoJeong1/Programers/tree/cbc0611cbc9bb99f52b376bbde0855c05d2ed5c9/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4/2/42586.%E2%80%85%EA%B8%B0%EB%8A%A5%EA%B0%9C%EB%B0%9C)**


## 참고자료

- [[python] 파이썬 올림, 내림 함수 (ceil, floor)](https://blockdmask.tistory.com/524)