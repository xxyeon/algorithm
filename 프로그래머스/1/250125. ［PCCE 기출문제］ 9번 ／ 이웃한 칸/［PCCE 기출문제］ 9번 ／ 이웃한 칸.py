def solution(board, h, w):
    answer = 0
    n = len(board)
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    
    for i in range(4):
        nh, nw = h+dx[i], w+dy[i]
        if nh < 0 or nh >= n or nw < 0 or nw >= n:
            continue
        if board[h][w] == board[nh][nw]:
            answer += 1
    return answer