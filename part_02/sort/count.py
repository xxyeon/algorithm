# 계수 정렬은 데이터의 크기 범위가 제한되어 정수 형태로 표현할 수 있을 때만 사용
# 시간복잡도 O(N+K) (N: 데이터개수, K: 데이터중 최대값의 크기)
# 동일한 값을 가지는 데이터가 여러 개 있을 때 적합

#모든 원소의 값이 0보다 크거나 같다고 가정
array = [7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2]

# 모든 범위를 포함하는 리스트 선언(모든 값 0 으로 초기화)
count = [0] * (max (array) + 1) #리스트의 크기가 가장 큰 데이터 + 1 이여야한다.

for i in range(len(array)):
    count[array[i]] += 1

for i in range(len(count)):
    for j in range(count[i]):
        print(i, end=' ')