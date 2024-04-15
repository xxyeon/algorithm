import sys

s_avg = {"A+":4.5, "A0": 4.0, "B+": 3.5, "B0":3.0, "C+":2.5, "C0":2.0, "D+":1.5, "D0":1.0, "F":0.0}

sum = 0
s_sum = 0
for _ in range(20):
  t, s, a = sys.stdin.readline().split()
  if (a == "P"):
    continue
  s_sum += float(s)
  for key in list(s_avg.keys()):
    if key == a:
      sum += s_avg[key] * float(s)
      
print("%0.4f" %(sum/s_sum))