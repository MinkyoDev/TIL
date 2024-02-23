# Algorithm 20240206 Heap

24년 02월 06일 Algorithm review

## 1. Heap sort

힙 정렬은 시간 복잡도가 `O(NlogN)`인 정렬으로, 버블 / 선택 / 삽입 정렬에 비해 우수한 성능을 가지고 있다.

heap은 완전 이진트리의 일종으로, 여러 값들 중에서 최솟값 혹은 최댓값을 빠르게 찾기 위해 설계된 자료구조이다.
heap은 느슨한 정렬 상태(반 정렬 상태)를 유지하고, 이를 쉽게 풀이하면 부모 노드의 키 값이 자식 노드의 키 값보다 항상 큰거나 작은 이진트리를 말한다.
- **완전 이진트리** : 마지막 레벨을 제외한 모든 레벨이 채워지고 마지막 레벨만 좌-> 우 구조

부모 노드의 키 값이 자식 노드의 키 값보다 큰 지, 작은 지에 따라 힙의 종류가 나뉜다.
- **최대 힙(Max Heap)** : 부모 노드의 키 값이 자식 노드의 키 값보다 큰 힙 -> 루트노드에 가장 큰 원소가 위치하게 된다.
- **최소 힙(Min Heap)** : 부모 노드의 키 값이 자식 노드의 키 값보다 작은 힙 -> 루트노드에 가장 작 원소가 위치하게 된다.

힙 정렬의 알고리즘을 단순하게 나타내면 다음과 같다.
```
1. 최대 힙 구성(0번 인덱스가 최댓값)
2. 최댓값을 배열 맨 마지막에 놓는다
3. 새로운 루트 노드에 대해 최대 힙 수행
4. 2~3 반
```

#### 직접 구현

```python
import random

def heapify(arr, arr_len):
    """배열 arr을 인덱스 0부터 인덱스 (arr_len -1) 사이를 최대 힙으로 재구성한다."""
    last_parent = arr_len // 2 - 1
    for current in range(last_parent, -1, -1):
        while current <= last_parent:
            child = current * 2 + 1
            sibling = child + 1
            if sibling < arr_len and arr[child] < arr[sibling]:
                child = sibling
            if arr[current] < arr[child]:
                arr[current], arr[child] = arr[child], arr[current]
                current = child
            else:
                break
  
def heap_sort(arr):
    """배열 arr을 오름차순으로 힙 정렬하다."""
    for arr_len in range(len(arr), 1, -1):
        print(arr)
        heapify(arr, arr_len)
        arr[arr_len - 1], arr[0] = arr[0], arr[arr_len - 1]
        print("------------------------------")
  

# arr = [random.randint(1, 50) for _ in range(10)]
arr = [1, 23, 28, 34, 10, 16, 23, 2, 18, 11]
print(f"정렬 전:\n{arr}")
heap_sort(arr)
print(f"정렬 후:\n{arr}")
```

## 2. heapq 모듈

heapq 모듈은 이진 트리(binary tree) 기반의 최소 힙(min heap) 자료구조를 제공한다.

```
     1  ---> root
   /   \
  3     5
 / \   /
4   8 7
```

### 1) heap에 원소 추가
```python
from heapq import heappush

heappush(heap, 4)
heappush(heap, 1)
heappush(heap, 7)
heappush(heap, 3)
print(heap)

#> [1, 3, 7, 4]
```

### 2) heap에 원소 삭제
```python
from heapq import heappop

print(heappop(heap))
print(heap)

#> 1
#> [3, 4, 7]
```

### 3) 최소값 삭제하지 않고 얻기
```python
print(heap[0])

#> 4
```

### 4) 기존 리스트를 힙으로 변환
```python
from heapq import heapify

heap = [4, 1, 7, 3, 8, 5]
heapify(heap)
print(heap)

#> [1, 3, 5, 4, 8, 7]
```

`heapify()` 함수의 성능은 인자로 넘기는 리스트의 원소수에 비례한다. 즉 `O(n)`의 시간 복잡도를 가진다.

`heapify()` 함수를 사용할 때 주의할 점은 새로운 리스트를 반환하는 것이 아니라 인자로 넘긴 리스트에 직접 변경한다는 것이다. 따라서 원본 리스트의 형태를 보존해야되는 경우에는 반드시 해당 리스트를 복제한 후에 인자로 넘겨야 할 것이다.

```python
nums = [4, 1, 7, 3, 8, 5]

heap = nums[:]
heapify(heap)

print(nums)
print(heap)

#> [4, 1, 7, 3, 8, 5]
#> [1, 3, 5, 4, 8, 7]
```

