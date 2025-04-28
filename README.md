## 코딩 테스트 리포지토리

- 적어도 하루에 한번씩 백준, 프로그래머스 문제 풀면서 알고리즘, 코테 문제 익숙해지기
- 백준 실버~골드, 프로그래머스 레벨3 문제들 푸는 게 목표
- 2024에는 프로그래머스에 있는 기출 문제 한번씩 다 풀어보기
  - (이코테 책에 있는 기출문제라도 힌트 보지 않고 풀 수 있을 정도의 실력향상이 목표)

## 코테 언어 제한으로 Java로 봐야할 경우가 있음

- [바킹독 알고리즘 문제집](https://github.com/encrypted-def/basic-algo-lecture/blob/master/workbook.md)
  자바로는 아직 자료구조 다루는게 부족 -> 자료구조 사용법부터 익히기

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

### stream 사용해서 int 배열로 변환
```java
 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
```

### ArrayList
`set(idx, value)`: 요소 교체하기

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

### Queue
[LinkedList를 큐로 사용하는 이유](https://mystudylog.tistory.com/199#3.2%20LinkedList%20%ED%81%B4%EB%9E%98%EC%8A%A4-1)

```java
import java.util.Queue;
import java.util.LinkedList;
Queue<T> q = new LinkedList<>();

q.add(value); // 삽입 실패시 exception
q.offer(vaelu); // 삽입 실패시 false

q.remove(); //공백 큐이면 Exception, 반환값: 삭제된 value
q.remove(value); // 삭제하 value 존재하지 않으면 false 반환, 반환값: 해당 값 삭제후 ture

q.poll(); // 공백 큐이면 null 반환, 반환값: 큐에서 값 pop

q.element(); // 반환값: 큐 head에 위치한 value / 공백이면 예외발생
q.peek(); // 반환 값: 위와 동일 / 공백이면 null 반환 -> 큐에 영향 미치지 않음

q.clear();

q.size();
q.contains(value);
q.isEmpty();
```

### Linked List

Deque는 indexOf 메서드가 없어서 불편, 대신 LinkedList 사용 -> Deque 메서드 다 지원해줌
LinkedList는 Deque 인터페이스를 구현하고 있고, List 인터페이스도 구현하고 있다.

### Deque

```java
Deque<T> deque = new ArrayDeque<>();
Deque<T> deque = new LinkedBlockingDeque<>();
Deque<T> deque = new ConcurrentLinkedDeque<>();
Deque<T> linkedList = new LinkedList<>();

deque.addFirst(); //앞쪽에 데이터 삽입, 용량 초과시 예외
deque.offerFirst(); // 앞쪽에 데이터 삽입 후 true, 요량 초과시 false

deque.addLast(); // 뒤쪽에 데이터 삽입, 용량 초과시 예외
deque.add(); //위와 동일

deque.offerLast(); //뒤쪽에 데이터 삽입 후 true, 용량 초과시 false
deque.offer(); // 위와 동일

deque.push(); //addfirst() 와 동일
deque.pop(); // removeFirst() 와 동일

//삭제(삭제된 값 반환))
deque.remove(); //deque의 첫 값 삭제
deque.removeFisrt(); //deque의 첫값 삭제
deque.remoeLast(); //deque의 끝값 삭제, t
deque.poll(); //deque의 첫값 삭제, 삭제된 값 반환, 실패시 null
deque.pollLast(); //deque의 끝 값 삭제, 삭제된값 반환, 실패시 null

```
### Iterator
일련의 데이터 집합에 대해 순차적인 접근을 지원하는 패턴
보통 배열이나 리스트 같은 경우 순서가 연속적인 데이터 집합이기 때문에 간단한 for을 통해 순회 가능
해시, 트리 등 컬렉션은 데이터 저장 순서가 정해지지 않고 적재되므로 각 요소들을 어떤 기준으로 접근해야 할지 애매
단방향으로 순회 가능
컬렉션 객체에서 `.iterator()`로 생성 가능
```java
List<Integer> list = new List<>();
Iterator<Integer> iter = list.iterator();


iter.hasNext(); //iterator에 다음 요소가 있는지
iter.next(); //다음 값 가져오기
iter.remove(); iter.next()로 가져온 값을 컬렉션에서 삭제
```


### ListIterator

LinkedList는 k 번째 인덱스를 저장하고 있지 않아서 add(index), remove(index)를 하게 될 경우 O(N)의 시간 복잡도가 나온다.  
ListIterator는 Iterator를 상속한 인터페이스다. 한마디로 Iterator기능을 다 갖고 더한 기능을 갖고 있다는 소리다.

가장 핵심적으로 Iterator의 위치를 양방향으로 알 수 있는 기능이 있다.  
문제의 커서를 찾기 위해 처음부터 다시 위치를 찾는게 아니라 기존 위치를 기억하고 앞 뒤로 찾을 수 있다는 어마어마한 장점이 있다

```java
LinkedList<T> lst = new LinkedList<>();
ListIterator<T> iter = lst.ListIterator();

iter.hasNext();//다음요소가 존재하는지
iter.next(); //포인터 오른쪽으로 이동
iter.hasPrevious();// 이전 요소가 존재하는지
iter.prevous(); //포인터 왼쪽으로 이동
iter.remove(); //포인터가 가리키는 요소 삭제 후
```

### stream
reduce(초기값(T), reduce에 적용할 함수(T)): 누적합 구하기
reduce는 T타입의 Optional을 반환
```java
long result = 0;
result = card.stream().reduce((x, y) -> x+y).get();
```

