n = int(input())
card = []
for i in range(1, n+1):
  card.append(i)
dis_card = []

while len(card) > 1:
  dis_card.append(card[0])
  del card[0]
  card.append(card[0])
  del card[0]
dis_card.append(card[0])
print(*(dis_card))