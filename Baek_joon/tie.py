n = int(input())

neg = []
pos = []
for _ in range(n):
    m = int(input())
    if m > 0:
        pos.append(m)
    else:
        neg.append(m)

# array를 오름차순으로 정렬
pos.sort(reverse=True)
neg.sort()

result = 0

for i in range(0, len(pos)-1, 2):
    if pos[i+1] == 1:
        result += pos[i] + pos[i+1]
    else:
        result += pos[i] * pos[i+1]

for i in range(0 , len(neg)-1 ,2):
    result += neg[i] * neg[i+1]

if len(pos)%2:
    result += pos[-1]
if len(neg)%2:
    result += neg[-1]

print(result)