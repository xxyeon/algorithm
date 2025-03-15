import heapq
def solution(genres, plays):
    answer = []
    dict_genre = {}
    for i, (genre, play) in enumerate(zip(genres, plays)):
        if genre not in dict_genre:
            dict_genre[genre] = []
        heapq.heappush(dict_genre[genre], (-play, i))  # (음수 재생수, 인덱스) 저장
        
    # keys = sorted(dict_genre, key = lambda x : -sum(dict_genre[x]), reverse=True)
    
    
    # 2. 장르별 총 재생수 기준 정렬
    keys = sorted(dict_genre.keys(), key=lambda x: sum(-play for play, _ in dict_genre[x]), reverse=True)
    for genre in keys:
        if len(dict_genre[genre]) >= 2:
            top_songs = []
            top_songs.append(heapq.heappop(dict_genre[genre]))
            top_songs.append(heapq.heappop(dict_genre[genre]))
            for song, i in top_songs:
                answer.append(i)
        elif len(dict_genre[genre]) == 1:
            answer.append(dict_genre[genre][0][1])
            
    return answer