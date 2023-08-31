## 스택
- 선입후출 (FILO)
<br>

## 큐
- 선입선출 (FIFO)
```python
from collections import deque
queue = deque()
queue.append(5)
queue.popleft()
print(queue) # 먼저 들어온 순서대로 출력
```
<br>

## 재귀함수
스택 자료구조를 활용해야 하는 상당수 알고리즘은 재귀함수를 이용해서 간편하게 구현될 수 있다. 
- DFS가 대표적이다
