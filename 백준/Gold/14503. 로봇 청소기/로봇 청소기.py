direction = [3,2,1,0] #서남동북(시계반대방향
dx = [0, 1, 0, -1] #서남동북 
dy = [-1, 0, 1, 0]
#0123 북동남서
n, m = map(int, input().split())
r, c, d = map(int, input().split())

room = [list(map(int, input().split())) for i in range(n)]

cnt = 0
def clean(x, y):
    global cnt
    global d
    move = False
    if x < 0 or x >= n or y < 0 or y >=m:
        return 

    if room[x][y] == 1: #벽인경우 작동 중지
        return
    if room[x][y] == 0: #청소 안되어 있으면
        room[x][y] = 2
        cnt +=1 
        
    #주변 4칸 청소안되어 있는 곳 있는지 검사
    #현재 방향 기준으로 반대방향으로 90도 회전
    idx = direction.index(d) #현재 방향
    for i in range(1, 5):
        nx = x + dx[(idx + i) % 4] #room[nx][ny] 현재 방향에서 한칸 전진
        ny = y + dy[(idx + i) % 4]
        if room[nx][ny] == 0: #청소 안되어 있는 곳 있다면
            d = direction[(idx+i) % 4] #방향 변경해주고
            move = True
            clean(nx, ny) #반복
            break #반복문을 멈추지 않으면 현재 있는 위치에서 청소 안되어 있는 방향을 다 청소하게 된다.
    #모두 청소되어 있으면
    #후진
    if not move:
        if d==0:
            clean(x+1, y)
        elif d==1:
            clean(x, y-1)
        elif d == 2:
            clean(x-1, y)
        elif d == 3:
            clean(x, y+1)
    
clean(r, c)
print(cnt)