# TIL 20240115

## React 설치

### React 설치 시 나온 오류 정리

**1. Error**
```
npx create-react-app study
```

```
npm ERR! code ENOENT
npm ERR! syscall lstat
npm ERR! path C:\Users\Yeonsik\AppData\Roaming\npm
npm ERR! enoent ENOENT: no such file or directory, lstat 'C:\Users\Yeonsik\AppData\Roaming\npm'
npm ERR! enoent 

npm ERR! A complete log of this run can be found in: C:\Users\Yeonsik\AppData\Local\npm-cache\_logs\2024-01-15T06_56_07_201Z-debug-0.log
```

**2. 해결방법 1**
```
npm cache clean --force
```

```
npm WARN using --force Recommended protections disabled.
npm ERR! code ENOTEMPTY
npm ERR! syscall rmdir
npm ERR! errno -4051

npm ERR! A complete log of this run can be found in: C:\Users\Yeonsik\AppData\Local\npm-cache\_logs\2024-01-15T06_57_52_330Z-debug-0.log
```

```
npm install --cache
```

```
npm WARN invalid config Must be valid filesystem path
npm ERR! code ENOENT
npm ERR! syscall open
npm ERR! path C:\workspace\study\react/package.json
npm ERR! errno -4058
npm ERR! enoent ENOENT: no such file or directory, open 'C:\workspace\study\react\package.json'
npm ERR! enoent This is related to npm not being able to find a file.
npm ERR! enoent
```

node를 재설치 하여도 같은 오류가 반복

**3. 해결방법 2**
```
npm install -g npm@latest
```

분명 node를 최신버전으로 받았으나 위 방식으로 해결하였음

http://yellow.kr/blog/?p=5884


### React 설치

```
npx create-react-app [프로젝트명]
```

## React 기초 문법

#### 문법 1 : className

클래스를 넣을 때는 기존 html 문법과 다르게 className으로 넣는다.
```jsx
<div className="App">
```

#### 문법 2 : {}를 사용해서 html에 변수 꽂아 넣기

변수를 선언하고
```jsx
let post = '강남 우동 맛집';
```

중괄호 안에 넣어서 html에 변수를 넣을 수 있다.
```jsx
<h4>{ post }</h4>
```

id나 태그 값에도 똑같이 사용이 가능하다.
```jsx
<h4 id={ post } }>블로그임</h4>
```

상상하는 거의 모든 곳에 사용 가능하고 함

#### 문법 3 : style 넣는 방법

스타일을 넣을 때는 이렇게
```jsx
<h4 style={ {color: 'red', fontsize: '16px'} }>블로그임</h4>
```

#### 문법 4 : return 안에는 하나의 소괄호만 있어야 함

올바른 방법
```jsx
return (
	<div className="App"></div>
	);
```

잘못된 방법
```jsx
return (
	<div className="App"></div>
	<div></div>
	);
```

#### 문법 5 : state 사용법

자료를 잠깐 저장할 때는 변수에 저장해도 되지만 state를 써도 됨

state import
```jsx
import { userState } from 'react';
```

use
```jsx
let [a, b] = userState('남자 코트 추천');
```

```jsx
a = '남자 코트 추천'
```

**state 사용 이유**
```jsx
let post = '강남 우동 맛집';

<h4>{ post }</h4>
```
변수는 변수 값이 바뀌면 html을 재 렌더링 해야 함

```jsx
let [글제목, b] = userState('남자 코트 추천');

<h4>{ 글제목 }</h4>
```
하지만 state는 html이 자동 재 렌더링 됨

```
자주 변경될거 같은 html 부분은 state로 만들어 놓기
```
##### 참고 : Destructuring

기존
```jsx
let num = [1, 2];
let a = num[0];
let b = num[1];
```

Destructuring
```jsx
let [a, b] = [1, 2];
```

따라서 
```jsx
let a = userState('남자 코트 추천');

a = ['남자 코트 추천', 함수]
```

##### 참고 : Warning message 없에기

코드 맨 위에
```jsx
/* eslint-disable */
```


#### 문법 6 : event handler

**onClick**
```jsx
<h4>{ 글제목[0] } <span onClick={ 함수 }>👍</span> { 따봉 } </h4>
```
항상 event handler 안에는 함수를 넣어야 함

틀린 예시
```jsx
<h4>{ 글제목[0] } <span onClick={ console.log(1) }>👍</span> { 따봉 } </h4>
```

이렇게는 가능
```jsx
<h4>{ 글제목[0] } <span onClick={ function(){ console.log(1) } }>👍</span> { 따봉 } </h4>
```
또는
```jsx
<h4>{ 글제목[0] } <span onClick={ () => { console.log(1) } }>👍</span> { 따봉 } </h4>
```
()=>{} 또한 함수 만드는 문법임

#### 문법 7 : state 변경법

state는 =를 써서 변경하면 반영이 잘 안됨
```jsx
() => { 따봉 = 따봉 + 1 }
```

state 변경 함수를 사용하는 것을 권장 
```jsx
let [따봉, 따봉변경] = useState(0);
```

```jsx
<h4>{ 글제목[0] }<span onClick={ () => { 따봉변경(1) } }>👍</span> { 따봉 } </h4>
```
하면 따봉이 1로 바뀜


#### 문법 7 : state 함수 동작 원리

아래 방식으로 변경하려고 한다면 재 렌더링이 작동하지 않음
```jsx
<button onClick={()=>{
        글제목[0] = '여자 코트 추천';
        글제목변경(글제목);
        }}>글수정</button>
```

state 변경함수 특징
```
기존state == 신규state 의 경우 변경 안해줌
```
array / object 특징
```jsx
let arr = [1,2,3];
```
arr에 [1,2,3]을 넣는게 아니라 [1,2,3]을 가리키는 값이 들어감

따라서 '글제목'이 변경된 것이 아니라 '여자 코트 추천'으로 바뀐 것이므로 반영이 안됨
```jsx
글제목[0] = '여자 코트 추천';
글제목변경(글제목);
```

물론 이것도 반연 안됨. 위치 값은 똑같으니까
```jsx
<button onClick={()=>{
        let copy = 글제목;
        copy[0] = '여자 코트 추천';
        글제목변경(copy);
        }}>글수정</button>
```

변경법
```jsx
<button onClick={()=>{
        let copy = [...글제목];
        copy[0] = '여자 코트 추천';
        글제목변경(copy);
        }}>글수정</button>
```
...을 넣으면 []괄호는 풀어주고 다시 괄호로 감싸면 완전히 새로운 변수로 만들어짐
약간 파이썬의 [:] 이거랑 비슷하다고 느껴짐

기존 state가 문자나 숫자면 상관이 없는데 **array / object면 독립적인 카피본을 만들어서 수정해야 함**

더 공부하고 싶다면 reference data type을 찾아보길