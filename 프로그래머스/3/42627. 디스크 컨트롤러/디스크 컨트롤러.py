import heapq

def solution(jobs):
    answer = 0
    jobs.sort(key=lambda x: x[0])  # 요청 시간이 빠른 순으로 정렬
    heap = []
    current_time, total_time, idx = 0, 0, 0
    count = 0  # 처리한 작업 수

    while count < len(jobs):
        # 현재 시간 이하에서 시작할 수 있는 모든 작업을 힙에 추가
        while idx < len(jobs) and jobs[idx][0] <= current_time:
            heapq.heappush(heap, (jobs[idx][1], jobs[idx][0]))  # (작업 소요시간, 요청 시간)
            idx += 1
        
        if heap:  # 수행할 작업이 있는 경우
            duration, start = heapq.heappop(heap)
            current_time += duration
            total_time += (current_time - start)
            count += 1
        else:  # 힙이 비어 있으면 현재 시간을 다음 작업 요청 시간으로 변경
            current_time = jobs[idx][0]

    return total_time // len(jobs)
