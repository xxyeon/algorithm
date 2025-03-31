def solution(triangle):
    answer = 0
    
    for row in range(len(triangle)-2, -1, -1):
        for col in range(len(triangle[row])):
            triangle[row][col] = max(triangle[row+1][col], triangle[row+1][col+1]) + triangle[row][col]
    
    return triangle[0][0]