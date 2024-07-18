def rotation(key):
    m = len(key)
    result = [[0 for _ in range(m)] for _ in range(m)]
    for i in range(m):
        for k in range(m):
            result[i][m-1-k] = key[k][i]

    return result

#열쇠 중간 부분이 1인지 확인하면 됨
def check(new_lock):
    lock_length = len(new_lock)//3 #new_lock이 lock의 3뱅므로 원래 lock의 길이는 //3
    for i in range(lock_length, lock_length*2):
        for k in range(lock_length, lock_length*2):
            if new_lock[i][k] != 1:
                return False
    return True #가운데 lock이 모두 1인 경우

def solution(key, lock):
#열쇠 돌리는 함수 필요
# 상하좌우로 움직일때마다 360도 회전하면서 열쇠 맞춰보기
    
    answer = False
    n = len(lock)
    m = len(key)
    new_lock = [[1 for _ in range(n*3)] for _ in range(n*3)]
    #새로운 자물쇠에 기존 자물쇠 끼우기
    for i in range(n):
        for k in range(n):
            new_lock[n+i][n+k] = lock[i][k]
    
    for j in range(4):
        key = rotation(key)
    #80000 * 4000 = 320000000
        for i in range(n*2):
            for k in range(n*2):
                #new_lock에 key를 상하좌우 움직이면서 lock의 모든 요소가 1이면 true반환
                #열쇠에 자물쇠 끼워넣기에서 막힘
                for x in range(m):
                    for y in range(m):
                        new_lock[i+x][k+y] += key[x][y]
                if check(new_lock):
                    return True
                else: #자물쇠에서 열쇠 빼기
                    for x in range(m):
                        for y in range(m):
                            new_lock[i+x][k+y] -= key[x][y]     
                
    return answer
