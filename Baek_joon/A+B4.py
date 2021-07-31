# 백준 10951번 A+B -4
result = []
while True:
    # try except 구문을 이용
    try:
        A, B = map(int, input().split())
        result.append(A + B)
    except:
        break

for r in result:
    print(r)