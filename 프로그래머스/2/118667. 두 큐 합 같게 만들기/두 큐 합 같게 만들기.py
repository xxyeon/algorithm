from collections import deque

def solution(queue1, queue2):
    answer = -1#-2로 설정하면 for 문에서 첫번째 조건을 만족하지 않으면 -2가 출력되서 실패함 테케 11, 28
  
    #300000 * 300000
    
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    total = sum(queue1) + sum(queue2)
    if total % 2 != 0:
        return -1
    total_div_2 = total // 2
    #각 큐의 합을 구한후 total_sum/2가 되려면 어느 수를 빼야하는지...
    sum_q1 = sum(queue1)

    # while True:
    for i in range(300000): #총 배열의 최대 길이가 300000 while로 하면 테케 3번에 무한 루프..?
        if len(queue2) == 0 or len(queue1) == 0:
            print(queue2, queue1)
            return -1

        elif total_div_2 == sum_q1:
            return i
        elif total_div_2 < sum_q1:
            n = queue1.popleft()
            queue2.append(n)
            sum_q1 -= n
            
        elif total_div_2 > sum_q1:
            n = queue2.popleft()
            queue1.append(n)
            sum_q1 += n
        

    return answer
                            