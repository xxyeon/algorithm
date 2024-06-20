#이진 탐색
# sol 1) 재귀함수
def binary_search(array, target, start, end):
  if start > end: #tartget이 array에 없는 경우
    return None
  mid = (start + end) // 2
  if array[mid] == target:
    return mid
  elif array[mid] > target:
    return binary_search(array, start, mid-1)
  elif array[mid] < target:
    return binary_search(array, mid+1, end)

# sol 2) 반복문
def binary_search2(array, target, start, end):
  while start <= end:
    mid = (start + end) // 2
    if array[mid] == target:
      return mid
    elif array[mid] > target:
      end = mid - 1
    elif array[mid] < target:
      start = mid + 1
  return None


