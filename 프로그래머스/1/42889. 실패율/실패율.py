def solution(N, stages):
    answer = []

    #낮은 stage부터 수를 세고, 다음 stage수를 셀 때는 전에 센 낮은 stage수를 빼면된다. 더 높은 stage에 도달하지 못했으므로
    length = len(stages)
    for i in range(1, N+1):
        count = stages.count(i)
        
        if length == 0:
            fail = 0
        else:
            fail = count/length
            
        answer.append((i, fail))
        length -= count
        
    
    answer.sort(key=lambda x: (-x[1], x[0]))
    answer = [i[0] for i in answer]
    return answer