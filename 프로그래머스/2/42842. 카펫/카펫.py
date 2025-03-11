def solution(brown, yellow):
    answer = []
    #가로 >= 세로 인 사각형
    #카펫 개수를 통해서 만들어질 수 있는 모든 직사각형을 먼저 구해봐야함
    #가로가 세로보다 같거나 크니까 (w, h) 이렇게 직가각형 길이 유추 해보기
    #가로 길이를 점점 늘리면서 조건이랑 같은지 확인
    # h, w 길이의 테두리에 있는 카펫의 개수는 2(h+w) - 4 -> brown이랑 일치하는지 확인
    carpet = []
    start = 0
    #갈색 카펫의 개수로 직사각형의 테두리 길이 = 2*4 + (brown -4)
    total_length = 2*4 + (brown -4)
    
    harf_length = total_length // 2
    if harf_length % 2 == 0:
        start = harf_length // 2
    else:
        start = harf_length // 2 + 1
    for w in range(start, harf_length): #가로길이 정해보기
        #가로길이 정해졌으면 세로길이도 알 수 있음
        
        h = harf_length - w
        #바깥 직사각형의 길이를 임의로 정했다면 안쪽 직사각형도 임의로 정해짐 -> 주어진 노란색 카펫 개수와 동일한지 비교
        #안쪽 직사각형의 inside_h = 바깥h - 2, inside_w = 바깥w-2
        #노란색 카펫의 개수 = inside_h * inside_w
        inside_h = h -2
        inside_w = w - 2
        expected_yellow = inside_h * inside_w
        print(w, h)
        print(inside_w, inside_h)
        if expected_yellow == yellow:
            answer = [w, h]
            break
    return answer