## 코딩 테스트 리포지토리
- 적어도 하루에 한번씩 백준, 프로그래머스 문제 풀면서 알고리즘, 코테 문제 익숙해지기
- 백준 실버~골드, 프로그래머스 레벨3 문제들 푸는 게 목표
- 2024에는 프로그래머스에 있는 기출 문제 한번씩 다 풀어보기
  - (이코테 책에 있는 기출문제라도 힌트 보지 않고 풀 수 있을 정도의 실력향상이 목표)
 
## 코테 언어 제한으로 Java로 봐야할 경우가 있음
### InputStream
throws IOException 예외 던져줘야함
```java
BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
```
### StringBuilder
```java
StringBuilder sb = new StringBuilder();
sb.append();
```

### 문자열로 입력받은거 배열로 변환 toCharArray()
```java
BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
char[] arr = bf.readLine().toCharArrary()
```

### split으로 단어 나누기
```java
String str = bf.spli(" ") //공백 기준으로 단어 나누기
```

### 우선순위 큐
```java
import java.util.*;
//최소 우선순위 큐
PriorityQueue<Integer> q = new PriorityQueue<Integer>();
//최대 우선순위 큐
PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());

//compare 오버라이딩 해서 우선순위 결정
PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
            // 양수이면 o1>o2, 음수이면 o1 < o2, 0이면 o1==o2
                //o1> o2:+, o1 <o2 :- o1==o2 절댓값 비교
                if (Math.abs(o1) == Math.abs(o2)){ return o1 > o2 ? 1 : -1;}
                return Math.abs(o1) - Math.abs(o2);
            }
        });
```

### stack
```java
Stack<Integer> stackInt = new Stack<>();
stackInt.push(1);
stackInt.pop();
stackInt.peak(); //스택에서 마지막 요소 반환하는데 스택에 영향을 주지 않음
stackInt.empty(); //비어있으면  ture
stackInt.search(); //메서드의 인자를 스택에서 검색하여 해당 위치 반환, 찾는 값이 없을 경우 -1 반환
```
