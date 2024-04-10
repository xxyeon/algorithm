import sys

month, day = map(int, sys.stdin.readline().split(" "))

total_day = 0
result = ""

lst = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"]
data = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
for i in range(1, month):
  total_day += data[i]
total_day += day
result = lst[total_day%7]
print(result)