### 5) \[응용] 최대 힙
`heapq` 모듈은 최소 힙(min heap)을 기능만을 동작하기 때문에 최대 힙(max heap)으로 활용하려면 약간의 요령이 필요하다. 바로 힙에 튜플(tuple)를 원소로 추가하거나 삭제하면, 튜플 내에서 맨 앞에 있는 값을 기준으로 최소 힙이 구성되는 원리를 이용하는 것이다.

따라서, 최대 힙을 만들려면 각 값에 대한 우선 순위를 구한 후, `(우선 순위, 값)` 구조의 튜플(tuple)을 힙에 추가하거나 삭제하면 된다. 그리고 힙에서 값을 읽어올 때는 각 튜플에서 인덱스 1에 있는 값을 취하면 된다. (우선 순위에는 관심이 없으므로)

```python
from heapq import heappush, heappop

nums = [4, 1, 7, 3, 8, 5]
heap = []

for num in nums:
  heappush(heap, (-num, num))  # (우선 순위, 값)

while heap:
  print(heappop(heap)[1])  # index 1

#> 8
#> 7
#> 5
#> 4
#> 3
#> 1
```

### 6) \[응용] n번째 최소값/최대값
최소 힙이나 최대 힙을 사용하면 `n` 번째로 작은 값이나 `n` 번째로 큰 값을 효과적으로 구할 수 있다.

`n` 번째 최소값을 구하기 위해서는 주어진 배열로 힙을 만든 후, `heappop()` 함수를 `n` 번 호출하면 된다.

```python
from heapq import heappush, heappop

def nth_smallest(nums, n):
    heap = []
    for num in nums:
        heappush(heap, num)

    nth_min = None
    for _ in range(n):
        nth_min = heappop(heap)

    return nth_min

print(nth_smallest([4, 1, 7, 3, 8, 5], 3))

#> 4
```

물론 `heapify()` 함수를 활용하면 힙을 만들 때 굳이 루프를 돌면서 숫자를 매 번 하나씩 추가해줄 필요가 없다.
```python
from heapq import heapify, heappop

def nth_smallest(nums, n):
    heapify(nums)

    nth_min = None
    for _ in range(n):
        nth_min = heappop(nums)

    return nth_min
```

사실 `heapq` 모듈에 이미 이러한 용도로 사용할 수 있는 `nsmallest()`라는 함수가 존재한다. `nsmallest()` 함수는 주어진 리스트에서 가장 작은 `n`개의 값을 담은 리스트를 반환하는데 그 결과 리스트의 마지막 값이 `n` 번째 작은 값이 된다.
```python
from heapq import nsmallest

nsmallest(3, [4, 1, 7, 3, 8, 5])[-1]
```

반대로 `n` 번째 최대값을 구할 때는 `nlargest()` 함수를 사용하면 된다.
```python
from heapq import nlargest

nlargest(3, [4, 1, 7, 3, 8, 5])[-1]
```

## 3. \[level 2] 더 맵

- **[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42626)**

### Comment

정답은 다음과 같다.
```python
import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    cnt = 0
    
    while scoville[0] < K:
        mix = heapq.heappop(scoville) + (heapq.heappop(scoville) * 2)
        heapq.heappush(scoville, mix)
        
        cnt += 1
        if len(scoville) == 1 and scoville[0] < K:
            return -1
    return cnt
```

처음 문제를 풀었을 때 아래와 같이 `min()`함수를 사용하여 timeout이 나왔다. `min()`, `max()` 함수의 시간 복잡도는 `O(n)`으로 해당 문제에서는 이미 `scoville`이 정렬되어있는 상태임으로 `scoville[0]`을 찾는 것이 더 간단하였다.
```python
min(scoville) < K
```

```python
scoville[0] < K
```



## 참고자료

- [파이썬의 heapq 모듈로 힙 자료구조 사용하기](https://www.daleseo.com/python-heapq/)
- [파이썬 - 정렬 필수 heapq](https://velog.io/@matt2550/%ED%8C%8C%EC%9D%B4%EC%8D%AC-%EC%A0%95%EB%A0%AC-%ED%95%84%EC%88%98-heapq)
- [힙 정렬(heap sort)이란? 힙 정렬 공부하기 - 파이썬 자료구조 공부](https://lsjsj92.tistory.com/472)
- [[python] 힙 정렬(Heap sort) 본문](https://good-potato.tistory.com/50)
- [20-07. 힙 정렬](https://wikidocs.net/219635)
- [[Algorithm] 힙 정렬 (Heap Sort)](https://hoons-dev.tistory.com/8)