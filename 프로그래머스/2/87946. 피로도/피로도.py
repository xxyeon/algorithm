from itertools import permutations
def solution(k, dungeons):
    answer = -1
    
    for dungeon in permutations(dungeons, len(dungeons)):
        cnt = 0
        now = k
        for need, t in dungeon:
            
            if now >= need:
                now -= t
                cnt += 1
       
        answer = max(cnt, answer)
           
            
    
    return answer