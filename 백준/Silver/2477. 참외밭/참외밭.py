k = int(input())
#https://www.acmicpc.net/board/view/93790 -> indexError
#4->1, 2->1 1->3은 공통으로 작은 사각형
#서, 남쪽에서 시작할때: 3->2 도 작은 사각형
data = []
height = []
width = []
for i in range(6):
    direction, length = map(int, input().split())
    data.append((direction, length))
    if direction == 1 or direction == 2:
        width.append(length)
    else:
        height.append(length)

max_width = max(width)
max_height = max(height)    
big_area = max_width * max_height
h, w = 0, 0
for direction, length in data:
    if (direction == 1 or direction == 2) and length == max_width:
        #가장 긴 가로 길이 인덱스 찾기
        idx = data.index((direction, length))
        h = abs(data[idx-1][1] - data[(idx+1)%6][1])

    elif (direction == 3 or direction == 4) and length == max_height:
        #가장 긴 세로 길이 인덱스 찾기
        idx = data.index((direction, length))
        w = abs(data[idx-1][1] - data[(idx+1)%6][1])

result = (big_area - (w*h)) * k
print(result)