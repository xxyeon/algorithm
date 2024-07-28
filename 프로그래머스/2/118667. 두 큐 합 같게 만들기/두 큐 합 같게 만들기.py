from collections import deque

def solution(queue1, queue2):
    total_sum = sum(queue1) + sum(queue2)
    
    # 총 합이 홀수이면 동일하게 나누는 것이 불가능함
    if total_sum % 2 != 0:
        return -1
    
    target_sum = total_sum // 2
    
    # 큐를 deque로 변환
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    
    sum_q1 = sum(queue1)
    
    # 최대 연산 횟수 설정
    max_operations = len(queue1) + len(queue2) * 2
    i = 0
    q1_index = 0
    q2_index = 0

    while i < max_operations:
        if sum_q1 == target_sum:
            return i
        elif sum_q1 > target_sum:
            if q1_index < len(queue1) + len(queue2):  # queue1이 비어있지 않은 경우에만 수행
                n = queue1.popleft()
                sum_q1 -= n
                queue2.append(n)
            else:
                return -1
        else:
            if q2_index < len(queue1) + len(queue2):  # queue2가 비어있지 않은 경우에만 수행
                n = queue2.popleft()
                sum_q1 += n
                queue1.append(n)
            else:
                return -1
        i += 1
    
    return -1

