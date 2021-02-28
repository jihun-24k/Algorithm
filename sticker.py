# 백준 9465번 스티커
import sys
input = sys.stdin.readline

T = int(input())
test_case = []
for _ in range(T):
    case = []
    N = int(input())
    for _ in range(2):
        case.append(list(map(int,input().split())))
    test_case.append(case)

for case in test_case:
    # 스티커 판별
    width = len(case[0])
    result = 0
    # 이전 인덱스 값
    before = -1

    for i in range(1, width):
        route1 = case[0][i-1] + case[1][i]
        route2 = case[1][i-1] + case[0][i]
        # 이전 인덱스랑 같은 스티커는 빼준다
        if before == 0:
            route1 -= case[0][i-1]
        elif before == 1:
            route2 -= case[1][i-1]

        # 만약 최대값이 같을 때
        if route1 == route2:
            result += route1
            before = -1
            continue
        # 두 루트가 차이가 날 때
        if route1 > route2:
            if i == width -1:
                result += route1
                continue
            result += case[0][i-1]
            before = 0
        else:
            if i == width -1:
                result += route2
                continue   
            result += case[1][i-1]
            before = 1
        print(result)
    print("****")
