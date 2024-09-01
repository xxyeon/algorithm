import heapq

def solution(book_time):
    answer = 0
    for i in range(len(book_time)):
        #시간은 60
        start_h, start_m = book_time[i][0].split(":")
        end_h, end_m = book_time[i][1].split(":")
        
        book_time[i] = [int(start_h)*60 + int(start_m), int(end_h)*60 + int(end_m)]
    
    book_time.sort()
    
    room = [] #배정 받은 객실의 시작시간, 끝나는 시간
    # heapq.heappush(room, book_time[0][1]+10) #끝나는 시간, 방번호
    print(book_time)
    for i in range(len(book_time)):
        start, end = book_time[i]
        p = False
      
        if len(room) != 0 and room[0] <= start: #방을 새로 잡을 필요가 없음, 끝나는 시간 업데이트
            heapq.heappop(room)
            
            
            
        
        else:
            
            answer += 1
        heapq.heappush(room, end+10)
        # print(room)
    
    return answer