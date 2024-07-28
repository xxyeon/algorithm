

def solution(queue1, queue2):
    answer = -2
    #300000 * 300000
    lst = [0] * 300000
    cnt = 0
    min_cnt = 1e10
    total_sum = sum(queue1) + sum(queue2)
    #각 큐의 합을 구한후 total_sum/2가 되려면 어느 수를 빼야하는지...
    sum_q1 = sum(queue1)
    sum_q2 = sum(queue2)
    need_q1 = total_sum//2 - sum_q1
    q1_sum = sum(queue1)
    need_q2 = total_sum//2 - sum_q2
    q1_idx = 0
    
#     while True:
#         if len(queue2) > 0:
#             # queue1.append(queue2.pop(0))
#             total_sum += queue2.pop(0)
#             cnt += 1
        
#         if total_sum//2 == sum(queue1):
#             answer = cnt
#             break
#         elif total_sum//2 < sum(queue1):
#             n = queue1.pop(0)
#             total_sum -= n
#             cnt += 1
#         elif total_sum//2 > sum(queue1):
#             continue
            
    print("total_sum:", total_sum//2)
    for i in range(len(queue2) * 2):
        if len(queue1) == 0 and lst[i-1] == 0: #이전에 값을 넣은게 없고 queue1이 empty라면
            answer = -1
            break
        if total_sum//2 > q1_sum:
            if len(queue2) > 0:
                # queue1.append(queue2.pop(0))
                q2 = queue2.pop(0)
                q1_sum += q2
                cnt += 1
                print(q1_sum)
                print("queue2.pop(0): ", q2)

        elif total_sum//2 < q1_sum:
            n = queue1.pop(0)
            lst[i] = n
            q1_sum -= n
            cnt += 1
            print(q1_sum)
        elif total_sum//2 == q1_sum:
            answer = cnt
    
            
            
                            
    return answer